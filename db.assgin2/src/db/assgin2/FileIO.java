package db.assgin2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class FileIO {
	BufferedReader br;
	PrintWriter pr;
	int m;
	public FileIO(String path,int mode){
		m=mode;
		if(mode==0){
			try {
				br = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(mode==1){
			try {
				pr = new PrintWriter(path);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	String readNext(){
		String s=null;
		try {
			s = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}
	
	void writeToFile(String line){
		pr.println(line);
	}
	
	void writeList(ArrayList<Record> l){
		for(Record i : l){
			writeToFile(i.toString());
		}
	}
	
	void close(){
		try{
			if(m==0)
				br.close();
			else
				pr.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
			
	}

}
