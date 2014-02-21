package Minu_Panorama;


/*
  						Gets Input as :
  						String[] otsitav={"Faili_nimi","l6ikealguskoht",l6ikesuurus,"otsitav"};
  						l6ikesuurus m22rab, kui suure stringi t66tlemiseks v6tan
  						
  						
  						Gives back    :
  						integer with string position + error code.
  						tagasiside[9]=1 file length<=0,  tagasiside[9]=2 end of file
 
 */




public class File_Find_Strings_Locations {

	public static int[] asukoht(String Faili_Nimi, int L6ike_Alguskoht, int L6ike_Suurus, String Otsitav) throws Exception {
		
		int i=0;
		int[] tulem1={0,0,0,0};
		String[] tulemus= Fail_Read.LoeFaili_Aadress_Algus_L6pp(Faili_Nimi, L6ike_Alguskoht, L6ike_Suurus);

		i=tulemus[0].indexOf(Otsitav);
		tulem1[0]=i;
		i=Integer.parseInt(tulemus[1]);
		tulem1[1]=i;
		i=Integer.parseInt(tulemus[2]);
		tulem1[2]=i;
		
		
		return tulem1;
	

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
