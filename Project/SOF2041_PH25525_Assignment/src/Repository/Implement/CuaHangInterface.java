/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository.Implement;

import Model.CuaHang;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public interface CuaHangInterface {
    ArrayList<CuaHang> all();
    
    void insert(CuaHang ch);
    
    void delete(String ma);
    
    void update(String id, CuaHang ch);
    
    CuaHang search(String ma);
}
