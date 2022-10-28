/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Service.Interface.NhanVienInter;
import Model.NhanVien;
import Repository.NhanVienRepo;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class NhanVienService implements NhanVienInter{
    private NhanVienRepo nvr;
    
    public  NhanVienService(){
        this.nvr = new NhanVienRepo();
    }
    
    @Override
    public ArrayList<NhanVien> getList(){
        return this.nvr.all();
    }
    
    @Override
    public void insert(NhanVien nv){
        this.nvr.insert(nv);
    }
    
    @Override
    public void delete(String ma){
        this.nvr.delete(ma);
    }
    
    @Override
    public void update(String id, NhanVien nv){
        this.nvr.update(id, nv);
    }
    
    @Override
    public NhanVien searchMa(String ma){
        return this.nvr.search(ma);
    }
}
