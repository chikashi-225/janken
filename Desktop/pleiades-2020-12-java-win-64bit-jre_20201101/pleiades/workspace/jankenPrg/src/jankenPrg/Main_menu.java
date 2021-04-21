package jankenPrg;

import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class Main_menu {

	public static void main(String[] args) throws UnsupportedEncodingException {
		// TODO 自動生成されたメソッド・スタブ
		//プレイヤー名入力
		System.out.println("プレイヤー名を入力してください。");
		Scanner sc = new Scanner(System.in);
		String name = sc.next();
		while(name == null || name.length() > 10) {
			System.out.println("プレイヤー名は「1～10桁」で入力してください。");
			name = sc.next();
		}
		//勝負回数入力
		Kaisuu kaisuu = new Kaisuu();
		kaisuu.kaisuu(name);
	}

}
