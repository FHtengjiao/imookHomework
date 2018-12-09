<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>编辑科室分类</title>
        <link rel="stylesheet" href="../../../css/bootstrap.min.css">
        <link rel="stylesheet" href="../../../css/add.css">
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
                <p>请小心的编辑科室分类记录，要是编辑一个错误的就不好了。。。</p>
            </div>
            <div class="page-header">
                <h3><small>编辑</small></h3>
            </div>
            <form class="form-horizontal" action="${pageContext.request.contextPath}/category/edit.do" method="post">
                <input type="hidden" name="id" value="${CATEGORY.id}">
                <div class="form-group">
                    <label for="name" class="col-sm-2 control-label">名称 ：</label>
                    <div class="col-sm-8">
                        <input name="name" class="form-control" id="name" value="${CATEGORY.name}">
                    </div>
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
