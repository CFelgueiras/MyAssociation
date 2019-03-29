/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myassociation.dal;


/**
 *
 * @author Francisco Pereira
 */
public interface IQuotaDAO {
    
    public boolean criarQuota(Double valor, Integer ano, Integer categoria);
    public String[] listaCategoriasSocios();
    public int getCategoriaIdPorNome(String nome);
    public boolean verificaQuotaPorAnoCategoria(Integer ano, Integer categoria);
}
