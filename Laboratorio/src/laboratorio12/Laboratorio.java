/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package laboratorio12;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Formacion
 */
public class Laboratorio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        Stream<Integer> s = Arrays.asList(1,2,3,4,5).stream().filter(n->n>2);
//        Stream<Integer> t = s.filter(n->n>3);
//        t.forEach(n->System.out.println(n));
        Calendar c = new GregorianCalendar();
        c.set(1985, 10, 29);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
        
    }
    
}
