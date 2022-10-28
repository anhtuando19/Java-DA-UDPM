/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.ArrayList;
import model.KhachHang;
import repository.KhachHangRepository;

/**
 *
 * @author Admin
 */
public class KhachHangService implements IKhachHangService {

    KhachHangRepository khr = new KhachHangRepository();

    @Override
    public ArrayList<KhachHang> getListKh() {
        return khr.getList();
    }

    @Override
    public void insert(KhachHang kh) {
        khr.insert(kh);
    }

    @Override
    public void update(KhachHang kh, String ma) {
        khr.update(kh, ma);
    }

    @Override
    public void delete(String ma) {
        khr.delete(ma);
    }

}
