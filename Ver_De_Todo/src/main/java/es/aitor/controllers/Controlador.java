/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.aitor.controllers;

import es.aitor.beans.Pelicula;
import es.aitor.beans.Programacion;
import es.aitor.beans.Serie;
import es.aitor.beans.Usuario;
import es.aitor.beans.Video;
import es.aitor.dao.IGenericoDAO;
import es.aitor.daofactory.DAOFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import static java.time.format.DateTimeFormatter.ISO_INSTANT;
import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE_TIME;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {

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

        String direccion = request.getParameter("direccion");
        HttpSession sesion = request.getSession(true);
        String url = null;

        DAOFactory daof = DAOFactory.getDAOFactory();
        IGenericoDAO gdao = daof.getGenericoDAO();

        List<Usuario> listaCanales = (List<Usuario>) sesion.getAttribute("canales");

        switch (direccion) {
            case "inicio":
                url = "JSP/inicio.jsp";
                break;
            case "videos":
                url = "JSP/videos.jsp";

                for (int i = 0; i < listaCanales.size(); i++) {
                    System.out.println("Estoy entrando");
                    List<Video> listaVideo = (List<Video>) gdao.getVideos(listaCanales.get(i).getIdUsuario());
                    listaCanales.get(i).setListaVideos(listaVideo);
                }
                sesion.setAttribute("canales", listaCanales);
                break;
            case "series":
                url = "JSP/series.jsp";
                for (int i = 0; i < listaCanales.size(); i++) {
                    List<Serie> listaSerie = (List<Serie>) gdao.getSeries(listaCanales.get(i).getIdUsuario());
                    listaCanales.get(i).setListaSeries(listaSerie);
                }
                sesion.setAttribute("canales", listaCanales);
                break;
            case "peliculas":
                url = "JSP/peliculas.jsp";
                for (int i = 0; i < listaCanales.size(); i++) {
                    System.out.println("ENTRO?");
                    List<Pelicula> listaPelicula = (List<Pelicula>) gdao.getPeliculas(listaCanales.get(i).getIdUsuario());
                    listaCanales.get(i).setListaPeliculas(listaPelicula);
                }
                sesion.setAttribute("canales", listaCanales);
                break;
            case "cuenta":
                url = "JSP/cuenta.jsp";
                break;
            case "subirArchivo":
                url = "JSP/subirArchivo.jsp";
                break;
            case "editarProgramacion":
                int idProgramacionEd = Integer.parseInt(request.getParameter("idProgramacion"));
                Programacion programacion = (Programacion) gdao.getOne(idProgramacionEd, Programacion.class);
                sesion.setAttribute("idProgramacion", idProgramacionEd);
                sesion.setAttribute("fechaRepro", programacion.getFechaReproduccion());
                sesion.setAttribute("horaRepro", programacion.getHoraReproduccion());
                url = "JSP/editarProgramacion.jsp";
                break;
            case "addProgramacion":
                int idArchivo = Integer.parseInt(request.getParameter("idArchivo"));
                String tipoArchivo = request.getParameter("tipoArchivo");
                sesion.setAttribute("idArchivo", idArchivo);
                sesion.setAttribute("archivoSeriePelicula", tipoArchivo);
                url = "JSP/anadirProgramacion.jsp";
                break;
        }
        response.sendRedirect(url);
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
