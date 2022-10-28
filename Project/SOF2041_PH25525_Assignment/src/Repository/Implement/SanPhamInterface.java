/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository.Implement;
import Model.SanPham;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public interface SanPhamInterface {
    ArrayList<SanPham> all();
    
    void insert(SanPham sp);
    
    void delete(String ma);
    
    void update(String id, SanPham sp);
    
    SanPham search(String ma);
}
