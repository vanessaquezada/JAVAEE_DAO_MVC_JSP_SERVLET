<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Administrar Personas</title>

        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>

        <!-- Popper JS -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">

        <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>

        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
    </head>
    <body>


        <div class="container">


            <a href="Persona?action=nuevo"  class="btn btn-primary mt-2"><span class="fas fa-plus"></span> Nuevo</a> <br><br>
            <h1 class="text-center mt-2"><span class="fas fa-table"></span> Lista  de Personas</h1>
            <table id="tdatos"  class="table">
                <thead>
                    <tr>
                        <th> ID</th>
                        <th> NOMBRE</th>
                        <th> APELLIDOS</th>
                        <th>EDAD</th>
                        <th>DIRECCION</th>

                        <th>ACCIONES</th>
                    </tr> 
                </thead>
                <tbody>
                    <c:forEach var="item" items="${lista}">
                        <tr>
                            <td><c:out value="${item.id}"/></td>
                            <td><c:out value="${item.nombre}"/></td>
                            <td><c:out value="${item.apellidos}"/></td>
                            <td><c:out value="${item.edad}"/></td>
                            <td><c:out value="${item.direccion}"/></td>

                            <td>
                                <a class="btn btn-warning mt-1" href="/JAVAEE_DAO_MVC_JSP_SERVLET/Persona?action=showedit&id=<c:out value="${item.id}" />"><span class="fas fa-pen"></span></a>
                                <a class="btn btn-danger mt-1" href="/JAVAEE_DAO_MVC_JSP_SERVLET/Persona?action=showEliminar&id=<c:out value="${item.id}"/>"><span class="fas fa-minus"></span></a>
                            </td>				
                        </tr>
                    </c:forEach>
                </tbody>

            </table>
        </div>

        <script>
            $(document).ready(function () {
                $('#tdatos').DataTable();
            });
        </script>
    </body>
</html>
