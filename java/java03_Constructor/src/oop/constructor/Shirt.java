package oop.constructor;
/*
 * Default Constructor:
 * 1. ���ڰ��� ���� ������
 * 2. �����ο��� �ƹ��� �ϵ� ���� �ʴ� ������
 */
public class Shirt {
	public String maker;//�⺻���� ������...null
	public boolean longSleeved;
	public char color;
	
	public Shirt(){}//Default Constructor
	public Shirt(String m, boolean longs, char c){
		//
		maker = m;
		longSleeved = longs;
		color = c;
	}
	public String getDetails() { //worker method=�����ΰ� �ִ� �޼ҵ�
		return maker+", "+longSleeved+","+color;
	}
}










