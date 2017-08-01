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
    /**
     * option.title 标题
     * option.msg 正文内容
     * @param option
     */
    alert : function(option){
        var title = option.title?option.title:"alert";
        var msg = option.msg?option.msg:"";
        var alertDiv = $("#alertDiv").find(".modal-title").text(title).end()
            .find(".modal-body").html(msg).end();
        $("#alertDiv").modal('show');
    }
};