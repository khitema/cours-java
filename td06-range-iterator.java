public class Range {
	public static Iterator<Integer> methode1(final int start, final int end) {
		return new Iterator<Integer>() {
			int i=start;
			@Override
			public boolean hasNext() {
				return i<=end;
			}

			@Override
			public Integer next() {
				if(!hasNext()) throw new NoSuchElementException();
				return i++;
			}
		};
	}
	
	public static Iterable<Integer> methode2(final int start, final int end) {
		return new Iterable<Integer>() {
			
			@Override
			public Iterator<Integer> iterator() {
				return methode1(start, end);
			}
		};
	}
		
	public static List<Integer> range(final int start, final int end) {
		if(start>end) throw new IllegalArgumentException();
		return new AbstractList<Integer>() {
			@Override
			public int size() {
				return end-start+1;
			}

			@Override
			public Integer get(int index) {
				return start+index;
			}
			
			//he oui !
			@Override
			public Iterator<Integer> iterator() {
				return methode1(start, end);
			}
		};
	}

	public static void main(String[] args) {
		Iterator<Integer> it0=methode1(1,5);
		for(;it0.hasNext();)
			System.out.println(it0.next()); // affiche 1 2 3 4 5
		
		for(int i:methode2(1,5))
			System.out.println(i); // affiche 1 2 3 4 5
		
		//List<Integer> li = range(3,1);//UAE!
		List<Integer> li = range(-2,2);//UAE!
		System.out.println(li);
		System.out.println(li.size());//attention, doit renvoyer 5 !!!
		
		List<Integer> l = range(1,5);
		System.out.println(l);
		System.out.println(l.size());
		
	    System.out.println("--");
	    Iterator<Integer> it = range(2,2).iterator();
	    System.out.println(it.next());
	    System.out.println(it.next());
	    System.out.println(it.next());
	  
	}
}
