package myassociation.controller;

import myassociation.dal.QuotaImpl;

/**
 *
 * @author Francisco Pereira
 */
public class QuotaController {

    QuotaImpl quotaDAO = new QuotaImpl();

    public boolean criarQuota(Double valor , Integer ano,Integer categoria) {
        return quotaDAO.criarQuota(valor, ano, categoria);
    }
    public String[] listaCategoriasSocios() {
        return quotaDAO.listaCategoriasSocios();
    }
   
    public boolean verificaQuotaPorAnoCategoria(Integer ano, Integer categoria){
        return quotaDAO.verificaQuotaPorAnoCategoria(ano,categoria);
    }
    
    public int getCategoriaIdPorNome(String nome) {
         return quotaDAO.getCategoriaIdPorNome(nome);
    }
 
}
