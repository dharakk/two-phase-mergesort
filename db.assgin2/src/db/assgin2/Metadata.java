package db.assgin2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Metadata {
	
	long rec_size;
	long N;
	long M;
	long ram;
	int cols;
	
	public Metadata(String filename,long mem){
		try {
			ram = mem;
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
			cols=0;
			
			String line;
			StringTokenizer tc;
			rec_size=0;
			while((line=br.readLine()) != null){
				cols++;
				
				tc = new StringTokenizer(line,",");
				while(tc.hasMoreTokens()){
					String s = tc.nextToken();
					s = tc.nextToken();
					rec_size = rec_size +  Integer.parseInt(s);
				}
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	long getRecordSize(){
		return rec_size;
	}
	
	long getAllowedRAM(){
		return ram;
	}
}
