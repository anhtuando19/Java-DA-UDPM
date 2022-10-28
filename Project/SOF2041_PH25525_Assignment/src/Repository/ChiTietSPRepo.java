/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import Repository.Implement.ChiTietSPInterface;
import JDBC.JDBCUtil;
import Model.ChiTietSP;
import Model.SanPham;
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
public class ChiTietSPRepo implements ChiTietSPInterface {

    @Override
    public void insert(ChiTietSP ctsp) {
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "INSERT INTO ChiTietSP " + "(IdSP, NamBH, MoTa, SoLuongTon, GiaNhap, GiaBan)"
                    + " VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            String idSP = null;
            if (ctsp.getIdSP() != null) {
                idSP = ctsp.getIdSP().getId();
            }
            ps.setString(1, idSP);
            ps.setInt(2, ctsp.getNamBH());
            ps.setString(3, ctsp.getMoTa());
            ps.setInt(4, ctsp.getSoLuongTon());
            ps.setDouble(5, ctsp.getGiaNhap());
            ps.setDouble(6, ctsp.getGiaBan());
            ps.execute();
        } catch (Exception ex) {
            Logger.getLogger(ChiTietSPRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(String id, String idSP) {
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "DELETE FROM ChiTietSP WHERE Id = ? AND IdSP = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, idSP);
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(ChiTietSPRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(String id, String idSP, ChiTietSP ctsp) {
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "UPDATE ChiTietSP SET NamBH = ?, MoTa = ?, SoLuongTon = ?, GiaNhap = ?, GiaBan = ? WHERE Id = ? AND IdSP = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, ctsp.getNamBH());
            ps.setString(2, ctsp.getMoTa());
            ps.setInt(3, ctsp.getSoLuongTon());
            ps.setDouble(4, ctsp.getGiaNhap());
            ps.setDouble(5, ctsp.getGiaBan());
            ps.setString(6, id);
            ps.setString(7, idSP);
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(ChiTietSPRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<ChiTietSP> all() {
        ArrayList<ChiTietSP> listCTSP = new ArrayList<>();
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "SELECT ctsp.Id, sp.Id, ctsp.NamBH, ctsp.MoTa, ctsp.SoLuongTon, ctsp.GiaNhap, ctsp.GiaBan FROM ChiTietSP ctsp JOIN SanPham sp ON ctsp.IdSP = sp.Id";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String id = rs.getString(1);
                String idSP = rs.getString(2);
                int namBH = rs.getInt(3);
                String moTa = rs.getString(4);
                int soLuongTon = rs.getInt(5);
                double giaNhap = rs.getDouble(6);
                double giaBan = rs.getDouble(7);
                
                SanPham sp = new SanPham();
                sp.setId(idSP);
                ChiTietSP ctsp = new ChiTietSP(id, sp, namBH, moTa, soLuongTon, giaNhap, giaBan);
                listCTSP.add(ctsp);
            }
        } catch (Exception ex) {
            Logger.getLogger(ChiTietSPRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listCTSP;
    }
}
