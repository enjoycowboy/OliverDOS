import java.util.Arrays;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Random;
import java.util.Date;
import java.time.Clock;

public class Process
{
	/*
 um processo vai ser um objeto com 4 propriedades:
	>  nome
	>  tempo de chegada
	>  tempo de cpu
	>  prioridade
	 
	 */
	private static int priority;
	private static double cpuTimeNeeded;
	private static char[] processName;
	private static String processDate;
	private static Process Process;	
	private final static char[] generateName()  // essa função gera o nome do processo
		{
				final String escopo = "0123456789ABCDEF";
			    final int N = escopo.length();
			    char[] assignedName = new char [6];

			    Random r = new Random();

			    for (int i = 0; i < 6; i++) 
			    {
			 	
			        assignedName[i] = (escopo.charAt(r.nextInt(N)));
			
			    }
				return assignedName;
		}

	private final static String assignDate()   // essa função vai carimbar a data no processo
	{
		   // cria um objeto Date
	       Date processDate = new Date();
	        
	       // atribui a data ao objeto criado  
	       return processDate.toString();
	}
	
	private final static int setPriority()
	{
		int setPriority = (int) (Math.random() * 11);
		return setPriority;
	}
	
 	public Process(int priority, double cpuTimeNeeded, String processDate, char[] processName) //construtor
	{
		Process.processName = generateName();
		Process.processDate = assignDate();
		Process.priority = setPriority();
	
	}
	
	public static void main (String[] args)
	{
		Process = new Process();
		
		System.out.println("NAME                PROCESS DATE                priority");
		System.out.print(Process.processName);
		System.out.print("        " + Process.processDate);
		System.out.print("                                " + Process.priority);
	
	}
	
	}