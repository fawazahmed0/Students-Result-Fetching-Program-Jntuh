//Thinks not completed fully for this program,have to test and see many things

// To run for other hallticket like 8P,run this program twice using different hallticket,both will run simultoneously
//you will get 'display selected console' option to choose the consoles for running program output ,in console box
// or put halltickets in hallcodetogenerate

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.ArrayUtils;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;


import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.tidy.Tidy;

import com.itextpdf.text.Anchor;

import com.itextpdf.text.Document;

import com.itextpdf.text.Font;

import com.itextpdf.text.Paragraph;

import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
/*


fit in one page
*/



//Links for diff results http://epayments.jntuh.ac.in/results/jsp/home.jsp
	
	//should have exam code
	
	// for result get only tables

public class jsptrynew {
 static  String allofhalltickets =  "";
 static  String allofhallticketssupply = "";
 static String allofhallticketsnormal = "";
	//To get toppers from each branch
 static Boolean topper;
    //For synchronization of threads
	static final Object lock0 = new Object();
	static final Object lock1 = new Object();
	static final Object lock2 = new Object();
	static final Object lock3 = new Object();
	static final Object lock4 = new Object();
	//Number of students or Number of halltickets to generate for each branch
	
	    // Things to change
	    public static int max = 240;
	    static Boolean supply = true;
	    public static int supplyno = 1;
	    public static int maxinvalidhall = 50;
		static int timesforthread  = 3;           //1254
		static String link = "http://epayments.jntuh.ac.in/results/jsp/SearchResult.jsp?degree=btech&examCode=1277";
		static String[] hallcodetogenerate = {"148P1A"};
		static Boolean automatic = false;
		static int timetowait = 0;
		static String[] headname = {"B.Tech","III Year","III B.Tech","II Sem","R13","Regular",""};
	
	//array of branch codes
	static int[] a = new int[]{01,02,03,04,05,12,21};
	
	//object to hold toppers rollno,name and marks
	 static chekhigh[] topperobj = new chekhigh[a.length];
	
	 
	 public static int nooftimesinvalid = 0;
//	static String[] testlink = {"http://202.63.105.184/RESULT/homepage.jsp?id=1&name=BT11S13S052016M","http://202.63.105.185/RESULT/homepage.jsp?id=1&name=BT11S13S052016M"};
	
	 /*
		 * maxinvalidhall should always be   more than 2*timesforthread
		 * because somes halltickets might not get extracted
		 * For Reevaluation and Recounting and Supply result keep maxinvalidhall as max
		 */

    static String examname = "";
	static String topperstring = "";

	static Boolean lateralboolean = true;

	//just putting value false to remove someinit dependency
	
	//all results modified source code
	static String allhtml  = "";

	//variable to store toppers high marks
	static int[] checkhigh = new int[a.length];
	// http://202.63.105.184/RESULT/homepage.jsp?id=1&name=BT22R13R052016M
	
		//http://202.63.105.184/RESULT/homepage.jsp?id=1&name=BTECH31R13_1207
	// http://epayments.jntuh.ac.in/results/jsp/home.jsp
	
	
	
	static String sorted = "";
	static String getcaptcha = "";
	static String modify = "";

	static int hallnoz = 0;
	

	// static int autocheckno = 0;
	//add more things in headname ,for automatic check
		
