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
    private int idProgramación;
    
    @Column(name="fechaReproduccion")
    private Date fechaReproduccion;
    
    @Column(name="horaReproduccion")
    private Time horaReproduccion;
    
    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;
    
    @OneToOne
    @JoinColumn(name = "idVideo")
    private Video idVideo;
    
    @OneToOne
    @JoinColumn(name = "idPelicula")
    private Pelicula idPelicula;
    
    @OneToOne
    @JoinColumn(name = "idSerie")
    private Serie idSerie;

    public Programacion() {
    }

    public Programacion(int idProgramación, Date fechaReproduccion, Time horaReproduccion) {
        this.idProgramación = idProgramación;
        this.fechaReproduccion = fechaReproduccion;
        this.horaReproduccion = horaReproduccion;
    }

    public Programacion(int idProgramación, Date fechaReproduccion, Time horaReproduccion, Usuario usuario) {
        this.idProgramación = idProgramación;
        this.fechaReproduccion = fechaReproduccion;
        this.horaReproduccion = horaReproduccion;
        this.usuario = usuario;
    }

    public Programacion(int idProgramación, Date fechaReproduccion, Time horaReproduccion, Usuario usuario, Video idVideo, Pelicula idPelicula, Serie idSerie) {
        this.idProgramación = idProgramación;
        this.fechaReproduccion = fechaReproduccion;
        this.horaReproduccion = horaReproduccion;
        this.usuario = usuario;
        this.idVideo = idVideo;
        this.idPelicula = idPelicula;
        this.idSerie = idSerie;
    }

    public int getIdProgramación() {
        return idProgramación;
    }

    public void setIdProgramación(int idProgramación) {
        this.idProgramación = idProgramación;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Video getIdVideo() {
        return idVideo;
    }

    public void setIdVideo(Video idVideo) {
        this.idVideo = idVideo;
    }

    public Pelicula getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(Pelicula idPelicula) {
        this.idPelicula = idPelicula;
    }

    public Serie getIdSerie() {
        return idSerie;
    }

    public void setIdSerie(Serie idSerie) {
        this.idSerie = idSerie;
    }
    
}
