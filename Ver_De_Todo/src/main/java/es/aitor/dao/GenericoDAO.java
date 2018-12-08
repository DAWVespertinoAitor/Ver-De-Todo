/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.aitor.dao;

import es.aitor.beans.Canal;
import es.aitor.beans.Pelicula;
import es.aitor.beans.Programacion;
import es.aitor.beans.Serie;
import es.aitor.beans.Suscriptor;
import es.aitor.beans.Usuario;
import es.aitor.beans.Video;
import es.aitor.context.Context;
import es.aitor.persistencia.HibernateUtil;
import java.io.Serializable;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import java.util.List;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.transform.Transformers;

/**
 *
 * @author Daw2
 */
public class GenericoDAO<T> implements IGenericoDAO<T> {

    private static final Logger LOG = Logger.getLogger(Context.class.getName());
    private Session sesion;

    private void startTransaction() {
        System.out.println("COMIENZA LA TRANSACION");
        sesion = HibernateUtil.getSessionFactory().openSession();

        System.out.println("Sesiones esta a " + sesion);
        sesion.beginTransaction();
    }

    private void endTransaction() {
        sesion.getTransaction().commit();
        sesion.close();
    }

    private void handleExcepcion(HibernateException he) throws HibernateException {
        sesion.getTransaction().rollback();
        throw he;
    }

    @Override
    public void insertUpdate(T objeto) {
        try {
            startTransaction();
            sesion.saveOrUpdate(objeto);
            sesion.flush();

        } catch (HibernateException he) {
            handleExcepcion(he);
        } finally {
            endTransaction();
        }
    }

    @Override
    public <T> List<T> get(String entidad) {
        List<T> listadoResultados = null;
        try {
            startTransaction();
            listadoResultados = sesion.createQuery(" from " + entidad).list();
        } catch (HibernateException he) {
            this.handleExcepcion(he);
        } finally {
            this.endTransaction();
        }
        return listadoResultados;
    }

//    @Override
//    public <T> List<T> getGroupBy(String entidad, String groupBy) {
//        List<T> listadoResultados = null;
//        String sql = "SELECT * from " + entidad + " GROUP BY " + groupBy;
//        try {
//            startTransaction();
//            listadoResultados = sesion.createSQLQuery(sql).list();
//        } catch (HibernateException he) {
//            this.handleExcepcion(he);
//        } finally {
//            this.endTransaction();
//        }
//        return listadoResultados;
//    }
    @Override
    public <T> T getOne(Serializable pk, Class<T> claseEntidad) {
        T objetoRecuperado = null;
        try {
            startTransaction();
            objetoRecuperado = sesion.get(claseEntidad, pk);
        } catch (HibernateException he) {
            this.handleExcepcion(he);
        } finally {
            this.endTransaction();
        }

        return objetoRecuperado;
    }

    @Override
    public <T> List<T> getUsuarioExistente(String email) {

        List<T> objetoRecuperado = null;
        Query query = null;
        String sql = "SELECT * FROM usuarios WHERE correoElectronico='" + email + "';";

        try {
            startTransaction();
            query = sesion.createSQLQuery(sql);
            query.setResultTransformer(Transformers.aliasToBean(Usuario.class));
            List<Usuario> listaUsuario = query.list();
            objetoRecuperado = (List<T>) listaUsuario;
        } catch (HibernateException he) {
            this.handleExcepcion(he);
        } finally {
            this.endTransaction();
        }

        return objetoRecuperado;
    }

    @Override
    public <T> List<T> getCanalExistente(String canal) {

        List<T> objetoRecuperado = null;
        Query query = null;
        String sql = "SELECT * FROM usuarios WHERE nombreCanal='" + canal + "';";

        try {
            startTransaction();
            query = sesion.createSQLQuery(sql);
            query.setResultTransformer(Transformers.aliasToBean(Usuario.class));
            List<Usuario> listaCanal = (List<Usuario>) query.list();
            objetoRecuperado = (List<T>) listaCanal;
        } catch (HibernateException he) {
            this.handleExcepcion(he);
        } finally {
            this.endTransaction();
        }

        return objetoRecuperado;
    }

    @Override
    public <T> List<T> getMisSuscripciones(int canal) {

        List<T> objetoRecuperado = null;
        Query query = null;
        String sql = "SELECT * FROM suscriptores WHERE idUsuarioSuscriptor=" + canal + ";";

        try {
            startTransaction();
            query = sesion.createSQLQuery(sql);
            query.setResultTransformer(Transformers.aliasToBean(Suscriptor.class));
            List<Suscriptor> listaSuscriptor = (List<Suscriptor>) query.list();
            for (int i = 0; i < listaSuscriptor.size(); i++) {
                System.out.println("Este es el canal " + listaSuscriptor.get(i).getIdUsuario());
            }
            objetoRecuperado = (List<T>) listaSuscriptor;
        } catch (HibernateException he) {
            this.handleExcepcion(he);
        } finally {
            this.endTransaction();
        }

        return objetoRecuperado;
    }

