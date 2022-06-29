package merkle;

import java.nio.charset.Charset;
import java.util.ArrayList;

import com.google.common.hash.Hashing;

public class MerkleTreeTest {

	public static void main(String[] args) {

		// Testtransaktionen
		ArrayList<String> transactions = new ArrayList<String>();
		
		transactions.add("a");
		transactions.add("b");
		transactions.add("c");
		transactions.add("d");
		transactions.add("e");
		transactions.add("f");
		transactions.add("g");
		transactions.add("h");
		
		MerkleTree tree = new MerkleTree(transactions);
		
		String merkleRoot = tree.getMerkleRoot();
		System.out.println("Merkle Root: "+ merkleRoot);


		MerkleTreeWithProof proofTree = new MerkleTreeWithProof(transactions);
		
		int txIndexToProof = 4;

		// Erzeugen des Merkle Path fuer die Transaktion an Position 4
		ArrayList<String> mPath = proofTree.getMerklePath(txIndexToProof);
		System.out.println("Merkle Path: "+ mPath);

		// Test mit enthaltener Transaktion
		String hashToProof = Hashing.sha256().hashString(transactions.get(txIndexToProof),Charset.defaultCharset()).toString();		
		System.out.println("Test mit enthaltener Transaktion: " + checkMerkleProof(mPath,merkleRoot,hashToProof,txIndexToProof));
		
		// Test mit nicht enthaltener Transaktion
		hashToProof = Hashing.sha256().hashString("XX",Charset.defaultCharset()).toString();
		System.out.println("Test mit nicht enthaltener Transaktion: "+ checkMerkleProof(mPath,merkleRoot,hashToProof,txIndexToProof));
		
	}

	public static boolean checkMerkleProof(ArrayList<String> merklePath, String merkleRoot, String hashToProof, int txIndex){

		// fuer jeden Hash im Merkle Path
		for(int i=0; i<merklePath.size(); i++){

			// wenn die Position gerade ist, dann mit dem rechten Kind hashen
			if(txIndex%2==0){
				hashToProof = Hashing.sha256().hashString(hashToProof+merklePath.get(i),Charset.defaultCharset()).toString();
			
			// wenn die Position ungerade ist, dann mit dem linken Kind hashen
			}else{
				hashToProof = Hashing.sha256().hashString(merklePath.get(i)+hashToProof,Charset.defaultCharset()).toString();
			}
			
			// Position aktualisieren
			txIndex = txIndex /2;
		}

		// wenn das neu erzeugte Merkle Root mit dem uebergebenen uebereinstimmt true liefern
		if(hashToProof.equals(merkleRoot)) return true;

		// andernfalls fals
		return false;
	}
}
