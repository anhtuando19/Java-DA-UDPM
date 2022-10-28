/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.ArrayList;
import model.CuaHang;

/**
 *
 * @author Admin
 */
public interface ICuaHangService {
    
    ArrayList<CuaHang> getList();
    
    void insert(CuaHang ch);
    
    void update(CuaHang ch, String ma);
    
    void delete(String ma);
    
}
