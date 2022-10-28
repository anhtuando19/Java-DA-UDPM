/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Service.Interface.CuaHangInter;
import Model.CuaHang;
import Repository.CuaHangRepo;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class CuaHangService implements  CuaHangInter{
    private CuaHangRepo chr;
    
    public CuaHangService(){
        this.chr = new CuaHangRepo();
    }
    
    @Override
    public ArrayList<CuaHang> getList(){
        return this.chr.all();
    }
    
    @Override
    public void insert(CuaHang ch){
        this.chr.insert(ch);
    }
    
    @Override
    public void delete(String id){
        this.chr.delete(id);
    }
    
    @Override
    public void update(String id, CuaHang ch){
        this.chr.update(id, ch);
    }
    
    @Override
    public CuaHang searchMa(String ma){
        return this.chr.search(ma);
    }
}
