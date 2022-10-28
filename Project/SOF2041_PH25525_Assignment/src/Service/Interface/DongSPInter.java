/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Interface;

import Model.DongSP;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public interface DongSPInter {
    ArrayList<DongSP> getList();
    
    void insert(DongSP dsp);
    
    void delete(String id);
    
    void update(String id, DongSP dsp);
    
    DongSP searchMa(String ma);
}
