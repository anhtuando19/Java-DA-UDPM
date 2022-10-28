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
import model.NhanVien;

/**
 *
 * @author Admin
 */
public class NhanVienRepository {

    public ArrayList<NhanVien> getList() {
        ArrayList<NhanVien> list = new ArrayList<>();
        try {
            Connection conn = DBContext.getConnection();
            String sql = "select * from NhanVien";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String ma = rs.getString("Ma");
                String ten = rs.getString("Ten");
                String tenDem = rs.getString("TenDem");
                String ho = rs.getString("Ho");
                String gt = rs.getString("GioiTinh");
                Date ngaySinh = rs.getDate("NgaySinh");
                String dc = rs.getString("DiaChi");
                String sdt = rs.getString("Sdt");
                String mk = rs.getString("MatKhau");
                int tt = rs.getInt("TrangThai");
                NhanVien nv = new NhanVien(ma, ten, tenDem, ho, gt, ngaySinh, dc, sdt, mk, tt);
                list.add(nv);
            }
        } catch (Exception ex) {
            Logger.getLogger(NhanVienRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void insert(NhanVien nv) {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "insert into NhanVien "
                    + "(Ma, Ten, TenDem, Ho, GioiTinh, NgaySinh, DiaChi, Sdt, MatKhau, TrangThai)"
                    + "values (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nv.getMa());
            ps.setString(2, nv.getTen());
            ps.setString(3, nv.getTenDem());
            ps.setString(4, nv.getHo());
            ps.setString(5, nv.getGioiTinh());
            ps.setString(7, nv.getDiaChi());
            ps.setString(8, nv.getSdt());
            ps.setString(9, nv.getMatKhau());
            ps.setInt(10, nv.getTrangThai());
            ps.setDate(6, nv.getNgaySinh());
            ps.execute();
        } catch (Exception ex) {
            Logger.getLogger(NhanVienRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(NhanVien nv, String ma) {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "update NhanVien set Ma =?, Ten=?, TenDem=?, Ho=?, GioiTinh=?, NgaySinh=?, DiaChi=?, Sdt=?, MatKhau=?, TrangThai=? where Ma = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nv.getMa());
            ps.setString(2, nv.getTen());
            ps.setString(3, nv.getTenDem());
            ps.setString(4, nv.getHo());
            ps.setString(5, nv.getGioiTinh());
            ps.setDate(6, new java.sql.Date(nv.getNgaySinh().getTime()));
            ps.setString(7, nv.getDiaChi());
            ps.setString(8, nv.getSdt());
            ps.setString(9, nv.getMatKhau());
            ps.setInt(10, nv.getTrangThai());
            ps.setString(11, ma);
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(NhanVienRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(String ma) {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "delete from NhanVien where Ma = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ma);
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(NhanVienRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
