package myassociation.model;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Date;

/**
 *
 * @author FELGUEIRAS
 */
public class Member {

    //all variables set to String, leading zeros needed
    private String numero;
    private String nif;
    private String nome;
    private String telefone;
    private String telemovel;
    private String morada;
    private String email;
    private Date datacriacao;
    private Date datamodif;
    private boolean estado;
    private byte[] fotografia;
    private String utilizador;
    private String associacao;
    private String categoria;

    public Member() {
    }

    public Member(String numero, String nif, String nome, String telefone, String telemovel, String morada, String email, boolean estado, BufferedImage fotografia, String utilizador, String associacao, String categoria) {
        this.numero = numero;
        this.nif = nif;
        this.nome = nome;
        this.telefone = telefone;
        this.telemovel = telemovel;
        this.morada = morada;
        this.email = email;
        this.estado = estado;
        this.associacao = associacao;
        this.utilizador = utilizador;
        this.categoria = categoria;
    }

    public String getUtilizador() {
        return utilizador;
    }

    public void setUtilizador(String utilizador) {
        this.utilizador = utilizador;
    }

    public String getAssociacao() {
        return associacao;
    }

    public void setAssociacao(String associacao) {
        this.associacao = associacao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Member(String nome, String numero, String morada, String nif) throws IOException {
        this.nome = nome;
        this.numero = numero;
        this.morada = morada;
        this.nif = nif;
    }

    public byte[] getFotografia() {
        return fotografia;
    }

    public void setFotografia(byte[] fotografia) {
        this.fotografia = fotografia;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public boolean getEstado() {
        return estado;
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

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDatacriacao() {
        return datacriacao;
    }

    public void setDatacriacao(Date datacriacao) {
        this.datacriacao = datacriacao;
    }

    public Date getDatamodif() {
        return datamodif;
    }

    public void setDatamodif(Date datamodif) {
        this.datamodif = datamodif;
    }

    @Override
    public String toString() {
        return "Socio: " + "nome:" + nome + ", numero:" + numero + ", morada:" + morada + ", nif:" + nif + '.';
    }

}
