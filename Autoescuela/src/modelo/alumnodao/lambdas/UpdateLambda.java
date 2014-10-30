/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.alumnodao.lambdas;

import ester.autoescuela.factoriaAlumnos.alumno.AlumnoDistancia;
import ester.autoescuela.factoriaAlumnos.alumno.AlumnoPresencial;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.alumnodao.interfaces.Update;

/**
 *
 * @author Formacion
 */
public class UpdateLambda {
    public static Update UPDATE_LAMBDA = (con, id, alumno) -> {
        // Actualizar los campos de la fila de la base de datos
        try{
            String SQL = "SELECT NOMBRE, APELLIDO1, APELLIDO2, DNI, TELEFONO, TIPOALUM FROM ALUMNO WHERE IDALUMNO = ?";
            PreparedStatement ps = con.prepareCall(SQL, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            rs.first();
            rs.updateString("NOMBRE", alumno.getNombre());
            rs.updateString("APELLIDO1", alumno.getApellido1());
            rs.updateString("APELLIDO2", alumno.getApellido2());
            rs.updateString("DNI", alumno.getDni());
            rs.updateString("TELEFONO", alumno.getTelefono());
            String tipo = "PRESENCIAL";
            if (alumno instanceof AlumnoDistancia)
                tipo = "A DISTANCIA";
            rs.updateString("TIPOALUM", tipo);
            rs.updateRow();
            ps.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return true;
    };
}
