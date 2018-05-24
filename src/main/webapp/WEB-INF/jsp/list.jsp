<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>List</title>
    <script type="text/javascript" src="../js/jquery-2.1.0.js"></script>
    <script type="text/javascript" src="../js/bootstrap.min.js"></script>
    <script type="text/javascript" src="../js/bootstrap-table.js"></script>
    <script type="text/javascript" src="../js/bootstrap-table-zh-CN.js"></script>

    <link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="../css/bootstrap-table.css">

    <script type="text/javascript">
        $(function(){
            $('#table').bootstrapTable({
                method: 'get',
                url: '/data.do',
                dataType: 'json',
                striped: true,//显示行间隔色
                pagination: true,
                pageNumber: 1,
                pageSize: 10,
                pageList: [10, 20, 50, 100],
                search: false,
                queryParamsType: '',//默认值为'limit': 在默认情况下 传给服务端的参数为：offset,limit,sort
                                    //设置为'': 在这种情况下传给服务器的参数为：pageSize,pageNumber
                sidePagination: 'server',
                columns:[
                    {
                        title: '编号',
                        field: 'id',
                        align: 'center'
                    },
                    {
                        title: '下载地址',
                        field: 'url',
                        align: 'center'
                    },
                    {
                        title: '时间',
                        field: 'systime',
                        align: 'center',
                        formatter:function(value,row,index){
                            return value.substring(0, value.indexOf('.'));
                        }
                    },
                    {
                        title: '是否使用',
                        field: 'status',
                        align: 'center',
                        formatter:function(value,row,index){
                            var color;
                            if(value == 0){
                                color = '<img id="'+ row.id +'" src="/img/green.png"  alt="未使用" />';
                            } else {
                                color = '<img id="'+ row.id +'" src="/img/red.png"  alt="已使用" />';
                            }
                            return color;
                        }
                    },
                    {
                        title: '是否售出',
                        field: 'issell',
                        align: 'center',
                        formatter:function(value,row,index){
                            var radio
                            if(value == 0){
                                radio = '<input id="isSell'+ row.id +'" type="checkbox" onclick="changeIsSell('+ value + ', ' + row.id + ')"/>';
                            } else {
                                radio = '<input id="isSell'+ row.id +'" type="checkbox" checked="checked" onclick="changeIsSell('+ value + ', ' + row.id +')"/>';
                            }
                            return radio;
                        }
                    },
                    {
                        title: '',
                        field: 'key',
                        align: 'center',
                        formatter:function(value,row,index){
                            return '<input type="button" data-toggle="modal" data-target="#qrcode" onclick="popupQRcode(\''+ value +'\');" value="查看二维码" class="btn"/>';
                        }
                    }
                ]
            });
        });

        function popupQRcode(key){
            $('#image').attr('src', '/qrcode/' + key + '.png');
        }

        function changeIsSell(issell, id){
            if(issell == 0){
                issell = 1;
            } else {
                issell = 0;
            }

            $.ajax({
                type: "get",
                url: "/isSell.do?issell=" + issell + "&id=" + id,
                dataType: "text",
                async: false,
                success: function (data) {
                    if(data == "success"){
                        if (issell == 0){
                            /*$('#'+id).attr('src', "/img/green.png");*/
                            $('#isSell'+id).attr('onclick', "changeIsSell(0, "+ id +")");
                        } else {
                            /*$('#'+id).attr('src', "/img/red.png");*/
                            $('#isSell'+id).attr('onclick', "changeIsSell(1, "+ id +")");
                        }
                    }
                },
            });
        }
    </script>
</head>
<body>
    <div class="container" style="margin-top: 20px;">
        <table id="table">
        </table>

        <!-- Modal -->
        <div class="modal fade" id="qrcode" style="width: 330px;" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel">二维码</h4>
                    </div>
                    <div class="modal-body">
                        <img src="" id="image" alt="二维码" />
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
