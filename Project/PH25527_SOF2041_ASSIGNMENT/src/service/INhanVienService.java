/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import java.util.ArrayList;
import model.NhanVien;
/**
 *
 * @author Admin
 */
public interface INhanVienService {
    
    ArrayList<NhanVien> getList();

    void insert(NhanVien nv);
    void update(NhanVien nv, String ma);
    void delete(String ma);
    
}
