/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.lambda.alumno.create;

import ester.autoescuela.factoriaAlumnos.alumno.Alumno;
import java.sql.Connection;

/**
 *
 * @author Formacion
 */
public interface Create {
    int create(Connection c, Alumno alumno);
}
