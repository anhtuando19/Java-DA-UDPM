/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.ArrayList;
import model.ChucVu;

/**
 *
 * @author Admin
 */
public interface IChucVuService {
    
    ArrayList<ChucVu> getList();
    
    void insert(ChucVu cv);
    
    void update(ChucVu cv, String ma);
    
    void delete( String ma);
    
}
