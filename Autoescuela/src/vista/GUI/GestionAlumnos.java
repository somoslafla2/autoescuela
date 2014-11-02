/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.GUI;

import controlador.Controlador;
import ester.autoescuela.tipocarnet.TipoCarnet;
import javax.swing.JOptionPane;
import modelo.conexion.ConexionAutoescuela;
import vista.InterfazVista;

/**
 *
 * @author Gonzalo,Oscar,Christian y Ester
 */
public class GestionAlumnos extends javax.swing.JFrame implements InterfazVista {

    private static final long serialVersionUID = -612577678585684133L;
    Controlador controlador;

//    private enum Pestania {
//        A, BM, C;
//    }
    /**
     * Creates new form GestionAlumno
     */
    public GestionAlumnos() {
        ConexionAutoescuela cA = ConexionAutoescuela.getInstance();
        controlador = new Controlador(cA);
        initComponents();

        for (TipoCarnet carnet : TipoCarnet.values()) {
            jComboBoxTipoDeCarnet.addItem(carnet.name());
        }
        controlador.setVista(this);
    }

    @Override
    public void setId(int id) {
        datosAlumno1.getjTextFieldIdAlumno().setText(Integer.toString(id));
    }

    @Override
    public String getNombre() {
        return datosAlumno1.getjTextFieldNombre().getText();
    }

    @Override
    public String getAp1() {
        return datosAlumno1.getjTextFieldPrimerApellido().getText();
    }

