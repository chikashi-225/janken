package jankenPrg;

import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class Continue {
	public void continueLogic(String name) throws UnsupportedEncodingException {
		Scanner sc = new Scanner(System.in);
		System.out.println("再チャレンジを行いますか？(y/n)");
		String tyarenzi = sc.next();
		if(tyarenzi.equals("y")) {
			Kaisuu kaisuu = new Kaisuu();
			kaisuu.kaisuu(name);
		}else if(tyarenzi.equals("n")) {
			System.out.println("お疲れさまでした。またの機会をお待ちしております。");
		}else {
			System.out.println("入力値に誤りがあります。");
		}
	}
}
