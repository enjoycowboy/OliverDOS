import java.util.ArrayList;
import java.util.Random;
import java.util.Date;

public class Process
{
	
	/* 
 um processo vai ser um objeto com 4 propriedades:
	>  nome
	>  tempo de chegada
	>  tempo de cpu
	>  prioridade
	 
	 tambem sera considerado se o processo foi concluido
	 */
	public static int priority;
	public static double cpuTimeNeeded;
	public static String name;
	public static String date;	
	public static boolean isFinished;
	public static boolean isRunning = false;
	static ArrayList<String> processDate = new ArrayList<String>();
	static ArrayList<Integer> processPriority = new ArrayList<Integer>();
	static ArrayList<Double> processTimeNeeded = new ArrayList<Double>();
	static ArrayList<String> processName = new ArrayList<String>();
	
	
	public final static int setRunTime()
	{
		
		int runtime = programEmbed.createCounter();
		System.out.println(runtime);
		return runtime;
	}
	
	
	public final static String generateName()  // essa função gera o nome do processo
		{
		final String escopo = "0123456789ABCDEF";
	    final int N = escopo.length();
	    char[] assignedName = new char [6];

	    Random r = new Random();

	    for (int i = 0; i < 6; i++) 
	    {
	 	
	        assignedName[i] = (escopo.charAt(r.nextInt(N)));
	
	    };
		
		return String.valueOf(assignedName);
				
		}
	
	private final static String assignDate()   // essa função vai carimbar a data no processo
	{
		   // cria um objeto Date
	      Date processDate = new Date();
	       
	      // atribui a data ao objeto criado  
	      return processDate.toString();
	}
	
	
	public final static int setPriority()
	{
		int setPriority = (int) (Math.random() * 100) + 1;
		return setPriority;
	}
	
	
	public Process()
	{
	name = generateName();
	date = assignDate();
	priority = setPriority();
	cpuTimeNeeded = setRunTime();	
	
	processDate.add(date);
	processPriority.add(priority);
	processTimeNeeded.add(cpuTimeNeeded);
	processName.add(name);
	
	
	}
	
	public static void Kill()
	{
		processDate.remove(date);
		processPriority.remove(priority);
		processTimeNeeded.remove(cpuTimeNeeded);
		processName.remove(name);
	}
	
	
	public static void main (String[] args)
	{
			if (Process.isFinished = true)
			{
				Process.Kill();
			}
	
	}
	
}