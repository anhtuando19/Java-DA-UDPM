/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ChucVu;

/**
 *
 * @author Admin
 */
public class ChucVuRepository{

    public ArrayList<ChucVu> getAll() {
        ArrayList<ChucVu> list = new ArrayList<>();
        try {
            Connection conn = DBContext.getConnection();
            String sql = "select * from SanPham";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String ma = rs.getString("Ma");
                String ten = rs.getString("Ten");
                ChucVu cv = new ChucVu(ma, ten);
                list.add(cv);
            }

        } catch (SQLException ex) {
            Logger.getLogger(SanPhamRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(SanPhamRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    

    public void delete(String Ma) {
         try {
            Connection conn = DBContext.getConnection();
            String sql = "delete from SanPham where Ma = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, Ma);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(SanPhamRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(ChucVu cv, String Ma) {
         try {
            Connection conn = DBContext.getConnection();
            String sql = "update ChucVu set Ma = ?, Ten = ? where Ma = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cv.getMa());
            ps.setString(2, cv.getTen());
            ps.setString(3, Ma);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(SanPhamRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    public void insert(ChucVu cv) {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "insert into ChucVu"
                    + "(Ma, Ten)"
                    + "values(?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cv.getMa());
            ps.setString(2, cv.getTen());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(SanPhamRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

    }



}
