package aufgaben;

public class geburtstagsangriff {

	public static void main(String args[]) {
		
		double var2 = 365;
		//a=0.5, b=.0.75, c=0.99
		double p = 0.5;
		double zwischenergebnis = 1;
		double ergebnis=1;
		for(int n=0; ergebnis >= p; n++) {
			zwischenergebnis = ((var2-(n-1))/var2);
			
			ergebnis = ergebnis*zwischenergebnis;
			System.out.println("n: "+n);
			System.out.println("erg: "+ergebnis);
		}
	}
}
