package Minu_Panorama;


import java.util.Comparator;




public class panoramio_sort implements Comparable<panoramio_sort>{
	public String sisu1="";
    public String OWNER_NAME="";
    public String sisu2="";
    public String PHOTO_TITLE="";
    public String sisu3="";
    public String UPLOAD_DATE_S="";
    public int UPLOAD_DATE_I=0;
    public String sisu4="";
   
    
    public panoramio_sort(String a, String b, String c, String d, String e, String f, int g, String h){
    //	super();
    	sisu1=a;
        OWNER_NAME=b;
        sisu2=c;
        PHOTO_TITLE=d;
        sisu3=e;
        UPLOAD_DATE_S=f;
        UPLOAD_DATE_I=g;
        sisu4=h;
    
    }
    
    public String getsisu1() {
		return sisu1;
	}
	public void setsisu1(String sisu1) {
	//	this.sisu1 = sisu1;
		this.sisu1 = sisu1;
	}
	
	 public String getOWNER_NAME() {
			return OWNER_NAME;
		}
		public void setOWNER_NAME(String OWNER_NAME) {
			this.OWNER_NAME = OWNER_NAME;
		}
		public String getsisu2() {
			return sisu2;
		}
		public void setsisu2(String sisu2) {
			this.sisu2 = sisu2;
		}
		public String getPHOTO_TITLE() {
			return PHOTO_TITLE;
		}
		public void setPHOTO_TITLE(String PHOTO_TITLE) {
			this.PHOTO_TITLE = PHOTO_TITLE;
		}
		public String getsisu3() {
			return sisu3;
		}
		public void setsisu3(String sisu3) {
			this.sisu3 = sisu3;
		}
		public int getUPLOAD_DATE_I() {
			return UPLOAD_DATE_I;
		}
		public void setUPLOAD_DATE_I(int UPLOAD_DATE_I) {
			this.UPLOAD_DATE_I = UPLOAD_DATE_I;
		}
		public String getUPLOAD_DATE_S() {
			return UPLOAD_DATE_S;
		}
		public void setUPLOAD_DATE_S(String UPLOAD_DATE_S) {
			this.UPLOAD_DATE_S = UPLOAD_DATE_S;
		}
		public String getsisu4() {
			return sisu4;
		}
		public void setsisu4(String sisu4) {
			this.sisu4 = sisu4;
		}
    
   
		
		public static Comparator<panoramio_sort> UPLOAD_DATE_Isortasc 
        = new Comparator<panoramio_sort>() {
		    public int compare(panoramio_sort UPLOAD_DATE1, panoramio_sort UPLOAD_DATE2) {
		    	 
			      String UPLOAD_DATE11 = Integer.toString(UPLOAD_DATE1.getUPLOAD_DATE_I());
			      String UPLOAD_DATE22 = Integer.toString(UPLOAD_DATE2.getUPLOAD_DATE_I());
			      
			      //ascending order
			      return UPLOAD_DATE11.compareTo(UPLOAD_DATE22);
		 

			      //descending order
			      //return name22.compareTo(name11);
			    }
		 
			};
			
			public static Comparator<panoramio_sort> UPLOAD_DATE_Isortdesc 
	        = new Comparator<panoramio_sort>() {
			    public int compare(panoramio_sort UPLOAD_DATE1, panoramio_sort UPLOAD_DATE2) {
			    	 
				      String UPLOAD_DATE11 = Integer.toString(UPLOAD_DATE1.getUPLOAD_DATE_I());
				      String UPLOAD_DATE22 = Integer.toString(UPLOAD_DATE2.getUPLOAD_DATE_I());
				      
				      //ascending order
				      return UPLOAD_DATE22.compareTo(UPLOAD_DATE11);

				    }
			 
				};
			
			
			
		
		
		
		
		
		public static Comparator<panoramio_sort> OWNER_NAMEsortasc 
        = new Comparator<panoramio_sort>() {
		    public int compare(panoramio_sort OWNER_NAME1, panoramio_sort OWNER_NAME2) {
		    	 
			      String OWNER_NAME11 = OWNER_NAME1.getOWNER_NAME().toUpperCase();
			      String OWNER_NAME22 = OWNER_NAME2.getOWNER_NAME().toUpperCase();
		 
			      //ascending order
			      return OWNER_NAME11.compareTo(OWNER_NAME22);
		 
			      //descending order
			      //return name22.compareTo(name11);
			    }
		 
			};
			public static Comparator<panoramio_sort> OWNER_NAMEsortdesc 
	        = new Comparator<panoramio_sort>() {
			    public int compare(panoramio_sort OWNER_NAME1, panoramio_sort OWNER_NAME2) {
			    	 
				      String OWNER_NAME11 = OWNER_NAME1.getOWNER_NAME().toUpperCase();
				      String OWNER_NAME22 = OWNER_NAME2.getOWNER_NAME().toUpperCase();
			 
				      //ascending order
				      return OWNER_NAME22.compareTo(OWNER_NAME11);

				    }
			 
				};
				
				
				
				
				public static Comparator<panoramio_sort> PHOTO_TITLEsortasc 
		        = new Comparator<panoramio_sort>() {
				    public int compare(panoramio_sort PHOTO_TITLE1, panoramio_sort PHOTO_TITLE2) {
				    	 
					      String PHOTO_TITLE11 = PHOTO_TITLE1.getPHOTO_TITLE().toUpperCase();
					      String PHOTO_TITLE22 = PHOTO_TITLE2.getPHOTO_TITLE().toUpperCase();
				 
					      //ascending order
					      return PHOTO_TITLE11.compareTo(PHOTO_TITLE22);
				 
					      //descending order
					      //return name22.compareTo(name11);
					    }
				 
					};
					public static Comparator<panoramio_sort> PHOTO_TITLEsortdesc 
			        = new Comparator<panoramio_sort>() {
					    public int compare(panoramio_sort PHOTO_TITLE1, panoramio_sort PHOTO_TITLE2) {
					    	 
						      String PHOTO_TITLE11 = PHOTO_TITLE1.getPHOTO_TITLE().toUpperCase();
						      String PHOTO_TITLE22 = PHOTO_TITLE2.getPHOTO_TITLE().toUpperCase();
					 
						      //ascending order
						      return PHOTO_TITLE22.compareTo(PHOTO_TITLE11);

						    }
					 
						};
				
				
				
				
				

		@Override
		public int compareTo(panoramio_sort o) {
			// TODO Auto-generated method stub
			return 0;
		}
		}

	

