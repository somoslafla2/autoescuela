/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import ester.autoescuela.factoriaAlumnos.alumno.Alumno;
import ester.autoescuela.factoriaAlumnos.factoria.CreadorAlumnoDistancia;
import ester.autoescuela.factoriaAlumnos.factoria.CreadorAlumnoPresencial;
import ester.autoescuela.factoriaAlumnos.factoria.FactoriaAlumnado;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;
import modelo.lambda.alumno.create.CreateLambda;
import modelo.lambda.alumno.delete.DeleteLambda;
import modelo.lambda.alumno.result.ResultIDLambda;
import modelo.lambda.alumno.result.ResultLambda;
import modelo.lambda.alumno.update.UpdateLambda;

/**
 *
 * @author Formacion
 */
public class AlumnoDAO {
    
    private Collection<Alumno> alumnos;

    public AlumnoDAO(Collection<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public Collection<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(Collection<Alumno> alumnos) {
        this.alumnos = alumnos;
    }
    
    public int create(Connection con, Alumno alumno){
        return CreateLambda.CREATE_ALUMNO.create(con, alumno);
    }
    
    public String resultTodo(Connection con) {
        String resultado = null;
        try (ResultSet rs = ResultLambda.RESULT_CTODOS.consultarTodo(con)) {
            resultado = "Nombre\tApellido1\tApellido2\tDNI\n";
            
            while (rs.next()){
                resultado += rs.getString("NOMBRE")+"\t"+
                        rs.getString("APELLIDO1")+" \t"+
                        rs.getString("APELLIDO2")+"\t"+
                        rs.getString("DNI")+"\n";
            };
            rs.close();
            
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        return resultado;
    }
    
    public boolean resultAlumno(Connection con, String dni){
        try (ResultSet rs = ResultLambda.RESULT_CALUMNO.consultarAlumno(con,dni)) {
            while (rs.next()){
                System.out.println(rs.isClosed());
                // Crear los alumnos e insertarlos en la colleccion
                String nombre = rs.getString("NOMBRE");
                String ap1 = rs.getString("APELLIDO1");
                String ap2 = rs.getString("APELLIDO2");
                String adni = rs.getString("DNI");
                String tlfn = rs.getString("TELEFONO");
                String tipo = rs.getString("TIPOALUM");
                Date fecha = rs.getDate("FECHANACIMIENTOALUM");
                Calendar c = new GregorianCalendar();
                c.setTime(fecha);
                FactoriaAlumnado f;
                if (tipo.equals("PRESENCIAL")){
                    f = new CreadorAlumnoPresencial();
                }else
                    f = new CreadorAlumnoDistancia();
                
                alumnos.add(f.crearAlumno(nombre, ap1, ap2, dni, tlfn, (GregorianCalendar) c));
            }
            rs.close();
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        return true;
    }
    
    public boolean update(Connection con, Alumno alumno){
        return UpdateLambda.UPDATE_LAMBDA.update(con);
    }
    
    public boolean delete (Connection con, int id){
        return DeleteLambda.DELETE_LAMBDA.delete(con,id);
    }
    
    public int getID(Connection con, String dni){
        return ResultIDLambda.RESULT_ID.result(con, dni);
    }
}
