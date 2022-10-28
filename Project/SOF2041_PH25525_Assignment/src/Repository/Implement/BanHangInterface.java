/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository.Implement;

import Model.HoaDon;
import ViewModel.TableGiohang;
import ViewModel.TableSanPham;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public interface BanHangInterface {
   ArrayList<TableSanPham> getListSP();
   
   ArrayList<TableSanPham> searchSPByMa(String ma);
   
   ArrayList<TableSanPham> searchSPByTen(String ten);
   
   void saveHD(HoaDon hd);
   
   ArrayList<TableGiohang> getListGioHang();
}
