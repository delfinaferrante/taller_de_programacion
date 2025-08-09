/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial7;

/**
 *
 * @author fer_m
 */
public class Estreno {
    private String titulo;
    private String contenido;
    private double recaudacion;
    private int visualizaciones;
    
    public Estreno(String titulo, String contenido, double recaudacion, int visualizaciones){
        setTitulo(titulo);
        setContenido(contenido);
        setRecaudacion(recaudacion);
        setVisualizaciones(visualizaciones);
    }

    public String getTitulo() {
        return titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public double getRecaudacion() {
        return recaudacion;
    }

    public int getVisualizaciones() {
        return visualizaciones;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public void setRecaudacion(double recaudacion) {
        this.recaudacion = recaudacion;
    }

    public void setVisualizaciones(int visualizaciones) {
        this.visualizaciones = visualizaciones;
    }
    
    public String toString(){
        String aux = "(Titulo: " + getTitulo() + ", contenido: " + getContenido() + ", recaudación: $" +
                    getRecaudacion() + ", " + getVisualizaciones() + " visualizaciones). \n";
        return aux;
    }
}
