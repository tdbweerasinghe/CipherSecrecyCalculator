/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package password_demo;

import javax.crypto.Cipher;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import java.security.Key;
import java.security.InvalidKeyException;

/**
 *
 * @author Tharindu Werasinghe
 */
public class AES {

    public static String algorithm     = "AES";
    public static Key key              = null;
    public static Cipher cipher        = null;

    //Setting up the key and cipher
    public static void setUp() throws Exception {
        key         = KeyGenerator.getInstance(algorithm).generateKey();
        cipher      = Cipher.getInstance(algorithm);
    }

     //AES Encryption
     public static byte[] AES_Encrypt(String input)
            throws InvalidKeyException,
            BadPaddingException,
            IllegalBlockSizeException {
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] inputBytes = input.getBytes();
        return cipher.doFinal(inputBytes);
    }

     //AES Decryption
     public static String AES_Decrypt(byte[] encryptionBytes)
            throws InvalidKeyException,
            BadPaddingException,
            IllegalBlockSizeException {
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] recoveredBytes = cipher.doFinal(encryptionBytes);
        String recovered      = new String(recoveredBytes);
        return recovered;
    }



}
