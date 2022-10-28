/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import java.util.ArrayList;
import model.KhachHang;
/**
 *
 * @author Admin
 */
public interface IKhachHangService  {
    
    ArrayList<KhachHang> getListKh();
    
    void insert(KhachHang kh);
    
    void update(KhachHang kh , String ma);
    
    void delete(String ma);
    
}
