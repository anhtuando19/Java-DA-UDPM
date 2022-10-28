/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.ArrayList;
import model.ChiTietSP;
import viewmodel.ChiTietSpViewModel;

/**
 *
 * @author Admin
 */
public interface IChiTietSPService {
    
    ArrayList<ChiTietSpViewModel> getList();
    
    void insert(ChiTietSP stsp);
    
    void update (ChiTietSP ctsp, String id);
    
    void delete(String id);
    
}
