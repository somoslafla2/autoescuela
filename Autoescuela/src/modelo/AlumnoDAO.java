/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import ester.autoescuela.excepciones.AlumnoMalFormado;
import ester.autoescuela.factoriaAlumnos.alumno.Alumno;
import ester.autoescuela.factoriaAlumnos.alumno.AlumnoPresencial;
import ester.autoescuela.factoriaAlumnos.factoria.CreadorAlumnoDistancia;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.interfaces.CRUD;
import modelo.lambdas.ObtenerIDLambda;

/**
 *
 * @author Formacion
 */
public class AlumnoDAO {
    
    private Alumno alumnoDoomi;
    private Collection<Alumno> alumnos;

    public AlumnoDAO(Collection<Alumno> alumnos) {
        this.alumnos = alumnos;
        try {
            alumnoDoomi = new CreadorAlumnoDistancia().crearAlumno("a", "a", "a", "a", "a", new GregorianCalendar());
        } catch (AlumnoMalFormado ex) {
        }
    }

    public Collection<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(Collection<Alumno> alumnos) {
        this.alumnos = alumnos;
    }
    
    public int create(CRUD crud, Connection con, MatriculaAlumno ma){
        Integer i = (Integer) crud.accion(con, ma);
        return i;
    }
    
    public String resultTodo(CRUD crud, Connection con) {
        String cadena = "NOMBRE\tAPELLIDO1\tAPELLIDO2\tDNI\tTELEFONO\n";
        ResultSet rs = (ResultSet) crud.accion(con,null);
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
    
    public boolean resultAlumno(Connection con, String dni){
        return true;
    }
    
    public boolean update(Connection con, Alumno alumno, Alumno aNuevo){
        return true;
    }
    
    public boolean delete (CRUD crud, Connection con, String dni){
        Integer id = obtenerID(ObtenerIDLambda.RESULTID, con, dni);        
        return (boolean) crud.accion(con, id);
    }
    
    public Integer obtenerID(CRUD crud, Connection con, String dni){        
        return (Integer) crud.accion(con, dni);
    }
    
    public void showAlumno(){
        if (alumnos.size() == 1)
            System.out.println("---------------------------------------------");
            for (Alumno alumno : alumnos) {
                System.out.println("Nombre: "+alumno.getNombre());
                System.out.println("Apellidos: " + alumno.getApellido1() + " " + alumno.getApellido2());
                System.out.println("DNI: "+alumno.getDni());
                System.out.println("Telefono: "+alumno.getTelefono());
                System.out.println("Tipo: "+((alumno instanceof AlumnoPresencial)?"PRESENCIAL":"A DISTANCIA"));
                System.out.println("Fecha: "+alumno.getFechaNacimiento().getTime());
            }
            System.out.println("---------------------------------------------");
    }
}
