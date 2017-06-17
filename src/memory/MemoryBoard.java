package memory;





import pair.Pair;
import pair.PairSequence;

public class MemoryBoard {
	int size;
	MemoryCardImage [][]board;
	private String backFileName;
	private String[] frontFileNames;
	private boolean [][]booleanMatrix;
	//private MemoryBoard brad;
	//private MemoryCardImage turn = new MemoryCardImage[][];
	
	/** Skapar ett memorybräde med size * size kort. backFileName är filnamnet 
	    för filen med baksidesbilden. Vektorn frontFileNames innehåller filnamnen 
	    för frontbilderna. */
	public MemoryBoard(int size, String backFileName, String[] frontFileNames) {
		this.size = size;
		board = new MemoryCardImage [size][size];
		this.frontFileNames = frontFileNames;
		this.backFileName = backFileName;
		createCards (backFileName, frontFileNames);
		booleanMatrix = new boolean [size][size];
	}
	
	/* Skapar size * size / 2 st memorykortbilder.
	   Placerar ut varje kort på två slumpmässiga ställen på spelplanen. */
	private void createCards(String backFileName, String[] frontFileNames) {
	PairSequence p = new PairSequence(size, size);
	for (int i = 0; i < frontFileNames.length; i++){
		Pair par = p.pick();
		int r1 = par.first();
		int c1 = par.second();
		board[r1][c1]=new MemoryCardImage(frontFileNames[i], backFileName);
		
		Pair par2 = p.pick();
		int r2 = par2.first();
		int c2 = par2.second();
		board[r2][c2]= board [r1][c1];
	}
	
	}
		/**MemoryCardImage [] myCards = new MemoryCardImage[frontFileNames.length];
		for (int n = 0; n < myCards.length; n++){
			myCards [n] = new MemoryCardImage(frontFileNames[n], backFileName);
			}
		int i = 0;
		int a = 0;
		int rand1 = rand.nextInt(size);
		int rand2 = rand.nextInt(size);
		while(i < myCards.length && a < 2){
			if(board[rand1][rand2]==null){
				board[rand1][rand2] = myCards[i];
				i++;
				if(i == myCards.length){
					i = 0;
					a++;
				}
			}else{
				rand1 = rand.nextInt(size);
				rand2 = rand.nextInt(size);
			}
			}
		}*/
		
		

		

	

	/** Tar reda på brädets storlek. */
	public int getSize() {
		return size;
	}
	
	/** Hämtar den tvåsidiga bilden av kortet på rad r, kolonn c.
	    Raderna och kolonnerna numreras från 0 och uppåt. */
	public MemoryCardImage getCard(int r, int c) {
		return board[r][c];
	}

	/** Vänder kortet på rad r, kolonn c. */
	public void turnCard(int r, int c) {
		if (booleanMatrix[r][c]==true){
			booleanMatrix[r][c] = false;
		}else{
			booleanMatrix[r][c] = true;
				
		}
		//booleanMatrix[r][c] = !booleanMatrix[r][c]; alternativ kortare kod
	}
	
	/** Returnerar true om kortet r, c har framsidan upp. */
	public boolean frontUp(int r, int c) {
		if(booleanMatrix [r][c]==true){// alt return booleanMatrix[r][c];
		return true;
		}
		return false;
	}
	
	
	/** Returnerar true om det är samma kort på rad r1, kolonn c2 som på rad r2, 
	    kolonn c2. */
	public boolean same(int r1, int c1, int r2, int c2) {
		if (board [r1][c1] == board [r2][c2]){
			return true;
		}
			return false;
		}
	
	/** Returnerar true om alla kort har framsidan upp. */
	public boolean hasWon() {
		for (int q = 0; q < board.length; q++){
			for (int s = 0; s < board.length; s++){
				if (booleanMatrix [q][s]== false){
					return false;
				}
			}
		}
		return true;
				}	
		}
	

