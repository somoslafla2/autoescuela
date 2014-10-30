/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.lambda.matricula;

import ester.autoescuela.tipocarnet.TipoCarnet;
import java.sql.Connection;

/**
 *
 * @author Formacion
 */
public interface CreateMatricula {
    boolean create(Connection con, int id, TipoCarnet c);
}
