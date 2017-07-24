/**
 * 公用JS Function
 * Created by gavin on 2016/4/27 0027.
 */
function getUUID(){
    return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function (c) {
        var r = Math.random() * 16 | 0, v = c == 'x' ? r : (r & 0x3 | 0x8);
        return v.toString(16);
    });
}

var $message = {
    _defDom : "<div>" +
        "<a id='alert' data-toggle='modal' href='#alertDiv' class='btn btn-sm' style='display: none;'></a>" +
        "<div class='modal fade' id='alertDiv' tabindex='-1' role='dialog' aria-hidden='true' style='display: none;'>" +
        "<div class='modal-dialog'>" +
        "<div class='modal-content'>" +
        "<div class='modal-header'>" +
        "<button type='button' class='close' data-dismiss='modal' aria-hidden='true'>×</button>" +
        "<h4 class='modal-title'></h4>" +
        "</div>" +
        "<div class='modal-body'>" +
        "<p></p>" +
        "</div>" +
        "<div class='modal-footer'>" +
        "<button type='button' class='btn btn-sm'>确定</button>" +
        "<button type='button' class='btn btn-sm' data-dismiss='modal'>确定</button>" +
        "</div>" +
        "</div>" +
        "</div>" +
        "</div>" +
    "</div>",
    /**
     * option.title 标题
     * option.msg 正文内容
     * @param option
     */
    alert : function(option){
        var id = "msgBox_" + getUUID();
        var title = option.title?option.title:"alert";
        var msg = option.msg?option.msg:"";
        var alertDiv = $(this._defDom).find(".modal-title").text(title).end().find(".modal-body").html(msg).end().find(".modal-footer>button:eq(0)").hide().end();
        alertDiv.attr("id",id);
        $("button[data-dismiss='modal']").click();
        $("div[id^='msgBox']").remove();
        $("body").prepend(alertDiv);
        $("#"+id).find("#alert").click();
    }
}