package Utils;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 * Helper class with encryption tools.
 *
 * @author Francisco Martins<francisco_jcm_7@hotmail.com>
 */
public class EncryptUtils {
    
    private static final String HASH_PBE_KEY_SPEC_KEY = "3WTZTmHniazAf3OXsPFk";
    private static final byte[] HASH_SALT = new byte[16];
    private static final int HASH_STRENGTH = 65536;
    private static final int HASH_CALC_ITERATIONS = 128;

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
    public static byte[] encrypt(String str)
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

        return factory.generateSecret(spec).getEncoded();
    }

}
