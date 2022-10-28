/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.ArrayList;
import model.HoaDon;
import repository.HoaDonRepository;

/**
 *
 * @author Admin
 */
public class HoaDonService implements IHoaDonService{
    
    HoaDonRepository hr = new HoaDonRepository();

    @Override
    public ArrayList<HoaDon> getList() {
        return hr.getList();
    }

    @Override
    public void insert(HoaDon hd) {
        hr.insert(hd);
    }

    @Override
    public void update(HoaDon hd, String ma) {
        hr.update(hd, ma);
    }

    @Override
    public void delete(String ma) {
        hr.delete(ma);
    }
    
}
