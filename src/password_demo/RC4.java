package password_demo;

import java.security.InvalidKeyException;
import java.security.Key;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;


public class RC4 {

    public static String algorithm     = "RC4";
    public static Key key              = null;
    public static Cipher cipher        = null;

    //Setting up the key and cipher
    public static void setUp() throws Exception {
        key         = KeyGenerator.getInstance(algorithm).generateKey();
        cipher      = Cipher.getInstance(algorithm);
    }

     //RC4 Encryption
     public static byte[] RC4_Encrypt(String input)
            throws InvalidKeyException,
            BadPaddingException,
            IllegalBlockSizeException {
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] inputBytes = input.getBytes();
        return cipher.doFinal(inputBytes);
    }

     //RC4 Decryption
     public static String RC4_Decrypt(byte[] encryptionBytes)
            throws InvalidKeyException,
            BadPaddingException,
            IllegalBlockSizeException {
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] recoveredBytes = cipher.doFinal(encryptionBytes);
        String recovered      = new String(recoveredBytes);
        return recovered;
    }

}
