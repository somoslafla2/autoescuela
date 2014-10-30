/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.alumnodao.lambdas;

import modelo.alumnodao.interfaces.ResultID;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

/**
 *
 * @author Oscar
 */
public class ResultIDLambda {
    public static ResultID RESULT_ID = (con, dni) -> {
        int id = -1;
        try {
            String SQL = "SELECT IDALUMNO FROM ALUMNO WHERE DNI=?";
            PreparedStatement ps = con.prepareCall(SQL);
            ps.setString(1, dni);
            ResultSet rs = ps.executeQuery();
            rs.next();
            id = rs.getInt("IDALUMNO");
            //Se prepara la llamada
//            CallableStatement cs = con.prepareCall(SQL, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
//            // Se encajan los playholder
//            cs.registerOutParameter(1, Types.INTEGER);
//            cs.setString(2, dni);
//            //Se ejecuta la llamada
//            cs.executeQuery();
//            // Se recoge el id del alumno correspondiente
//            id = cs.getInt(1);
            // Se cierra el callablestatement
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return id;
    };
}
