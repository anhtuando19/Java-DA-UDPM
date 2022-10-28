/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import Repository.Implement.HoaDonInterface;
import JDBC.JDBCUtil;
import Model.HoaDon;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class HoaDonRepo implements HoaDonInterface {

    @Override
    public void insert(HoaDon hd) {
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "INSERT INTO HoaDon" + "(Ma, NgayTao, NgayThanhToan, NgayShip, NgayNhan, TinhTrang, TenNguoiNhan, DiaChi, Sdt)"
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
            Logger.getLogger(HoaDonRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(String ma) {
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "DELETE FROM HoaDon WHERE Ma = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ma);
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(HoaDonRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(String id, HoaDon hd) {
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "UPDATE HoaDon SET Ma = ?, NgayTao = ?, NgayThanhToan = ?, NgayShip = ?, NgayNhan = ?"
                    + ", TinhTrang = ?, TenNguoiNhan = ?, DiaChi = ?, Sdt = ? WHERE Id = ?";
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
            ps.setString(10, id);
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(HoaDonRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<HoaDon> all() {
        ArrayList<HoaDon> listHD = new ArrayList<>();
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "Select * from HoaDon";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String id = rs.getString("Id");
                String ma = rs.getString("Ma");
                Date ngayTao = rs.getDate("NgayTao");
                Date ngayThanhToan = rs.getDate("NgayThanhToan");
                Date ngayShip = rs.getDate("NgayShip");
                Date ngayNhan = rs.getDate("NgayNhan");
                int tinhTrang = rs.getInt("TinhTrang");
                String tenNguoiNhan = rs.getString("TenNguoiNhan");
                String diaChi = rs.getString("DiaChi");
                String sdt = rs.getString("Sdt");
                HoaDon hd = new HoaDon(id, ma, ngayTao, ngayThanhToan, ngayShip, ngayNhan, tinhTrang, tenNguoiNhan, diaChi, sdt);
                listHD.add(hd);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return listHD;
    }

    @Override
    public HoaDon search(String ma) {
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "SELECT * FROM HoaDon WHERE Ma = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            if (rs.next()) {
                String id = rs.getString("Id");
                Date ngayTao = rs.getDate("NgayTao");
                Date ngayThanhToan = rs.getDate("NgayThanhToan");
                Date ngayShip = rs.getDate("NgayShip");
                Date ngayNhan = rs.getDate("NgayNhan");
                int tinhTrang = rs.getInt("TinhTrang");
                String tenNguoiNhan = rs.getString("TenNguoiNhan");
                String diaChi = rs.getString("DiaChi");
                String sdt = rs.getString("Sdt");
                HoaDon hd = new HoaDon(id, ma, ngayTao, ngayThanhToan, ngayShip, ngayNhan, tinhTrang, tenNguoiNhan, diaChi, sdt);
                return hd;
            }
        } catch (Exception ex) {
            Logger.getLogger(HoaDonRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
