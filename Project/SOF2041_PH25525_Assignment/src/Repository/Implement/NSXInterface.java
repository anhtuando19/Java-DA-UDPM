/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository.Implement;

import Model.NSX;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public interface NSXInterface {
    void insert(NSX nsx);
    
    void delete(String ma);
    
    void update(String id, NSX nsx);
    
    ArrayList<NSX> all();
    
    NSX search(String ma);
}
