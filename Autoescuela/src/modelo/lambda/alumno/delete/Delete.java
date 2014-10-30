/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.lambda.alumno.delete;

import java.sql.Connection;

/**
 *
 * @author Formacion
 */
public interface Delete {
    boolean delete(Connection con, int id);
}
