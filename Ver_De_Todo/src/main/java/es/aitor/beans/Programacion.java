/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.aitor.beans;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="programaciones")
public class Programacion implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="idProgramacion")
    private int idProgramacion;
    
    @Column(name="fechaReproduccion")
    private Date fechaReproduccion;
    
    @Column(name="horaReproduccion")
    private Time horaReproduccion;
    
//    @ManyToOne
//    @JoinColumn(name = "idUsuario")
    @Column(name="idUsuario")
    private int usuario;
    
//    @OneToOne(fetch=FetchType.LAZY)
//    @JoinColumn(name = "idPelicula")
    @Column(name="idPelicula")
    private int idPelicula;
    
//    @OneToOne(fetch=FetchType.LAZY)
//    @JoinColumn(name = "idSerie")
    @Column(name="idSerie")
    private int idSerie;

    public Programacion() {
    }

    public Programacion(int idProgramacion, Date fechaReproduccion, Time horaReproduccion) {
        this.idProgramacion = idProgramacion;
        this.fechaReproduccion = fechaReproduccion;
        this.horaReproduccion = horaReproduccion;
    }
    
    public Programacion(int idProgramacion, Date fechaReproduccion, Time horaReproduccion, int idPelicula, int idSerie) {
        this.idProgramacion = idProgramacion;
        this.fechaReproduccion = fechaReproduccion;
        this.horaReproduccion = horaReproduccion;
        this.idPelicula = idPelicula;
        this.idSerie = idSerie;
    }

    public Programacion(int idProgramacion, Date fechaReproduccion, Time horaReproduccion, int usuario, int idPelicula, int idSerie) {
        this.idProgramacion = idProgramacion;
        this.fechaReproduccion = fechaReproduccion;
        this.horaReproduccion = horaReproduccion;
        this.usuario = usuario;
        this.idPelicula = idPelicula;
        this.idSerie = idSerie;
    }

    public int getIdProgramacion() {
        return idProgramacion;
    }

    public void setIdProgramacion(int idProgramacion) {
        this.idProgramacion = idProgramacion;
    }

    public Date getFechaReproduccion() {
        return fechaReproduccion;
    }

    public void setFechaReproduccion(Date fechaReproduccion) {
        this.fechaReproduccion = fechaReproduccion;
    }

    public Time getHoraReproduccion() {
        return horaReproduccion;
    }

    public void setHoraReproduccion(Time horaReproduccion) {
        this.horaReproduccion = horaReproduccion;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public int getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    public int getIdSerie() {
        return idSerie;
    }

    public void setIdSerie(int idSerie) {
        this.idSerie = idSerie;
    }
    
}