    @Override
    public String getAp2() {
        return datosAlumno1.getjTextFieldSegundoApellido().getText(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getDNI() {
        return datosAlumno1.getjTextFieldDNI().getText(); //To change body of generated methods, choose Tools | Templates.
    }

   // @Override
    public String getDNI2() {
        return datosAlumno2.getjTextFieldDNI().getText(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getTlfn() {
        return datosAlumno1.getjTextFieldTelefono().getText(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getDia() {
        return Integer.parseInt(datosAlumno1.getjTextFieldDia().getText()); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getMes() {
        return Integer.parseInt(datosAlumno1.getjTextFieldMes().getText()); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getAnio() {
        return Integer.parseInt(datosAlumno1.getjTextFieldAnnio().getText());  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean getPresencial() {
        return datosAlumno1.getjComboBoxtipodeAlumno().getSelectedItem().toString().equals("Presencial"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TipoCarnet getCarnet() {
        String lo = (String) jComboBoxTipoDeCarnet.getModel().getSelectedItem();
        return TipoCarnet.valueOf(lo);
    }

    //@Override
    public void show(String cadena) {
        jTextAreaConsultas.setText(cadena);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelGestionAlum = new javax.swing.JTabbedPane();
        jPanelAltas = new javax.swing.JPanel();
        jLabelTipoDeCarnet = new javax.swing.JLabel();
        jComboBoxTipoDeCarnet = new javax.swing.JComboBox();
        jLabelPrecio = new javax.swing.JLabel();
        jTextFieldPrecio = new javax.swing.JTextField();
        datosAlumno1 = new vista.GUI.DatosAlumno();
        jButtonCrear = new javax.swing.JButton();
        jPanelBajasYModif = new javax.swing.JPanel();
        jScrollInfoTabla = new javax.swing.JScrollPane();
        jTextTabla = new javax.swing.JTextArea();
        datosAlumno2 = new vista.GUI.DatosAlumno();
        jButtonBorrar = new javax.swing.JButton();
        jButtonBuscar = new javax.swing.JButton();
        jButtonModificar = new javax.swing.JButton();
        jPanelConsult = new javax.swing.JPanel();
        jScrollInfoConsultas = new javax.swing.JScrollPane();
        jTextAreaConsultas = new javax.swing.JTextArea();
        jButtonMostrarTodo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestión Autoescuela");

        jLabelTipoDeCarnet.setText("Tipo de Carnet:");

        jComboBoxTipoDeCarnet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTipoDeCarnetActionPerformed(evt);
            }
        });

        jLabelPrecio.setText("Precio:");

        jTextFieldPrecio.setEditable(false);
        jTextFieldPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPrecioActionPerformed(evt);
            }
        });

        jButtonCrear.setText("Crear");
        jButtonCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCrearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelAltasLayout = new javax.swing.GroupLayout(jPanelAltas);
        jPanelAltas.setLayout(jPanelAltasLayout);
        jPanelAltasLayout.setHorizontalGroup(
            jPanelAltasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAltasLayout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(datosAlumno1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
            .addGroup(jPanelAltasLayout.createSequentialGroup()
                .addGap(199, 199, 199)
                .addGroup(jPanelAltasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelAltasLayout.createSequentialGroup()
                        .addGroup(jPanelAltasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelTipoDeCarnet, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelPrecio, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelAltasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldPrecio)
                            .addComponent(jComboBoxTipoDeCarnet, 0, 161, Short.MAX_VALUE)))
                    .addGroup(jPanelAltasLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jButtonCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanelAltasLayout.setVerticalGroup(
            jPanelAltasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAltasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(datosAlumno1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(jPanelAltasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxTipoDeCarnet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTipoDeCarnet))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelAltasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPrecio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jButtonCrear)
                .addGap(28, 28, 28))
        );

        jPanelGestionAlum.addTab("Altas", jPanelAltas);

        jTextTabla.setColumns(20);
        jTextTabla.setRows(5);
        jScrollInfoTabla.setViewportView(jTextTabla);

        jButtonBorrar.setText("Borrar");
        jButtonBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBorrarActionPerformed(evt);
            }
        });

        jButtonBuscar.setText("Búsqueda  por DNI");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });

        jButtonModificar.setText("Modificar");
        jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBajasYModifLayout = new javax.swing.GroupLayout(jPanelBajasYModif);
        jPanelBajasYModif.setLayout(jPanelBajasYModifLayout);
        jPanelBajasYModifLayout.setHorizontalGroup(
            jPanelBajasYModifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBajasYModifLayout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(jPanelBajasYModifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelBajasYModifLayout.createSequentialGroup()
                        .addComponent(jButtonBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollInfoTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(datosAlumno2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(89, Short.MAX_VALUE))
        );
        jPanelBajasYModifLayout.setVerticalGroup(
            jPanelBajasYModifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBajasYModifLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(datosAlumno2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollInfoTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanelBajasYModifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonBorrar)
                    .addComponent(jButtonBuscar)
                    .addComponent(jButtonModificar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelGestionAlum.addTab("Bajas y Modificaciones", jPanelBajasYModif);

        jTextAreaConsultas.setEditable(false);
        jTextAreaConsultas.setColumns(20);
        jTextAreaConsultas.setRows(5);
        jScrollInfoConsultas.setViewportView(jTextAreaConsultas);

        jButtonMostrarTodo.setText("Mostrar todo");
        jButtonMostrarTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMostrarTodoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelConsultLayout = new javax.swing.GroupLayout(jPanelConsult);
        jPanelConsult.setLayout(jPanelConsultLayout);
        jPanelConsultLayout.setHorizontalGroup(
            jPanelConsultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelConsultLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollInfoConsultas)
                .addContainerGap())
            .addGroup(jPanelConsultLayout.createSequentialGroup()
                .addGap(238, 238, 238)
                .addComponent(jButtonMostrarTodo)
                .addContainerGap(243, Short.MAX_VALUE))
        );
        jPanelConsultLayout.setVerticalGroup(
            jPanelConsultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelConsultLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollInfoConsultas, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonMostrarTodo)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jPanelGestionAlum.addTab("Consultas", jPanelConsult);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelGestionAlum))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelGestionAlum))
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCrearActionPerformed
       // Crear Alumno
        JOptionPane.showConfirmDialog(null, "¿Desea dar de alta a este alumno?", "Alta de alumno", JOptionPane.OK_CANCEL_OPTION);
        controlador.crearAlumno();
    }//GEN-LAST:event_jButtonCrearActionPerformed

    private void jComboBoxTipoDeCarnetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTipoDeCarnetActionPerformed
        // Para rellenar el combobox con los tipos de Carnet
        String lo = (String) jComboBoxTipoDeCarnet.getModel().getSelectedItem();
        TipoCarnet t = TipoCarnet.valueOf(lo);
        jTextFieldPrecio.setText(Float.toString(t.getPrecio()));//Asigna el precio correspondiente con el tipo de carnet

    }//GEN-LAST:event_jComboBoxTipoDeCarnetActionPerformed

    private void jTextFieldPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPrecioActionPerformed
       
    }//GEN-LAST:event_jTextFieldPrecioActionPerformed

    private void jButtonMostrarTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMostrarTodoActionPerformed
      //Consultar todos los datos de todos los alumnos
        controlador.consultar();
    }//GEN-LAST:event_jButtonMostrarTodoActionPerformed

    private void jButtonBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBorrarActionPerformed
    // Borrar un alumno, tras haberlo localizado a través de su DNI
    // Este botón permanece desactivado hasta que el usuario introduce un DNI

        JOptionPane.showConfirmDialog(null, "¿Seguro que quieres borrar este dato?", "eliminar dato", JOptionPane.OK_CANCEL_OPTION);
        controlador.borrar();
    }//GEN-LAST:event_jButtonBorrarActionPerformed

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        // Busca a través del DNI los datos de un alumno 

        String dni
                = JOptionPane.showInputDialog("Introducir DNI");
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed
        // Modifica los datos de un alumno, tras haberlo localizado a través de su DNI
        //Este botón permanece desactivado hasta que el usuario introduce un DNI
        JOptionPane.showConfirmDialog(null, "¿Desea guardar las modificaciones realizadas?", "confirmar modificaciones", JOptionPane.OK_CANCEL_OPTION);
    }//GEN-LAST:event_jButtonModificarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GestionAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionAlumnos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private vista.GUI.DatosAlumno datosAlumno1;
    private vista.GUI.DatosAlumno datosAlumno2;
    private javax.swing.JButton jButtonBorrar;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonCrear;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JButton jButtonMostrarTodo;
    private javax.swing.JComboBox jComboBoxTipoDeCarnet;
    private javax.swing.JLabel jLabelPrecio;
    private javax.swing.JLabel jLabelTipoDeCarnet;
    private javax.swing.JPanel jPanelAltas;
    private javax.swing.JPanel jPanelBajasYModif;
    private javax.swing.JPanel jPanelConsult;
    private javax.swing.JTabbedPane jPanelGestionAlum;
    private javax.swing.JScrollPane jScrollInfoConsultas;
    private javax.swing.JScrollPane jScrollInfoTabla;
    private javax.swing.JTextArea jTextAreaConsultas;
    private javax.swing.JTextField jTextFieldPrecio;
    private javax.swing.JTextArea jTextTabla;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setControlador(Controlador c) {
        this.controlador = c;
    }

}
