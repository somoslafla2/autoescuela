/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.lambdas;

import ester.autoescuela.carnet.TipoCarnet;
import ester.autoescuela.excepciones.AlumnoMalFormado;
import ester.autoescuela.factoriaAlumnos.alumno.Alumno;
import ester.autoescuela.factoriaAlumnos.factoria.CreadorAlumnoDistancia;
import ester.autoescuela.factoriaAlumnos.factoria.CreadorAlumnoPresencial;
import ester.autoescuela.factoriaAlumnos.factoria.FactoriaAlumnado;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Calendar;
import java.util.GregorianCalendar;
import llamadas.Llamadas;
import modelo.MatriculaAlumno;
import modelo.interfaces.Result;

/**
 *
 * @author Oscar
 */
public class ResultLambda {
    public static Result<Object,ResultSet> CONSULTAR_TODO = (Connection con, Object a)->{
        ResultSet rs = null;
        try {
            rs = con.createStatement().executeQuery(Llamadas.CONSULTAR_TODO);
            
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        
        return rs;
    };
    
    public static Result<Integer,MatriculaAlumno> CONSULTAR_ALUMNO = (Connection con, Integer id)->{
        MatriculaAlumno ma = null;
        CallableStatement llamada;
        try{
            llamada = con.prepareCall("{?=call SACAR(?,?,?,?,?,?,?)}", ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);

            llamada.registerOutParameter(1, Types.VARCHAR);
            llamada.setInt(2, id);
            llamada.registerOutParameter(3, Types.VARCHAR);
            llamada.registerOutParameter(4, Types.VARCHAR);
            llamada.registerOutParameter(5, Types.VARCHAR);
            llamada.registerOutParameter(6, Types.VARCHAR);
            llamada.registerOutParameter(7, Types.VARCHAR);
            llamada.registerOutParameter(8, Types.DATE);

            int filas=llamada.executeUpdate();
            System.out.println(filas);
            FactoriaAlumnado f;
            if (llamada.getString(7).equals("PRESENCIAL")){
                f = new CreadorAlumnoPresencial();
            } else {
                f = new CreadorAlumnoDistancia();
            }
            Calendar c = new GregorianCalendar();
            c.setTime(llamada.getDate(8));
            Alumno a = null;
            try{
                a = f.crearAlumno(llamada.getString(1), llamada.getString(3), 
                    llamada.getString(4), llamada.getString(5), llamada.getString(6), c);
                ma = new MatriculaAlumno(a, TipoCarnet.A);
            }catch(AlumnoMalFormado ex){}
            
            llamada.close();  
            
            llamada = con.prepareCall("SELECT TIPOCARNET, FECHAALTA FROM MATRICULALUMNO WHERE IDALUMNO=?");
            llamada.setInt(1, id);
            ResultSet rs = llamada.executeQuery();
            while(rs.next()){
                ma.setCarnets(TipoCarnet.valueOf(rs.getString("TIPOCARNET")));
                c = new GregorianCalendar();
                c.setTime(rs.getDate("FECHAALTA"));
                ma.setFechaAlta(c);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        
        return ma;
    };
}
