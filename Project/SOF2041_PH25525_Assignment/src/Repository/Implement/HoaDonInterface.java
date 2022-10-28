/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository.Implement;

import Model.HoaDon;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public interface HoaDonInterface {
    void insert(HoaDon hd);
    
    void delete(String ma);
    
    void update(String id, HoaDon hd);
    
    ArrayList<HoaDon> all();
    
    HoaDon search(String ma);
}
