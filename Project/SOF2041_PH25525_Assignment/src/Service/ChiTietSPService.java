/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Service.Interface.ChiTietSPInter;
import Model.ChiTietSP;
import Repository.ChiTietSPRepo;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class ChiTietSPService implements ChiTietSPInter{
    private ChiTietSPRepo ctspr;

    public ChiTietSPService(){
        this.ctspr = new ChiTietSPRepo();
    }
 
    @Override
    public ArrayList<ChiTietSP> getList(){
        return this.ctspr.all();
    }
 
   @Override
    public void insert(ChiTietSP ctsp){
        this.ctspr.insert(ctsp);
    }
  
    @Override
    public void delete(String id, String idSP){
        this.ctspr.delete(id, idSP);
    }
   
    @Override
    public void update(String id, String idSP, ChiTietSP ctsp){
        this.ctspr.update(id, idSP, ctsp);
    }

}
