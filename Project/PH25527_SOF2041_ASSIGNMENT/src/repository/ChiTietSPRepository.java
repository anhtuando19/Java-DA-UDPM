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
import viewmodel.ChiTietSpViewModel;

/**
 *
 * @author Admin
 */
public class ChiTietSPRepository{


    public ArrayList<ChiTietSpViewModel> getList() {
        ArrayList<ChiTietSpViewModel> list = new ArrayList<>();
        try {
            Connection conn = DBContext.getConnection();
            String sql = "select * from ChiTietSP";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {                
                String id = rs.getString("Id");
                String idSP = rs.getString("IdSP");
                int nambh = rs.getInt("NamBH");
                int slton = rs.getInt("SoLuongTon");
                String mota = rs.getString("MoTa");
                double gianhap = rs.getDouble("GiaNhap");
                double giaban = rs.getDouble("GiaBan");
                ChiTietSpViewModel ctsp = new ChiTietSpViewModel(id, nambh, mota, slton, gianhap, mota);
                list.add(ctsp);
            }
        } catch (Exception ex) {
            Logger.getLogger(ChiTietSPRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void insert(ChiTietSP ctsp) {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "insert into ChiTietSP (NamBH,MoTa,SoLuongTon,GiaNhap,GiaBan,IdSP) values(?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, ctsp.getNamBH());
            ps.setInt(3, ctsp.getSoLuongTon());
            ps.setString(2, ctsp.getMoTa());
            ps.setString(6, ctsp.getIdSP());
            ps.setDouble(4, ctsp.getGiaNhap());
            ps.setDouble(5, ctsp.getGiaBan());
            ps.execute();
        } catch (Exception ex) {
            Logger.getLogger(ChiTietSPRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public void update(ChiTietSP ctsp, String id) {
         try {
            Connection conn = DBContext.getConnection();
            String sql = "update ChiTietSP set NamBH = ?,MoTa = ?,SoLuongTon = ?,GiaNhap = ?,GiaBan = ? where ID = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, ctsp.getNamBH());
            ps.setInt(3, ctsp.getSoLuongTon());
            ps.setString(2, ctsp.getMoTa());
            ps.setDouble(4, ctsp.getGiaNhap());
            ps.setDouble(5, ctsp.getGiaBan());
            ps.setString(6, id);
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(ChiTietSPRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public void delete(String id) {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "delete from ChiTietSP where ID = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(ChiTietSPRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
