package db.assgin2;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Record implements Comparable<Record> {
	int cols;
	ArrayList<String> values;
	Metadata metadata;
	int[] fields;
	String mode;
	public Record(Metadata m,String line){
		cols = 0;
		metadata=m;
		values = new ArrayList<String>();
		StringTokenizer tc = new StringTokenizer(line," ");
		int i=0;
		while(tc.hasMoreTokens()){
			values.add(i, tc.nextToken());
			i++;
		}
		cols=i;
		fields = metadata.getSortFields();
		mode= metadata.getMode();
	}
	
	public String toString(){
		StringBuilder s = new StringBuilder();;
		for(int i=0;i<cols;i++){
			s.append(values.get(i));
			s.append(" ");
		}
		return s.toString();
	}

	@Override
	public int compareTo(Record o) {
		
		int m=1;
		if(mode.equals("asc"))
			m=1;
		else if(mode.equals("desc"))
			m=-1;
		
		int r=0;
		for(int i=0;i<fields.length;i++){
			r=values.get(fields[i]).compareTo(o.values.get(fields[i]));
			if(r==0){
				continue;
			}
			else
				return r*m;
		}
		return 0;
	}
}
