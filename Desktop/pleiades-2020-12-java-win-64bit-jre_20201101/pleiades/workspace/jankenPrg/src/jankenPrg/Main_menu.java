package jankenPrg;

import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class Main_menu {

	public static void main(String[] args) throws UnsupportedEncodingException {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		//�v���C���[������
		System.out.println("�v���C���[������͂��Ă��������B");
		Scanner sc = new Scanner(System.in);
		String name = sc.next();
		while(name == null || name.length() > 10) {
			System.out.println("�v���C���[���́u1�`10���v�œ��͂��Ă��������B");
			name = sc.next();
		}
		//�����񐔓���
		Kaisuu kaisuu = new Kaisuu();
		kaisuu.kaisuu(name);
	}

}
