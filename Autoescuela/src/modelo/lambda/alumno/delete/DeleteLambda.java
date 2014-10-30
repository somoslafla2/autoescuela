/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.lambda.alumno.delete;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Formacion
 */
public class DeleteLambda {
    
    public static Delete DELETE_LAMBDA = (con,id) -> {
        try{
            String SQL = "DELETE FROM ALUMNO WHERE IDALUMNO=?";
            PreparedStatement ps = con.prepareStatement(SQL, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            ps.setInt(1,id);
            
            int filas = ps.executeUpdate();
            
            if (filas == 0) // NO EXISTE EL ID EN LA TABLA ALUMNO
                return false;
            
            ps.close();
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        return true;
    };
}
