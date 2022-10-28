/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Service.Interface.MauSacInter;
import Model.MauSac;
import Repository.MauSacRepo;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class MauSacService  implements MauSacInter{
    private MauSacRepo msr;
    
    public MauSacService(){
        this.msr = new MauSacRepo();
    }
 
    @Override
    public ArrayList<MauSac> getList(){
        return this.msr.all();
    }
    
    @Override
    public void insert(MauSac ms){
        this.msr.insert(ms);
    }
    
    @Override
    public void delete(String id){
        this.msr.delete(id);
    }
    
    @Override
    public void update(String id, MauSac ms){
        this.msr.update(id, ms);
    }
    
    @Override
    public MauSac searchMa(String ma){
        return this.msr.search(ma);
    }
}
