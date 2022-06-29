package commitment;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.common.hash.Hashing;

public class CommitmentAPI {

	static boolean verify(String com, String key, String msg)
	{
		String hash = Hashing.sha256().hashString(msg+key,Charset.defaultCharset()).toString();
		return (hash.equals(com));
	}
	
	static List<String> commit(String msg)
	{
		List<String> list = new ArrayList<String>();
		
		String key = String.valueOf((int)(Math.random()*100000));
		String hash = Hashing.sha256().hashString(msg+key,Charset.defaultCharset()).toString();
		list.add(hash);
		list.add(key);
			
		return list;
		
	}

	public static void main(String[] args) 
	{
		System.out.println(CommitmentAPI.commit("Hallo"));
		
		System.out.println("Geben Sie COM-KEY-MSG zum Prüfen ein: ");
		Scanner sc = new Scanner(System.in);
		String eingabe = sc.nextLine();
		sc.close();
		String[] split = eingabe.split("-");
		System.out.println(split[0]+" | "+ split[1] +" | "+ split[2]);
		System.out.println(verify(split[0], split[1], split[2]));
	}
}
