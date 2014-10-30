/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.matriculadao.interfaces;

import java.sql.Connection;

/**
 *
 * @author Oscar
 */
public interface DeleteMatricula {
    boolean delete(Connection con, int id);
}
