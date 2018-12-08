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

/**
 *
 * @author Rodrigo
 */
@Entity
@Table(name="series")
public class Serie implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="idSerie")
    private int idSerie;
    private String tituloSerie;
    private String temporada;
    private String tituloCapitulo;
    private int numCapitulo;
    private String idioma;
    private char subtitulos; //E=Español, I=Ingles, L=Latino;
    @Column(name="nombreArchivo")
    private String nombreArchivo;
    private String descripcion;
    @Column(name="fechaDeSubida")
    private Timestamp fechaDeSubida;
    
    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    public Serie() {
    }

    public Serie(int idSerie, String tituloSerie, String temporada, String tituloCapitulo, int numCapitulo, String idioma, char subtitulos, String nombreArchivo, String descripcion, Timestamp fechaDeSubida) {
        this.idSerie = idSerie;
        this.tituloSerie = tituloSerie;
        this.temporada = temporada;
        this.tituloCapitulo = tituloCapitulo;
        this.numCapitulo = numCapitulo;
        this.idioma = idioma;
        this.subtitulos = subtitulos;
        this.nombreArchivo = nombreArchivo;
        this.descripcion = descripcion;
        this.fechaDeSubida = fechaDeSubida;
    }

    public Serie(int idSerie, String tituloSerie, String temporada, String tituloCapitulo, int numCapitulo, String idioma, char subtitulos, String nombreArchivo, String descripcion, Timestamp fechaDeSubida, Usuario usuario) {
        this.idSerie = idSerie;
        this.tituloSerie = tituloSerie;
        this.temporada = temporada;
        this.tituloCapitulo = tituloCapitulo;
        this.numCapitulo = numCapitulo;
        this.idioma = idioma;
        this.subtitulos = subtitulos;
        this.nombreArchivo = nombreArchivo;
        this.descripcion = descripcion;
        this.fechaDeSubida = fechaDeSubida;
        this.usuario = usuario;
    }

    public int getIdSerie() {
        return idSerie;
    }

    public void setIdSerie(int idSerie) {
        this.idSerie = idSerie;
    }

    public String getTituloCapitulo() {
        return tituloCapitulo;
    }

    public void setTituloCapitulo(String tituloCapitulo) {
        this.tituloCapitulo = tituloCapitulo;
    }

    public int getNumCapitulo() {
        return numCapitulo;
    }

    public void setNumCapitulo(int numCapitulo) {
        this.numCapitulo = numCapitulo;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public char getSubtitulos() {
        return subtitulos;
    }

    public void setSubtitulos(char subtitulos) {
        this.subtitulos = subtitulos;
    }
    
    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTituloSerie() {
        return tituloSerie;
    }

    public void setTituloSerie(String tituloSerie) {
        this.tituloSerie = tituloSerie;
    }

    public String getTemporada() {
        return temporada;
    }

    public void setTemporada(String temporada) {
        this.temporada = temporada;
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
        return "Serie{" + "idSerie=" + idSerie + ", tituloSerie=" + tituloSerie + ", temporada=" + temporada + ", tituloCapitulo=" + tituloCapitulo + ", numCapitulo=" + numCapitulo + ", idioma=" + idioma + ", subtitulos=" + subtitulos + ", nombreArchivo=" + nombreArchivo + ", descripcion=" + descripcion + ", usuario=" + usuario + '}';
    }

}
