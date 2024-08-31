<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Policy</title>
<style>
  body {
    font-family: Arial, sans-serif;
    background-color: #f4f4f4;
    margin: 0;
    padding: 0;
  }

  h1 {
    text-align: center;
    margin-top: 50px;
  }

  form {
    width: 300px;
    margin: 0 auto;
    background-color: #fff;
    padding: 20px;
    border-radius: 8px;
    box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
  }

  label {
    display: block;
    margin-bottom: 5px;
    font-weight: bold;
  }

  input[type="text"] {
    width: calc(100% - 12px);
    padding: 6px;
    margin-bottom: 15px;
    border: 1px solid #ccc;
    border-radius: 4px;
  }

  input[type="submit"] {
    width: 100%;
    background-color: #4CAF50;
    color: white;
    padding: 10px 20px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
  }

  input[type="submit"]:hover {
    background-color: #45a049;
  }
</style>
</head>
<body>

<h1>Add Policy</h1>

<form action="AddServlet" method="post">
  <label for="id">ID:</label>
  <input type="text" id="id" name="id">
  <label for="name">Name:</label>
  <input type="text" id="name" name="name">
  <label for="amount">Amount:</label>
  <input type="text" id="amount" name="amount">
  <label for="premium">Premium:</label>
  <input type="text" id="premium" name="premium">
  <input type="submit" value="Add">
</form>

 

</body>
</html>
