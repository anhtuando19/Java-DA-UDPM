/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository.Implement;

import Model.DongSP;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public interface DongSPInterface {
    ArrayList<DongSP> all();
    
    void insert(DongSP dsp);
    
    void delete(String ma);
    
    void update(String id, DongSP dsp);
    
    DongSP search(String ma);
}
