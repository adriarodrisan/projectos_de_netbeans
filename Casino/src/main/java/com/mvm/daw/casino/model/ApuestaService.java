/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mvm.daw.casino.model;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author isard
 */
public class ApuestaService {

    public ApuestaService() {
    }

    public void addApuesta(List<Apuesta> listaApuestas, int ContadorID, HttpServletRequest request) {

        // recuperar los datos del formulario
        String nombre = request.getParameter("nombre");
        int ID = ContadorID;
        String fecha_partido = request.getParameter("fecha_partido");
        String apuesta = request.getParameter("apuesta");
        String equipo= request.getParameter("equipo");
        String resultat = request.getParameter("Resultat");
        //String usuario = "Nombre: " + nombre + ", Correo: " + correu + ", Cargo: " + carrec;
        Apuesta apuestas = new Apuesta(nombre, ID, equipo, fecha_partido, apuesta, resultat);
        // añadir los datos del usuario (del formulario) en la lista
        listaApuestas.add(apuestas);
    }
    public List<Apuesta> Borrar(List<Apuesta> listaApuestas, HttpServletRequest request) {
        List<Apuesta> listaFiltrada = new ArrayList();
        String nombre = request.getParameter("nombre");
        for (Apuesta apuesta: listaApuestas){
                if(apuesta.getID().equals(nombre)){
                    listaApuestas.remove(apuesta);
                    break;
                }
        }
        return listaFiltrada;
    }
}