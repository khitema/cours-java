public class Cell {
	private Cell next;
	private final Object data;
	
	public Cell(String s, Cell c) {
		data = s;
		next = c;
	}

	public Object getData() {
		return data;
	}

	public Cell getNext() {
		return next;
	}

	public void setNext(Cell nouv) {
		next = nouv;		
	}	
}
