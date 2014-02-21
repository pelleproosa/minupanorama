package Minu_Panorama;
/*
 * 1) fromcommandline checks input string array from user(from Minu_Panorama)
 * limits counted commands to 4 variables
 * and forwards it with counted commands value to functions.usercommandverify(jada,i);
 * 
 * 
 * 
 * */
public class panoramio_parse {
	
public static void fromcommandline(String[] x) throws Exception{  ///// 1) > 
	String jada[]={"1","2","3","4"};
	String str1="";										 
	try{
	try{
		if (x[0].equals("help")){
			panoramio_text.commands();
			System.exit(0);
		}
		try{
		str1=x[0];
		x[0]=str1;
		}catch(Exception eee){
			panoramia_help.commands();
			System.exit(0);
		}
		str1=x[1];
		
	}catch(Exception ee){
		jada[1]="ascend";
		jada[2]="date";
		
	}
	
	if ((x[1].equalsIgnoreCase("ascend"))&&(x[2].equalsIgnoreCase("descend"))){
		try{
				x[2]=x[3];
				x[3]="";
			}
		catch(Exception viga){ 
				
			}
	}
		if ((x[1].equalsIgnoreCase("descend"))&&(x[2].equalsIgnoreCase("ascend"))){
			try{
					x[2]=x[3];
					x[3]="";
				}
			catch(Exception viga){ 
					
				}
		}
			
			
			
			
			
			
		int i=0;
			
			
			while (true){ // while 1) >  
		try{
			jada[i]=x[i];                        //// neljaliikmelisele jadale omistab rohkem v‰‰rtusi ja saab provotseeritud exceptioni
		//	System.out.println("parse_fromcommandline liige nr: "+i+" on:_"+x[i]+"_");  /// 
			if (jada[i]==null){
				System.out.println("panoramio_parse.fromcommandline : jada esimene liige on tyhi");
			}
				
			
			i++;
			}
		catch(Exception viga){                  //
			if (i<3){
			while(true){            // kui oli alla 4 liikme, siis functionis tekib if lausetes error... teen lisaks tyhjad liikmed
			i++;
			jada[i]="";
			
		if (i>=3)	{break;}
			}
			}
			
			i--;
		//	System.out.println("break sees on panoramio parses lugeja i:"+i+"");  /// coding help... delete later
			break;
			}
		
		
		
		
		
		}// > while 1)
	}catch(Exception viga)
	{ //veateate kohaselt pole tegemist integeriga
	panoramio_text.inputerror();
	panoramio_text.commands();
	System.exit(0);
	}


	functions.usercommandverify(jada);
	}
											// > 1)


public static String[] googleapiparse(String x){
	
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
    	a++;
    // lugedes failist seda stringi, sain: lat+7, lng+7, lat+7, lng+7
    // siis otsin kas koma v6i tyhiku asukoha
    // loen vahelise ala stringiks
    int	l6pp=operatsioon.indexOf("l6pp");
  while (a<5){   
	  i=operatsioon.indexOf(otsing[a]); 
    googleapiparse1[a]=operatsioon.substring((i+7), (i+20));      
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
  a++;
  }
  	return googleapiparse1;
}



}
