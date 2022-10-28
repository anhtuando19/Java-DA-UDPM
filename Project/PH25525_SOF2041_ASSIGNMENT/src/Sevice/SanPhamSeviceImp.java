/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sevice;

import Model.SanPham;
import Repository.SanPhamRepository;
import java.util.ArrayList;

/**
 *
 * @author ASDF
 */
public class SanPhamSeviceImp implements SanPhamSevice{

    private SanPhamRepository sanPhamRepository = new SanPhamRepository();
    
    @Override
    public ArrayList<SanPham> getList() {
        return sanPhamRepository.getListSanPham();
    }

    @Override
    public void insert(SanPham sp) {
        sanPhamRepository.insert(sp);
    }

    @Override
    public void delete(String ma) {
        sanPhamRepository.delete(ma);
    }

    @Override
    public void update(SanPham sp, String ma) {
        sanPhamRepository.update(sp, ma);
    }

    
}
