/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laundry;

import static java.awt.Frame.MAXIMIZED_BOTH;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mbahmo
 */
public class menuutama extends javax.swing.JFrame {
private DefaultTableModel model, model2, model3;
public String iduser;
    /**
     * Creates new form menuutama
     */
    public menuutama() {
        initComponents();
          this.setExtendedState(MAXIMIZED_BOTH);
        login tod = new login();
        
        model = new  DefaultTableModel()
        { @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
         jTable1.setModel(model);
        model.addColumn("ID Barang");
        model.addColumn("Nama Barang");
        model.addColumn("Jenis Barang");
        model.addColumn("Satuan");
        model.addColumn("Harga");
        
        model2 = new  DefaultTableModel()
        { @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
         jTable2.setModel(model2);
        model2.addColumn("ID Pelanggan");
        model2.addColumn("Nama");
        model2.addColumn("Alamat");
        model2.addColumn("No Telp");
        
        model3 = new  DefaultTableModel()
        { @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        jTable3.setModel(model3);
        model3.addColumn("No Transaksi");
        model3.addColumn("Tanggal Masuk");
        model3.addColumn("Tanggal Selesai");
        model3.addColumn("Pelanggan");
        model3.addColumn("Cucian");
        model3.addColumn("Jumlah");
        model3.addColumn("User");
        
        tampildatabarang();
        tampildatapelanggan();
        tampildatapenerimaan();
    }
void tampildatabarang(){   
    model.getDataVector().removeAllElements();
    model.fireTableDataChanged();
        try {
            Statement statement=(Statement)
                    koneksi.getConnection().createStatement();
         String sql="SELECT * FROM tbbarang";
            ResultSet r = statement.executeQuery(sql);
                    
            while (r.next())
            {
                Object[] o=new Object[5];
                o[0]=r.getString("IdBarang");
                o[1]=r.getString("NamaBarang");
                o[2]=r.getString("JenisBarang");
                o[3]=r.getString("Satuan");
                o[4]=r.getString("Harga");
                model.addRow(o);
            }
           r.close();
           statement.close();
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

void tampildatapelanggan(){   
    model2.getDataVector().removeAllElements();
    model2.fireTableDataChanged();
        try {
            Statement statement=(Statement)
                    koneksi.getConnection().createStatement();
         String sql="SELECT * FROM tbpelanggan";
            ResultSet r = statement.executeQuery(sql);
                    
            while (r.next())
            {
                Object[] o=new Object[4];
                o[0]=r.getString("IdPelanggan");
                o[1]=r.getString("NamaPelanggan");
                o[2]=r.getString("Alamat");
                o[3]=r.getString("NoTelp");
                model2.addRow(o);
            }
           r.close();
           statement.close();
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
void tampildatapenerimaan(){   
    model3.getDataVector().removeAllElements();
    model3.fireTableDataChanged();
        try {
            Statement statement=(Statement)
                    koneksi.getConnection().createStatement();
         String sql="SELECT\n" +
"  `tbpenerimaan`.*, `tbpelanggan`.*, `tbbarang`.*, `tbuser`.*\n" +
"FROM\n" +
"  `tbpelanggan` INNER JOIN\n" +
"  `tbpenerimaan` ON `tbpelanggan`.`IdPelanggan` = `tbpenerimaan`.`IdPelanggan`\n" +
"  INNER JOIN\n" +
"  `tbbarang` ON `tbbarang`.`IdBarang` = `tbpenerimaan`.`IdBarang` INNER JOIN\n" +
"  `tbuser` ON `tbuser`.`IdUser` = `tbpenerimaan`.`IdUser` where Keterangan = 'Belum Diambil';";
            ResultSet r = statement.executeQuery(sql);
//                    System.out.println(sql);
            while (r.next())
            {
                Object[] o=new Object[7];
                o[0]=r.getString("NoTransaksi");
                o[1]=r.getString("TglMasuk");
                o[2]=r.getString("TglSelesai");
                o[3]=r.getString("NamaPelanggan");
                o[4]=r.getString("NamaBarang");
                o[5]=r.getString("Jumlah") +" "+ r.getString("Satuan");
                o[6]=r.getString("Username");
                model3.addRow(o);
            }
           r.close();
           statement.close();
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
void tablebarangsearch(){
        
            DefaultTableModel tabelTampil1 = new DefaultTableModel();
       tabelTampil1.addColumn("ID Barang");
            tabelTampil1.addColumn("Nama Barang");
    tabelTampil1.addColumn("Jenis Barang");
    tabelTampil1.addColumn("Satuan");
    tabelTampil1.addColumn("Harga");
        try{
             Statement statement=(Statement)
                    koneksi.getConnection().createStatement();
            String sql = "Select * from tbbarang where IdBarang like '%" + jTextField1.getText() + "%'" 
                         + "or NamaBarang like '%" + jTextField1.getText() + "%'"
                    + "or JenisBarang like '%" + jTextField1.getText() + "%'"
                 +   "or Satuan like '%" + jTextField1.getText() + "%'"
                    +   "or Harga like '%" + jTextField1.getText() + "%'";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
            tabelTampil1.addRow(new Object[]{
            rs.getString(1),
            rs.getString(2),
            rs.getString(3),
            rs.getString(4),
            rs.getString(5),
            });
            }
          jTable1.setModel(tabelTampil1);

                }catch (Exception e){
                    System.out.println(e);
            }
     }

void tablepelanggansearch(){
        
            DefaultTableModel tabelTampil2 = new DefaultTableModel();
       tabelTampil2.addColumn("ID Pelanggan");
            tabelTampil2.addColumn("Nama");
            tabelTampil2.addColumn("Alamat");
            tabelTampil2.addColumn("No Telp");
        try{
             Statement statement=(Statement)
                    koneksi.getConnection().createStatement();
            String sql = "Select * from tbpelanggan where IdPelanggan like '%" + jTextField2.getText() + "%'" 
                         + "or NamaPelanggan like '%" + jTextField2.getText() + "%'"
                    + "or Alamat like '%" + jTextField2.getText() + "%'"
                 +   "or NoTelp like '%" + jTextField2.getText() + "%'";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
            tabelTampil2.addRow(new Object[]{
            rs.getString(1),
            rs.getString(2),
            rs.getString(3),
            rs.getString(4),
            });
            }
          jTable2.setModel(tabelTampil2);

                }catch (Exception e){
                    System.out.println(e);
            }
     }


void tablepenerimaansearch(){
        
            DefaultTableModel tabelTampil3 = new DefaultTableModel();
       tabelTampil3.addColumn("No Transaksi");
       tabelTampil3.addColumn("Tanggal Masuk");
       tabelTampil3.addColumn("Tanggal Selesai");
       tabelTampil3.addColumn("Pelanggan");
       tabelTampil3.addColumn("Cucian");
       tabelTampil3.addColumn("Jumlah");
       tabelTampil3.addColumn("User");
        try{
             Statement statement=(Statement)
                    koneksi.getConnection().createStatement();
            String sql = "SELECT\n" +
"  `tbpenerimaan`.*, `tbpelanggan`.*, `tbbarang`.*, `tbuser`.*\n" +
"FROM\n" +
"  `tbpelanggan` INNER JOIN\n" +
"  `tbpenerimaan` ON `tbpelanggan`.`IdPelanggan` = `tbpenerimaan`.`IdPelanggan`\n" +
"  INNER JOIN\n" +
"  `tbbarang` ON `tbbarang`.`IdBarang` = `tbpenerimaan`.`IdBarang` INNER JOIN\n" +
"  `tbuser` ON `tbuser`.`IdUser` = `tbpenerimaan`.`IdUser` where (NoTransaksi like '%" + jTextField3.getText() + "%'" 
                         + "or NamaPelanggan like '%" + jTextField3.getText() + "%'"
                    + "or NamaBarang like '%" + jTextField3.getText() + "%'"
                    + "or Username like '%" + jTextField3.getText() + "%'"
                 +   "or Jumlah like '%" + jTextField3.getText() + "%') AND "
                    + "Keterangan = 'Belum Diambil'";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
            tabelTampil3.addRow(new Object[]{
            rs.getString("NoTransaksi"),
            rs.getString("TglMasuk"),
            rs.getString("TglSelesai"),
            rs.getString("NamaPelanggan"),
            rs.getString("NamaBarang"),
            rs.getString("Jumlah") +" "+ rs.getString("Satuan"),
            rs.getString("Username"),
 
            });
            }
          jTable3.setModel(tabelTampil3);

                }catch (Exception e){
                    System.out.println(e);
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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistem Informasi Laundry");

        jPanel1.setBackground(new java.awt.Color(255, 102, 102));

        jTabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTabbedPane1.setFont(new java.awt.Font("Righteous", 0, 11)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

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
        jScrollPane1.setViewportView(jTable1);

        jPanel7.setBackground(new java.awt.Color(255, 51, 51));

        jLabel9.setFont(new java.awt.Font("Nirmala UI", 1, 28)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Data Barang");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTextField1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setText("Search :");

        jButton1.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jButton1.setText("   Tambah");
        jButton1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jButton2.setText("  Update");
        jButton2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jButton3.setText("  Delete");
        jButton3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Barang", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jTable2.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        jPanel8.setBackground(new java.awt.Color(255, 51, 51));

        jLabel10.setFont(new java.awt.Font("Nirmala UI", 1, 28)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Data Pelanggan");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTextField2.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2KeyReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel5.setText("Search :");

        jButton4.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jButton4.setText("   Tambah");
        jButton4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jButton5.setText("  Update");
        jButton5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jButton6.setText("  Delete");
        jButton6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField2))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton6)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton5)
                    .addComponent(jButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Pelanggan", jPanel3);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jTable3.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTable3);

        jPanel9.setBackground(new java.awt.Color(255, 51, 51));

        jLabel11.setFont(new java.awt.Font("Nirmala UI", 1, 28)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Data Transaksi");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTextField3.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField3KeyReleased(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel6.setText("Search :");

        jButton7.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jButton7.setText("Penerimaan");
        jButton7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jButton8.setText("Pengembalian");
        jButton8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jButton9.setText("History");
        jButton9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField3))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jButton7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton9)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7)
                    .addComponent(jButton8)
                    .addComponent(jButton9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Transaksi", jPanel5);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel8.setText("Admin :");

        jLabel3.setFont(new java.awt.Font("SansSerif", 3, 42)); // NOI18N
        jLabel3.setText("Sistem Informasi Laundry");

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel2.setText("jLabel2");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(21, 21, 21)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel2))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        jMenu4.setText("File");
        jMenu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu4MouseClicked(evt);
            }
        });

        jMenuItem3.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jMenuItem3.setText("Master User");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem3);

