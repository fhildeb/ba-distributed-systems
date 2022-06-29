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
