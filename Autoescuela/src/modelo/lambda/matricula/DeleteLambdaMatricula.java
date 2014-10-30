/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.lambda.matricula;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Oscar
 */
public class DeleteLambdaMatricula {
    public static DeleteMatricula DELETE_MATRICULA = (con, id)->{
        try {
            String SQL = "DELETE FROM MATRICULALUMNO WHERE IDALUMNO=?";
            PreparedStatement ps = con.prepareStatement(SQL, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            ps.setInt(1, id);
            
            int filas;
            // Si no hay filas afectadas => No existen referencias en ela tabla al alumno
            if ((filas = ps.executeUpdate())==0)
                return false;
            
            ps.close();
        } catch (SQLException e) {
        }
        return true;
    };
}
