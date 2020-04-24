package java01.test;

import java.util.Scanner;

public class WorkShopTest3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int rpsn = 0;
		int wincnt = 0;
		int losecnt = 0;
		int com = 0; 
		
		String msg ="###컴퓨터 승!";
		String rps = "";
		
		System.out.println("媛��쐞諛붿쐞蹂� 寃뚯엫�쓣 �떆�옉�빀�땲�떎. �븘�옒 蹂닿린 以� �븯�굹瑜� 怨좊Ⅴ�꽭�슂 \n"
				+ "1. 5�뙋 3�듅 \n"
				+ "2. 3�뙋 2�듅 \n"
				+ "3. 1�뙋 1�듅 \n"
				+ "踰덊샇瑜� �엯�젰�븯�꽭�슂.");
		int selected = sc.nextInt();
	
		switch(selected) {
		case 1:
			for(int i=0; i<5;i++) {
				if (wincnt >=3) {
					msg = "###�쑀�� �듅!";
					break;
				}
				else if (losecnt >=3) break;
				
				System.out.println("媛��쐞諛붿쐞蹂� 以� �븯�굹 �엯�젰:");
				rps = sc.next();
				com = (int) ((Math.random()*3)+1);
				
				if(rps == "媛��쐞" && com == 2) { 
					System.out.println("�씠寃쇱뒿�땲�떎!");
					wincnt++; }
				else if (rps == "諛붿쐞" && com == 3) {
					System.out.println("�씠寃쇱뒿�땲�떎!");
					wincnt++;
				}
				else if (rps =="蹂�" && com == 1) {
					System.out.println("�씠寃쇱뒿�땲�떎!");
					wincnt++;
				}
				else {
					System.out.println("議뚯뒿�땲�떎!");
					losecnt++;
				}
			}
			break;
			
		case 2:
			for(int i=0; i<3;i++) {
				if (wincnt >=2) {
					msg = "###�쑀�� �듅!";
					break;
				}
				else if (losecnt >=2) break;
				
				System.out.println("媛��쐞諛붿쐞蹂� 以� �븯�굹 �엯�젰:");
				rps = sc.next();
				com = (int) ((Math.random()*3)+1);
				if(rps == "媛��쐞" && com == 2) { 
					System.out.println("�씠寃쇱뒿�땲�떎!");
					wincnt++; }
				else if (rps == "諛붿쐞" && com == 3) {
					System.out.println("�씠寃쇱뒿�땲�떎!");
					wincnt++;
				}
				else if (rps =="蹂�" && com == 1) {
					System.out.println("�씠寃쇱뒿�땲�떎!");
					wincnt++;
				}
				else {
					System.out.println("議뚯뒿�땲�떎!");
					losecnt++;
				}
			}
			break;
			
		case 3:
			System.out.println("媛��쐞諛붿쐞蹂� 以� �븯�굹 �엯�젰:");
			rps = sc.next();
			com = (int) ((Math.random()*3)+1);
			if(rps == "媛��쐞" && com == 2) { 
				System.out.println("�씠寃쇱뒿�땲�떎!");
				msg = "###�쑀�� �듅!";
				break;}
			
			else if (rps == "諛붿쐞" && com == 3) {
				System.out.println("�씠寃쇱뒿�땲�떎!");
				msg = "###�쑀�� �듅!";
				break;
			}
			else if (rps =="蹂�" && com == 1) {
				System.out.println("�씠寃쇱뒿�땲�떎!");
				msg = "###�쑀�� �듅!";
				break;
			}
			else {
				System.out.println("議뚯뒿�땲�떎!");
			}
			break;
			
		default:
			System.out.println("�뾾�뒗 踰덊샇�엯�땲�떎.");
		}
		
		System.out.println(msg);
	}
}
