/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mvm.daw.casino.model;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
        String fecha_partido_String = request.getParameter("fecha_partido");
        String resultat = request.getParameter("Resultat");
        String equipo = request.getParameter("equipo");
        double apuesta = Double.parseDouble(request.getParameter("apuesta"));
        DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate fecha_partido = LocalDate.parse(fecha_partido_String, formater);
        //String apuestas = "Apuesta: " + nombre + ", ID: " + id + ", Cargo: " + carrec;
        Apuesta apuestas = new Apuesta(nombre, ID, equipo, fecha_partido, apuesta, resultat);
        // añadir los datos del usuario (del formulario) en la lista
        listaApuestas.add(apuestas);
    }
    public void Borrar(List<Apuesta> listaApuestas, HttpServletRequest request) {
        int ID = Integer.parseInt(request.getParameter("ID"));
        for (Apuesta apuesta : listaApuestas) {
            if (apuesta.getID() == ID) {
                listaApuestas.remove(apuesta);
                break;
            }
        }
    }
       public void Mostrar(List<Apuesta> listaApuestas, HttpServletRequest request) {
        int ID = Integer.parseInt(request.getParameter("ID"));
        for (Apuesta apuesta : listaApuestas) {
            if (apuesta.getID() == ID) {
                request.setAttribute("apuesta", apuesta);
                return;
            }
        }
    }
    public void Modificar(List<Apuesta> listaApuestas, HttpServletRequest request) {
        int ID = Integer.parseInt(request.getParameter("ID"));
        for (Apuesta apuesta : listaApuestas) {
            if (apuesta.getID() == ID) {
                String nombre = request.getParameter("nombre");
                String equipo = request.getParameter("equipo");
                String resultat = request.getParameter("Resultat");
                String fechaPartidoString = request.getParameter("fecha_partido");
                double apuestaEconomica = Double.parseDouble(request.getParameter("apuesta"));
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                LocalDate fechaPartido = LocalDate.parse(fechaPartidoString, formatter);
                apuesta.setNombre(nombre);
                apuesta.setEquipo(equipo);
                apuesta.setResultat(resultat);
                apuesta.setFecha_partido(fechaPartido);
                apuesta.setApuesta(apuestaEconomica);
                break;
            }
        }
}}
