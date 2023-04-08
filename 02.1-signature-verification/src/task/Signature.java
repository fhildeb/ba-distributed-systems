package task;

import java.math.BigInteger;

public class Signature {

	public static void main(String[] args) {
		BigInteger m_check;
		BigInteger p = new BigInteger("61");
		BigInteger q = new BigInteger("53");
		BigInteger phi = new BigInteger("730");
		BigInteger e = new BigInteger("17");
		BigInteger n = p.multiply(q);
		
		BigInteger d = e.modInverse(phi);
		
		System.out.println("n: "+ n);
		System.out.println("phi: "+ phi);
		System.out.println("d: "+ d);
		
		BigInteger m = new BigInteger("5");
		BigInteger signature_p1 = m.pow(d.intValue());
		BigInteger signature = signature_p1.mod(n);
		System.out.println(signature);
		
		m_check = signature.modPow(e, n);
		System.out.println("m: "+m);
		System.out.println("m-check: "+m_check);
		
		if(m_check.equals(m)){
			System.out.println("Signatur stimmt.");
		}
		else {
			System.out.println("Signatur stimmt nicht.");
		}
	}
}

