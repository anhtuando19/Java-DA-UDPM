/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Model.SanPham;
import java.util.ArrayList;
import repository.DBContext;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASDF
 */
public class SanPhamRepository {

    private DBContext dbConnection;

    public void update(SanPham sp, String ma){
        try {
            Connection conn = DBContext.getConnection();
            String sql = "UPDATE SanPham set ma = ?, ten = ? WHERE Ma = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sp.getMa() );
            ps.setString(2, sp.getTen() );
            ps.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
        }
    }
    public void delete(String ma) {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "DELETE FROM SanPham WHERE Ma = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ma);
            ps.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void insert(SanPham sp) {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "insert into SanPham"
                    + "(Ma, Ten)"
                    + "values(?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sp.getMa());
            ps.setString(2, sp.getTen());
            ps.execute();
        } catch (Exception e) {
            e.getMessage();
        }

    }

    public ArrayList<SanPham> getListSanPham() {
        ArrayList<SanPham> listSP = new ArrayList<>();
        String sql = "SELECT * FROM SanPham";
        try (Connection conn = dbConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.execute();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sanPham = new SanPham();
                sanPham.setId(rs.getString(1));
                sanPham.setMa(rs.getString(2));
                sanPham.setTen(rs.getString(3));
                listSP.add(sanPham);
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return listSP;
    }
}
