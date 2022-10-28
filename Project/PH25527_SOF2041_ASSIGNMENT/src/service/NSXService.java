/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.ArrayList;
import model.NSX;
import repository.NSXRepository;

/**
 *
 * @author Admin
 */
public class NSXService implements INSXService{
    
    NSXRepository nr = new NSXRepository();

    @Override
    public ArrayList<NSX> getList() {
        return nr.getList();
    }

    @Override
    public void insert(NSX nsx) {
        nr.insert(nsx);
    }

    @Override
    public void update(NSX nsx, String ma) {
        nr.update(nsx, ma);
    }

    @Override
    public void delete(String ma) {
        nr.delete(ma);
    }
    
}
