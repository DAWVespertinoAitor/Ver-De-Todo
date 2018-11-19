/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.aitor.context;

import es.aitor.beans.Canal;
import es.aitor.beans.Usuario;
import es.aitor.dao.GenericoDAO;
import es.aitor.dao.IGenericoDAO;
import es.aitor.daofactory.DAOFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 *
 * @author aitor
 */
@WebListener
public class Context implements ServletContextListener {

    private static final Logger LOG = Logger.getLogger(Context.class.getName());

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        System.out.println("Entro a iniciar");
        ServletContext contexto = sce.getServletContext();
        DAOFactory daof = DAOFactory.getDAOFactory();

        IGenericoDAO gdao = daof.getGenericoDAO();

        Usuario usuario = new Usuario();
        Canal canal = new Canal();
        
        canal.setNombre("TheSenior96");
        canal.setNumSuscriptores(5);
        
        usuario.setNombreReal("Aitor");
        usuario.setApellido1("Muñoz");
        usuario.setApellido2("Blanco");
        usuario.setCorreoElectronico("tadfasdfasd@gmail.com");
        usuario.setPassword("1234");
        usuario.setIdCanal(canal);
        
        gdao.insertUpdate(usuario);
        
        //usuario = (Usuario) gdao.getOne(1, Usuario.class);
        

        synchronized (contexto) {
            contexto.setAttribute("usuarioContexto", usuario);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Entro a destruir");
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
