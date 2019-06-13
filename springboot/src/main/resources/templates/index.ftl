<!DOCTYPE html>
<html>
<head lang="en">
<title>Spring Boot Example</title>
<link href="/static/css/index.css" rel="stylesheet">
<script type="text/javascript" src="/static/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="/static/js/index.js"></script>
</head>
<body>
    <h2>Test freemarker ~</h2>
    <font> 
        <#list userList as user> 
            ${user!}<br />
        </#list>
    </font>
    <button class="a"> click me</button>
</body>
</html>