/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.matriculadao.lambdas;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.matriculadao.interfaces.ResultMatricula;

/**
 *
 * @author Formacion
 */
public class ResultLambdaMatricula {
    public static ResultMatricula RESULT_MATRICULA = (con, id)->{
        ResultSet rs = null;
        try {
            String SQL = "SELECT TIPOCARNET, FECHAALTA, PRECIO FROM MATRICULALUMNO WHERE IDALUMNO=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, id);
            rs = ps.executeQuery();
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        return rs;
    };
}
