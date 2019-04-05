<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="BASE" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<!--[if IE 9 ]><html class="ie9"><![endif]-->
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
        <meta name="format-detection" content="telephone=no">
        <meta charset="UTF-8">
        <meta name="description" content="Violate Responsive Admin Template">
        <meta name="keywords" content="Super Admin, Admin, Template, Bootstrap">

        <title>思维殿堂</title>
            
        <!-- CSS -->
        <link href="${BASE}/asset/css/bootstrap.min.css" rel="stylesheet">
        <link href="${BASE}/asset/css/animate.min.css" rel="stylesheet">
        <link href="${BASE}/asset/css/font-awesome.min.css" rel="stylesheet">
        <link href="${BASE}/asset/css/form.css" rel="stylesheet">
        <link href="${BASE}/asset/css/calendar.css" rel="stylesheet">
        <link href="${BASE}/asset/css/style.css" rel="stylesheet">
        <link href="${BASE}/asset/css/icons.css" rel="stylesheet">
        <link href="${BASE}/asset/css/generics.css" rel="stylesheet">
        <link href="${BASE}/asset/css/jsmind.css" rel="stylesheet">

        <style type="text/css">

            #jsmind_container{
                width:100%;
                height:700px;
            }
            #jsmind_container > div {
                overflow: hidden;
            }

        </style>

    </head>
    <body id="skin-tectile">
        <div id="jsmind_container"></div>
        <!-- Javascript Libraries -->
        <!-- jQuery -->
        <script src="${BASE}/asset/js/jquery.min.js"></script> <!-- jQuery Library -->

        <!-- Bootstrap -->
        <script src="${BASE}/asset/js/bootstrap.min.js"></script>

        <!-- UX -->
        <script src="${BASE}/asset/js/scroll.min.js"></script> <!-- Custom Scrollbar -->

        <!-- Other -->
        <script src="${BASE}/asset/js/calendar.min.js"></script> <!-- Calendar -->
        <script src="${BASE}/asset/js/feeds.min.js"></script> <!-- News Feeds -->
        
        <!-- All JS functions -->
        <script src="${BASE}/asset/js/functions.js"></script>

        <!-- jsMind -->
        <script src="${BASE}/asset/js/jsmind/jsmind.js"></script>
        <script src="${BASE}/asset/js/jsmind/jsmind.draggable.js"></script>
        <script src="${BASE}/asset/js/jsmind/jsmind.screenshot.js"></script>

        <script>

            var mind = {
                /* 元数据，定义思维导图的名称、作者、版本等信息 */
                "meta":{
                    "name":"example",
                    "author":"hizzgdev@163.com",
                    "version":"0.2"
                },
                /* 数据格式声明 */
                "format":"node_array",
                /* 数据内容 */
                "data":[
                    ${typeStr}
                ]
            };

            var options = {
                container:'jsmind_container',
                editable:false,
                theme:'palace'
            };

            var jm = new jsMind(options);
            // 让 jm 显示这个 mind 即可
            jm.show(mind);

        </script>

        <script>
            var tempId = 1;
            window.setInterval(checkSelected, 500);
            function checkSelected()
            {

                if(null != jm.get_selected_node() && 1 != jm.get_selected_node().id && tempId != jm.get_selected_node().id){
                    $.ajax({
                        type: "get",
                        dataType: "json",
                        async: "false",
                        url: "/son-num",
                        data: {
                            pId : jm.get_selected_node().id
                        },
                        success: function (data){
                            if(data > 0){
                                location.href = "/mind?pId=" + jm.get_selected_node().id ;
                            }else {
                                $.ajax({
                                    type: "get",
                                    dataType: "json",
                                    async: "false",
                                    url: "/article-num",
                                    data: {
                                        pId : jm.get_selected_node().id
                                    },
                                    success: function (data){
                                        if(data > 0){
                                            location.href = "/list?typeId=" + jm.get_selected_node().id ;
                                        }else {
                                            tempId = jm.get_selected_node().id;
                                            alert("\"" + jm.get_selected_node().topic + "\"" + "下暂无内容，敬请期待！");
                                        }
                                    }
                                })
                            }
                        }
                    })
                }
            }
        </script>

    </body>
</html>

