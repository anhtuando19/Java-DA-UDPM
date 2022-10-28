/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import Repository.Implement.SanPhamInterface;
import JDBC.JDBCUtil;
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
public class SanPhamRepo implements SanPhamInterface {

    @Override
    public void insert(SanPham sp) {
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "INSERT INTO SanPham" + "(Ma, Ten)" + "VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sp.getMa());
            ps.setString(2, sp.getTen());
            ps.execute();
        } catch (Exception ex) {
            Logger.getLogger(SanPhamRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(String id) {
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "DELETE FROM SanPham WHERE Id = ?\n";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(SanPhamRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(String id, SanPham sp) {
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "UPDATE SanPham SET Ma = ?, Ten = ? WHERE Id  = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sp.getMa());
            ps.setString(2, sp.getTen());
            ps.setString(3, sp.getId());
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(SanPhamRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<SanPham> all() {
        ArrayList<SanPham> listSP = new ArrayList<>();
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "SELECT * FROM SanPham";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String id = rs.getString("Id");
                String ma = rs.getString("Ma");
                String ten = rs.getString("Ten");
                SanPham sp = new SanPham(id, ma, ten);
                listSP.add(sp);
            }
        } catch (Exception ex) {
            Logger.getLogger(SanPhamRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listSP;
    }

    public SanPham search(String ma) {
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "SELECT * FROM SanPham WHERE Ma = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            if (rs.next()) {
                String id = rs.getString("Id");
                String ten = rs.getString("Ten");
                SanPham sp = new SanPham(id, ma, ten);
                return sp;
            }
        } catch (Exception ex) {
            Logger.getLogger(SanPhamRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
