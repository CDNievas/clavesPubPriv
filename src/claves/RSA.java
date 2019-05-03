package claves;

import java.security.*;

import javax.crypto.Cipher;

public class RSA {
	
	public static KeyPair generarKeys() throws NoSuchAlgorithmException{
		
		final int keySize = 2048;
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(keySize);      
        return keyPairGenerator.genKeyPair();
		
	}
	
	public static byte[] encriptar(Key clave, byte [] bytesAEncriptar) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");  
        cipher.init(Cipher.ENCRYPT_MODE, clave);  

        return cipher.doFinal(bytesAEncriptar);  
    }
    
    public static byte[] desencriptar(Key clave, byte [] bytesEncriptados) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");  
        cipher.init(Cipher.DECRYPT_MODE, clave);
        
        return cipher.doFinal(bytesEncriptados);
    }
	
	
}
