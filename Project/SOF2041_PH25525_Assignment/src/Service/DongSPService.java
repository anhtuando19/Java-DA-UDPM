/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Service.Interface.DongSPInter;
import Model.DongSP;
import Repository.DongSPRepo;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class DongSPService implements  DongSPInter{
    private DongSPRepo dspr;
    
    public DongSPService(){
        this.dspr = new DongSPRepo();
    }
    
    @Override
    public ArrayList<DongSP> getList(){
        return this.dspr.all();
    }
    
    @Override
    public void insert(DongSP dsp){
        this.dspr.insert(dsp);
    }
    
    @Override
    public void delete(String id){
        this.dspr.delete(id);
    }
    
    @Override
    public void update(String id, DongSP dsp){
        this.dspr.update(id, dsp);
    }
    
    public DongSP searchMa(String ma){
        return this.dspr.search(ma);
    }
}
