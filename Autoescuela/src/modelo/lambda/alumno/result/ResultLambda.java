/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.lambda.alumno.result;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Formacion
 */
public class ResultLambda {
    private static final String CONSULTAR_TODOS = 
            "SELECT nombre, apellido1, apellido2, dni FROM ALUMNO";
    
    private static final String CONSULTAR_ALUMNO = 
            "SELECT NOMBRE, APELLIDO1, APELLIDO2, DNI, TELEFONO, TIPOALUM, FECHANACIMIENTOALUM FROM ALUMNO WHERE dni = ?";
    
    public static Result RESULT_CTODOS = (con) -> {
        ResultSet rs = null;
        try {
            Statement st = con.createStatement();
            
            rs = st.executeQuery(CONSULTAR_TODOS);
            
            //st.close();
        } catch (SQLException ex){
            
        }
        return rs;
    };
    
    public static ResultAlumno RESULT_CALUMNO = (con,dni) -> {
        ResultSet rs = null;
        try {
            PreparedStatement ps = con.prepareStatement(CONSULTAR_ALUMNO,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            
            ps.setString(1, dni);
            
            rs = ps.executeQuery();
            
            //st.close();
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return rs;
    };
}
