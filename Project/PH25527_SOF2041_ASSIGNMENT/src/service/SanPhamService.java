/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.ArrayList;
import model.SanPham;
import repository.SanPhamRepository;
/**
 *
 * @author Admin
 */
public class SanPhamService implements ISanPhamService{
    
    SanPhamRepository spr = new SanPhamRepository();
    
    @Override
    public ArrayList<SanPham> getList(){
        return spr.getAll();
    }
    
    @Override
    public void insert(SanPham sp){
        spr.insert(sp);
    }
    @Override
    public void delete(String Ma){
        spr.delete(Ma);
    }
    @Override
    public void update(SanPham sp, String ma){
        spr.update(sp, ma);
    }
    
}
