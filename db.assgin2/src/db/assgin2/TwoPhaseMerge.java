package db.assgin2;

import java.util.ArrayList;

public class TwoPhaseMerge { 	

	
		public static void main(String[] st){
			int[] sort_cols = new int[st.length-4];
			for(int i=4;i<st.length;i++){
				sort_cols[i-4]=Integer.parseInt(st[i].substring(st[i].length()-1));
			}
			Metadata metadata = new Metadata("samples/sample1/metadata.txt",(long)(Runtime.getRuntime().totalMemory()*0.7),sort_cols,st[3]);
			ArrayList<String> tempfiles;
			Partition pr  = new Partition(metadata,"samples/sampe1/metadta.txt");
			tempfiles = pr.divideAndSort();
			
			
		}
}
 