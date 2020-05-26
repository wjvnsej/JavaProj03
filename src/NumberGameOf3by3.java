import java.util.Scanner;

public class NumberGameOf3by3 {

	public static void main(String[] args) {
		while (true) {
			Puzle puzle = new Puzle(4100);
			puzle.start();

			Scanner scan = new Scanner(System.in);
			System.out.println("재시작하시겠습니까?(y 누르면 재시작, 나머지는 종료.)");
			String reStart = scan.nextLine();
			if(reStart.equals("y")) {
				puzle.start();
			}
			else {
				System.exit(0);
			}
		}
	}
} 