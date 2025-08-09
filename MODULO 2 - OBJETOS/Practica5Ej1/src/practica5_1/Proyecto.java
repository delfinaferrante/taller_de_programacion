/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica5_1;

/**
 *
 * @author Usuario
 */
public class Proyecto {
    private String nombre;
    private int codigo;
    private String nombreDirector;
    private int dimF = 50;
    private int dimL = 0;
    private Investigadores[] vecInv = new Investigadores[dimF];
    
    public Proyecto(String unNombre, int unCodigo, String nomDirec){
        this.nombre = unNombre;
        this.codigo = unCodigo;
        this.nombreDirector = nomDirec;
    }
    
    public boolean hayLugar(){
        return (dimL < 50);
    }
    
    public void agregarInvestigador(Investigadores unInvestigador){
        if (hayLugar()){
            vecInv[dimL] = unInvestigador;
            dimL++;
        }
    }
    
    public double dineroTotalProyecto(){
        double montoTotal = 0;
        for (int i=0; i<dimL; i++){
            montoTotal+= vecInv[i].dineroTotalOtorgado();
        }
        return montoTotal;
    }
    
    public void otorgarTodos(String unNombre){
        int pos = 0;
        while ((pos < dimL) && (!vecInv[pos].getNombre().equals(unNombre))){
            pos++;
        }
        if (vecInv[pos].getNombre().equals(unNombre)){
            vecInv[pos].otorgarSubsidio();
        } else
            System.out.println("El investigador " + unNombre + " no esta en el proyecto.");
    }
    
    public String toString(){
        String aux = " ";
        aux = "Proyecto " + nombre + ", codigo: " + codigo + ", director: " + nombreDirector + "\n";
        for (int i=0; i<dimL; i++){
            aux+= "Dinero total del proyecto: $" + dineroTotalProyecto() + "\n" +
                   "Investigador " + (i+1) + vecInv[i].toString();
        }  
        return aux;
    }
    
    
}
