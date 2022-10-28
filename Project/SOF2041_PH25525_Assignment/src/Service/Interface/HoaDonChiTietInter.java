/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Interface;

import Model.HoaDonChiTiet;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public interface HoaDonChiTietInter {
    ArrayList<HoaDonChiTiet> getList();
    
    void insert(HoaDonChiTiet hdct);
    
    void delete(String idHoaDon, String idChiTietSP);
    
    void update(String idHoaDon, String idChiTietSP, HoaDonChiTiet hdct);
}
