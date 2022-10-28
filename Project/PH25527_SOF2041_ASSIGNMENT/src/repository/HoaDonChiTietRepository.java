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
import model.HoaDonChiTiet;
/**
 *
 * @author Admin
 */
public class HoaDonChiTietRepository {
    
    public ArrayList<HoaDonChiTiet> getList(){
        ArrayList<HoaDonChiTiet> list = new ArrayList<>();
        try {
            Connection conn = DBContext.getConnection();
            String sql = "select * from HoaDonChiTiet ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {                
                String id_hd = rs.getString(1);
                String id_ctsp = rs.getString(2);
                int soLuong = rs.getInt(3);
                double donGia = rs.getDouble(4);
                HoaDonChiTiet hdct = new HoaDonChiTiet(id_ctsp, id_hd, soLuong, donGia);
                list.add(hdct);
            }
        } catch (Exception ex) {
            Logger.getLogger(HoaDonChiTietRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    
    public void insert(HoaDonChiTiet hdct){
        try {
            Connection conn = DBContext.getConnection();
            String sql = "insert into HoaDonChiTiet";
        } catch (Exception ex) {
            Logger.getLogger(HoaDonChiTietRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