        jMenuItem6.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jMenuItem6.setText("Logout");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem6);

        jMenuItem7.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jMenuItem7.setText("Keluar Aplikasi");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem7);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        // TODO add your handling code here:
        tablebarangsearch();
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
            databarang tambahbarang=new databarang(this, rootPaneCheckingEnabled);
            tambahbarang.show();
           tambahbarang.setAlwaysOnTop(true);
             jTable1.setModel(model);
        tampildatabarang();
        jTextField1.setText("");
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:  int i=jTable1.getSelectedRow();
       int i=jTable1.getSelectedRow();
        if (i==-1){
            JOptionPane.showMessageDialog(this, "   Silahkan Pilih Data Barang");
            return;
        }
        else
        {
           String idbarang=(String) jTable1.getValueAt(i, 0);
           String nama= (String) jTable1.getValueAt(i, 1);
           String jenis= (String) jTable1.getValueAt(i, 2);
           String satuan= (String) jTable1.getValueAt(i, 3);
           String harga =(String)jTable1.getValueAt(i, 4);
       databarang updatebarang=new  databarang(this, rootPaneCheckingEnabled);
       updatebarang.jLabel2.setText(" UPDATE DATA BARANG");
       updatebarang.jButton1.setText("Update");
       updatebarang.jTextField1.setText(nama);
       updatebarang.jComboBox1.setSelectedItem(jenis);
       updatebarang.jComboBox2.setSelectedItem(satuan);
       updatebarang.jTextField4.setText(harga);
       updatebarang.idbarang=idbarang;
       updatebarang.show();
        updatebarang.setAlwaysOnTop(true);
          jTable1.setModel(model);
     tampildatabarang();
     jTextField1.setText("");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
         int i=jTable1.getSelectedRow();
            if (i==-1)
            {
                JOptionPane.showMessageDialog(this, "      Belum Memilih Data");
            return;
            }
            else{
        try {
            
           String idbarang=(String) jTable1.getValueAt(i, 0);
            Statement statement=(Statement)
                    koneksi.getConnection().createStatement();
            //executequery untuk menampilkan data
            //executeupdate untuk menambah/simpan, edit data
            
             int jawaban = JOptionPane.showConfirmDialog(this, "Apakah anda yakin?",
                "Pertanyaan",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
       if (jawaban==JOptionPane.YES_OPTION)
       {
           statement.executeUpdate("delete from tbbarang where IdBarang=('"+idbarang+"');");
            statement.close();
       }
       else 
            {
           return;
                    }
            JOptionPane.showMessageDialog(this, "Data Berhasil Dihapus");
            tampildatabarang();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Data Gagal Dihapus\n"+e.getMessage());
        }
                    }
              jTable1.setModel(model);
               tampildatabarang();        
     jTextField1.setText("");
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        menudatauser user=new menudatauser(this, rootPaneCheckingEnabled);
        user.show();
        user.setAlwaysOnTop(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:

        login login= new login();
        int jawaban = JOptionPane.showConfirmDialog(this, "Yakin ingin logout?",
            "Konfirmasi Logout",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE
        );
        if (jawaban==JOptionPane.YES_OPTION)
        {
            JOptionPane.showMessageDialog(this, "     Sampai Jumpa "+jLabel2.getText());
            login.show();
            this.dispose();
        }
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
        int jawaban = JOptionPane.showConfirmDialog(this, "Yakin ingin keluar aplikasi?",
            "Konfirmasi Logout",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE
        );
        if (jawaban==JOptionPane.YES_OPTION)
        {
            JOptionPane.showMessageDialog(this, "     Sampai Jumpa "+jLabel2.getText());
            this.dispose();
        }
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenu4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu4MouseClicked

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased
        // TODO add your handling code here:
        tablepelanggansearch();
    }//GEN-LAST:event_jTextField2KeyReleased

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
         datapelanggan tambahpelanggan=new datapelanggan(this, rootPaneCheckingEnabled);
            tambahpelanggan.show();
           tambahpelanggan.setAlwaysOnTop(true);
             jTable2.setModel(model2);
        tampildatapelanggan();
        jTextField2.setText("");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        int i=jTable2.getSelectedRow();
        if (i==-1){
            JOptionPane.showMessageDialog(this, "   Silahkan Pilih Data Pelanggan");
            return;
        }
        else
        {
           String idpelanggan=(String) jTable2.getValueAt(i, 0);
           String nama= (String) jTable2.getValueAt(i, 1);
           String alamat= (String) jTable2.getValueAt(i, 2);
           String notelp= (String) jTable2.getValueAt(i, 3);
       datapelanggan updatepelanggan=new  datapelanggan(this, rootPaneCheckingEnabled);
       updatepelanggan.jLabel2.setText(" UPDATE DATA PELANGGAN");
       updatepelanggan.jButton1.setText("Update");
       updatepelanggan.jTextField1.setText(nama);
       updatepelanggan.jTextField2.setText(alamat);
       updatepelanggan.jTextField3.setText(notelp);
       updatepelanggan.idpelanggan=idpelanggan;
       updatepelanggan.show();
        updatepelanggan.setAlwaysOnTop(true);
          jTable2.setModel(model2);
     tampildatapelanggan();
     jTextField2.setText("");
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        int i=jTable2.getSelectedRow();
            if (i==-1)
            {
                JOptionPane.showMessageDialog(this, "      Belum Memilih Data");
            return;
            }
            else{
        try {
            
           String idpelanggan=(String) jTable2.getValueAt(i, 0);
            Statement statement=(Statement)
                    koneksi.getConnection().createStatement();
            //executequery untuk menampilkan data
            //executeupdate untuk menambah/simpan, edit data
            
             int jawaban = JOptionPane.showConfirmDialog(this, "Apakah anda yakin?",
                "Pertanyaan",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
       if (jawaban==JOptionPane.YES_OPTION)
       {
           statement.executeUpdate("delete from tbpelanggan where IdPelanggan=('"+idpelanggan+"');");
            statement.close();
       }
       else 
            {
           return;
                    }
            JOptionPane.showMessageDialog(this, "Data Berhasil Dihapus");
            tampildatabarang();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Data Gagal Dihapus\n"+e.getMessage());
        }
                    }
              jTable2.setModel(model2);
               tampildatapelanggan();
     jTextField2.setText("");
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTextField3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyReleased
        // TODO add your handling code here:
        tablepenerimaansearch();
    }//GEN-LAST:event_jTextField3KeyReleased

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        penerimaan penerimaan=new penerimaan(this, rootPaneCheckingEnabled);
        penerimaan.iduser=iduser;
        penerimaan.show();
        penerimaan.setAlwaysOnTop(true);
        jTextField3.setText("");
        jTable3.setModel(model3);
        tampildatapenerimaan();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
         int i=jTable3.getSelectedRow();
        if (i==-1){
            JOptionPane.showMessageDialog(this, "   Silahkan Pilih Data Laundry");
            return;
        }
        else{
            
            String notransaksi=(String) jTable3.getValueAt(i, 0);
            pengembalian pengembalian=new pengembalian(this, rootPaneCheckingEnabled);
            pengembalian.iduser=iduser;
            pengembalian.jTextField2.setText(notransaksi);
            
                 try {
                Statement statement=(Statement)
                    koneksi.getConnection().createStatement();
                String sql ="SELECT\n" +
"  `tbpenerimaan`.*, `tbbarang`.*\n" +
"FROM\n" +
"  `tbpenerimaan` INNER JOIN\n" +
"  `tbbarang` ON `tbbarang`.`IdBarang` = `tbpenerimaan`.`IdBarang` where NoTransaksi='"+notransaksi+"';";
             System.out.println(sql);
                ResultSet r = statement.executeQuery(sql); 
            
               
            while(r.next()){
                Double Total=r.getDouble("Jumlah")*r.getDouble("Harga");
                System.out.println(Total);
            pengembalian.jLabel10.setText("Total Cucian :" + Total);
            pengembalian.total=Total;
            }
             
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e);
            }
            
            
            pengembalian.show();
            pengembalian.setAlwaysOnTop(true);
            jTextField3.setText("");
            jTable3.setModel(model3);
            tampildatapenerimaan();
            
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
      datahistory history=new datahistory(this, rootPaneCheckingEnabled);
      history.show();
      history.setAlwaysOnTop(true);
    }//GEN-LAST:event_jButton9ActionPerformed

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
            java.util.logging.Logger.getLogger(menuutama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menuutama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menuutama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menuutama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menuutama().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    public javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    public javax.swing.JTable jTable1;
    public javax.swing.JTable jTable2;
    public javax.swing.JTable jTable3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