    @Override
    public <T> List<T> getUsuarioValidacion(String email, String password, String claseEntidad) {

        List<T> objetoRecuperado = null;
        Query query = null;
        String sql = "SELECT * from " + claseEntidad + " WHERE correoElectronico='" + email + "' AND password=" + password + ";";
        try {
            startTransaction();
            query = sesion.createSQLQuery(sql);
            query.setResultTransformer(Transformers.aliasToBean(Usuario.class));
            List<Usuario> listaUsuario = query.list();
            objetoRecuperado = (List<T>) listaUsuario;

        } catch (HibernateException he) {
            this.handleExcepcion(he);
        } finally {
            this.endTransaction();
        }

        return objetoRecuperado;
    }

    @Override
    public <T> List<T> getPeliculas(int canal) {
        List<T> objetoRecuperado = null;
        Query query = null;
        String sql = "SELECT idPelicula, titulo, fechaDeSubida, genero, pais, director, sinopsis, actores, nombreArchivo, subtitulos FROM peliculas WHERE idUsuario='" + canal + "' ;";
        try {
            startTransaction();
            query = sesion.createSQLQuery(sql);
            query.setResultTransformer(Transformers.aliasToBean(Pelicula.class));
            List<Pelicula> listaPelicula = (List<Pelicula>) query.list();
            for (int i = 0; i < listaPelicula.size(); i++) {
                System.out.println("Pelicula " + listaPelicula.get(i).getTitulo());
            }
            objetoRecuperado = (List<T>) listaPelicula;

        } catch (HibernateException he) {
            this.handleExcepcion(he);
        } finally {
            this.endTransaction();
        }
        return objetoRecuperado;
    }

    @Override
    public <T> List<T> getSeries(int canal) {
        List<T> objetoRecuperado = null;
        Query query = null;
        String sql = "SELECT idSerie, tituloSerie, temporada, tituloCapitulo, numCapitulo, idioma, subtitulos, nombreArchivo, descripcion, fechaDeSubida FROM series WHERE idUsuario='" + canal + "' ORDER BY fechaDeSubida DESC LIMIT 3;";
        try {
            startTransaction();
            query = sesion.createSQLQuery(sql);
            query.setResultTransformer(Transformers.aliasToBean(Serie.class));
            List<Serie> listaSerie = (List<Serie>) query.list();
            for (int i = 0; i < listaSerie.size(); i++) {
                System.out.println("Serie " + listaSerie.get(i).getTituloSerie());
            }
            objetoRecuperado = (List<T>) listaSerie;

        } catch (HibernateException he) {
            this.handleExcepcion(he);
        } finally {
            this.endTransaction();
        }
        return objetoRecuperado;
    }

    @Override
    public <T> List<T> getVideos(int canal) {
        List<T> objetoRecuperado = null;
        Query query = null;
        String sql = "SELECT idVideo, titulo, descripcion, fechaDeSubida FROM videos WHERE idUsuario='" + canal + "' ORDER BY fechaDeSubida DESC LIMIT 3;";
        try {
            startTransaction();
            query = sesion.createSQLQuery(sql);
            query.setResultTransformer(Transformers.aliasToBean(Video.class));
            List<Video> listaVideo = (List<Video>) query.list();
            for (int i = 0; i < listaVideo.size(); i++) {
                System.out.println("Video " + listaVideo.get(i).getTitulo());
            }
            objetoRecuperado = (List<T>) listaVideo;

        } catch (HibernateException he) {
            this.handleExcepcion(he);
        } finally {
            this.endTransaction();
        }
        return objetoRecuperado;
    }

    @Override
    public List<Programacion> getProgramacion(int canal, String fechaReproduccion) {
        List<Programacion> listaProgramacion = null;
        Query query = null;
        String sql = "SELECT idProgramacion, fechaReproduccion, horaReproduccion, idPelicula, idSerie FROM programaciones WHERE idUsuario='"+canal+"' AND fechaReproduccion > '"+fechaReproduccion+"';";//WHERE idUsuario='" + canal + "'"+/*fechaReproduccion+*/";";
        try {
            startTransaction();
            query = sesion.createSQLQuery(sql);
            query.setResultTransformer(Transformers.aliasToBean(Programacion.class));
            listaProgramacion = (List<Programacion>) query.list();

        } catch (HibernateException he) {
            this.handleExcepcion(he);
        } finally {
            this.endTransaction();
        }
        return listaProgramacion;
    }

    @Override
    public void delete(T objeto) {
        try {
            startTransaction();
            sesion.delete(objeto);
        } catch (HibernateException he) {
            this.handleExcepcion(he);
        } finally {
            this.endTransaction();
        }
    }

}
