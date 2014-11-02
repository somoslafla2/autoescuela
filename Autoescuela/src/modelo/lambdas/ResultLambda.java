/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.lambdas;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        
        return null;
    };
}
