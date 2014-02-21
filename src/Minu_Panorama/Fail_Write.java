package Minu_Panorama;

/*
 *                        Sisendiks anda  :  (String file name, String sisu, String t2psustus(append/rewrite))
 *                        Output gives: Boolean false=error, true=done;
 * 
 * */


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
public class Fail_Write																							//class Fail_Write algus 
{


	public static boolean Fail_Kirjuta(String Faili_Nimi, String Sisu, String Kirjutamise_Moodus) throws Exception //Fail_Kirjuta algus
	{
	boolean moodus=true;
	File f=new File(Faili_Nimi);
		if (!f.exists())
		{
			if ( !f.createNewFile() ) 
			{
				return false;
			}
		}
		if (Kirjutamise_Moodus.equalsIgnoreCase("append"))
		{
			moodus=true;
		}else
		{
			moodus=false;
		}
		BufferedWriter output;
		output = new BufferedWriter(new FileWriter(Faili_Nimi,moodus));
	        output.write(Sisu);
	        output.close();
        return true;
	}																												//Fail_Kirjuta lõpp
	
	
}																													//class Fail_Write lõpp