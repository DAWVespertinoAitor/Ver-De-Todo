/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.aitor.beans;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;
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
@Table(name="canales")
public class Canal implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="idCanal")
    private int idCanal;
    @Column(name="nombre", length=80)
    private String nombre;
    @Column(name="numSuscriptores")
    private int numSuscriptores;

    @OneToOne(cascade={CascadeType.ALL})
    @PrimaryKeyJoinColumn
    private Usuario idUsuario;
    
    @OneToMany(cascade = {CascadeType.ALL}, fetch=FetchType.EAGER)
    @JoinColumn(name="idCanal")
    private List<Suscriptor> idSuscriptor;
    
    public Canal() {
    }

    public Canal(int idCanal, String nombre, int numSuscriptores) {
        this.idCanal = idCanal;
        this.nombre = nombre;
        this.numSuscriptores = numSuscriptores;
    }
    
//    public Canal(int idCanal, String nombre, int numSuscriptores /*, Usuario idUsuario*/) {
//        this.idCanal = idCanal;
//        this.nombre = nombre;
//        this.numSuscriptores = numSuscriptores;
////        this.idUsuario = idUsuario;
//    }

    public Canal(int idCanal, String nombre, int numSuscriptores, /*Usuario idUsuario,*/ List<Suscriptor> idSuscriptor) {
        this.idCanal = idCanal;
        this.nombre = nombre;
        this.numSuscriptores = numSuscriptores;
//        this.idUsuario = idUsuario;
        this.idSuscriptor = idSuscriptor;
    }

    public int getIdCanal() {
        return idCanal;
    }

    public void setIdCanal(int idCanal) {
        this.idCanal = idCanal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumSuscriptores() {
        return numSuscriptores;
    }

    public void setNumSuscriptores(int numSuscriptores) {
        this.numSuscriptores = numSuscriptores;
    }

//    public Usuario getIdUsuario() {
//        return idUsuario;
//    }
//
//    public void setIdUsuario(Usuario idUsuario) {
//        this.idUsuario = idUsuario;
//    }

    public List<Suscriptor> getIdSuscriptor() {
        return idSuscriptor;
    }

    public void setIdSuscriptor(List<Suscriptor> idSuscriptor) {
        this.idSuscriptor = idSuscriptor;
    }

    @Override
    public String toString() {
        return "Canal{" + "idCanal=" + idCanal + ", nombre=" + nombre + ", numSuscriptores=" + numSuscriptores /*+ ", idUsuario=" + idUsuario*/ + ", idSuscriptor=" + idSuscriptor + '}';
    }

    
    
}
