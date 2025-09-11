<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>View Application</title>
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
        input[type="number"] {
            width: 100%;
            padding: 8px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        button {
            width: 100%;
            padding: 10px;
            background-color: #3c923f;
            color: white;
            border: none;
            border-radius: 4px;
            font-size: 16px;
            cursor: pointer;
        }
        button:hover {
            background-color: #2c722e;
        }
        .details, .error {
            margin-top: 20px;
            padding: 15px;
            border-radius: 4px;
        }
        .details {
            background-color: #f0f8ff;
            border: 1px solid #bce2f8;
        }
        .details p {
            margin: 0 0 10px 0;
        }
        .error {
            background-color: #f8d7da;
            border: 1px solid #f5c6cb;
            color: #721c24;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>View Application Details</h1>
        <form th:action="@{/view}" method="get">
            <div>
                <label for="applicationId">Application ID:</label>
                <input type="number" id="applicationId" name="applicationId" required />
            </div>
            <div>
                <button type="submit">View Details</button>
            </div>
        </form>

        <div th:if="${application}" class="details">
            <h3>Application Details</h3>
            <p><strong>Application ID:</strong> <span th:text="${application.applicationId}"></span></p>
            <p><strong>Company Name:</strong> <span th:text="${application.companyName}"></span></p>
            <p><strong>Loan Type:</strong> <span th:text="${application.loanType}"></span></p>
            <p><strong>Loan Amount:</strong> <span th:text="${application.loanAmount}"></span></p>
            <p><strong>Status:</strong> <span th:text="${application.status}"></span></p>
            <p><strong>Submission Date:</strong> <span th:text="${application.submissionDate}"></span></p>
        </div>

        <div th:if="${error}" class="error">
            <p th:text="${error}"></p>
        </div>
    </div>
</body>
</html>