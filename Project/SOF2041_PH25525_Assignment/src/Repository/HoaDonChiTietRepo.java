/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import Repository.Implement.HoaDonChiTietInterface;
import JDBC.JDBCUtil;
import Model.ChiTietSP;
import Model.HoaDon;
import Model.HoaDonChiTiet;
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
public class HoaDonChiTietRepo implements HoaDonChiTietInterface{
    
    @Override
    public void insert(HoaDonChiTiet hdct){
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "INSERT INTO HoaDonChiTiet " + "(IdHoaDon, IdChiTietSP, SoLuong, DonGia)" + " VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            String idHD = null;
            if(hdct.getHd() != null){
                idHD = hdct.getHd().getId();
            }
            String idCTSP = null;
            if(hdct.getCtsp() != null){
                idCTSP = hdct.getCtsp().getId();
            }
            ps.setString(1, idHD);
            ps.setString(2, idCTSP);
            ps.setInt(3, hdct.getSoLuong());
            ps.setDouble(4, hdct.getDonGia());
            ps.execute();
        } catch (Exception ex) {
            Logger.getLogger(HoaDonChiTietRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void delete(String idHD, String idCTSP){
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "DELETE FROM HoaDonChiTiet WHERE IdHoaDon = ? AND IdChiTietSP = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, idHD);
            ps.setString(2, idCTSP);
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(HoaDonChiTietRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void update(String idHD, String idCTSP, HoaDonChiTiet hdct){
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "UPDATE HoaDonChiTiet SET SoLuong = ?, DonGia = ? WHERE IdHoaDon = ? AND IdChiTietSP = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, hdct.getSoLuong());
            ps.setDouble(2, hdct.getDonGia());
            ps.setString(3, idHD);
            ps.setString(4, idCTSP);
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(HoaDonChiTietRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public ArrayList<HoaDonChiTiet> all(){
        ArrayList<HoaDonChiTiet> listHDCT = new ArrayList<>();
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "SELECT hd.Id, ctsp.Id, hdct.SoLuong, hdct.DonGia FROM HoaDonChiTiet hdct JOIN HoaDon hd ON hdct.IdHoaDon = hd.Id\n"
                    + "JOIN ChiTietSP ctsp ON ctsp.Id = hdct.IdChiTietSP";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {                
                String idHoaDon = rs.getString(1);
                String idChiTietSP = rs.getString(2);
                int soLuong = rs.getInt(3);
                double donGia = rs.getDouble(4);
                HoaDon hd = new HoaDon();
                hd.setId(idHoaDon);
                ChiTietSP ctsp = new ChiTietSP();
                ctsp.setId(idChiTietSP);
                HoaDonChiTiet hdct = new HoaDonChiTiet(hd, ctsp, soLuong, donGia);
                listHDCT.add(hdct);
            }
        } catch (Exception ex) {
            Logger.getLogger(HoaDonChiTietRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listHDCT;
    }
    
}
