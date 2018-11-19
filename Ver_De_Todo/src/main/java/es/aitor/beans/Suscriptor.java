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
    private int idSuscripcion;
    
    @Column(name="idUsuarioSuscriptor")
    private int idUsuarioSuscriptor;
    
    @ManyToOne
    @JoinColumn(name = "idCanal")
    private Canal idCanal;

    public Suscriptor() {
    }

    public Suscriptor(int idSuscripcion, int idUsuarioSuscriptor) {
        this.idSuscripcion = idSuscripcion;
        this.idUsuarioSuscriptor = idUsuarioSuscriptor;
    }

    public Suscriptor(int idSuscripcion, int idUsuarioSuscriptor, Canal idCanal) {
        this.idSuscripcion = idSuscripcion;
        this.idUsuarioSuscriptor = idUsuarioSuscriptor;
        this.idCanal = idCanal;
    }

    

    public int getIdSuscripcion() {
        return idSuscripcion;
    }

    public void setIdSuscripcion(int idSuscripcion) {
        this.idSuscripcion = idSuscripcion;
    }

    public Canal getIdCanal() {
        return idCanal;
    }

    public void setIdCanal(Canal idCanal) {
        this.idCanal = idCanal;
    }

    public int getIdUsuarioSuscriptor() {
        return idUsuarioSuscriptor;
    }

    public void setIdUsuarioSuscriptor(int idUsuarioSuscriptor) {
        this.idUsuarioSuscriptor = idUsuarioSuscriptor;
    }

    @Override
    public String toString() {
        return "Suscriptor{" + "idSuscripcion=" + idSuscripcion + ", idCanal=" + idCanal + ", idUsuarioSuscriptor=" + idUsuarioSuscriptor + '}';
    }

    

}
