<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <style>
        body {font-family: Arial, Helvetica, sans-serif; margin-right:100px; margin-left:100px;}
        <style>

         .icon-bar {
             width: 90px;
             background-color: #555;
         }

        .icon-bar a {
            display: block;
            text-align: center;
            padding: 16px;
            transition: all 0.3s ease;
            color: white;
            font-size: 36px;
        }

        .icon-bar a:hover {
            background-color: #000;
        }

        .active {
            background-color: #4CAF50 !important;
        }

        form {
            /* Расположим форму по центру страницы */

            width: auto;
            margin-top: 0px;
        }

        a {
            color: #008000; /* Цвет обычной ссылки */
            text-decoration: none; /* Убираем подчеркивание у ссылок */
        }
        a:visited {
            color: #800080; /* Цвет посещённой ссылки */
        }
        a:hover {
            color: red; /* Цвет ссылки при наведении на нее курсора мыши */
            text-decoration: underline; /* Добавляем подчеркивание */
        }

        input {
            background: white; /* Цвет фона */
            border: 1px solid #7a7b7e; /* Параметры рамки */
            width: 300px; /* Ширина кнопки */
            height: 30px; /* Высота */
            border-radius: 0px;
        }


        button {
            background: #f2f6f8; /* Цвет фона */
            border: 1px solid #7a7b7e; /* Параметры рамки */
            width: 100px; /* Ширина кнопки */
            height: 30px; /* Высота */
            border-radius: 15px;
        }

        button:hover {background-color: #3e8e41}

        button:active {
            background-color: #3e8e41;
            box-shadow: 0 5px #666;
            transform: translateY(4px);
        }

        table {
            margin: 0 auto;

            margin-top: 10px;
            border-collapse: collapse;
            border-spacing: 0;
            width: 100%;
            border: 1px solid #ddd;
        }

        th, td {
            text-align: center;
            padding: 16px;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2
        }

        #customers {
            font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        #customers td, #customers th {
            border: 1px solid #ddd;
            padding: 8px;
        }

        #customers tr:nth-child(even){background-color: #f2f2f2;}

        #customers tr:hover {background-color: #ddd;}

        #customers th {
            padding-top: 12px;
            padding-bottom: 12px;
            text-align: center;
            background-color: #4CAF50;
            color: white;
        }

        .btn {
            margin-top: auto;
            margin-right: auto;
            margin-left: auto;
            margin-right: auto;

            border: 2px solid black;
            width: 100px;
            background-color: white;
            color: black;

            cursor: pointer;
            border-radius: 15px;
        }

        /* BLUE */
        .logout {
            border-color: dodgerblue;
            color: dodgerblue;
        }

        .logout:hover {
            background-color: dodgerblue;
            color: white;
        }

        /* Red */
        .add {
            border-color: darkgreen;
            color: green;
        }

        .add:hover {
            background-color: #4CAF50;
            color: white;
        }

        /* Yellow */
        .edit {
            border-color: yellow;
            color: yellow;
        }

        .edit:hover {
            background-color: yellow;
            color: white;
        }

        /* Red */
        .delete {
            border-color: #f44336;
            color: red
        }

        .delete:hover {
            background: #f44336;
            color: white;
        }

        .pagination a {
            color: black;
            float: left;
            padding: 8px 16px;
            text-decoration: none;
            transition: background-color .3s;
        }

        .pagination a.active {
            background-color: dodgerblue;
            color: white;
        }

        .pagination a:hover:not(.active) {background-color: #ddd;}


    </style>
</head>
<body>

<security:authorize access="isAuthenticated()">
<form method="post" action="${pageContext.request.contextPath}/logout">
    <div>
        <button class="btn logout" >logout</button>
    </div>
</form>
</security:authorize>
<p><big><big><big><h1 align="center">Sensor table</h1></big></big></big></p>

<form>
<div>
    <ul class="pagination">
        <li class="page-item disabled">
            <a class="page-link" href="#" tabindex="-1">Pages</a>
        </li>
        <c:forEach items="${listSize}" var="pageItem">
            <c:choose>
                <c:when test="${(pageItem-1) == page}">
                    <li class="page-item active">
                        <a class="page-link" href="#" tabindex="-1">${pageItem}</a>
                    </li>
                </c:when>
                <c:when test="${pageItem == -1}">
                    <li class="page-item active">
                        <a class="page-link" href="#" tabindex="-1">...</a>
                    </li>
                </c:when>
                <c:otherwise>
                    <li class="page-item">
                        <a class="page-link" href="${url}?page=${pageItem-1}&size=${size}" tabindex="-1">${pageItem}</a>
                    </li>
                </c:otherwise>
            </c:choose>
        </c:forEach>

        <li class="page-item disabled">
            <a class="page-link" href="#" tabindex="-1">Elements</a>
        </li>
        <c:forEach items="${[4, 8, 12, 16]}" var="pageSize">
            <c:choose>
                <c:when test="${pageSize == size}">
                    <li class="page-item active">
                        <a class="page-link" href="#">${pageSize}</a>
                    </li>
                </c:when>
                <c:otherwise>
                    <li class="page-item">
                        <a class="page-link" href="${url}?page=${page}&size=${pageSize}" tabindex="-1">${pageSize}</a>
                    </li>
                </c:otherwise>
            </c:choose>
        </c:forEach>

    </ul>
</div>
</form>

<form>
    <div class="pagination">
        <a href="#">«</a>
        <a href="#">1</a>
        <a class="active" href="#">2</a>
        <a href="#">3</a>
        <a href="#">4</a>
        <a href="#">5</a>
        <a href="#">6</a>
        <a href="#">»</a>
    </div>
</form>
