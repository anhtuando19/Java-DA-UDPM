/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Interface;

import Model.HoaDon;
import ViewModel.TableGiohang;
import ViewModel.TableSanPham;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public interface BanHangInter {
    ArrayList<TableSanPham> getListSP();
    
    ArrayList<TableSanPham> searchSPByMa(String ma);
    
    ArrayList<TableSanPham> searchSPByTen(String ten);
    
    void insert(HoaDon hd);
    
    ArrayList<TableGiohang> getListGioHang();
}
