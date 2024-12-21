package Model;

public class Board {

	public int size;
	public PlayingPiece[][] board;
	
	public Board(int size) {
		this.size=size;
		board=new PlayingPiece[size][size];
	}
	
	public boolean addPiece(int i,int j,PlayingPiece playingPiece){
		if(board[i][j]==null) {
			board[i][j]=playingPiece;
			return true;
		}else {
			return false;
		}
	}
	
	public boolean freecells() {
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				if(board[i][j]==null) return true;
			}
		}
		return false;
	}
	
	public void printBoard() {
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				if(board[i][j]!=null)System.out.print(board[i][j].playingPieceType+" |");
				else System.out.print("    |");
			}
			System.out.println();
		}
	}
}
