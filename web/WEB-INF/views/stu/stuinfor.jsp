<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/11/9
  Time: 18:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<%--width: 800px; height: 500px; background: #eee; border: 1px solid rgb(204, 204, 204); position: absolute; left: 50%;top: 50%; transform: translate(-50%,-50%);--%>
<%--style="padding: 50px 50px 100px 100px"--%>
<div class="table-responsive" style="padding: 20px 40px 100px 10px;">
    <%--table-sm--%>
    <a href="/stu?type=input" class="btn btn-sm btn-info" role="button" aria-pressed="true" style="font-size: 7px;padding-bottom: 5px;">添加学生信息</a>
    <!-- Button trigger modal -->
    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#clName">
        添加班级信息
    </button>
    <a href="/stu?type=classInput" class="btn btn-sm btn-info" role="button" aria-pressed="true" style="font-size: 7px;padding-bottom: 5px;">添加班级信息</a>
    <table class="table table-sm table-bordered table-hover" style="text-align: center">
        <thead>
        <tr>
            <th scope="col">编号</th>
            <th scope="col">名称</th>
            <th scope="col">密码</th>
            <th scope="col">年纪</th>
            <th scope="col">性别</th>
            <th scope="col">电话</th>
            <th scope="col">班级</th>
            <th scope="col">地址</th>
            <th scope="col" style="width: 110px;">操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach	items="${stuList}" var="stu">
        <tr>
            <td scope="row">${stu.id}</td>
            <td>${stu.name}</td>
            <td>${stu.password}</td>
            <td>${stu.age}</td>
            <td>${stu.gender==0?"女":"男"}</td>
            <td>${stu.phone}</td>
            <td>${stu.className}</td>
            <td>${stu.address}</td>
            <td>
                <a href="/stu?type=input&id=${stu.id}" class="btn btn-sm btn-info" role="button" aria-pressed="true" style="font-size: 7px;">修改</a>
                <input type="button" class="btn btn-primary btn-sm btn-danger" data-toggle="modal" data-target="#exampleModal" style="font-size: 7px;" value="删除" onclick="values('${stu.id}')">
            </td>
        </tr>
        </c:forEach>
    </table>
</div>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <form action="" method="post">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">请输入你要添加的班级信息</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
<%--                    <input type="hidden" id="id" name="id" value="">--%>
                    <input type="text" name="className">
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
                    <a href="#" onclick="deleteId()" id="deleteSure" class="btn btn-primary" role="button">确认</a>
                </div>
            </div>
        </form>
    </div>
</div>


<!-- Button trigger modal -->
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#clName">
    Launch demo modal
</button>

<!-- Modal -->
<div class="modal fade" id="clName" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel2">Modal title</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                ...
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Save changes</button>
            </div>
        </div>
    </div>
</div>

<script>
    $("#exampleModal").modal("hide");
    function values(ID){
        $("#id").val(ID);
        document.getElementById('use').innerText='id='+ID;
    }

    function deleteId(){
        var id = document.getElementById('id').value;
        document.getElementById('use').innerText='id='+id;
        document.getElementById('deleteSure').href='/stu?type=delete&id='+id;
    }
</script>
</body>
</html>
