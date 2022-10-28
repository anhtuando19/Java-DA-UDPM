/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import JDBC.JDBCUtil;
import Model.HoaDon;
import Repository.Implement.BanHangInterface;
import ViewModel.TableGiohang;
import ViewModel.TableSanPham;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class BanHangRepo implements BanHangInterface{
    
    @Override
    public ArrayList<TableSanPham> getListSP(){
        ArrayList<TableSanPham> listSP = new ArrayList<>();
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "SELECT * FROM SanPham sp JOIN ChiTietSP ctsp ON sp.Id = ctsp.IdSP";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {                
                String ma = rs.getString("Ma");
                String ten = rs.getString("Ten");
                int namBH = rs.getInt("NamBH");
                String moTa = rs.getString("MoTa");
                int soLuongTon = rs.getInt("SoLuongTon");
                double giaNhap = rs.getDouble("GiaNhap");
                double giaBan = rs.getDouble("GiaBan");
                TableSanPham tsp = new TableSanPham(ma, ten, namBH, moTa, soLuongTon, giaNhap, giaBan);
                listSP.add(tsp);
            }
        } catch (Exception ex) {
            Logger.getLogger(BanHangRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listSP;
    }
    
    @Override
    public ArrayList<TableSanPham> searchSPByMa(String ma){
        ArrayList<TableSanPham> listSP = new ArrayList<>();
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "SELECT * FROM SanPham sp JOIN ChiTietSP ctsp ON sp.Id = ctsp.IdSP WHERE Ma = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ma);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {                
                String maSP = rs.getString("Ma");
                String tenSP = rs.getString("Ten");
                int namBH = rs.getInt("NamBH");
                String moTa = rs.getString("MoTa");
                int soLuongTon = rs.getInt("SoLuongTon");
                double giaNhap = rs.getDouble("GiaNhap");
                double giaBan = rs.getDouble("GiaBan");
                TableSanPham tsp = new TableSanPham(maSP, tenSP, namBH, moTa, soLuongTon, giaNhap, giaBan);
                listSP.add(tsp);
            }
        } catch (Exception ex) {
            Logger.getLogger(BanHangRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listSP;
    }
    
    @Override
    public ArrayList<TableSanPham> searchSPByTen(String ten){
        ArrayList<TableSanPham> listSP = new ArrayList<>();
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "SELECT * FROM SanPham sp JOIN ChiTietSP ctsp ON sp.Id = ctsp.IdSP WHERE Ten = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ten);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {                
                String maSP = rs.getString("Ma");
                String tenSP = rs.getString("Ten");
                int namBH = rs.getInt("NamBH");
                String moTa = rs.getString("MoTa");
                int soLuongTon = rs.getInt("SoLuongTon");
                double giaNhap = rs.getDouble("GiaNhap");
                double giaBan = rs.getDouble("GiaBan");
                TableSanPham tsp = new TableSanPham(maSP, tenSP, namBH, moTa, soLuongTon, giaNhap, giaBan);
                listSP.add(tsp);
            }
        } catch (Exception ex) {
            Logger.getLogger(BanHangRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listSP;
    }
    
    @Override
    public void saveHD(HoaDon hd){
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "INSERT INTO HoaDon" + "(Ma, NgayTao, TinhTrang)" + " VALUES(?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, hd.getMa());
            ps.setDate(2, hd.getNgayTao());
            ps.setInt(3, hd.getTinhTrang());
            ps.execute();
        } catch (Exception ex) {
            Logger.getLogger(BanHangRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public ArrayList<TableGiohang> getListGioHang(){
        ArrayList<TableGiohang> list = new ArrayList<>();
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "SELECT sp.Ma as 'MaSp', Ten, SoLuongTon, GiaBan FROM SanPham sp JOIN ChiTietSP ctsp ON sp.Id = ctsp.IdSP\n"
                  + "JOIN HoaDonChiTiet hdct ON hdct.IdChiTietSP = ctsp.Id\n"  
                  + "JOIN HoaDon hd ON hd.Id = hdct.IdHoaDon";  
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {                
                String ma = rs.getString("MaSP");
                String ten = rs.getString("Ten");
                int soLuongTon = rs.getInt("SoLuongTon");
                double donGia = rs.getDouble("GiaBan");
                TableGiohang tbgh = new TableGiohang(ma, ten, soLuongTon, donGia, soLuongTon * donGia);
            }
        } catch (Exception ex) {
            Logger.getLogger(BanHangRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
