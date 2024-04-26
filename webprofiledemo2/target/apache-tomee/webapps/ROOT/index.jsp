<%@ page session="false" %>

<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"; rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>

<%@ include file="header.jsp"%>
<div class="container my-5">
<div class="p-5 text-center bg-body-tertiary rounded-3">

<p class="lead">
<%= (String)application.getAttribute("message") %>
</p>
</div>
</div>

<%@ include file="footer.jsp"%>


</body>
</html>