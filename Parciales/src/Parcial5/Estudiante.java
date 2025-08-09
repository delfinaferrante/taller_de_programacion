/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial5;

/**
 *
 * @author Delfi
 */
public class Estudiante {
    private String nombre;
    private String apellido;
    private int dni;
    
    public Estudiante(String nombre, String apellido, int dni){
        setNombre(nombre);
        setApellido(apellido);
        setDni(dni);
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }
    
}
