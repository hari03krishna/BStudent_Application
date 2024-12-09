<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Forgot Password</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #e0f7fa;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
    }
    .form-container {
        text-align: center;
        background-color: #ffffff;
        padding: 20px;
        border-radius: 10px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        width: 300px;
    }
    .form-container h1 {
        font-size: 24px;
        color: #004d99;
        margin-bottom: 10px;
    }
    .form-container p {
        font-size: 16px;
        margin-bottom: 20px;
    }
    .form-container input[type="text"],
    .form-container input[type="password"] {
        width: 100%;
        padding: 10px;
        margin: 10px 0;
        border: 1px solid #ccc;
        border-radius: 5px;
    }
    .form-container button {
        background-color: #0077b6;
        color: white;
        padding: 10px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        width: 100%;
    }
    .form-container button:hover {
        background-color: #005f8b;
    }
    .form-container a {
        color: #0077b6;
        text-decoration: none;
        font-size: 14px;
    }
    .form-container a:hover {
        text-decoration: underline;
    }
    .form-container .footer {
        margin-top: 10px;
    }
</style>
</head>
<body>
    <div class="form-container">
        <h1>Pentagon Space</h1>
        <p>Forgot Password</p>
        <form action="forgotpassword" method="post">
         <% String success = (String) request.getAttribute("success"); 
           if (success != null) { %>
           <h1 style="color: green"><%= success %></h1>
        <% } %>
        
        <% String failure = (String) request.getAttribute("failure"); 
           if (failure != null) { %>
           <h1 style="color: red"><%= failure %></h1>
        <% } %>
        
            <input type="text" name="email" placeholder="Enter your registered mail ID" required>
            <input type="text" name="phone" placeholder="Enter your registered phone number" required>
            <input type="password" name="new_password" placeholder="Enter new password" required>
            <input type="password" name="confirm_password" placeholder="Confirm new password" required>
            <button type="submit">Reset Password</button>
        </form>
        <div class="footer">
            <a href="login.jsp">Back to Login</a>
        </div>
    </div>
</body>
</html>
