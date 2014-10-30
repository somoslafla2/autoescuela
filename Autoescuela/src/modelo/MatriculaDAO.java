/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import ester.autoescuela.tipocarnet.TipoCarnet;
import java.sql.Connection;
import java.sql.ResultSet;
import modelo.lambda.matricula.CreateLambda;
import modelo.lambda.matricula.DeleteLambdaMatricula;

/**
 *
 * @author Formacion
 */
public class MatriculaDAO {
    public boolean crearMatricula(Connection con, int id, TipoCarnet c){
        return CreateLambda.CREATE_MATRICULA.create(con, id, c);
    }
    
    public boolean borrar(Connection con, int id){
        return DeleteLambdaMatricula.DELETE_MATRICULA.delete(con, id);
    }
    
    public ResultSet consultar(Connection con, int id){
        return null;
    }
    
    public boolean actualizar(Connection con, int id, TipoCarnet c, boolean acabado){
        return true;
    }
}
