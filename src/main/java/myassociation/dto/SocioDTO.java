package myassociation.dto;

/**
 * Transfer object used on partner entities.
 * 
 * @author Francisco Martins<fcmartins@lastsoftware.pt>
 */
public class SocioDTO {

    public String NUMERO;
    public String NIF;
    public String NOME;
    public String TELEFONE;
    public String TELEMOVEL;
    public String MORADA;
    public String EMAIL;
    public String DATACRIACAO;
    public String DATAMODIF;
    public String IDUTILIZADOR;
    public String FOTOGRAFIA;
    public String ATIVO;
    public String APAGADO;
    public Integer IDASSOCIACAO;
    public Integer IDCATEGORIA;

    public String getNUMERO() {
        return NUMERO;
    }

    public void setNUMERO(String NUMERO) {
        this.NUMERO = NUMERO;
    }

    public String getNIF() {
        return NIF;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public String getNOME() {
        return NOME;
    }

    public void setNOME(String NOME) {
        this.NOME = NOME;
    }

    public String getTELEFONE() {
        return TELEFONE;
    }

    public void setTELEFONE(String TELEFONE) {
        this.TELEFONE = TELEFONE;
    }

    public String getTELEMOVEL() {
        return TELEMOVEL;
    }

    public void setTELEMOVEL(String TELEMOVEL) {
        this.TELEMOVEL = TELEMOVEL;
    }

    public String getMORADA() {
        return MORADA;
    }

    public void setMORADA(String MORADA) {
        this.MORADA = MORADA;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getDATACRIACAO() {
        return DATACRIACAO;
    }

    public void setDATACRIACAO(String DATACRIACAO) {
        this.DATACRIACAO = DATACRIACAO;
    }

    public String getDATAMODIF() {
        return DATAMODIF;
    }

    public void setDATAMODIF(String DATAMODIF) {
        this.DATAMODIF = DATAMODIF;
    }

    public String getIDUTILIZADOR() {
        return IDUTILIZADOR;
    }

    public void setIDUTILIZADOR(String IDUTILIZADOR) {
        this.IDUTILIZADOR = IDUTILIZADOR;
    }

    public String getFOTOGRAFIA() {
        return FOTOGRAFIA;
    }

    public void setFOTOGRAFIA(String FOTOGRAFIA) {
        this.FOTOGRAFIA = FOTOGRAFIA;
    }

    public String getATIVO() {
        return ATIVO;
    }

    public void setATIVO(String ATIVO) {
        this.ATIVO = ATIVO;
    }

    public String getAPAGADO() {
        return APAGADO;
    }

    public void setAPAGADO(String APAGADO) {
        this.APAGADO = APAGADO;
    }

    public Integer getIDASSOCIACAO() {
        return IDASSOCIACAO;
    }

    public void setIDASSOCIACAO(Integer IDASSOCIACAO) {
        this.IDASSOCIACAO = IDASSOCIACAO;
    }

    public Integer getIDCATEGORIA() {
        return IDCATEGORIA;
    }

    public void setIDCATEGORIA(Integer IDCATEGORIA) {
        this.IDCATEGORIA = IDCATEGORIA;
    }

}
