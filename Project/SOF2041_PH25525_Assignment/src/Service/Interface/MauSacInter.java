/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Interface;

import Model.MauSac;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public interface MauSacInter {
    ArrayList<MauSac> getList();
    
    void insert(MauSac ms);
    
    void delete(String ma);
    
    void update(String id, MauSac ms);
    
    MauSac searchMa(String ma);
}
