/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.matriculadao.lambdas;

import modelo.matriculadao.interfaces.CreateMatricula;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Formacion
 */
public class CreateLambdaMatricula {
    public static CreateMatricula CREATE_MATRICULA = (con,id,carnet) -> {
        try{
            String SQL = "{call addmatricula(?,?,?)}";
            CallableStatement ps = con.prepareCall(SQL, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            ps.setInt(1,id);
            ps.setString(2, carnet.name());
            ps.setFloat(3, carnet.getPrecio());
            
            int filas = ps.executeUpdate();
            
            if (filas == 0)
                return false;
            
            ps.close();
        } catch(SQLException ex){
            ex.printStackTrace();
            return false;
        }
        return true;
    };
}
