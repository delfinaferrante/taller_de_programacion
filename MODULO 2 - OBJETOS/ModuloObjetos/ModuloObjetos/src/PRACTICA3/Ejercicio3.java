/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PRACTICA3;


public class Ejercicio3 {
    public static void main(String[] args) {
        Estante estante = new Estante();
       
        Autor autor1 = new Autor("Federico Garcia Lorca", "poeta, dramaturgo y prosista español", "España");
		Libro libro1 = new Libro("La casa de Bernarda Alba", "Losada", autor1, "1754BCY GD4475");
        estante.agregarLibro(libro1);
        
        Autor autor2 = new Autor("Gabriel Garcia Marquez", "escritor, guionista, editor de libros y periodista","Colombia");
        Libro libro2 = new Libro("Cien años de soledad", "Sudamericana", autor2, "8558HFT 37512");
		estante.agregarLibro(libro2);
        
        Autor autor3 = new Autor("Louisa May Alcott", "escritora, comprometida con el movimiento abolicionista y el sufragismo","Massachusetts");
        Libro libro3 = new Libro("Mujercitas", "Alianza editorial", autor3, "176HG76 HGY");
		estante.agregarLibro(libro3);
		
		Autor autor4 = new Autor("Julio Cortazar", "escritor y profesor, trabajo como traductor","Argentina");
        Libro libro4 = new Libro("Rayuela", "Debolsillo", autor4, "JUT5743 87GT");
		estante.agregarLibro(libro4);
	
		System.out.println(estante.buscarPorTitulo("Mujercitas"));
	
    }
}
