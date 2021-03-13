<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


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

<p><big><big><big><h1 align="center">Add/Edit</h1></big></big></big></p>
<form action="/web/sensor/add" method="post" modelAttribute="sensorDto">
    <div class="container">
        <label for="sensorName">Name*</label>
        <input type="text" id="sensorName" name="sensorNameDto" placeholder="Name">
    </div>

    <div class="container">
        <label for="modelName">Model*</label>
        <input type="text" id="modelName" name="modelNameDto" placeholder="Model">
    </div>

    <div class="container">
        <label>Range</label>
        <table>
            <tr>
                <th>
                    <input type="number" id="rangeFromSensor" name="rangeFromSensorDto" placeholder="from">
                </th>
                <th>
                    <input type="number" id="rangeToSensor" name="rangeToSensorDto" placeholder="to">
                </th>
        </table>
    </div>

    <div class="container">
        <label for="typeNameDto">Type*</label>
        <select id="typeNameDto" name="typeNameDto">
            <option value="1">Temperature</option>
            <option value="2">Voltage</option>
            <option value="3">Pressure</option>
            <option value="4">Humidity</option>
        </select>
    </div>
    <div class="container">
        <label for="unitNameDto">Unit*</label>
        <select id="unitNameDto" name="unitNameDto">
            <option value="1">&#8451;</option>
            <option value="2">voltage</option>
            <option value="3">bar</option>
            <option value="4">&#8240;</option>
        </select>
    </div>
    <div class="container">
        <label for="locationSensor">Location</label>
        <input type="text" id="locationSensor" name="locationSensorDto" placeholder="location">
    </div>
    <div class="container">
        <label for="descriptionSensor">Description</label>
        <input type="text" id="descriptionSensor" name="descriptionSensorDto" placeholder="Enter description sensor" style="height:100px">

    </div>
    <button class="btn save" type="submit" value="Save">Save</button>
    <button class="btn cancel" type="submit" value="Cancel" align="right" href="/web">Cancel</button>
</form>

</body>
</html>



