/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.sql.Date;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import Icon.ImageI;
import Model.GioHang;
import Service.GioHangService;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC
 */
public class GioHangForm extends javax.swing.JFrame {

    private GioHangService ghs;
    private DefaultTableModel defaultTableModel;

    public GioHangForm() {
        initComponents();
        this.ghs = new GioHangService();
        this.setIconImage(ImageI.iconx());
        this.IconX();
        this.loadTable();
        this.setLocationRelativeTo(null);

    }

    public void loadTable() {
        defaultTableModel = (DefaultTableModel) tb_gioHang.getModel();
        defaultTableModel.setRowCount(0);
        for (GioHang gh : this.ghs.getList()) {
            defaultTableModel.addRow(new Object[]{
                gh.getId(), gh.getMa(), gh.getNgayTao(), gh.getNgayThanhToan(), gh.getTenNguoiNhan(), gh.getDiaChi(), gh.getSdt(), gh.getTinhTrang()
            });
        }
    }

    public boolean checkMa(String ma) {
        ArrayList<GioHang> listGH = this.ghs.getList();
        for (int i = 0; i < listGH.size(); i++) {
            if (listGH.get(i).getMa().equals(ma)) {
                return true;
            }
        }
        return false;
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

        txt_diaChi = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btn_prev = new javax.swing.JButton();
        lb_id = new javax.swing.JLabel();
        btn_next = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txt_tenNguoiNhan = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_ngayThanhToan = new javax.swing.JTextField();
        btn_new = new javax.swing.JButton();
        btn_save = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_gioHang = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        txt_maGioHang = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_ngayTao = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_sdt = new javax.swing.JTextField();
        cbx_tinhTrang = new javax.swing.JComboBox<>();
        lb_idKH = new javax.swing.JLabel();
        lb_idNV = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Giỏ hàng");

        jLabel2.setText("IdKH");

        jLabel3.setText("Ngày thanh toán");

        btn_prev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_prevActionPerformed(evt);
            }
        });

        lb_id.setText("-");

        btn_next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nextActionPerformed(evt);
            }
        });

        jLabel5.setText("Tên người nhận");

        jLabel6.setText("IdNV");

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

        jLabel7.setText("Địa chỉ");

        tb_gioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Mã giỏ hàng", "Ngày tạo", "Ngày thanh toán", "Tên người nhận", "Địa chỉ", "Sđt", "Tình trạng"
            }
        ));
        tb_gioHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_gioHangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_gioHang);

        jLabel8.setText("Mã giỏ hàng");

        jLabel9.setText("Ngày tạo");

        jLabel10.setText("Sđt");

        jLabel11.setText("Tình trạng");

        cbx_tinhTrang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đã thanh toán ", "Chưa thanh toán" }));

        lb_idKH.setText("-");

        lb_idNV.setText("-");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(13, 13, 13)
                            .addComponent(btn_new)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel6))
                            .addComponent(jLabel9))
                        .addGap(1, 1, 1)))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_ngayTao, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_maGioHang, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(lb_idNV, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lb_id, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(lb_idKH))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7)
                                .addComponent(jLabel5)
                                .addComponent(jLabel10)
                                .addComponent(jLabel11)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_ngayThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_tenNguoiNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_diaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbx_tinhTrang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(83, 83, 83))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(btn_save)
                        .addGap(113, 113, 113)
                        .addComponent(btn_delete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_update)
                        .addGap(115, 115, 115))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 705, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(204, 204, 204)
                .addComponent(btn_prev)
                .addGap(107, 107, 107)
                .addComponent(btn_next)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(lb_id)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(lb_idKH))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(lb_idNV))
                                .addGap(13, 13, 13)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(txt_maGioHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(jLabel1)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(txt_ngayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel3)
                                            .addComponent(txt_ngayThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(21, 21, 21)
                                        .addComponent(jLabel5))
                                    .addComponent(txt_tenNguoiNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(16, 16, 16)
                                .addComponent(jLabel7))
                            .addComponent(txt_diaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txt_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(cbx_tinhTrang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(74, 74, 74)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_new)
                    .addComponent(btn_save)
                    .addComponent(btn_delete)
                    .addComponent(btn_update))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_next, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_prev, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_newActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_newActionPerformed
        clearform();
    }//GEN-LAST:event_btn_newActionPerformed

    private void tb_gioHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_gioHangMouseClicked
        try {
            int row = tb_gioHang.getSelectedRow();
            fillData(row);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_tb_gioHangMouseClicked

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        if (checkMa(txt_maGioHang.getText()) == true) {
            JOptionPane.showMessageDialog(this, "Trùng mã");
        } else {
            GioHang gh = this.addData();
            if (gh == null) {
                return;
            }
            this.ghs.insert(gh);
            this.loadTable();
        }
    }//GEN-LAST:event_btn_saveActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        int row = tb_gioHang.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Chọn dòng cần xóa");
            return;
        }
        int con = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa không");
        if (con != JOptionPane.YES_OPTION) {
            return;
        }
        String ma = tb_gioHang.getValueAt(row, 1).toString();
        this.ghs.delete(ma);
        this.loadTable();
        this.clearform();
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        int row = tb_gioHang.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Chọn dòng cần sửa");
            return;
        }
        GioHang gh = this.addData();
        this.ghs.update(gh.getId(), gh);
        this.loadTable();
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_prevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_prevActionPerformed
        try {
            int row = tb_gioHang.getSelectedRow();
            if (row == 0) {
                row = ghs.getList().size() - 1;
                fillData(row);
                tb_gioHang.setRowSelectionInterval(row, row);
            } else {
                row--;
                fillData(row);
                tb_gioHang.setRowSelectionInterval(row, row);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btn_prevActionPerformed

    private void btn_nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nextActionPerformed
        try {
            int row = tb_gioHang.getSelectedRow();
            if (row == ghs.getList().size() - 1) {
                row = 0;
                fillData(row);
                tb_gioHang.setRowSelectionInterval(row, row);
            } else {
                row++;
                fillData(row);
                tb_gioHang.setRowSelectionInterval(row, row);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btn_nextActionPerformed

    private void clearform() {
        lb_id.setText("-");
        txt_diaChi.setText("");
        txt_maGioHang.setText("");
        txt_ngayTao.setText("");
        txt_ngayThanhToan.setText("");
        txt_tenNguoiNhan.setText("");
        txt_sdt.setText("");
        cbx_tinhTrang.setSelectedIndex(0);
    }

    private GioHang addData() {
        String id = this.lb_id.getText();
        String ma = this.txt_maGioHang.getText();
        String ngayTao = this.txt_ngayTao.getText();
        String ngayThanhToan = this.txt_ngayThanhToan.getText();
        String tenNguoiNhan = this.txt_tenNguoiNhan.getText();
        String diaChi = this.txt_diaChi.getText();
        String sdt = this.txt_sdt.getText();
        int tinhTrang = 0;
        if (ma.length() == 0 || ngayTao.length() == 0 || ngayThanhToan.length() == 0 || tenNguoiNhan.length() == 0 || diaChi.length() == 0 || sdt.length() == 0) {
            JOptionPane.showMessageDialog(this, "Không được để trống");
            return null;
        }
        Date date = null;
        Date dat = null;
        try {
            date = Date.valueOf(ngayTao);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi ngày");
        }
        try {
            dat = Date.valueOf(ngayThanhToan);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi ngày");
        }
        GioHang gh = new GioHang(id, ma, date, dat, tenNguoiNhan, diaChi, sdt, tinhTrang);
        if (cbx_tinhTrang.getSelectedItem().equals("Đã thanh toán")) {
            tinhTrang = 1;
        } else {
            tinhTrang = 0;
        }
        return gh;
    }

    private void fillData(int row) {
        lb_id.setText(tb_gioHang.getValueAt(row, 0).toString());
        txt_maGioHang.setText(tb_gioHang.getValueAt(row, 1).toString());
        txt_ngayTao.setText(tb_gioHang.getValueAt(row, 2).toString());
        txt_ngayThanhToan.setText(tb_gioHang.getValueAt(row, 3).toString());
        txt_tenNguoiNhan.setText(tb_gioHang.getValueAt(row, 4).toString());
        txt_diaChi.setText(tb_gioHang.getValueAt(row, 5).toString());
        txt_sdt.setText(tb_gioHang.getValueAt(row, 6).toString());
        if (tb_gioHang.getValueAt(row, 7).equals(0)) {
            cbx_tinhTrang.setSelectedIndex(1);
        } else {
            cbx_tinhTrang.setSelectedIndex(0);
        }
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
            java.util.logging.Logger.getLogger(GioHangForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GioHangForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GioHangForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GioHangForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GioHangForm().setVisible(true);
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
    private javax.swing.JComboBox<String> cbx_tinhTrang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_id;
    private javax.swing.JLabel lb_idKH;
    private javax.swing.JLabel lb_idNV;
    private javax.swing.JTable tb_gioHang;
    private javax.swing.JTextField txt_diaChi;
    private javax.swing.JTextField txt_maGioHang;
    private javax.swing.JTextField txt_ngayTao;
    private javax.swing.JTextField txt_ngayThanhToan;
    private javax.swing.JTextField txt_sdt;
    private javax.swing.JTextField txt_tenNguoiNhan;
    // End of variables declaration//GEN-END:variables
}
