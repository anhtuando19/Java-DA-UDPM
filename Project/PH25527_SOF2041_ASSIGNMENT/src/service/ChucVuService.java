/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import java.util.ArrayList;
import model.ChucVu;
import repository.ChucVuRepository;
/**
 *
 * @author Admin
 */
public class ChucVuService implements IChucVuService{
    
    ChucVuRepository cr = new ChucVuRepository();
    
    @Override
    public ArrayList<ChucVu> getList(){
        return cr.getAll();
    }
    
    @Override
    public void insert(ChucVu cv){
        cr.insert(cv);
    }
    @Override
    public void update(ChucVu cv, String ma){
        cr.update(cv, ma);
    }
    @Override
    public void delete( String ma){
        cr.delete(ma);
    }
    
}
