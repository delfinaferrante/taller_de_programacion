/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parciales;

/**
 *
 * @author Usuario
 */
public class Materias {
    private String nombre;
    private double nota;
    private String fecha;
    
    public Materias(String nombre, double nota, String fecha){
        this.nombre = nombre;
        this.nota = nota;
        this.fecha = fecha;
    }
    
    public double getNota(){
        return nota;
    }
    public String getNombre(){
        return nombre;
    }
    public String toString(){
        String aux = nombre + ", nota: " + nota + ", fecha: " + fecha + "\n";
        return aux;
    }
}
