/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import ester.autoescuela.tipocarnet.TipoCarnet;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.alumnodao.lambdas.ResultLambda;
import modelo.matriculadao.lambdas.CreateLambdaMatricula;
import modelo.matriculadao.lambdas.DeleteLambdaMatricula;
import modelo.matriculadao.lambdas.ResultLambdaMatricula;

/**
 *
 * @author Formacion
 */
public class MatriculaDAO {
    public boolean crearMatricula(Connection con, int id, TipoCarnet c){
        return CreateLambdaMatricula.CREATE_MATRICULA.create(con, id, c);
    }
    
    public boolean borrar(Connection con, int id){
        return DeleteLambdaMatricula.DELETE_MATRICULA.delete(con, id);
    }
    
    public String consultar(Connection con, int id){
        String resultado = "";
        try (ResultSet rs = ResultLambdaMatricula.RESULT_MATRICULA.consultar(con,id)){
            resultado += "MATRICULAS ------------\n";
            while(rs.next()){
                resultado+="- "+rs.getString("TIPOCARNET")+" "+
                        rs.getDate("FECHAALTA")+" "+rs.getFloat("PRECIO")+"\n";
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return resultado;
    }
    
    public boolean actualizar(Connection con, int id, TipoCarnet c, boolean acabado){
        return true;
    }
}
