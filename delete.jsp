<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Policy</title>
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
    color: #333;
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
    color: #666;
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

  /* Multicolor styling */
  label {
    color: #ff6666; /* Red */
  }

  input[type="text"] {
    border-color: #ffcc66; /* Yellow */
  }

  input[type="submit"] {
    background-color: #6699ff; /* Blue */
  }

  input[type="submit"]:hover {
    background-color: #3366ff; /* Dark Blue */
  }
</style>
</head>
<body>

<h1>Delete Policy</h1>

<form action="DeleteServlet" method="post">
  <label for="id">Policy ID:</label>
  <input type="text" id="id" name="id">
  <input type="submit" value="Delete">
</form>

</body>
</html>
