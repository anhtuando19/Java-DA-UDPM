/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Service.Interface.HoaDonInter;
import Model.HoaDon;
import Repository.HoaDonRepo;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class HoaDonService implements  HoaDonInter{
    private HoaDonRepo hdr;
    
    public HoaDonService(){
        this.hdr = new HoaDonRepo();
    }
    
    @Override
    public ArrayList<HoaDon> getList(){
        return this.hdr.all();
    }
    
    @Override
    public void insert(HoaDon hd){
        this.hdr.insert(hd);
    }
    
    @Override
    public void delete(String ma){
        this.hdr.delete(ma);
    }
    
    @Override
    public void update(String id, HoaDon hd){
        this.hdr.update(id, hd);
    }
    
    @Override
    public HoaDon checkMa(String ma){
        return this.hdr.search(ma);
    }
}
