package Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class TICTACTOEGAME {
	
	Board GamingBoard;
	Deque<Player> players;
	
	public void initializeGame() throws NumberFormatException, IOException{
		players=new LinkedList<>();
		 BufferedReader br = new BufferedReader(
		            new InputStreamReader(System.in));
		System.out.print("Please Enter the no of Players :");
		int n=Integer.parseInt(br.readLine());
		//System.out.println();
		while(n>3||n<=1) {
			System.out.println("no of players should be less than 3 and greater than zero");
			System.out.print("Please Enter the no of Players :");
			n=Integer.parseInt(br.readLine());
		}
		if(n==2) {
			PlayingPiece playingPieceX=new PlayingPieceX(PlayingPieceType.X);
			Player player1=new Player("Player1",playingPieceX);
			PlayingPiece playingPieceO=new PlayingPieceX(PlayingPieceType.O);
			Player player2=new Player("Player2",playingPieceO);
			players.addFirst(player1);
			players.addFirst(player2);
		}else{
			PlayingPiece playingPieceX=new PlayingPieceX(PlayingPieceType.X);
			Player player1=new Player("Player1",playingPieceX);
			PlayingPiece playingPieceO=new PlayingPieceX(PlayingPieceType.O);
			Player player2=new Player("Player2",playingPieceO);
			PlayingPiece playingPiece$=new PlayingPiece$(PlayingPieceType.$);
			Player player3=new Player("Player3",playingPiece$);
			players.addFirst(player1);
			players.addFirst(player2);
			players.addFirst(player3);
		}
		boolean won=false;
		System.out.print("Enter the board size :");
		int size=Integer.parseInt(br.readLine());
		GamingBoard =new Board(size);
		while(!won) {
			Player player=players.removeLast();
			
			if(!GamingBoard.freecells()) {
				System.out.println("GAME OVER");
				return;
			}
			System.out.print(player.name+" Please enter the row,col :");
			String rowcol=br.readLine();
			String[] pos=rowcol.split(",");
			int row=Integer.parseInt(pos[0]);
			int col=Integer.parseInt(pos[1]);
			if(!GamingBoard.addPiece(row, col, player.playingPiece)){
				players.addLast(player);
			}else {
				GamingBoard.printBoard();
				if(won(row,col,player.playingPiece.playingPieceType)) {
					System.out.println("Game is Won By "+player.name);
					return;
				}
				players.addFirst(player);
			}
		}
		
		
	}
	
	public boolean won(int row,int col,PlayingPieceType playingPieceType){
		boolean rowWon=true;
		boolean colWon=true;
		boolean d1=true;
		boolean d2=true;
		for(int i=0;i<GamingBoard.size;i++) {
			if(GamingBoard.board[row][i]==null || GamingBoard.board[row][i].playingPieceType!=playingPieceType) {
				rowWon=false;
			}
		}
		for(int i=0;i<GamingBoard.size;i++) {
			if(GamingBoard.board[i][col]==null || GamingBoard.board[i][col].playingPieceType!=playingPieceType) {
				colWon=false;
			}
		}
		for(int i=0,j=0;i<GamingBoard.size && j<GamingBoard.size;i++,j++) {
			if(GamingBoard.board[i][j]==null || GamingBoard.board[i][j].playingPieceType!=playingPieceType) {
				d1=false;
			}
		}
		for(int i=0,j=GamingBoard.size-1;i<GamingBoard.size && j>=0;i++,j--) {
			if(GamingBoard.board[i][j]==null || GamingBoard.board[i][j].playingPieceType!=playingPieceType) {
				d2=false;
			}
		}
		
		if(rowWon||colWon||d1||d2) return true;
		return false;
		
	}

}
