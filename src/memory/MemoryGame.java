package memory;

public class MemoryGame {
	
	public static void main(String[] args) {
		String[] frontFileNames = {"can.jpg", "flopsy_mopsy_cottontail.jpg",
				"friends.jpg", "mother_ladybird.jpg", "mr_mcgregor.jpg",
				"mrs_rabbit.jpg", "mrs_tittlemouse.jpg", "radishes.jpg" };
	
	MemoryBoard mb = new MemoryBoard (4, "back.jpg", frontFileNames);
	MemoryWindow w = new MemoryWindow (mb);
	w.drawBoard();
	int tries = 0;

	while (!mb.hasWon()){
		w.waitForMouseClick();
		while(mb.frontUp(w.getMouseRow(), w.getMouseCol())){
			w.waitForMouseClick();
		}
		int row = w.getMouseRow();
		int cols = w.getMouseCol();
		if(!(mb.frontUp(row, cols))){
			mb.turnCard (row, cols);
			w.drawCard(row, cols);
			}
		w.waitForMouseClick();
		
		while(mb.frontUp(w.getMouseRow(), w.getMouseCol())){
			w.waitForMouseClick();
		}
		int row2 = w.getMouseRow();
		int cols2 = w.getMouseCol ();
		if(!mb.frontUp(row2, cols2)){
			mb.turnCard(row2, cols2);
			w.drawCard(row2, cols2);
		}
		
		if (!(mb.same(row, cols, row2, cols2))){
			w.delay(2000);
			mb.turnCard(row, cols);
			w.drawCard(row, cols);
			mb.turnCard(row2, cols2);
			w.drawCard(row2, cols2);
			tries++;
			}
	}
		if(mb.hasWon()){
			System.out.println("Det krävdes"+ ( tries + 8) +"försök.");
		}
	}
}

			
		
		
	
	
	

	
	
		

