/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica5ej3;


public class Practica5Ej3 {

  
    public static void main(String[] args) {
        EventosOcasionales evento = new EventosOcasionales("One Direction", 5, "show privado", "Delfina Ferrante", "2 de mayo");
        Giras gira = new Giras("No Te Va Gustar", 10, "Gira latinoamerica", 10);
        
        evento.agregarTema("One way or another");
        evento.agregarTema("Best song ever");
        evento.agregarTema("You & I");
        
        gira.agregarTema("A las nueve");
        gira.agregarTema("Ese maldito momento");
        gira.agregarTema("Al vacío");
        gira.agregarTema("Chau");
        gira.agregarTema("Perfecto");
        
        
        Fecha fecha1 = new Fecha("Buenos Aires", "05 de diciembre");
        Fecha fecha2 = new Fecha("Mar Del Plata", "17 de abril");
        Fecha fecha3 = new Fecha("Chile", "22 de mayo");
        Fecha fecha4 = new Fecha("Venezuela", "27 de agosto");
        Fecha fecha5 = new Fecha("Ushuaia", "28 de febrero");
        
        gira.agregarFecha(fecha1);
        gira.agregarFecha(fecha2);
        gira.agregarFecha(fecha3);
        gira.agregarFecha(fecha4);
        gira.agregarFecha(fecha5);
        gira.agregarFecha(fecha5);

        
        System.out.println("Costo de evento: $" + evento.calcularCosto());
        System.out.println("Costo de gira: $" + gira.calcularCosto() + "\n");
        System.out.println(evento.actuar() + "\n");
        System.out.println(gira.actuar() + "\n");
        System.out.println(gira.actuar());

    }
    
}
