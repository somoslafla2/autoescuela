/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import ester.autoescuela.carnet.TipoCarnet;
import ester.autoescuela.excepciones.AlumnoMalFormado;
import ester.autoescuela.factoriaAlumnos.alumno.Alumno;
import ester.autoescuela.factoriaAlumnos.factoria.CreadorAlumnoDistancia;
import ester.autoescuela.factoriaAlumnos.factoria.CreadorAlumnoPresencial;
import ester.autoescuela.factoriaAlumnos.factoria.FactoriaAlumnado;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.AlumnoDAO;
import modelo.MatriculaAlumno;
import modelo.MatriculaDAO;
import modelo.conexion.ConexionAutoescuela;
import modelo.lambdas.CreateLambda;
import modelo.lambdas.DeleteLambda;
import modelo.lambdas.ResultLambda;
import vista.InterfazVista;

/**
 *
 * @author Formacion
 */
public class Controlador {

    private ConexionAutoescuela conexion;
    private InterfazVista vista;
    private AlumnoDAO aDAO;
    private MatriculaDAO mDAO;

    public Controlador() {
    }
    
    public Controlador(ConexionAutoescuela conexion) {
        this.conexion = conexion;
        aDAO = new AlumnoDAO(new HashSet());
        mDAO = new MatriculaDAO();
    }
    
    public void setVista(InterfazVista vista) {
        this.vista = vista;
    }
    
    public void crearAlumno(){
        boolean pres = vista.getPresencial();
        FactoriaAlumnado fabrica;
        
        if (pres)
            fabrica = new CreadorAlumnoPresencial();
        else
            fabrica = new CreadorAlumnoDistancia();
        
        Alumno a = null;
        try {
            a = fabrica.crearAlumno(vista.getNombre(), vista.getAp1(), vista.getAp2(), vista.getDNI(), vista.getTlfn(), 
                    new GregorianCalendar(vista.getAnio(), vista.getMes()-1, vista.getDia()));
            System.out.println(a.fechaToString());
        } catch (AlumnoMalFormado ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
               
        TipoCarnet c = vista.getCarnet();
        
        MatriculaAlumno mA = new MatriculaAlumno(a, new ArrayList());
        mA.add(c);
        
        
        int id = aDAO.create(CreateLambda.CREAR2,conexion.getConexion(), mA);
        if (id != -1)
            vista.setId(id);
    }
    
    
    public boolean borrar(){
        return aDAO.delete(DeleteLambda.DELETE,conexion.getConexion(), vista.getDNI());
    }
    
    public void consultar(){
        String resultado = aDAO.resultTodo(ResultLambda.CONSULTAR_TODO,conexion.getConexion());
        System.out.println(resultado);
    }
    
    public void consultar(String dni){
        dni = vista.getDNI();
        // Se obtiene el id de la tabla del alumno que se quiere eliminar
//        aDAO.resultAlumno(conexion.getConexion(), dni);
//        aDAO.showAlumno();
//        int id = aDAO.getID(conexion.getConexion(), dni);
//        System.out.println(mDAO.consultar(conexion.getConexion(), id));
    }
    
    public void actualizar(){
        consultar(vista.getDNI());
//        int id = aDAO.getID(conexion.getConexion(), vista.getDNI());
        Collection<Alumno> alumnos = aDAO.getAlumnos();
        Alumno [] a = new Alumno[alumnos.size()];
        a = alumnos.toArray(a);
        
        String nombre = vista.getNombre();
        String ap1 = vista.getAp1();
        String ap2 = vista.getAp2();
        String dni = vista.getDNI();
        String tlf = vista.getTlfn();
        boolean pres = vista.getPresencial();
        FactoriaAlumnado fabrica;
        if (pres)
            fabrica = new CreadorAlumnoPresencial();
        else
            fabrica = new CreadorAlumnoDistancia();
        
        Alumno aNuevo = null;
        try {
            aNuevo = fabrica.crearAlumno(nombre, ap1, ap2, dni, tlf, (GregorianCalendar) a[0].getFechaNacimiento());
        } catch (AlumnoMalFormado ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        aDAO.update(conexion.getConexion(),a[0],aNuevo);
    }
    
}
