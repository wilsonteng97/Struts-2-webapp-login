<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>

    <body>
        <s:form action="login">
            <s:textfield label="Username" key="user.userID" />
            <s:password label="Password" key="user.password" />
            <s:if test='hasActionErrors()'>
                <s:actionerror />
            </s:if>
            <s:submit />
        </s:form>
    </body>

</html>