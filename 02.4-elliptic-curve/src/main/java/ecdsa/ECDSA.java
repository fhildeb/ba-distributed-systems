package ecdsa;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.Security;
import java.security.Signature;
import java.security.SignatureException;
import org.bouncycastle.jce.ECNamedCurveTable;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.spec.ECParameterSpec;

public class ECDSA {

	public static void main(String[] args) throws Exception{
		Security.addProvider(new BouncyCastleProvider());
		String plaintext = "Das ist die Nachricht";
		KeyPair keys = GenerateKeys();
		System.out.println(keys.getPublic().toString());
		System.out.println(keys.getPrivate().toString());
		byte[] signature = GenerateSignature(plaintext, keys);
		boolean isValidated = ValidateSignature(plaintext, keys, signature);
		System.out.println("Result: " + isValidated);
	}
	
	public static byte[] GenerateSignature(String plaintext, KeyPair keys) throws SignatureException, 
	UnsupportedEncodingException, InvalidKeyException, NoSuchAlgorithmException, NoSuchProviderException{
		Signature ecdsaSign = Signature.getInstance("SHA256withECDSA", "BC");
		ecdsaSign.initSign(keys.getPrivate());
		ecdsaSign.update(plaintext.getBytes("UTF-8"));
		byte[] signature = ecdsaSign.sign();
		System.out.println(signature.toString());
		return signature;
	}
	
	public static boolean ValidateSignature(String plaintext, KeyPair pair, byte[] signature) throws SignatureException, 
	InvalidKeyException, UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchProviderException{
		Signature ecdsaVerify = Signature.getInstance("SHA256withECDSA", "BC");
		ecdsaVerify.initVerify(pair.getPublic());
		ecdsaVerify.update(plaintext.getBytes("UTF-8"));
		return ecdsaVerify.verify(signature);
	}
	
	public static KeyPair GenerateKeys() throws NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException{
		// Für eine ECD-Signatur muss eine entsprechende Ellipitsche Kurve gewählt werden.
		ECParameterSpec ecSpec = ECNamedCurveTable.getParameterSpec("B-571"); 
		// Weitere Kurven sind hier zu finden: http://www.bouncycastle.org/wiki/display/JA1/Supported+Curves+%28ECDSA+and+ECGOST%29
		KeyPairGenerator g = KeyPairGenerator.getInstance("ECDSA", "BC");
		g.initialize(ecSpec, new SecureRandom());
		return g.generateKeyPair();
	}	

}
