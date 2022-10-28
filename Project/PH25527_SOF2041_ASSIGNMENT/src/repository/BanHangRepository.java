/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ChiTietSP;
import model.SanPham;
import viewmodel.TBSanPham;
/**
 *
 * @author Admin
 */
public class BanHangRepository {
    
    public ArrayList<TBSanPham> getListSP(){
        ArrayList<TBSanPham> listsp = new ArrayList<>();
        try {
            Connection conn = DBContext.getConnection();
            String sql = "select * from SanPham join ChiTietSP on SanPham.Id = ChiTietSP.IdSP";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {                
                String ma = rs.getString("Ma");
                String ten = rs.getString("Ten");
                String mota = rs.getString("MoTa");
                int namnh = rs.getInt("NamBH");
                int slton = rs.getInt("SoLuongTon");
                double gianhap = rs.getDouble("GiaNhap");
                double giaban = rs.getDouble("GiaBan");
                TBSanPham tbsp = new TBSanPham(ma, ten, namnh, mota, slton, gianhap, giaban);
                listsp.add(tbsp);
            }
        } catch (Exception ex) {
            Logger.getLogger(BanHangRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listsp;
    }
    
    
    public ArrayList<TBSanPham> getListSPTimKiemTheoMa(String ma){
        ArrayList<TBSanPham> listsp = new ArrayList<>();
        try {
            Connection conn = DBContext.getConnection();
            String sql = "select * from SanPham join ChiTietSP on SanPham.Id = ChiTietSP.IdSP where Ma = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ma);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {                
                String masp = rs.getString("Ma");
                String tensp = rs.getString("Ten");
                String mota = rs.getString("MoTa");
                int namnh = rs.getInt("NamBH");
                int slton = rs.getInt("SoLuongTon");
                double gianhap = rs.getDouble("GiaNhap");
                double giaban = rs.getDouble("GiaBan");
                TBSanPham tbsp = new TBSanPham(masp, tensp, namnh, mota, slton, gianhap, giaban);
                listsp.add(tbsp);
            }
        } catch (Exception ex) {
            Logger.getLogger(BanHangRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listsp;
    }
    public ArrayList<TBSanPham> getListSPTimKiemTheoTen(String ten){
        ArrayList<TBSanPham> listsp = new ArrayList<>();
        try {
            Connection conn = DBContext.getConnection();
            String sql = "select * from SanPham join ChiTietSP on SanPham.Id = ChiTietSP.IdSP where Ten = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ten);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {                
                String masp = rs.getString("Ma");
                String tensp = rs.getString("Ten");
                String mota = rs.getString("MoTa");
                int namnh = rs.getInt("NamBH");
                int slton = rs.getInt("SoLuongTon");
                double gianhap = rs.getDouble("GiaNhap");
                double giaban = rs.getDouble("GiaBan");
                TBSanPham tbsp = new TBSanPham(masp, tensp, namnh, mota, slton, gianhap, giaban);
                listsp.add(tbsp);
            }
        } catch (Exception ex) {
            Logger.getLogger(BanHangRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listsp;
    }
    
    
}
