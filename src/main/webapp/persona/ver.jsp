<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Administrar Personas</title>

       <%@include file="../componentes/asset.jspf" %>
    </head>
    <body>


        <div class="container">


            <a href="Persona?action=nuevo"  class="btn btn-primary mt-2"><span class="fas fa-plus"></span> Nuevo</a> <br><br>
            <h1 class="text-center mt-2"><span class="fas fa-table"></span> Lista  de Personas</h1>
            <table id="tdatos"  class="table table-striped table-bordered table-hover" style="width:100%">
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
