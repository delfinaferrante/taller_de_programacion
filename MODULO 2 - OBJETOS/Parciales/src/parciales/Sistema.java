/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parciales;

/**
 *
 * @author Usuario
 */
public class Sistema {
    private int dias = 5;       //filas
    private int turnos = 6;     //columnas
    private Paciente[][] agenda;
    
    public Sistema(){
        agenda = new Paciente[dias][turnos];
        
        for (int i=0; i<dias; i++){
            for(int j=0; j<turnos; j++){
                agenda[i][j]= null;
            }
        }
    }
    
    public void agendarPaciente(Paciente unPaciente, int unDia, int unTurno){
       if (agenda[unDia-1][unTurno-1] == null){
            agenda[unDia-1][unTurno-1] = unPaciente;
            System.out.println("agregado en " + unDia + ", " + unTurno);
       }else
           System.out.println("Ya hay un paciente en el dia " + unDia + " turno " + unTurno);
    }
    
    public String liberarTurnos(int unDia){
        String aux = "";
        for(int j=0; j<turnos; j++){
            if (agenda[unDia-1][j] != null){
                aux+= "Avisar de la cancelacion a: " + agenda[unDia-1][j].toString() + "\n";
                agenda[unDia-1][j] = null;
            }else
                aux+= "No hay ningun paciente \n";
        }
        return aux;
    }
    
    public double recaudacionSemanal(){
        double monto = 0;
        for (int i=0; i<dias; i++){
            for (int j=0; j<turnos; j++){
                monto+= agenda[i][j].getCosto();
            }
        }
        return monto;
    }
}
