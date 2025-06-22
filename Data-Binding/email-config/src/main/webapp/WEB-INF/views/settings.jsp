<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Settings</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            margin: 0;
            padding: 20px;
        }
        h2 {
            color: #1a3c6d;
            text-align: center;
            margin-bottom: 25px;
            font-size: 28px;
            font-weight: 700;
            text-transform: uppercase;
            letter-spacing: 1px;
            border-bottom: 2px solid #007bff;
            padding-bottom: 8px;
        }
        form {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 400px;
        }
        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
            color: #555;
        }
        select, textarea {
            width: 100%;
            padding: 8px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 14px;
            box-sizing: border-box;
        }
        select:focus, textarea:focus {
            border-color: #007bff;
            outline: none;
            box-shadow: 0 0 5px rgba(0, 123, 255, 0.3);
        }
        textarea {
            resize: vertical;
        }
        .checkbox-container {
            margin-bottom: 15px;
            display: flex;
            align-items: center;
        }
        .checkbox-container input[type="checkbox"] {
            margin-right: 8px;
        }
        input[type="submit"] {
            background-color: #007bff;
            color: #fff;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
            width: 100%;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
        .form-group {
            margin-bottom: 15px;
        }
    </style>
</head>
<body>
<form:form modelAttribute="settings" method="post">
    <h2>Settings</h2>
    <div class="form-group">
        <label>Languages:</label>
        <form:select path="language">
            <form:options items="${languages}"/>
        </form:select>
    </div>

    <div class="form-group">
        <label>Page Size:</label>
        <form:select path="pageSize">
            <form:options items="${pageSizes}"/>
        </form:select>
        <span>emails per page</span>
    </div>

    <div class="form-group checkbox-container">
        <form:checkbox path="spamFilter"/>
        <label>Enable spams filter</label>
    </div>

    <div class="form-group">
        <label>Signature:</label>
        <form:textarea path="signature" rows="4" cols="40"/>
    </div>

    <input type="submit" value="Update"/>
</form:form>
</body>
</html>