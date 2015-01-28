package db.assgin2;

import java.util.ArrayList;
import java.util.Collections;

public class Partition {
	
	ArrayList<String> tempfiles;
	long buf_size;
	String input_path;
	FileIO input;
	Metadata metadata;
	
	
	public Partition(Metadata m,String filepath){
		buf_size = m.getAllowedRAM()/m.getRecordSize();
		input_path=filepath;
		input = new FileIO(filepath,0);
		metadata=m;
	}
	
	
	
	ArrayList<String> divideAndSort(){
		tempfiles = new ArrayList<String>();
		ArrayList<Record> buffer = new ArrayList<Record>();
		int count=0;
		int filecount=0;
		String line;
		FileIO fout;
		while((line=input.readNext())!=null){
			if(count==buf_size){
				count=0;
				Collections.sort(buffer);
				fout = new FileIO("tempf"+filecount,1);
				fout.writeList(buffer);
				fout.close();
				buffer= new ArrayList<Record>();
				filecount++;
			}
			buffer.add(count,new Record(metadata,line));
			count++;
		}
		
		return tempfiles;
	}
}
