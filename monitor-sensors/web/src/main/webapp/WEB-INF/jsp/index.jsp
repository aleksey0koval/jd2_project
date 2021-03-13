<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
        body {font-family: Arial, Helvetica, sans-serif;}

        /* Full-width input fields */
        input[type=text], input[type=password] {
            width: 100%;
            padding: 12px 20px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            box-sizing: border-box;
        }

        form {
            /* Расположим форму по центру страницы */
            margin: 0 auto;
            width: 500px;

            margin-top: 100px;	/* Отступ сверху */
            /* Определим контур формы */
            padding: 1em;
            border: 1px solid #CCC;
            border-radius: 1em;
        }

        /* Set a style for all buttons */
        button {
            background-color: #4CAF50;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            cursor: pointer;
            width: 100%;
        }

    </style>
</head>
<body>

<form action="/web/sensor">
    <h1 align="center">Login Form</h1>
    <h6 align="center">enter login and password for access</h6>

    <div class="container">
        <label for="username"><b>Login</b></label>
        <input type="text" id="username" class="form-control" placeholder="Enter login" name="username" required>
        <label for="password"><b>Password</b></label>
        <input type="password" id="password" class="form-control" placeholder="Your Password" name="password" required>

        <button class="btn btn-lg btn-primary btn block" type="submit">Sign in</button>

    </div>


</form>
</body>
</html>



