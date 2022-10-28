/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Service.Interface.HoaDonChiTietInter;
import Model.HoaDonChiTiet;
import Repository.HoaDonChiTietRepo;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class HoaDonChiTietService implements HoaDonChiTietInter{
    private HoaDonChiTietRepo hdctr;
    
    public HoaDonChiTietService(){
        this.hdctr = new HoaDonChiTietRepo();
    }
    
    @Override
    public ArrayList<HoaDonChiTiet> getList(){
        return this.hdctr.all();
    }
    
    @Override
    public void insert(HoaDonChiTiet hdct){
        this.hdctr.insert(hdct);
    }
    
    @Override
    public void delete(String idHoaDon, String idChiTietSP){
        this.hdctr.delete(idHoaDon, idChiTietSP);
    }
    
    @Override
    public void update(String idHoaDon, String idChiTietSP, HoaDonChiTiet hdct){
        this.hdctr.update(idHoaDon, idChiTietSP, hdct);
    }
}
