package password_demo;

import javax.crypto.Cipher;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import java.security.Key;
import java.security.InvalidKeyException;


public class RC2 {

    public static String algorithm     = "RC2";
    public static Key key              = null;
    public static Cipher cipher        = null;

    //Setting up the key and cipher
    public static void setUp() throws Exception {
        key         = KeyGenerator.getInstance(algorithm).generateKey();
        cipher      = Cipher.getInstance(algorithm);
    }

     //RC4 Encryption
     public static byte[] RC2_Encrypt(String input)
            throws InvalidKeyException,
            BadPaddingException,
            IllegalBlockSizeException {
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] inputBytes = input.getBytes();
        return cipher.doFinal(inputBytes);
    }

     //RC4 Decryption
     public static String RC2_Decrypt(byte[] encryptionBytes)
            throws InvalidKeyException,
            BadPaddingException,
            IllegalBlockSizeException {
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] recoveredBytes = cipher.doFinal(encryptionBytes);
        String recovered      = new String(recoveredBytes);
        return recovered;
    }

}
