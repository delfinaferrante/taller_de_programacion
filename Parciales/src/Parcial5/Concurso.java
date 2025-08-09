/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial5;

/**
 *
 * @author Delfi
 */
public class Concurso {
    private Canciones[][] concurso;
    private int cantCategorias;
    private int cantCanciones;
    
    public Concurso(int cantCategorias, int cantCanciones){
        this.cantCategorias = cantCategorias;
        this.cantCanciones = cantCanciones;
        this.concurso = new Canciones[cantCanciones][cantCategorias];
        for(int i=0; i<cantCanciones;i++){
            for(int j=0; j<cantCategorias;j++){
                concurso[i][j] = null;
            }
        }
    }

    public void agregarCancion(Canciones unaCancion, int unaCategoria){
        int canciones = 0;
        if(concurso[canciones][unaCategoria-1] == null){
            concurso[canciones][unaCategoria-1] = unaCancion;
        }else{
            System.out.println("Lugar ocupado.");
            canciones++;
            if(canciones < cantCanciones){
                concurso[canciones][unaCategoria-1] = unaCancion;
            }
        } 
    }
    
    public void interpretarCancion(int id, Estudiante interpretador, int puntaje){
        for(int i=0; i<cantCanciones; i++){
            for(int j=0; j<cantCategorias; j++){
                if ((concurso[i][j] != null)&&(concurso[i][j].getId() == id)){
                    concurso[i][j].comparoYActualizoPuntaje(puntaje,interpretador);
                }
            }
        }
    }
    
    public Estudiante buscarGanador(int id){
        for(int i=0; i<cantCanciones; i++){
            for(int j=0; j<cantCategorias; j++){
                if ((concurso[i][j] != null)&&(concurso[i][j].getId() == id)){
                    return concurso[i][j].getGanador();
                }
            }
        }
        return null;
    }
    
    public Canciones cancionPuntajeMax(int unaCategoria){
        int puntajeMax = -1;
        Canciones aux = null;
        
        for(int j=0; j<cantCanciones; j++){
            if(concurso[unaCategoria-1][j] != null){
                if(concurso[unaCategoria-1][j].getPuntaje() > puntajeMax){
                    puntajeMax = concurso[unaCategoria-1][j].getPuntaje();
                    aux = concurso[unaCategoria-1][j];
                }
            }
        }
        return aux;
    }
    
}
