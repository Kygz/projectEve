/**
 * 公用JS Function
 * Created by gavin on 2016/4/27 0027.
 */

/**
 * 取UUID
 * @returns {string}
 */
function getUUID(){
    return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function (c) {
        var r = Math.random() * 16 | 0, v = c == 'x' ? r : (r & 0x3 | 0x8);
        return v.toString(16);
    });
}

/**
 * 弹窗对象
 * @type {{alert: $message.alert}}
 */
var $message = {
    /**
     * option.title 标题
     * option.msg 正文内容
     * @param option
     */
    alert : function(option){
        var alertDiv;
        if(typeof indexPageParam != 'undefined' || (typeof loginPage != 'undefined' && loginPage === true)){//首页
            alertDiv = $("#alertDiv");
        }else if(parent.indexPageParam){
            alertDiv = parent.$("#alertDiv");
        }
        if(alertDiv){
            var title = option.title?option.title:"alert";
            var msg = option.msg?option.msg:"";
            alertDiv.find(".modal-title").text(title).end()
                .find(".modal-body").html(msg).end();
            alertDiv.modal('show');
        }
    }
};

/**
 * 存取设置数据 存于 sessionStorage
 */
var $storage = {
    /**
     * 初始化 清空sessionStorage
     */
    storage : window.sessionStorage,
    init : function () {
        this.cleanAll();
    },
    getPropertyByKey : function(key){
        var data = this.storage.getItem(key);
        return data;
    },
    setPropertyByKey : function (key,value) {
        var vivian = "";
        if(value!==null && value!=="" && typeof value!=="undefined"){
            vivian = value;
        }
        if(key){
            this.storage.setItem(key,vivian);
        }
    },
    delPropertyByEntityId : function (key) {
        if(key){
            this.storage.removeItem(key);
        }
    },
    setCurrentMember :function (memberStr) {
        this.setPropertyByKey("currentMember",memberStr);
    },
    getCurrentMember :function () {
        var memberStr = this.getPropertyByKey("currentMember");
        return $.parseJSON(memberStr,true);
    }
};

var $fileSize = {
    /**
     * 取科比
     */
    getKb : function (strLength) {
        return strLength/8/1024;
    },
    /**
     * 取你MB
     */
    getMb : function (strLength) {
        return this.getKb(strLength)/1024;
    },
    /**
     * 好看的皮囊
     */
    getSizeFowShow : function (strLength) {
        var mb = this.getMb(strLength);
        if(mb > 0.1){
            return mb + "Mb";
        }else{
            return this.getKb() + "Kb";
        }
    }
};


var htmlEncodeByRegExp = function(str){
    /*1.用正则表达式实现html转码*/
    var s = "";
    if(str.length == 0) return "";
    s = str.replace(/&/g,"&amp;");
    s = s.replace(/</g,"&lt;");
    s = s.replace(/>/g,"&gt;");
    s = s.replace(/ /g,"&nbsp;");
    s = s.replace(/\'/g,"&#39;");
    s = s.replace(/\"/g,"&quot;");
    s = s.replace(/\'/g,"&#039;");
    s = s.replace(/\"/g,"&034;");
    return s;
};
//------------------------------------------------------------
var autoWin = function () {
    var quList = window.sessionStorage.getItem("examQu");
    var map = {};
    try {
        if(quList){
            var _map = JSON.parse(quList);
            map = _map;
        }
    } catch(e){
        console.log("alert!!")
    }
    var i = 0;
    var a = setInterval(function () {
        var xxx = $(".q-title .pre-title").text().replace(/【多选题】|【单选题】/, "");
        if (xxx && xxx.trim() != null) {
            xxx = xxx.trim().substr(xxx.indexOf(".") + 1).replace(/["',\s]/g, "_");
            if (map[xxx]) {
                var list = map[xxx];
                $.each($(".choice-group > li div.ng-binding"), function (v, i) {
                    var optText = $(this).text().substr(2);
                    if(list.indexOf(optText) > -1){
                        $(this).prev().click();
                    }
                    list.push($(this).text().substr(2));
                });
                map[xxx] = list;
            }else{
                $(".choice-group > li div.ng-binding:eq(0)").prev().click();
            }
        }
        i++;
        if (i > 50) {
            clearInterval(a);
            console.log(map);
        } else {
            $(".next-btn").click();
        }
    }, 400);
};

