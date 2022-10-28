/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.HoaDon;

/**
 *
 * @author Admin
 */
public class HoaDonRepository {

    public ArrayList<HoaDon> getList() {
        ArrayList<HoaDon> list = new ArrayList<>();
        try {
            Connection conn = DBContext.getConnection();
            String sql = "select * from HoaDon";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String ma = rs.getString("Ma");
                Date ngayTao = rs.getDate("NgayTao");
                Date ngayThanhToan = rs.getDate("NgayThanhToan");
                Date ngayShip = rs.getDate("NgayShip");
                Date ngayNhan = rs.getDate("NgayNhan");
                int tt = rs.getInt("TinhTrang");
                String tenNguoiNhan = rs.getString("TenNguoiNhan");
                String dc = rs.getString("DiaChi");
                String sdt = rs.getString("Sdt");
                HoaDon hd = new HoaDon(ma, ngayTao, ngayThanhToan, ngayShip, ngayNhan, tt, tenNguoiNhan, dc, sdt);
                list.add(hd);
            }
        } catch (Exception ex) {
            Logger.getLogger(HoaDonRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void insert(HoaDon hd) {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "insert into HoaDon (Ma,NgayTao,NgayThanhToan,NgayShip,NgayNhan,TinhTrang,TenNguoiNhan,DiaChi,Sdt)"
                    + "values(?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, hd.getMa());
            ps.setDate(2, hd.getNgayTao());
            ps.setDate(3, hd.getNgayThanhToan());
            ps.setDate(4, hd.getNgayShip());
            ps.setDate(5, hd.getNgayNhan());
            ps.setInt(6, hd.getTinhTrang());
            ps.setString(7, hd.getTenNguoiNhan());
            ps.setString(8, hd.getDiaChi());
            ps.setString(9, hd.getSdt());
            ps.execute();
        } catch (Exception ex) {
            Logger.getLogger(HoaDonRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(HoaDon hd, String ma) {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "update HoaDon set Ma = ?,NgayTao = ?,NgayThanhToan = ?,NgayShip = ?,NgayNhan = ?,TinhTrang = ?,TenNguoiNhan = ?,DiaChi = ?,Sdt = ? where Ma = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, hd.getMa());
            ps.setDate(2, hd.getNgayTao());
            ps.setDate(3, hd.getNgayThanhToan());
            ps.setDate(4, hd.getNgayShip());
            ps.setDate(5, hd.getNgayNhan());
            ps.setInt(6, hd.getTinhTrang());
            ps.setString(7, hd.getTenNguoiNhan());
            ps.setString(8, hd.getDiaChi());
            ps.setString(9, hd.getSdt());
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(HoaDonRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(String ma) {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "delete from HoaDon where Ma = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ma);
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(HoaDonRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
