import java.util.*;
import java.io.*;
import java.lang.Math;

public class CacheSimulator {

	public static void main(String[] args) {
		long w,c,b,k, number;
		String bi;
		double tag,index,offset;
		Scanner kb=new Scanner(System.in);
		Scanner myReader = null;
		int elements=0;
		Stack<String> stack = new Stack<String>();
	
		
			try {
					File myObj = new File("15-ao491.in");
				    myReader = new Scanner(new FileInputStream(myObj));
				    w = Long.parseLong(myReader.next());
				    c = Long.parseLong(myReader.next());
				    b = Long.parseLong(myReader.next());
				    k = Long.parseLong(myReader.next());
				    System.out.println(w +" "+ c + " " + b + " " + k);
				   
					index = (Math.log(c/b))/(Math.log(2));
					offset = (Math.log(b/k))/(Math.log(2));
					tag = w - (index + offset);
					
					System.out.println("Number of bits for offset: " + (int)offset);
					System.out.println("Number of bits for index: " + (int)index);
					System.out.println("Number of bits for tag: " + (int)tag);
					
				    while (myReader.hasNextLine()) {
				    number = Long.parseLong(myReader.next());
				    bi = Long.toBinaryString(number);
				    bi = toBinary(bi,w);
				    elements++;
					//System.out.println(bi);
					if(stack.search(bi.substring(0,(int)(tag+index))) == -1 || stack.empty()) {
						stack.push(bi.substring(0,(int)(tag+index)));
						System.out.println("M");
						
					}
					else 
						System.out.println("C");
					
			    }
				    System.out.println(elements);
			   
				    myReader.close();
			
			} catch (FileNotFoundException e) {
					System.out.println("An error occurred.");
					e.printStackTrace();
			  }
			System.out.println("Done");
		
	}

	public static String toBinary(String n, Long w) {
		
		if (n.length() == w)
			return n;
		else {
			while(n.length() < w)
				n="0"+n;
			return n;
		}
	}
}

