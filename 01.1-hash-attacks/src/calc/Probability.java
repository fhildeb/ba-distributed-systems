package calc;

public class Probability {

	public static void main(String args[]) {
		
		double zwischenergebnis, n, wurzel, sekunden, minuten, stunden, tage, jahre, ergebnis;
		n = Math.pow(2, 256);
		n = n- 1;
		
		wurzel = Math.sqrt(n);
		zwischenergebnis = 1.18 * wurzel;
		ergebnis = ((zwischenergebnis / 1000000) / 1000000);
		sekunden = (ergebnis / 1000);
		minuten = (sekunden / 60);
		stunden = (minuten / 60);
		tage = (stunden / 24);
		jahre = (tage / 365);
		
		System.out.print("Der Prozessor würde: "+jahre+ " Jahre benötigen");			
	}
}
