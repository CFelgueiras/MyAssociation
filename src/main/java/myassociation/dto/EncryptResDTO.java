
package myassociation.dto;

public class EncryptResDTO {
    public String hash;
    public String salt;

    public EncryptResDTO(String hash, String salt) {
        this.hash = hash;
        this.salt = salt;
    }
    
}
