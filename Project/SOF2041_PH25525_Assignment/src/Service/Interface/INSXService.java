/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Interface;

import Model.NSX;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public interface INSXService {
    ArrayList<NSX> getList();
    
    NSX checkMa(String ma);
    
    void insert(NSX nsx);
    
    void delete(String ma);
    
    void update(String id, NSX nsx);
}
