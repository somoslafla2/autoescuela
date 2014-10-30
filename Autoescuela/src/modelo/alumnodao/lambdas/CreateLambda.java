/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.alumnodao.lambdas;

import ester.autoescuela.factoriaAlumnos.alumno.AlumnoPresencial;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Formacion
 */
public class CreateLambda {
    private static final String LLAMADA_INSERTAR = "{? = call addalumno(?,?,?,?,?,?,?)}";
    
    public static modelo.alumnodao.interfaces.Create CREATE_ALUMNO = (conexion, alumno) -> {
        int id = -1;
        try{
            CallableStatement llamada = conexion.prepareCall(LLAMADA_INSERTAR,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            
            llamada.registerOutParameter(1, Types.INTEGER);
            llamada.setString(2, alumno.getNombre());
            llamada.setString(3, alumno.getApellido1());
            llamada.setString(4, alumno.getApellido2());
            llamada.setString(5, alumno.getDni());
            llamada.setString(6, alumno.getTelefono());
            String tipo = "A DISTANCIA";
            if (alumno instanceof AlumnoPresencial)
                tipo = "PRESENCIAL";
            llamada.setString(7, tipo);
            
            GregorianCalendar fnac = alumno.getFechaNacimiento();
            String fecha = fnac.get(Calendar.MONTH)+"/"
                            + fnac.get(Calendar.DATE)+"/"
                            + fnac.get(Calendar.YEAR);
            System.out.println(fecha);
            llamada.setString(8, fecha);          
            
            llamada.executeQuery();
            
            id = llamada.getInt(1);
            if (id == -1){
                System.out.println("Ya esta registrado");
                return id;
            }
        } catch (SQLException ex){
            
            System.out.println("Vamos mal...");
            ex.printStackTrace();
            return id;
        }
        
        return id;
    };
}
