<%@taglib prefix="planet" uri="/planetTaglib" %>
<%@taglib prefix="eve" uri="/indexTaglib" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<!--[if IE 9 ]><html class="ie9"><![endif]-->
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0"/>
    <meta name="format-detection" content="telephone=no">
    <meta charset="UTF-8">

    <meta name="description" content="Violate Responsive Admin Template">
    <meta name="keywords" content="Super Admin, Admin, Template, Bootstrap">

    <title>米氏非正常人类集散地</title>

    <!-- CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/animate.min.css" rel="stylesheet">
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/form.css" rel="stylesheet">
    <link href="css/calendar.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <link href="css/icons.css" rel="stylesheet">
    <link href="css/generics.css" rel="stylesheet">
    <style>
        .cursor-hand{
            cursor: pointer;
        }
        .select .form-control{
            height: 30px;
        }
        span.icon.transBtn {
            font-size: 16px;
            position: absolute;
            right: 5px;
            top: 5px;
        }
        #titleCol{ transition: width ease-in 0.3s}
        .listview .counts.color-green{
            color: #5cb85c;
        }
        .listview .counts.color-red{
            color: #d9534f;
        }
    </style>
</head>
<body style="background: none">
<section id="content" class="container" style="margin-left: 0">
    <%--    <h4 class="page-title">日程活动</h4>--%>
    <div class="block-area">
        <button class="btn m-r-5" id="addSection">新增栏目</button>
    </div>
    <div class="block-area">
        <h3 class="block-title">栏目价格取自国服市场中心，最高收购价，每30分钟更新一次</h3>
        <div class="row">
            <c:forEach items="${sections}" var="sectionObj">
                <c:set var="sectionId" value="${sectionObj.id}"/>
                <c:set var="sectionName" value="${sectionObj.titleName}"/>
                <c:set var="itemList" value="${sectionObj.showList}"/>
            <div class="col-md-4">
                <input type="hidden" id="">
                <div class="tile">
                    <h2 class="tile-title">${sectionName}</h2>
                    <div class="tile-config dropdown">
                        <a data-toggle="dropdown" href="" class="tooltips tile-menu" title="" data-original-title="Options"></a>
                        <ul class="dropdown-menu pull-right text-right">
<%--                                <li><a href="javascript:void(0);" onclick="sectionRefresh('${sectionId}')">Refresh</a></li>--%>
                            <li><a href="javascript:void(0);"  onclick="deleteSection('${sectionId}')">删除栏目</a></li>
                        </ul>
                    </div>
                    <div class="listview narrow">
                        <c:forEach items="${itemList}" var="itemObj">
                            <c:set var="itemId" value="${itemObj.id}"/>
                            <c:set var="itemName" value="${itemObj.name}"/>
                            <c:set var="itemPrice" value="${itemObj.price}"/>
                            <c:set var="itemCompare" value="${itemObj.compare}"/>
                        <div class="media">
                            <div class="pull-right">
                                <c:if test="${'1' eq itemCompare }">
                                    <div class="counts color-red">${itemPrice}&nbsp;ISK</div>
                                </c:if>
                                <c:if test="${'0' eq itemCompare || '' eq itemCompare || null eq itemCompare}">
                                    <div class="counts">${itemPrice}&nbsp;ISK</div>
                                </c:if>
                                <c:if test="${'-1' eq itemCompare }">
                                    <div class="counts color-green">${itemPrice}&nbsp;ISK</div>
                                </c:if>
                            </div>
                            <div class="media-body">
                                <h6>${itemName}</h6>
                            </div>
                        </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
            </c:forEach>

        </div>
    </div>

    <!-- Add event -->
    <div class="modal fade" id="addNew-event">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title">新的栏目</h4>
                </div>
                <div class="modal-body">
                    <form class="form-validation" role="form">
                        <div class="form-group">
                            <div class="row">
                                <div class="col-md-12 m-b-15">
                                    <label class="checkbox-inline">
                                        <input type="checkbox" id="titleCompare" name="titleCompare" >
                                        标题物品比价
                                    </label>
                                    <label class="checkbox-inline">
                                        <input type="checkbox" id="totalCount" name="totalCount">
                                        计算总价
                                    </label>
                                </div>
                            </div>
                            <div class="row">
                                <div id="titleCol" class="col-md-6 m-b-15">
                                    <label for="titleItem">标题</label>
                                    <div class="p-relative">
                                        <input type="text" class="input-sm form-control validate[required]" id="titleItem" value="">
                                        <span id="searchTitleItem" class="icon cursor-hand transBtn" onclick="transItem('titleItem','titleItemId')"></span>
                                    </div>
                                </div>
                                <div id="titleSelectCol" class="col-md-3 m-b-15">
                                    <label>&nbsp;</label>
                                    <select id="titleItemId" class="select">
                                        <option value="-1">-无-</option>
                                    </select>
                                </div>
                                <div id="titleNumCol" class="col-md-3 m-b-15">
                                    <label for="titleNum">&nbsp;</label>
                                    <div class="p-relative">
                                        <input id="titleNum" class="form-control input-sm spinedit" value="1"/>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6 m-b-15">
                                    <label for="titleItem">添加物品</label>
                                    <div class="p-relative">
                                        <input type="text" class="input-sm form-control" id="enterItem" value="">
                                        <span class="icon cursor-hand transBtn" onclick="transItem('enterItem','enterItemId')"></span>
                                    </div>
                                </div>
                                <div class="col-md-3 m-b-15">
                                    <label>&nbsp;</label>
                                    <select id="enterItemId" class="select">
                                        <option value="-1">-无-</option>
                                    </select>
                                </div>
                                <div class="col-md-3 m-b-15">
                                    <label>&nbsp;</label>
                                    <div style=" height: 30px; width: 100%; line-height: 30px; cursor: pointer; text-align: center">
                                        <span onclick="addToList()"><span class="icon" style="font-weight: bold"></span>&nbsp;添加到列表</span>
                                    </div>
                                </div>
                            </div>
                            <div class="row" id="item_block">
                                <div class="col-md-4 m-b-15">
                                    <label><span class="icon cursor-hand"></span>&nbsp;&nbsp;三钛合金</label>
                                    <div class="p-relative">
                                        <input id="test1" class="form-control input-sm spinedit" value="333"/>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>

                <div class="modal-footer">
                    <input type="submit" class="btn btn-info btn-sm" id="addEvent" value="发布">
                    <button type="button" class="btn btn-info btn-sm" data-dismiss="modal">关闭</button>
                </div>
            </div>
        </div>
    </div>
    <br/><br/>
