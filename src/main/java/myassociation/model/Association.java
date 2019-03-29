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
    private String nif;
    private String Presidente;
    private String secretario;
    private String tesoureiro;
    private String vogal1, vogal2, vogal3, vogal4, vogal5;
    private String morada;
    private String telefone;
    private String telemovel;
    private String email;

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

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getPresidente() {
        return Presidente;
    }

    public void setPresidente(String Presidente) {
        this.Presidente = Presidente;
    }

    public String getSecretario() {
        return secretario;
    }

    public void setSecretario(String secretario) {
        this.secretario = secretario;
    }

    public String getTesoureiro() {
        return tesoureiro;
    }

    public void setTesoureiro(String tesoureiro) {
        this.tesoureiro = tesoureiro;
    }

    public String getVogal1() {
        return vogal1;
    }

    public void setVogal1(String vogal1) {
        this.vogal1 = vogal1;
    }

    public String getVogal2() {
        return vogal2;
    }

    public void setVogal2(String vogal2) {
        this.vogal2 = vogal2;
    }

    public String getVogal3() {
        return vogal3;
    }

    public void setVogal3(String vogal3) {
        this.vogal3 = vogal3;
    }

    public String getVogal4() {
        return vogal4;
    }

    public void setVogal4(String vogal4) {
        this.vogal4 = vogal4;
    }

    public String getVogal5() {
        return vogal5;
    }

    public void setVogal5(String vogal5) {
        this.vogal5 = vogal5;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTelemovel() {
        return telemovel;
    }

    public void setTelemovel(String telemovel) {
        this.telemovel = telemovel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
