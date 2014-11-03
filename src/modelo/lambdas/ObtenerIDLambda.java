/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.lambdas;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import modelo.interfaces.Result;
import modelo.llamadas.Llamadas;

/**
 *
 * @author Oscar
 */
public class ObtenerIDLambda {
    public static Result<String,Integer> RESULTID = (Connection con, String dni)->{
        Integer id = -1;
        
        try (CallableStatement llamada = con.prepareCall(Llamadas.OBTENERIDALUMNO)) {
            //Damos valor a los argumentos
            llamada.registerOutParameter(1, Types.INTEGER);
            llamada.setString(2, dni);

            int filas_afectadas = llamada.executeUpdate();
            System.out.println("las filas afectadas son: " + filas_afectadas);
            id = llamada.getInt(1);

            llamada.close();
        } catch (SQLException ex){
            ex.printStackTrace();
        }

        return id;
    };
}
