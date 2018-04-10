package password_demo;

import java.security.InvalidKeyException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;

public class TWFirstHybrid {
    private static String decryptedHybridText;

    public static void setUp() throws Exception {
        TripleDES.setUp();
        RC4.setUp();
    }
    public static byte[] HybridEncryption(String input) throws InvalidKeyException, BadPaddingException, IllegalBlockSizeException{

        byte[] encryptionBytes = null;

        //3DES Related
        try {            
            encryptionBytes = TripleDES.DES_Encrypt(input);
            } catch (InvalidKeyException ex) {
                Logger.getLogger(TWFirstHybrid.class.getName()).log(Level.SEVERE, null, ex);
            } catch (BadPaddingException ex) {
                Logger.getLogger(TWFirstHybrid.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalBlockSizeException ex) {
                Logger.getLogger(TWFirstHybrid.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NullPointerException ex) {
                Logger.getLogger(TWFirstHybrid.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            //Encrypt with RC4 and Return (Reference: RC4.java)
            return (RC4.RC4_Encrypt(encryptionBytes.toString()));
        }

    public static String HybridDecryption(byte[] inputEncryptedByte) throws InvalidKeyException, BadPaddingException, IllegalBlockSizeException{

        //RC4 Decryption
        String rc4DecryptedText = RC4.RC4_Decrypt(inputEncryptedByte);

        //3DES Related
        try {
            decryptedHybridText = TripleDES.DES_Decrypt(rc4DecryptedText.getBytes());
            } catch (InvalidKeyException ex) {
                Logger.getLogger(TWFirstHybrid.class.getName()).log(Level.SEVERE, null, ex);
            } catch (BadPaddingException ex) {
                Logger.getLogger(TWFirstHybrid.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalBlockSizeException ex) {
                Logger.getLogger(TWFirstHybrid.class.getName()).log(Level.SEVERE, null, ex);
            }catch (NullPointerException ex) {
                Logger.getLogger(TWFirstHybrid.class.getName()).log(Level.SEVERE, null, ex);
            }
        return decryptedHybridText;

        }

    }
