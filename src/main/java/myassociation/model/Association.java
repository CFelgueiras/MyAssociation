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
public class Association {

    private String nome;
    private byte[] logotipo;

    public Association() {
    }

    public Association(String nome) {
        this.nome = nome;
    }

    public Image applicationIcon() {
        ImageIcon icon = new ImageIcon(getClass().getResource("/Resources/app_images/Blue_MyAssociation_100px.png"));
        Image iconimage = icon.getImage();
        return iconimage;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public byte[] getLogotipo() {
        return logotipo;
    }

    public void setLogotipo(byte[] logotipo) {
        this.logotipo = logotipo;
    }

    @Override
    public String toString() {
        return "Association{" + "nome=" + nome + '}';
    }
}
