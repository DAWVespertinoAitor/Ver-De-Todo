/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.aitor.controllers;

import es.aitor.beans.Pelicula;
import es.aitor.beans.Serie;
import es.aitor.beans.Usuario;
import es.aitor.beans.Video;
import es.aitor.dao.IGenericoDAO;
import es.aitor.daofactory.DAOFactory;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import org.apache.commons.beanutils.BeanUtils;

/**
 *
 * @author aitor
 *
 */
@MultipartConfig
@WebServlet(name = "SubirArchivo", urlPatterns = {"/SubirArchivo"})
public class SubirArchivo extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods. 
     * 
     * Este metodo se encarga de la obtención de los datos del
     * contenido a subir crea un token para que el nombre del archivo no se
     * repita dentro del servidor y sube a base de datos las credenciales
     * obtenidas.
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String url = null;

        HttpSession sesion = request.getSession(true);
        Usuario usuario = new Usuario();
        usuario = (Usuario) sesion.getAttribute("usuario");

        System.out.println("Usuario jeje " + usuario.getIdUsuario());

        DAOFactory daof = DAOFactory.getDAOFactory();
        IGenericoDAO gdao = daof.getGenericoDAO();

        //Bean
        Pelicula pelicula = new Pelicula();
        Serie serie = new Serie();
        Video video = new Video();

        String codigo = null;
        String tipoArchivo = request.getParameter("tipoArchivo");

        Part filePart = request.getPart("archivo"); // Obtiene el archivo
        Part filePartPortada = request.getPart("archivoPortada"); // Obtiene la portada

        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
        String fileNamePortada = Paths.get(filePartPortada.getSubmittedFileName()).getFileName().toString(); // MSIE fix.

        //InputStream fileContent = filePart.getInputStream(); //Lo transforma en InputStream
        String path = "/archivos/";

        File uploads = new File(path); //Carpeta donde se guardan los archivos

        uploads.mkdirs(); //Crea los directorios necesarios

        File file = null;
        File filePortada = null;
        Timestamp fechaDeSubida = null;
        switch (tipoArchivo) {
            case "pelicula":
                String duracionPelicula = request.getParameter("duracionP") + ":00";
                Time duracion = Time.valueOf(duracionPelicula);
                codigo = "pelicula";
                try {
                    fechaDeSubida = new Timestamp(System.currentTimeMillis());
                    pelicula.setFechaDeSubida(fechaDeSubida);
                    BeanUtils.populate(pelicula, request.getParameterMap());

                } catch (IllegalAccessException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvocationTargetException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }

                file = File.createTempFile(codigo + "-", "-" + fileName, uploads); //Evita que hayan dos archivos con el mismo nombre
                filePortada = File.createTempFile(codigo + "-portada" + "-", "-" + fileNamePortada, uploads); //Evita que hayan dos archivos con el mismo nombre

                try (InputStream input = filePart.getInputStream()) {
                    Files.copy(input, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
                }
                try (InputStream input = filePartPortada.getInputStream()) {
                    Files.copy(input, filePortada.toPath(), StandardCopyOption.REPLACE_EXISTING);
                }
                pelicula.setNombreArchivo(file.getName());
                pelicula.setNombrePortada(filePortada.getName());
                pelicula.setDuracionPelicula(duracion);
                pelicula.setUsuario(usuario);
                gdao.insertUpdate(pelicula);
                url = "JSP/inicio.jsp";
                break;
            case "serie":
                codigo = "serie";
                String duracionCapitulo = request.getParameter("duracionC") + ":00";
                Time duracionCa = Time.valueOf(duracionCapitulo);
                try {
                    fechaDeSubida = new Timestamp(System.currentTimeMillis());
                    pelicula.setFechaDeSubida(fechaDeSubida);
                    BeanUtils.populate(serie, request.getParameterMap());
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvocationTargetException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }

                file = File.createTempFile(codigo + "-", "-" + fileName, uploads); //Evita que hayan dos archivos con el mismo nombre
                filePortada = File.createTempFile(codigo + "-portada" + "-", "-" + fileNamePortada, uploads); //Evita que hayan dos archivos con el mismo nombre

                try (InputStream input = filePart.getInputStream()) {
                    Files.copy(input, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
                }

                try (InputStream input = filePartPortada.getInputStream()) {
                    Files.copy(input, filePortada.toPath(), StandardCopyOption.REPLACE_EXISTING);
                }

                serie.setNombreArchivo(file.getName());
                serie.setNombrePortada(filePortada.getName());
                serie.setDuracionCapitulo(duracionCa);
                serie.setUsuario(usuario);
                gdao.insertUpdate(serie);
                url = "JSP/inicio.jsp";
                break;
            case "video":
                codigo = "video";
                try {
                    fechaDeSubida = new Timestamp(System.currentTimeMillis());
                    pelicula.setFechaDeSubida(fechaDeSubida);
                    BeanUtils.populate(video, request.getParameterMap());
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvocationTargetException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
                file = File.createTempFile(codigo + "-", "-" + fileName, uploads); //Evita que hayan dos archivos con el mismo nombre
                filePortada = File.createTempFile(codigo + "-portada" + "-", "-" + fileNamePortada, uploads); //Evita que hayan dos archivos con el mismo nombre

                try (InputStream input = filePart.getInputStream()) {
                    Files.copy(input, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
                }

                try (InputStream input = filePartPortada.getInputStream()) {
                    Files.copy(input, filePortada.toPath(), StandardCopyOption.REPLACE_EXISTING);
                }
                video.setNombreArchivo(file.getName());
                video.setNombrePortada(filePortada.getName());
                video.setUsuario(usuario);
                gdao.insertUpdate(video);
                url = "JSP/inicio.jsp";
                break;
        }
        response.sendRedirect(url);
//        request.getRequestDispatcher(url).forward(request, response);
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
