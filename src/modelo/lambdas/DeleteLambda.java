/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.lambdas;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.interfaces.Delete;
import modelo.llamadas.Llamadas;

/**
 *
 * @author Oscar
 */
public class DeleteLambda {
    public static Delete<Integer, Boolean> DELETE = (Connection con, Integer id)->{
        boolean exito = false;
        try (CallableStatement llamada = con.prepareCall(Llamadas.BORRAR_ALUMNO,
                    ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE)){
            //Damos valor a los argumentos
            llamada.setInt(1, id); // recoger el id

            int filas_afectadas = llamada.executeUpdate();
            System.out.println("las filas afectadas son: " + filas_afectadas);

            llamada.close();
            exito = true;
        }catch(SQLException ex){
            
        }
        return exito;
    };
}
