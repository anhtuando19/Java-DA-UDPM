/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import java.util.ArrayList;
import model.HoaDon;
/**
 *
 * @author Admin
 */
public interface IHoaDonService {
    
    ArrayList<HoaDon> getList();
    
    void insert(HoaDon hd);
    
    void update (HoaDon hd, String ma);
    
    void delete(String ma);
    
}
