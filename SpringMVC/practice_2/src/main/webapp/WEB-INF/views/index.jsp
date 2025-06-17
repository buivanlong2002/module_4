<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
    table {
        border: 1px solid black;
        border-collapse: collapse;
    }
    th, td {
        border: 1px dotted #555;
        padding: 5px 10px;
    }
</style>

<h2>Customer List</h2>
There are ${customers.size()} customers.
<table>
    <thead>
    <tr>
        <th>Id</th><th>Name</th><th>Email</th><th>Address</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="c" items="${customers}">
        <tr>
            <td>${c.id}</td>
            <td><a href="customer?id=${c.id}">${c.name}</a></td>
            <td>${c.email}</td>
            <td>${c.address}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
