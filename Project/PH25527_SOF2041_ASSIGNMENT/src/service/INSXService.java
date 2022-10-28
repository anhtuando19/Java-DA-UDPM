/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import java.util.ArrayList;
import model.NSX;
/**
 *
 * @author Admin
 */
public interface INSXService {
    
    ArrayList<NSX> getList();
    
    void insert(NSX nsx);
    
    void update(NSX nsx, String ma);
    
    void delete(String ma);
    
}
