/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myassociation.model;

/**
 *
 * @author Francisco Pereira
 */
public class Quota {
    private Double numero;
 private Integer ano;
    private Integer categoria;

    public Double getNumero() {
        return numero;
    }

    public void setNumero(Double numero) {
        this.numero = numero;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Integer getCategoria() {
        return categoria;
    }

    public void setCategoria(Integer categoria) {
        this.categoria = categoria;
    }
    
    public Quota(Double numero, Integer ano, Integer categoria) {
        this.numero = numero;
        this.ano = ano;
        this.categoria = categoria;
    }
   
    
}
