package com.mvm.daw.casino.model;


import java.util.UUID;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author isard
 */
public class Apuesta {
    String nombre;
    String fecha_partido;
    String apuesta;
    String equipo;
    String resultat;
    int ID;
    public Apuesta(String nombre, int ID, String fecha_partido, String equipo, String resultat, String apuesta) {
        this.ID= ID;
        this.nombre = nombre;
        this.fecha_partido = fecha_partido;
        this.apuesta = apuesta;
        this.equipo = equipo;
        this.resultat = resultat;
    }

    public int getID() {
        return ID;
    }
    public String getNombre() {
        return nombre;
    }
    public String getFecha_partido() {
        return fecha_partido;
    }
    public String getApuesta() {
        return apuesta;
    }
    public String getEquipo() {
        return equipo;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setFecha_partido(String fecha_partido) {
        this.fecha_partido = fecha_partido;
    }
    public void setApuesta(String apuesta) {
        this.apuesta = apuesta;
    }
    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    public void setResultat(String resultat) {
        this.resultat = resultat;
    }
    public String getResultat() {
        return resultat;
    }
}
