/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.ArrayList;
import model.CuaHang;
import repository.CuaHangRepository;
/**
 *
 * @author Admin
 */
public class CuaHangService implements ICuaHangService{
    
    CuaHangRepository chr = new CuaHangRepository();
    
    @Override
    public ArrayList<CuaHang> getList(){
        return chr.getAll();
    }
    
    @Override
    public void insert(CuaHang ch){
        chr.insert(ch);
    }
    
    @Override
    public void update(CuaHang ch, String ma){
        chr.update(ch, ma);
    }
    
    @Override
    public void delete(String ma){
        chr.delete(ma);
    }
    
}
