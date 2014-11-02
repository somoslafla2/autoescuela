/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import ester.autoescuela.carnet.TipoCarnet;
import ester.autoescuela.factoriaAlumnos.alumno.Alumno;
import java.util.Collection;

/**
 *
 * @author Oscar
 */
public class MatriculaAlumno {
    private Alumno alumno;
    private Collection<TipoCarnet> carnets;

    public MatriculaAlumno(Alumno alumno, Collection<TipoCarnet> carnet) {
        this.alumno = alumno;
        this.carnets = carnet;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Collection<TipoCarnet> getCarnets() {
        return carnets;
    }

    public void setCarnets(Collection<TipoCarnet> carnet) {
        this.carnets = carnet;
    }
    
    public boolean add(TipoCarnet carnet){
        return  carnets.add(carnet);
    }
}
