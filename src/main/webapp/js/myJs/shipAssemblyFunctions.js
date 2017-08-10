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