/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial9;

/**
 *
 * @author fer_m
 */
public class Sandwich /*extends Comun*/{
    private String nombre;
    private Pan unPan;
    private int maxIngredientes;
    private int cantIngredientes;
    private Ingrediente[]ingredientes;
    
    public Sandwich(String nombre, Pan unPan, int maxIngredientes){
        //super(nombre);
        setNombre(nombre);
        this.unPan = unPan;
        this.maxIngredientes = maxIngredientes;
        this.cantIngredientes = 0;
        this.ingredientes = new Ingrediente[maxIngredientes];
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public boolean hayLugar(){
        return cantIngredientes < maxIngredientes;
    }
    
    public void agregarIngrediente(Ingrediente unIngrediente){
        if(hayLugar()){
            ingredientes[cantIngredientes] = unIngrediente;
            cantIngredientes++;
        }else
            System.out.println("No es posible agregar mas ingredientes.");
    }
    
    public double recorrerIngredientes(){
        double costoIngred = 0;
        for(int i=0;i<cantIngredientes;i++){
            costoIngred += ingredientes[i].costoFinal();
        }
        return costoIngred;
    }
    
    public String imprimirIngredientes(){
        String aux = "";
        for(int i=0; i<cantIngredientes; i++){
            aux += "Ingrediente "+ (i+1) + ": " + ingredientes[i].toString() + "\n";
        }
       return aux;
    }
    
    public double costoSandwich(){
        return (recorrerIngredientes() + unPan.costoFinal());
    }
    
    public String toString(){
        String aux = "SANDWICH " + getNombre() + "\n" + unPan.toString() + " - cantidad de ingredientes: " + cantIngredientes +
                    "\n" + imprimirIngredientes() + " - costo final: $" + costoSandwich();
        return aux;
    }
}
