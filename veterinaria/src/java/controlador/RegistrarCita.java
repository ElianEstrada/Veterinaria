/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import datos.CitaBD;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.MessageFormat;
import model.Cita;
/*import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;*/

/**
 *
 * @author elian_estrada
 */
@WebServlet(name = "registrarCita", urlPatterns = {"/registrarCita"})
public class RegistrarCita extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Cita</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Cita at " + request.getContextPath() + "</h1>");
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
        
        try {
            
            String nombreMascota = request.getParameter("nombreMascota");
            String especie = request.getParameter("especie");
            String fecha = request.getParameter("fecha");
            String horaInicio = request.getParameter("horaInicio");
            String horaFin = request.getParameter("horaFin");
            int idCliente = Integer.parseInt(request.getParameter("idCliente"));
            
            System.out.println(MessageFormat.format(
                    "{0} - {1} - {2} - {3}:{4} - {5}", 
                    nombreMascota,
                    especie,
                    fecha,
                    horaInicio,
                    horaFin,
                    idCliente
            ));
            
            Cita cita = new Cita(nombreMascota, especie, fecha, horaInicio, horaFin, idCliente);
            
            CitaBD citaBD = new CitaBD();
            
            if (!citaBD.validarHorario(cita)) {
                System.out.println("Ya existe una cita en ese horario");
                request.setAttribute("errorCita", cita);
                request.getRequestDispatcher("./ErrorCita.jsp").forward(request, response);
                return;
            }
            
            if (citaBD.crearCita(cita)) {
                System.out.println("Cita agendada exitosamente");
                response.sendRedirect("./InicioCliente.jsp");
            } else {
                System.out.println("La cita no se pudo agendar en la base de datos :'(");
                request.setAttribute("errorCita", cita);
                request.getRequestDispatcher("./ErrorCita.jsp").forward(request, response);
            }
            
        } catch (Exception e) {
            System.out.println("Error al crear cita: " + e.getMessage());
            e.getStackTrace();
        }
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
