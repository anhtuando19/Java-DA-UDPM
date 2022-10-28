/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Model.HoaDon;
import Repository.BanHangRepo;
import Service.Interface.BanHangInter;
import ViewModel.TableGiohang;
import ViewModel.TableSanPham;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class BanHangService implements BanHangInter{
    private BanHangRepo bhr;
    
    public BanHangService(){
        this.bhr = new BanHangRepo();
    }
    
    @Override
    public ArrayList<TableSanPham> getListSP(){
        return this.bhr.getListSP();
    }
    
    @Override
    public ArrayList<TableSanPham> searchSPByMa(String ma){
        return this.bhr.searchSPByMa(ma);
    }
    
    @Override
    public ArrayList<TableSanPham> searchSPByTen(String ten){
        return this.bhr.searchSPByTen(ten);
    }
    
    @Override
    public void insert(HoaDon hd){
        this.bhr.saveHD(hd);
    }
    
    @Override
    public ArrayList<TableGiohang> getListGioHang(){
        return this.bhr.getListGioHang();
    }
}
