/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Service.Interface.KhachHangInter;
import Model.KhachHang;
import Repository.KhachHangRepo;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class KhachHangService implements KhachHangInter{
    private KhachHangRepo khr;
    
    public KhachHangService(){
        this.khr = new KhachHangRepo();
    }
    
    @Override
    public ArrayList<KhachHang> getList(){
        return this.khr.all();
    }
    
    @Override
    public void insert(KhachHang kh){
        this.khr.insert(kh);
    }
    
    @Override
    public void delete(String ma){
        this.khr.delete(ma);
    }
    
    @Override
    public void update(String id, KhachHang kh){
        this.khr.update(id, kh);
    }
    
    @Override
    public KhachHang checkMa(String ma){
        return this.khr.search(ma);
    }
}
