/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.aitor.beans;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="videos")
public class Video implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="idVideo")
    private int idVideo;
    
    @Column(name="titulo")
    private String titulo;
    
    @Column(name="descripcion")
    private String descripcion;
    
    @Column(name="nombreArchivo")
    private String nombreArchivo;
    
    @Column(name="nombrePortada")
    private String nombrePortada;
    
    @Column(name="fechaDeSubida")
    private Timestamp fechaDeSubida;
    
    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    public Video() {
    }

    public Video(int idVideo, String titulo, String descripcion, String nombreArchivo, String nombrePortada, Timestamp fechaDeSubida) {
        this.idVideo = idVideo;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.nombreArchivo = nombreArchivo;
        this.nombrePortada = nombrePortada;
        this.fechaDeSubida = fechaDeSubida;
    }

    public Video(int idVideo, String titulo, String descripcion, String nombreArchivo, String nombrePortada, Timestamp fechaDeSubida, Usuario usuario) {
        this.idVideo = idVideo;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.nombreArchivo = nombreArchivo;
        this.nombrePortada = nombrePortada;
        this.fechaDeSubida = fechaDeSubida;
        this.usuario = usuario;
    }

    public int getIdVideo() {
        return idVideo;
    }

    public void setIdVideo(int idVideo) {
        this.idVideo = idVideo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion ) {
        this.descripcion = descripcion;
    }
    
    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public String getNombrePortada() {
        return nombrePortada;
    }

    public void setNombrePortada(String nombrePortada) {
        this.nombrePortada = nombrePortada;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public Timestamp getFechaDeSubida() {
        return fechaDeSubida;
    }

    public void setFechaDeSubida(Timestamp fechaDeSubida) {
        this.fechaDeSubida = fechaDeSubida;
    }

    @Override
    public String toString() {
        return "Video{" + "idVideo=" + idVideo + ", titulo=" + titulo + ", descripcion=" + descripcion + ", nombreArchivo=" + nombreArchivo + ", usuario=" + usuario + '}';
    }

}
