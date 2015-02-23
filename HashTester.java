import java.lang.*;
import java.util.*;
public class HashTester{
	private LinkedList_t [] hash;
	private LinkedList_t [][] doubleHasher;
	private int size;
	private int capacity;
	private int dcap;
	public HashTester(int cap){
		if(cap == (26*26)){
			doubleHasher = new LinkedList_t [26][26];
        		capacity = 26*26;
         		for(int i = 0;i<doubleHasher.length;i++){
        			for(int j =0;j<doubleHasher[i].length;j++){
            				doubleHasher[i][j] = new LinkedList_t();
                			size++;
                		}
         		}
		}
		else{
        		hash = new LinkedList_t [cap];
         		capacity = cap;
         		for(int i = 0;i<hash.length;i++){
            			hash[i] = new LinkedList_t();
            			size++;
         		}
      		}
   	}
	public int getSize(){
		return size;
	}
	public int getCapacity(){
		return capacity;
	}
	public LinkedList_t [] getHash(){
		return hash;
	}
	public LinkedList_t[][] getdoubleHasher(){
		return doubleHasher;
	}
	public static void main(String [] args){
		HashTester minihash = new HashTester(26);
		ArrayList<String> arrayList = new ArrayList<String>();
		HashTester Bighash = new HashTester(26*26);
		HashTester superhash = new HashTester(10000);
		int position1,position2,position3,totalB,totalBB,totalS;
    		char positionM,positionB,positionBs,positionS,positionSS;
   		int sizeM = 0;
   		int sizeB = 0;
   		int sizeS = 0;
   		String itemL;
   		Scanner scan = new Scanner(System.in );
   		while(scan.hasNext()){
   			itemL  = scan.nextLine();
   			itemL = itemL.toLowerCase();
   			arrayList.add(itemL);
   		}
   		int subtotoal = 0;
   		for(int i = 0;i<arrayList.size();i++){
   			String data = arrayList.get(i);
   			positionM  = data.charAt(0);
   			position1  = (int)positionM;
   			position1 %= 26;
   			minihash.hash[position1].insertInOrder(data);
   			System.out.printf("%d%s%s%s\n" , i," ", data," TRUE");
   			sizeM++;
   		}
		for(int i = 0;i<arrayList.size();i++){
            		String data = arrayList.get(i);
            		if(data.length()>2){
				positionB  = data.charAt(0);
				positionBs = data.charAt(1);
                  		position1  = (int)positionB;
				position2  = (int)positionBs;
                  		totalB = position1;
				totalBB = position2;
				totalB %= 26;
				totalBB %= 26;
                  		if((totalB >=0 && totalB>26) && (totalBB >=0 && totalBB>26) ){
                        		Bighash.doubleHasher[totalB][totalBB].insertInOrder(data);
					System.out.printf("%d%s%s%s\n" , i," ", data," TRUE");
                        		sizeB++;
                  		}
			}
			if(data.length()<2){
				positionB  = data.charAt(0);
               			position1  = (int)positionB;
               			totalB = position1;
               			totalB %= 26;
               			Bighash.doubleHasher[totalB][0].insertInOrder(data);
				System.out.printf("%d%s%s%s\n" , i," ", data," TRUE");
                		sizeB++;
            		}
         	}
		for(int i = 0;i<arrayList.size();i++){
                  	String data = arrayList.get(i);
                  	if(data.length()>2){
   				positionS  = data.charAt(0);
                     		position1  = (int)positionS;
   				positionSS = data.charAt(1);
   				position3 = (int)positionSS;
   				totalS = position1+position3;
                     		totalS *= 9973;//largest prime number between 0 and 10000
   				totalS %=10000;
                     		superhash.hash[totalS].insertInOrder(data);
   				system.out.printf("%d%s%s%s\n" , i," ", data," TRUE");
 	                  	sizeS++;
			}
			if(data.length()<2){
		                positionS  = data.charAt(0);
                		position1  = (int)positionS;
                  		totalS = position1;
                  		totalS *= 9973;
				totalS %= 10000;
				superhash.hash[totalS].insertInOrder(data);
				System.out.printf("%d%s%s%s\n" , i," ", data," TRUE");
                		sizeB++;
                	}
           	}
	}
}

