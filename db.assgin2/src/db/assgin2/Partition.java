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
		System.out.println("2 "+m.getAllowedRAM()+" "+buf_size+" "+m.getRecordSize());
		//buf_size=5;
		input_path=filepath;
		input = new FileIO(filepath,0);
		metadata=m;
	}
	
	
	void QuickSort(ArrayList<Record> r){
		
	}
	
	
	ArrayList<String> divideAndSort(){
		tempfiles = new ArrayList<String>();
		ArrayList<Record> buffer = new ArrayList<Record>();
		int count=0;
		int filecount=0;
		String line;
		FileIO fout;
		while(true){
			line=input.readNext();
			if(line==null || count==buf_size){
				count=0;
				System.out.println("before sort " + Runtime.getRuntime().freeMemory());
				Collections.sort(buffer);
				System.out.println("after sort " + Runtime.getRuntime().freeMemory());
				tempfiles.add(filecount,"tempf"+filecount);
				fout = new FileIO("tempf"+filecount,1);
				fout.writeList(buffer);
				fout.close();
				buffer.clear();
				filecount++;
				if(line==null){
					input.close();
					break;
				}
				
			}
			buffer.add(count,new Record(metadata,line));
			count++;
			//System.out.println(""+count+" "+ Runtime.getRuntime().freeMemory());
		}
		
		return tempfiles;
	}
}
