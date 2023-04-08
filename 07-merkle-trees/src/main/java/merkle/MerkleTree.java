package merkle;

import java.nio.charset.Charset;
import java.util.ArrayList;
import com.google.common.hash.Hashing;

public class MerkleTree {
	public ArrayList<String> data;
	public MerkleTree(ArrayList<String> data){
		this.data = data;
	}

	public String getMerkleRoot(){

		// Hilfsliste erzeugen
		ArrayList<String> tempList = new ArrayList<String>();

		// von allen Blaettern die SHA256 Hashes in der Hilfsliste speichern 
		for (int i = 0; i < this.data.size(); i++) {
			tempList.add(Hashing.sha256().hashString(this.data.get(i),Charset.defaultCharset()).toString());
		}

		// die Methode getNewTxList so lange aufrufen, bis im Ergebnis nur noch ein Hash steht
		while (tempList.size() != 1) {
			tempList = getNewTxList(tempList);
		}

		// Merkle Root zurueck liefern
		return tempList.get(0);
	}

	private ArrayList<String> getNewTxList(ArrayList<String> tempTxList) {

		// Rueckgabeliste initialisieren
		ArrayList<String> newTxList = new ArrayList<String>();
		int index = 0;

		// so lange noch Blaetter / Kinder in der Liste sind
		while (index < tempTxList.size()) {
			
			// erstes Blatt / Kind
			String left = tempTxList.get(index);
			index++;

			// zweites Blatt / Kind
			String right = "";
			if (index != tempTxList.size()) {
				right = tempTxList.get(index);
			}

			// den Hash aus beiden Kindelementen bilden und der Rueckgabeliste hinzufuegen
			newTxList.add(Hashing.sha256().hashString(left + right,Charset.defaultCharset()).toString());
			index++;
		}

		return newTxList;
	}	
}