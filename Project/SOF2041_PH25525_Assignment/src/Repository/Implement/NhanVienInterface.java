/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository.Implement;

import Model.NhanVien;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public interface NhanVienInterface {
    ArrayList<NhanVien> all();
    
    void insert(NhanVien nv);
    
    void delete(String ma);
    
    void update(String id, NhanVien nv);
    
    NhanVien search(String ma);
}
