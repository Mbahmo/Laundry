/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laundry;

import java.awt.Dimension;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mbahmo
 */
public class menudatauser extends javax.swing.JDialog {
private DefaultTableModel model;
    /**
     * Creates new form menudatauser
     */
    public menudatauser(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
          model = new DefaultTableModel();
         jTable1.setModel(model);      
        model.addColumn("ID User");
        model.addColumn("Username");
        model.addColumn("Level");
        tampildatauser();
   
    }


     public void tampildatauser()
    {
    model.getDataVector().removeAllElements();
    model.fireTableDataChanged();
        try {
            Statement statement=(Statement)
                    koneksi.getConnection().createStatement();
         String sql="SELECT `tbuser`.* FROM `tbuser`;";
            ResultSet r = statement.executeQuery(sql);
                    
            while (r.next())
            {
                Object[] o=new Object[4];
                o[0]=r.getString("IdUser");
                o[1]=r.getString("Username");
                o[2]=r.getString("Level");
                model.addRow(o);
            }
           r.close();
           statement.close();
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
     void tableusersearch(){
        
            DefaultTableModel tabelTampil1 = new DefaultTableModel();
       tabelTampil1.addColumn("ID User");
            tabelTampil1.addColumn("Username");
    tabelTampil1.addColumn("Level");
        try{
             Statement statement=(Statement)
                    koneksi.getConnection().createStatement();
             String sql = "Select * from tbuser where IdUser like '%" + jTextField1.getText() + "%'" 
                         + "or Username like '%" + jTextField1.getText() + "%'"
                    + "or Level like '%" + jTextField1.getText() + "%'";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
            tabelTampil1.addRow(new Object[]{
            rs.getString("IdUser"),
            rs.getString("Username"),
            rs.getString("Level"),
            });
            }
          jTable1.setModel(tabelTampil1);

                }catch (Exception e){
                  JOptionPane.showMessageDialog(this, e);
            }
     }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Data User");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jPanel2.setBackground(new java.awt.Color(255, 0, 0));
        jPanel2.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Master Data User");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 0, 0));
        jPanel3.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N

        jTable1.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jButton1.setText("Daftar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jButton2.setText("Hapus User");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jButton5.setText("Ganti Password");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jTextField1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Search :");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(8, 8, 8)
                        .addComponent(jTextField1))
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton5)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int i=jTable1.getSelectedRow();
        if (i==-1)
        return;
        else
        {
            String nis=(String) jTable1.getValueAt(i, 0);
            String nama= (String) jTable1.getValueAt(i, 1);
            //masukkan ke form
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String username=(JOptionPane.showInputDialog(null,"Username","Masukkan Username"
            ,JOptionPane.QUESTION_MESSAGE));
    JLabel jPassword = new JLabel("Password");
    JTextField password = new JPasswordField()
    {
        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 30);
        }
        };

        Object[] ob = {jPassword, password};

        int result = JOptionPane.showConfirmDialog(null, ob, "Masukkan Password",
            JOptionPane.OK_CANCEL_OPTION);
        String passwordValue = password.getText();
        if (username.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Username Masih Kosong");
            return;
        }
        else if(passwordValue.equals("")){

            JOptionPane.showMessageDialog(this, "Password Masih Kosong");
            return;
        }
        else{
            try {
                Statement statement=(Statement)
                koneksi.getConnection().createStatement();
                //executequery untuk menampilkan data
                //executeupdate untuk menambah/simpan, edit data
                String sql="SELECT `tbuser`.`Username` FROM `tbuser` Where `Username`='"+username+"';";
                ResultSet r = statement.executeQuery(sql);

                if (r.next()){
                    JOptionPane.showMessageDialog(this, "User Sudah Terdaftar. Coba Lagi");
                }
                else{
                    try {
                        koneksi.getConnection().createStatement();
                        //executequery untuk menampilkan data
                        //executeupdate untuk menambah/simpan, edit data
                        statement.executeUpdate("insert into tbuser (Username,Password,Level) "
                            + "value('"+username+"','"+passwordValue+"','User')");
                        statement.close();
                        JOptionPane.showMessageDialog(this, "Berhasil Mendaftar User");
                        tampildatauser();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, "Gagal Mendaftar User\n"+e.getMessage());

                    }
                }
            } catch (Exception e) {
            }

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int i=jTable1.getSelectedRow();

        try {
            Statement statement=(Statement)
            koneksi.getConnection().createStatement();
            //executequery untuk menampilkan data
            //executeupdate untuk menambah/simpan, edit data
 if (i==-1){
                    JOptionPane.showMessageDialog(this, "Silahkan  Memilih User Yang Ingin Dihapus Terlebih Dahulu");
                    return;
 }
 else
 {
            int jawaban = JOptionPane.showConfirmDialog(this, "Apakah anda yakin?",
                "Pertanyaan",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
            if (jawaban!=JOptionPane.YES_OPTION)
            {
               
                }
                else
                {
                    String iduser=(String) jTable1.getValueAt(i, 0);
                    statement.executeUpdate("delete from tbuser where iduser=('"+iduser+"');");
                    statement.close();
                    JOptionPane.showMessageDialog(this, "Data Berhasil Dihapus");
                    tampildatauser();
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Data Gagal Dihapuis\n"+e.getMessage());
        }
        }

        private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        JLabel jPassword = new JLabel("Password Lama");
        JTextField password = new JPasswordField()
        {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(200, 30);
            }
        };
        JLabel jPassword2 = new JLabel("Password Baru");
        JTextField password2 = new JPasswordField()
        {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(200, 30);
            }
        };
        int i=jTable1.getSelectedRow();

        if (i==-1){
            JOptionPane.showMessageDialog(this, ""
                + "Silahkan  pilih user terlebih dahulu");
            return;
        }
        else
        {
            Object[] ob = {jPassword, password};
            Object[] ob2 = {jPassword2, password2};

            int result = JOptionPane.showConfirmDialog(null, ob, "Masukkan Password Lama",
                JOptionPane.OK_CANCEL_OPTION);
            int result2 = JOptionPane.showConfirmDialog(null, ob2, "Masukkan Password Baru",
                JOptionPane.OK_CANCEL_OPTION);
            String passwordValue = password.getText();
            String passwordValue2 = password2.getText();

            if (passwordValue.equals(""))
            {
                JOptionPane.showMessageDialog(this, "Password Lama Masih Kosong");
                return;
            }
            else if(passwordValue2.equals("")){

                JOptionPane.showMessageDialog(this, "Password Baru Masih Kosong");
                return;
            }
            else{
                String id=(String) model.getValueAt(i, 0);
                try {
                    Statement statement=(Statement)
                    koneksi.getConnection().createStatement();
                    //executequery untuk menampilkan data
                    //executeupdate untuk menambah/simpan, edit data
                    String sql="SELECT `tbuser`.`Password` FROM `tbuser` Where"
                    + "`Iduser`='"+id+"' AND `Password`='"+passwordValue+"';";
                    ResultSet r = statement.executeQuery(sql);

                    if (!r.next()){
                        JOptionPane.showMessageDialog(this, "Password Lama Salah. Coba Lagi",
                            "Password Salah",JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                        try {
                            koneksi.getConnection().createStatement();
                            //executequery untuk menampilkan data
                            //executeupdate untuk menambah/simpan, edit data
                            statement.executeUpdate("UPDATE `dblaundry`.`tbuser` SET `Password`"
                                + " = '"+passwordValue2+"' WHERE `tbuser`.`IdUser` = '"+id+"';");
                            statement.close();
                            JOptionPane.showMessageDialog(this, "Berhasil Mengubah Password");
                            tampildatauser();
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(this, "Gagal Mengubah Password\n"+e.getMessage());

                        }
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, e);
                }

            }
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        // TODO add your handling code here:
        tableusersearch();
    }//GEN-LAST:event_jTextField1KeyReleased

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
            java.util.logging.Logger.getLogger(menudatauser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menudatauser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menudatauser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menudatauser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                menudatauser dialog = new menudatauser(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}