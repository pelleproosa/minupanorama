package Minu_Panorama;




 
public class Minu_Panorama {
 static String jada[];

 
	public static void main(String[] args) throws Exception {
		
		
		
		// java -jar panoramio.jar kuressaare force ascend picture
		// java -jar panoramio.jar tallinn force ascend picture
		
            // 1)> Võtan command line sisestuse stringina ja annan edasi parse class-ile
		
/*	long	startTime = System.currentTimeMillis();
	long	endTime = System.currentTimeMillis();
	double	time = (endTime - startTime) / 1000.0;
		System.out.print("\nProgram took time: about ");
		System.out.println(time+" seconds");
*/
		
		
		
/*		
		functions.Korrasta_Fail("D://temp/kuusalu.txt");
		System.exit(0);
		
*/		
		try{
            jada = args;
		}
		catch(Exception viga)
		{ //veateate kohaselt pole tegemist integeriga
		panoramio_text.inputerror();
		panoramio_text.commands();
		System.exit(0);
		}
          //  System.out.println("asun edasi saatma");
	
            panoramio_parse.fromcommandline(jada);
            // >1)
          //  panoramio_text.commands();
		
		
		
		
		
	
	}

}