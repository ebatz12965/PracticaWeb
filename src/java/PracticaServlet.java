/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Edwing
 */
@WebServlet(urlPatterns = {"/PracticaServlet"})
public class PracticaServlet extends HttpServlet {
    PersonaClass persona;
    Persona registroPersona;
     PersonaClass[] personasRegistradas;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            persona = new PersonaClass(
                request.getParameter("code"),
                request.getParameter("name"),
                request.getParameter("address")
            );
            
            if(registroPersona==null){
                registroPersona = new Persona();
            }
           
            registroPersona.guardarPersona(persona);//almacenarlo en el array
             personasRegistradas= registroPersona.getPersona();
                       
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PracticaServlet</title>");   
            out.println("<title>Servlet NewServlet</title>");   
            out.println("<link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css' integrity='sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N' crossorigin='anonymous'>");
            out.println("<script src='https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js' integrity='sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct' crossorigin='anonymous'></script>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class=\"container\">");
            out.println("<div class='container-lg d-flex'> <a href='index.html' class=\"btn btn-success ml-auto\">Registrar Nuevo</a></div><br>");
            out.println("<table class=\"table table-hover table-striped\">");   
            out.println("<thead><tr> <th scope=\"col\">CODIGO</th> <th scope=\"col\">NOMBRE</th>\n" +
                                "<th scope=\"col\">DIRECCION</th></tr></thead>"); 
            out.println("<thead><tr> <th scope=\"col\">" +persona.getCode()+ "</th> <th scope=\"col\">" +persona.getName()+ "</th>\n" +
                                "<th scope=\"col\">" +persona.getAddress()+ "</th></tr></thead>"); 
            out.println("<tbody>");
            for (int i = 0; i < personasRegistradas.length; i++){
                    if(!personasRegistradas[i].getCode().isEmpty()){
                       out.println("<tr><td>" + personasRegistradas[i].getCode()+ "</td>");
                       out.println("<td>" + personasRegistradas[i].getName() + "</td>");
                       out.println("<td>" + personasRegistradas[i].getAddress()+ "</td>");
                       out.println("<td>"
                               + "<button type=\"button\" class=\"btn btn-warning\"></i>Editar</button> "
                               + "<button type=\"button\" class=\"btn btn-danger\">Eliminar</button>"
                               + "</td></tr>");
                    }
                }
            out.println("</div>");
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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
