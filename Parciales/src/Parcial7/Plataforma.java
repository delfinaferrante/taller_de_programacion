/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial7;

/**
 *
 * @author fer_m
 */
public class Plataforma {
    private String nombre;
    private int suscriptores;
    private int categorias;   //filas
    private int meses = 12;        //columnas
    private Estreno[][] agenda;
    
    public Plataforma(String nombre, int suscriptores, int categorias){
        setNombre(nombre);
        setSuscriptores(suscriptores);
        this.categorias = categorias;
        this.agenda = new Estreno[categorias][meses];
        for(int i=0;i<categorias;i++){
            
            for(int j=0; j<meses; j++){
                agenda[i][j] = null;
            }
        }
    }
    public String getNombre(){
        return nombre;
    }
    
    public int getSuscriptores(){
        return suscriptores;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSuscriptores(int suscriptores) {
        this.suscriptores = suscriptores;
    }
    
    public void registrarEstreno(Estreno unEstreno,int unaCategoria){
        int mes = 0;
        while((mes < meses)&&(agenda[unaCategoria-1][mes] != null)){
            mes++;
        }
        if(agenda[unaCategoria-1][mes] == null){
            agenda[unaCategoria-1][mes] = unEstreno;
        }
    }
    
    public String imprimirEstrenos(int unaCategoria){
        String aux = "ESTRENOS DE LA CATEGORIA " + unaCategoria + "\n";
        for(int i=0; i<meses; i++){
            aux += (i+1) + ": ";
            if(agenda[unaCategoria-1][i] != null){
                aux+= agenda[unaCategoria-1][i].toString();
            }else
                aux+= "No hay estreno. \n";
        }
     return aux;
    }
    
    public double calcularGananciaSeries(){
        double ganancias = 0;
        for(int i=0; i<categorias; i++){
            for(int j=0; j<meses; j++){
                if ((agenda[i][j] != null)&&(agenda[i][j].getContenido().equals("serie"))){
                   ganancias+= agenda[i][j].getRecaudacion()/2;
                }
            }   
        }
        return ganancias;
    }
    
    public String toString(){
        String aux = "PLATAFORMA: " + getNombre() + ", " + getSuscriptores() + " suscriptores. \n";
        for(int i=0; i<categorias; i++){
            aux += "Categoria " + (i+1) + "\n";
            for(int j=0; j<meses; j++){
                aux+= "Mes " + (j+1) + ": ";
                if(agenda[i][j] != null){
                    aux+= agenda[i][j].toString();
                }else
                    aux+= "No hay estreno en este mes. \n";
            }
        }
        return aux;
    }
}
