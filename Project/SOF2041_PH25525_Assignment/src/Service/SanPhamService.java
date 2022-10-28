/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Service.Interface.SanPhamInter;
import Model.SanPham;
import Repository.SanPhamRepo;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class SanPhamService implements SanPhamInter{
    private SanPhamRepo spr;
    
    public SanPhamService(){
        this.spr = new SanPhamRepo();
    }
    
    @Override
    public ArrayList<SanPham> getList(){
        return this.spr.all();
    }
    
    @Override
    public void insert(SanPham sp){
        this.spr.insert(sp);
    }
    
    @Override
    public void delete(String id){
        this.spr.delete(id);
    }
    
    @Override
    public void update(String id, SanPham sp){
        this.spr.update(id, sp);
    }
    
    @Override
    public SanPham checkMa(String ma){
        return this.spr.search(ma);
    }
}
