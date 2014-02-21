package Minu_Panorama;


/*Contains functions: 
 * 
 * 1) commands  >>>> text display
 * panoramia_help.commands();
 * 
 * 2) apilink   >>>> provides string arrays: googleapilink and panoramioapilink. Returns one link as String array.
 * mystringarray=panoramia_help.apilink(x); <<< if x=1, returns googleapi link, if x=2, returns panoramioapi link.
 * 
 * 
 * 
 * */


public class panoramia_help {

	
	static void commands(){
		System.out.println();
		System.out.println("Please type commands like this:");
		System.out.println("");
		System.out.println("java -jar panoramio.jar kuressaare force ascend picture");
		System.out.println("java -jar panoramio.jar kuressaare descend date");
		System.out.println("java -jar panoramio.jar kuressaare force ascend author");
		System.out.println("java -jar panoramio.jar kuressaare force");
		System.out.println("");
	}	
	
	public static String[] apilink(int x){

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
	}
	

	
}
