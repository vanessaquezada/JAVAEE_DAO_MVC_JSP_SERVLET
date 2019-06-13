/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pruebas;

import com.Modelos.Persona;
import com.dao.PersonaDaoImplJDBC;
import com.dao.PersonaDaoImplLocal;
import com.idao.IPersonaDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author FIGTE
 */
public class Ejemplo extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
      IPersonaDao persona=new PersonaDaoImplJDBC();
      
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
      
        
                
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
                out.println("<head>");
                    out.println("<title>Servlet Suma de dos numeros</title>");     
                    out.println("  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\">"); 
                    out.println(" <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js\"></script>");
                    out.println(" <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\"></script>");
                    out.println(" <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\"></script>");
                out.println("</head>");
                out.println("<body>");
                    out.println("<h1 class='text-center'>Registros</h1>");
                    out.println("<table class='table'>");
                        out.println("<tr>");
                             out.println("<th>Nombre</th>");
                             out.println("<th>Apellidos</th>");
                             out.println("<th>Edad</th>");
                             out.println("<th>Direccion</th>");

                         out.println("</tr>");
                    for (Persona c : persona.obtenerClientes()) {
                        out.println("<tr>");
                            out.println("<td>"+c.getNombre()+"</td>"); 
                            out.println("<td>"+c.getApellidos()+"</td>"); 
                            out.println("<td>"+c.getEdad()+"</td>"); 
                            out.println("<td>"+c.getDireccion()+"</td>");  
                        out.println("</tr>");
                    }
                    out.println("</table>");
                out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
      // processRequest(request, response, request.getParameter("n1"),request.getParameter("n2"));
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
