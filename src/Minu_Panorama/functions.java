package Minu_Panorama;

//import java.io.BufferedReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;







/* Functions class gets commands from main(Minu_Panorama) and returns them back
 * 
 * functions class contains:
 * 
 * 1) usercommandverify(String[] x, int i)
 * kasutaja command(kuni neli liiget), mis on parses vaheetapi l2binud, kontrollitakse k2skude olemasolu
 *  
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */





public class functions {
	
	public static void usercommandverify(String[] x) throws Exception { // 1) >   ///x on k2skude jada, i on k2skude arv
	String[] commandslist1=	panoramio_text.commandslist();
	x[0]=x[0].toLowerCase(); // kasutaja sisestus v2ikestesse t2htedesse
	Global.address=x[0];
	// String commandslist1[]={"address","force","ascend","descend","picture","author","date"};
	//                             0        1        2        3          4        5       6
	if (x[1].equalsIgnoreCase(commandslist1[1])){
		Global.force=true;   // panoramio k2sule lisandub programmisiseselt vastav force funktsioon
	}
	
	if ((x[2].equalsIgnoreCase(commandslist1[2]))||(x[2].equalsIgnoreCase(commandslist1[3]))){
		if (x[2].equalsIgnoreCase(commandslist1[2])){Global.ascend=true;}else Global.descend=true;
	if ((x[3].equalsIgnoreCase(commandslist1[4]))||(x[3].equalsIgnoreCase(commandslist1[5]))||(x[3].equalsIgnoreCase(commandslist1[6]))){
	
		if (x[3].equalsIgnoreCase(commandslist1[4])){Global.picture=true;}
		if (x[3].equalsIgnoreCase(commandslist1[5])){Global.author=true;}
		if (x[3].equalsIgnoreCase(commandslist1[6])){Global.date=true;}
	}}
	if	((x[1].equalsIgnoreCase(commandslist1[2]))||(x[1].equalsIgnoreCase(commandslist1[3]))){
			if (x[1].equalsIgnoreCase(commandslist1[2])){Global.ascend=true;}else{Global.descend=true;}
				
			if ((x[2].equalsIgnoreCase(commandslist1[4]))||(x[2].equalsIgnoreCase(commandslist1[5]))||(x[2].equalsIgnoreCase(commandslist1[6]))){
				if (x[2].equalsIgnoreCase(commandslist1[4])){Global.picture=true;}
				if (x[2].equalsIgnoreCase(commandslist1[5])){Global.author=true;}
				if (x[2].equalsIgnoreCase(commandslist1[6])){Global.date=true;}
					
			}	
	}
	try{
		
	}catch(Exception e){
		
	}

	String googleapilink[] ={"valmis link","http://maps.googleapis.com/maps/api/geocode/json?address=","&sensor=false"};
	googleapilink[0]=googleapilink[1]+x[0]+googleapilink[2];
				panoramio_url.googleapi(googleapilink[0]);
	}
	
	
	
	
	public static String[] failistpilt(String Faili_Nimi,int tellimus) throws Exception{
	
	int L6ike_Suurus=Global.L6ike_Suurus;
	int lugeja=Global.Lugeja;
	if (!(tellimus==0)){        // kui andsin faili nimega kaasa tellimuse numbri
		lugeja=tellimus;
	}
	int number=0;
	int LeitudPilte =0;
	String[] pilt={"","","","","","","","","0","",""};
	while (LeitudPilte<lugeja){
		number=Integer.parseInt(pilt[8]);
	
	pilt= Fail_Find_Strings_Locations_Main.pilt(Faili_Nimi, number, L6ike_Suurus);
	
	if (pilt[9].equalsIgnoreCase("4")){

		break;
	}
/*	
	String pildike="";
	int i=1;
	while (i<8){
		pildike=pildike+pilt[i];
		i++;
	}
	*/
//	System.out.println(pildike);
	LeitudPilte++;
	}
//	System.out.println("Leidus "+LeitudPilte+" pilti");
pilt[10]=""+LeitudPilte;
	
//	System.exit(0);
	return pilt;
	
	
	}
	public static void Korrasta_Fail(String Faili_Nimi) throws Exception{
System.out.println("1");
		int piltidearv=0;
		String[] pilt=functions.failistpilt(Faili_Nimi, 0);		
		piltidearv=Integer.parseInt(pilt[10]);
	String pildike="";
	int vaadeldav_pilt=0;
	int i=0;
	int pildisuurus=0;
	int sai_pilte =0;
	String Kirjutamise_Moodus="";
	while (vaadeldav_pilt<piltidearv){
		vaadeldav_pilt++;
	 pilt=functions.failistpilt(Faili_Nimi, vaadeldav_pilt);
	i=1;
	pildike="";
	while (i<8){
		pildike=pildike+pilt[i];
		i++;
	}
	System.out.println("2");
	pildisuurus=pildike.length();	
	if(pildisuurus>100){
		Fail_Write.Fail_Kirjuta("D://temp/xbufferx.txt", pildike, Kirjutamise_Moodus);
		if (vaadeldav_pilt==1){
			Kirjutamise_Moodus="append";
		}
		sai_pilte++;
	}
	}
	vaadeldav_pilt=0;
	Kirjutamise_Moodus="";
	System.out.println("3");
	while (vaadeldav_pilt<sai_pilte){
		vaadeldav_pilt++;
	 pilt=functions.failistpilt("D://temp/xbufferx.txt", vaadeldav_pilt);
	i=1;
	pildike="";
	while (i<8){
		pildike=pildike+pilt[i];
		i++;
	}
	pildisuurus=pildike.length();	
	System.out.println("4");
	
		Fail_Write.Fail_Kirjuta(Faili_Nimi, pildike, Kirjutamise_Moodus);
		if (vaadeldav_pilt==1){
			Kirjutamise_Moodus="append";
		}
	}
	File file = new File("D://temp/xbufferx.txt");
	 
	file.delete();
	
	
	System.exit(0);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static String[] panoramiostringijupitamine(String x){ // algus    googleapi hoopiski
		
	//	int ridadearv=1000;
	//	int pesadearv=6;
		
	//	String pildid[][] = new String[ridadearv][pesadearv];
		
		String googleapiparse1[]={"0","1","2","3","4"};
		String text = x;
		String operatsioon=x;
	    String otsing[]={"bounds","lat","lng","lat","lng"}; //66,
	    int a=0;
	 
	    int i =0;
	    // otsin yles bounds asukoha
	    	i=text.indexOf(otsing[a]); // kui otsing[a] asukohta ei leita, saab i v22rtuse -1
	    	
	    	//v6tan bounds kandis v2lja oma otsitavad yhte stringi edasiseks t66tlemiseks
	    	operatsioon=text.substring(i+50, i+256);
	    	operatsioon=operatsioon+"l6pp ";
	    	System.out.println("otsitavate asukohad stringis(operatsioon panoramio_parse.googleapiparse) :"+operatsioon);
	    	System.out.println("############################################################################");
	    	System.out.println("");
	    	System.out.println("############################################################################");
	    	System.out.println("");
	    	System.out.println("############################################################################");
	    	a++;
	 
	    // lugedes failist seda stringi, sain: lat+7, lng+7, lat+7, lng+7
	    // siis otsin kas koma v6i tyhiku asukoha
	    // loen vahelise ala stringiks
	    
	    int	l6pp=operatsioon.indexOf("l6pp");
	    System.out.println("l6pp : "+l6pp);
	  while (a<5){   
		  i=operatsioon.indexOf(otsing[a]); 
		  System.out.println("i="+i);
		  
	    googleapiparse1[a]=operatsioon.substring((i+7), (i+20));      
	    System.out.println(" googleapiparse1["+a+"(a)] #"+googleapiparse1[a]+"#  i+7 #"+(i+7)+"# , i+20 #"+(i+20));
	    operatsioon=operatsioon.substring((i+20), l6pp);
	    l6pp=l6pp-(i+20);
	    i=(googleapiparse1[a].indexOf(","));
	    if (i>0){												//////  teades, et peale numbrit on kas koma v6i tyhik, otsin neid stringist
	    	googleapiparse1[a]=googleapiparse1[a].substring(0, i);			////// ja l6ikan endale sobiva stringi v2listades otsitava m2rgi (koma,tyhik)
	    }else
	    {
	    	i=(googleapiparse1[a].indexOf(" "));
	    		if (i>0)
	    		{
	    			googleapiparse1[a]=googleapiparse1[a].substring(0, i);	
	    		}
	    }
	    
	    
	    System.out.println("#"+googleapiparse1[a]+"#");
	  a++;
	  }
	  
	  //System.exit(0);
	  
	    /*
	    while((i=(text.indexOf(otsing[a],i)+1))>0){
	        	
	            j[k]=i;
	            if (a==0){
	            	a++;
	            	}else{
	            		a--;
	            	}
	            k++;
	          
	       
	  
	            
	            
	            
	            if (k==5){
	            break;
	            }
	            
	        }
	        
	        a++;
	        if((a>1)||(k>3)){break;}
		
	*/	
		
		
		return googleapiparse1;
	}
	
	
	
	
	
	
	
	
	public static void googleapi(String[] x, int i) throws Exception{
		
		functions http = new functions();
		 
		//	System.out.println("Testing 1 - Send Http GET request");
			http.sendGet();
	 
		
	 
		}
	 
		// HTTP GET request
		private void sendGet() throws Exception {
			String a="http://www.panoramio.com/map/get_panoramas.php?set=public&from=";
			String b="&to=";
			String c="&minx=24.5501939&miny=59.351809&maxx=24.9262889&maxy=59.5914239&size=medium&mapfilter=true";
			int nr1=0;
			int nr2=100;
			
			long startTime; // Starting time of program, in milliseconds.
		      long endTime;   // Time when computations are done, in milliseconds.
		      double time;    // Time difference, in seconds.
			
			
			//"http://www.panoramio.com/map/get_panoramas.php?set=public&from=0&to=1500&minx=24.5501939&miny=59.351809&maxx=24.9262889&maxy=59.5914239&size=medium&mapfilter=true";
			// panoramiot suudab 500 kaupa lugeda ... kindlam on 100 kaupa teha
			String url = "";
		//	System.out.println("Täppidega tähed korda saada programmis!!!");
			System.out.println();
			StringWriter stringWriter = new StringWriter();
			BufferedWriter bufferedWriter = new BufferedWriter(stringWriter);
			
			System.out.println("Started reading into memory");
			startTime = System.currentTimeMillis();
			
			while(true){	
				url = a+nr1+b+nr2+c;
				
				
			URL obj = new URL(url);
			
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	 
			// optional default is GET
			con.setRequestMethod("GET");
			
			
			
			
			BufferedReader infile = new BufferedReader(
			        new InputStreamReader(con.getInputStream()));
			bufferedWriter.write(infile.readLine());
			infile.close();
			
			nr1=nr1+100;
			nr2=nr2+100;
			if (nr1>Global.picturelimit_from_panoramioapi){
				break;}
			}
			System.out.println("All in memory");
			System.out.println("Dumping into file");
		
		
		
		
				File file = new File("D://temp/data.txt");
		
		
		 
		// if file doesnt exists, then create it
		if (!file.exists()) {
			file.createNewFile();
		}


		FileWriter fw = new FileWriter(file,true);
		BufferedWriter bw = new BufferedWriter(fw);
		bufferedWriter.close();
		String hugeString = stringWriter.toString();
		bw.write(hugeString);
		bw.close();
		
		System.out.println("Done!");
		endTime = System.currentTimeMillis();
	      time = (endTime - startTime) / 1000.0;
	      System.out.print("\nProgram took time:  ");
	      System.out.println(time);
		
		
		}
		
	     
	private static int Kuup2evEdasiSorti(String x){
		
		String[] Kuup2evNumbriks={"",""," ","#"};
		String[] Kuud1_12={"","January","February","March","April","May","June","July",
				"August","September","October","November","December"};
		int i=0, ii=0;
		int tsykkel=0;
		int SaadudNumber=0;
//		boolean kuu=false;
	//	String originaal=x;
		x=(x+"#");
		i=x.indexOf((Kuup2evNumbriks[2]));				
		Kuup2evNumbriks[0]=x.substring(0, i);
		
		ii=x.indexOf(Kuup2evNumbriks[3]);
		x=x.substring((i+1), (ii+1));
		
		i=x.indexOf((Kuup2evNumbriks[2]));
		Kuup2evNumbriks[1]=x.substring(0, i);
		ii=x.indexOf(Kuup2evNumbriks[3]);
		Kuup2evNumbriks[2]=x.substring((i+1), ii);
		
		i=Integer.parseInt(Kuup2evNumbriks[0]);
		ii=Integer.parseInt(Kuup2evNumbriks[2]);
		tsykkel=0;
		while (tsykkel<12){
		tsykkel++;
			if (Kuup2evNumbriks[1].equalsIgnoreCase(Kuud1_12[tsykkel])){break;}
		
			if (tsykkel>=12){
			System.out.println("Functions.Kuup2evEdasiSorti : kuup2evas kuu nimest numbrit tehes tsykkel muutuja sai 13... anomaalia!!! ");
			System.exit(0);
			}
		}
		
		
		
		
		
		
		
	
		SaadudNumber=(i+(tsykkel*30)+(ii*365*12));
		
			
			return SaadudNumber;
				
				
	}
	
	

		public static panoramio_sort[] sorteerimine(panoramio_sort[] pildibaas,int Stringide_Arv_Jadas) {
			
			
			

				
			
			if (Global.descend==true){
				
				if(Global.date==true){
					if(Global.kuva==false){
						Arrays.sort(pildibaas, panoramio_sort.UPLOAD_DATE_Isortdesc);
						
					}else{

				
						System.out.println("###################################");
						System.out.println("# DATE # OWNER NAME # PHOTO TITLE #");
						System.out.println("###################################");
				int	pildilugeja=0;
				while (pildilugeja<(Stringide_Arv_Jadas)){
			System.out.println("# "+pildibaas[pildilugeja].UPLOAD_DATE_S+" # "+pildibaas[pildilugeja].OWNER_NAME+" # "+pildibaas[pildilugeja].PHOTO_TITLE+" # ");	
			pildilugeja++;
				}
					}
				}
				
				if (Global.author==true){
					if(Global.kuva==false){
						
						Arrays.sort(pildibaas, panoramio_sort.OWNER_NAMEsortdesc);
					}else{


						System.out.println("###################################");
						System.out.println(" # OWNER NAME# PHOTO TITLE # DATE #");
						System.out.println("###################################");
					
					int	pildilugeja=0;
					while (pildilugeja<(Stringide_Arv_Jadas)){
				System.out.println("# "+pildibaas[pildilugeja].OWNER_NAME+" # "+pildibaas[pildilugeja].PHOTO_TITLE+" # "+pildibaas[pildilugeja].UPLOAD_DATE_S+" # ");	
				pildilugeja++;
					}
					}
				}
				if (Global.picture==true){
					if(Global.kuva==false){
						Arrays.sort(pildibaas, panoramio_sort.PHOTO_TITLEsortdesc);
						
					}else{

						System.out.println("###################################");
						System.out.println("# PHOTO TITLE # OWNER NAME # DATE #");
						System.out.println("###################################");

					int	pildilugeja=0;
					while (pildilugeja<(Stringide_Arv_Jadas)){
				System.out.println("# "+pildibaas[pildilugeja].PHOTO_TITLE+" # "+pildibaas[pildilugeja].OWNER_NAME+" # "+pildibaas[pildilugeja].UPLOAD_DATE_S+" # ");	
				pildilugeja++;
					}
					}
				}
			}
			if (Global.ascend==true){
				if(Global.date==true){
					if(Global.kuva==false){
						Arrays.sort(pildibaas, panoramio_sort.UPLOAD_DATE_Isortasc);
						
					}else{

						System.out.println("###################################");
						System.out.println("# DATE # OWNER NAME # PHOTO TITLE #");
						System.out.println("###################################");

				int	pildilugeja=0;
				while (pildilugeja<(Stringide_Arv_Jadas)){
			System.out.println("# "+pildibaas[pildilugeja].UPLOAD_DATE_S+" # "+pildibaas[pildilugeja].OWNER_NAME+" # "+pildibaas[pildilugeja].PHOTO_TITLE+" # ");	
			pildilugeja++;
				}
				}
				}
				if (Global.author==true){
					if(Global.kuva==false){
						Arrays.sort(pildibaas, panoramio_sort.OWNER_NAMEsortasc);
						
					}else{

						System.out.println("###################################");
						System.out.println("# OWNER NAME # PHOTO TITLE # DATE # ");
						System.out.println("###################################");

					int	pildilugeja=0;
					while (pildilugeja<(Stringide_Arv_Jadas)){
				System.out.println("# "+pildibaas[pildilugeja].OWNER_NAME+" # "+pildibaas[pildilugeja].PHOTO_TITLE+" # "+pildibaas[pildilugeja].UPLOAD_DATE_S+" # ");	
				pildilugeja++;
					}
					}
				}
				if (Global.picture==true){
					if(Global.kuva==false){
						
						Arrays.sort(pildibaas, panoramio_sort.PHOTO_TITLEsortasc);
					}else{

						System.out.println("###################################");
						System.out.println("# PHOTO TITLE # OWNER NAME # DATE #");
						System.out.println("###################################");

					int	pildilugeja=0;
					while (pildilugeja<(Stringide_Arv_Jadas)){
				System.out.println("# "+pildibaas[pildilugeja].PHOTO_TITLE+" # "+pildibaas[pildilugeja].OWNER_NAME+" # "+pildibaas[pildilugeja].UPLOAD_DATE_S+" # ");	
				pildilugeja++;
					}
					}
				}
			}
			
			if((Global.ascend==false)&&(Global.descend==false)){
				if(Global.kuva==false){
					Arrays.sort(pildibaas, panoramio_sort.UPLOAD_DATE_Isortasc);
					
				}else{
					System.out.println("###################################");
					System.out.println("#    Default sort: ascend date    #");
					System.out.println("###################################");
					System.out.println("# DATE # OWNER NAME # PHOTO TITLE #");
					System.out.println("###################################");

			int	pildilugeja=0;
			while (pildilugeja<(Stringide_Arv_Jadas)){
		System.out.println("# "+pildibaas[pildilugeja].UPLOAD_DATE_S+" # "+pildibaas[pildilugeja].OWNER_NAME+" # "+pildibaas[pildilugeja].PHOTO_TITLE+" # ");	
		pildilugeja++;
			}
			}
				
			}
			


			
			
			
			
			
	//		Arrays.sort(pildibaas, panoramio_sort.OWNER_NAMEsortasc);
			
	/*	int	pildilugeja=0;
			while (pildilugeja<(Stringide_Arv_Jadas)){
		System.out.println("# "+pildibaas[pildilugeja].UPLOAD_DATE_S+" # "+pildibaas[pildilugeja].OWNER_NAME+" # "+pildibaas[pildilugeja].PHOTO_TITLE+" # ");	
		pildilugeja++;
			}
	*/		
	//		System.out.println("OK!");
	//		System.exit(0);
			return pildibaas;
			
			
			
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		public static String[] stringistjada(String x) {
		
		
		
		int algusint=0;
		int hugeStringpikkus=x.length();
		int sodilugeja=0;
		int l6puint=0;
		int[] asukoht={0,0};
		int asend=0;
		char[] ch={'{', '}'};
		int i=0;
		String[] pildidbuffrist=new String[10000];
		try{
		asend=1;
		
		while (((asukoht[asend]>-1)&&(hugeStringpikkus>0))&&(algusint>-1)){
			hugeStringpikkus=x.length();
			asend--;
			algusint=asukoht[asend]=x.indexOf(ch[asend]);
			asend++;
			l6puint=asukoht[asend]=x.indexOf(ch[asend]);
			l6puint++;
			
			pildidbuffrist[sodilugeja]=(x.substring(algusint, l6puint));
			if((pildidbuffrist[sodilugeja].length())>250){
			//	System.out.println(""+pildidbuffrist[sodilugeja]+" j2rjekorra nr: "+sodilugeja+" stringi pikkus: "+pildidbuffrist[sodilugeja].length());
				sodilugeja++;
				
				
			}
			x=x.substring(l6puint);
			
			
		}
		
		
		
		
		}
		catch(Exception ex){}
		String[] pildidbuffristsorti=new String[sodilugeja];
		i=0;
		while (i<(sodilugeja)){
			pildidbuffristsorti[i]=pildidbuffrist[i];
		//	System.out.println(""+pildidbuffristsorti[i]+" j2rjekorra nr: "+i+" stringi pikkus: "+pildidbuffristsorti[i].length());	
			i++;
		}
		Global.Stringide_Arv_Jadas=sodilugeja;

		return pildidbuffristsorti;
		
		
		
		
		
	
		
		}
		
		
		
		public static panoramio_sort[] puzzle(String[] x,int Stringide_Arv_Jadas) {
			
			System.out.print("Cutting pictures into puzzle...");
			
/*			
			int proovi=0;
			while (proovi<(Stringide_Arv_Jadas)){
				
				System.out.println(""+x[proovi]+" j2rjekorra nr: "+proovi+" stringi pikkus: "+x[proovi].length());	
				proovi++;
			}
*/
		 	
			String otsing[]={"}" ,"owner_name\":\"" , "photo_title\":\"" , "upload_date\":\"" , "\""};
			//                0          1                   2                     3             4
		//	int objektidearv=Stringide_Arv_Jadas;
			String sisu1="";// otsing owner_name":"  + 13
			String OWNER_NAME="";   // otsing "
			String sisu2="";// otsing photo_title":" + 14
			String PHOTO_TITLE="";  // otsing "
			String sisu3="";// otsing upload_date":" + 14
			String UPLOAD_DATE_S="";// otsing "
			String sisu4="";//         otsing }      + 1
			String jupp="";
			int UPLOAD_DATE_I=0; 
			int siblija=0;
	//		int kuup2ev=0;
	//		String vahepala="";
		
		
		panoramio_sort[] pildibaas= new panoramio_sort[Stringide_Arv_Jadas];	
		int i=0;
		while (i<Stringide_Arv_Jadas){
			
			jupp=x[i];
			

			
			
			siblija=(jupp.indexOf(otsing[1]))+13;
			sisu1=jupp.substring(0, siblija);
//			System.out.println(sisu1+" jada suurus : "+Stringide_Arv_Jadas);
//			pildibaas[i].sisu1=(sisu1);
			
			jupp=jupp.substring(siblija);
			siblija=(jupp.indexOf(otsing[4]));
			OWNER_NAME=jupp.substring(0, siblija);
//			pildibaas[i].setOWNER_NAME(jupp.substring(0, siblija));
			jupp=jupp.substring(siblija);
			
			siblija=(jupp.indexOf(otsing[2]))+14;
			sisu2=jupp.substring(0, siblija);
//			pildibaas[i].setsisu2(jupp.substring(0, siblija));
			jupp=jupp.substring(siblija);
			siblija=(jupp.indexOf(otsing[4]));
			PHOTO_TITLE=jupp.substring(0, siblija);
//			pildibaas[i].setPHOTO_TITLE(jupp.substring(0, siblija));
			jupp=jupp.substring(siblija);
			
			siblija=(jupp.indexOf(otsing[3]))+14;
			sisu3=jupp.substring(0, siblija);
//			pildibaas[i].setsisu3(jupp.substring(0, siblija));
			jupp=jupp.substring(siblija);
			siblija=(jupp.indexOf(otsing[4]));
			UPLOAD_DATE_S=jupp.substring(0, siblija);
//			pildibaas[i].setUPLOAD_DATE_S(jupp.substring(0, siblija));
			UPLOAD_DATE_I=functions.Kuup2evEdasiSorti(UPLOAD_DATE_S);
//			pildibaas[i].setUPLOAD_DATE_I(kuup2ev);
			jupp=jupp.substring(siblija);
			
			siblija=(jupp.indexOf(otsing[0]))+1;
			sisu4=jupp.substring(0, siblija);
//			pildibaas[i].setsisu4(jupp.substring(0, siblija));

			pildibaas[i]=new panoramio_sort(sisu1,OWNER_NAME,sisu2,PHOTO_TITLE,sisu3,UPLOAD_DATE_S, UPLOAD_DATE_I,sisu4);				
			
		//	System.out.println(i+" "+pildibaas[i].sisu1+pildibaas[i].OWNER_NAME+pildibaas[i].sisu2+pildibaas[i].PHOTO_TITLE+pildibaas[i].sisu3+pildibaas[i].UPLOAD_DATE_S+pildibaas[i].sisu4);
			i++;
		}
		System.out.println("done!");
		System.out.println();
		return pildibaas;
}
		
		
		
		
		
		
		
		
		
		
		
		
		
		///faili l6pp
	
	}
	
	
	
	
		
														


