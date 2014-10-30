/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import ester.autoescuela.factoriaAlumnos.alumno.Alumno;
import ester.autoescuela.factoriaAlumnos.factoria.CreadorAlumnoDistancia;
import ester.autoescuela.factoriaAlumnos.factoria.CreadorAlumnoPresencial;
import ester.autoescuela.factoriaAlumnos.factoria.FactoriaAlumnado;
import ester.autoescuela.tipocarnet.TipoCarnet;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.HashSet;
import modelo.AlumnoDAO;
import modelo.MatriculaDAO;
import modelo.conexion.ConexionAutoescuela;
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
        int dia = vista.getDia();
        int mes = vista.getMes();
        int annio = vista.getAnio();
        
        Alumno a = fabrica.crearAlumno(nombre, ap1, ap2, dni, tlf, 
                new GregorianCalendar(annio, mes, dia));
        
        TipoCarnet c = vista.getCarnet();
        
        int id= 0;
        if (a != null && c!=null){
            id = aDAO.create(conexion.getConexion(),a);    
            if (id != -1){
                // Insertar el carnet
                mDAO.crearMatricula(conexion.getConexion(),id, c);
                vista.setId(id);
            }
        }
    }
    
    
    public boolean borrar(){
        String dni = vista.getDNI();
        // Se obtiene el id de la tabla del alumno que se quiere eliminar
        int id = aDAO.getID(conexion.getConexion(), dni);
        // Se eliminan las referencias de ese alumno
        if(mDAO.borrar(conexion.getConexion(), id))
            //Se elimina el alumno
            return aDAO.delete(conexion.getConexion(), id);
        return false;
    }
    
    public void consultar(){
        String resultado = aDAO.resultTodo(conexion.getConexion());
        System.out.println(resultado);
    }
    
    public void consultarPorDNI(){
        String dni = vista.getDNI();
        // Se obtiene el id de la tabla del alumno que se quiere eliminar
        aDAO.resultAlumno(conexion.getConexion(), dni);
        aDAO.showAlumno();
        int id = aDAO.getID(conexion.getConexion(), dni);
        System.out.println(mDAO.consultar(conexion.getConexion(), id));
    }
    
    public void actualizar(){
        consultarPorDNI();
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
        
        Alumno aNuevo = fabrica.crearAlumno(nombre, ap1, ap2, dni, tlf, 
                a[0].getFechaNacimiento());
        aDAO.update(conexion.getConexion(),a[0],aNuevo);
    }
    
}
