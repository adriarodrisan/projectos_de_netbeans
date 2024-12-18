package com.mvm.daw.casino.model;

import java.time.LocalDate;

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
    LocalDate fecha_partido;
    double apuesta;
    String equipo;
    String resultat;
    int ID;
    String liga;
    boolean ganar;

    public Apuesta(String nombre, int ID, String resultat, LocalDate fecha_partido, double apuesta, String equipo, String liga,boolean ganar) {
        this.nombre = nombre;
        this.fecha_partido = fecha_partido;
        this.apuesta = apuesta;
        this.equipo = equipo;
        this.resultat = resultat;
        this.ID = ID;
        this.liga = liga;
        this.ganar=  ganar;
    }

    public boolean isGanar() {
        return ganar;
    }
    public void setGanar(boolean ganar) {
        this.ganar = ganar;
    }
    public String getLiga() {
        return liga;
    }
    public void setLiga(String liga) {
        this.liga = liga;
    }

    public int getID() {
        return ID;
    }
    public String getNombre() {
        return nombre;
    }

    public LocalDate getFecha_partido() {
        return fecha_partido;
    }

    public double getApuesta() {
        return apuesta;
    }
    public String getEquipo() {
        return equipo;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setFecha_partido(LocalDate fecha_partido) {
        this.fecha_partido = fecha_partido;
    }
    public void setApuesta(double apuesta) {
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
