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
import model.CuaHang;

/**
 *
 * @author Admin
 */
public class CuaHangRepository {

    public void insert(CuaHang ch) {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "insert into CuaHang"
                    + "(Ma, Ten, DiaChi, ThanhPho, QuocGia)"
                    + "values(?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ch.getMa());
            ps.setString(2, ch.getTen());
            ps.setString(3, ch.getDiaChi());
            ps.setString(4, ch.getThanhPho());
            ps.setString(5, ch.getQuocGia());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(SanPhamRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void update(CuaHang cv, String Ma) {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "update CuaHang set Ma = ?, Ten = ? where Ma = ?";
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

    public void delete(String Ma) {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "delete from CuaHang where Ma = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, Ma);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(SanPhamRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ArrayList<CuaHang> getAll() {
        ArrayList<CuaHang> list = new ArrayList<>();
        try {
            Connection conn = DBContext.getConnection();
            String sql = "select * from CuaHang";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String ma = rs.getString("Ma");
                String ten = rs.getString("Ten");
                String dc = rs.getString("DiaChi");
                String tp = rs.getString("ThanhPho");
                String qg = rs.getString("QuocGia");
                CuaHang ch = new CuaHang(ma, ten, dc, tp, qg);
                list.add(ch);
            }

        } catch (SQLException ex) {
            Logger.getLogger(SanPhamRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(SanPhamRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

}
