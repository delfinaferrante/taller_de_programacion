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
public class AlumnosDeGrado extends Alumno{
    private String carrera;
  
    public AlumnosDeGrado(String nombre, int dni, int maxMaterias, String carrera){
        super(nombre, dni, maxMaterias);
        this.carrera = carrera;
    }
    
    public String toString(){
        String aux = "ALUMNO DE GRADO: " + super.toString() + "; esta graduado de la carrera " + carrera;
        return aux;
    }
}
