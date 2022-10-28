/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Icon;

import java.awt.Image;;
import java.net.URL;
import javax.swing.ImageIcon;

/**
 *
 * @author PC
 */
public class ImageI {
    public static Image iconx(){
        URL url = ImageI.class.getResource("/Anh/logo.jpg");
        return new ImageIcon(url).getImage();
    }
}
