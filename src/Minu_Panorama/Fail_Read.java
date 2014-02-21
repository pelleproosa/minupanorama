package Minu_Panorama;

/*
 *   Component Gets input: (String Read_File_Name, int Start_Reading, int End_Reading)
 *   
 *   Returns output      : String[] tagasiside
 *   
 *   tagasiside[0]= cut string from file
 *   tagasiside[1]= number, how many chars from file end
 *   tagasiside[2]= int file_status   0=file has more, 1=File not found!, 2=Start_Reading>File.length(), 4=end of file reached, 5=  ((End_Reading<0)||(Start_Reading<0))
 * 	 tagasiside[3]= int file length()
 * */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.File;

public class Fail_Read {

	public static String[] LoeFaili_Aadress_Algus_L6pp(String Read_File_Name, int Start_Reading, int End_Reading) throws Exception {
		String[] tagasiside = new String[4];
		BufferedReader reader = new BufferedReader(new FileReader(Read_File_Name));
		File f=new File(Read_File_Name);
		int i=0;
		String tulem= "";
		int kogufailipikkus=(int) f.length();
		End_Reading=End_Reading+Start_Reading;															/// hommikune uimasus
		if ((End_Reading<0)||(Start_Reading<0)){            //kui huvipakkuv lõpp alla nulli või algus alla nulli ...  
			tagasiside[0]="";
			tagasiside[1]="0";
			tagasiside[2]="5"; 
			tagasiside[3]="0";
			System.out.println("tagasiside 5 readfailis");
			reader.close();
			return tagasiside;
		}
		if (Start_Reading>=kogufailipikkus){
				tagasiside[0]="";
				tagasiside[1]="0";
				tagasiside[2]="4"; 
				tagasiside[3]="0";
				reader.close();
				return tagasiside;
		}
		if (End_Reading>kogufailipikkus){
			End_Reading=kogufailipikkus;
			tagasiside[2]="4"; 
			if(End_Reading==Start_Reading){
				reader.close();
				return tagasiside;
			}
		}else {
			tagasiside[2]="0";
		}
		int j=End_Reading-Start_Reading;
		
		char[] c1=new char[j];
		try {
		    for ( i = 0; i < Start_Reading; i++) {
		        reader.read(); // Selle tsykli abil viin lugeja positsioonile Start_Reading
		    }
		    reader.read(c1, 0, j);  // ja siin saan nyyd ilusti loetud oma asja
		   tulem= new String(c1);
		}
		catch (FileNotFoundException e) {
			tagasiside[0]="";
			tagasiside[1]="0";
			tagasiside[2]="1";
			tagasiside[3]="0";
			System.out.println("faili ei leia!");
			reader.close();
			return tagasiside;
		}
		End_Reading=kogufailipikkus-End_Reading;
		tagasiside[0]=tulem;
		tagasiside[1]=""+End_Reading;
		if(!tagasiside[2].equalsIgnoreCase("4")){
		tagasiside[2]="1"; }
		tagasiside[3]=""+kogufailipikkus;
		reader.close();
		return tagasiside;
	}
}