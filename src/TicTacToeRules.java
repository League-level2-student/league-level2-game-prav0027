
public class TicTacToeRules {

	static int checkForWinner(int[] turns) {
		if(turns[0] == turns[1] && turns[0] == turns[2] && turns[0]!=0) {
			return turns[0];
		}
		else if(turns[3]==turns[4]&&turns[3]==turns[5] && turns[3]!=0) {
			return turns[3];
		}
		else if(turns[6]==turns[7]&&turns[6]==turns[8] && turns[6]!=0) {
			return turns[6];
		}
		else if(turns[0]==turns[3]&&turns[0]==turns[6] && turns[0]!=0) {
			return turns[0];
		}
		else if(turns[1]==turns[4]&&turns[1]==turns[7] && turns[1]!=0) {
			return turns[1];
		}
		else if(turns[2]==turns[5]&&turns[2]==turns[8] && turns[2]!=0) {
			return turns[2];
		}
		else if(turns[0]==turns[4]&&turns[0]==turns[8] && turns[0]!=0) {
			return turns[0];
		}
		else if(turns[2]==turns[4]&&turns[2]==turns[6] && turns[2]!=0) {
			return turns[2];
		}
		else if(turns[0]>0 && turns [1]>0 && turns [2]>0 && turns [3]>0 && turns [4]>0 && turns [5]>0 && turns [6]>0 && turns [7]>0 && turns [8]>0) {
			return 3;
		}
		else return 0;
	}
	
	 
}
