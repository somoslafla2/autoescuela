/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.alumnodao.lambdas;

import modelo.alumnodao.interfaces.Update;

/**
 *
 * @author Formacion
 */
public class UpdateLambda {
    public static Update UPDATE_LAMBDA = (con) -> {
        // Actualizar los campos de la fila de la base de datos
        return true;
    };
}
