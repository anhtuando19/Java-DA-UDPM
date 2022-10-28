/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.ArrayList;
import model.SanPham;

/**
 *
 * @author Admin
 */
public interface ISanPhamService {
    
    ArrayList<SanPham> getList();
    
    void insert(SanPham sp);
    
    void delete(String Ma);
    
    void update(SanPham sp, String ma);
    
}
