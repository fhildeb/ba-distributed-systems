package hash;

import java.util.ArrayList;

public class HashfunctionTest {
	
	public static void main(String[] args) {
		String binaryConcat;
		Integer dezimal;
		Integer crossSum;
		String mystring= "Hallo Welt";
		binaryConcat = createBinaryFromString(mystring);
		dezimal = splitBinToDez(binaryConcat);
		
		System.out.println("\nAlle Teilergebnisse des Strings '" + mystring +" aufaddiert': " + dezimal);
		crossSum = crossSumMethod(dezimal);
		System.out.println("Einstellige Quersumme aus dem gebildeten Hash: " + crossSum);
	}
	
	// Jedes Char in ASCII umwandeln und dann in einen Binärstring
	public static String createBinaryFromString(String text){ 
		char textChar;
		int ascii;
		String binarycode;
		String binarycodeConcat = "";
		System.out.println("\nNun wird eine Bytekette erstellt...");
		for (int i = 0, n = text.length(); i < n; i++ ){
			textChar = text.charAt(i);
			ascii = (int) textChar;
			binarycode = Integer.toBinaryString(ascii);
			binarycodeConcat = binarycodeConcat + binarycode;
			System.out.println("\nCharakter an Stelle [" +i+"]: "+ textChar + "; \nASCII-Code: " + ascii + "; \nBinärcode: " + binarycode + "; \nErstellte Binarykette: " + binarycodeConcat);
		}
		System.out.println("");
		return binarycodeConcat;
	}
	
	// Den Binärstring in Teilstücke der Länge 9 spalten 
	//und für jedes Stück den Dezimalwert berechnen
	public static Integer splitBinToDez(String binaryConcat){ 
		ArrayList<String> binaries = new ArrayList<String>();
		Integer dezimal;
		Integer sumDezimal = 0;
		String splitBinary;
		int index = 0;
		
		while (index < binaryConcat.length()){
			splitBinary = (binaryConcat.substring(index,Math.min(index + 9, binaryConcat.length())));
			binaries.add(splitBinary);
			dezimal = binaryStringToDez(splitBinary); // Aus dem Binärstring eine Dezimalzahl machen
			sumDezimal = sumDezimal + dezimal; // Alle Dezimalzahlen addieren
			index = index + 9;
		}
		
		return sumDezimal;
	}
	
	public static Integer binaryStringToDez(String binaryString){
		Integer index;
		String binaryStringReverse = new StringBuffer(binaryString).reverse().toString(); // von hinten anfangen
		Integer dez;
		Integer dezSum = 0;
		index = 0;
		
		System.out.print("\n-------------------------------");
		System.out.println("\nBinär: " + binaryString+ " (reverse:) " +binaryStringReverse);
		while (index < binaryStringReverse.length()){
			dez = Character.getNumericValue(binaryStringReverse.charAt(index));
			
			System.out.println("Byte aufschlüsseln an Stelle [" + index + "]: "+dez);
			dez = dez * (int)Math.pow(2, index);
			System.out.println("--------> daraus resultierender Wert: "+dez);
			dezSum = dezSum + dez;
			index++;
		}
		System.out.println("Teilergebnis: gewandelte Dezimalsumme aus Byte: " + dezSum);
		System.out.print("-------------------------------\n");
		return dezSum;
	}
	
	public static Integer crossSumMethod(Integer number){
		Integer crossSum = 0;
		while(number > 0){
			crossSum = crossSum + number % 10;
			number = number / 10;
		}
		// Da die Quersumme einstellig sein soll.
			if (crossSum > 9) { 
			crossSum = crossSumMethod(crossSum);
		}
		return crossSum;
	}
}
