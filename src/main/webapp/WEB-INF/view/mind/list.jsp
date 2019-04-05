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

    <title>文章流</title>

    <!-- CSS -->
    <link href="${BASE}/asset/css/bootstrap.min.css" rel="stylesheet">
    <link href="${BASE}/asset/css/animate.min.css" rel="stylesheet">
    <link href="${BASE}/asset/css/font-awesome.min.css" rel="stylesheet">
    <link href="${BASE}/asset/css/form.css" rel="stylesheet">
    <link href="${BASE}/asset/css/calendar.css" rel="stylesheet">
    <link href="${BASE}/asset/css/style.css" rel="stylesheet">
    <link href="${BASE}/asset/css/icons.css" rel="stylesheet">
    <link href="${BASE}/asset/css/generics.css" rel="stylesheet">
</head>
<body id="skin-tectile"\>

<section id="main" class="p-relative" role="main">
    <!-- Content -->
    <section id="content" class="container" style="margin: 0 auto;">

        <!-- Content Boxes -->
        <div class="block-area" id="content-boxes">

            <div class="row">


            <c:forEach var="article" items="${articleList}" varStatus="status">
                <c:if test="${status.count % 3 == 0}">
                    <div class="row">
                </c:if>

                    <div class="col-sm-6 col-md-4">
                        <div class="thumbnail tile">
                            <div class="p-15">
                                <h4>${article.title}</h4>
                                <p>${article.summary}</p>
                                <p>
                                    <a href="${article.url}" class="btn btn-alt btn-sm">查看全文</a>
                                </p>
                            </div>
                        </div>
                    </div>
                <c:if test="${status.count % 3 == 0}">
                    </div>
                </c:if>

            </c:forEach>


            </div>
        </div>
    </section>
</section>

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

</body>
</html>

