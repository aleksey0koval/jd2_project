<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


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
    text-align: center;
    border: 2px solid black;
    width: 150px;
    background-color: white;
    color: black;
    padding: 14px 28px;
    font-size: 16px;
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


</style>
</head>
<body>
<form method="post" action="/web">
    <div>
        <button class="btn logout" href="/web">logout</button>
    </div>
</form>
<p><big><big><big><h1 align="center">Sensor table</h1></big></big></big></p>



<form  action="/web/search">
          <input name="searchParam" type="search" placeholder="enter text to search" aria-label="Search">
          <button class="fa fa-search" type="submit">Search</button>
        </form>

<table id="customers" align="center">
    <thead>
      	<tr>
            <th>Name</th>
            <th>Model</th>
            <th>Type</th>
            <th>Range</th>
            <th>Unit</th>
            <th>Location</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach items="${sensorList}" var="sensorItem">
        <tr>
            <td>${sensorItem.sensorName}</td>

            <c:forEach items="${sensorItem.descriptionSensor.modelSensors}" var="modelSensor">
                <td>${modelSensor.modelName}</td>
            </c:forEach>

            <c:forEach items="${sensorItem.descriptionSensor.typeSensors}" var="typeSensors">
                <td>${typeSensors.typeName}</td>
            </c:forEach>

            <c:forEach items="${sensorItem.descriptionSensor.rangeSensors}" var="rangeSensors">
                <td>${rangeSensors.rangeFromSensor} - ${rangeSensors.rangeToSensor}</td>
            </c:forEach>

            <c:forEach items="${sensorItem.descriptionSensor.typeSensors.unitTypeSensors}" var="unitTypeSensors">
                <td>${unitTypeSensors.unitName}</td>
            </c:forEach>

            <td>${sensorItem.locationSensor}</td>

            <form method="post" action="/web/add-sensor">
                <div>
                    <button class="btn edit" href=/web/edit?id=${sensorItem.sensorId}">Edit</button>
                </div>
            </form>
            <form method="post" action="/web/logout">
                <div>
                    <button class="btn delete" href="/web/delete?id=${sensorItem.sensorId}">Delete</button>
                </div>
            </form>
        </tr>
    </c:forEach>
    </tbody>
</table>


<form action="/web/add-sensor">
    <div>
        <button class="btn add" >Add sensor</button>
    </div>
</form>
</form>
</body>
</html>



