/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import java.util.ArrayList;
import model.ChiTietSP;
import repository.ChiTietSPRepository;
import viewmodel.ChiTietSpViewModel;
/**
 *
 * @author Admin
 */
public class ChiTietSPService implements IChiTietSPService{
    ChiTietSPRepository cr = new ChiTietSPRepository();
    
    @Override
    public ArrayList<ChiTietSpViewModel> getList(){
        return cr.getList();
    }
    
    @Override
    public void insert(ChiTietSP stsp){ 
        cr.insert(stsp);
    }
    @Override
    public void update (ChiTietSP ctsp, String id){
        cr.update(ctsp, id);
    }
    
    @Override
    public void delete(String id){
        cr.delete(id);
    }
    
    
}
