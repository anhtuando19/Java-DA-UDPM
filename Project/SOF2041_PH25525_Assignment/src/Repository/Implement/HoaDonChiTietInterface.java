/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository.Implement;

import Model.HoaDonChiTiet;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public interface HoaDonChiTietInterface {
    void insert(HoaDonChiTiet hdct);
    
    void delete(String idHD, String idCTSP);
    
    void update(String idHD, String idCTSP, HoaDonChiTiet hdct);
    
    ArrayList<HoaDonChiTiet> all();
}
