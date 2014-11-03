/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.lambdas;

import ester.autoescuela.carnet.TipoCarnet;
import ester.autoescuela.factoriaAlumnos.alumno.Alumno;
import ester.autoescuela.factoriaAlumnos.alumno.AlumnoPresencial;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import llamadas.Llamadas;
import modelo.MatriculaAlumno;
import modelo.interfaces.Create;

/**
 *
 * @author Oscar
 */
public class CreateLambda {
//    public static Create<Alumno, TipoCarnet, Integer> CREAR = 
//        (Connection con, Alumno alumno, TipoCarnet carnet)->{
//            // Crear el alumno en la base de datos con el carnet correspondiente
//            Integer id = -1;
//            
//            //Damos valor a los argumentos
//            try (CallableStatement llamada = con.prepareCall(Llamadas.INSERTAR_NUEVO)) {
//                //Damos valor a los argumentos
//                llamada.setString(1, alumno.getNombre());
//                llamada.setString(2, alumno.getApellido1());
//                llamada.setString(3, alumno.getApellido2());
//                llamada.setString(4, alumno.getDni());
//                llamada.setString(5, alumno.getTelefono());
//                llamada.setString(6, (alumno instanceof AlumnoPresencial ? "PRESENCIAL" : "A DISTANCIA"));
//                llamada.setString(7, alumno.fechaToString());
//                llamada.setString(8, carnet.name());
//                llamada.setFloat(9, carnet.getPrecio());
//
//                int filas_afectadas = llamada.executeUpdate();
//                System.out.println("las filas afectadas son: " + filas_afectadas);
//                
//            } catch (SQLException ex){
//                ex.printStackTrace();
//            }
//
//            return id;
//        };
    
    public static Create<MatriculaAlumno, Integer> CREAR2 = 
        (Connection con, MatriculaAlumno mA)->{
            // Crear el alumno en la base de datos con el carnet correspondiente
            Integer id = -1;
            
            try (CallableStatement llamada = con.prepareCall("{?=call INSERTARNUEVO2(?,?,?,?,?,?,?,?,?)}",
                    ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE)) {
                //Damos valor a los argumentos
                llamada.registerOutParameter(1, Types.INTEGER);
                llamada.setString(2, mA.getAlumno().getNombre());
                llamada.setString(3, mA.getAlumno().getApellido1());
                llamada.setString(4, mA.getAlumno().getApellido2());
                llamada.setString(5, mA.getAlumno().getDni());
                llamada.setString(6, mA.getAlumno().getTelefono());
                llamada.setString(7, (mA.getAlumno() instanceof AlumnoPresencial ? "PRESENCIAL" : "A DISTANCIA"));
                llamada.setString(8, mA.getAlumno().fechaToString());
                TipoCarnet c = mA.getCarnet();
                llamada.setString(9, c.name());
                llamada.setFloat(10, c.getPrecio());

                int filas_afectadas = llamada.executeUpdate();
                System.out.println("las filas afectadas son: " + filas_afectadas);
                id = llamada.getInt(1);
                
                llamada.close();
            } catch (SQLException ex){
                ex.printStackTrace();
            }

            return id;
        };
}
