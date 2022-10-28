/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import Repository.Implement.KhachHangInterface;
import JDBC.JDBCUtil;
import Model.KhachHang;
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
public class KhachHangRepo implements KhachHangInterface{

    @Override
    public void insert(KhachHang kh) {
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "INSERT INTO KhachHang" + "(Ma, Ten, TenDem, Ho, NgaySinh, Sdt, DiaChi, ThanhPho, QuocGia, MatKhau)"
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, kh.getMa());
            ps.setString(2, kh.getTen());
            ps.setString(3, kh.getTenDem());
            ps.setString(4, kh.getHo());
            ps.setDate(5, kh.getNgaySinh());
            ps.setString(6, kh.getSdt());
            ps.setString(7, kh.getDiaChi());
            ps.setString(8, kh.getThanhPho());
            ps.setString(9, kh.getQuocGia());
            ps.setString(10, kh.getMatKhau());
            ps.execute();
        } catch (Exception ex) {
            Logger.getLogger(KhachHangRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(String Ma) {
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "DELETE FROM KhachHang WHERE Ma = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, Ma);
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(KhachHangRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(String Id, KhachHang kh) {
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "UPDATE KhachHang SET Ma = ?, Ten = ?, TenDem = ?, Ho = ?, NgaySinh = ?"
                    + ", Sdt = ?, DiaChi = ?, ThanhPho = ?, QuocGia = ?, MatKhau = ? WHERE Id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, kh.getMa());
            ps.setString(2, kh.getTen());
            ps.setString(3, kh.getTenDem());
            ps.setString(4, kh.getHo());
            ps.setDate(5, kh.getNgaySinh());
            ps.setString(6, kh.getSdt());
            ps.setString(7, kh.getDiaChi());
            ps.setString(8, kh.getThanhPho());
            ps.setString(9, kh.getQuocGia());
            ps.setString(10, kh.getMatKhau());
            ps.setString(11, Id);
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(KhachHangRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<KhachHang> all() {
        ArrayList<KhachHang> listKH = new ArrayList<>();
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "SELECT * FROM KhachHang";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String id = rs.getString("Id");
                String ma = rs.getString("Ma");
                String ten = rs.getString("Ten");
                String tenDem = rs.getString("tenDem");
                String ho = rs.getString("Ho");
                Date ngaySinh = rs.getDate("NgaySinh");
                String sdt = rs.getString("Sdt");
                String diaChi = rs.getString("DiaChi");
                String thanhPho = rs.getString("ThanhPho");
                String quocGia = rs.getString("QuocGia");
                String matKhau = rs.getString("MatKhau");
                KhachHang kh = new KhachHang(id, ma, ten, tenDem, ho, ngaySinh, sdt, diaChi, thanhPho, quocGia, matKhau);
                listKH.add(kh);
            }
        } catch (Exception ex) {
            Logger.getLogger(KhachHangRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listKH;
    }

    @Override
    public KhachHang search(String ma) {
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "SELECT * FROM KhachHang WHERE Ma = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            if (rs.next()) {
                String id = rs.getString("Id");
                String ten = rs.getString("Ten");
                String tenDem = rs.getString("tenDem");
                String ho = rs.getString("Ho");
                Date ngaySinh = rs.getDate("NgaySinh");
                String sdt = rs.getString("Sdt");
                String diaChi = rs.getString("DiaChi");
                String thanhPho = rs.getString("ThanhPho");
                String quocGia = rs.getString("QuocGia");
                String matKhau = rs.getString("MatKhau");
                KhachHang kh = new KhachHang(id, ma, ten, tenDem, ho, ngaySinh, sdt, diaChi, thanhPho, quocGia, matKhau);
                return kh;
            }
        } catch (Exception ex) {
            Logger.getLogger(KhachHangRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
