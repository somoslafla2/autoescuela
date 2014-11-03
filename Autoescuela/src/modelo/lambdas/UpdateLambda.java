/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.lambdas;

import ester.autoescuela.factoriaAlumnos.alumno.Alumno;
import ester.autoescuela.factoriaAlumnos.alumno.AlumnoPresencial;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import llamadas.Llamadas;
import modelo.interfaces.Update;

/**
 *
 * @author Oscar
 */
public class UpdateLambda {
    public static Update<Alumno, Boolean> MODIFICAR_ALUMNO = (Connection con, Alumno alumno)->{
        //Damos valor a los argumentos
        boolean exito = false;
        CallableStatement llamada;
        try {
            llamada = con.prepareCall(Llamadas.OBTENERIDALUMNO);
            //Damos valor a los argumentos
            llamada.registerOutParameter(1, Types.INTEGER);
            llamada.setString(2, alumno.getDni());
            int filas = llamada.executeUpdate();
            Integer id = -1;
            if (filas != 0){
                id = llamada.getInt(1);
            }
            llamada.close();
            if (id != -1){
                llamada = con.prepareCall(Llamadas.MODIFICAR_ALUMNO);
                llamada.setInt(1, id);
                llamada.setString(2, alumno.getNombre());
                llamada.setString(3, alumno.getApellido1());
                llamada.setString(4, alumno.getApellido2());
                llamada.setString(5, alumno.getDni());
                llamada.setString(6, alumno.getTelefono());
                llamada.setString(7, (alumno instanceof AlumnoPresencial ? "PRESENCIAL" : "A DISTANCIA"));
                llamada.setString(8, alumno.fechaToString());

                int filas_afectadas = llamada.executeUpdate();
                System.out.println("las filas afectadas son: " + filas_afectadas);
                exito = true;
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return exito;
    };
}
