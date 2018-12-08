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
@Table(name="peliculas")
public class Pelicula implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="idPelicula")
    private int idPelicula;
    
    @Column(name="titulo", length=50)
    private String titulo;
    
    @Column(name="fechaDeSubida")
    private Timestamp fechaDeSubida;
    
    @Column(name="genero", length=30)
    private String genero;
    
    @Column(name="pais", length=20)
    private String pais;
    
    @Column(name="director", length=30)
    private String director;
    
    @Column(name="sinopsis")
    private String sinopsis;
    
    @Column(name="actores")
    private String actores;
    
    @Column(name="nombreArchivo")
    private String nombreArchivo;
    
    @Column(name="subtitulos")
    private char subtitulos; //E=español, I=ingles, L=latino
    
    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    public Pelicula() {
    }

    public Pelicula(int idPelicula, String titulo, Timestamp fechaDeSubida, String genero, String pais, String director, String sinopsis, String actores, String nombreArchivo, char subtitulos) {
        this.idPelicula = idPelicula;
        this.titulo = titulo;
        this.fechaDeSubida = fechaDeSubida;
        this.genero = genero;
        this.pais = pais;
        this.director = director;
        this.sinopsis = sinopsis;
        this.actores = actores;
        this.nombreArchivo = nombreArchivo;
        this.subtitulos = subtitulos;
    }
    
    public Pelicula(int idPelicula, String titulo, Timestamp fechaDeSubida, String genero, String pais, String director, String sinopsis, String actores, String nombreArchivo, char subtitulos, Usuario usuario) {
        this.idPelicula = idPelicula;
        this.titulo = titulo;
        this.fechaDeSubida = fechaDeSubida;
        this.genero = genero;
        this.pais = pais;
        this.director = director;
        this.sinopsis = sinopsis;
        this.actores = actores;
        this.nombreArchivo = nombreArchivo;
        this.subtitulos = subtitulos;
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Timestamp getFechaDeSubida() {
        return fechaDeSubida;
    }

    public void setFechaDeSubida(Timestamp fechaDeSubida) {
        this.fechaDeSubida = fechaDeSubida;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getActores() {
        return actores;
    }

    public void setActores(String actores) {
        this.actores = actores;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }
    
    public char getSubtitulos() {
        return subtitulos;
    }

    public void setSubtitulos(char subtitulos) {
        this.subtitulos = subtitulos;
    }

    @Override
    public String toString() {
        return "Pelicula{" + "idPelicula=" + idPelicula + ", titulo=" + titulo +/* ", estreno=" + estreno +*/ ", genero=" + genero + ", pais=" + pais + ", director=" + director + ", sinopsis=" + sinopsis + ", actores=" + actores + ", nombreArchivo=" + nombreArchivo + ", subtitulos=" + subtitulos + ", usuario=" + usuario + '}';
    }
    
    
}
