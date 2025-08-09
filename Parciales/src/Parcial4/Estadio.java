/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial4;

/**
 *
 * @author Delfi
 */
public class Estadio {
    private String nombre;
    private String direccion;
    private int capacidad;
    private int filas = 12;         //meses
    private int columnas = 31;      //dias
    private int[] dimL;
    private Concierto[][] agenda;
    
    public Estadio(String nombre, String direccion, int capacidad){
        setNombre(nombre);
        setDireccion(direccion);
        setCapacidad(capacidad);
        this.agenda = new Concierto[this.filas][this.columnas];
        this.dimL = new int[12];  //vector de meses con dimL
        for(int i=0; i<12; i++){
            dimL[i] = 0;
        }
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    
    public boolean hayLugar(int unMes){
        return dimL[unMes-1] < 31;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }
    
    public String getDireccion(){
        return direccion;
    }
    
    public void registrarConcierto(Concierto unConcierto, int unMes){
        if(hayLugar(unMes)){
            agenda[unMes-1][dimL[unMes-1]] = unConcierto;
            dimL[unMes-1]++; 
        }
    }
    
    public String listaDeConciertos(int unMes){
        String aux = " ";
        for(int j=0; j<dimL[unMes-1]; j++){
            aux += "Conciertos en el mes " + (unMes-1) + "\n" + "Dia " + (j+1) + agenda[unMes-1][j].toString() + "\n";
        }
        return aux;
    }
    
    public double obtenerGanancias(int unMes){
        double ganancias = 0;
        for(int j=0; j<dimL[unMes-1]; j++){
            ganancias += agenda[unMes-1][j].getEntradasVendidas() * agenda[unMes-1][j].getPrecioEntrada();
        }
        return ganancias/2;
    }
    
    public String toString(){
        String aux = "ESTADIO " + getNombre() + ", ubicado en " + getDireccion() + ", con capacidad de " + getCapacidad() + " personas. \n";
        for (int i=0; i<filas; i++){
            aux += "MES " + (i+1) + "\n";
            for(int j=0; j<columnas; j++){
                aux += "DIA " + (j+1)+": ";
                if(agenda[i][j] != null){
                    aux += agenda[i][j].toString();
                }else
                    aux += "No hay concierto agendado. \n";
            }
        }
        return aux;
    }
}
