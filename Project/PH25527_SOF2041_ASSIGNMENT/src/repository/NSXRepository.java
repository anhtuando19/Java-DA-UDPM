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
import model.NSX;

/**
 *
 * @author Admin
 */
public class NSXRepository{


    public ArrayList<NSX> getList() {
        ArrayList<NSX> list = new ArrayList<>();
        try {
            Connection conn = DBContext.getConnection();
            String sql = "select * from NSX";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String ma = rs.getString("Ma");
                String ten = rs.getString("Ten");
                NSX nsx = new NSX(ma, ten);
                list.add(nsx);
            }
        } catch (Exception ex) {
            Logger.getLogger(NSXRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

 
    public void insert(NSX nsx) {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "insert into NSX (Ma, Ten) values(?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nsx.getMa());
            ps.setString(2, nsx.getTen());
            ps.execute();

        } catch (Exception ex) {
            Logger.getLogger(NSXRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public void update(NSX nsx, String ma) {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "update NSX set Ma = ?, Ten = ? where Ma = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nsx.getMa());
            ps.setString(2, nsx.getTen());
            ps.setString(3, nsx.getMa());
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(NSXRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public void delete(String ma) {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "delete from NSX where Ma = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ma);
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(NSXRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
