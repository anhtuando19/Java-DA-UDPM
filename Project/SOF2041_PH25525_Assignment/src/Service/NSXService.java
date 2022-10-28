/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Service.Interface.INSXService;
import Model.NSX;
import Repository.NSXRepo;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class NSXService implements INSXService{
    private NSXRepo nsxr;
    
    public NSXService(){
        this.nsxr = new NSXRepo();
    }
    
    @Override
    public ArrayList<NSX> getList(){
        return this.nsxr.all();
    }
    
    @Override
    public NSX checkMa(String ma){
        return this.nsxr.search(ma);
    }
    
    @Override
    public void insert(NSX nsx){
        this.nsxr.insert(nsx);
    }
    
    @Override
    public void delete(String ma){
        this.nsxr.delete(ma);
    }
    
    @Override
    public void update(String id, NSX nsx){
        this.nsxr.update(id, nsx);
    }
}
