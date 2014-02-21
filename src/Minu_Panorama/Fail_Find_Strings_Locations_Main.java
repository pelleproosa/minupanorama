package Minu_Panorama;
/*
 *          Gets    : Faili_Nimi, L6ike_Alguskoht
 * 
 * 			Returnes: end, String_array_of_picture, file status from fail_read 
 * 
 * 
 * */

public class Fail_Find_Strings_Locations_Main {

	public static String[] pilt(String Faili_Nimi, int L6ike_Alguskoht, int L6ike_Suurus) throws Exception {
	//	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		String[] otsitav={"D://temp/kuusalu.txt","1000","pelel6pp10","[{","{","\"owner_name\":\"","\"","\"photo_title\":\"","\"upload_date\":\"","}",","};
		//                         0             1          2          3   4          5            6            7                    8           9   10
	//	String Faili_Nimi=otsitav[0];
		int i=0;
	//	int L6ike_Alguskoht=0;
		
		String Otsitav=otsitav[3];
		String[] tagasiside={"","","","","","","","","","","","",""};
		
		int end=0;
		String[] tulem={"","","1",""};
		int[]asukohad={0,0,0,0,0,0,0,0,0,0,0};
//		System.out.println("L6ike_Alguskoht on : "+L6ike_Alguskoht);
		if (L6ike_Alguskoht==0){
		asukohad=File_Find_Strings_Locations.asukoht(Faili_Nimi, L6ike_Alguskoht, L6ike_Suurus, Otsitav);
		i=otsitav[3].length();
		end=asukohad[0];
		tulem= Fail_Read.LoeFaili_Aadress_Algus_L6pp(Faili_Nimi, 0, end);
		tagasiside[0]=tulem[0];
		L6ike_Alguskoht=asukohad[0];
//		System.out.println(tagasiside[0]);
		}else{
			Otsitav=otsitav[4];
			asukohad=File_Find_Strings_Locations.asukoht(Faili_Nimi, L6ike_Alguskoht, L6ike_Suurus, Otsitav);
			end=asukohad[0];
			tulem= Fail_Read.LoeFaili_Aadress_Algus_L6pp(Faili_Nimi, L6ike_Alguskoht, end);
			tagasiside[0]=tulem[0];
	//		System.out.println(tagasiside[0]);
		//	System.exit(0);
			L6ike_Alguskoht=L6ike_Alguskoht+end;
		}
		end= (end+asukohad[0]);
	//	System.out.println(tagasiside[0]);
		tagasiside[9]=tulem[2];
		if (tagasiside[9].equalsIgnoreCase("4")){

			return tagasiside;
		}		
		
		
		
		
		
		Otsitav=otsitav[5];
		i=otsitav[5].length();
	

		
		asukohad=File_Find_Strings_Locations.asukoht(Faili_Nimi, L6ike_Alguskoht, L6ike_Suurus, Otsitav);
		
		end=(asukohad[0]+i);
		tulem= Fail_Read.LoeFaili_Aadress_Algus_L6pp(Faili_Nimi, L6ike_Alguskoht, end);
		tagasiside[1]=tulem[0];
//		System.out.println(tagasiside[1]);
		tagasiside[9]=tulem[2];
		if (tagasiside[9].equalsIgnoreCase("4")){

			return tagasiside;
		}		
		
		
		Otsitav=otsitav[6];
		L6ike_Alguskoht=L6ike_Alguskoht+end;
		asukohad=File_Find_Strings_Locations.asukoht(Faili_Nimi, L6ike_Alguskoht, L6ike_Suurus, Otsitav);
		end= asukohad[0];
		tulem= Fail_Read.LoeFaili_Aadress_Algus_L6pp(Faili_Nimi, L6ike_Alguskoht, end);
		tagasiside[2]=tulem[0];
//		System.out.println("#"+tagasiside[2]+"#");
		tagasiside[9]=tulem[2];
		if (tagasiside[9].equalsIgnoreCase("4")){
			return tagasiside;
		}		
		
		
		
		Otsitav=otsitav[7];
		L6ike_Alguskoht=L6ike_Alguskoht+end;
		asukohad=File_Find_Strings_Locations.asukoht(Faili_Nimi, L6ike_Alguskoht, L6ike_Suurus, Otsitav);
        i=otsitav[7].length();
		end=( (asukohad[0])+i);
		tulem= Fail_Read.LoeFaili_Aadress_Algus_L6pp(Faili_Nimi, L6ike_Alguskoht, end);
		tagasiside[3]=tulem[0];
//		System.out.println(tagasiside[3]);
		tagasiside[9]=tulem[2];
		if (tagasiside[9].equalsIgnoreCase("4")){
			return tagasiside;
		}		
		
		

		Otsitav=otsitav[6];
		L6ike_Alguskoht=L6ike_Alguskoht+end;
		asukohad=File_Find_Strings_Locations.asukoht(Faili_Nimi, L6ike_Alguskoht, L6ike_Suurus, Otsitav);
		end=( (asukohad[0]));
		tulem= Fail_Read.LoeFaili_Aadress_Algus_L6pp(Faili_Nimi, L6ike_Alguskoht, end);
		tagasiside[4]=tulem[0];
//		System.out.println(tagasiside[4]);
		tagasiside[9]=tulem[2];
		if (tagasiside[9].equalsIgnoreCase("4")){
			return tagasiside;
		}		
		
		
		Otsitav=otsitav[8];
		L6ike_Alguskoht=L6ike_Alguskoht+end;
		asukohad=File_Find_Strings_Locations.asukoht(Faili_Nimi, L6ike_Alguskoht, L6ike_Suurus, Otsitav);
		i=otsitav[7].length();
		end=( (asukohad[0])+i);
		tulem= Fail_Read.LoeFaili_Aadress_Algus_L6pp(Faili_Nimi, L6ike_Alguskoht, end);
		tagasiside[5]=tulem[0];
//		System.out.println(tagasiside[5]);
		tagasiside[9]=tulem[2];
		if (tagasiside[9].equalsIgnoreCase("4")){
			return tagasiside;
		}		
		
		
		
		Otsitav=otsitav[6];
		L6ike_Alguskoht=L6ike_Alguskoht+end;
		asukohad=File_Find_Strings_Locations.asukoht(Faili_Nimi, L6ike_Alguskoht, L6ike_Suurus, Otsitav);
		end=( (asukohad[0]));
		tulem= Fail_Read.LoeFaili_Aadress_Algus_L6pp(Faili_Nimi, L6ike_Alguskoht, end);
		tagasiside[6]=tulem[0];
//		System.out.println(tagasiside[6]);
		tagasiside[9]=tulem[2];
		if (tagasiside[9].equalsIgnoreCase("4")){
			return tagasiside;
		}	
		
		
		Otsitav=otsitav[9];
		L6ike_Alguskoht=L6ike_Alguskoht+end;
		asukohad=File_Find_Strings_Locations.asukoht(Faili_Nimi, L6ike_Alguskoht, L6ike_Suurus, Otsitav);
		i=otsitav[9].length();
		end=( (asukohad[0])+i);
		tulem= Fail_Read.LoeFaili_Aadress_Algus_L6pp(Faili_Nimi, L6ike_Alguskoht, end);
		tagasiside[7]=tulem[0];
//		System.out.println(tagasiside[7]);
		
		
//		System.exit(0);
		

		
		
		
		tagasiside[8]=""+(L6ike_Alguskoht+end);
//		System.out.println("j2i pooleli : "+tagasiside[8]);
		tagasiside[9]=tulem[2];

		
		
		
		
		
		
		
		
		
		
		
		


	//	System.exit(0);
		return tagasiside;
		
		
		
		
		
		
		
		
		
		
	}

}
