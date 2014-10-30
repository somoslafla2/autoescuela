/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.alumnodao.interfaces;

import java.sql.Connection;

/**
 *
 * @author Formacion
 */
public interface Update {
    boolean update(Connection con);
}
