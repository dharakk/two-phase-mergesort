package db.assgin2;

import java.util.ArrayList;

public class TwoPhaseMerge { 	

	
		public static void main(String[] st){
			Metadata metadata = new Metadata("samples/sample1/metadata.txt",Runtime.getRuntime().totalMemory());
			ArrayList<String> tempfiles;
			Partition pr  = new Partition(metadata,"samples/sampe1/metadta.txt");
			tempfiles = pr.divideAndSort();
		}
}
 