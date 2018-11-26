/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.aitor.dao;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Daw2
 */
public interface IGenericoDAO<T> {
     
    public void insertUpdate(T objeto);
    public <T> List<T> get(String entidad);
//    public <T> List<T> getGroupBy(String entidad, String groupBy);
    public <T> T getOne(Serializable pk, Class<T> claseEntidad);
    public void delete(T objeto);
    public <T> List<T> getUsuarioExistente(String email);
    public <T> List<T> getCanalExistente(String canal);
    public <T> List<T> getMisSuscripciones(int canal);
    public <T> List<T> getUsuarioValidacion(String email, String password, String claseEntidad);
}
