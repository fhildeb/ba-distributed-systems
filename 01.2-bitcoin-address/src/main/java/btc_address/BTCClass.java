package btc_address;

import org.bitcoinj.core.Address;
import org.bitcoinj.core.Base58;
import org.bitcoinj.core.NetworkParameters;
import org.bitcoinj.core.Sha256Hash;
import org.bitcoinj.core.Utils;
import org.bitcoinj.params.MainNetParams;

public class BTCClass {

	private final static NetworkParameters np = MainNetParams.get();
	//private final static Context c = new Context(np);

	public static void main(String[] args) 
	{
		System.out.println("Erfolgreiche Tests:\n");
		testPublicKeyToAddressCalculation1();
		
		System.out.println("\n");
		testPublicKeyToAdressCalculation2();
	}


	public static void testPublicKeyToAddressCalculation1()
	{
		String publicKey = 	"0450863AD64A87AE8A2FE83C1AF1A"+
							"8403CB53F53E486D8511DAD8A0488"+
							"7E5B23522CD470243453A299FA9E7"+
							"7237716103ABC11A1DF38855ED6F2"+
							"EE187E9C582BA6";
							
		publicKey = publicKey.toLowerCase();
		
		// Umwandeln des Strings in HEX-Schreibweise in ein Bytearray. 
		//Die nachfolgende Hashfunktion benötigt den PublicKey in Bytes.
		byte[] publicKeyByte = Utils.HEX.decode(publicKey);
		
		// OP_HASH160 (sha256 then ripemd160) Schritt 2 und 3
		publicKeyByte = Utils.sha256hash160(publicKeyByte);
		System.out.println(Utils.HEX.encode(publicKeyByte));
		
		// Schritt 4, 5, 6, 7, 8, 9 Address add = new Address(np, publicKeyByte);
		Address add = new Address(np, publicKeyByte);
		System.out.println("Die BTC-Adresse: "+add);
		// 16UwLL9Risc3QfPqBUvKofHmBQ7wMtjvM
	}

	public static void testPublicKeyToAdressCalculation2()
	{
		String publicKey = 	"0450863AD64A87AE8A2FE83C1AF1A"+
							"8403CB53F53E486D8511DAD8A0488"+
							"7E5B23522CD470243453A299FA9E7"+
							"7237716103ABC11A1DF38855ED6F2"+
							"EE187E9C582BA6";
		
		
		publicKey = publicKey.toLowerCase();
		byte[] publicKeyByte = Utils.HEX.decode(publicKey);
		//Umwandelnbyte[] publicKeyByte = Utils.HEX.decode(publicKey);
		
		//OP_HASH160
		publicKeyByte = Utils.sha256hash160(publicKeyByte);
		
		System.out.println(publicKeyByte);
		
		//Schritt 3: 00 anfügen
		String hs160 = Utils.HEX.encode(publicKeyByte);
		hs160 = "00" + hs160;
		
		//Schritt 4: sha256
		publicKeyByte = Sha256Hash.hash(Utils.HEX.decode(hs160));
		
		//Schritt 5: sha256 auf vorheriges Ergebnis ausführen
		publicKeyByte = Sha256Hash.hash(publicKeyByte);
		
		//Schritt 6+7: Ersten 4 Byte als Prüfsume
		String tmp = Utils.HEX.encode(publicKeyByte);
		hs160 += tmp.substring(0,8);
		
		//Schritt 8: Base 58 encoding
		System.out.println("Die BTC-Adressse: "+ Base58.encode(Utils.HEX.decode(hs160)));
	}

}

