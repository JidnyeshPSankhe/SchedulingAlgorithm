
import java.util.Arrays;
import java.util.Random;
import java.io.IOException;
import java.util.*;

class Barber
{
   
	private int customer = 40;

	private int[] Earning = new int[5]; 
	private String[] Barbers = {"A","B","C","D","E"};

	public static void main (String[] args) throws IOException
	{
		Barber t = new Barber();
		
		String[] time =
			{
					"8:00","8:25","8:05","8:15","8:40"
			};
		t.sortTime(time);
		t.rndFunc();
		
	}
	public void sortTime(String time[])
	{
		System.out.println("Barbers in unsorted way:");
        for(int n=0;n<5;n++)
        {
        	
            System.out.print (Barbers[n] + ":");
            System.out.println (time[n]);
        }
        System.out.println (" ");
        for ( int i = 0; i < 5; i++) {
            for (int j = i + 1; j < 5; j++) {
                String dtmp=null;
                String stmp=null;
                if (time[i].compareTo(time[j]) >0) {
                    dtmp = Barbers[i];
                    Barbers[i] = Barbers[j];
                    Barbers[j] = dtmp;
                    stmp = time[i];
                    time[i]=time[j];
                    time[j]=stmp;
                }
            }
        }
       
      
        System.out.print("Barbers in Ascending order of sign in time: \n");
        for(int n=0;n<5;n++)
        {
        	
            System.out.print (Barbers[n] + ":");
            System.out.println (time[n]);
        }
        System.out.println();
	}
    public void rndFunc(){
    	
        int[]a= new int[]{10,30,40,20};
        
        
        int customer_service[];    //declaring array
        customer_service = new int[customer]; // allocating memory
        
        for (int i = 0; i < customer_service.length; i++){
        	Random rnd= new Random();
        	customer_service[i] =  a[rnd.nextInt(a.length)];
        	
        }
    	
        int no_barber=0,r=1;
        int[] temp_services = new int[5];
       
        
		for(int j=0; j<customer_service.length;j++)
		{
			
		
			if (no_barber < 5)
			{
			Earning[no_barber] = customer_service[j] + Earning[no_barber];
			temp_services[no_barber]=customer_service[j];
			
			no_barber++;
			
			if(no_barber==5)
			{

				System.out.println("Round "+r);
				System.out.println(Arrays.toString(Barbers));
		      
				System.out.println("Service requested by the customer costs: " + Arrays.toString(temp_services));
				System.out.println("Earning of barbers after round: "+r++);
				
				System.out.println(Arrays.toString(Earning));
				no_barber=0;
				Compare();
				System.out.println();
				
				
			}
		}
		}
		System.out.println("Round "+r);
		System.out.println(Arrays.toString(Barbers));
		System.out.println("No more customers");
} 
    
   private void arrange(int larger, int smaller)
   {
	   int tempEarning[] = new int[5];
	   String tempBarber[] = new String[5];
	   //earnings
	   System.arraycopy(Earning, 0, tempEarning, 0, 5);
	   tempEarning[larger] = Earning[smaller];
       System.arraycopy(Earning, larger, tempEarning, larger+1, smaller-larger);
       System.arraycopy(Earning, smaller+1, tempEarning, smaller+1, Earning.length-smaller-1);
       Earning = tempEarning;
       //barbers
       System.arraycopy(Barbers, 0, tempBarber, 0, 5);
       tempBarber[larger] = Barbers[smaller];
       System.arraycopy(Barbers, larger, tempBarber, larger+1, smaller-larger);
       System.arraycopy(Barbers, smaller+1, tempBarber, smaller+1, Barbers.length-smaller-1);
       Barbers = tempBarber;
       	   
   }
    private void Compare(){
		for ( int i = 0; i < 5; i++) {
           for (int j = i + 1; j < 5; j++) {
        	   if (Earning[i] >=(Earning[j] +20)) {
        		   arrange(i,j);
        		   }
            }
		}

    }
 }
    



