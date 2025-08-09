/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial10;

/**
 *
 * @author fer_m
 */
public class Supermercado {
    private String nombre;
    private String direccion;
    private int gondolas;
    private int estantes; 
    private int posGondola = 0;
    private int posEstante = 0;
    //private int[]dimensiones; 
    private Producto[][]productos;
    
    public Supermercado(String nombre, String direccion, int gondolas, int estantes){
        setNombre(nombre);
        setDireccion(direccion);
        this.gondolas = gondolas;
        this.estantes = estantes; 
        this.productos = new Producto[gondolas][estantes];
        /*this.dimensiones = new int[gondolas]; //vector de dim logicas
        for(int i=0; i<gondolas; i++){
            dimensiones[i] = 0;
        }*/
    }

    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion(){
        return direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public void registrarProducto(Producto unProducto){
        if(posGondola < gondolas){        //si quedan gondolas disponibles
            if(posEstante < estantes){   //si quedan estantes en la gondola actual
                productos[posGondola][posEstante] = unProducto;
                posEstante++;
                
            } else {   //si no quedan estantes disponibles, voy a la otra gondola
                posGondola++;
                posEstante = 0;
                
                if(posGondola < gondolas){
                    productos[posGondola][posEstante] = unProducto;
                    posEstante++;
                } else
                    System.out.println("No hay mas gondolas disponibles.");
            }
        } else
            System.out.println("Supermercado lleno.");
    }
    
    public String imprimirProductos(String unaMarca, int unaGondola){
        String aux = "GONDOLA " + unaGondola + "\n";
        for(int est=0; est<estantes; est++){
            if((productos[unaGondola-1][est] != null)&&(productos[unaGondola-1][est].getMarca().equals(unaMarca))){
                aux+= "Estante " + (est+1) + productos[unaGondola-1][est].toString() + "\n";
            }
        }
        return aux;
    }
    
    public String toString(){
        String aux = "SUPERMERCADO " + getNombre() + "; " + getDireccion() + "\n";
        for(int i=0; i<gondolas; i++){
            aux+= "GONDOLA " + (i+1) + "\n";
            
            for(int j=0; j<estantes; j++){
                aux+= "Estante " + (j+1) + ": ";
                
                if(productos[i][j] != null){
                    aux+= productos[i][j].toString() + "\n";
                } else
                    aux+= "Sin producto. \n";
            }
        }
       return aux; 
    }
}
