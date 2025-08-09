/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial2;

/**
 *
 * @author Delfi
 */
public class ProgramadorLider extends Programador{
    private int antiguedad;
    private int cantProyectos;
    
    public ProgramadorLider(String nombre, int dni, double sueldo, int cantLineas, String lenguajeFav,
                            int antiguedad, int cantProyectos){
        super(nombre,dni,sueldo,cantLineas,lenguajeFav);
        setAntiguedad(antiguedad);
        setCantProyectos(cantProyectos);
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public int getCantProyectos() {
        return cantProyectos;
    }
    
    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public void setCantProyectos(int cantProyectos) {
        this.cantProyectos = cantProyectos;
    }
    
    public double calcularSueldoFinal(){
        double incremento = super.calcularSueldoFinal();
        incremento += (10000 * getAntiguedad()) + (20000 * getCantProyectos());
        return incremento;
    }
    
    public String toString(){
        String aux = super.toString();
        return aux;
    }
}
