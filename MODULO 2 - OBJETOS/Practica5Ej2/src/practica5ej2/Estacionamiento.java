/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica5ej2;


public class Estacionamiento {
   private String nombre;
   private String direccion;
   private String horaApertura;
   private String horaCierre;
   private int pisos;
   private int plazas;
   private Auto[][] autos;
   
   public Estacionamiento(String unNombre, String unaDireccion){
       this.nombre = unNombre;
       this.direccion = unaDireccion;
       this.horaApertura = "08:00";
       this.horaCierre = "21:00";
       this.pisos = 5;
       this.plazas = 10;
       this.autos = new Auto[pisos][plazas];
       for (int i=0; i<5; i++){
           for(int j=0; j<10; j++)
               autos[i][j] = null;
       }
   }
   
   public Estacionamiento(String unNombre, String unaDireccion, String horaA, String horaC, int pisos, int plazas){
       this.nombre = unNombre;
       this.direccion = unaDireccion;
       this.horaApertura = horaA;
       this.horaCierre = horaC;
       this.pisos = pisos;
       this.plazas = plazas;
       this.autos = new Auto[pisos][plazas];
       for (int i=0; i<pisos; i++){
           for(int j=0; j<plazas; j++)
               autos[i][j] = null;
       }
   }
   
   public boolean lugarLibre(int numPiso, int numPlaza){
       return (autos[numPiso][numPlaza] == null);
   }
   
   public void registrarAuto(Auto unAuto, int numPiso, int numPlaza){
       if (lugarLibre(numPiso, numPlaza)){
           autos[numPiso][numPlaza] = unAuto;
       }
   }
   
   public String buscarAuto(String unaPatente){
       int posPiso = 0;    //filas
       int posPlaza = 0;   //columnas

       while (posPiso <= pisos){
           
           if ( (autos[posPiso][posPlaza] != null) && (autos[posPiso][posPlaza].getPatente().equals(unaPatente))){
               return "El auto con patente " + unaPatente + " está en " + (posPiso+1) + ", " + (posPlaza+1);
           }
           
           posPlaza++; //voy a la siguiente columna
           
           if (posPlaza >= plazas){ //si ya llegue al limite de las columnas, paso a la sig fila
               posPlaza = 0;
               posPiso++;
           }
       }
       
          return "Auto Inexistente";
   }
   
   public int cantAutosUbicados(int numPlaza){
       int cant = 0;
       for (int i=0; i<pisos; i++){
           if (autos[i][numPlaza]!= null){
               cant++;
           }
       }
       return cant;
   }
   
   @Override 
   public String toString(){
       String aux = " ";
       for (int i=0; i<pisos; i++){
           aux+= "\n -- Piso " + (i+1) + " -- \n";
           for(int j=0; j<plazas; j++){
               aux+= "Plaza " + (j+1);
               
               if (!lugarLibre(i, j)){
                   aux+= " - Ocupado por " + autos[i][j].toString(); 
               } else
                   aux+= " - Libre ";
           }
       }
       return aux;
   }
}
