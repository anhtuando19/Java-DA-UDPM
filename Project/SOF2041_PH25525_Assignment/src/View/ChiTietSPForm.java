/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import Icon.ImageI;
import Model.ChiTietSP;
import Model.SanPham;
import Service.ChiTietSPService;
import Service.SanPhamService;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC
 */
public class ChiTietSPForm extends javax.swing.JFrame {

    private ChiTietSPService ctsps;
    private SanPhamService sps;
    private DefaultTableModel defaultTableModel;
    private DefaultComboBoxModel dfcb = new DefaultComboBoxModel();

    public ChiTietSPForm() {
        initComponents();

        this.ctsps = new ChiTietSPService();
        this.sps = new SanPhamService();
        this.setIconImage(ImageI.iconx());
        this.IconX();
        this.loadComboBoxSP();
        this.loadTable();
        this.setLocationRelativeTo(null);
        new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date now = new Date();
                SimpleDateFormat formater = new SimpleDateFormat("hh:mm a");
                String text = formater.format(now);
                lb_dongHo.setText(text);
            }
        }).start();
    }

    public void loadTable() {
        defaultTableModel = (DefaultTableModel) tb_chiTietSP.getModel();
        defaultTableModel.setRowCount(0);
        for (ChiTietSP ctsp : this.ctsps.getList()) {
            defaultTableModel.addRow(new Object[]{
                ctsp.getId(), ctsp.getIdSP(), ctsp.getNamBH(), ctsp.getMoTa(), ctsp.getSoLuongTon(), ctsp.getGiaNhap(), ctsp.getGiaBan()
            });
        }
    }

    public void loadComboBoxSP() {
        List<SanPham> listSP = sps.getList();
        for (SanPham sp : listSP) {
            cbx_idSP.addItem(sp);
        }
    }

    private void IconX() {
        Icon iNew = new ImageIcon("new.png");
        Icon iDelete = new ImageIcon("delete.png");
        Icon iSave = new ImageIcon("save.png");
        Icon iUpdate = new ImageIcon("update.png");
        Icon iPrev = new ImageIcon("first.png");
        Icon iNext = new ImageIcon("last.png");

        this.btn_new.setIcon(iNew);
        this.btn_delete.setIcon(iDelete);
        this.btn_save.setIcon(iSave);
        this.btn_update.setIcon(iUpdate);
        this.btn_next.setIcon(iNext);
        this.btn_prev.setIcon(iPrev);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_prev = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        lb_id = new javax.swing.JLabel();
        txt_giaNhap = new javax.swing.JTextField();
        btn_next = new javax.swing.JButton();
        txt_giaBan = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_moTa = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_namBH = new javax.swing.JTextField();
        btn_new = new javax.swing.JButton();
        btn_save = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_chiTietSP = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        txt_soLuongTon = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lb_dongHo = new javax.swing.JLabel();
        lb = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lb_id2 = new javax.swing.JLabel();
        lb_id3 = new javax.swing.JLabel();
        lb_id4 = new javax.swing.JLabel();
        cbx_idSP = new javax.swing.JComboBox<SanPham>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chi tiết SP");

        btn_prev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_prevActionPerformed(evt);
            }
        });

        jLabel11.setText("Giá bán");

        lb_id.setText("-");

        btn_next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nextActionPerformed(evt);
            }
        });

        jLabel5.setText("Mô tả");

        jLabel6.setText("IdNSX");

        btn_new.setText("New");
        btn_new.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_newActionPerformed(evt);
            }
        });

        btn_save.setText("Save");
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });

        btn_update.setText("Update");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        btn_delete.setText("Delete");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        jLabel1.setText("Id");

        jLabel7.setText("Số lượng tồn");

        tb_chiTietSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "IdSP", "Năm BH", "Mô tả", "Số lượng tồn", "Giá nhập", "Giá bán"
            }
        ));
        tb_chiTietSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_chiTietSPMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_chiTietSP);

        jLabel8.setText("IdMauSac");

        jLabel2.setText("IdSP");

        jLabel9.setText("IdDongSP");

        lb_dongHo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lb_dongHo.setText("jLabel8");

        lb.setText("Năm BH");

        jLabel10.setText("Giá nhập");

        lb_id2.setText("-");

        lb_id3.setText("-");

        lb_id4.setText("-");

        cbx_idSP.setModel(new javax.swing.DefaultComboBoxModel<SanPham>());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(btn_new, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(125, 125, 125)
                                .addComponent(btn_prev)
                                .addGap(107, 107, 107)
                                .addComponent(btn_next)
                                .addGap(111, 111, 111)
                                .addComponent(lb_dongHo)
                                .addGap(103, 103, 103))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(btn_update)
                                        .addGap(194, 194, 194))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(42, 42, 42)
                                        .addComponent(btn_save)
                                        .addGap(80, 80, 80)
                                        .addComponent(btn_delete)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lb_id)
                                            .addComponent(lb_id4)
                                            .addComponent(lb_id3)
                                            .addComponent(lb_id2)
                                            .addComponent(cbx_idSP, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel10)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel5)
                                            .addComponent(lb))
                                        .addGap(29, 29, 29)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txt_giaNhap, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_giaBan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_soLuongTon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_moTa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_namBH, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(41, 41, 41))))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 705, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(lb_id))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(cbx_idSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(lb_id3)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(lb_id2)))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(lb_id4)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_namBH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_moTa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_soLuongTon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_giaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_giaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))))
                .addGap(88, 88, 88)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_new)
                    .addComponent(btn_save)
                    .addComponent(btn_delete)
                    .addComponent(btn_update))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addComponent(lb_dongHo)
                        .addGap(48, 48, 48))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_next, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_prev, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(57, 57, 57))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_newActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_newActionPerformed
        clearForm();
    }//GEN-LAST:event_btn_newActionPerformed

    private void tb_chiTietSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_chiTietSPMouseClicked
        try {
            int row = tb_chiTietSP.getSelectedRow();
            fillData(row);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_tb_chiTietSPMouseClicked

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        ChiTietSP ctsp = this.addData();
        if (ctsp == null) {
            return;
        }
        this.ctsps.insert(ctsp);
        this.loadTable();
    }//GEN-LAST:event_btn_saveActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        int row = tb_chiTietSP.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Chọn dòng cần xóa");
            return;
        }
        int con = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa không");
        if (con != JOptionPane.YES_OPTION) {
            return;
        }
        String id = tb_chiTietSP.getValueAt(row, 0).toString();
        String idSP = tb_chiTietSP.getValueAt(row, 1).toString();
        this.ctsps.delete(id, idSP);
        this.loadTable();
        this.clearForm();
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        int row = tb_chiTietSP.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Chọn dòng cần sửa");
            return;
        }
        ChiTietSP ctsp = this.addData();
        this.ctsps.update(ctsp.getId(), ctsp.getIdSP().getId(), ctsp);
        this.loadTable();
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_prevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_prevActionPerformed
        try {
            int row = tb_chiTietSP.getSelectedRow();
            if (row == 0) {
                row = ctsps.getList().size() - 1;
                fillData(row);
                tb_chiTietSP.setRowSelectionInterval(row, row);
            } else {
                row--;
                fillData(row);
                tb_chiTietSP.setRowSelectionInterval(row, row);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btn_prevActionPerformed

    private void btn_nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nextActionPerformed
        try {
            int row = tb_chiTietSP.getSelectedRow();
            if (row == ctsps.getList().size() - 1) {
                row = 0;
                fillData(row);
                tb_chiTietSP.setRowSelectionInterval(row, row);
            } else {
                row++;
                fillData(row);
                tb_chiTietSP.setRowSelectionInterval(row, row);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btn_nextActionPerformed

    private void clearForm() {
        this.lb_id.setText("-");
        this.cbx_idSP.setSelectedIndex(0);
        this.txt_moTa.setText("");
        this.txt_namBH.setText("");
        this.txt_soLuongTon.setText("");
        this.txt_giaBan.setText("");
        this.txt_giaNhap.setText("");
    }

    private ChiTietSP addData() {
        String id = this.lb_id.getText();
        SanPham idSP = (SanPham) cbx_idSP.getSelectedItem();
        String namBH = this.txt_namBH.getText();
        String moTa = this.txt_moTa.getText();
        String soLuongTon = this.txt_soLuongTon.getText();
        String giaNhap = this.txt_giaNhap.getText();
        String giaBan = this.txt_giaBan.getText();
        if (namBH.length() == 0 || moTa.length() == 0 || soLuongTon.length() == 0 || giaNhap.length() == 0 || giaBan.length() == 0) {
            JOptionPane.showMessageDialog(this, "Không được để trống");
            return null;
        }
        int namBH1 = -1;
        try {
            namBH1 = Integer.parseInt(namBH);
            if (namBH1 <= 0) {
                JOptionPane.showMessageDialog(this, "Nhập sai namBH");
                return null;
            }
        } catch (NumberFormatException e) {
        }
        int slt = -1;
        try {
            slt = Integer.parseInt(soLuongTon);
            if (slt < 0) {
                JOptionPane.showMessageDialog(this, "Nhập sai namBH");
                return null;
            }
        } catch (NumberFormatException e) {
        }
        double giaN = -1;
        try {
            giaN = Double.parseDouble(giaNhap);
            if (giaN <= 0) {
                JOptionPane.showMessageDialog(this, "Nhập sai giá nhập");
                return null;
            }
        } catch (NumberFormatException e) {
        }
        double giaB = -1;
        try {
            giaB = Double.parseDouble(giaBan);
            if (giaB <= 0) {
                JOptionPane.showMessageDialog(this, "Nhập sai giá bán");
                return null;
            }
        } catch (NumberFormatException e) {
        }
        ChiTietSP ctsp = new ChiTietSP(id, idSP, namBH1, moTa, slt, giaN, giaB);
        return ctsp;
    }

    private void fillData(int row) {
        lb_id.setText(tb_chiTietSP.getValueAt(row, 0).toString());
        SanPham sp = (SanPham) tb_chiTietSP.getValueAt(row, 1);
        int soLuongSP = cbx_idSP.getItemCount();
        for (int i = 0; i < soLuongSP; i++) {
            SanPham spm = cbx_idSP.getItemAt(i);
            if (spm.getId().equals(sp.getId())) {
                cbx_idSP.setSelectedIndex(i);
            }
        }
        txt_namBH.setText(tb_chiTietSP.getValueAt(row, 2).toString());
        txt_moTa.setText(tb_chiTietSP.getValueAt(row, 3).toString());
        txt_soLuongTon.setText(tb_chiTietSP.getValueAt(row, 4).toString());
        txt_giaNhap.setText(tb_chiTietSP.getValueAt(row, 5).toString());
        txt_giaBan.setText(tb_chiTietSP.getValueAt(row, 6).toString());
    }

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
            java.util.logging.Logger.getLogger(ChiTietSPForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChiTietSPForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChiTietSPForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChiTietSPForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChiTietSPForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_new;
    private javax.swing.JButton btn_next;
    private javax.swing.JButton btn_prev;
    private javax.swing.JButton btn_save;
    private javax.swing.JButton btn_update;
    private javax.swing.JComboBox<SanPham> cbx_idSP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb;
    private javax.swing.JLabel lb_dongHo;
    private javax.swing.JLabel lb_id;
    private javax.swing.JLabel lb_id2;
    private javax.swing.JLabel lb_id3;
    private javax.swing.JLabel lb_id4;
    private javax.swing.JTable tb_chiTietSP;
    private javax.swing.JTextField txt_giaBan;
    private javax.swing.JTextField txt_giaNhap;
    private javax.swing.JTextField txt_moTa;
    private javax.swing.JTextField txt_namBH;
    private javax.swing.JTextField txt_soLuongTon;
    // End of variables declaration//GEN-END:variables
}
