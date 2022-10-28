/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository.Implement;

import Model.GioHang;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public interface GioHangInterface {
    ArrayList<GioHang> all();
    
    void insert(GioHang gh);
    
    void delete(String ma);
    
    void update(String id, GioHang gh);
    
    GioHang search(String ma);
}
