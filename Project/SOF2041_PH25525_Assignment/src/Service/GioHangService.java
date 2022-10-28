/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Model.GioHang;
import Repository.GioHangRepo;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class GioHangService {
    private GioHangRepo ghr;
    
    public GioHangService(){
        this.ghr = new GioHangRepo();
    }
    
    public ArrayList<GioHang> getList(){
        return this.ghr.all();
    }
    
    public void insert(GioHang gh){
        this.ghr.insert(gh);
    }
    
    public void update(String id, GioHang gh){
        this.ghr.update(id, gh);
    }
    
    public void delete(String ma){
        this.ghr.delete(ma);
    }
    
    public GioHang checkMa(String ma){
        return this.ghr.search(ma);
    }
}
