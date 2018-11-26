/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.aitor.controllers;

import es.aitor.beans.Canal;
import es.aitor.beans.Suscriptor;
import es.aitor.beans.Usuario;
import es.aitor.dao.IGenericoDAO;
import es.aitor.daofactory.DAOFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
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
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
                System.out.println("Entro en el login");
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
                    
                    url = "./JSP/inicio.jsp";
                    
                    //Recojo los canales a los que esta suscrito
                    List<Suscriptor> listaSuscripciones = null;
                    List<Usuario> listaCanales = new ArrayList();
                    listaSuscripciones = (List<Suscriptor>) gdao.getMisSuscripciones(usuarioLogin2.getIdUsuario());
                    for (int i = 0; i < listaSuscripciones.size(); i++) {
                        Usuario usuarioRecuperado = (Usuario) gdao.getOne((Serializable) listaSuscripciones.get(i).getIdUsuario(), Usuario.class);
                        listaCanales.add(usuarioRecuperado);
                    }

                    //Meto el usuario en sesion
                    sesion.setAttribute("usuario", usuarioLogin2);

                    //Meto los canales en sesion
                    sesion.setAttribute("canales", listaCanales);
                }
                break;
            case "registro":
                url = "JSP/inicio.jsp";
                Usuario usuario = new Usuario();
//                Canal canal = new Canal();
//                String claveRepetida = request.getParameter("claveR");
//                boolean clavesIguales = false;

                try {
                    BeanUtils.populate(usuario, request.getParameterMap());
//                    BeanUtils.populate(canal, request.getParameterMap());
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvocationTargetException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }

//                usuario.setIdCanal(canal);
                gdao.insertUpdate(usuario);
//                if(usuario.getPassword().equals(claveRepetida)){
//                    clavesIguales = true;
//                }

                break;
        }
        System.out.println("Que direccion llevo "+url);
        request.getRequestDispatcher(url).forward(request, response);
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
