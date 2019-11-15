/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Modelo.Alumno;
import Modelo.AlumnoData;
import Modelo.Conexion;
import Modelo.Cursada;
import Modelo.CursadaData;
import Modelo.Materia;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;


public class VistaInscripciones extends javax.swing.JInternalFrame {

    private Alumno alu;
    private Conexion conexion;
    private AlumnoData ad;
    private CursadaData cd;
    private DefaultTableModel modelo;
    
    public VistaInscripciones() {
        try {
            initComponents();
            initComponents();
            conexion = new Conexion();
            ad = new AlumnoData(conexion);
            ad.obtenerAlumnos();
            List<Alumno> lista = ad.obtenerAlumnos();
            for(Alumno x:lista){
                cboAlumnos.addItem(x);
            }
            modelo = new DefaultTableModel();
            cd = new CursadaData(conexion);
            armarCabeceraTabla();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VistaInscripciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

     public void armarCabeceraTabla(){
        ArrayList<Object> columnas = new ArrayList<Object>();
        columnas.add("ID");
        columnas.add("Nombre: ");
        columnas.add("Responsable ");
        columnas.add("Responsable");
        for(Object x: columnas){
            modelo.addColumn(x);
        }
        dgvMaterias.setModel(modelo);
    }
    
    public void borrarFilas(){
        int a = modelo.getRowCount()-1;
        for(int i=a;i>=0;i--){
            modelo.removeRow(i);
        }
    }
    
    public void cargaDatosInscriptas(){
        borrarFilas();
        //Lenar las filas 
        alu = (Alumno)cboAlumnos.getSelectedItem();
        List<Materia> listaMaterias = cd.obtenerMateriasCursadas(alu.getId());
        for(Materia m: listaMaterias){
            modelo.addRow(new Object[]{m.getCod(),m.getNombre(),m.getResponsable(),m.getPeriodo()});
        }
    }
    
    public void cargarDatosNoInscriptas(){
        borrarFilas();
        //Lenar las filas 
        alu = (Alumno)cboAlumnos.getSelectedItem();
        List<Materia> listaMaterias = cd.obtenerMateriasNOCursadas(alu.getId());
        for(Materia m: listaMaterias){
            modelo.addRow(new Object[]{m.getCod(),m.getNombre(),m.getResponsable(),m.getPeriodo()});
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnOpcion = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cboAlumnos = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        rbInsc = new javax.swing.JRadioButton();
        rbNoInsc = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        dgvMaterias = new javax.swing.JTable();
        btnInscribir = new javax.swing.JButton();
        btnAnular = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setBackground(new java.awt.Color(0, 204, 204));
        setTitle("CARGAR INSCRIPCIONES");
        setName("frmVistaInscrip"); // NOI18N

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel1.setText("INSCRIPCIONES");

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel2.setText("ALUMNOS");

        cboAlumnos.setName("cboAlumnos"); // NOI18N

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel3.setText("LISTADO DE MATERIAS");

        btnOpcion.add(rbInsc);
        rbInsc.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        rbInsc.setText("Inscriptas");
        rbInsc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbInscActionPerformed(evt);
            }
        });

        btnOpcion.add(rbNoInsc);
        rbNoInsc.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        rbNoInsc.setText("No Inscriptas");
        rbNoInsc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbNoInscActionPerformed(evt);
            }
        });

        dgvMaterias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(dgvMaterias);

        btnInscribir.setBackground(new java.awt.Color(51, 102, 255));
        btnInscribir.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        btnInscribir.setText("INSCRIBIR");
        btnInscribir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInscribirActionPerformed(evt);
            }
        });

        btnAnular.setBackground(new java.awt.Color(51, 102, 255));
        btnAnular.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        btnAnular.setText("ANULAR INSCRIPCIÓN");
        btnAnular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnularActionPerformed(evt);
            }
        });

        btnSalir.setBackground(new java.awt.Color(51, 102, 255));
        btnSalir.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        btnSalir.setText("SALIR");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(rbInsc)
                        .addGap(66, 66, 66)
                        .addComponent(rbNoInsc))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(cboAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(btnInscribir)
                .addGap(18, 18, 18)
                .addComponent(btnAnular, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbInsc)
                    .addComponent(rbNoInsc))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInscribir, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAnular, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbInscActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbInscActionPerformed
        borrarFilas();
        cargaDatosInscriptas();
    }//GEN-LAST:event_rbInscActionPerformed

    private void rbNoInscActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbNoInscActionPerformed
        borrarFilas();
        cargarDatosNoInscriptas();
    }//GEN-LAST:event_rbNoInscActionPerformed

    private void btnInscribirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInscribirActionPerformed
        int filaseleccionada = dgvMaterias.getSelectedRow();
        
        if(filaseleccionada!= -1){
            Alumno a= (Alumno)cboAlumnos.getSelectedItem();//creo un alumno c el item q seleccione en la lista desplegable
            
            int idMateria =(Integer)modelo.getValueAt(filaseleccionada, 0);//guardo los datos q tengo seleccionados en variables de su tipo
            String nommat =(String)modelo.getValueAt(filaseleccionada, 1);
            String resp =(String)modelo.getValueAt(filaseleccionada, 2);
            String perio =(String)modelo.getValueAt(filaseleccionada, 3);
            
            Materia mat = new Materia(nommat,perio,resp,idMateria);//creo una amteria c los datos seleccionados y luego la guardo en la bd
            Cursada c= new Cursada(a,mat,0);
            
            cd.guardarCursada(c);
            borrarFilas();
        }
    }//GEN-LAST:event_btnInscribirActionPerformed

    private void btnAnularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnularActionPerformed
         int filaseleccionada = dgvMaterias.getSelectedRow();
        
        if(filaseleccionada!= -1){
             Alumno a= (Alumno)cboAlumnos.getSelectedItem();
            
             int idMateria =(Integer)modelo.getValueAt(filaseleccionada, 0);
             cd.borrarCursadaDeUnaMateriaDeunAlumno(a.getId(), idMateria);
             borrarFilas();
        }
    }//GEN-LAST:event_btnAnularActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnular;
    private javax.swing.JButton btnInscribir;
    private javax.swing.ButtonGroup btnOpcion;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<Alumno> cboAlumnos;
    private javax.swing.JTable dgvMaterias;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JRadioButton rbInsc;
    private javax.swing.JRadioButton rbNoInsc;
    // End of variables declaration//GEN-END:variables
}
