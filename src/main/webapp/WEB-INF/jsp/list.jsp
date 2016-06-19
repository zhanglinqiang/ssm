<%--
  Created by IntelliJ IDEA.
  User: zhang
  Date: 2016/6/19
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>list</title>
    <script type="text/javascript" src="/js/jquery-1.12.2.js"></script>
</head>
<body>
<table border="1" cellpadding="0" align="center">
    <tr>
        <th>id</th>
        <th>name</th>
        <th>age</th>
        <th>operation</th>
    </tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.age}</td>
            <td><a href="javascript:void(0);" onclick="deleteUser('${user.id}',this)">delete</a></td>
        </tr>
    </c:forEach>
</table>
<div align="center" style="margin-top:20px;">
    <form name="fm_user">
        <label>name:</label><input type="text" name="name"/>
        <label>age:</label><input type="text" name="age"/>
        <input type="button" onclick="addUser();" value="add" />
    </form>
</div>

<script type="text/javascript">
    function addUser(){
        var param={};
        param["name"]=$("input[name=name]").val();
        param["age"]=$("input[name=age]").val();
        $.post("/user/add",param,function (result) {
            if(result){
                location.reload();
            }else {
                alert("添加失败!");
            }
        });
    }

    function deleteUser(id,a){
        var $tr = $(a).closest("tr");
        $.post("/user/delete",{"id":id},function (result) {
            if(result){
                $tr.remove();
            }else {
                alert("删除失败!")
            }
        });
    }
</script>
</body>
</html>
