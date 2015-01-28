package db.assgin2;

import java.util.ArrayList;

public class TwoPhaseMerge { 	

	
		public static void main(String[] st){
			int[] sort_cols = new int[st.length-4];
			for(int i=4;i<st.length;i++){
				sort_cols[i-4]=Integer.parseInt(st[i].substring(st[i].length()-1));
			}
			System.out.println("1 "+ Runtime.getRuntime().freeMemory());
			Metadata metadata = new Metadata("samples/sample1/metadata.txt",(long)(Runtime.getRuntime().freeMemory()*0.4),sort_cols,st[3]);
			ArrayList<String> tempfiles;
			Partition pr  = new Partition(metadata,"samples/sample1/input.txt");
			System.out.println("3 "+ Runtime.getRuntime().freeMemory());
			tempfiles = pr.divideAndSort();
			
			
		}
}
 