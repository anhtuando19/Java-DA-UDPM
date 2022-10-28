/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Icon.ImageI;
import Model.HoaDon;
import Service.BanHangService;
import Service.HoaDonService;
import ViewModel.TableGiohang;
import ViewModel.TableSanPham;
import java.sql.Date;
import java.util.Random;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC
 */
public class BanHangForm extends javax.swing.JFrame {

    private DefaultTableModel defaultTableModel;
    private BanHangService bhs;
    private HoaDonService hds;
    private int stt = 1;
    ButtonGroup buttonGroup = new ButtonGroup();

    public BanHangForm() {
        initComponents();
        this.bhs = new BanHangService();
        this.hds = new HoaDonService();
        this.loadTableSP();
        this.searchByMa();
        this.searchByTen();
        this.loadTableHoaDon();
        this.trangThai();
        this.setEdit();
        this.setLocationRelativeTo(null);
        this.setIconImage(ImageI.iconx());
    }

    public void setEdit() {
        txt_maHD.setEditable(false);
        txt_tenNV.setEditable(false);
        txt_ngayTao.setEditable(false);
        txt_tienThua.setEditable(false);
        txt_tongTien.setEditable(false);
    }

    public void loadTableSP() {
        defaultTableModel = (DefaultTableModel) tb_sanPham.getModel();
        defaultTableModel.setRowCount(0);
        int row = tb_sanPham.getSelectedRow();
        for (TableSanPham sp : bhs.getListSP()) {
            defaultTableModel.addRow(new Object[]{
                row == -1 ? row += 2 : ++row, sp.getMa(), sp.getTen(), sp.getNamBH(), sp.getMoTa(), sp.getSoLuongTon(), sp.getGiaNhap(), sp.getGiaBan()
            });
        }
    }

    public void searchByMa() {
        String text = txt_search.getText();
        int row = tb_sanPham.getSelectedRow();
        defaultTableModel = (DefaultTableModel) tb_sanPham.getModel();
        defaultTableModel.setRowCount(0);
        for (TableSanPham sp : bhs.getListSP()) {
            defaultTableModel.addRow(new Object[]{
                row == -1 ? row += 2 : ++row, sp.getMa(), sp.getTen(), sp.getNamBH(), sp.getMoTa(), sp.getSoLuongTon(), sp.getGiaNhap(), sp.getGiaBan()
            });
        }
    }

    public void searchByTen() {
        String text = txt_search.getText();
        int row = tb_sanPham.getSelectedRow();
        defaultTableModel = (DefaultTableModel) tb_sanPham.getModel();
        defaultTableModel.setRowCount(0);
        for (TableSanPham sp : bhs.getListSP()) {
            defaultTableModel.addRow(new Object[]{
                row == -1 ? row += 2 : ++row, sp.getMa(), sp.getTen(), sp.getNamBH(), sp.getMoTa(), sp.getSoLuongTon(), sp.getGiaNhap(), sp.getGiaBan()
            });
        }
    }

    public void loadTableGioHang(){
    int row = tb_gioHang.getSelectedRow();
    defaultTableModel = (DefaultTableModel) tb_gioHang.getModel();
    defaultTableModel.setRowCount(0);
    for(TableGiohang gh: bhs.getListGioHang()){
    defaultTableModel.addRow(new Object[]{
    row == -1 ? row += 2 : ++row, gh.getMaSP(), gh.getTen(), gh.getSoLuongTon(), gh.getDonGia(), gh.getThanhTien()
    });
    }
    }
    public void loadTableHoaDon() {
        int row = tb_hoaDon.getSelectedRow();
        defaultTableModel = (DefaultTableModel) tb_hoaDon.getModel();
        defaultTableModel.setRowCount(0);
        for (HoaDon hd : hds.getList()) {
            defaultTableModel.addRow(new Object[]{
                row == -1 ? row += 2 : ++row, hd.getMa(), hd.getNgayTao(), "Anh Tuấn", hd.getTinhTrang() == 1 ? "Đã thanh toán" : "Chưa thanh toán"
            });
        }
    }

