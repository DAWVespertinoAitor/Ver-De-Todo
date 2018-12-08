/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.aitor.controllers;

import es.aitor.beans.Programacion;
import es.aitor.beans.Usuario;
import es.aitor.dao.IGenericoDAO;
import es.aitor.daofactory.DAOFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author aitor
 */
@WebServlet(name = "EditarProg", urlPatterns = {"/EditarProg"})
public class EditarProg extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");

        HttpSession sesion = request.getSession(true);
        String url = null;

        DAOFactory daof = DAOFactory.getDAOFactory();
        IGenericoDAO gdao = daof.getGenericoDAO();

        int idProgramacion = (Integer) sesion.getAttribute("idProgramacion");
        String fechaReproduccion = request.getParameter("fechaReproduccion");
        String horaReproduccion = request.getParameter("horaReproduccion");
        Programacion programacion = new Programacion();
        Usuario usuario = (Usuario) sesion.getAttribute("usuario");
        List<Programacion> listaProgramacion = (List<Programacion>) sesion.getAttribute("programacion");
        
        Date fecha = Date.valueOf(fechaReproduccion);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        long hora = 0;
        
        try{
            hora = sdf.parse(horaReproduccion).getTime();
        } catch(ParseException pe){
            pe.addSuppressed(pe);
        }
        
        Time horaR = new Time(hora);
        
        programacion.setIdProgramacion(idProgramacion);
        programacion.setFechaReproduccion(fecha);
        programacion.setHoraReproduccion(horaR);
        
        for (int i = 0; i < listaProgramacion.size(); i++) {
            if(listaProgramacion.get(i).getIdProgramacion() == idProgramacion){
                programacion.setIdPelicula(listaProgramacion.get(i).getIdPelicula());
                programacion.setIdSerie(listaProgramacion.get(i).getIdSerie());
                programacion.setUsuario(usuario.getIdUsuario());
                if(!listaProgramacion.get(i).getFechaReproduccion().equals(fecha)){
                    listaProgramacion.get(i).setFechaReproduccion(fecha);
                } else if (!listaProgramacion.get(i).getHoraReproduccion().equals(horaR)){
                    listaProgramacion.get(i).setHoraReproduccion(horaR);
                }
            }
        }
        sesion.setAttribute("programacion", listaProgramacion);
        
        gdao.insertUpdate(programacion);
        response.sendRedirect("JSP/inicio.jsp");

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
        PrintWriter out = response.getWriter();
        HttpSession sesion = request.getSession(true);
        DAOFactory daof = DAOFactory.getDAOFactory();
        IGenericoDAO gdao = daof.getGenericoDAO();
        
        List<Programacion> listaProgramacion = (List<Programacion>) sesion.getAttribute("programacion");
        int id = Integer.valueOf(request.getParameter("idProg"));
        for(int i=0; i<listaProgramacion.size();i++){
            if(listaProgramacion.get(i).getIdProgramacion() == id){
                gdao.delete(listaProgramacion.get(i));
                listaProgramacion.remove(i);
            }
        }
        sesion.setAttribute("programacion", listaProgramacion);
        
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
