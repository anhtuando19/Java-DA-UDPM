/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository.Implement;

import Model.KhachHang;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public interface KhachHangInterface {
    void insert(KhachHang kh);
    
    void delete(String Ma);
    
    void update(String Id, KhachHang kh);
    
    ArrayList<KhachHang> all();
    
    KhachHang search(String ma);
}