		static String genericlink = "http://epayments.jntuh.ac.in/results/jsp/home.jsp";
	
	
	public static void main(String args[]) {
		
		try{
			System.setProperty("webdriver.gecko.driver","C:\\Users\\Nawaz\\workspace\\Hallticket\\jars\\Firefox Driver\\geckodriver.exe");
			while(automatic&&!autocheck()){
		Thread.sleep(timetowait);
 //   300000  5 min
		}
			
			if(maxinvalidhall<(2*timesforthread)){
				maxinvalidhall=(2*timesforthread)+1;
				System.out.println("Increased maxinvalidhall to :"+ maxinvalidhall);
				
			}
			
		for(;hallnoz<hallcodetogenerate.length;hallnoz++){
			
		allofhalltickets = "";
			allofhallticketssupply = "";
			allofhallticketsnormal = "";
			    //For synchronization of threads
	
				//Number of students or Number of halltickets to generate for each branch
			
				
				
			
			
				
				//array of branch codes
			//	a = new int[]{01,02,03,04,05,12,21};
				
				//object to hold toppers rollno,name and marks
			topperobj = new chekhigh[a.length];
				
				 
				nooftimesinvalid = 0;
				
		
			    examname = "";
				topperstring = "";

		
		
			
				//all results modified source code
				allhtml  = "";

				//variable to store toppers high marks
			checkhigh = new int[a.length];
			
		//	autocheckno = 0;
				
				
				//342
				
				
				
				sorted = "";
				getcaptcha = "";
				modify = "";

		
				
		
		
		System.out.println("before someinit and doing");
		
		
		//someinit will check for supply and generate more previous years halltickets based on supply number 
	//	someinit();
		doing();
		}
			
	
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("error inside main method");
		}
		}
	
	
	static void doing(){
		System.out.println("in doing");
		try{
			
			//initializing all objj arrays ,otherwise it will throw NullPointerException
			for(int jmx = 0;jmx<a.length;jmx++){
				topperobj[jmx] = new chekhigh();
			}
		
	//		 getcaptcha = FileUtils.readFileToString(new File("jsptry.js"), "Cp1252");
			 modify = FileUtils.readFileToString(new File("jspmodify2.js"), "Cp1252");
		
			//Creating Hallticket Numbers
			 if(supply){
				 topper = false;
					
					String year = 	hallcodetogenerate[hallnoz].substring(0,2);
					int j = Integer.parseInt(year);
					for(int i=0;i<=supplyno;i++){
				
					
					String oldhallcode = Integer.toString(j)+ hallcodetogenerate[hallnoz].substring(2);
					creating(oldhallcode);
					j=j-1;
					
					}
					
				
			
			 
			 
			 }else {
				 topper = true;
				 creating(hallcodetogenerate[hallnoz]);
				 
			 }
				  Thread[] threads = new Thread[timesforthread];
			 for (int i = 0; i < threads.length; i++) {
				      threads[i] = new Thread(new Runnable()  {
				          public void run()  {
				        	
				        	  Boolean toallowhalling = false;
				        	  String prevhallno="";
				                String   hallno = "";
				                int bigloopbreak = 0;
				                int quitbr = 0;
				                JavascriptExecutor js = null;
				               Boolean refresh = false;
				                WebDriver  driver;
				                FirefoxProfile prof = new FirefoxProfile();
				            	prof.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/zip");
				            	prof.setPreference("print.always_print_silent", true);
				            	 prof.setPreference("browser.download.folderList",2);
				            	    prof.setPreference("browser.download.manager.showWhenStarting",false);
				            	    prof.setPreference("browser.download.dir","D:\\");
				            	    prof.setPreference("browser.helperApps.neverAsk.saveToDisk","text/csv");
				            	    prof.setPreference("dom.successive_dialog_time_limit", 0);
				   //   	   
				      //  	  synchronized(lock0) {   
				         	//      driver = new PhantomJSDriver();   
				        //    	    DesiredCapabilities dcaps = new DesiredCapabilities();
				       //     	    dcaps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,"C:/Program Files/phantomjs-2.1.1-windows/bin/phantomjs.exe" );
				       //     	    dcaps.setCapability("takesScreenshot", false);
				   //     	  	 driver = new FirefoxDriver(prof);  
				      driver = new HtmlUnitDriver(true);
			    //     	   driver.setJavascriptEnabled(true);
				        	
				            	
				            	  	 
			//	          }
				        		
				            
				            	 
				            	    
				       outerwhile:   	 while((!allofhalltickets.isEmpty())||hallno!=""){
				    //	   System.out.println("inside outerwhile");
				    	 
				    	   
				    	   try{
				    		
				    		   
				    		
				    	   //new code
				    	// If the program is trying hallticket for many number of times,then close the browser and start it again
				    	prevhallno=hallno;
		    			   if(quitbr>20){
		    				   System.out.println("Inside quitbr");
		    				   driver.quit();
						    	driver = new HtmlUnitDriver(true);
				  //    	  	 driver = new FirefoxDriver(prof);  
						    	
						    	quitbr=0;
		    			   }
		    			   
		    				 driver.get(link);
				            	(new WebDriverWait(driver, 30))
					          		  .until(ExpectedConditions.presenceOfElementLocated(By.name("htno")));
				            	//	 driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);	
				            			   js = (JavascriptExecutor) driver; 
		    				//
				    		/*
				    		   if(refresh){
				    			   System.out.println("Inside refresh");
				    			   
				    			
				    			   
		
				    			   driver.get(link);
		            		//	(new WebDriverWait(driver, 30))
		            		//	  .until(ExpectedConditions.presenceOfElementLocated(By.name("htno")));
		               		// js.executeScript(getcaptcha);
				    			   driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);	
		               		refresh=false;
		            		autocheckno=0;
		            	
				    		   }
				    	   */
				    	   }catch(Exception e){
				    		   e.printStackTrace();
				    		  
				    		   continue outerwhile;
				    	   }
				    	   
				    		 synchronized(lock1) {
				            			
				            	    if(toallowhalling||hallno==""){
				            	    	
				            	    	try{
				            	    	//It will throw stringindexoutof bound exception	
				            		  hallno= hallnoing(); 
				            		  System.out.println("Trying for "+hallno);
				            		  toallowhalling=false;
				            	    	}catch(Exception e){
				            	    		System.out.println("Error while assigning hallno");
				            	    		e.printStackTrace();	
				            	    		break outerwhile;
				            	    	
				            	    	}
				            	    }
				            	 
				            	    
				            	
				            	 
				            	     }
				            //new code
				    	//	 increasing quitbr,If the program is trying hallticket for many number of times,then close the browser and start it again
				    		 if(hallno.equalsIgnoreCase(prevhallno)){
				    			   quitbr++;
				    				}
				    		 else{
				    					quitbr=0;
				    				}
				    				
				    		 //
				    		 
				    		 
					            	try{
				            	
					            	
					            		   WebElement element11 = driver.findElement(By.name("htno"));
					            		    WebElement element12 = driver.findElement(By.id("datepicker"));
					            		    WebElement element13 = driver.findElement(By.id("txtInput"));
					            		    WebElement element14 = driver.findElement(By.cssSelector("[type='submit']"));
					            		    element11.clear();
					            		    element12.clear();
					            		    element13.clear();
					            		    
					            		    
					            		    js.executeScript("document.getElementById('htno').setAttribute('value', '"+hallno+"')");
					            		    //    element11.sendKeys("14E31A0577");
					            		        System.out.println("trying for ");
					            		   //     element12.click();
					            		     //   element12.sendKeys("1991-07-03");
					            		        js.executeScript("document.getElementById('datepicker').setAttribute('value', '1991-07-03')");
					            		        
					            		    //    String captcha = (String) js.executeScript("return document.getElementById('txtCaptcha').value");
					            		    //    System.out.println(captcha);
					            		    //    element13.click();
					            		    //    element13.sendKeys(captcha);
					            		        js.executeScript("document.getElementById('txtInput').setAttribute('value', document.getElementById('txtCaptcha').value)");

					            		        
					            		        element14.click();
					            		        /*
					            		        (new WebDriverWait(driver, 30))
					            		  	  .until(ExpectedConditions.presenceOfElementLocated(By.tagName("table")));
					            		       */ 
//					            		 	String generaddress = link.replace("http://epayments.jntuh.ac.in", "");
					            		 //.out.println(generaddress);
					            		 	// String headings= "hello";
//					            		 	System.out.println(driver.getPageSource());
					            		 //      driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
					            	      
					       
					            
					            	}catch(Exception e){
					            		
					            		e.printStackTrace();
					            		
					            		continue outerwhile;
					            	}   	    
					            	    
					            	    
					            	    
					            	    
					            	    
					            	    
					            	    
					            	    
					            	    
					            	    
					            	    
					            
					             

					              
					             
					            
					             
					        
					             
					                
					        
				        		
				           	
				            		
				  
				           
				            String   pleasetry = "invalid hallticket number";
				            
				           
				           

				               
				               
				               try{   
				                
				               
				            	

				              
				          
				            	   synchronized(lock1) {
				                if(nooftimesinvalid>maxinvalidhall){
				                	
				                	try
				                	{
				                		shorting();
				                	}catch(Exception e)
				                	{
				                		System.out.println("Error while shorting");
				                		e.printStackTrace();
				                		break outerwhile;
				                		}
				                	nooftimesinvalid=0;
				                	continue outerwhile;
				                }
				            	   }
				                	
				              
				             
				            	   String  testval;


				          
				        
				            
				             toallowhalling = false;
				                	
				             String hallrez = "";
				             String  invalidhall ="";
				             String validno = "";
				               try { 
				            	   invalidhall = driver.findElement(By.cssSelector("#myForm > div > table > tbody > tr:nth-child(1) > td:nth-child(3) > div")).getText();
				               	   }catch(Exception e) {e.printStackTrace();}
				             
				               try { 
				            	     hallrez = driver.findElement(By.cssSelector("body > form > table > tbody > tr:nth-child(1) > td:nth-child(2) > b")).getText();
				            	       }catch(Exception e) {e.printStackTrace();}
				               try { 
				            	     validno = driver.findElement(By.cssSelector("table:last-child tr:nth-child(2) td:first-child")).getText();
				            	       }catch(Exception e) {e.printStackTrace();}
				            	  //Removing hallticket results with no subjects
				               if(validno.equalsIgnoreCase("total")) {
				            	    	
				            	    	hallno="";        

				            	    	toallowhalling = true;    
				            	    	nooftimesinvalid=0;
				            	    	continue outerwhile;
				            	    	
				            	    } 	     

				               
				             if(hallrez.equals(hallno)) {
				          //     System.out.println(driver.getPageSource());
				            	 

						            
				        	     
					        	   
				            	  examname = driver.findElement(By.cssSelector("body > form > h6")).getText();
				        	      WebElement elem16 = driver.findElement(By.cssSelector("body > form > h6"));
					        	  	 WebElement elem14 = driver.findElement(By.cssSelector("body > form > table"));
					        	  	WebElement elem17 = driver.findElement(By.cssSelector("table:last-child"));
					        	 	synchronized(lock1) {	



//Below code is not for B.Pharm or anything which is not in array a     

//calculating topperz
if(topper){ 
String elemtotal = driver.findElement(By.cssSelector("table:last-child tr:last-child td:nth-child(2) > b")).getText();
String elemname = driver.findElement(By.cssSelector("body > form > table > tbody > tr:nth-child(1) > td:nth-child(4) > b")).getText();
String elemrno = driver.findElement(By.cssSelector("body > form > table > tbody > tr:nth-child(1) > td:nth-child(2) > b")).getText();


String last1 = hallno.substring(6,8);
int indexi = ArrayUtils.indexOf(a, Integer.parseInt(last1));

System.out.println(indexi+" "+hallno);
//element not inside the array
if(indexi==-1)
indexi++;


if(Integer.parseInt(elemtotal)==checkhigh[indexi]){

topperobj[indexi].rno = topperobj[indexi].rno +" ^ " +elemrno;
topperobj[indexi].name = topperobj[indexi].name+" ^ "+ elemname;
topperobj[indexi].marks =topperobj[indexi].marks; 



topperobj[indexi].branchcode = last1;

}

if(Integer.parseInt(elemtotal)>checkhigh[indexi]){
System.out.println("elemtotal:"+elemtotal);

checkhigh[indexi]= Integer.parseInt(elemtotal);

topperobj[indexi].rno = elemrno;
topperobj[indexi].name = elemname;
topperobj[indexi].marks = elemtotal;
topperobj[indexi].branchcode = last1;
System.out.println("Name of the student"+topperobj[indexi].name);


}
}

   js.executeScript(modify);     
allhtml = allhtml + "<html><body>"+"<img src='image.png' />" + elem16.getAttribute("innerHTML") + elem14.getAttribute("innerHTML") +elem17.getAttribute("innerHTML")+"</body></html>";
System.out.println(hallno);
hallno="";        

toallowhalling = true;    
nooftimesinvalid=0;
}



				             }
				             else if(invalidhall.equals("invalid hallticket number")) {
				            	 
				            	//   System.out.println(driver.getPageSource());
				            	 System.out.println("Invalid hallticket");
				            	 toallowhalling = true;
				            	 nooftimesinvalid++;
				            	 continue outerwhile;
				             }
				             else {
				            	 toallowhalling=false;
				            	 continue outerwhile;
				            	 
				             }  		
				                
				                    
				                     
				                      
				               
				                			                	
				                	//End of while loop
				          
				                      
				         
				                
				    

				             
				         		 }catch(Exception e){
				         			 e.printStackTrace();
				         			 
				         			toallowhalling= false;
				         				continue;
				         		
				             	 }
				         	}
	                 
	              
	                    System.out.println("Before Quittting");
	              
	              
			
	                    
	                   
	                
	        			driver.quit();
	              
	            
	               	 
	               	 
	             
				          
				          
				          } 
				           });
				      threads[i].start();
				     
				  }
				  for (Thread thread : threads) {
					    thread.join();
					}
			
				
				
				if(supply){
					allofhalltickets  = allofhallticketssupply;
				}
				else{
					//creating(hallcodetogenerate[hallnoz]);
					allofhalltickets = allofhallticketsnormal;
					
				}
			
				sortinghtml();
				
				makepdf();
			
				System.out.println("End  ............................");
				
				
				for(int jm = 0;jm<a.length;jm++){
					if(topperobj[jm].rno!="")
					System.out.println(topperobj[jm].rno+"\n"+topperobj[jm].marks+"\n"+topperobj[jm].name);
							}

		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
		
		
		
		
	}
	
	
	
	static void sortinghtml(){
		try{
		while(!allofhalltickets.isEmpty()){
			
			String hallno = hallnoing();
			if(allhtml.contains(hallno)){
				int inx = allhtml.indexOf(hallno);
				int shtmltag = allhtml.lastIndexOf("<html", inx);
				int ehtmltag = allhtml.indexOf("</html", inx);
				
			
				String st = allhtml.substring(shtmltag, ehtmltag+6);
	//
				
				 st = st+">";
				 //cleaning html
				st = jtidyi(st);
				//inserting page break
				 st = new StringBuilder(st).insert(st.length()-18,  "<p style='page-break-before: always'></p>").toString();
				
				 sorted = sorted+st;
			//	System.out.println(st);
			
				
			}
		
		
	}
		}catch(Exception e){
			e.printStackTrace();
		}   
	}   
	public static String creating(String userin){
			
			
		char k = 65;
		int s =0;
		if(userin.length()==8){
			int mar = 0;
			while(mar<2){
				 k = 65;
				 s =0;
				 String year = userin.substring(0, 2);
				   
				    String collegecode = userin.substring(2,4);
				    String last1 = userin.substring(6,8);
				    String last = userin.substring(5,6);
				    int fee = Integer.parseInt(year);
				    fee = fee+1;
				    String lateral = fee+""+collegecode+"5"+last+last1;
				
				
			for(int i=00;i<max;i++){
			    if(i<100){
			    	
			    	
			    
			    	  String num = ""+	String.format("%02d", i);;
			    	 
			    if(mar==0){
			    	String added = userin+num;
		
			    	 allofhalltickets  = allofhalltickets+added;}
			    else if(lateralboolean){
			   	String added = lateral+num;
			    	
			    	 allofhalltickets  = allofhalltickets+added;
			    	
			    }
			    }
			    if(i>=100){
			    
			    	int b =0;
			    	
			    	while(b<10&&s<max-100){
			    	
			    	 
			    		 if(mar==0){
			    	String added = userin+k+b;
			    
			    	 allofhalltickets  = allofhalltickets+added;
			    		 }else if(lateralboolean){
			    			 
			    			String added = lateral+k+b;
			    			    
			   		   	 allofhalltickets  = allofhalltickets+added;
			    		 }
			    	 
			    	 b++;
			    	 s++;
			    	 
			    	}
			    	k++;
			    }
			  
			}
	mar++;	 }
			}
		 else{
			

			    for (int k1 =  0; k1 <a.length; k1++) {
			    	int po = 0;
			    	
			    String year = userin.substring(0, 2);
			   
			    String collegecode = userin.substring(2,4);
			    String last = userin.substring(5,6);
			    int fee = Integer.parseInt(year);
			    fee = fee+1;
			    String lateral = fee+""+collegecode+"5"+last;
			    
			    	
			    	
			    	while(po<2){
			  s=0;
			  k=65;
			    	
			    	for ( int i = 0; i < max&&s<max-100; i++) {
			            if (i < 100) {
			                String num = "" + String.format("%02d", i);
			                String kz = ""+	String.format("%02d", a[k1]);
			               if(po==0) {
			                String added = userin + kz + num;
			                allofhalltickets = allofhalltickets + added;}
			               else if(lateralboolean){
			        	   String added = lateral + kz + num;
				               allofhalltickets = allofhalltickets + added;
			            	   
			               }

			            }
			           
			            
			            if(i>=100){
					    	int b =0;
					    	while(b<10){
					    	
					    	 
					        String kz = ""+	String.format("%02d", a[k1]);
					        
					        if(po==0) {
					    	String added1 = userin+kz+k+b;
					    
					    	 allofhalltickets  = allofhalltickets+added1;
					        }else if(lateralboolean){
					        	String added1 = lateral+kz+k+b;
							    
						    	 allofhalltickets  = allofhalltickets+added1;
					        	
					        }
					    	 b++;
					    	 s++;
					    	 
					    	}
					    	k++;
					    	
					    }
			           
			        
			    
			 
			
			   }
		po++;	    }	
			    
			    }
		 }
		allofhallticketsnormal = allofhalltickets;
		return allofhalltickets;
		}
	public static  String  hallnoing(){
		
		
		String upToNCharacters = allofhalltickets.substring(0, Math.min(allofhalltickets.length(), 10));
		  
		

	    allofhalltickets = allofhalltickets.substring(10);
	 	return upToNCharacters;
		
		}

	




	 static String jtidyi(String jbl){
		 String aString = "";
		try{
		 ByteArrayOutputStream os  = new ByteArrayOutputStream();
		    try( 
		    		InputStream in = IOUtils.toInputStream(jbl, "UTF-8");
		    	
		    		
		    		) {
		    	
		        Tidy tidy = new Tidy();
		        tidy.setShowWarnings(true);
		        tidy.setXmlTags(true);
		        tidy.setInputEncoding("UTF-8");
		        tidy.setOutputEncoding("UTF-8");
		        
		        tidy.setXHTML(true);
		        tidy.setMakeClean(true);
		        org.w3c.dom.Document xmlDoc = (org.w3c.dom.Document) tidy.parseDOM(in, null);
		        tidy.pprint((org.w3c.dom.Document) xmlDoc, os);
		     
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		    
		     aString = new String(os.toByteArray(),"UTF-8");
		
		        
		
		}catch(Exception e){
			e.printStackTrace();
		}
		return aString;
	}
	 
	static void makepdf(){
		

	    
	 
	 
	 
	 
	 try
		{

	/*	 
		 File file1 = new File("index.html");
	 file1.createNewFile();
	 PrintWriter pw = new PrintWriter("index.html", "UTF-8");
	 pw.print(everything);  
	*/
		 //creting topperstring
		 topperpage();
		 String fname = examname.substring(10, 30) + System.currentTimeMillis();
		String clgcode =  hallcodetogenerate[hallnoz].substring(2,4);
		String pre = "";
		if(automatic){
		pre = 	"C:/Users/NAWAZ/Google Drive/";
		}
		
		
	//       OutputStream filepdf = new FileOutputStream(new File("C:/Users/NAWAZ/Google Drive/"+fname+" "+clgcode+".pdf"));
	       OutputStream filepdf = new FileOutputStream(new File(pre+fname+" "+clgcode+".pdf"));
	       Document document = new Document();
		PdfWriter writer = PdfWriter.getInstance(document, filepdf);
	
		 BaseFont baseFont3 = BaseFont.createFont("C:/Windows/Fonts/FREESCPT.TTF",
	               BaseFont.WINANSI, BaseFont.NOT_EMBEDDED);
	       Font font2 = new Font(baseFont3, 14,Font.BOLD);
		document.open();
		
		Paragraph paragraph = new Paragraph();
	
		document.add(new Paragraph(topperstring, font2));
	
	      document.add(new Paragraph("\n\nDON'T FORGET TO SHARE WITH YOUR FRIENDS\nFOR MORE PDFs,JOIN THE GROUP AT:", font2));

		 Anchor anchor = new Anchor(
		          "https://www.facebook.com/groups/803590379692043/");
		          anchor.setReference(
		          "https://www.facebook.com/groups/803590379692043/");
		         
		
		          
		  
		          
		        paragraph.add(anchor);
	

		          document.add(paragraph); 
		
		          document.newPage();
		          
		      
		        

		InputStream is = new ByteArrayInputStream(sorted.getBytes());
		
		XMLWorkerHelper.getInstance().parseXHtml(writer, document,is);
		
		
		
		
		
		
		document.close();
		filepdf.close();

		
	}
	catch (Exception e)
	{
		e.printStackTrace();
	}
		
	}


	static String branchString(String bcode){
		if(bcode.equals("00"))
			return "B.PHARMACY";
		if(bcode.equals("01"))
			return "CIVIL ENGINEERING";
		if(bcode.equals("02"))
			return "ELECTRICAL AND ELECTRONICS ENGINEERING";
		if(bcode.equals("03"))
			return "MECHANICAL ENGINEERING";
		if(bcode.equals("04"))
			return "ELECTRONICS AND COMMUNICATION ENGINEERING";
		if(bcode.equals("05"))
			return "COMPUTER SCIENCE AND ENGINEERING";
		if(bcode.equals("08"))
			return "CHEMICAL ENGINEERING";
		if(bcode.equals("10"))
			return "ELECTRONICS AND INSTRUMENTATION ENGINEERING";
		if(bcode.equals("11"))
			return "BIO-MEDICAL ENGINEERING";
		if(bcode.equals("12"))
			return "INFORMATION TECHNOLOGY";
		if(bcode.equals("14"))
			return "MECHANICAL ENGINEERING -MECHATRONICS";
		if(bcode.equals("17"))
			return "ELECTRONICS AND TELEMATICS ENGINEERING";
		if(bcode.equals("18"))
			return "METALLURGICAL AND MATERIALS ENGINEERING";
		if(bcode.equals("19"))
			return "ELECTRONICS AND COMPUTER ENGINEERING";
		if(bcode.equals("20"))
			return "MECHANICAL ENGINEERING - PRODUCTION";
		if(bcode.equals("21"))
			return "AERONAUTICAL ENGINEERING";
		if(bcode.equals("22"))
			return "INSTRUMENTATION AND CONTROL ENGINEERING";
		if(bcode.equals("23"))
			return "BIO-TECHNOLOGY";
		if(bcode.equals("24"))
			return "AUTOMOBILE ENGINEERING";
		if(bcode.equals("25"))
			return "MINING ENGINEERING";
		if(bcode.equals("26"))
			return "MINING MACHINERY";
		if(bcode.equals("27"))
			return "PETROLEUM";
		if(bcode.equals("28"))
			return "CIVIL AND ENVIRONMENTAL ENGINEERING";
		if(bcode.equals("29"))
			return "MATERIAL SCIENCE AND NANO TECHNOLOGY";
		if(bcode.equals("30"))
			return "AGRICULTURE ENGINEERING";
		if(bcode.equals("31"))
			return "COMPUTER SCIENCE AND TECHNOLOGY";
		return "hello";
		
		
		
	}

	static void topperpage(){
		try{
		if(topper){
			int highest = 0;
			//topper list
			
			for(int i=0;i<a.length;i++){
				if(topperobj[i].marks=="")
				continue;
				
				if(Integer.parseInt(topperobj[i].marks)==highest){
					highest = Integer.parseInt(topperobj[i].marks);
					topperstring =topperstring+ topperobj[i].branchcode +" "+branchString(topperobj[i].branchcode)+"\n"+ topperobj[i].name+" / "+topperobj[i].rno+" / "+topperobj[i].marks+"\n\n";	
				}
				
				if(Integer.parseInt(topperobj[i].marks)>highest){
					highest = Integer.parseInt(topperobj[i].marks);
				
					
					topperstring = "Topperzzz List\n\nCollege Wise Topper:\n\n"+ topperobj[i].branchcode +" "+branchString(topperobj[i].branchcode)+"\n"+ topperobj[i].name+" / "+topperobj[i].rno+" / "+topperobj[i].marks+"\n\n";	
					
				}
				
				
			}
			
			
			
			
		
	     

		
		
		//branchwise list
		
		topperstring = topperstring+"\n\nBranch Wise Toppers:\n\n";
		
		for(int i=0;i<a.length;i++){
			if(topperobj[i].branchcode=="")
				continue;

			topperstring = topperstring+ topperobj[i].branchcode +" "+branchString(topperobj[i].branchcode)+"\n";
			topperstring = topperstring+topperobj[i].name+" / "+topperobj[i].rno+" / "+topperobj[i].marks+"\n\n";
			
			
		}
		
		
		topperstring = topperstring+"CONGRATS TO ALL TOPPERS...........FROM FAWAZ AHMED\n\n";
		
		topperstring  = topperstring.toUpperCase();
		
		System.out.println(topperstring);
		
		
		
		}
		
		
		
	}catch(Exception e){
		e.printStackTrace();
	}
	}




static boolean autocheck(){
	
	 WebDriver  driver;
   FirefoxProfile prof = new FirefoxProfile();
	prof.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/zip");
	prof.setPreference("print.always_print_silent", true);
	 prof.setPreference("browser.download.folderList",2);
	    prof.setPreference("browser.download.manager.showWhenStarting",false);
	    prof.setPreference("browser.download.dir","D:\\");
	    prof.setPreference("browser.helperApps.neverAsk.saveToDisk","text/csv");
	    prof.setPreference("dom.successive_dialog_time_limit", 0);
	  //  System.out.println("inside autocheck");
//	   
//	  synchronized(lock0) {   
	//      driver = new PhantomJSDriver();   
//	    DesiredCapabilities dcaps = new DesiredCapabilities();
// 	    dcaps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,"C:/Program Files/phantomjs-2.1.1-windows/bin/phantomjs.exe" );
// 	    dcaps.setCapability("takesScreenshot", false);
	// 	 driver = new FirefoxDriver(prof);  
 driver = new HtmlUnitDriver();
// 	   driver.setJavascriptEnabled(true);
	
//size is number of titles to check,keep it less like 30
	int size = 10;
	String[] heading = new String[size];
	

	try{

	
		
	//	System.out.println("Genericlink : "+genericlink);
		
	driver.get(genericlink);
	(new WebDriverWait(driver, 30))
	  .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#panel > table > tbody > tr:nth-child(1) > td:nth-child(1) > a")));
//	JavascriptExecutor js = (JavascriptExecutor)driver; 
	WebElement[] headelem = new WebElement[size];
	System.out.println(headelem);
	for(int i=0;i<heading.length;i++){
		try{
//	heading[i] = driver.findElement(By.cssSelector("body > center:nth-child(2) > table > tbody > tr:nth-child("+(i+2)+") > td:nth-child(1) > b > a")).getAttribute("innerHTML");
headelem[i] = driver.findElement(By.cssSelector("#panel > table > tbody > tr:nth-child("+(i+1)+") > td:nth-child(1) > a"));
			heading[i] = headelem[i].getAttribute("innerHTML");
		//	System.out.println("heading is "+heading[i]);
       //   System.out.println(heading[i]);

//Remember to remove the ! from dates check,if autochecking for older released results more than two days make dates check as !	
	if((StringUtils.containsIgnoreCase(heading[i], headname[0])&&(StringUtils.containsIgnoreCase(heading[i], headname[1])||StringUtils.containsIgnoreCase(heading[i], headname[2]))&&StringUtils.containsIgnoreCase(heading[i], headname[3])&&StringUtils.containsIgnoreCase(heading[i], headname[4])&&StringUtils.containsIgnoreCase(heading[i], headname[5])&&StringUtils.containsIgnoreCase(heading[i], headname[6]))){
		link = headelem[i].getAttribute("href");
		driver.quit();
		System.out.println("Link is found  "+link);
		return true;
	}
	}catch(Exception e){
		e.printStackTrace();
		
	}
	}
	
	
	
	
	

			
	}catch(Exception e){
		e.printStackTrace();
		
	}			
				
			
				
				
	
	driver.quit();
return false;
}

}
