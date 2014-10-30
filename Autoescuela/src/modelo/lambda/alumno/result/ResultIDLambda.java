/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.lambda.alumno.result;

import java.sql.CallableStatement;
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
            String SQL = "{? = call getidalumno(?)}";
            //Se prepara la llamada
            CallableStatement cs = con.prepareCall(SQL, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            // Se encajan los playholder
            cs.registerOutParameter(1, Types.INTEGER);
            cs.setString(2, dni);
            //Se ejecuta la llamada
            cs.executeQuery();
            // Se recoge el id del alumno correspondiente
            id = cs.getInt(1);
            // Se cierra el callablestatement
            cs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return id;
    };
}
