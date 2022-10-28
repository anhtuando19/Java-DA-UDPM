/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import Repository.Implement.DongSPInterface;
import JDBC.JDBCUtil;
import Model.DongSP;
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
public class DongSPRepo implements DongSPInterface{

    @Override
    public void insert(DongSP dsp) {
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "INSERT INTO DongSP" + " (Ma, Ten)" + " VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, dsp.getMa());
            ps.setString(2, dsp.getTen());
            ps.execute();
        } catch (Exception ex) {
            Logger.getLogger(DongSPRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(String id) {
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "DELETE FROM DongSp WHERE Id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(DongSPRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(String id, DongSP dsp) {
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "UPDATE DongSP SET Ma = ?, Ten = ? WHERE Id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, dsp.getMa());
            ps.setString(2, dsp.getTen());
            ps.setString(3, id);
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(DongSPRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<DongSP> all() {
        ArrayList<DongSP> listDSP = new ArrayList<>();
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "SELECT * FROM DongSP";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String id = rs.getString("Id");
                String ma = rs.getString("Ma");
                String ten = rs.getString("Ten");
                DongSP dsp = new DongSP(id, ma, ten);
                listDSP.add(dsp);
            }
        } catch (Exception ex) {
            Logger.getLogger(DongSPRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listDSP;
    }

    @Override
    public DongSP search(String ma) {
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "SELECT * FROM DongSP WHERE Ma = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            if (rs.next()) {
                String id = rs.getString("Id");
                String ten = rs.getString("Ten");
                DongSP dsp = new DongSP(id, ma, ten);
                return dsp;
            }
        } catch (Exception ex) {
            Logger.getLogger(DongSPRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
