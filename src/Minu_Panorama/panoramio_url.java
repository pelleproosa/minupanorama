package Minu_Panorama;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class panoramio_url {

	public static String sendGet(String x) throws Exception {
		//"http://www.google.com/search?q=mkyong"
		//http://www.panoramio.com/map/get_panoramas.php?set=public&from=0&to=20&minx=-180&miny=-90&maxx=180&maxy=90&size=medium&mapfilter=true
		/*
		 * Googleapis.com
		 * Linna p2ring
		 * http://maps.googleapis.com/maps/api/geocode/xml?address=Rakvere&sensor=false
		 * tagurpidi.. parnu
		 * http://maps.googleapis.com/maps/api/geocode/json?latlng=58.41638460000001,24.604497&sensor=true
		 * Panoramiosse sealt ainult lattitude ja longitude vahemikud (pindala, kust pilte hankida)
		 * www.panoramio.com/map/get_panoramas.php?set=public&from=0&to=20&minx=24.5972479&miny=58.3907161&maxx=24.6458120&maxy=58.4248780&size=medium&mapfilter=true
		 * */
	
		// panoramiot suudab 500 kaupa lugeda ... kindlam on 100 kaupa teha
		String url = x;
		System.out.println("Täppidega tähed korda saada programmis!!!");
		System.out.println();
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
 
		// optional default is GET
		con.setRequestMethod("GET");
 
 
	//	int responseCode = con.getResponseCode();

 
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
 String vastus="";
		while ((inputLine = in.readLine()) != null) {
		vastus=vastus+inputLine;
		}
		in.close();

		System.out.println(vastus);
		return x;

		
		
	}
	static void save(String x){
		
	}

	///////////////////////////////////////pooleli
	
	
		public static void googleapi(String x) throws Exception {
		
		String url = x;
	//	System.out.println("Täppidega tähed korda saada programmis!!!");
	//	System.out.println();
		StringWriter stringWriter = new StringWriter();
		BufferedWriter bufferedWriter = new BufferedWriter(stringWriter);
		
		System.out.println("");
		System.out.print("Getting "+Global.address+" coordinates from Googleapi...");
		
	
		URL obj = new URL(url);
		
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		
		BufferedReader lugemisbuffer = new BufferedReader(new InputStreamReader(con.getInputStream()));
	try{	
		int zx=0;								// 50-ne rea lugemise tsykkel googleapi jaoks
		while (true){	
		bufferedWriter.write(lugemisbuffer.readLine());
		zx++;
		if (zx>=50){break;}
	}   
	}catch(Exception ehhee){
		System.out.println("");
		System.out.println("");
		System.out.println("CONGRATULATIONS!");
		System.out.println("");
		System.out.println("You have just made up new location name, whitch did not exist so far!");
		System.out.println("");
		System.out.println("Exiting program, because havent set up local file check as first thing to do.... OOPS!");
		System.exit(0);
	}
		bufferedWriter.close();
		
		String hugestring = stringWriter.toString();// tsykli l6pp
		
		
	String[] googleapikoordinaadid=	panoramio_parse.googleapiparse(hugestring);
	System.out.println("done!");
		lugemisbuffer.close();
		System.out.println("");
		System.out.print("Getting "+Global.address+" pictures from Panoramioapi...");
		panoramio_url.panoramioapi(googleapikoordinaadid);
	//	return googleapikoordinaadid;
}            //// > googleapi



///////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////
		/**
		 * desc
		 * @param x
		 * @throws Exception
		 */
		public static void  panoramioapi(String[] x) throws Exception {
			String a="http://www.panoramio.com/map/get_panoramas.php?set=public&from=";
			String b="&to=";
			String c="&minx=";
			String minx=x[4];
			String d="&miny=";
			String miny= x[3];
			String e="&maxx=";
			String maxx=x[2];
			String f="&maxy=";
			String maxy=x[1];
			String g="&size=";
			String size="medium";
			String h="&mapfilter=";
			String mapfilter="true";
			int nr1=0;               ////kasutajalt valik, mitmendast.... antuf kodut66s ei n6utud ja ei tee siis ka(aega pole)
			int nr2=100;        //programm loeb 'nrsamm' kaupa
			int nrsamm=100;     //programm eelistab 100 kaupa lugemist kui (nrsamm<nrmax) else nrsamm=100-((100-(nrmax-loetud)))
			int nrmax=1000;                               //// kasutajalt valik, mitmendani
			
			
			
			//"http://www.panoramio.com/map/get_panoramas.php?set=public&from=0&to=1500&minx=24.5501939&miny=59.351809&maxx=24.9262889&maxy=59.5914239&size=medium&mapfilter=true";
			// panoramiot suudab 500 kaupa lugeda ... kindlam on 100 kaupa teha
		//	System.out.println("Täppidega tähed korda saada programmis!!!");
			StringWriter stringWriter = new StringWriter();
			BufferedWriter bufferedWriter = new BufferedWriter(stringWriter);
			
			String url="";		

			while(true){	
				url = a+nr1+b+nr2+c+minx+d+miny+e+maxx+f+maxy+g+size+h+mapfilter;
				URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			// optional default is GET
			con.setRequestMethod("GET");
			BufferedReader lugemisbuffer = new BufferedReader(
			        new InputStreamReader(con.getInputStream()));
			bufferedWriter.write(lugemisbuffer.readLine());
			lugemisbuffer.close();
			nr1=nr1+nrsamm;
			nr2=nr2+nrsamm;
			if (nr1>=nrmax){
				con.disconnect();
				break;}
			}			// tsykli l6pp
			
			System.out.println("done!");
			System.out.println();
			bufferedWriter.close();
			//String hugestring = stringWriter.toString();
			String hugeString = stringWriter.toString();
			stringWriter.close();

	
			
			
			
//#############################################################################################################################################			

			/*                     KOGU MUUSIKA KÄIB SIIN !!!!                */
			
			
			String[] pildidbuffristsorti={};
			
			
			pildidbuffristsorti=functions.stringistjada(hugeString);          /// siin saan stringide jada(iga jada=1 pilt) ja jadade arvu jadas
			int i=0;
			panoramio_sort[] pildibaas= new panoramio_sort[Global.Stringide_Arv_Jadas];     // teen sortimiseks jada, mis koosneb jadadest, milles soovitud liikmeid võrreldes saab teha sorteeringu  
		
			pildibaas=functions.puzzle(pildidbuffristsorti,Global.Stringide_Arv_Jadas);     // see sortimise jada saab töövalmis >>>ehk>>> omistatakse väärtused
			
			File uusfail=new File((Global.aadressfolder+Global.address+Global.aadressextension));
			if (!uusfail.exists()||(Global.force==true)){	                                                              // kui sellenimelist faili veel pole, või käsk oli "force"
				pildibaas=functions.sorteerimine(pildibaas, Global.Stringide_Arv_Jadas);                                  // sorteerin jada vastavalt kasutaja soovile
				String Sisu="";
				i=0;
				Global.kuva=true;																						  // sorteerimisfunktsioon lülitub jada kuvamisele
				pildibaas=functions.sorteerimine(pildibaas, Global.Stringide_Arv_Jadas);   // sorteerin jada vastavalt kasutaja soovile
				System.out.println("");														
				System.out.println("############################");
				System.out.println("#      YOUR PICTURES       #");
				System.out.println("############################");
				while (i<(Global.Stringide_Arv_Jadas)){                                     							  // teen saadud sorteeritud jadast stringi faili kirjutamiseks  :  "sisu"
					Sisu=Sisu+(pildibaas[i].sisu1+pildibaas[i].OWNER_NAME+pildibaas[i].sisu2+pildibaas[i].PHOTO_TITLE+pildibaas[i].sisu3+pildibaas[i].UPLOAD_DATE_S+pildibaas[i].sisu4);
					System.out.println(pildibaas[i].sisu1+pildibaas[i].OWNER_NAME+pildibaas[i].sisu2+pildibaas[i].PHOTO_TITLE+pildibaas[i].sisu3+pildibaas[i].UPLOAD_DATE_S+pildibaas[i].sisu4);
					i++;
				}
				Fail_Write.Fail_Kirjuta((Global.aadressfolder+Global.address+Global.aadressextension), Sisu, "rw");       // kirjutan loodud stringi faili "linnanimi.txt"
				Global.kuva=false;																						  // sorteerimisfunktsioon lülitub tagasi sorteerimisele
				System.out.println("");
				System.out.println("");
				System.out.println("You got "+Global.Stringide_Arv_Jadas+" pictures of "+Global.address+" saved into "+Global.aadressfolder+Global.address+Global.aadressextension);
				System.exit(0);
			}
																										 // kui sellenimeline fail on olemas, algab võrdlus
																										 // et võrdluses ei esineks vigu, salvestan reaalse käsu
																										 // häälestan sorteerimise kuupäev descend 

			
			
			
			else{	                                                              // kui sellenimelist faili veel pole, või käsk oli "force"
				pildibaas=functions.sorteerimine(pildibaas, Global.Stringide_Arv_Jadas);                                  // sorteerin jada vastavalt kasutaja soovile
				String Sisu="";
				i=0;
				while (i<(Global.Stringide_Arv_Jadas)){                                     							  // teen saadud sorteeritud jadast stringi faili kirjutamiseks  :  "sisu"
					Sisu=Sisu+(pildibaas[i].sisu1+pildibaas[i].OWNER_NAME+pildibaas[i].sisu2+pildibaas[i].PHOTO_TITLE+pildibaas[i].sisu3+pildibaas[i].UPLOAD_DATE_S+pildibaas[i].sisu4);
					i++;
				}
				Fail_Write.Fail_Kirjuta((Global.aadressfolder+"buffer"+Global.aadressextension), Sisu, "rw");       // kirjutan loodud stringi faili "linnanimi.txt"
				System.out.println("");
				System.out.println("");
				System.out.println("You got "+Global.Stringide_Arv_Jadas+" pictures from panoramio saved into "+Global.aadressfolder+"\"buffer\""+Global.aadressextension);

			}
			
			boolean ajutine_ascend=Global.ascend;
			boolean ajutine_descend=Global.descend;
			boolean ajutine_picture=Global.picture;
			boolean ajutine_author=Global.author;
			boolean ajutine_date=Global.date;
			Global.date=true;
			Global.author=false;
			Global.picture=false;
			Global.ascend=false;
			Global.descend=true;
			
			
			pildibaas=functions.sorteerimine(pildibaas, Global.Stringide_Arv_Jadas);					// sorteerin värske päringu sobivalt mälus
			
			
			
			
			
			
			
			
			
			Global.Stringide_Arv_Jadas_buffer=Global.Stringide_Arv_Jadas;								// jätan meelde seal oleva piltide arvu
		
		
		
		
													/////////////   TEGELEN OLEMASOLEVA FAILIGA    ///////////////////////
		String Sisu2="";
		String[]failiinfo=new String[4];
		failiinfo=Fail_Read.LoeFaili_Aadress_Algus_L6pp((Global.aadressfolder+Global.address+Global.aadressextension), 0, 0);	// küsin failist 0 chari pikkuse jupi, ehk huvitun tegelt tagasisidena faili pikkusest 
		Sisu2=failiinfo[3];																										// võtan failipikkuse
		i=Integer.parseInt(Sisu2);																								// teen selle numbriks
		i++;
		failiinfo=Fail_Read.LoeFaili_Aadress_Algus_L6pp((Global.aadressfolder+Global.address+Global.aadressextension), 0, i);   // loen faili sisu
		Sisu2=failiinfo[0];																										// omistan selle oma muutujale
		pildidbuffristsorti=functions.stringistjada(Sisu2);
		panoramio_sort[] pildibaasfailist= new panoramio_sort[Global.Stringide_Arv_Jadas];
		pildibaasfailist=functions.puzzle(pildidbuffristsorti,Global.Stringide_Arv_Jadas);
		pildibaasfailist=functions.sorteerimine(pildibaasfailist, Global.Stringide_Arv_Jadas);       // nagu esmalt mällu loetuga, sorteerin ka selle mälus sobivalt (desc date), et ei tuleks äpardusi võrdluses

		
		

		/*		
		i=0;
		Sisu2="";
		while (i<(Global.Stringide_Arv_Jadas)){
			System.out.println(pildibaasfailist[i].sisu1+pildibaasfailist[i].OWNER_NAME+pildibaasfailist[i].sisu2+pildibaasfailist[i].PHOTO_TITLE+pildibaasfailist[i].sisu3+pildibaasfailist[i].UPLOAD_DATE_S+pildibaasfailist[i].sisu4);
				i++;
			}
System.exit(0);

		i=0;
		Sisu2="";
		while (i<(Global.Stringide_Arv_Jadas)){
			Sisu2=Sisu2+(pildibaasfailist[i].sisu1+pildibaasfailist[i].OWNER_NAME+pildibaasfailist[i].sisu2+pildibaasfailist[i].PHOTO_TITLE+pildibaasfailist[i].sisu3+pildibaasfailist[i].UPLOAD_DATE_S+pildibaasfailist[i].sisu4);
				i++;
			}
//		Global.address="tulem";
		Fail_Write.Fail_Kirjuta((Global.aadressfolder+"tulem"+Global.aadressextension), Sisu2, "rw");
		///////////    FAILIST LOETUD JA UUS FAIL KIRJUTATUD ............ võrdlus puudu!!!
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("##################################################################################");
		System.out.println();
		System.out.println();
		System.out.println();
	*/	
		////////////////        EELPOOL TOIMIB!  edasi:      VÕRDLUS
		/*		
		System.out.println(pildibaas[0].OWNER_NAME);
		System.out.println(pildibaasfailist[0].OWNER_NAME);
		if((pildibaas[0].OWNER_NAME).equalsIgnoreCase(pildibaasfailist[0].OWNER_NAME)){
			System.out.println();
			System.out.println("Tadaaa!!  hahaa!");	
		}
		 */		
	//	i=((Global.Stringide_Arv_Jadas));
		i=((Global.picturelimit_from_panoramioapi));
		i=i*2;
		panoramio_sort[] l6pptulem= new panoramio_sort[i];         //// topelt suurus, et ei jääks puudu
		panoramio_sort[] uuedpildid= new panoramio_sort[i];
		int l6pptulemilugeja=0;
		int uuedpildidlugeja=0;
		int lugeja=0;

		while(lugeja<(Global.Stringide_Arv_Jadas)){           // omistan jada uude kohta
				l6pptulem[lugeja]=new panoramio_sort(pildibaas[lugeja].sisu1,pildibaas[lugeja].OWNER_NAME,pildibaas[lugeja].sisu2,pildibaas[lugeja].PHOTO_TITLE,pildibaas[lugeja].sisu3,pildibaas[lugeja].UPLOAD_DATE_S, pildibaas[lugeja].UPLOAD_DATE_I,pildibaas[lugeja].sisu4);
				System.out.println(l6pptulemilugeja+"  "+l6pptulem[l6pptulemilugeja].sisu1+l6pptulem[l6pptulemilugeja].OWNER_NAME+l6pptulem[l6pptulemilugeja].sisu2+l6pptulem[l6pptulemilugeja].PHOTO_TITLE+l6pptulem[l6pptulemilugeja].sisu3+l6pptulem[l6pptulemilugeja].UPLOAD_DATE_S+l6pptulem[l6pptulemilugeja].UPLOAD_DATE_I+l6pptulem[l6pptulemilugeja].sisu4);
				lugeja++;
				l6pptulemilugeja=lugeja;
		}
		lugeja--;
		l6pptulemilugeja=lugeja;

		lugeja=0;
		i=0;
		
		while (lugeja<Global.Stringide_Arv_Jadas_buffer){
			while (i<(Global.Stringide_Arv_Jadas+1)){
				if((pildibaas[lugeja].OWNER_NAME).equalsIgnoreCase(pildibaasfailist[i].OWNER_NAME)){
					if((pildibaas[lugeja].PHOTO_TITLE).equalsIgnoreCase(pildibaasfailist[i].PHOTO_TITLE)){
						if((pildibaas[lugeja].UPLOAD_DATE_S).equalsIgnoreCase(pildibaasfailist[i].UPLOAD_DATE_S)){
							pildibaas[lugeja].OWNER_NAME="pelepanoramiopele";
						//	System.exit(0);
						//	l6pptulem[l6pptulemilugeja]=new panoramio_sort(pildibaas[lugeja].sisu1,pildibaas[lugeja].OWNER_NAME,pildibaas[lugeja].sisu2,pildibaas[lugeja].PHOTO_TITLE,pildibaas[lugeja].sisu3,pildibaas[lugeja].UPLOAD_DATE_S, pildibaas[lugeja].UPLOAD_DATE_I,pildibaas[lugeja].sisu4);
//							System.out.println(l6pptulemilugeja+"  "+l6pptulem[l6pptulemilugeja].sisu1+l6pptulem[l6pptulemilugeja].OWNER_NAME+l6pptulem[l6pptulemilugeja].sisu2+l6pptulem[l6pptulemilugeja].PHOTO_TITLE+l6pptulem[l6pptulemilugeja].sisu3+l6pptulem[l6pptulemilugeja].UPLOAD_DATE_S+l6pptulem[l6pptulemilugeja].UPLOAD_DATE_I+l6pptulem[l6pptulemilugeja].sisu4);
						//	l6pptulemilugeja++;
							
							break;
						}else{
							if((pildibaas[lugeja].UPLOAD_DATE_I)>(pildibaasfailist[i].UPLOAD_DATE_I)){  
								l6pptulemilugeja++;
								l6pptulem[l6pptulemilugeja]=new panoramio_sort(pildibaas[lugeja].sisu1,pildibaas[lugeja].OWNER_NAME,pildibaas[lugeja].sisu2,pildibaas[lugeja].PHOTO_TITLE,pildibaas[lugeja].sisu3,pildibaas[lugeja].UPLOAD_DATE_S, pildibaas[lugeja].UPLOAD_DATE_I,pildibaas[lugeja].sisu4);
								uuedpildid[uuedpildidlugeja]=new panoramio_sort(pildibaas[lugeja].sisu1,pildibaas[lugeja].OWNER_NAME,pildibaas[lugeja].sisu2,pildibaas[lugeja].PHOTO_TITLE,pildibaas[lugeja].sisu3,pildibaas[lugeja].UPLOAD_DATE_S, pildibaas[lugeja].UPLOAD_DATE_I,pildibaas[lugeja].sisu4);
								uuedpildidlugeja++;
							//	System.out.println("########################################### kontrollkoht ####################################################       1      ");
								break;
							}
						//	l6pptulemilugeja++;
						//	l6pptulem[l6pptulemilugeja]=new panoramio_sort(pildibaasfailist[lugeja].sisu1,pildibaasfailist[lugeja].OWNER_NAME,pildibaasfailist[lugeja].sisu2,pildibaasfailist[lugeja].PHOTO_TITLE,pildibaasfailist[lugeja].sisu3,pildibaasfailist[lugeja].UPLOAD_DATE_S, pildibaasfailist[lugeja].UPLOAD_DATE_I,pildibaasfailist[lugeja].sisu4);
						//	System.out.println("########################################### kontrollkoht ####################################################        2     ");

							//							System.out.println(l6pptulemilugeja+"  "+l6pptulem[i].sisu1+l6pptulem[i].OWNER_NAME+l6pptulem[i].sisu2+l6pptulem[i].PHOTO_TITLE+l6pptulem[i].sisu3+l6pptulem[i].UPLOAD_DATE_S+l6pptulem[i].UPLOAD_DATE_I+l6pptulem[i].sisu4);
						
							break;
						}
					}else{}
					
				}else{
				}
				i++;
				if(i==Global.Stringide_Arv_Jadas){
					l6pptulemilugeja++;
					l6pptulem[l6pptulemilugeja]=new panoramio_sort(pildibaas[lugeja].sisu1,pildibaas[lugeja].OWNER_NAME,pildibaas[lugeja].sisu2,pildibaas[lugeja].PHOTO_TITLE,pildibaas[lugeja].sisu3,pildibaas[lugeja].UPLOAD_DATE_S, pildibaas[lugeja].UPLOAD_DATE_I,pildibaas[lugeja].sisu4);
//					System.out.println(l6pptulemilugeja+"  "+l6pptulem[i].sisu1+l6pptulem[i].OWNER_NAME+l6pptulem[i].sisu2+l6pptulem[i].PHOTO_TITLE+l6pptulem[i].sisu3+l6pptulem[i].UPLOAD_DATE_S+l6pptulem[i].UPLOAD_DATE_I+l6pptulem[i].sisu4);
					uuedpildid[uuedpildidlugeja]=new panoramio_sort(pildibaas[lugeja].sisu1,pildibaas[lugeja].OWNER_NAME,pildibaas[lugeja].sisu2,pildibaas[lugeja].PHOTO_TITLE,pildibaas[lugeja].sisu3,pildibaas[lugeja].UPLOAD_DATE_S, pildibaas[lugeja].UPLOAD_DATE_I,pildibaas[lugeja].sisu4);
					uuedpildidlugeja++;
					
				//	System.out.println("########################################### kontrollkoht ####################################################       3      ");

					break;
				}
			}
			i=0;
			lugeja++;
		}
///////////////////////////////////////               KUI EELPOOL TOIMIS	siis   sorteerimine, tagasiside ja faili	
		System.out.println("lugeja on "+lugeja+" ja l6pptulemilugeja on : "+l6pptulemilugeja);
		l6pptulemilugeja++;
		i=l6pptulemilugeja;
		panoramio_sort[] l6ppudel6pp= new panoramio_sort[i];
		i=0;
		while (i<l6pptulemilugeja){
			/*
			l6ppudel6pp[i].sisu1=l6pptulem[i].sisu1;
			l6ppudel6pp[i].OWNER_NAME=l6pptulem[i].OWNER_NAME;
			l6ppudel6pp[i].sisu2=l6pptulem[i].sisu2;
			l6ppudel6pp[i].PHOTO_TITLE=l6pptulem[i].PHOTO_TITLE;
			l6ppudel6pp[i].sisu3=l6pptulem[i].sisu3;
			l6ppudel6pp[i].UPLOAD_DATE_S=l6pptulem[i].UPLOAD_DATE_S;
			l6ppudel6pp[i].UPLOAD_DATE_I=l6pptulem[i].UPLOAD_DATE_I;
			l6ppudel6pp[i].sisu4=l6pptulem[i].sisu4;
			*/

			l6ppudel6pp[i]=new panoramio_sort(l6pptulem[i].sisu1,l6pptulem[i].OWNER_NAME,l6pptulem[i].sisu2,l6pptulem[i].PHOTO_TITLE,l6pptulem[i].sisu3,l6pptulem[i].UPLOAD_DATE_S,l6pptulem[i].UPLOAD_DATE_I,l6pptulem[i].sisu4);		
//			System.out.println(i);
			i++;
			}
		

		Global.date=ajutine_date;
		Global.author=ajutine_author;
		Global.picture=ajutine_picture;
		Global.ascend=ajutine_ascend;
		Global.descend=ajutine_descend;
		l6ppudel6pp=functions.sorteerimine(l6ppudel6pp, l6pptulemilugeja);
		Global.kuva=true;
		l6ppudel6pp=functions.sorteerimine(l6ppudel6pp, l6pptulemilugeja);
		Global.kuva=false;
		i=0;
		if(uuedpildidlugeja>0){
			System.out.println("##############################");
			System.out.println("# Found "+uuedpildidlugeja+" new picture(s)!");
			System.out.println("##############################");
		while (i<uuedpildidlugeja){
			System.out.println(uuedpildid[i].sisu1+uuedpildid[i].OWNER_NAME+uuedpildid[i].sisu2+uuedpildid[i].PHOTO_TITLE+uuedpildid[i].sisu3+uuedpildid[i].UPLOAD_DATE_S+uuedpildid[i].sisu4);
				i++;
			}
		System.out.println();
		System.out.println();
		System.out.println();
		}
		System.out.println("############################");
		System.out.println("#      YOUR PICTURES       #");
		System.out.println("############################");
	//	int uuedjuurde=i;
		i=0;
		String Sisu3="";
		while (i<(l6pptulemilugeja)){
			Sisu3=Sisu3+(l6ppudel6pp[i].sisu1+l6ppudel6pp[i].OWNER_NAME+l6ppudel6pp[i].sisu2+l6ppudel6pp[i].PHOTO_TITLE+l6ppudel6pp[i].sisu3+l6ppudel6pp[i].UPLOAD_DATE_S+l6ppudel6pp[i].sisu4);
			System.out.println(l6ppudel6pp[i].sisu1+l6ppudel6pp[i].OWNER_NAME+l6ppudel6pp[i].sisu2+l6ppudel6pp[i].PHOTO_TITLE+l6ppudel6pp[i].sisu3+l6ppudel6pp[i].UPLOAD_DATE_S+l6ppudel6pp[i].sisu4);
			i++;
		}

		
		
		Fail_Write.Fail_Kirjuta((Global.aadressfolder+Global.address+Global.aadressextension), Sisu3, "rw");
	
		
		
		
		
		
		
		System.exit(0);
	
  
	}
}

