/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.aitor.controllers;

import es.aitor.beans.Pelicula;
import es.aitor.beans.Programacion;
import es.aitor.beans.Serie;
import es.aitor.dao.IGenericoDAO;
import es.aitor.daofactory.DAOFactory;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "reproducirContenido", urlPatterns = {"/reproducirContenido"})
public class reproducirContenido extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * 
     * Este controlador, es llamado por ajax para obtener y reproducir el 
     * contenido programado por el usuario.
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession sesion = request.getSession(true);
        DAOFactory daof = DAOFactory.getDAOFactory();
        IGenericoDAO gdao = daof.getGenericoDAO();

        PrintWriter out = response.getWriter();
        int idProgramacion = Integer.valueOf(request.getParameter("idProgramacion"));

        int idContenido = 0;
        Pelicula pelicula = new Pelicula();
        Serie serie = new Serie();
        List<Programacion> listaProgramacion = (List<Programacion>) sesion.getAttribute("programacion");
        for (int i = 0; i < listaProgramacion.size(); i++) {
            if (listaProgramacion.get(i).getIdProgramacion() == idProgramacion) {
                if (listaProgramacion.get(i).getIdPelicula() != 0) {
                    idContenido = listaProgramacion.get(i).getIdPelicula();
                    pelicula = (Pelicula) gdao.getOne(idContenido, Pelicula.class);
                    out.println("<video src=\"http://127.0.0.1:8887/"+pelicula.getNombreArchivo());
                }
                if (listaProgramacion.get(i).getIdSerie() != 0) {
                    idContenido = listaProgramacion.get(i).getIdSerie();
                    serie = (Serie) gdao.getOne(idContenido, Serie.class);
                    out.println("<video src=\"http://127.0.0.1:8887/"+serie.getNombreArchivo());
                }
            }
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
