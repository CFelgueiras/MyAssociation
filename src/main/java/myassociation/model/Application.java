/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myassociation.model;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Cláudio Felgueiras
 */
public class Application {

    private String currentUser;

    private static byte[] logotipo;
    private static ImageIcon icon;

    public Application() {
        icon = new ImageIcon(getClass().getResource("/Resources/app_images/Blue_MyAssociation_100px.png"));
    }

    public void setCurrentUser(String username) {
        this.currentUser = username;
    }

    public String getCurrentUser() {
        return this.currentUser;
    }

    public byte[] getLogotipo() {
        return logotipo;
    }

    public void setLogotipo(byte[] logotipo) {
        Application.logotipo = logotipo;
    }

    public static Image getIcon() {
        Image iconimage = icon.getImage();
        return iconimage;
    }
}
