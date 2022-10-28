/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Interface;

import Model.CuaHang;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public interface CuaHangInter {
    ArrayList<CuaHang> getList();
    
    void insert(CuaHang ch);
    
    void delete(String id);
    
    void update(String id, CuaHang ch);
    
    CuaHang searchMa(String ma);
}
