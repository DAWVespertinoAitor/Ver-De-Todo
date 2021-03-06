/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.aitor.controllers;

import es.aitor.beans.Pelicula;
import es.aitor.beans.Programacion;
import es.aitor.beans.Serie;
import es.aitor.beans.Suscriptor;
import es.aitor.beans.Usuario;
import es.aitor.beans.Video;
import es.aitor.dao.IGenericoDAO;
import es.aitor.daofactory.DAOFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.beanutils.BeanUtils;

/**
 *
 * @author aitor
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * 
     * Se encarga de saber si el usuario ha introducido bien las credenciales o no.
     * Tambien comprueba la programación que tiene y descarta la que ya ha pasado de fecha u hora.
     * Obtiene los canales a los que estas suscrito.
     * Por otro lado tambien se encarga de subir los datos registro a la base de datos.
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        HttpSession sesion = request.getSession(true);

        String url = null;
        String opcionRegistro = request.getParameter("loginRegistro");

        DAOFactory daof = DAOFactory.getDAOFactory();
        IGenericoDAO gdao = daof.getGenericoDAO();

        PrintWriter out = response.getWriter();
        String clave;
        String claveRepe;
        switch (opcionRegistro) {
            case "login":
                List<Usuario> usuarioLogin = null;
                Usuario usuarioLogin2 = null;
                String emailLogin = request.getParameter("email");
                String passwdLogin = request.getParameter("clave");
//                usuarioLogin2 = (Usuario) gdao.getOne(1, Usuario.class);
                System.out.println(emailLogin);
                System.out.println(passwdLogin);
                usuarioLogin = (List<Usuario>) gdao.getUsuarioValidacion(emailLogin, passwdLogin, "usuarios");

                for (int i = 0; i < usuarioLogin.size(); i++) {
//                    System.out.println("Usuario correo "+usuarioLogin.get(i).getCorreoElectronico());
                    usuarioLogin2 = usuarioLogin.get(i);
                }

                if (usuarioLogin2 == null) {
                    url = "index.jsp";
                    request.setAttribute("datosErroneos", true);
                    request.setAttribute("email", emailLogin);
                } else {
                    System.out.println("Esta es la ruta " + request.getContextPath());

                    url = "./JSP/inicio.jsp";

                    //Recojo los canales a los que esta suscrito
                    List<Suscriptor> listaSuscripciones = null;
                    List<Usuario> listaCanales = new ArrayList();
                    List<Usuario> listaCanalesOtros = new ArrayList();

                    Pelicula pelicula = new Pelicula();
                    Serie serie = new Serie();
                    Video video = new Video();

                    //Recupero las suscripciones
                    listaSuscripciones = (List<Suscriptor>) gdao.getMisSuscripciones(usuarioLogin2.getIdUsuario());
                    for (int i = 0; i < listaSuscripciones.size(); i++) {
                        Usuario usuarioRecuperado = (Usuario) gdao.getOne((Serializable) listaSuscripciones.get(i).getIdUsuario(), Usuario.class);
                        listaCanales.add(usuarioRecuperado);
                    }

                    String idCanales = "";
                    //Recupero canales a los que no esta suscrito
                    if (listaCanales.size() > 0) {
                        for (int i = 0; i < listaCanales.size(); i++) {
                            if (i == 0) {
                                idCanales = idCanales + usuarioLogin2.getIdUsuario() + ", " + listaCanales.get(i).getIdUsuario();
                            } else {
                                idCanales = idCanales + ", " + listaCanales.get(i).getIdUsuario();
                            }
                        }
                        listaCanalesOtros = (List<Usuario>) gdao.getOtrosCanales(idCanales);
                    } else {
                        idCanales = String.valueOf(usuarioLogin2.getIdUsuario());
                        listaCanalesOtros = (List<Usuario>) gdao.getOtrosCanales(idCanales);
                    }

                    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HH:mm:00");
                    DateTimeFormatter fmtFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    LocalDate hoy = LocalDate.now();
                    LocalDateTime hora = LocalDateTime.now();
//                    Date hoy = new Date(ahora.getYear(), ahora.now().getMonthValue(), ahora.now().getDayOfMonth());
                    String fechaHoy = "2018-" + String.valueOf(hoy.getMonthValue()) + "-" + String.valueOf(hoy.getDayOfMonth());
                    List<Programacion> listaProgramacion = gdao.getProgramacion(usuarioLogin2.getIdUsuario(), fechaHoy);
                    for (int i = 0; i < listaProgramacion.size(); i++) {
                        if (listaProgramacion.get(i).getFechaReproduccion().equals(Date.valueOf(fmtFecha.format(hoy)))) {
                            long diferencia = Time.valueOf(fmt.format(hora)).getTime() - listaProgramacion.get(i).getHoraReproduccion().getTime();
                            if (diferencia > listaProgramacion.get(i).getDuracionContenido().getTime()) {
                                listaProgramacion.remove(i);
                            }
                        }
                    }

                    //Meto el usuario en sesion
                    sesion.setAttribute("usuario", usuarioLogin2);

                    //Meto la programacion en sesion
                    sesion.setAttribute("programacion", listaProgramacion);

                    //Meto los canales en sesion
                    sesion.setAttribute("canales", listaCanales);

                    //Meto los otros canales en sesion
                    sesion.setAttribute("canalesNoSuscritos", listaCanalesOtros);
                }
                break;
            case "registro":
                url = "JSP/inicio.jsp";
                Usuario usuario = new Usuario();

                try {
                    BeanUtils.populate(usuario, request.getParameterMap());
//                    BeanUtils.populate(canal, request.getParameterMap());
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvocationTargetException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }

                gdao.insertUpdate(usuario);

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
