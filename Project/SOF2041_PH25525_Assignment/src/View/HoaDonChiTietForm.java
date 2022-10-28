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
import Model.HoaDon;
import Model.HoaDonChiTiet;
import Service.ChiTietSPService;
import Service.HoaDonChiTietService;
import Service.HoaDonService;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author PC
 */
public class HoaDonChiTietForm extends javax.swing.JFrame {

    private HoaDonChiTietService hdcts;
    private HoaDonService hds;
    private ChiTietSPService ctsps;
    private DefaultTableModel defaultTableModel;
    
    public HoaDonChiTietForm() {
        initComponents();
        this.hdcts = new HoaDonChiTietService();
        this.hds = new HoaDonService();
        this.ctsps = new ChiTietSPService();
        this.loadTable();
        this.loadComboBoxHD();
        this.loadComboBoxCTSP();
        this.setIconImage(ImageI.iconx());
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
    }
    
    public void loadTable(){
        defaultTableModel = (DefaultTableModel) tb_hoaDonChiTiet.getModel();
        defaultTableModel.setRowCount(0);
        for(HoaDonChiTiet hdct: this.hdcts.getList()){
            defaultTableModel.addRow(new Object[]{
                hdct.getHd(), hdct.getCtsp(), hdct.getSoLuong(), hdct.getDonGia()
            });
        }
    }
    
    public void loadComboBoxHD(){
        List<HoaDon> listHD = hds.getList();
        for(HoaDon hd: listHD){
            cbx_idHD.addItem(hd);
        }
    }
    
    public void loadComboBoxCTSP(){
        List<ChiTietSP> listCTSP = ctsps.getList();
        for(ChiTietSP ctsp: listCTSP){
            cbx_idCTSP.addItem(ctsp);
        }
    }

