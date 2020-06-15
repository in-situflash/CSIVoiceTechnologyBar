<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
         pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <title>${title}</title>
        <style type="text/css">
            h1 {font-family:Tahoma,Arial,sans-serif;color:white;background-color:#525D76;font-size:22px;}
            h2 {font-family:Tahoma,Arial,sans-serif;color:white;background-color:#525D76;font-size:16px;}
            h3 {font-family:Tahoma,Arial,sans-serif;color:white;background-color:#525D76;font-size:14px;}
            body {font-family:Tahoma,Arial,sans-serif;color:black;background-color:white;}
            b {font-family:Tahoma,Arial,sans-serif;color:white;background-color:#525D76;}
            p {font-family:Tahoma,Arial,sans-serif;background:white;color:black;font-size:12px;}
            a {color:black;}
            a.name {color:black;}
            .line {height:1px;background-color:#525D76;border:none;}
        </style>
    </head>
    <body>
        <h1>${title}</h1>
        <hr class="line">
            <p><b>Type</b>  ${type}</p>
            <p><b>Message</b>  ${msg}</p>
            <p><b>Description</b>  ${desc}</p>
    </body>
</html>
