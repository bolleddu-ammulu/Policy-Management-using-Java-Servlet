<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Success</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 0;
    }
    
    h1, h2 {
        text-align: center;
    }
    
    .container {
        max-width: 600px;
        margin: 50px auto;
        padding: 20px;
        background-color: #fff;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    
    form {
        display: flex;
        flex-direction: column;
        align-items: center;
    }
    
    a {
        display: inline-block;
        margin: 10px;
        padding: 10px 20px;
        text-decoration: none;
        color: #fff;
        background-color: #007bff;
        border-radius: 4px;
        transition: background-color 0.3s ease;
    }
    4
    a:hover {
        background-color: #0056b3;
    }
</style>
</head>
<body>
    <div class="container">
        <h1>Welcome USER</h1>
        
        <form>
            <a href="add.jsp">Add Policy</a>
            <a href="delete.jsp">Delete Policy</a>
            <a href="update.jsp">Update Policy</a>
            <a href="ViewServlet">View Policy</a>
        </form>
    </div>
</body>
</html>
