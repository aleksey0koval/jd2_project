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
    <div class="pagination">
        <a href="#">«</a>
        <a class="active" href="#">1</a>
        <a href="#">»</a>
    </div>
</form>

<form  action="/web/search">
    <input name="searchParam" type="search" placeholder="enter text to search" aria-label="Search">
    <button class="fa fa-search" type="submit">Search</button>
</form>

<table id="customers" align="center">
    <thead>
    <tr>
        <security:authorize access="hasRole('ADMIN')">
            <th></th>
        </security:authorize>
        <th>Name</th>
        <th>Model</th>
        <th>Type</th>
        <th>Range</th>
        <th>Unit</th>
        <th>Location</th>
        <security:authorize access="hasRole('ADMIN')">
            <th></th>
        </security:authorize>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${searchResult}" var="sensorItem">
        <tr>
            <security:authorize access="hasRole('ADMIN')">
                <td>
                    <form action="edit/${sensorItem.sensorId}">
                        <div>
                            <button class="btn edit" >Edit</button>
                        </div>
                    </form>
                </td>
            </security:authorize>

            <td><a title=${sensorItem.descriptionSensor.descriptionSensor}>${sensorItem.sensorName}</a></td>
            <td>${sensorItem.descriptionSensor.modelName}</td>
            <td>${sensorItem.descriptionSensor.typeName}</td>
            <td>${sensorItem.descriptionSensor.rangeFromSensor} - ${sensorItem.descriptionSensor.rangeToSensor}</td>
            <td>${sensorItem.descriptionSensor.unitName}</td>
            <td>${sensorItem.locationName}</td>
            <security:authorize access="hasRole('ADMIN')">
                <td>

                    <form action="delete/${sensorItem.sensorId}">
                        <div>
                            <button class="btn delete" style="">Delete</button>
                        </div>
                    </form>
                </td>
            </security:authorize>
        </tr>
    </c:forEach>
    </tbody>

</table>

<security:authorize access="hasRole('ADMIN')">
    <form action="/web/add-sensor">
        <div>
            <button class="btn add" >Add sensors</button>
        </div>
    </form>
</security:authorize>

<form action="/web">
    <div>
        <button class="btn add" >All sensors</button>
    </div>
</form>

</body>
</html>



