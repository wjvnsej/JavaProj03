
import java.util.Objects;
import java.util.Scanner;

interface puzVal {
	String ONE = "1", TWO = "2", THREE = "3", FOUR = "4", FIVE = "5",
			SIX = "6", SEVEN = "7", EIGHT = "8", X = "X"; 
	
	String [][] PUZ_ORIGIN = {
			{ONE, TWO, THREE},
			{FOUR, FIVE, SIX},
			{SEVEN, EIGHT, X}
	};
}

public class Puzle implements puzVal {
	int i = 2, j = 2;
	String Change;
	String [][] puz = {
			{ONE, TWO, THREE},
			{FOUR, FIVE, SIX},
			{SEVEN, EIGHT, X}
	};
	
	public Puzle(int num) {
		int shu_num = 0;
		while (shu_num < num) {
			int rnd = (int)(Math.random() * 4)+1;
			switch (rnd) {
			//up
			case 1:
				if(i == 2) {
					down();
					break;
				}
				Change = puz[++i][j];
				puz[--i][j] = Change;
				puz[++i][j] = X;
				break;
			//down
			case 2:
				if(i == 0) {
					up();
					break;
				}
				Change = puz[--i][j];
				puz[++i][j] = Change;
				puz[--i][j] = X;
				break;
			//left
			case 3:
				if(j == 2) {
					right();
					break;
				}
				Change = puz[i][++j];
				puz[i][--j] = Change;
				puz[i][++j] = X;
				break;
			//right
			case 4:
				if(j == 0) {
					left();
					break;
				}
				Change = puz[i][--j];
				puz[i][++j] = Change;
				puz[i][--j] = X;
				break;
			}
			shu_num ++;
		}
	}
	
	public void showpuz() {
		System.out.println("--------");
		for(int i=0;i<puz.length;i++) {
			for(int j=0;j<puz[i].length;j++) {
				System.out.printf("%-3s",puz[i][j]);
			}
			System.out.println();
		}
		System.out.println("--------");
	}
	
	public void start() {
		Scanner scan = new Scanner(System.in);
		System.out.println("**퍼즐게임을 시작합니다.**");
		while(!(Objects.deepEquals(puz, PUZ_ORIGIN))) {
			showpuz();
			System.out.println
				("[ 이동 ] 'w' : UP, 's' : DOWN, 'a' : LEFT, 'd' : RIGHT");
			System.out.println("[ 종료 ] x : EXIT");
			System.out.println("선택>> ");
			String move = scan.nextLine();
			
			switch (move) {
			case "w":
				up();
				break;
			case "s":
				down();
				break;
			case "a":
				left();
				break;
			case "d":
				right();
				break;
			case "x":
				System.out.println("프로그램을 종료합니다.");
				return;
			}
			
		}
		System.out.println("정답입니다!!");
		showpuz();
		
	}
	
	public void up() {
					
		if(puz[2][j] == X){
			System.out.println("위로 움직일 수 없습니다.");
			return;
		}
		Change = puz[++i][j];
		puz[--i][j] = Change;
		puz[++i][j] = X;
		return;
	}
	
	public void down() {
		if(puz[0][j] == X){
			System.out.println("아래로 움직일 수 없습니다.");
			return;
		}
		Change = puz[--i][j];
		puz[++i][j] = Change;
		puz[--i][j] = X;
		return;
	}
	public void left() {
		if(puz[i][2] == X){
			System.out.println("왼쪽으로 움직일 수 없습니다.");
			return;
		}
		Change = puz[i][++j];
		puz[i][--j] = Change;
		puz[i][++j] = X;
		return;
	}
	public void right() {
		if(puz[i][0] == X){
			System.out.println("오른쪽으로 움직일 수 없습니다.");
			return;
		}
		Change = puz[i][--j];
		puz[i][++j] = Change;
		puz[i][--j] = X;
		return;
	}
	
	
}
