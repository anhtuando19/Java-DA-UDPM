/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Interface;

import Model.ChiTietSP;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public interface ChiTietSPInter {
    ArrayList<ChiTietSP> getList();
    
    void insert(ChiTietSP ctsp);
    
    void delete(String id, String idSP);
    
    void update(String id, String idSP, ChiTietSP ctsp);
}
