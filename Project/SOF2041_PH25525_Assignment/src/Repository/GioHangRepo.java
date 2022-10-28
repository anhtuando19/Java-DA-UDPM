/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import Repository.Implement.GioHangInterface;
import JDBC.JDBCUtil;
import Model.GioHang;
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
public class GioHangRepo implements GioHangInterface{

    @Override
    public void insert(GioHang gh) {
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "INSERT INTO GioHang" + "(Ma, NgayTao, NgayThanhToan, TenNguoiNhan, DiaChi, Sdt, TinhTrang)"
                    + "VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, gh.getMa());
            ps.setDate(2, gh.getNgayTao());
            ps.setDate(3, gh.getNgayThanhToan());
            ps.setString(4, gh.getTenNguoiNhan());
            ps.setString(5, gh.getDiaChi());
            ps.setString(6, gh.getSdt());
            ps.setInt(7, gh.getTinhTrang());
            ps.execute();
        } catch (Exception ex) {
            Logger.getLogger(GioHangRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(String ma) {
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "DELETE FROM GioHang WHERE Ma = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ma);
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(GioHangRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(String id, GioHang gh) {
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "UPDATE GioHang SET Ma = ?, NgayTao = ?, NgayThanhToan = ?, TenNguoiNhan = ?,"
                    + " DiaChi = ?, Sdt = ?, TinhTrang = ? WHERE Id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, gh.getMa());
            ps.setDate(2, gh.getNgayTao());
            ps.setDate(3, gh.getNgayThanhToan());
            ps.setString(4, gh.getTenNguoiNhan());
            ps.setString(5, gh.getDiaChi());
            ps.setString(6, gh.getSdt());
            ps.setInt(7, gh.getTinhTrang());
            ps.setString(8, id);
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(GioHangRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<GioHang> all() {
        ArrayList<GioHang> listGH = new ArrayList<>();
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "SELECT * FROM GioHang";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {                
                String id = rs.getString("Id");
                String ma = rs.getString("Ma");
                Date ngayTao = rs.getDate("NgayTao");
                Date ngayThanhToan = rs.getDate("NgayThanhToan");
                String tenNguoiNhan = rs.getString("TenNguoiNhan");
                String diaChi = rs.getString("DiaChi");
                String sdt = rs.getString("Sdt");
                int tinhTrang = rs.getInt("TinhTrang");
                GioHang gh = new GioHang(id, ma, ngayTao, ngayThanhToan, tenNguoiNhan, diaChi, sdt, tinhTrang);
                listGH.add(gh);
            }
        } catch (Exception ex) {
            Logger.getLogger(GioHangRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listGH;
    }
    
    @Override
    public GioHang search(String ma){
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "SELECT * FROM GioHang WHERE Ma = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            if(rs.next()){
                String id = rs.getString("Id");
                Date ngayTao = rs.getDate("NgayTao");
                Date ngayThanhToan = rs.getDate("NgayThanhToan");
                String tenNguoiNhan = rs.getString("TenNguoiNhan");
                String diaChi = rs.getString("DiaChi");
                String sdt = rs.getString("Sdt");
                int tinhTrang = rs.getInt("TinhTrang");
                GioHang gh = new GioHang(id, ma, ngayTao, ngayThanhToan, tenNguoiNhan, diaChi, sdt, tinhTrang);
                return gh;
            }
        } catch (Exception ex) {
            Logger.getLogger(GioHangRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
