package oop.greet;

/* EncoreGreet Ŭ������ �뵵
 * EncoreGreet ��
 * Ecore �������� �������鿡�� ���ϴ� �λ縻�� �����ϰ� �ִ� Ŭ���� 
 */
public class EncoreGreet {
	//var : Field - saved value
	public String name = "James"; // initialization
	public String message = "Hello! Gday mate!";
	
	//add filed
	public int classRoom;
	public String subject;
	

	//method (���)
	public void sayHello(){
		System.out.println(name+","+message); 
	}
	//�޼ҵ� �߰�
	public String getEncore() {
		return name+"\t"+message+"\t"+classRoom+"\t"+subject;
	}
	
	//�Լ��߰�.. �������� ���� �ѹ��� �ʵ忡 �����ϴ� ����� ����
	//�޼ҵ� ���� = �޼ҵ弱��� + �޼ҵ� ������
	public void setEncore(String n, String m, int c, String s) {
		name = n;
		message = m;
		classRoom = c;
		subject = s;
	}
}
