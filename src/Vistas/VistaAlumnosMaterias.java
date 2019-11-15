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
import Modelo.MateriaData;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;


public class VistaAlumnosMaterias extends javax.swing.JInternalFrame {

     private DefaultTableModel modelo;
     private ArrayList<Cursada> listacursada;
     private ArrayList<Materia> listamateria;
     private ArrayList<Alumno> listaAlumno;
     private MateriaData md;
     private CursadaData cd;
     private AlumnoData ad;
     private Conexion conexion;
     
     public VistaAlumnosMaterias() {
         try {
             initComponents();
             
             conexion = new Conexion();
             modelo = new DefaultTableModel();
             
             cd = new CursadaData(conexion);
             listacursada = (ArrayList)cd.obtenerCursadas();
             
             md = new MateriaData(conexion);
             listamateria = (ArrayList)md.obtenerMaterias();
             
             ad = new AlumnoData(conexion);
             listaAlumno = (ArrayList)ad.obtenerAlumnos();
             
             cargarMaterias();
             armaCabeceraTabla();
             CargaDatos();
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(VistaAlumnosMaterias.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
     public void armaCabeceraTabla(){
       ArrayList<Object> columna = new ArrayList<Object>();
       columna.add("ID");
       columna.add("Nombre");
       columna.add("Nota");
    
       for(Object it:columna){
          modelo.addColumn(it);
       }
       dgvMaterias.setModel(modelo);
      }   
     public void cargaMaterias()
     {
       for(Materia item: listamateria)
           cboMaterias.addItem(item);
     }
     public void borrarFilasTabla(){
    int a = modelo.getRowCount()-1;
    
    for(int i=a; i>=0; i--){
        modelo.removeRow(i);
    }
    }
    
    public void CargaDatos(){
        borrarFilasTabla();
        Materia mat = (Materia)cboMaterias.getSelectedItem();
        for(Cursada m: listacursada)
          if(m.getMateria().getCod() == mat.getCod())
              modelo.addRow(new Object[]{m.getAlumno().getId(),m.getAlumno().getNombre(),m.getNota()});
    }
    public void cargarMaterias()
    {
        for(Materia item: listamateria)
            cboMaterias.addItem(item);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cboMaterias = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        dgvMaterias = new javax.swing.JTable();

        setBackground(new java.awt.Color(0, 204, 204));
        setTitle("LISTADO DE ALUMNOS POR MATERIAS");
        setName("frmAlumnosMaterias"); // NOI18N

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        jLabel1.setText("LISTADO DE ALUMNOS POR MATERIA");

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        jLabel2.setText("MATERIA");

        cboMaterias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboMateriasActionPerformed(evt);
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
        jScrollPane1.setViewportView(dgvMaterias);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(74, 74, 74)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cboMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 12, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cboMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboMateriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboMateriasActionPerformed
        CargaDatos();
    }//GEN-LAST:event_cboMateriasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Materia> cboMaterias;
    private javax.swing.JTable dgvMaterias;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
