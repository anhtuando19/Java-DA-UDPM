/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import Repository.Implement.CuaHangInterface;
import JDBC.JDBCUtil;
import Model.CuaHang;
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
public class CuaHangRepo implements CuaHangInterface{
    
    @Override
    public void insert(CuaHang ch){
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "INSERT INTO CuaHang" + "(Ma, Ten, DiaChi, ThanhPho, QuocGia)"
                    + "VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ch.getMa());
            ps.setString(2, ch.getTen());
            ps.setString(3, ch.getDiaChi());
            ps.setString(4, ch.getThanhPho());
            ps.setString(5, ch.getQuocGia());
            ps.execute();
        } catch (Exception ex) {
            Logger.getLogger(CuaHangRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  
    @Override
    public void delete(String id){
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "DELETE FROM CuaHang WHERE Id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(CuaHangRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void update(String id, CuaHang ch){
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "UPDATE CuaHang SET Ma = ?, Ten = ?, DiaChi = ?, ThanhPho = ?, QuocGia = ? WHERE Id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ch.getMa());
            ps.setString(2, ch.getTen());
            ps.setString(3, ch.getDiaChi());
            ps.setString(4, ch.getThanhPho());
            ps.setString(5, ch.getQuocGia());
            ps.setString(6, ch.getId());
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(CuaHangRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public ArrayList<CuaHang> all(){
        ArrayList<CuaHang> listCH = new ArrayList<>();
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "SELECT * FROM CuaHang";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while(rs.next()){
                String id = rs.getString("Id");
                String ma = rs.getString("Ma");
                String ten = rs.getString("Ten");
                String diaChi = rs.getString("DiaChi");
                String thanhPho = rs.getString("ThanhPho");
                String quocGia = rs.getString("QuocGia");
                CuaHang ch = new CuaHang(id, ma, ten, diaChi, thanhPho, quocGia);
                listCH.add(ch);
            }
        } catch (Exception ex) {
            Logger.getLogger(CuaHangRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listCH;
    }
    
    @Override
    public CuaHang search(String ma){
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "SELECT * FROM CuaHang WHERE Ma = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            if(rs.next()){
                String id = rs.getString("Id");
                String ten = rs.getString("Ten");
                String diaChi = rs.getString("DiaChi");
                String thanhPho = rs.getString("ThanhPho");
                String quocGia = rs.getString("QuocGia");
                CuaHang ch = new CuaHang(id, ma, ten, diaChi, thanhPho, quocGia);
                return ch;
            }
        } catch (Exception ex) {
            Logger.getLogger(CuaHangRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
