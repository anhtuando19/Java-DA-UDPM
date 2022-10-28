/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Interface;

import Model.ChucVu;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public interface IChucVuService {
    ArrayList<ChucVu> getList();
    
    void insert(ChucVu cv);
    
    void delete(String ma);
    
    void update(String id, ChucVu cv);
    
    ChucVu checkMa(String ma);
}
