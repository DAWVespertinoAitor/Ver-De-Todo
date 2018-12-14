/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.aitor.controllers;

import es.aitor.beans.Usuario;
import es.aitor.dao.IGenericoDAO;
import es.aitor.daofactory.DAOFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
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
@WebServlet(name = "RegistroAjax", urlPatterns = {"/RegistroAjax"})
public class RegistroAjax extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * 
     * Este controlador se encarga de la validación de los datos.
     * Por ejemplo, que no se registre una persona con un email que ya existe en
     * la base de datos.
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession sesion = request.getSession(true);

        String url = null;
        String opcionRegistro = request.getParameter("loginRegistro");

        DAOFactory daof = DAOFactory.getDAOFactory();
        IGenericoDAO gdao = daof.getGenericoDAO();

        PrintWriter out = response.getWriter();
        String clave;
        String claveRepe;
        switch (opcionRegistro) {
            case "existeCorreo":
                String emailExistente = request.getParameter("correo");
                
                List<Usuario> usuarioExistente = null;
                Usuario usuarioVal = null;

                usuarioExistente = (List<Usuario>) gdao.getUsuarioExistente(emailExistente);
                
                for(int i=0;i<usuarioExistente.size();i++){
//                    System.out.println("Usuario correo "+usuarioExistente.get(i).getCorreoElectronico());
                    usuarioVal = usuarioExistente.get(i);
                }
                
                if (usuarioVal != null) {
//                    System.out.println("Este correo ya esta en uso");
                    out.println("Este correo ya esta en uso");
                }
                break;
            case "existeCanal":
                String nombreExistente = request.getParameter("canal");
                
                List<Usuario> canalExistente = null;
                Usuario canalVal = null;

                canalExistente = (List<Usuario>) gdao.getCanalExistente(nombreExistente);
                
                for(int i=0;i<canalExistente.size();i++){
//                    System.out.println("Usuario correo "+usuarioExistente.get(i).getCorreoElectronico());
                    canalVal = canalExistente.get(i);
                }
                
                if (canalVal != null) {
//                    System.out.println("Este correo ya esta en uso");
                    out.println("Otro usuario tiene ya este nombre");
                }
                break;
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
