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
public class Parcial4 {
    public static void main(String[]args){
        AlumnosDeGrado alumgrado = new AlumnosDeGrado("Pamela Ferrante", 37912771, 5, "Contador Publico");
        AlumnosDoctorado alumdoct = new AlumnosDoctorado("Rodrigo Cañas", 30657912, 4, "Licenciado en Diseño Multimedial", "Universidad de La Plata");
        
        Materias materia1 = new Materias("Matematica Financiera", 7.50, "05/10/2022");
        Materias materia2 = new Materias("Conta V", 5.60, "10/04/2021");
        Materias materia3 = new Materias("Organizacion Judicial", 5.50, "20/05/2022");
        Materias materia4 = new Materias("Logica", 2.50, "14/10/2023");
        alumgrado.agregarMateriaAprobada(materia1);
        alumgrado.agregarMateriaAprobada(materia2);
        alumgrado.agregarMateriaAprobada(materia3);
        alumgrado.agregarMateriaAprobada(materia4);
        
        Materias m1 = new Materias("Lenguaje Multimedial", 7.50, "12/12/2022");
        Materias m2 = new Materias("Tecno IV", 8.50, "11/05/2023");
        Materias m3 = new Materias("Taller de Diseño Multimedial", 3.50, "20/05/2022");
        Materias m4 = new Materias("Teoria de la Practica Artistica", 5.50, "20/05/2022");
        Materias m5 = new Materias("Tis", 9.50, "20/12/2023");
        alumdoct.agregarMateriaAprobada(m1);
        alumdoct.agregarMateriaAprobada(m2);
        alumdoct.agregarMateriaAprobada(m3);
        alumdoct.agregarMateriaAprobada(m4);  
        alumdoct.agregarMateriaAprobada(m5); 
        
        System.out.println(alumdoct.alumnoGraduado(alumdoct));
        System.out.println(alumgrado.alumnoGraduado(alumgrado));
        
        System.out.println(alumdoct.toString());
        System.out.println(alumgrado.toString());
        
    }
}
