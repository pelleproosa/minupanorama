package Minu_Panorama;




/*Contains functions: 
 * 
 * 1) commands  >>>> text display
 * panoramia_help.commands();
 * 
 * 2) apilink   >>>> provides string arrays: googleapilink and panoramioapilink. Returns one link as String array.
 * mystringarray=panoramia_help.apilink(x); <<< if x=1, returns googleapi link, if x=2, returns panoramioapi link.
 * 
 * 3) inputerror >> text display
 * panoramia_help.inputerror();
 * 
 * 4) commandslist for functions.usercommandsverify
 * 
 * 5) noforcenosort for functions.usercommandverify
 * 
 * */


public class panoramio_text {  


	
	static void commands(){  	 // 1) >
		System.out.println("####################################################################################");
		System.out.println("#                                                                                  #");
		System.out.println("# Panoramio Help                                                                   #");
		System.out.println("#                                                                                  #");
		System.out.println("# Just type commands separated by space.                                           #");
		System.out.println("#                                                                                  #");
		System.out.println("# java -jar panoramio.jar Address BufferForce Sorting                              #");
		System.out.println("#                                                                                  #");
		System.out.println("# Example command:                                                                 #");
		System.out.println("# java -jar panoramio.jar address force ascend/descend picture/author/date         #");
		System.out.println("#                                                                                  #");
		System.out.println("# Example command:                                                                 #");
		System.out.println("# java -jar panoramio.jar tallinn                                                  #");
		System.out.println("# gets pictures about tallinn and shows their info                                 #");
		System.out.println("#                                                                                  #");
		System.out.println("# Example command:                                                                 #");
		System.out.println("# java -jar panoramio.jar tallinn force descend picture                            #");
		System.out.println("# gets pictures from web and display them sorted by picture names in descend mode. #");
		System.out.println("# ");
		System.out.println("####################################################################################");

		
		
	}							// > 1) 
	
	public static String[] apilink(int x){	// 2) >

		String googleapilink[]={
			"http://maps.googleapis.com/maps/api/geocode/xml?address=", "rakvere", "&sensor=false"
	};

	// 
	String panoramioapilink[]={
		"http://www.panoramio.com/map/get_panoramas.php?set=public&from=", "0", "&to=", "10", "&minx=", "&minx=", "24.5501939", "&miny=", "59.351809", "&maxx=", "24.9262889", "&maxy=", "59.5914239", "&size=", "medium", "&mapfilter=", "true"	
	};

	if (x==1){
	return googleapilink;	
	}
	if (x==2){
	return panoramioapilink;	
	}
	return null;
	}										// > 2)
	
	
	static void inputerror(){				// 3) >
		
		System.out.println();
		System.out.println("Input Error!");
		System.out.println();
		System.out.println("You did not input proper command.");
		System.out.println();
	}										// > 3)

	public static String[] commandslist(){	// 4) >
		String commandslist1[]={"address","force","ascend","descend","picture","author","date"};
		return commandslist1;
	}										// > 4)
	
	public static void noforcenosort(){			// 5) >
		System.out.println("");
		System.out.println("Executing program without forcing buffer and without sort");
		System.out.println("");
		System.out.println("For commands help, type help");
		System.out.println("");
	}										// > 5)
	
	
	
}