</section>
<!-- Javascript Libraries -->
<!-- jQuery -->
<script src="js/jquery.min.js"></script> <!-- jQuery Library -->
<script src="js/jquery-ui.min.js"></script> <!-- jQuery UI -->

<!-- Bootstrap -->
<script src="js/bootstrap.min.js"></script>

<!-- UX -->
<script src="js/scroll.min.js"></script> <!-- Custom Scrollbar -->

<!--  Form Related -->
<script src="js/validation/validate.min.js"></script> <!-- jQuery Form Validation Library -->
<script src="js/validation/validationEngine.min.js"></script>
<!-- jQuery Form Validation Library - requirred with above js -->

<!-- Other -->
<script src="js/calendar.min.js"></script> <!-- Calendar -->
<script src="js/feeds.min.js"></script> <!-- News Feeds -->
<script src="js/autosize.min.js"></script><!-- Textare autosize -->


<!-- All JS functions -->
<script src="js/spinner.min.js"></script>
<script src="js/select.min.js"></script>
<script src="js/icheck.js"></script>
<script src="js/functions.js"></script>
<script src="js/myJs/commonFunction.js"></script>
<script src="js/myJs/iframeFunction.js"></script>

<script type="text/javascript">
    $(document).ready(function () {
        parent.setMainIframeHeight();

        $('#titleNum').spinedit('setMinimum', 1).spinedit('setMaximum', 10000);
        $('#test1').spinedit('setMinimum', 1).spinedit('setMaximum', 10000);
        $('#titleItemId').selectpicker();
        // $('#testselect').selectpicker('refresh');
        // $('.selectpicker').selectpicker('val', ‘列表id');

        $('#titleCompare').on('ifChecked', function(event){
            titleChange(true);
        });
        $('#titleCompare').on('ifUnchecked', function(event){
            titleChange(false);
        });


        //新建确定按钮
        $('body').on('click', '#addSection', function () {
            var eventForm = $(this).closest('.modal').find('.form-validation');
            eventForm.validationEngine('validate');
            $('#addNew-event form')[0].reset();
            $('#titleCompare').iCheck('uncheck');
            $('#totalCount').iCheck('uncheck');
            $("#titleItem").val("");
            titleChange(false);
            $("#titleNum").val("1");

            $("#enterItem").val("");
            $("#enterItemId option:not(:eq(0))").remove();
            $('#enterItemId').selectpicker('refresh');
            $("#item_block").html("");

            $('#addNew-event').modal('show');
        });


        $('body').on('click', '#addEvent', function () {
            var eventForm = $(this).closest('.modal').find('.form-validation');
            eventForm.validationEngine('validate');
            var itemList = $(".sub_item_block");
            if (!(eventForm).find('.formErrorContent')[0] && itemList.length > 0) {
                var needCompare = $("#titleCompare").is(":checked");
                var needCount = $("#totalCount").is(":checked");

                var titleName = $("#titleItem").val();
                var titleItemId = $("#titleItemId").val();
                var titleNum = $("#titleNum").val();

                var subList = [];
                if(needCompare){
                    if(titleItemId == -1){
                        $message.alert({
                            title: "Insert result",
                            msg: "<p>" + "标题不是有效的物品！" + "</p>"
                        });
                        return;
                    }
                    var titleObj = {};
                    titleObj.id     = titleItemId;
                    titleObj.num    = titleNum;

                    subList.push(titleObj);
                }

                for(var i = 0; i < itemList.length; i++){
                    var subObj = {};
                    var subItemId = itemList[i].getAttribute("id").replace("subItem_","");
                    var subItemNum = $(itemList[i]).find("#itemNum_" + subItemId).val();
                    subObj.id     = subItemId;
                    subObj.num    = subItemNum;
                    subList.push(subObj);
                }

                var sectionData = {
                    title:titleName + "",
                    needCompare:needCompare + "",
                    needCount:needCount + "",
                    itemList:JSON.stringify(subList) + ""
                };
                $.ajax({
                    url: "itemGroup.do?method=addNewSection",
                    async: false,
                    type: "POST",
                    dataType: "json",
                    data: sectionData,
                    success: function (data) {
                        window.location.reload();
                    },
                    error: function (data) {
                        $message.alert({
                            title: "Insert result",
                            msg: "<p>" + "失败!" + "</p>"
                        });
                    }
                });
                $('#addNew-event form')[0].reset();
                $('#addNew-event').modal('hide');
            }
        });
    });

    function titleChange(isChecked) {
        $("#titleItemId option:not(:eq(0))").remove();
        $("#titleItemId").val("-1");
        $('#titleItemId').selectpicker('refresh');
        if(isChecked){
            $("#titleCol").toggleClass("col-md-6",true).toggleClass("col-md-12",false);
            setTimeout(function () {
                $("#searchTitleItem").show();
                $("#titleSelectCol").show();
                $("#titleNumCol").show();
            },500);
        }else{
            $("#searchTitleItem").hide();
            $("#titleSelectCol").hide();
            $("#titleNumCol").hide();
            $("#titleCol").toggleClass("col-md-12",true).toggleClass("col-md-6",false);
        }
    }

    function transItem(inputDomId,selectDomId){
        var prevInputDom = $("#" + inputDomId);
        var nextSelectDom = $("#" + selectDomId);
        var itemName = $.trim(prevInputDom.val());
        $.ajax({
            url : "item.do?method=queryJitaItemsByName",
            async : false,
            type : "POST",
            dataType : "json",
            data : {
                itemName : itemName,
            },
            success : function(data) {
                nextSelectDom.find("option:not(:eq(0))").remove();
                if(typeof data == "object" && data.length > 0){
                    for(var i = 0; i < data.length; i++){
                        $("<option>").text(data[i].name).val(data[i].id).appendTo(nextSelectDom);
                    }
                }
                nextSelectDom.selectpicker('refresh');
            }
        });
    }
    function addToList() {
        var itemName = $("#enterItemId").find("option:selected").text();
        var itemId = $("#enterItemId").val();
        if(itemId == "-1" || $("#subItem_" + itemId).length > 0){
            return false;
        }
        var itemDom = $("<div id=\"subItem_"+ itemId +"\" class=\"col-md-3 m-b-15 sub_item_block\">\n" +
            "    <label for=\"itemNum_"+itemId  +"\"><span class=\"icon\" style='font-weight: bold' onclick='removeSubItem(this)'></span>&nbsp;"+ itemName +"</label>\n" +
            "    <div class=\"p-relative\">\n" +
            "        <input id=\"itemNum_"+ itemId +"\" class=\"form-control input-sm spinedit\" value=\"1\"/>\n" +
            "    </div>\n" +
            "</div>");
        itemDom.hide();
        $("#item_block").append(itemDom);
        $("#itemNum_"+ itemId).spinedit('setMinimum', 1).spinedit('setMaximum', 10000);
        itemDom.show();
    }

    function removeSubItem(dom) {
        $(dom).parent().remove();
    }

    function deleteSection(sectionId){
        if(sectionId && $.trim(sectionId) !== ""){
            $.ajax({
                url : "itemGroup.do?method=removeSection",
                async : false,
                type : "POST",
                dataType : "json",
                data : {
                    sectionId : sectionId,
                },
                success : function(data) {
                    if(data.code === "0"){
                        window.location.reload();
                    }else{
                        $message.alert({
                            title: "Delete result",
                            msg: "<p>" + "删除失败! 原因：" + data.msg + "</p>"
                        });
                    }
                }
            });
        }
    }
</script>
</body>
</html>

