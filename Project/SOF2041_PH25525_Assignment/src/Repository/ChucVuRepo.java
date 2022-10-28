/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import Repository.Implement.ChucVuInterface;
import JDBC.JDBCUtil;
import Model.ChucVu;
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
public class ChucVuRepo implements ChucVuInterface{
    
    @Override
    public void insert(ChucVu cv){
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "INSERT INTO ChucVu" + "(Ma, Ten)" 
                    + "VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cv.getMa());
            ps.setString(2, cv.getTen());
            ps.execute();
        } catch (Exception ex) {
            Logger.getLogger(ChucVuRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  
    @Override
    public void delete(String ma){
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "DELETE FROM ChucVu WHERE Ma = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ma);
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(ChucVuRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @Override    
    public void update(String id, ChucVu cv){
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "UPDATE ChucVu SET Ma = ?, Ten = ? WHERE Id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cv.getMa());
            ps.setString(2, cv.getTen());
            ps.setString(3, cv.getId());
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(ChucVuRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public ArrayList<ChucVu> all(){
        ArrayList<ChucVu> listCV = new ArrayList<>();
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "SELECT * FROM ChucVu";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while(rs.next()){
                String id = rs.getString("Id");
                String ma = rs.getString("Ma");
                String ten = rs.getString("Ten");
                ChucVu cv = new ChucVu(id, ma, ten);
                listCV.add(cv);
            }
        } catch (Exception ex) {
            Logger.getLogger(ChucVuRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listCV;
    }
 
    @Override
    public ChucVu search(String ma){
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "SELECT * FROM ChucVu WHERE Ma = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            if(rs.next()){
                String id = rs.getString("Id");
                String ten = rs.getString("Ten");
                ChucVu cv = new ChucVu(id, ma, ten);
                return cv;
            }
        } catch (Exception ex) {
            Logger.getLogger(ChucVuRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
