<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List of members</title>
</head>
<body>
<h1>Welcome to the club</h1>

<h3>New member</h3>
<form action="/members" method="post">
    <table style="width: 25%">
        <tr>
            <td>Name</td>
            <td><input type="text" name="name" /></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><input type="text" name="email" /></td>
        </tr>
    </table>
    <input type="submit" value="Add" />
</form>

<h3>Members</h3>

<table style="border: 1px solid black; width: 75%;">
    <thead>
    <tr>
        <th style="border: 1px solid black;">#   </th>
        <th style="border: 1px solid black;">Name</th>
        <th style="border: 1px solid black;">Email</th>
        <th style="border: 1px solid black;">Registration Date</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="member" items="${allMembers}" varStatus="loop">
        <tr style="border: 1px solid black;">
            <td style="border: 1px solid black;">${loop.index}</td>
            <td style="border: 1px solid black;"><strong>${member.name}</strong></td>
            <td style="border: 1px solid black;">${member.email}</td>
            <td style="border: 1px solid black;">${member.creationDate}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>