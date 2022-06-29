package rsa;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Scanner;

import javax.crypto.Cipher;

public class Rsa {
    
    public static void main(String [] args) throws Exception {
        // generate public and private keys
        KeyPair keyPair = buildKeyPair();
        PublicKey pubKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();
        
        System.out.println("Geben sie ihre geheime Botschaft ein:");
        @SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String eingabe = sc.nextLine();
        
		System.out.println("ergiebt diesen RSA-Output: ");
        // sign the message
        byte [] signed = encrypt(privateKey, eingabe);     
        System.out.println(new String(signed));
        
        System.out.println("Wollen Sie den RSA-Output entschlüsseln? y/n");
        eingabe = sc.nextLine();

		if(eingabe.equalsIgnoreCase("y"))
			{
	        byte[] verified = decrypt(pubKey, signed);                                 
	        System.out.println("Nachricht lautete: " + new String(verified)); 
		}
		else {
			System.out.println("Ok, dann eben nicht");
		}
    }

    public static KeyPair buildKeyPair() throws NoSuchAlgorithmException {
        final int keySize = 2048;
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(keySize);      
        return keyPairGenerator.genKeyPair();
    }

    public static byte[] encrypt(PrivateKey privateKey, String message) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");  
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);  

        return cipher.doFinal(message.getBytes());  
    }
    
    public static byte[] decrypt(PublicKey publicKey, byte [] encrypted) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");  
        cipher.init(Cipher.DECRYPT_MODE, publicKey);
        
        return cipher.doFinal(encrypted);
    }
}
