package merkle;

import java.nio.charset.Charset;
import java.util.ArrayList;

import com.google.common.hash.Hashing;

public class MerkleTreeWithProof {

	public ArrayList<String> data;

	public MerkleTreeWithProof(ArrayList<String> data){
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

	public ArrayList<String> getMerklePath(int txIndex) {

		// Rueckgabe erzeugen
		ArrayList<String> merklePath = new ArrayList<String>();

		// Hilfsliste erzeugen
		ArrayList<String> tempList = new ArrayList<String>();

		// von allen Blaettern die SHA256 Hashes in der Hilfsliste speichern 
		for (int i = 0; i < this.data.size(); i++) {
			String txHashatPos = Hashing.sha256().hashString(this.data.get(i),Charset.defaultCharset()).toString();

			// wenn Position gerade dann den rechten Nachbarn dem Pfad hinzufügen
			if(txIndex%2==0 && i==txIndex+1)
				merklePath.add(txHashatPos);

			// wenn Position ungerade dann den linken Nachbarn dem Pfad hinzufügen
			if(txIndex%2==1 && i==txIndex-1)
				merklePath.add(txHashatPos);

			tempList.add(txHashatPos);
		}

		// Hilfsvariable zur Bestimmung der Postion des benoetigten Hashes 
		// in der naechsten Ebene des Baums
		int hashIndex = txIndex/2;

		// die Methode getNewTxList so lange aufrufen, bis im Ergebnis nur noch ein Hash steht
		while (tempList.size() != 1) {
			tempList = getNewTxList(tempList);

			// wenn noch nicht an der Wurzel
			if(tempList.size()>1){

				// wenn Position gerade dann den rechten Nachbarn dem Pfad hinzufügen
				if(hashIndex%2==0) {
					merklePath.add(tempList.get(hashIndex+1));

				// wenn Position ungerade dann den linken Nachbarn dem Pfad hinzufügen
				} else {
					merklePath.add(tempList.get(hashIndex-1));
				}
				// Position des Hashes in der naechsten Baumebene bestimmen
				hashIndex = hashIndex / 2;
			}
		}

		return merklePath;
	}

}