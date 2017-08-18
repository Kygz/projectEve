/*
以下为上传页面所用
 */
/**
 * 提交
 */
function submitShipAssembly() {
        var title = $.trim($("#ship_title").val());
        var img = $("#ship_img > .fileupload-preview > img").attr("src");
        var content = $.trim($("#ship_desc").code());
        var ship_scope = $("#ship_scope").val();
        var ship_type = $("#ship_type").val();
        var ship_tag = $("#ship_tag").val();
        var ship_tag_str = "";

        if( title === ""){
            $message.alert({
                title: "ERROR",
                msg: "<p>请填写标题！</p>"
            });
            return false;
        }
        if(typeof img === "undefined"){
            $message.alert({
                title: "ERROR",
                msg: "<p>无图言X,请上传配置图片！</p>"
            });
            return false;
        }
        if(content===""){
            $message.alert({
                title: "ERROR",
                msg: "<p>图文并茂更生动！</p>"
            });
            return false;
        }

        if(ship_tag === null){
            $message.alert({
                title: "ERROR",
                msg: "<p>请为配置打上标签！</p>"
            });
            return false;
        }else{
            for(var i = 0;i<ship_tag.length;i++){
                var tempTag = ship_tag[0];
                ship_tag_str += tempTag;
                if(i<(ship_tag.length-1)){
                    ship_tag_str += "|";
                }
            }
        }

        $.ajax({
            url: "shipAssembly.do?method=addShipAssembly",
            async: false,
            type: "POST",
            dataType: "json",
            data: {
                title : title,
                img : img,
                content : content,
                ship_scope : ship_scope,
                ship_type : ship_type,
                ship_tag : ship_tag_str
            },
            success: function (data) {
                $message.alert({
                    title: "Insert result",
                    msg: "<p>" + data.msg + "</p>"
                });
            },
            error : function (data) {
                $message.alert({
                    title: "Insert result",
                    msg: "<p>" + "失败!" + "</p>"
                });
            }
        });
}


/*
以下为列表页面所用
 */
var $listPageFun = {
    _DEFICON : ["LEGION.png","LEGION.png","TEAM.png","PERSONAL.png"],
    _DEFROW : "<div class=\"media p-l-5\">" +
    "              <div class=\"pull-left\">" +
    "                <img width=\"55\" src=\"img/profile-pics/1.jpg\" alt=\"\">" +
    "              </div>" +
    "              <div class=\"media-body\">" +
    "                <small >标题</small><br/>" +
    "                <a class=\"t-overflow text-muted\" ></a>" +
    "                <a class=\"t-overflow text-muted\" ></a>" +
    "              </div>" +
    "          </div>",
    createList : function findList(pageNo,condition){
        $.ajax({
            url: "shipAssembly.do?method=queryList",
            async: false,
            type: "POST",
            dataType: "json",
            data: {
                pageNo : pageNo
            },
            success: function (data) {
                var div = $("#leftList");
                var list = data.list;
                $storage.setPropertyByKey("shipAssemblyList",JSON.stringify(list));
                if(list && list.length>0){
                    div.find(">div[id!='pageDiv']").remove();
                    for(var i = 0;i<list.length;i++){
                        $("#pageDiv").before($listPageFun.renderRow(list[i]));
                    }
                }
            },
            error : function (data) {
                $message.alert({
                    title: "Insert result",
                    msg: "<p>" + "失败!" + "</p>"
                });
            }
        });
    },
    renderRow :function (vo) {
        var temp = $(this._DEFROW);
        var titleImg  = "img/shipAssembly/";

        temp.attr("id","row_" + vo.shipAssembly_id)
            .find("img").attr("src",titleImg + this._DEFICON[vo.shipAssembly_scope]).end()
            .find(".media-body").find(" > small").text(vo.shipAssembly_title).end()
            .find("a:eq(0)").text(vo.shipAssembly_creator_name).end()
            .find("a:eq(1)").text(vo.shipAssembly_tag).end().end()
            .click(function () {
                var id = this.getAttribute("id").split("_")[1];
                var listStr = $storage.getPropertyByKey("shipAssemblyList");
                var jsonList = $.parseJSON(listStr);
                for(var i = 0,tempObj = jsonList[i];i<jsonList.length;i++){
                    if(tempObj.shipAssembly_id === id){
                        $("#show_title").val(tempObj.shipAssembly_title);
                        $("#show_scope").val(tempObj.shipAssembly_scope);
                        $("#show_type").val(tempObj.shipAssembly_use_type);
                        $("#show_tag").val(tempObj.shipAssembly_tag.split("|")).trigger("liszt:updated");
                        $("#show_content").html(tempObj.shipAssembly_content);
                    }
                }
                $listPageFun.getPic(tempObj.shipAssembly_id);
                return false;
            });
        return temp;
    },
    getPic : function (id,domId) {
        $.ajax({
            url: "shipAssembly.do?method=getPic",
            async: false,
            type: "POST",
            dataType: "json",
            data: {
                id : id
            },
            success: function (data) {
                if(data.img !== ""|| typeof data.img !== "undefined"){
                    $("#show_img > img").attr("src",data.img);
                }
            },
            error : function (data) {

            }
        });
    }

}
