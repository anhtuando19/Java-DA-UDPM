/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Interface;

import Model.HoaDon;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public interface HoaDonInter {
    ArrayList<HoaDon> getList();
    
    void insert(HoaDon hd);
    
    void delete(String ma);
    
    void update(String id, HoaDon hd);
    
    HoaDon checkMa(String ma);
}
