<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <link href="./styles/login.css" rel="stylesheet" type="text/css"/> 
    </head>

    <body>
        <header>
            <h1>CZ3002 Login Webapp</h1>
            <h3>By: Wilson Thurman Teng, Goh Jun Le, Chester Yeoh</h3>
        </header>

        <div class="container">
            <s:form action="login">
                <s:textfield label="Username" key="user.userID" />
                <s:password label="Password" key="user.password" />
                <s:submit />
            </s:form>
        </div>

        <s:if test='hasActionErrors()'>
            <s:actionerror />
        </s:if>

    </body>

</html>