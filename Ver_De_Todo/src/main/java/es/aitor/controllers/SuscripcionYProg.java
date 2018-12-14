/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.aitor.controllers;

import es.aitor.beans.Programacion;
import es.aitor.beans.Suscriptor;
import es.aitor.beans.Usuario;
import es.aitor.dao.IGenericoDAO;
import es.aitor.daofactory.DAOFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
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
@WebServlet(name = "SuscripcionYProg", urlPatterns = {"/SuscripcionYProg"})
public class SuscripcionYProg extends HttpServlet {

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
        HttpSession sesion = request.getSession(true);
        String url = null;

        DAOFactory daof = DAOFactory.getDAOFactory();
        IGenericoDAO gdao = daof.getGenericoDAO();
        
        String archivo = (String) sesion.getAttribute("archivoSeriePelicula");
        int idArchivo = (int) sesion.getAttribute("idArchivo");
        String fechaReproduccion = request.getParameter("fechaReproduccion");
        String horaReproduccion = request.getParameter("horaReproduccion");
        Programacion programacion = new Programacion();
        List<Programacion> listaProgramacion = (List<Programacion>) sesion.getAttribute("programacion");
        Usuario usuario = (Usuario) sesion.getAttribute("usuario");
        
        Date fecha = Date.valueOf(fechaReproduccion);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        long hora = 0;
        
        try{
            hora = sdf.parse(horaReproduccion).getTime();
        } catch(ParseException pe){
            pe.addSuppressed(pe);
        }
        
        Time horaR = new Time(hora);
        switch(archivo){
            case "pelicula":
                programacion.setFechaReproduccion(fecha);
                programacion.setHoraReproduccion(horaR);
                programacion.setIdPelicula(idArchivo);
                programacion.setIdSerie(0);
                programacion.setUsuario(usuario.getIdUsuario());
                listaProgramacion.add(programacion);
                gdao.insertUpdate(programacion);
                url = "JSP/inicio.jsp";
                break;
            case "serie":
                programacion.setFechaReproduccion(fecha);
                programacion.setHoraReproduccion(horaR);
                programacion.setIdPelicula(0);
                programacion.setIdSerie(idArchivo);
                programacion.setUsuario(usuario.getIdUsuario());
                listaProgramacion.add(programacion);
                gdao.insertUpdate(programacion);
                url = "JSP/inicio.jsp";
                break;
        }
        Collections.sort(listaProgramacion);
        sesion.setAttribute("programacion", listaProgramacion);
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
        
        HttpSession sesion = request.getSession(true);

        DAOFactory daof = DAOFactory.getDAOFactory();
        IGenericoDAO gdao = daof.getGenericoDAO();
        
        PrintWriter out = response.getWriter();
        
        Suscriptor suscriptor = new Suscriptor();
        String accion = request.getParameter("accion");
        int idCanal = Integer.valueOf(request.getParameter("idUser"));
        
        Usuario usuario = (Usuario) sesion.getAttribute("usuario");
        
        System.out.println("Que id me traigo? "+idCanal);
        suscriptor.setIdUsuarioSuscriptor(usuario.getIdUsuario());
        suscriptor.setIdUsuario(idCanal);
        
        List<Usuario> listaCanales = (List<Usuario>) sesion.getAttribute("canales");
        List<Usuario> listaCanalesNoSus = (List<Usuario>) sesion.getAttribute("canalesNoSuscritos");
        
        switch(accion){
            case "add":
                for(int i = 0;i<listaCanalesNoSus.size();i++){
                    if(listaCanalesNoSus.get(i).getIdUsuario() == idCanal){
                        listaCanales.add(listaCanalesNoSus.get(i));
                        listaCanalesNoSus.remove(i);
                    }
                }
                sesion.setAttribute("canales", listaCanales);
                sesion.setAttribute("canalesNoSuscritos", listaCanalesNoSus);
                gdao.insertUpdate(suscriptor);
                break;
            case "del":
                List<Suscriptor> listaSuscripciones = (List<Suscriptor>) gdao.getMisSuscripciones(usuario.getIdUsuario());
                for(int i= 0;i<listaSuscripciones.size();i++){
                    if(listaSuscripciones.get(i).getIdUsuario() == suscriptor.getIdUsuario() || listaSuscripciones.get(i).getIdUsuarioSuscriptor() == suscriptor.getIdUsuarioSuscriptor()){
                        suscriptor.setIdSuscriptor(listaSuscripciones.get(i).getIdSuscriptor());
                    }
                }
                for(int i = 0;i<listaCanales.size();i++){
                    if(listaCanales.get(i).getIdUsuario() == idCanal){
                        listaCanalesNoSus.add(listaCanales.get(i));
                        listaCanales.remove(i);
                    }
                }
                sesion.setAttribute("canales", listaCanales);
                sesion.setAttribute("canalesNoSuscritos", listaCanalesNoSus);
                gdao.delete(suscriptor);
                break;
        }
        
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
