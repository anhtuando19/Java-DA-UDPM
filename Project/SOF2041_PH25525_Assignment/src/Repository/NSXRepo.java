/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import Repository.Implement.NSXInterface;
import JDBC.JDBCUtil;
import Model.NSX;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class NSXRepo implements NSXInterface{
    
    @Override
    public void insert(NSX nsx){
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "INSERT INTO NSX" + "(Ma, Ten)" + "VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nsx.getMa());
            ps.setString(2, nsx.getTen());
            ps.execute();
        } catch (Exception ex) {
            Logger.getLogger(NSXRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void delete(String ma){
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "DELETE FROM NSX WHERE Ma = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ma);
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(NSXRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void update(String id, NSX nsx){
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "UPDATE NSX SET Ma = ?, Ten = ? WHERE Id = ?"; 
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nsx.getMa());
            ps.setString(2, nsx.getTen());
            ps.setString(3, id);
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(NSXRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public ArrayList<NSX> all(){
        ArrayList<NSX> listNSX = new ArrayList<>();
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "SELECT * FROM NSX";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {                
                String id = rs.getString("Id");
                String ma = rs.getString("Ma");
                String ten = rs.getString("Ten");
                NSX nsx = new NSX(id, ma, ten);
                listNSX.add(nsx);
            }
        } catch (Exception ex) {
            Logger.getLogger(NSXRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listNSX;
    }
    
    @Override
    public NSX search(String ma){
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "SELECT * FROM NSX WHERE Ma = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            if(rs.next()){
                String id = rs.getString("Id");
                String ten = rs.getString("Ten");
                NSX nsx = new NSX(id, ma, ten);
                return nsx;
            }
        } catch (Exception ex) {
            Logger.getLogger(NSXRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
