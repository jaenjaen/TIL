package array.test1;

public class ArrayBasicTest1 {

	String type = "배열";
	public String type() {
		return type;
	}
	public static void main(String[] args) {
		
		//ArrayExam exam = new ArrayExam();
		//1. 선언과 생성
		int[] arr = new int[3];//객체

/*		for(int i=0; i<arr.length;i++) { //length는 함수 아님
			System.out.println("Defalut Balude :: "+arr[i]);
		}
*/
		//향상된 for문 x가 y안에서 돌아가는 것만 생각하면 됨
		for(int p : arr) {
			System.out.print(p + " ");
		}
		System.out.println("\n");
		
		//System.out.println("\n"+exam); // array.test1에있는 array Exam의 주소는 ******이다. (골뱅이 뒤의 숫자가 주소값)
		//System.out.println("\n"+exam.tostring()); // 위와 동일 결과 (tostring이 생략되는 것)
		System.out.println(arr);
		
		//2. 배열의 초기화
		arr[0] = 11;
		arr[1] = 22;
		arr[2] = 33;
		
		for(int p: arr) {
			System.out.print(p+" ");
		}
		
		
		//3. 선언 생성 초기화 한번에
		
		int[] arr2 = {11,22,33};
		for(int p:arr2) {
			System.out.print(p+" ");
		}
		System.out.println();
		//4.배열 크기 확인
		System.out.printf("배열의 크기는: %d \n",arr2.length);
		
		//5.배열 확대? -> 배열은 추가 resizing 불가 사이즈 변경시 새로운 객체가 생성됨
		
		
		arr2 = new int[5]; 
		arr2[3] = 44; arr2[4] =55;
		for(int p:arr2) {
			System.out.print(p+" ");
		}
	}

}
