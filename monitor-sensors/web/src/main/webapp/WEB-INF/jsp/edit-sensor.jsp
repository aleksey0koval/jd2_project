<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
        body {
            font-family: Arial, Helvetica, sans-serif;
            margin-right: 100px;
            margin-left: 100px;
        }

        form {
            /* Расположим форму по центру страницы */
            margin: 0 auto;
            width: 500px;

            margin-top: 0; /* Отступ сверху */
            /* Определим контур формы */

        }

        table {
            /* Расположим форму по центру страницы */
            margin: 0 auto;
            width: 500px;

            margin-top: 0; /* Отступ сверху */
            /* Определим контур формы */

        }


        input[type=text], select, textarea {
            width: 100%;
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
            margin-top: 6px;
            margin-bottom: 16px;
            resize: vertical;
        }

        input[type=number], select, textarea {
            width: 100%;
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
            margin-top: 6px;
            margin-bottom: 16px;
            resize: vertical;
        }

        input[type=submit] {
            background-color: #4CAF50;
            color: white;
            padding: 12px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type=submit]:hover {
            background-color: #45a049;
        }

        .container {
            /* Фон вокруг формы
            border-radius: 5px;
            background-color: #f2f2f2;
            padding: 5px;*/
        }


        .btn {
            align: center;

            border: 2px solid black;
            width: 150px;
            background-color: white;
            color: black;
            padding: 14px 28px;
            font-size: 16px;
            cursor: pointer;
            border-radius: 15px;
        }

        /* Green */
        .save {
            border-color: #4CAF50;
            color: green;
        }

        .save:hover {
            background-color: #4CAF50;
            color: white;
        }

        /* Red */
        .cancel {
            border-color: #f44336;
            color: red
        }

        .cancel:hover {
            background: #f44336;
            color: white;
        }


    </style>
</head>
<body>

<p><big><big><big><h1 align="center">Edit</h1></big></big></big></p>
<form action="/web/edit/${sensorId}" method="post" modelAttribute="sensorDto">
    <div class="container">
        <label for="sensorName">Name*</label>
        <input path="sensorName" minlength="3" maxlength="30" type="text" id="sensorName" name="sensorNameDto" placeholder=${sensor.sensorName} value="${sensor.sensorName}"/>
    </div>

    <div class="container">
        <label for="modelName">Model*</label>
        <input path="modelName" minlength="3" maxlength="15" type="text" id="modelName" name="modelNameDto" value="${sensor.descriptionSensor.modelName}"/>
    </div>

    <div class="container">
        <label>Range</label>
        <table>
            <tr>
                <th>
                    <input path="rangeFromSensor" type="number" id="rangeFromSensor" name="rangeFromSensorDto" value="${sensor.descriptionSensor.rangeFromSensor}"/>
                </th>
                <th>
                    <input path="rangeToSensor" type="number" id="rangeToSensor" name="rangeToSensorDto" value="${sensor.descriptionSensor.rangeToSensor}"/>
                </th>
        </table>
    </div>

    <div class="container">
        <label for="typeName">Type*</label>
        <select path="typeName" id="typeName" name="typeNameDto" value="${sensor.descriptionSensor.typeName}">
            <option value="Temperature">Temperature</option>
            <option value="Voltage">Voltage</option>
            <option value=Pressure>Pressure</option>
            <option value="Humidity">Humidity</option>
        </select>
    </div>
    <div class="container">
        <label for="unitName">Unit*</label>
        <select path="unitName" id="unitName" name="unitNameDto" value="${sensor.descriptionSensor.unitName}">
            <option value=C>C</option>
            <option value="voltage">voltage</option>
            <option value="bar">bar</option>
            <option value="%">%</option>
        </select>
    </div>
    <div class="container">
        <label for="locationName">Location</label>
        <input path="locationName" maxlength="40" type="text" id="locationName" name="locationSensorDto" value="${sensor.locationName}" />
    </div>
    <div class="container">
        <label for="descriptionSensor">Description</label>
        <input path="descriptionSensor" maxlength="200" type="text" id="descriptionSensor" name="descriptionSensorDto" value="${sensor.descriptionSensor.descriptionSensor}" style="height:100px"/>

    </div>
    <button class="btn save" type="submit" value="Save">Save</button>

</form>
<form action="/web">
    <div>
        <button class="btn cancel" type="submit" value="Cancel" align="right" >Cancel</button>
    </div>
</form>

</body>
</html>



