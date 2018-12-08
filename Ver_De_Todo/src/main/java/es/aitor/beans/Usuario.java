/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.aitor.beans;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.IndexColumn;


@Entity
@Table(name="usuarios")
public class Usuario implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="idUsuario")
    private int idUsuario;
    
    @Column(name="nombreReal")
    private String nombreReal;
    
    @Column(name="apellido1")
    private String apellido1;
    
    @Column(name="apellido2")
    private String apellido2;
    
    @Column(name="correoElectronico")
    private String correoElectronico;
    
    @Column(name="password")
    private String password;
    
    @Column(name="nombreCanal", length=80)
    private String nombreCanal;
    
    @Column(name="numSuscriptores")
    private int numSuscriptores;
    
    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(name="idUsuario ")
    private List<Suscriptor> listaSuscriptores;

//    @OneToOne(cascade={CascadeType.ALL})
//    @PrimaryKeyJoinColumn
//    private Canal idCanal;
    
    @OneToMany(cascade = {CascadeType.ALL}, fetch=FetchType.LAZY)
    @JoinColumn(name="idUsuario")
    private List <Pelicula> listaPeliculas;
    
//    @OneToMany(cascade = {CascadeType.ALL}, fetch=FetchType.LAZY)
//    @JoinColumn(name="idUsuario")
//    private List<Programacion> listaProgramaciones;
    
    @OneToMany(cascade = {CascadeType.ALL}, fetch=FetchType.LAZY)
    @JoinColumn(name="idUsuario")
    private List<Serie> listaSeries;
    
    @OneToMany(cascade = {CascadeType.ALL}, fetch=FetchType.LAZY)
    @JoinColumn(name="idUsuario")
    private List<Video> listaVideos;
    
    public Usuario() {
    }

    public Usuario(int idUsuario, String nombreReal, String apellido1, String apellido2, String correoElectronico, String password, String nombreCanal, int numSuscriptores) {
        this.idUsuario = idUsuario;
        this.nombreReal = nombreReal;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.correoElectronico = correoElectronico;
        this.password = password;
        this.nombreCanal = nombreCanal;
        this.numSuscriptores = numSuscriptores;
    }
    
    public Usuario(int idUsuario, String nombreReal, String apellido1, String apellido2, String correoElectronico, String password, String nombreCanal, int numSuscriptores, List<Suscriptor> listaSuscriptores, List<Pelicula> listaPeliculas, /*List<Programacion> listaProgramaciones,*/ List<Serie> listaSeries, List<Video> listaVideos) {
        this.idUsuario = idUsuario;
        this.nombreReal = nombreReal;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.correoElectronico = correoElectronico;
        this.password = password;
        this.nombreCanal = nombreCanal;
        this.numSuscriptores = numSuscriptores;
        this.listaSuscriptores = listaSuscriptores;
        this.listaPeliculas = listaPeliculas;
//        this.listaProgramaciones = listaProgramaciones;
        this.listaSeries = listaSeries;
        this.listaVideos = listaVideos;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    public String getNombreReal() {
        return nombreReal;
    }

    public void setNombreReal(String nombreReal) {
        this.nombreReal = nombreReal;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombreCanal() {
        return nombreCanal;
    }

    public void setNombreCanal(String nombreCanal) {
        this.nombreCanal = nombreCanal;
    }

    public int getNumSuscriptores() {
        return numSuscriptores;
    }

    public void setNumSuscriptores(int numSuscriptores) {
        this.numSuscriptores = numSuscriptores;
    }

    public List<Suscriptor> getListaSuscriptores() {
        return listaSuscriptores;
    }

    public void setListaSuscriptores(List<Suscriptor> listaSuscriptores) {
        this.listaSuscriptores = listaSuscriptores;
    }

    public List <Pelicula> getListaPeliculas() {
        return listaPeliculas;
    }

    public void setListaPeliculas(List <Pelicula> listaPeliculas) {
        this.listaPeliculas = listaPeliculas;
    }

//    public List<Programacion> getListaProgramaciones() {
//        return listaProgramaciones;
//    }
//
//    public void setListaProgramaciones(List<Programacion> listaProgramaciones) {
//        this.listaProgramaciones = listaProgramaciones;
//    }

    public List<Serie> getListaSeries() {
        return listaSeries;
    }

    public void setListaSeries(List<Serie> listaSeries) {
        this.listaSeries = listaSeries;
    }


    public List<Video> getListaVideos() {
        return listaVideos;
    }

    public void setListaVideos(List<Video> listaVideos) {
        this.listaVideos = listaVideos;
    }
    
}
