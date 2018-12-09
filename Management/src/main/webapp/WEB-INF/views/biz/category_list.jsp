<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>科室分类列表</title>
        <link rel="stylesheet" href="../../../css/index.css">
        <link rel="stylesheet" href="../../../css/bootstrap.min.css">
    </head>

    <body>
       <header>
            <div class="container">
                <c:forEach items="${CATEGORIES}" var="category">
                    <nav>
                        <a href="${pageContext.request.contextPath}/department/list.do?category_id=${category.id}" >${category.name}</a>
                    </nav>
                </c:forEach>
                <nav>
                    <a href="${pageContext.request.contextPath}/category/list.do">分类</a>
                </nav>
            </div>
        </header>
        <section class="banner">
            <div class="container">
                <div>
                    <h1>科室分类</h1>
                    <p>科室分类列表</p>
                </div>
            </div>
        </section>
        <section class="main">
            <div class="container">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>名称</th>
                        <th>创建时间</th>
                        <th>最后修改时间</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${CATEGORIES}" var="category">
                            <tr>
                                <td>${category.name}</td>
                                <td><fmt:formatDate value="${category.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                                <td><fmt:formatDate value="${category.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/category/toEdit.do?id=${category.id}">修改</a>&nbsp;&nbsp;
                                    <a href="${pageContext.request.contextPath}/category/delete.do?id=${category.id}">删除</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </section>
        <section class="page">
            <div class="container">
                <div id="fatie">
                    <a href="${pageContext.request.contextPath}/category/toAdd.do" role="button" class="btn btn-primary">新&nbsp;&nbsp;建</a>
                </div>
            </div>
        </section>
        <footer>
            copy@慕课网
        </footer>
    </body>
</html>