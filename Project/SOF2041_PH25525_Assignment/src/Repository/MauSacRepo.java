/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import Repository.Implement.MauSacInterface;
import JDBC.JDBCUtil;
import Model.MauSac;
import Service.MauSacService;
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
public class MauSacRepo implements MauSacInterface{

    @Override
    public void insert(MauSac ms) {
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "INSERT INTO MauSac" + " (Ma, Ten)" + " VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ms.getMa());
            ps.setString(2, ms.getTen());
            ps.execute();
        } catch (Exception ex) {
            Logger.getLogger(MauSacService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(String id) {
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "DELETE FROM MauSac WHERE Id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(MauSacRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(String id, MauSac ms) {
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "UPDATE MauSac SET Ma = ?, Ten = ? WHERE Id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ms.getMa());
            ps.setString(2, ms.getTen());
            ps.setString(3, ms.getId());
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(MauSacRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<MauSac> all() {
        ArrayList<MauSac> listMS = new ArrayList<>();
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "SELECT * FROM MauSac";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String id = rs.getString("Id");
                String ma = rs.getString("Ma");
                String ten = rs.getString("Ten");
                MauSac ms = new MauSac(id, ma, ten);
                listMS.add(ms);
            }
        } catch (Exception ex) {
            Logger.getLogger(MauSacRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listMS;
    }

    @Override
    public MauSac search(String ma) {
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "SELECT * FROM MauSac WHERE Ma = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            if (rs.next()) {
                String id = rs.getString("Id");
                String ten = rs.getString("Ten");
                MauSac ms = new MauSac(id, ma, ten);
                return ms;
            }
        } catch (Exception ex) {
            Logger.getLogger(MauSacRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
