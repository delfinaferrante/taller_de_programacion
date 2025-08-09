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
public class Investigadores {
    private String nombre;
    private int categoria;
    private String especialidad;
    private int maxSubsidios = 5;
    private int dimL = 0;
    private Subsidios[] vecSub = new Subsidios[maxSubsidios];
    
    public Investigadores(String unNombre, int unaCategoria, String unaEspecialidad){
        this.nombre = unNombre;
        this.categoria = unaCategoria;
        this.especialidad = unaEspecialidad;
    }
    public String getNombre(){
        return nombre;
    }
    
    public boolean puedePedirSubsidio(){
        return (dimL < maxSubsidios);
    }
    
    public void agregarSubsidio(Subsidios unSubsidio){
        if (puedePedirSubsidio()){
            vecSub[dimL] = unSubsidio;
            dimL++;
        }
    }
    public double dineroTotalOtorgado(){
        double montoTotal = 0;
        for (int i=0; i<dimL; i++){
           if (vecSub[i].getOtorgado()) 
                montoTotal+= vecSub[i].getMontoPedido();
        }
        return montoTotal;   
    }
    
    public void otorgarSubsidio(){ //le otorgo todos los subsidios que estan no-otorgados
        for (int i=0; i<maxSubsidios;i++){
            if (!vecSub[i].getOtorgado())
                vecSub[i].isOtorgado(true);
        }
    }
    
    public String toString(){
        String aux = " Nombre: " + nombre + " - Categoria: " + categoria + " - Especialidad: " + especialidad +
                    " Total de dinero otorgado en subsidios: $" + dineroTotalOtorgado() + "\n";
        return aux;
    }
}
