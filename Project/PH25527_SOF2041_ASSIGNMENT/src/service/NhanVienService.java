/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.ArrayList;
import model.NhanVien;
import repository.NhanVienRepository;

/**
 *
 * @author Admin
 */
public class NhanVienService implements INhanVienService {

    NhanVienRepository nr = new NhanVienRepository();

    @Override
    public ArrayList<NhanVien> getList() {
        return nr.getList();
    }

    @Override
    public void insert(NhanVien nv) {
        nr.insert(nv);
    }

    @Override
    public void update(NhanVien nv, String ma) {
        nr.update(nv, ma);
    }

    @Override
    public void delete(String ma) {
        nr.delete(ma);
    }
}
