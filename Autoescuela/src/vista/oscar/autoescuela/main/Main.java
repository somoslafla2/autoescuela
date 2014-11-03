/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vista.oscar.autoescuela.main;

import controlador.Controlador;
import modelo.conexion.ConexionAutoescuela;
import vista.oscar.autoescuela.assets.AssetMenu;
import vista.oscar.autoescuela.menu.Menu;


/**
 *
 * @author Oscar
 */
public class Main {
    public static void main(String[] args) {        
        ConexionAutoescuela cA = ConexionAutoescuela.getInstance();
        Controlador controlador = new Controlador(cA);
        Menu m = AssetMenu.createMenu(controlador);
        controlador.setVista(m);
        while (true){
            m.showMenu();
            m = m.executeOption();
        }
    }
}
