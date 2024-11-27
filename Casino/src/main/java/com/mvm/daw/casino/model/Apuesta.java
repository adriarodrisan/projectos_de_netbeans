package com.mvm.daw.casino.model;


import java.util.Date;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author isard
 */
public class Apuesta {
    int ID;
    String nombre;
    Date fecha_partido;
    int apuesta;
    String equipo;
    public Apuesta(int ID, String nombre, Date fecha_partido, int apuesta, String equipo) {
        this.ID = ID;
        this.nombre = nombre;
        this.fecha_partido = fecha_partido;
        this.apuesta = apuesta;
        this.equipo = equipo;
    }
    public int getID() {
        return ID;
    }
    public String getNombre() {
        return nombre;
    }
    public Date getFecha_partido() {
        return fecha_partido;
    }
    public int getApuesta() {
        return apuesta;
    }
    public String getEquipo() {
        return equipo;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setFecha_partido(Date fecha_partido) {
        this.fecha_partido = fecha_partido;
    }
    public void setApuesta(int apuesta) {
        this.apuesta = apuesta;
    }
    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }
}
