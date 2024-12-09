<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
        .success
        {
        color: green;
        }
        .failure
        {
        color: red;
        }
        
        


</style>
</head>
<body>

<div class="form-container">
        <h1>Pentagon Space</h1>
        <p>Application Form</p>
        
        <%String success=(String)request.getAttribute("success");
        if(success!=null){%>
        <h3 class="success"><%=success%></h3>
        <%} %>
        
        
         
        <%String failure=(String)request.getAttribute("failure");
        if(failure!=null){%>
        <h3 class="failure"><%=failure%></h3>
        <%} %>
        
        
        
        
        
        <form action="applicationform" method="post">
            <input type="text" name="name" placeholder="Enter your Name"required>
            <input type="text" name="phone" placeholder="Enter the Phone number" required>
            <input type="text" name="email" placeholder="Enter the Mail ID" required>
            
          select branch <select name="branch">
          <option>CSE</option>
          <option>ISE</option>
          <option>ECE</option>
          <option>ME</option>
          <option>CIVIL</option>
          </select>
          
            <input type="text" name="location" placeholder="Enter the Location" required>
            <input type="password" name="password" placeholder="Enter the password" required>
            <input type="password" name="confirm_password" placeholder="Confirm the password" required>
            <button type="submit">Create Account</button>
        </form>
        <div class="footer">
            <span>Already have an account? <a href="login.html">Login</a></span>
        </div>
    </div>



</body>
</html>







