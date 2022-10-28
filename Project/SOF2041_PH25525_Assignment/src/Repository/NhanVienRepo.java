/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import Repository.Implement.NhanVienInterface;
import JDBC.JDBCUtil;
import Model.NhanVien;
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
public class NhanVienRepo implements NhanVienInterface{
    
    @Override
    public void insert(NhanVien nv){
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "INSERT INTO NhanVien" + " (Ma, Ten, TenDem, Ho, GioiTinh, NgaySinh, DiaChi, Sdt, MatKhau, TrangThai)"
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
            Logger.getLogger(NhanVienRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void delete(String ma){
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "DELETE FROM NhanVien WHERE Ma = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ma);
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(NhanVienRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void update(String ma, NhanVien nv){
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "UPDATE NhanVien SET Ma = ?, Ten = ?, TenDem = ?, Ho = ?, GioiTinh = ?, NgaySinh = ?, DiaChi = ?,"
                    + " Sdt = ?, MatKhau = ?, TrangThai = ? WHERE Id = ?";
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
            Logger.getLogger(NhanVienRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public ArrayList<NhanVien> all(){
        ArrayList<NhanVien> listNV = new ArrayList<>();
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "SELECT * FROM NhanVien";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while(rs.next()){
                String id = rs.getString("Id");
                String ma = rs.getString("Ma");
                String ten = rs.getString("Ten");
                String tenDem = rs.getString("TenDem");
                String ho = rs.getString("Ho");
                String gioiTinh = rs.getString("GioiTinh");
                Date ngaySinh = rs.getDate("NgaySinh");
                String diaChi = rs.getString("DiaChi");
                String sdt = rs.getString("Sdt");
                String matKhau = rs.getString("MatKhau");
                int trangThai = rs.getInt("TrangThai");
                NhanVien nv = new NhanVien(id, ma, ten, tenDem, ho, gioiTinh, ngaySinh, diaChi, sdt, matKhau, trangThai);
                listNV.add(nv);
            }
        } catch (Exception ex) {
            Logger.getLogger(NhanVienRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listNV;
    }
    
    @Override
    public NhanVien search(String Ma){
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "SELECT * FROM NhanVien WHERE Ma = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            if(rs.next()){
                String id = rs.getString("Id");
                String ten = rs.getString("Ten");
                String tenDem = rs.getString("TenDem");
                String ho = rs.getString("Ho");
                String gioiTinh = rs.getString("GioiTinh");
                Date ngaySinh = rs.getDate("NgaySinh");
                String diaChi = rs.getString("DiaChi");
                String sdt = rs.getString("Sdt");
                String matKhau = rs.getString("MatKhau");
                int trangThai = rs.getInt("TrangThai");
                NhanVien nv = new NhanVien(id, Ma, ten, tenDem, ho, gioiTinh, ngaySinh, diaChi, sdt, matKhau, trangThai);
                return nv;
            }
        } catch (Exception ex) {
            Logger.getLogger(NhanVienRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
