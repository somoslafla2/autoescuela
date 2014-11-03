/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import ester.autoescuela.factoriaAlumnos.alumno.Alumno;
import ester.autoescuela.factoriaAlumnos.alumno.AlumnoPresencial;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.interfaces.CRUD;
import modelo.lambdas.ObtenerIDLambda;

/**
 *
 * @author Formacion
 */
public class AlumnoDAO {
    
    private Collection<Alumno> alumnos;
    private MatriculaAlumno ma;

    public AlumnoDAO(Collection<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public Collection<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(Collection<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public MatriculaAlumno getMa() {
        return ma;
    }
    
    
    
    public int create(CRUD<MatriculaAlumno,Integer> crud, Connection con, MatriculaAlumno ma){
        Integer i = crud.accion(con, ma);
        return i;
    }
    
    public String resultTodo(CRUD<Object,ResultSet> crud, Connection con) {
        String cadena = "NOMBRE\tAPELLIDO1\tAPELLIDO2\tDNI\tTELEFONO\n";
        ResultSet rs = crud.accion(con,null);
        try {
            while (rs.next()){
                cadena += rs.getString("NOMBRE")+"\t" + rs.getString("APELLIDO1") + "\t"
                        + rs.getString("APELLIDO2") + "\t" + rs.getString("DNI") + "\t" 
                        + rs.getString("TELEFONO") + "\n";
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cadena;
    }
    
    public MatriculaAlumno resultAlumno(CRUD<Integer,MatriculaAlumno> crud, Connection con, String dni){
        Integer id = obtenerID(ObtenerIDLambda.RESULTID, con, dni);
        if (id != -1){
            ma = crud.accion(con, id);
            return ma;
        }
        return null;
    }
    
    public boolean update(CRUD<Alumno, Boolean> crud, Connection con, Alumno alumno){
        return crud.accion(con, alumno);
    }
    
    public boolean delete (CRUD<Integer,Boolean> crud, Connection con, String dni){
        Integer id = obtenerID(ObtenerIDLambda.RESULTID, con, dni);        
        return crud.accion(con, id);
    }
    
    public Integer obtenerID(CRUD<String,Integer> crud, Connection con, String dni){        
        return crud.accion(con, dni);
    }
    
}
