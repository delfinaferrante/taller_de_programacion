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
public abstract class Alumno {
    private String nombre;
    private int dni;
    private int maxMaterias;
    private int dimL;
    private Materias[] materiasAprobadas;
    
    public Alumno(String nombre, int dni, int maxMaterias){
        this.nombre = nombre;
        this.dni = dni;
        this.maxMaterias = maxMaterias;
        this.dimL = 0;
        this.materiasAprobadas = new Materias[maxMaterias];
    }
    
    public boolean estaAprobada(double unaNota){
        return (unaNota >= 4);
    }
    
    public void agregarMateriaAprobada(Materias unaMateria){
        if (estaAprobada(unaMateria.getNota())){
            materiasAprobadas[dimL] = unaMateria;
            dimL++;
        } else
            System.out.println("La materia " + unaMateria.getNombre()+ " esta desaprobada");
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public String alumnoGraduado(Alumno unAlumno){
        int pos = 0;
        if (dimL == maxMaterias){
            while ((pos < dimL) && (!materiasAprobadas[pos].getNombre().equals("Tesis"))){
                pos++;    
            }
        }
        if ((pos<dimL) && (materiasAprobadas[pos].getNombre().equals("Tesis") && (estaAprobada(materiasAprobadas[pos].getNota())))){       
            return "El alumno " + unAlumno.getNombre() + " esta graduado";
        } else
            return "El alumno " + unAlumno.getNombre() + " no llego a graduarse";
    }
    
    public String toString(){
        String aux = " ";
        aux += "DNI: " + dni + ", nombre: " + nombre + ", materias aprobadas: " + dimL + "\n";
        for (int i=0; i<dimL; i++){
            aux+= materiasAprobadas[i].toString();
        }
        return aux;
    }
}
