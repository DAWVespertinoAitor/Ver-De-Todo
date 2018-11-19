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

        String url = "index.jsp";
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
                if(usuarioLogin2 != null){
                    System.out.println("He obtenido en usuarioLogin 2");
                    System.out.println("correElectronico "+usuarioLogin2.getCorreoElectronico());
                }
                usuarioLogin = gdao.getUsuarioValidacion(emailLogin, passwdLogin, "usuarios");
                

                if (usuarioLogin == null) {
//                    url = "JSP/loginRegistro.jsp";
                    request.setAttribute("datosErroneos", true);
                    request.setAttribute("email", emailLogin);
                } else {
                    System.out.println("EEEEEEEEEEEH");
                    System.out.println("Encontrado");
//                    if(usuarioLogin.getTipo() == 'a'){
//                        url = "JSP/Admin/eleccion.jsp";
//                    }
//                    clienteLogin = cdao.getCliente(usuarioLogin.getIdUsuario());
//                    sesion.setAttribute("usuarioLogeado", usuarioLogin);
                }
//
//                if (clienteLogin == null) {
//                    sesion.setAttribute("clienteLogeado", null);
//                } else {
//                    sesion.setAttribute("clienteLogeado", clienteLogin);
//                }
//                int pedidoProducto = 0;
//                sesion.setAttribute("total", (int) pedidoProducto);
//                request.getRequestDispatcher(url).forward(request, response);
                break;
        }
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
