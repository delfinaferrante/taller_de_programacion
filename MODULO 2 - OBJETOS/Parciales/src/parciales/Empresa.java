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
public class Empresa {
    private String nombre;
    private String direccion;
    private Director director;
    private int dimF;
    private Encargado[] sucursales; //un vector de los encargados de cada sucursal
    
    public Empresa(String nombre, String direccion, Director director, int cantSucursales){
        this.nombre = nombre;
        this.direccion = direccion;
        this.director = director;
        this.dimF = cantSucursales;
        this.sucursales = new Encargado[dimF];
        
        for (int i=0; i<dimF; i++){
            sucursales[i]= null;
        }
    }
    
    public void asignarEncargado(int sucursal, Encargado unEncargado){
        if (sucursales[sucursal-1] == null){
            sucursales[sucursal-1] = unEncargado;
        } else
            System.out.println("En la sucursal " + sucursal + " ya hay un encargado asignado.");
    }
    
    public String toString(){
        String aux = "Empresa llamada " + nombre + ", ubicada en: " + direccion + "\n" + "Director: " + director.toString();
        
        for (int i=0; i<dimF; i++){
            aux+= "Sucursal numero " + (i+1) + "\n";
            if (sucursales[i]!= null){
                aux+= sucursales[i].toString() + "\n";
            } else
                aux+= "No hay encargados asignados. \n";
        }
        return aux;
    }
}
