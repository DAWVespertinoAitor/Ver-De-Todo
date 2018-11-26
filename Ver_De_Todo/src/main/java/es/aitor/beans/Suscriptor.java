/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.aitor.beans;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="suscriptores")
public class Suscriptor implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="idSuscriptor")
    private int idSuscriptor;
    
    @Column(name="idUsuarioSuscriptor")
    private int idUsuarioSuscriptor;
    
//    @ManyToOne
//    @JoinColumn(name = "idUsuario")
    private int idUsuario;

    public Suscriptor() {
    }

    public Suscriptor(int idSuscriptor, int idUsuarioSuscriptor) {
        this.idSuscriptor = idSuscriptor;
        this.idUsuarioSuscriptor = idUsuarioSuscriptor;
    }

    public Suscriptor(int idSuscriptor, int idUsuarioSuscriptor, int idUsuario) {
        this.idSuscriptor = idSuscriptor;
        this.idUsuarioSuscriptor = idUsuarioSuscriptor;
        this.idUsuario = idUsuario;
    }

    public int getIdSuscriptor() {
        return idSuscriptor;
    }

    public void setIdSuscriptor(int idSuscriptor) {
        this.idSuscriptor = idSuscriptor;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdUsuarioSuscriptor() {
        return idUsuarioSuscriptor;
    }

    public void setIdUsuarioSuscriptor(int idUsuarioSuscriptor) {
        this.idUsuarioSuscriptor = idUsuarioSuscriptor;
    }

    @Override
    public String toString() {
        return "Suscriptor{" + "idSuscriptor=" + idSuscriptor + ", idUsuario=" + idUsuario + ", idUsuarioSuscriptor=" + idUsuarioSuscriptor + '}';
    }

    

    

}
