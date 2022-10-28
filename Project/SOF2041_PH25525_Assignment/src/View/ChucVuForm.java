/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import Icon.ImageI;
import Model.ChucVu;
import Service.ChucVuService;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC
 */
public class ChucVuForm extends javax.swing.JFrame {

    private ChucVuService cvs;
    private DefaultTableModel defaultTableModel;

    public ChucVuForm() {
        initComponents();
        this.setIconImage(ImageI.iconx());
        this.cvs = new ChucVuService();
        this.IconX();
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
        this.loadTable();
    }

    private void IconX() {
        Icon iNew = new ImageIcon("new.png");
        Icon iDelete = new ImageIcon("delete.png");
        Icon iSave = new ImageIcon("save.png");
        Icon iUpdate = new ImageIcon("update.png");
        Icon iPrev = new ImageIcon("first.png");
        Icon iNext = new ImageIcon("last.png");

        this.bt_new.setIcon(iNew);
        this.bt_delete.setIcon(iDelete);
        this.bt_save.setIcon(iSave);
        this.bt_update.setIcon(iUpdate);
        this.btn_next.setIcon(iNext);
        this.btn_prev.setIcon(iPrev);
    }

    public boolean checkMa(String ma) {
        ArrayList<ChucVu> listCH = this.cvs.getList();
        for (int i = 0; i < listCH.size(); i++) {
            if (listCH.get(i).getMa().equals(ma)) {
                return true;
            }
        }
        return false;
    }

    public void loadTable() {
        defaultTableModel = (DefaultTableModel) tb_chucVu.getModel();
        defaultTableModel.setRowCount(0);
        for (ChucVu cv : this.cvs.getList()) {
            defaultTableModel.addRow(new Object[]{
                cv.getId(), cv.getMa(), cv.getTen()
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lb_id = new javax.swing.JLabel();
        txt_ten = new javax.swing.JTextField();
        txt_ma = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_chucVu = new javax.swing.JTable();
        btn_prev = new javax.swing.JButton();
        btn_next = new javax.swing.JButton();
        bt_new = new javax.swing.JButton();
        bt_save = new javax.swing.JButton();
        bt_delete = new javax.swing.JButton();
        bt_update = new javax.swing.JButton();
        lb_dongHo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chức vụ");

        jLabel1.setText("Id");

        jLabel2.setText("Mã chức vụ");

        jLabel3.setText("Tên chức vụ");

        lb_id.setText("-");

        tb_chucVu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id", "Mã chức vụ", "Tên chức vụ"
            }
        ));
        tb_chucVu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_chucVuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_chucVu);

        btn_prev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_prevActionPerformed(evt);
            }
        });

        btn_next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nextActionPerformed(evt);
            }
        });

        bt_new.setText("New");
        bt_new.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_newActionPerformed(evt);
            }
        });

        bt_save.setText("Save");
        bt_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_saveActionPerformed(evt);
            }
        });

        bt_delete.setText("Delete");
        bt_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_deleteActionPerformed(evt);
            }
        });

        bt_update.setText("Update");
        bt_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_updateActionPerformed(evt);
            }
        });

        lb_dongHo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lb_dongHo.setText("jLabel4");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lb_id)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_ten, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txt_ma, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(295, 295, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(btn_prev)
                .addGap(54, 54, 54)
                .addComponent(btn_next)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lb_dongHo)
                .addGap(88, 88, 88))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bt_new)
                .addGap(31, 31, 31)
                .addComponent(bt_save)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bt_delete)
                .addGap(48, 48, 48)
                .addComponent(bt_update)
                .addGap(73, 73, 73))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(lb_id)
                    .addComponent(txt_ten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_ma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bt_new)
                            .addComponent(bt_update)
                            .addComponent(bt_delete)
                            .addComponent(bt_save))
                        .addGap(32, 32, 32)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_prev, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_next, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(47, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lb_dongHo)
                        .addGap(59, 59, 59))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_newActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_newActionPerformed
        clearform();
    }//GEN-LAST:event_bt_newActionPerformed

    private void tb_chucVuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_chucVuMouseClicked
        try {
            int row = tb_chucVu.getSelectedRow();
            fillData(row);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_tb_chucVuMouseClicked

    private void bt_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_saveActionPerformed
        if (checkMa(txt_ma.getText()) == true) {
            JOptionPane.showMessageDialog(this, "Trùng mã");
        } else {
            ChucVu cv = this.addData();
            if (cv == null) {
                return;
            }
            this.cvs.insert(cv);
            this.loadTable();
        }
    }//GEN-LAST:event_bt_saveActionPerformed

    private void bt_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_deleteActionPerformed
        int row = tb_chucVu.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Chọn dòng cần xóa");
            return;
        }
        int con = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa không");
        if (con != JOptionPane.YES_OPTION) {
            return;
        }
        String ma = tb_chucVu.getValueAt(row, 1).toString();
        this.cvs.delete(ma);
        this.loadTable();
        this.clearform();
    }//GEN-LAST:event_bt_deleteActionPerformed

    private void bt_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_updateActionPerformed
        int row = tb_chucVu.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Chọn dòng cần sửa");
            return;
        }
        ChucVu cv = this.addData();
        this.cvs.update(cv.getId(), cv);
        this.loadTable();
    }//GEN-LAST:event_bt_updateActionPerformed

    private void btn_prevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_prevActionPerformed
        try {
            int row = tb_chucVu.getSelectedRow();
            if (row == 0) {
                row = cvs.getList().size() - 1;
                fillData(row);
                tb_chucVu.setRowSelectionInterval(row, row);
            } else {
                row--;
                fillData(row);
                tb_chucVu.setRowSelectionInterval(row, row);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btn_prevActionPerformed

    private void btn_nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nextActionPerformed
        try {
            int row = tb_chucVu.getSelectedRow();
            if (row == cvs.getList().size() - 1) {
                row = 0;
                fillData(row);
                tb_chucVu.setRowSelectionInterval(row, row);
            } else {
                row++;
                fillData(row);
                tb_chucVu.setRowSelectionInterval(row, row);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btn_nextActionPerformed

    public ChucVu addData() {
        String id = this.lb_id.getText();
        String ma = this.txt_ma.getText();
        String ten = this.txt_ten.getText();
        if (id.length() == 0 || ma.length() == 0 || ten.length() == 0) {
            JOptionPane.showMessageDialog(this, "Không được để trống");
            return null;
        }
        ChucVu cv = new ChucVu(id, ma, ten);
        return cv;
    }

    private void clearform() {
        this.lb_id.setText("-");
        this.txt_ma.setText("");
        this.txt_ten.setText("");
    }

    private void fillData(int row) {
        lb_id.setText(tb_chucVu.getValueAt(row, 0).toString());
        txt_ma.setText(tb_chucVu.getValueAt(row, 1).toString());
        txt_ten.setText(tb_chucVu.getValueAt(row, 2).toString());
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
            java.util.logging.Logger.getLogger(ChucVuForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChucVuForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChucVuForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChucVuForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChucVuForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_delete;
    private javax.swing.JButton bt_new;
    private javax.swing.JButton bt_save;
    private javax.swing.JButton bt_update;
    private javax.swing.JButton btn_next;
    private javax.swing.JButton btn_prev;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_dongHo;
    private javax.swing.JLabel lb_id;
    private javax.swing.JTable tb_chucVu;
    private javax.swing.JTextField txt_ma;
    private javax.swing.JTextField txt_ten;
    // End of variables declaration//GEN-END:variables
}
