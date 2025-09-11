<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Loan Origination System</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 40px;
            background-color: #f4f4f4;
            text-align: center;
        }
        .container {
            background: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            display: inline-block;
        }
        h1 {
            color: #333;
        }
        ul {
            list-style-type: none;
            padding: 0;
        }
        li {
            margin: 10px 0;
        }
        a {
            text-decoration: none;
            color: #007bff;
            font-weight: bold;
            padding: 10px 20px;
            border: 1px solid #007bff;
            border-radius: 5px;
            transition: background-color 0.3s, color 0.3s;
        }
        a:hover {
            background-color: #007bff;
            color: white;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Welcome to the Corporate Banking Loan Origination System</h1>
        <p>Please select an option to proceed:</p>
        <ul>
            <li>
                <a th:href="@{/submitApplicationPage}">Submit a New Loan Application</a>
            </li>
            <li>
                <a th:href="@{/trackApplicationPage}">Track an Existing Application</a>
            </li>
            <li>
                <a th:href="@{/viewApplicationPage}">View an Application by ID</a>
            </li>
        </ul>
    </div>
</body>
</html>