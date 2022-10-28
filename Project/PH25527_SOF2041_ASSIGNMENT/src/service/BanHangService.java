/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.ArrayList;
import repository.BanHangRepository;
import viewmodel.TBSanPham;
/**
 *
 * @author Admin
 */
public class BanHangService {
    
    BanHangRepository bhr = new BanHangRepository();
    
    public ArrayList<TBSanPham> getListSP(){
        return bhr.getListSP();
    }
    public ArrayList<TBSanPham> getListSPTimKiemTheoMa(String ma){
        return bhr.getListSPTimKiemTheoMa(ma);
    }
    public ArrayList<TBSanPham> getListSPTimKiemTheoten(String ten){
        return bhr.getListSPTimKiemTheoTen(ten);
    }
    
    
    
    
}
