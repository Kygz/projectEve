/*
以下为上传页面所用
 */
/**
 * 提交
 *
 */
function submitShipAssembly() {
        var title = $.trim($("#ship_title").val());
        var img = $("#ship_img > .fileupload-preview > img").attr("src");
        var content = $.trim($("#ship_desc").code());
        var ship_scope = $("#ship_scope").val();
        var ship_type = $("#ship_type").val();
        var ship_tag = $("#ship_tag").val();
        var ship_id = $("#ship_id").val();
        var items = $("#c1").val();
        var ship_tag_str = "";

        if( title === ""){
            $message.alert({
                title: "ERROR",
                msg: "<p>请填写标题！</p>"
            });
            return false;
        }
        if(typeof img === "undefined"){
            // $message.alert({
            //     title: "ERROR",
            //     msg: "<p>无图言X,请上传配置图片！</p>"
            // });
            // return false;
            img = "";
        }
        if(content===""){
            $message.alert({
                title: "ERROR",
                msg: "<p>图文并茂更生动！</p>"
            });
            return false;
        }
        if($fileSize.getMb(content.length + img.length) > 1){
            $message.alert({
                title: "ERROR",
                msg: "<p>图文大小请小于200Kb,当前预估大小"+ $fileSize.getSizeFowShow(content.length + img.length) +"</p>"
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
                var tempTag = ship_tag[i];
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
                ship_tag : ship_tag_str,
                ship_name : ship_id,
                items : items
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

/**
 * 从剪贴板中获取装配
 */
function getFromClipBoard(text) {
    text = text.trim();
    if(text !== ""){
        console.log("按行来一通");
        var shipName = "";
        var assemblyName = "";
        var step = 0;
        var c1 = [];
        var isSuccess = true;
        text.split('\n').forEach(function(v, i) {
            console.log(v);
            v = v.replace(/[\n\r]/g,"");
            if(i === 0 && v.startsWith("[") && v.endsWith("]")){
                var nameRow = v.replace(/[\[\]]/g,"");
                var _nameRow = nameRow.split(",");
                if(_nameRow.length === 2 && _nameRow[0].trim() !== ""){
                    var $select = $("select#ship_name option");
                    shipName = _nameRow[0];
                    assemblyName = _nameRow[1];
                    for(var j = 0; j < $select.length; j++){
                        var nowOpt = $($select[j]);
                        if(nowOpt.text() === _nameRow[0].trim()){
                            $('#ship_name').selectpicker('val', nowOpt.val());
                            if(_nameRow[1].trim() !== ""){
                                $("#ship_title").val(_nameRow[1].trim());
                            }
                            break
                        }
                    }
                }
                step = 1;
            }else{
                if(i > 0 && step === 0){
                    isSuccess = false;
                    return;
                }
                if(step === 1 && v !== ""){//标题下一个空行，啥都不干
                    c1.push(v);
                }
            }
        });
        if(isSuccess){
            console.log("载入成功");
            var rowTPL = $("<div class=\"m-0\"><label class=\"t-overflow\"></label></div>");
            var itemList = $("#c1List > .media");
            var itemInput = $("#c1");
            var itemValue = "";
            if(c1.length > 0){
                itemList.find(".m-0").remove();
                itemInput.val("");
                c1.forEach(function(text, i) {
                    itemValue += text + ",";
                    var _row = rowTPL.clone();
                    _row.find("label").text(text);
                    itemList.append(_row);
                });
                itemInput.val(itemValue);
            }
        }
    }
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
                        $("#listBlock").toggleClass("col-md-4",true).toggleClass("col-md-12",false);
                        $("#detailBlock").toggleClass("hidden",false);
                        var $select = $("select#ship_name option");
                        var shipId = tempObj.shipAssembly_ship_id + "";
                        for(var j = 0; j < $select.length; j++){
                            var nowOpt = $($select[j]);
                            if(nowOpt.attr("value") === (shipId)){
                                $('#ship_name').selectpicker('val', nowOpt.val());
                                break
                            }
                        }
                        $("#ship_name").val(tempObj.shipAssembly_ship_id);
                        var items = JSON.parse(tempObj.shipAssembly_equipment);
                        var allItemIds = "";
                        var c1List = items.c1;
                        var c2List = items.c2;
                        var c3List = items.c3;
                        var c4List = items.c4;
                        var c1Clear = true;
                        var c2Clear = true;
                        var c3Clear = true;
                        var c4Clear = true;

                        var $1 = $("<div class=\"media\">\n" +
                            "<div class=\"m-0\"><label class=\"t-overflow\">无</label></div>\n" +
                            "</div>");
                        //c1
                        var $equipmentBlock = $("#equipmentBlock");
                        $equipmentBlock.html($1.clone());
                        for (var c1ListKey in c1List) {
                            var item = c1List[c1ListKey];
                            if(c1Clear){
                                c1Clear = false;
                                $equipmentBlock.html("");
                            }
                            allItemIds += item[0] + ",";
                            var _row = $1.clone();
                            _row.find("label").text(item[1]);
                            _row.appendTo($equipmentBlock);
                        }
                        //c2
                        var $modBlock = $("#modBlock");
                        $modBlock.html($1.clone());
                        for (var c2ListKey in c2List) {
                            var item = c2List[c2ListKey];
                            if(c2Clear){
                                c2Clear = false;
                                $modBlock.html("");
                            }
                            allItemIds += item[0] + ",";
                            var _row = $1.clone();
                            _row.find("label").text(item[1]);
                            _row.appendTo($modBlock);
                        }
                        //c3
                        var $subSystemBlock = $("#subSystemBlock");
                        $subSystemBlock.html($1.clone());
                        for (var c3ListKey in c3List) {
                            var item = c3List[c3ListKey];
                            if(c3Clear){
                                c3Clear = false;
                                $subSystemBlock.html("");
                            }
                            allItemIds += item[0] + ",";
                            var _row = $1.clone();
                            _row.find("label").text(item[1]);
                            _row.appendTo($subSystemBlock);
                        }
                        //c4
                        var $ammunitionAndScriptBlock = $("#ammunitionAndScriptBlock");
                        $ammunitionAndScriptBlock.html($1.clone());
                        for (var c4ListKey in c4List) {
                            var item = c4List[c4ListKey];
                            if(c4Clear){
                                c4Clear = false;
                                $ammunitionAndScriptBlock.html("");
                            }
                            allItemIds += item[0] + ",";
                            var _row = $1.clone();
                            _row.find("label").text(item[1]);
                            _row.appendTo($ammunitionAndScriptBlock);
                        }

                        $("#allItemIds").val(allItemIds);
                    }
                }
                // $listPageFun.getPic(tempObj.shipAssembly_id);
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
                }else{

                }
            },
            error : function (data) {

            }
        });
    },
    searchFun : function () {
        var ids = $("#allItemIds").val();
        console.log(ids);
    }
};