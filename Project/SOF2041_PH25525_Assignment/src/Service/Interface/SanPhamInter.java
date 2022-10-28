/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Interface;

import Model.SanPham;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public interface SanPhamInter {
    ArrayList<SanPham> getList();
    
    void insert(SanPham sp);
    
    void delete(String id);
    
    void update(String id, SanPham sp);
    
    SanPham checkMa(String ma);
}
