public class MyList {
	private Cell first = null;
	private int size;

	public void add(String s) {
		Cell c = new Cell(s, first);
		first = c;
		size++;
	}
	
	public void addLast(String s) {
		Cell nouv = new Cell(s, null);
		if(first==null) {
			first = nouv;
			size++;
			return;
		}
		Cell it = first;
		for(int i=0; i<size-1 ; ++i) {
			it = it.getNext();
		}
		it.setNext(nouv);
		size++;
	}

	public int size() {
		//faire un parcours serait en O(n) !
		return size;
	}

	public Object get(int ind) {
		if(ind>=size || ind<0) throw new IndexOutOfBoundsException();
		Cell it = first;
		for(int i=0; i<ind ; ++i) {
			it = it.getNext();
		}
		return it.getData();
	}

	public boolean contains(Object o) {
		Cell tmp = first;
		while(tmp != null) {
			if(tmp.getData().equals(o))
				return true;
			tmp = tmp.getNext();
		}
		return false;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Cell it = first;

		for(int i=0;i<size;++i) {
			sb.append(it.getData()).append(" ");
			it = it.getNext();
		}

		return sb.toString();
	}
	
		public int sumLetter() {
		int sum=0;
		Cell it=first;
		for(int i=0 ; i<size ; ++i) {
			String s = (String)it.getData();
			sum += s.length();
			it.getNext();
		}
		return sum;
	}

	public static void main(String[] args) {
		MyList ml = new MyList();
		ml.addLast("tatu");
		ml.add("toto");
		ml.add("titi");
		ml.addLast("tutu");
		System.out.println(ml);
	}
}

