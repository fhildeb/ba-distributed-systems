package btctestnet;

import java.io.File;

import org.bitcoinj.core.Coin;
import org.bitcoinj.core.NetworkParameters;
import org.bitcoinj.core.Transaction;
import org.bitcoinj.kits.WalletAppKit;
import org.bitcoinj.params.TestNet3Params;
import org.bitcoinj.wallet.Wallet;
import org.bitcoinj.wallet.listeners.WalletCoinsReceivedEventListener;

public class BTC_TestNet_ReceiveCoins {

	//	Erster Output:	
		//	Sende Geld an: mu7wJpNEoUspu8GdE8ngPSF8t9fLzbm4dU
		//	Erhaltene Transaktion für 0.0001 BTC :   b281d0ea1d95aa94052ad8c6daf40eb413d778abdde26876012f4a851b7aca59
		//	  updated: 2019-04-26T13:39:17Z
		//	  version 2
		//	  time locked until block 1512508
		//	     in   PUSHDATA(22)[00141a7e8ceff06dc46ca76c7699cd47fc13be0fce61]
		//	          outpoint:c494955f84f970838d214bd165f25fb26558e2aa6e8571b2b7116c688dc8c087:1
		//	          sequence:fffffffe
		//	     out  DUP HASH160 PUSHDATA(20)[95375ebdac677ff408d660d03f2684add2b753eb] EQUALVERIFY CHECKSIG 0.0001 BTC
		//	     out  HASH160 PUSHDATA(20)[c5b850cd04aa5204eaa0cca328e8bff3ffe4a64f] EQUAL 0.01946742 BTC
		//	     prps UNKNOWN
	
	private static WalletAppKit kit;
	private static boolean gotCoins = false;
	
	public static void main(String[] args) throws InterruptedException {
		
		//Testnet Parameter laden
		NetworkParameters params = TestNet3Params.get();
		
		//Erstellen und Starten der Wallet
		String prefix = "test-wallet";
		String path ="/Users/fhildebrandt/Documents/Eclipse/CreatedFiles";
		kit = new WalletAppKit(params, new File(path), prefix);
		kit.startAsync();
		kit.awaitRunning();
		
		//Listener zum erhalten von Coins
		kit.wallet().addCoinsReceivedEventListener(new WalletCoinsReceivedEventListener() {
			public void onCoinsReceived(Wallet w, Transaction tx, Coin prevBalance, Coin newBalance) {
				Coin value = tx.getValueSentToMe(w);
				System.out.println("Erhaltene Transaktion für " + value.toFriendlyString()+" : " +tx);
				gotCoins = true;
			}
		});
		
		//Erstellen einer Adresse
		System.out.println("Sende Geld an: " + kit.wallet().freshReceiveAddress().toString());
		
		//Warten bis Coins vorhanden sind
		while(!gotCoins) {
			Thread.sleep(1000);
		}
		
		//Wallet schließen
		kit.stopAsync();
		kit.awaitTerminated();
	}
}
