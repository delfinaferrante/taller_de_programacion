/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PRACTICA3;

public class Estante {
    private int cantLibros;
    private Libro libros[];
    
    Estante(){
		libros = new Libro[20];
		cantLibros = 0;  
    }
    
    public int cantLibrosAlmacenados(){
        return cantLibros;
    }
    
    public boolean estanteLleno(){
        return (cantLibros == 20);
    }  
    
    public void agregarLibro(Libro unLibro){
        if (!estanteLleno()){
            libros[cantLibros] = unLibro;
            cantLibros++;
        } else {
            System.out.println("ESTANTE LLENO.");
        }
    }
    
    public Libro buscarPorTitulo(String titulo){
        int pos = 0;
        while ( (pos < cantLibros) && (!(libros[pos].getTitulo().equals(titulo)))){
            pos++;
        }
		if (pos < cantLibros){
			return (libros[pos]);
		} else {
			return null;
    }  
}
	
}
