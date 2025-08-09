/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica5ej3;


public abstract class Recitales {
   private String nombreBanda;
   private String[] listaTemas; 
   private int dimL;
   private int dimF;
   
   public Recitales(String unaBanda, int cantTemas){
       this.nombreBanda = unaBanda;
       this.dimF = cantTemas;
       this.dimL = 0;
       this.listaTemas = new String[cantTemas];
   }
   
   public boolean hayLugar(){
       return (this.dimL < this.dimF);
   }
   
   public void agregarTema(String unTema){
       if (hayLugar()){
           listaTemas[dimL] = unTema;
           dimL++;
       } else
           System.out.println("Ya no hay mas lugar para agregar temas.");
   }
   public abstract double calcularCosto();
           
   public String actuar(){
       String aux = "";
       for (int i=0; i<dimL; i++){
           aux+= " Y ahora tocaremos... " + listaTemas[i] + "\n";
       }
       return aux;
   }
}
