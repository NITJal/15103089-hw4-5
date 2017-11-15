class Lights{  
 synchronized void light(String s){ 
     System.out.println(s);  
 	}  
}  
  
class Red extends Thread{    
	public Lights t = new Lights();
	public void run()
	{
		t.light("RED");
	}
}  
 
class Green extends Thread{    
	public Lights t = new Lights();
	public void run()
	{
		t.light("GREEN");
	} 
} 

class Yellow extends Thread{    
	public Lights t = new Lights();
	public void run()
	{
		t.light("YELLOW");
	}
} 

class FlashYellow extends Thread{    
	public Lights t = new Lights();
	public void run()
	{
		//for(int i=0 ; i<20; i++)
		{
			t.light("Yellow");
		}
	} 
} 
   
public class Trafficlights {
		public static void main(String args[])
		{
			Red r = new Red();
			Green g = new Green();
			Yellow y = new Yellow();
			FlashYellow[] fy = new FlashYellow[20];
			
			g.start();
		     try{  
		         Thread.sleep(60*1000);  
		        }
		        catch(Exception e){
		       	 System.out.println(e);
		        }  
			y.start();
		     try{  
		         Thread.sleep(50*1000);  
		        }
		        catch(Exception e){
		       	 System.out.println(e);
		        }  
		     for(int i=0; i<20; i++)
		     {
		    	 fy[i] = new FlashYellow();
		    	 fy[i].start();
		    	 try{  
			         Thread.sleep(2*1000);  
			        }
			        catch(Exception e){
			       	 System.out.println(e);
			        } 
		     }
			r.start();
			try{  
		         Thread.sleep(60*1000);  
		        }
		        catch(Exception e){
		       	 System.out.println(e);
		        } 
		}
}