    private void IconX(){
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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bt_new = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_hoaDonChiTiet = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        bt_save = new javax.swing.JButton();
        bt_update = new javax.swing.JButton();
        bt_delete = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lb_dongHo = new javax.swing.JLabel();
        btn_prev = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txt_soLuong = new javax.swing.JTextField();
        btn_next = new javax.swing.JButton();
        txt_donGia = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cbx_idHD = new javax.swing.JComboBox<HoaDon>();
        cbx_idCTSP = new javax.swing.JComboBox<ChiTietSP>()
        ;

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hóa đơn chi tiết");

        bt_new.setText("New");
        bt_new.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_newActionPerformed(evt);
            }
        });

        tb_hoaDonChiTiet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id hóa đơn", "Id chi tiết SP", "Số lượng", "Đơn giá"
            }
        ));
        tb_hoaDonChiTiet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_hoaDonChiTietMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_hoaDonChiTiet);

        jLabel3.setText("Số lượng");

        bt_save.setText("Save");
        bt_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_saveActionPerformed(evt);
            }
        });

        bt_update.setText("Update");
        bt_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_updateActionPerformed(evt);
            }
        });

        bt_delete.setText("Delete");
        bt_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_deleteActionPerformed(evt);
            }
        });

        jLabel2.setText("Id chi tiết SP");

        lb_dongHo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lb_dongHo.setText("jLabel4");

        btn_prev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_prevActionPerformed(evt);
            }
        });

        jLabel1.setText("Id hóa đơn");

        btn_next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nextActionPerformed(evt);
            }
        });

        jLabel4.setText("Đơn giá");

        cbx_idHD.setModel(new javax.swing.DefaultComboBoxModel<HoaDon>()
        );

        cbx_idCTSP.setModel(new javax.swing.DefaultComboBoxModel<ChiTietSP>()
        );

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
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbx_idHD, 0, 134, Short.MAX_VALUE)
                            .addComponent(cbx_idCTSP, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_soLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_donGia, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(61, 61, 61))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(47, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bt_new)
                        .addGap(31, 31, 31)
                        .addComponent(bt_save)
                        .addGap(109, 109, 109)
                        .addComponent(bt_delete)
                        .addGap(52, 52, 52)
                        .addComponent(bt_update)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(btn_prev)
                .addGap(54, 54, 54)
                .addComponent(btn_next)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lb_dongHo)
                .addGap(88, 88, 88))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(txt_soLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbx_idHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_donGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(cbx_idCTSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addContainerGap(82, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lb_dongHo)
                        .addGap(59, 59, 59))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_newActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_newActionPerformed
        clearForm();
    }//GEN-LAST:event_bt_newActionPerformed

    private void tb_hoaDonChiTietMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_hoaDonChiTietMouseClicked
        try {
            int row = tb_hoaDonChiTiet.getSelectedRow();
            fillData(row);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_tb_hoaDonChiTietMouseClicked

    private void bt_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_saveActionPerformed
        HoaDonChiTiet hdct = this.addData();
        if(hdct == null){
            return;
        }
        this.hdcts.insert(hdct);
        this.loadTable();
    }//GEN-LAST:event_bt_saveActionPerformed

    private void bt_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_deleteActionPerformed
        int row = tb_hoaDonChiTiet.getSelectedRow();
        if(row == -1){
            JOptionPane.showMessageDialog(this, "Chọn dòng cần xóa");
            return;
        }
        int con = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa không");
        if(con != JOptionPane.YES_OPTION){
            return;
        }
        String idHD = tb_hoaDonChiTiet.getValueAt(row, 0).toString();
        String idCTSP = tb_hoaDonChiTiet.getValueAt(row, 1).toString();
        this.hdcts.delete(idHD, idCTSP);
        this.loadTable();
        this.clearForm();
    }//GEN-LAST:event_bt_deleteActionPerformed

    private void bt_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_updateActionPerformed
        int row = tb_hoaDonChiTiet.getSelectedRow();
        if(row == -1){
            JOptionPane.showMessageDialog(this, "Chọn dòng cần sửa");
            return;
        }
        HoaDonChiTiet hdct = this.addData();
        this.hdcts.update(hdct.getHd().getId(), hdct.getCtsp().getId(), hdct);
        this.loadTable();
    }//GEN-LAST:event_bt_updateActionPerformed

    private void btn_prevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_prevActionPerformed
        try {
            int row = tb_hoaDonChiTiet.getSelectedRow();
            if(row == 0){
                row = hdcts.getList().size() - 1;
                fillData(row);
                tb_hoaDonChiTiet.setRowSelectionInterval(row, row);
            }else{
                row--;
                fillData(row);
                tb_hoaDonChiTiet.setRowSelectionInterval(row, row);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btn_prevActionPerformed

    private void btn_nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nextActionPerformed
        try {
            int row = tb_hoaDonChiTiet.getSelectedRow();
            if(row == hdcts.getList().size() - 1){
                row = 0;
                fillData(row);
                tb_hoaDonChiTiet.setRowSelectionInterval(row, row);
            }else{
                row++;
                fillData(row);
                tb_hoaDonChiTiet.setRowSelectionInterval(row, row);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btn_nextActionPerformed

    private void clearForm(){
        this.txt_donGia.setText("");
        this.cbx_idHD.setSelectedIndex(0);
        this.cbx_idCTSP.setSelectedIndex(0);
        this.txt_soLuong.setText("");
    }
    
    private HoaDonChiTiet addData(){
        HoaDon idHD = (HoaDon) cbx_idHD.getSelectedItem();
        ChiTietSP idCTSP = (ChiTietSP) cbx_idCTSP.getSelectedItem();
        String soLuong = this.txt_soLuong.getText();
        String donGia = this.txt_donGia.getText();
        if(soLuong.length() == 0 || donGia.length() == 0){
            JOptionPane.showMessageDialog(this, "Không được để trống");
            return null;
        }
        int sl = -1;
        try {
            sl = Integer.parseInt(soLuong);
            if(sl <= 0){
                JOptionPane.showMessageDialog(this, "Nhập sai số lượng");
                return null;
            }
        } catch (Exception e) {
        }
        double dg = -1;
        try {
            dg = Double.parseDouble(donGia);
            if(dg <= 0){
                JOptionPane.showMessageDialog(this, "Nhập sai Đơn giá");
                return null;
            }
        } catch (Exception e) {
        }
        HoaDonChiTiet hdct = new HoaDonChiTiet(idHD, idCTSP, sl, dg);
        return hdct;
    }
    
    private void fillData(int row){
        HoaDon hd = (HoaDon) tb_hoaDonChiTiet.getValueAt(row, 0);
        int soLuongHD = cbx_idHD.getItemCount();
        for(int i = 0; i < soLuongHD; i++){
            HoaDon hdn = cbx_idHD.getItemAt(i);
            if(hdn.getId().equals(hd.getId())){
                cbx_idHD.setSelectedIndex(i);
            }
        }
        ChiTietSP ctsp = (ChiTietSP) tb_hoaDonChiTiet.getValueAt(row, 1);
        int soLuongSP = cbx_idCTSP.getItemCount();
        for(int i = 0; i < soLuongSP; i++){
            ChiTietSP ctspr = cbx_idCTSP.getItemAt(i);
            if(ctspr.getId().equals(ctsp.getId()));
        }
        txt_soLuong.setText(tb_hoaDonChiTiet.getValueAt(row, 2).toString());
        txt_donGia.setText(tb_hoaDonChiTiet.getValueAt(row, 3).toString());
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
            java.util.logging.Logger.getLogger(HoaDonChiTietForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HoaDonChiTietForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HoaDonChiTietForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HoaDonChiTietForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HoaDonChiTietForm().setVisible(true);
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
    private javax.swing.JComboBox<ChiTietSP> cbx_idCTSP;
    private javax.swing.JComboBox<HoaDon> cbx_idHD;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_dongHo;
    private javax.swing.JTable tb_hoaDonChiTiet;
    private javax.swing.JTextField txt_donGia;
    private javax.swing.JTextField txt_soLuong;
    // End of variables declaration//GEN-END:variables
}