    public void trangThai() {
        buttonGroup.add(rd_huy);
        buttonGroup.add(rd_choThanhToan);
        buttonGroup.add(rd_choThanhToan);
        buttonGroup.add(rd_all);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bt_taoHoaDon = new javax.swing.JButton();
        rd_all = new javax.swing.JRadioButton();
        rd_choThanhToan = new javax.swing.JRadioButton();
        rd_huy = new javax.swing.JRadioButton();
        rd_daThanhToan = new javax.swing.JRadioButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_maHD = new javax.swing.JTextField();
        txt_tongTien = new javax.swing.JTextField();
        txt_tienKhachDua = new javax.swing.JTextField();
        txt_tienThua = new javax.swing.JTextField();
        txt_ngayTao = new javax.swing.JTextField();
        txt_tenNV = new javax.swing.JTextField();
        bt_thanhToan = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_hoaDon = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_sanPham = new javax.swing.JTable();
        txt_search = new javax.swing.JTextField();
        bt_search = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tb_gioHang = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bán hàng");

        bt_taoHoaDon.setText("Tạo hóa đơn");
        bt_taoHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_taoHoaDonActionPerformed(evt);
            }
        });

        rd_all.setText("Tất cả");
        rd_all.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rd_allMouseClicked(evt);
            }
        });

        rd_choThanhToan.setText("Chờ thanh toán");
        rd_choThanhToan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rd_choThanhToanMouseClicked(evt);
            }
        });

        rd_huy.setText("Đã hủy");
        rd_huy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rd_huyMouseClicked(evt);
            }
        });

        rd_daThanhToan.setText("Đã thanh toán");
        rd_daThanhToan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rd_daThanhToanMouseClicked(evt);
            }
        });

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setText("Mã HD");

        jLabel3.setText("Tên NV");

        jLabel4.setText("Ngày tạo");

        jLabel5.setText("Tổng tiền");

        jLabel6.setText("Tiền khách đưa");

        jLabel7.setText("Tiền thừa");

        txt_maHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_maHDActionPerformed(evt);
            }
        });

        txt_tongTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tongTienActionPerformed(evt);
            }
        });

        txt_tienKhachDua.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_tienKhachDuaCaretUpdate(evt);
            }
        });
        txt_tienKhachDua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tienKhachDuaActionPerformed(evt);
            }
        });

        txt_tienThua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tienThuaActionPerformed(evt);
            }
        });

        txt_ngayTao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ngayTaoActionPerformed(evt);
            }
        });

        txt_tenNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tenNVActionPerformed(evt);
            }
        });

        bt_thanhToan.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bt_thanhToan.setText("THANH TOÁN");
        bt_thanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_thanhToanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(66, 66, 66)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_ngayTao, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_tenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_tongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_tienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_tienThua, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_maHD, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bt_thanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_maHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_ngayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_tenNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_tongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(txt_tienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_tienThua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addComponent(bt_thanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Hóa đơn");

        tb_hoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã HĐ", "Ngày Tạo", "Tên NV", "Tình trạng"
            }
        ));
        tb_hoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_hoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_hoaDon);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Giỏ hàng");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Sản phẩm");

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tb_sanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã Sp", "Tên SP", "Năm bán", "Mô tả", "SL SP tồn", "Giá nhập", "Giá bán"
            }
        ));
        tb_sanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_sanPhamMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tb_sanPham);

        txt_search.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_searchCaretUpdate(evt);
            }
        });
        txt_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_searchActionPerformed(evt);
            }
        });

        bt_search.setText("Search");
        bt_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_searchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(bt_search)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 701, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_search, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(bt_search))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tb_gioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã Sp", "Tên SP", "Số lượng", "Đơn giá", "Thành tiền"
            }
        ));
        tb_gioHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_gioHangMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tb_gioHang);
        if (tb_gioHang.getColumnModel().getColumnCount() > 0) {
            tb_gioHang.getColumnModel().getColumn(3).setHeaderValue("Số lượng");
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bt_taoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rd_choThanhToan)
                                .addGap(35, 35, 35)
                                .addComponent(rd_all)
                                .addGap(27, 27, 27)
                                .addComponent(rd_huy)
                                .addGap(45, 45, 45)
                                .addComponent(rd_daThanhToan))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(bt_taoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(rd_choThanhToan)
                                    .addComponent(rd_all)
                                    .addComponent(rd_huy)
                                    .addComponent(rd_daThanhToan))
                                .addGap(33, 33, 33)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_maHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_maHDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_maHDActionPerformed

    private void txt_tongTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tongTienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tongTienActionPerformed

    private void txt_tienKhachDuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tienKhachDuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tienKhachDuaActionPerformed

    private void txt_tienThuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tienThuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tienThuaActionPerformed

    private void txt_ngayTaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ngayTaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ngayTaoActionPerformed

    private void txt_tenNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tenNVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tenNVActionPerformed

    private void txt_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_searchActionPerformed

    private void tb_sanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_sanPhamMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tb_sanPhamMouseClicked

    private void tb_gioHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_gioHangMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tb_gioHangMouseClicked

    private void txt_searchCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_searchCaretUpdate
        String text = txt_search.getText();
        if (!bhs.searchSPByMa(text).isEmpty()) {
            searchByMa();
            return;
        } else {
            loadTableSP();
        }
        if (!bhs.searchSPByTen(text).isEmpty()) {
            searchByTen();
            return;
        } else {
            loadTableSP();
        }
    }//GEN-LAST:event_txt_searchCaretUpdate

    private void bt_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_searchActionPerformed

    }//GEN-LAST:event_bt_searchActionPerformed

    private void bt_thanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_thanhToanActionPerformed
       
    }//GEN-LAST:event_bt_thanhToanActionPerformed

    private void txt_tienKhachDuaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_tienKhachDuaCaretUpdate
        try {
            int tongTien = Integer.parseInt(txt_tongTien.getText());
            int tienKhachDua = Integer.parseInt(txt_tienKhachDua.getText());
            if (String.valueOf(tienKhachDua).equals("")) {
                txt_tongTien.setText("");
            }
            String tienThua = String.valueOf(tienKhachDua - tongTien);
            txt_tienThua.setText(tienThua);
        } catch (NumberFormatException e) {
        }
    }//GEN-LAST:event_txt_tienKhachDuaCaretUpdate

    private void bt_taoHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_taoHoaDonActionPerformed
        Random random = new Random();
        long millis = System.currentTimeMillis();
        String ma = "hd" + random.nextInt(1000);
        HoaDon hd = new HoaDon();
        hd.setMa(ma);
        hd.setTinhTrang(0);
        hd.setNgayTao(new Date(millis));
        bhs.insert(hd);
        loadTableHoaDon();
        defaultTableModel = (DefaultTableModel) tb_gioHang.getModel();
        defaultTableModel.setRowCount(0);
    }//GEN-LAST:event_bt_taoHoaDonActionPerformed

    private void rd_choThanhToanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rd_choThanhToanMouseClicked
        defaultTableModel = (DefaultTableModel) tb_hoaDon.getModel();
        defaultTableModel.setRowCount(0);
        int row = tb_hoaDon.getSelectedRow();
        for(HoaDon hd: hds.getList()){
            if(hd.getTinhTrang() == 0){
                defaultTableModel.addRow(new Object[]{
                    row == -1 ? row += 2 : ++row, hd.getMa(), hd.getNgayTao(), "Thành Đạt", hd.getTinhTrang() == 1 ? "Đã thanh toán" : "Chưa thanh toán"
                });
            }
        }
    }//GEN-LAST:event_rd_choThanhToanMouseClicked

    private void rd_allMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rd_allMouseClicked
        loadTableHoaDon();
    }//GEN-LAST:event_rd_allMouseClicked

    private void rd_huyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rd_huyMouseClicked
        defaultTableModel = (DefaultTableModel) tb_hoaDon.getModel();
        defaultTableModel.setRowCount(0);
        int row = tb_hoaDon.getSelectedRow();
        for(HoaDon hd: hds.getList()){
            if(hd.getTinhTrang() == 2){
                defaultTableModel.addRow(new Object[]{
                    row == -1 ? row += 2 : ++row, hd.getMa(), hd.getNgayTao(), "Thành Đạt", hd.getTinhTrang() == 1 ? "Đã thanh toán" : "Chưa thanh toán"
                });
            }
        }
    }//GEN-LAST:event_rd_huyMouseClicked

    private void rd_daThanhToanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rd_daThanhToanMouseClicked
        defaultTableModel = (DefaultTableModel) tb_hoaDon.getModel();
        defaultTableModel.setRowCount(0);
        int row = tb_hoaDon.getSelectedRow();
        for(HoaDon hd: hds.getList()){
            if(hd.getTinhTrang() == 1){
                defaultTableModel.addRow(new Object[]{
                    row == -1 ? row += 2 : ++row, hd.getMa(), hd.getNgayTao(), "Thành Đạt", hd.getTinhTrang() == 1 ? "Đã thanh toán" : "Chưa thanh toán"
                });
            }
        }
    }//GEN-LAST:event_rd_daThanhToanMouseClicked

    private void tb_hoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_hoaDonMouseClicked
        int row = tb_hoaDon.getSelectedRow();
        txt_maHD.setText(tb_hoaDon.getValueAt(row, 1).toString());
        txt_ngayTao.setText(tb_hoaDon.getValueAt(row, 2).toString());
        txt_tenNV.setText(tb_hoaDon.getValueAt(row, 3).toString());
    }//GEN-LAST:event_tb_hoaDonMouseClicked

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
            java.util.logging.Logger.getLogger(BanHangForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BanHangForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BanHangForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BanHangForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BanHangForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_search;
    private javax.swing.JButton bt_taoHoaDon;
    private javax.swing.JButton bt_thanhToan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JRadioButton rd_all;
    private javax.swing.JRadioButton rd_choThanhToan;
    private javax.swing.JRadioButton rd_daThanhToan;
    private javax.swing.JRadioButton rd_huy;
    private javax.swing.JTable tb_gioHang;
    private javax.swing.JTable tb_hoaDon;
    private javax.swing.JTable tb_sanPham;
    private javax.swing.JTextField txt_maHD;
    private javax.swing.JTextField txt_ngayTao;
    private javax.swing.JTextField txt_search;
    private javax.swing.JTextField txt_tenNV;
    private javax.swing.JTextField txt_tienKhachDua;
    private javax.swing.JTextField txt_tienThua;
    private javax.swing.JTextField txt_tongTien;
    // End of variables declaration//GEN-END:variables
}
