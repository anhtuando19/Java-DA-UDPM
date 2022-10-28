/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Sevice;

import Model.SanPham;
import java.util.ArrayList;

/**
 *
 * @author ASDF
 */
public interface SanPhamSevice {

    ArrayList<SanPham> getList();

    void insert(SanPham sp);

    void delete(String ma);

    void update(SanPham sp, String ma);
}
