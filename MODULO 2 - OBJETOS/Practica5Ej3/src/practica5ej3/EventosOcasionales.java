/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica5ej3;


public class EventosOcasionales extends Recitales{
    private String motivo;
    private String[] motivos = {"beneficencia", "show de tv", "show privado"};
    private String nombreContratante;
    private String dia;
    
    public EventosOcasionales(String unaBanda, int cantTemas, String unMotivo, String nomContratante, String unDia){
        super(unaBanda,cantTemas);
        this.motivo = unMotivo;
        this.nombreContratante = nomContratante;
        this.dia = unDia;
    }
    
    public double calcularCosto(){
        if (motivo.equals(motivos[0])){
            return 0;
        } else if (motivo.equals(motivos[1])){
            return 50000;
        } else
            return 150000;
    }
    
    public String actuar(){{
        String aux="";
        
        if (motivo.equals(motivos[0])){
            aux = "Recuerden colaborar con " + nombreContratante + super.actuar();
        } else if (motivo.equals(motivos[1])){
            aux = "Saludos amigos televidentes!" + super.actuar();
        } else 
            aux = "Un feliz cumpleaños para " + nombreContratante + super.actuar();
        
        return aux;
    }
    }
}
