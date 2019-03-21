package Utils;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import myassociation.dto.EncryptResDTO;

/**
 * Helper class with encryption tools.
 *
 * Use Case : 31
 *
 * @author Francisco Martins<francisco_jcm_7@hotmail.com>
 */
public class EncryptUtils {

    private static final String HASH_PBE_KEY_SPEC_KEY = "PBKDF2WithHmacSHA1";
    private static final byte[] HASH_SALT = new byte[64];
    private static final int HASH_STRENGTH = 65536;
    private static final int HASH_CALC_ITERATIONS = 128;
    private static final String HEX_FROM_BYTES_FORMAT_KEY = "%02x";

    /**
     * Converts and Byte[] hash to an hexadecimal String.
     *
     * @param str Original string.
     *
     * @return Hexadecimal hash.
     */
    private static String bytesToHexa(byte[] str) {
        StringBuilder retStr = new StringBuilder();
        for (byte it : str) {
            retStr.append(String.format(HEX_FROM_BYTES_FORMAT_KEY, it));
        }

        return retStr.toString();
    }

    private static byte[] hexStringToByteArray(String str) {
        int len = str.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4)
                    + Character.digit(str.charAt(i + 1), 16));
        }
        return data;
    }

    /**
     * Generates an binary hash implementing PBKDF2 algorithm.
     *
     * @param str Original string to be hashed.
     *
     * @return Returns the hash bytes.
     *
     * @throws NoSuchAlgorithmException thrown when a particular cryptographic
     * algorithm is requested but is not available in the environment.
     *
     * @throws InvalidKeySpecException throw when the algorithm as invalid key
     * specifications.
     */
    public static EncryptResDTO encrypt(String str)
            throws NoSuchAlgorithmException, InvalidKeySpecException {
        new SecureRandom().nextBytes(HASH_SALT);
        KeySpec spec = new PBEKeySpec(
                str.toCharArray(),
                HASH_SALT,
                HASH_STRENGTH,
                HASH_CALC_ITERATIONS
        );
        SecretKeyFactory factory = SecretKeyFactory.getInstance(
                HASH_PBE_KEY_SPEC_KEY
        );
        
        return new EncryptResDTO(
                bytesToHexa(factory.generateSecret(spec).getEncoded()),
                bytesToHexa(HASH_SALT)
        );
    }

    public static String getEncyptionWithSalt(String str, String salt)
            throws NoSuchAlgorithmException, InvalidKeySpecException {
        KeySpec spec = new PBEKeySpec(
                str.toCharArray(),
                hexStringToByteArray(salt),
                HASH_STRENGTH,
                HASH_CALC_ITERATIONS
        );
        SecretKeyFactory factory = SecretKeyFactory.getInstance(
                HASH_PBE_KEY_SPEC_KEY
        );

        return bytesToHexa(factory.generateSecret(spec).getEncoded());
    }
}
