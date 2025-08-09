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
public class AlumnosDoctorado extends Alumno{
    private String titulo;
    private String universidad;
    
    public AlumnosDoctorado(String nombre, int dni, int maxMaterias, String titulo, String universidad){
        super(nombre, dni, maxMaterias);
        this.titulo = titulo;
        this.universidad = universidad;
    }
    
    public String toString(){
        String aux = "ALUMNO DE DOCTORADO: " + super.toString() + "; esta graduado con titulo " + titulo + " de la universidad: " +
                universidad + "\n";
        return aux;
    }
}
