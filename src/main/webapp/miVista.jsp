
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>

        <!-- Popper JS -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        
        <title>JSP Page</title>
    </head>
    <body>
       
        <div class="container">
            
            
            <div class="row">
                
                <div class="col-md-6">
                     <h1 class="text-center">Datos del registro</h1>
        
                    <table class="table">
                        <thead>
                            <tr>
                                <th>Nombre</th>
                                <th>Apellidos</th>
                                <th>Edad</th>
                                <th>Direccion</th>
                            </tr>
                        </thead>
                        <tbody>


                        </tbody>
                    </table>
        
                </div>
                <div class="col-md-6">
                    <h1 class="text-center">Formulario de Registro.</h1>
                    
                    <form>
                        <div class="form-group">
                            <label>Nombre</label>
                            <input type="text" name="nombre">
                        </div>
                    </form>
                </div> 
            </div>
            
        </div>
        
        
    </body>
</html>
