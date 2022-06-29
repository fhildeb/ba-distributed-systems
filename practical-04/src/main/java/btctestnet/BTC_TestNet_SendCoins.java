package btctestnet;

import java.io.File;

import org.bitcoinj.core.Address;
import org.bitcoinj.core.AddressFormatException;
import org.bitcoinj.core.Coin;
import org.bitcoinj.core.InsufficientMoneyException;
import org.bitcoinj.core.NetworkParameters;
import org.bitcoinj.core.Transaction;
import org.bitcoinj.core.TransactionConfidence;
import org.bitcoinj.core.listeners.TransactionConfidenceEventListener;
import org.bitcoinj.kits.WalletAppKit;
import org.bitcoinj.params.TestNet3Params;
import org.bitcoinj.wallet.Wallet;
import org.bitcoinj.wallet.listeners.WalletCoinsSentEventListener;

public class BTC_TestNet_SendCoins {

	public static void main(String[] args) {
		
		//Block: 0000000000000138ba4663d05c97af0e04fec8deb476aba6997602eb42bea758
		
		//Testnet Parameter laden
		NetworkParameters params = TestNet3Params.get();
				
		String path = "/Users/fhildebrandt/Documents/Eclipse/CreatedFiles";
		
		//Empfängeradresse aus Faucet
		String forwardingAdressString = "2N1dv1VAi4A1VNwj52u5MKiKLG8LwsmrF7K";
				
		//Betrag
		Coin amountToSend = Coin.parseCoin("0.00001"); 
		
		WalletAppKit kit = new WalletAppKit(params, new File(path), "test-wallet");
		kit.startAsync();
		kit.awaitRunning();
		
		kit.wallet().addTransactionConfidenceEventListener(new TransactionConfidenceEventListener() {
			public void onTransactionConfidenceChanged(Wallet wallet, Transaction tx) {
				System.out.println("-------> Condifidence geändert: " + tx.getHashAsString());
				TransactionConfidence confidence = tx.getConfidence();
				System.out.println("Neue Block Tiefe: "+ confidence.getDepthInBlocks());
			}
		});
		
		kit.wallet().addCoinsSentEventListener(new WalletCoinsSentEventListener() {
			public void onCoinsSent(Wallet w, Transaction tx, Coin prevBalance, Coin newBalance) {
				System.out.println("Gesendete Coins: "+ tx.getHashAsString());
			}
		});
		
		//Wallet ausgeben
		System.out.println("Wallet: " + kit.wallet());
		
		//Senden der Coins
		try {
			Address forwardingAddress = Address.fromBase58(params, forwardingAdressString);
			Wallet.SendResult sendResult = kit.wallet().sendCoins(kit.peerGroup(), forwardingAddress, amountToSend);
			System.out.println("Ergebnis des Sendevorgangs: " + sendResult);
		}catch(AddressFormatException | InsufficientMoneyException e){
			e.printStackTrace();
		}
		
		kit.stopAsync();
		kit.awaitTerminated();
	}
}
