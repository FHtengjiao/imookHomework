<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>新建</title>
        <link rel="stylesheet" href="../../../css/bootstrap.min.css">
        <link rel="stylesheet" href="../../../css/add.css">
        <script src="../../../js/jquery-1.8.3.min.js"></script>
        <script>
            $(function () {
                $("#option_${DEPARTMENT.categoryId}").attr("selected",true);
            });
        </script>
    </head>
    <body>
        <nav class="navbar navbar-default">
            <div class="container">
                <div class="navbar-header">
                    <a class="navbar-brand" href="${pageContext.request.contextPath}/category/list.do">
                        慕课网科室分类管理
                    </a>
                </div>
            </div>
        </nav>
        <div class="container">
            <div class="jumbotron">
                <h1>Hello, ${USER.account}!</h1>
                <p>请小心的编辑科室记录，要是编辑一个错误的就不好了。。。</p>
            </div>
            <div class="page-header">
                <h3><small>编辑科室</small></h3>
            </div>
            <form class="form-horizontal" action="${pageContext.request.contextPath}/department/edit.do" method="post">
                <input type="hidden" name="id" value="${DEPARTMENT.id}">
                <div class="form-group">
                    <label for="name" class="col-sm-2 control-label">名称 ：</label>
                    <div class="col-sm-8">
                        <input name="name" class="form-control" id="name" value="${DEPARTMENT.name}">
                    </div>
                </div>
                <div class="form-group">
                    <label for="category_id" class="col-sm-2 control-label">分类 ：</label>
                    <select id="category_id" name="category_id" class="col-sm-2 form-control" style="width: auto">
                        <c:forEach items="${CATEGORIES}" var="category">
                            <option id="option_${category.id}" value="${category.id}">${category.name}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-primary">保存</button>&nbsp;&nbsp;&nbsp;
                    </div>
                </div>
            </form>
        </div>
        <footer class="text-center" >
            copy@imooc
        </footer>
    </body>
</html>
