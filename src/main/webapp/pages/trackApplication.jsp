<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Track Application</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 40px;
            background-color: #f4f4f4;
        }
        .container {
            background: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            max-width: 600px;
            margin: 0 auto;
        }
        h1 {
            text-align: center;
            color: #333;
        }
        form div {
            margin-bottom: 15px;
        }
        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }
        input[type="number"], input[type="text"] {
            width: 100%;
            padding: 8px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        button {
            width: 100%;
            padding: 10px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 4px;
            font-size: 16px;
            cursor: pointer;
        }
        button:hover {
            background-color: #0056b3;
        }
        .result, .error {
            margin-top: 20px;
            padding: 15px;
            border-radius: 4px;
        }
        .result {
            background-color: #e2f3e8;
            border: 1px solid #c6e0d2;
        }
        .error {
            background-color: #f8d7da;
            border: 1px solid #f5c6cb;
            color: #721c24;
        }
        .result p, .error p {
            margin: 0;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Track Your Application</h1>
        <form th:action="@{/track}" method="get">
            <div>
                <label for="applicationId">Application ID:</label>
                <input type="number" id="applicationId" name="applicationId" required />
            </div>
            <div>
                <label for="companyName">Company Name:</label>
                <input type="text" id="companyName" name="companyName" required />
            </div>
            <div>
                <button type="submit">Track Status</button>
            </div>
        </form>

        <div th:if="${trackInfo}" class="result">
            <h3>Application Status</h3>
            <p><strong>Application ID:</strong> <span th:text="${trackInfo.applicationId}"></span></p>
            <p><strong>Company Name:</strong> <span th:text="${trackInfo.companyName}"></span></p>
            <p><strong>Status:</strong> <span th:text="${trackInfo.status}"></span></p>
        </div>

        <div th:if="${error}" class="error">
            <p th:text="${error}"></p>
        </div>
    </div>
</body>
</html>