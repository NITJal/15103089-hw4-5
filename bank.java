 class Customer{  
    int amount=10000;  
      
    synchronized void withdraw(int amount)
    {  
    	System.out.println("Bob withdraws...");  
      
    	if(this.amount < amount){  
    			System.out.println("Waiting for deposit due to insufficient balance...");  
    			try{
    				wait();
    			}catch(Exception e){}  
    	}  
    	this.amount -= amount;  
    	System.out.println("Withdraw completed...");  
    }  
      
    synchronized void deposit(int amount)
    {  
    	System.out.println("Alice going to deposit...");  
    	this.amount += amount;  
    	System.out.println("Deposit completed... ");  
    	notify();  
    }  
}  
 
public class bank {  
	    public static void main(String args[]){  
	    	final Customer c=new Customer();  
	    	new Thread()
	    	{  
	    		public void run(){c.withdraw(15000);}  
	    	}.start();  
	    	new Thread(){  
	    		public void run(){c.deposit(10000);}  
	    	}.start();  
	    }
}
