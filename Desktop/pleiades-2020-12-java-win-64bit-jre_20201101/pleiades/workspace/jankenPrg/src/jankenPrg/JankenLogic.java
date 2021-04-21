package jankenPrg;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class JankenLogic {
	String result1;
	String result2;
	String result3;
	String result4;
	String result5;

	Map<Integer, String> kekka;
	Map<Integer, String> anata;
	Map<Integer, String> aite;
	int count;
	public void janken(String name, int count) throws UnsupportedEncodingException {
		//じゃんけん処理
		this.kekka = new HashMap<>();
		this.anata = new HashMap<>();
		this.aite = new HashMap<>();
		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		int times = 0;
		for(times = 1 ; times <= count ; times++) {
			System.out.println("じゃんけんの手を入力してください(1:グー、2:チョキ、3:パー)");
			int te = sc.nextInt();
			while(te < 1 || te > 3) {
				System.out.println("じゃんけんの手は1、2、3のいずれかを入力してください。");
				te = sc.nextInt();
			}
			int r = random.nextInt(2);
			++r;
			switch(te) {
			case 1:
				this.anata.put(times, "グー");
				if(r == 1) {
					this.kekka.put(times, "あいこ");
					this.aite.put(times, "グー");
					System.out.println("結果: " + this.kekka.get(times) + " " + name + " : " + this.anata.get(times) + " 相手: " + this.aite.get(times));
				}else if(r == 2) {
					this.kekka.put(times, "あなたの勝ち");
					this.aite.put(times, "チョキ");
					System.out.println("結果: " + this.kekka.get(times) + " " + name + " : " + this.anata.get(times) + " 相手: " + this.aite.get(times));
				}else {
					this.kekka.put(times, "あなたの負け");
					this.aite.put(times, "パー");
					System.out.println("結果: " + this.kekka.get(times) + " " + name + " : " + this.anata.get(times) + " 相手: " + this.aite.get(times));
				}
				break;

			case 2:
				this.anata.put(times, "チョキ");
				if(r == 1) {
					this.kekka.put(times, "あなたの負け");
					this.aite.put(times, "グー");
					System.out.println("結果: " + this.kekka.get(times) + " " + name + " : " + this.anata.get(times) + " 相手: " + this.aite.get(times));
				}else if(r == 2) {
					this.kekka.put(times, "あいこ");
					this.aite.put(times, "チョキ");
					System.out.println("結果: " + this.kekka.get(times) + " " +  name + " : " + this.anata.get(times) + " 相手: " + this.aite.get(times));
				}else {
					this.kekka.put(times, "あなたの勝ち");
					this.aite.put(times, "パー");
					System.out.println("結果: " + this.kekka.get(times) + " " +  name + " : " + this.anata.get(times) + " 相手: " + this.aite.get(times));
				}
				break;

			case 3:
				this.anata.put(times, "パー");
				if(r == 1) {
					this.kekka.put(times, "あなたの勝ち");
					this.aite.put(times, "グー");
					System.out.println("結果: " + this.kekka.get(times) + " " +  name + " : " + this.anata.get(times) + " 相手: " + this.aite.get(times));
				}else if(r == 2) {
					this.kekka.put(times, "あなたの負け");
					this.aite.put(times, "チョキ");
					System.out.println("結果: " + this.kekka.get(times) + " " +  name + " : " + this.anata.get(times) + " 相手: " + this.aite.get(times));
				}else {
					this.kekka.put(times, "あいこ");
					this.aite.put(times, "パー");
					System.out.println("結果: " + this.kekka.get(times) + " " + name + " : " + this.anata.get(times) + " 相手: " + this.aite.get(times));
				}
				break;
			}
		}

		//結果出力
		System.out.println("結果をファイルに出力しますか？(y/n)");
		String hanntei = sc.next();
		if(hanntei.equals("y")) {     //ファイルに出力
			//日付準備
			Calendar cl = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			String str = sdf.format(cl.getTime());

			//ファイル準備
//			File file = new File("/test/" + name + "_" + str + ".txt");
//			try(FileWriter fw = new FileWriter(file, false);
//				BufferedWriter bw = new BufferedWriter(fw);) {
				//anataformat
				int len = name.getBytes("sjis").length-name.length();
				this.result1 = String.format("%-" + (10 - len) + "s", name);
				if(name.length() == 1) {
					this.result1 = String.format("%-10s", name);
				}else if(name.length() == 2){
					this.result1 = String.format("%-10s", name);
				}else if(name.length() == 3){
					this.result1 = String.format("%-10s", name);
				}else if(name.length() == 4) {
					this.result1 = String.format("%-10s", name);
				}else if(name.length() == 5) {
					this.result1 = String.format("%-10s", name);
				}else if(name.length() == 6) {
					this.result1 = String.format("%-10s", name);
				}else if(name.length() == 7) {
					this.result1 = String.format("%-10s", name);
				}else if(name.length() == 8) {
					this.result1 = String.format("%-10s", name);
				}else if(name.length() == 9) {
					this.result1 = String.format("%-10s", name);
				}else {
					this.result1 = String.format("%-10s", name);
				}
				System.out.println("┌──┬─────┬────┬───────┐");
				System.out.printf("│回数│%s│相手    │結果          │\n", this.result1);
				System.out.println("├──┼─────┼────┼───────┤");
				for(times = 1 ; times <= count ; times++) {
					//kaisuuformat
					if(String.valueOf(times).length() == 1) {
						String times1 = String.valueOf(times);
						this.result2 = String.format("%-4s", times1);
					}else {
						String times1 = String.valueOf(times);
						this.result2 = String.format("%-4s", times1);
					}
					//anataformat2
					String anata1 = this.anata.get(times);
					if(anata1.length() == 2) {
						this.result3 = String.format("%-8s", anata1);
					}else {
						this.result3 = String.format("%-7s", anata1);
					}
					//aiteformat
					String aite1 = this.aite.get(times);
					if(aite1.length() == 2) {
						this.result4 = String.format("%-6s", aite1);
					}else {
						this.result4 = String.format("%-5s", aite1);
					}
					//kekkaformat
					String kekka1 = this.kekka.get(times);
					if(kekka1.length() == 6) {
						this.result5 = String.format("%-8s", kekka1);
					}else {
						this.result5 = String.format("%-11s", kekka1);
					}
					System.out.printf("│%s│%s│%s│%s│\n", this.result2, this.result3, this.result4, this.result5);
				}
				System.out.println("└──┴─────┴────┴───────┘");
//				String filename = file.getName();
//				System.out.println("ファイル出力が完了しました[ファイル名:{" + filename + "}]");
				this.aite.clear();
				this.anata.clear();
				this.kekka.clear();
				Continue con = new Continue();
				con.continueLogic(name);
		}else if(hanntei.equals("n")) {
			this.aite.clear();
			this.anata.clear();
			this.kekka.clear();
			Continue con = new Continue();
			con.continueLogic(name);
		}else {
			System.out.println("入力値に誤りがあります。");
		}
	}

//	public Map<Integer, String> getKekka(){
//		return this.kekka;
//	}
//
//	public Map<Integer, String> getAnata(){
//		return this.anata;
//	}
//
//	public Map<Integer, String> getAite(){
//		return this.aite;
//	}
//
//	public int getCount() {
//		return this.count;
//	}
}
