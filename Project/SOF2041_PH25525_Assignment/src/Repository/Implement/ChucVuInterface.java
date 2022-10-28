/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository.Implement;

import Model.ChucVu;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public interface ChucVuInterface {
    ArrayList<ChucVu> all();
    
    void insert(ChucVu cv);
    
    void delete(String ma);
    
    void update(String id, ChucVu cv);
    
    ChucVu search(String ma);
}
