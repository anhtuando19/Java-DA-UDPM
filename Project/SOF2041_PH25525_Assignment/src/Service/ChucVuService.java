/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Service.Interface.IChucVuService;
import Model.ChucVu;
import Repository.ChucVuRepo;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class ChucVuService implements IChucVuService{
    private ChucVuRepo cvr;
    
    public ChucVuService(){
        this.cvr = new ChucVuRepo();
    }
    
    @Override
    public ArrayList<ChucVu> getList(){
        return this.cvr.all();
    }

    @Override
    public void insert(ChucVu cv){
        this.cvr.insert(cv);
    }
    
    @Override
    public void delete(String ma){
        this.cvr.delete(ma);
    }
    
    @Override
    public void update(String id, ChucVu cv){
        this.cvr.update(id, cv);
    }
    
    @Override
    public ChucVu checkMa(String ma){
        return this.cvr.search(ma);
    }
}
