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
import model.KhachHang;

/**
 *
 * @author Admin
 */
public class KhachHangRepository {

    public ArrayList<KhachHang> getList() {
        ArrayList<KhachHang> list = new ArrayList<>();
        try {
            Connection conn = DBContext.getConnection();
            String sql = "select * from KhachHang";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String ma = rs.getString("Ma");
                String ten = rs.getString("Ten");
                String tendem = rs.getString("TenDem");
                String ho = rs.getString("Ho");
                String sdt = rs.getString("Sdt");
                String dc = rs.getString("DiaChi");
                String tp = rs.getString("ThanhPho");
                String qg = rs.getString("QuocGia");
                String mk = rs.getString("MatKhau");
                Date ns = rs.getDate("NgaySinh");
                KhachHang kh = new KhachHang(ma, ten, tendem, ho, ns, sdt, dc, tp, qg, mk);
                list.add(kh);
            }
        } catch (Exception ex) {
            Logger.getLogger(KhachHangRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void insert(KhachHang kh) {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "insert into KhachHang "
                    + "(Ma, Ten, TenDem, Ho, NgaySinh, Sdt, DiaChi, ThanhPho, QuocGia, MatKhau)"
                    + "values (?,?,?,?,?,?,?,?,?,?)";
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
            Logger.getLogger(NhanVienRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(KhachHang kh, String ma) {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "update KhachHang set Ma = ?, Ten= ?, TenDem = ?, Ho = ?, NgaySinh = ?, Sdt = ?, DiaChi = ?, ThanhPho = ?, QuocGia = ?, MatKhau = ? where Ma = ?";
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
            ps.setString(11, ma);
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(NhanVienRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(String ma) {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "delete from KhachHang where Ma = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ma);
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(NhanVienRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
