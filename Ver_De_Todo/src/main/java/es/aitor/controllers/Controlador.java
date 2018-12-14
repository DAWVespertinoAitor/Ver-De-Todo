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
     * Servlet controlador, se encarga de toda la navegación y la logica que conlleva
     * cada una de las secciones.
     * Seccion inicio: te redirige a inicio.jsp
     * Seccion video: obtiene los videos de los canales a los que estas suscrito
     * y a los que no estas suscrito
     * Seccion series: obtiene las series de los canales a los que estas suscrito
     * y a los que no estas suscrito
     * Seccion peliculas: obtiene las peliculas de los canales a los que estas suscrito
     * y a los que no estas suscrito
     * 
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
        List<Usuario> listaOtrosCanales = (List<Usuario>) sesion.getAttribute("canalesNoSuscritos");
        List<Serie> listaSeries = new ArrayList();
        List<Pelicula> listaPeliculas = new ArrayList();
        List<Video> listaVideos = new ArrayList();
        Usuario usuario = (Usuario) sesion.getAttribute("usuario");

        switch (direccion) {
            case "inicio":
                url = "JSP/inicio.jsp";
                break;
            case "videos":
                url = "JSP/videos.jsp";
                if (listaCanales.size() > 0) {
                    for (int i = 0; i < listaCanales.size(); i++) {
                        List<Video> listaVideo = (List<Video>) gdao.getVideos(listaCanales.get(i).getIdUsuario());
                        listaCanales.get(i).setListaVideos(listaVideo);
                    }
                }
                for (int i = 0; i < listaOtrosCanales.size(); i++) {
                    List<Video> listaVideo = (List<Video>) gdao.getVideos(listaOtrosCanales.get(i).getIdUsuario());
                    listaOtrosCanales.get(i).setListaVideos(listaVideo);
                }
                sesion.setAttribute("canales", listaCanales);
                sesion.setAttribute("canalesNoSuscritos", listaOtrosCanales);
                break;
            case "series":
                url = "JSP/series.jsp";
                for (int i = 0; i < listaCanales.size(); i++) {
                    List<Serie> listaSerie = (List<Serie>) gdao.getSeries(listaCanales.get(i).getIdUsuario());
                    listaCanales.get(i).setListaSeries(listaSerie);
                }
                for (int i = 0; i < listaOtrosCanales.size(); i++) {
                    List<Serie> listaSerie = (List<Serie>) gdao.getSeries(listaOtrosCanales.get(i).getIdUsuario());
                    listaOtrosCanales.get(i).setListaSeries(listaSerie);
                }
                sesion.setAttribute("canales", listaCanales);
                sesion.setAttribute("canalesNoSuscritos", listaOtrosCanales);
                break;
            case "peliculas":
                url = "JSP/peliculas.jsp";
                for (int i = 0; i < listaCanales.size(); i++) {
                    List<Pelicula> listaPelicula = (List<Pelicula>) gdao.getPeliculas(listaCanales.get(i).getIdUsuario());
                    listaCanales.get(i).setListaPeliculas(listaPelicula);
                }
                for (int i = 0; i < listaOtrosCanales.size(); i++) {
                    List<Pelicula> listaPelicula = (List<Pelicula>) gdao.getPeliculas(listaOtrosCanales.get(i).getIdUsuario());
                    listaOtrosCanales.get(i).setListaPeliculas(listaPelicula);
                }
                sesion.setAttribute("canales", listaCanales);
                sesion.setAttribute("canalesNoSuscritos", listaOtrosCanales);
                break;
            case "miCuenta":
                url = "JSP/cuenta.jsp";
                break;
            case "cerrarSesion":
                sesion.invalidate();
                url = "index.jsp";
                break;
            case "informacionMiCuenta":
                usuario = (Usuario) gdao.getOne(usuario.getIdUsuario(), Usuario.class);
                sesion.setAttribute("informacionMiUsuario", usuario);
                url = "JSP/miInformacion.jsp";
                break;
            case "misPeliculas":
                listaPeliculas = gdao.getTodasPeliculas(usuario.getIdUsuario());
                sesion.setAttribute("misPeliculas", listaPeliculas);
                url = "JSP/misPeliculas.jsp";
                break;
            case "misSeries":
                listaSeries = gdao.getBuscarSeries(usuario.getIdUsuario());
                sesion.setAttribute("misSeries", listaSeries);
                url = "JSP/misSeries.jsp";
                break;
            case "temporadasSerie":
                String nombreSerie = request.getParameter("nombreSerie");
                List<Serie> serieEscogida = gdao.getTraerSerie(nombreSerie, usuario.getIdUsuario());
                sesion.setAttribute("serieObtenida", serieEscogida);
                url = "JSP/temporadasSerie.jsp";
                break;
            case "capitulosTemporada":
                String temporadaNumero = request.getParameter("temporadaNumero");
                serieEscogida = (List<Serie>) sesion.getAttribute("serieObtenida");
                List<Serie> capitulosTemporada = new ArrayList();
                for (int i = 0; i < serieEscogida.size(); i++) {
                    if (serieEscogida.get(i).getTemporada().equals(temporadaNumero)) {
                        capitulosTemporada.add(serieEscogida.get(i));
                    }
                }
                sesion.setAttribute("capitulosTemporada", capitulosTemporada);
                url = "JSP/capitulosTemporada.jsp";
                break;
            case "misVideos":
                listaVideos = gdao.getTodosVideos(usuario.getIdUsuario());
                sesion.setAttribute("misVideos", listaVideos);
                url = "JSP/misVideos.jsp";
                break;
            case "verPeliculasCanal":
                Usuario usuarioVerCanal = (Usuario) sesion.getAttribute("usuarioVerCanal");
                listaPeliculas = gdao.getTodasPeliculas(usuarioVerCanal.getIdUsuario());
                sesion.setAttribute("peliculasCanal", listaPeliculas);
                url = "JSP/verPeliculasCanal.jsp";
                break;
            case "verSeriesCanal":
                usuarioVerCanal = (Usuario) sesion.getAttribute("usuarioVerCanal");
                listaSeries = gdao.getBuscarSeries(usuarioVerCanal.getIdUsuario());
                sesion.setAttribute("seriesCanal", listaSeries);
                url = "JSP/verSeriesCanal.jsp";
                break;
            case "temporadasSerieCanal":
                String nombreSerieCanal = request.getParameter("nombreSerieCanal");
                usuarioVerCanal = (Usuario) sesion.getAttribute("usuarioVerCanal");
                List<Serie> serieEscogidaCanal = gdao.getTraerSerie(nombreSerieCanal, usuarioVerCanal.getIdUsuario());
                sesion.setAttribute("serieObtenidaCanal", serieEscogidaCanal);
                url = "JSP/temporadasSerieCanal.jsp";
                break;
            case "capitulosTemporadaCanal":
                String temporadaNumeroCanal = request.getParameter("temporadaNumeroCanal");
                usuarioVerCanal = (Usuario) sesion.getAttribute("usuarioVerCanal");
                serieEscogidaCanal = (List<Serie>) sesion.getAttribute("serieObtenidaCanal");
                List<Serie> capitulosTemporadaCanal = new ArrayList();
                for (int i = 0; i < serieEscogidaCanal.size(); i++) {
                    if (serieEscogidaCanal.get(i).getTemporada().equals(temporadaNumeroCanal)) {
                        capitulosTemporadaCanal.add(serieEscogidaCanal.get(i));
                    }
                }
                sesion.setAttribute("capitulosTemporadaCanal", capitulosTemporadaCanal);
                url = "JSP/capitulosTemporadaCanal.jsp";
                break;
            case "verVideosCanal":
                usuarioVerCanal = (Usuario) sesion.getAttribute("usuarioVerCanal");
                listaVideos = gdao.getTodosVideos(usuarioVerCanal.getIdUsuario());
                sesion.setAttribute("videosCanal", listaVideos);
                url = "JSP/verVideosCanal.jsp";
                break;
            case "subirArchivo":
                listaSeries = gdao.getBuscarSeries(usuario.getIdUsuario());
                sesion.setAttribute("misSeries", listaSeries);
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
            case "verCanal":
                int idVerCanal = Integer.valueOf(request.getParameter("idVerCanal"));
                usuarioVerCanal = (Usuario) gdao.getOne(idVerCanal, Usuario.class);
                sesion.setAttribute("usuarioVerCanal", usuarioVerCanal);
                url = "JSP/verCanal.jsp";
                break;
            case "verPelicula":
                int idPelicula = Integer.valueOf(request.getParameter("idPelicula"));
                Pelicula pelicula = (Pelicula) gdao.getOne(idPelicula, Pelicula.class);
                sesion.setAttribute("verPelicula", pelicula);
                url = "JSP/verPelicula.jsp";
                break;
            case "verSerie":
                int idSerie = Integer.valueOf(request.getParameter("idCapitulo"));
                Serie serie = (Serie) gdao.getOne(idSerie, Serie.class);
                sesion.setAttribute("verSerie", serie);
                url = "JSP/verSerie.jsp";
                break;
            case "verVideo":
                int idVideo = Integer.valueOf(request.getParameter("idVideo"));
                Video video = (Video) gdao.getOne(idVideo, Video.class);
                sesion.setAttribute("verVideo", video);
                url = "JSP/verVideo.jsp";
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
