/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ester.autoescuela.factoriaAlumnos.factoria;

import ester.autoescuela.excepciones.AlumnoMalFormado;
import ester.autoescuela.factoriaAlumnos.alumno.Alumno;
import ester.autoescuela.factoriaAlumnos.alumno.AlumnoPresencial;
import java.util.Calendar;

/**
 *
 * @author Formacion
 */
public  class CreadorAlumnoPresencial extends FactoriaAlumnado {

    @Override
    public Alumno crearAlumno(String nombre, String apellido1, String apellido2, 
            String dni, String telefono, Calendar fechaNacimiento) throws AlumnoMalFormado{        
        return new AlumnoPresencial(nombre, apellido1, apellido2, dni, telefono, fechaNacimiento);
    }
    
}
