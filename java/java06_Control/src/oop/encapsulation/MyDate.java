package oop.encapsulation;
/*
 * �� ���� �Է�
 * ��¥�Է�
 */
public class MyDate {
	public int month;
	public int day;
	
	public int getMonth() {
		return month;
	}
	//���ú����� �ʵ��� �̸��� ������ �����ϱ� ���ؼ� �ʵ�տ� this�� �����Ѵ�.
	public void setMonth(int month) {
		if (month<1 || month>12) {
			System.out.println("�������� �ʴ� ���Դϴ�.");
			System.exit(0); //���α׷� Ż�� ���⼭ ���α׷� ���� �ȵǴ� ���� : ��ĳ�ʰ� �ȴ�����
		}
		else this.month = month;
	}
	
	public int getDay() {
		return day;
	}
	
	public void setDay(int day) {
		switch(month) {
		case 2:
			if(day>=1 && day<=28) this.day = day;
			else {
				System.out.println("�������� �ʴ� ���Դϴ�.");
				System.exit(0); // �ʵ� �ʱ�ȭ�� ���� == 0���� ��ȯ
				}
			break;
		case 4: case 6: case 9: case 11:
			if(day>=1 && day<=30) this.day = day;
			else{
				System.out.println("�������� �ʴ� ���Դϴ�.");
				System.exit(0); // �ʵ� �ʱ�ȭ�� ���� == 0���� ��ȯ
				}
			break;
		default :
			if(day>=1 && day<=28) this.day = day;
			else{
				System.out.println("�������� �ʴ� ���Դϴ�.");
				System.exit(0); // �ʵ� �ʱ�ȭ�� ���� == 0���� ��ȯ
				}
		}
	}	
}
