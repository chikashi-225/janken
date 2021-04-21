package jankenPrg;

import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class Kaisuu {
	public void kaisuu(String name)throws UnsupportedEncodingException {
		//勝負回数を入力
		Scanner sc = new Scanner(System.in);
		System.out.println("勝負回数を入力してください。（1～20）");
		int count = sc.nextInt();
		while(count <= 0 || count > 20 ) {
			System.out.println("勝負回数は1～20回です。");
			count = sc.nextInt();
		}

		JankenLogic jl = new JankenLogic();
		jl.janken(name, count);
	}
}
