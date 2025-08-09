/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PRACTICA3;

public class Ejercicio2 {
    public static void main(String[]args){
        Autor primerAutor = new Autor("Herbert Schildt", 
                "Informático, programador y músico estadounidense. Ha escrito libros sobre varios lenguajes de programación.",
                "Estados Unidos");
        Libro libro1 = new  Libro("Java: A Beginner's Guide",   
                                 "Mcgraw-Hill", 2014, primerAutor,
                                 "978-0071809252", 21.72);
       
        //System.out.println(libro1.toString());
        
        Autor segundoAutor = new Autor("John Horton",
        "prolífico matemático británico, especialista en la teoría de grupos", "Liverpool");
        
        Libro libro2 = new Libro("Learning Java by Building Android Games",  
                              "CreateSpace Independent Publishing", 
                               segundoAutor, "978-1512108347");
        
        System.out.println(libro2.toString());
        System.out.println("Precio del libro2: " + libro2.getPrecio());
        System.out.println("Año edición del libro2: " + libro2.getAñoEdicion());
       // Libro libro3= new Libro(); 
    }
    
    }