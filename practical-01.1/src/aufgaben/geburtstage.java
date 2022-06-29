package aufgaben;

public class geburtstage {

	public static void main(String args[]) {
		double var1 = 364, var2 = 365, var3 = var1/var2;
		//a=0.5, b=.0.75, c=0.99
		double p=0.99;
		double ergebnis = 1;
		
		for(int n=0; ergebnis >= p; n++) {
			ergebnis = Math.pow(var3, n);
			System.out.println("n: "+n);
		}
	}
}
