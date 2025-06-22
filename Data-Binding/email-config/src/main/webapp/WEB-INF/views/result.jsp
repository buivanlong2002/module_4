<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Settings Updated</title>
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
        .container {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 400px;
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
        p {
            margin: 10px 0;
            color: #555;
            font-size: 16px;
        }
        pre {
            background-color: #f8f9fa;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 14px;
            white-space: pre-wrap;
            word-wrap: break-word;
        }
        a {
            display: inline-block;
            margin-top: 15px;
            padding: 10px 15px;
            background-color: #007bff;
            color: #fff;
            text-decoration: none;
            border-radius: 4px;
            font-size: 16px;
            text-align: center;
            width: 100%;
            box-sizing: border-box;
        }
        a:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Updated Settings:</h2>
    <p>Language: ${settings.language}</p>
    <p>Page Size: ${settings.pageSize}</p>
    <p>Spam Filter: ${settings.spamFilter}</p>
    <p>Signature:<br/> <pre>${settings.signature}</pre></p>
    <a href="/settings">Back</a>
</div>
</body>
</html>