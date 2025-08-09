/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica5ej3;


public class Giras extends Recitales {
    private String nombre;
    private Fecha[]fechas;
    private int dimL;
    private int dimF;
    private int fechaActual = 0;
    
    Giras(String unaBanda, int cantTemas, String nombreGira, int cantFechas){
        super(unaBanda,cantTemas);
        this.nombre = nombreGira;
        this.dimL =  0;
        this.dimF = cantFechas;
        this.fechas = new Fecha[dimF];
    }
    
    public void agregarFecha(Fecha unaFecha){
        if (this.hayLugar()){
            fechas[dimL] = unaFecha;
            dimL++;
        }
    }
    
    public double calcularCosto(){
        return (30000*dimL);
    }
    
    public String actuar(){
        String aux="";
        aux+= "Buenas noches " + fechas[fechaActual].getCiudad() + "\n" + super.actuar();
        fechaActual++;
        return aux;
    }
}
