/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.lambda.alumno.result;

import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author Formacion
 */
public interface ResultAlumno {
    ResultSet consultarAlumno(Connection con, String dni);
}
