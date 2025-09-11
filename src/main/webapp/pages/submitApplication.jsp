<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Submit Loan Application</title>
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
        input[type="text"], input[type="number"], select {
            width: 100%;
            padding: 8px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        button {
            width: 100%;
            padding: 10px;
            background-color: #28a745;
            color: white;
            border: none;
            border-radius: 4px;
            font-size: 16px;
            cursor: pointer;
        }
        button:hover {
            background-color: #218838;
        }
        .message {
            text-align: center;
            margin-top: 20px;
            padding: 10px;
            background-color: #d4edda;
            color: #155724;
            border: 1px solid #c3e6cb;
            border-radius: 4px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>New Loan Application</h1>
        <p th:if="${message}" class="message" th:text="${message}"></p>
        <form th:action="@{/appli}" th:object="${loanApplication}" method="post">
            <div>
                <label for="companyName">Company Name:</label>
                <input type="text" id="companyName" th:field="*{companyName}" required />
            </div>
            <div>
                <label for="loanType">Loan Type:</label>
                <select id="loanType" th:field="*{loanType}" required>
                    <option value="">--Select Loan Type--</option>
                    <option value="Term Loan">Term Loan</option>
                    <option value="Working Capital">Working Capital</option>
                    <option value="Line of Credit">Line of Credit</option>
                    <option value="Equipment Financing">Equipment Financing</option>
                </select>
            </div>
            <div>
                <label for="loanAmount">Loan Amount:</label>
                <input type="number" id="loanAmount" th:field="*{loanAmount}" required />
            </div>
            <div>
                <button type="submit">Submit Application</button>
            </div>
        </form>
    </div>
</body>
</html>