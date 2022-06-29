package parsen;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.bitcoinj.core.Block;
import org.bitcoinj.core.TransactionInput;
import org.bitcoinj.params.MainNetParams;
import org.bitcoinj.utils.BlockFileLoader;

public class Blockparser {

	public static void main(String[] args) 
	{
		MainNetParams params = MainNetParams.get(); //Hauptnetz
		File file = new File("PATH_TO_BITCOIN_BLOCK_FILE");
		List<File> filesList = new ArrayList<File>();
		filesList.add(file);
		BlockFileLoader bfl = new BlockFileLoader(params, filesList);
		Block block = bfl.next(); //1. Block wählen, Datei enthält mehrere Blöcke
		
		System.out.println("Erster Block Hash: " + block.getHashAsString());
		
		System.out.println("Erster Transaktion --Hash:   " + block.getTransactions().get(0).getHashAsString());
		
		int input, output;
		List<TransactionInput> inputKind;
		input = block.getTransactions().get(0).getInputs().size();
		inputKind = block.getTransactions().get(0).getInputs();
		output = block.getTransactions().get(0).getOutputs().size();
		System.out.println("Erster Transaktion --Anzahl Inputs:  " + input +", Art: "+ inputKind);
		System.out.println("Erster Transaktion --Anzahl Outputs: " + output);
		System.out.println("Ist Transaktion Coinbase Transaction?: " + block.getTransactions().get(0).isCoinBase()+"\n");
	}
}
