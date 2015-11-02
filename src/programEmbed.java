public class programEmbed
{
	// gerar instruções pro processador
	// processador tem 8 registradores
	// o objeto instrução tem 6 bits pra instrução, 1 pra operação e 1 pro reg
	
	// operandos:
	// 0-> guarda na memória
	// 1-> adicionar ao reg indicado
	// 2-> remover do reg indicado
	// 3-> adicionar ao valor do reg indicado
	// 4-> subtrair ao valor do reg indicado
	// 5-> multiplicar ao valor do reg indicado
	// 6-> dividir ao valor do reg indicado
	// 7-> remove da memória atual
	
	
	// instrução:
	// 0 -> valor
	// 1 -> operando
	// 2 -> registrador
	
	
	// regs: 0, 1, 2, 3, 4, 5, 6, 7
	
	// main = roda o programcounter
	
	
	private static  int[] Register = new int [7];
	private  static int[] logicMem = new int [10];
	private static   int[] Instruction = new int [3];
	public   int ProgramCounter;
	public   int[] createInstruction()
	{
		int value = (int) (Math.random() * 9998) + 1;
		Instruction[0] = value;
		int operand = (int) (Math.random() * 7);
		Instruction[1] =  operand;
		int reg = (int) (Math.random() * 5);
		Instruction[2] = reg;
		return Instruction;
	}
	public   void realizeOperation()
	{
		switch (Instruction[1])
				{
				case 0:
					int mempos = 0;
					memoryStore(mempos, Instruction[0]);
					mempos++;
					break;
				case 1:
					addToReg(Instruction[2]);
					break;
				case 3:
					Register[Instruction[2]] = Register[Instruction[2]] + Instruction[0]; 
					break;
				case 2:
					delFromReg(Instruction[2]);
					break;
				case 4:
					Register[Instruction[2]] = Register[Instruction[2]] - Instruction[0];
					break;
				case 5:
					Register[Instruction[2]] = Register[Instruction[2]] * Instruction[0];
					break;
				case 6:
					Register[Instruction[2]] = Register[Instruction[2]] / Instruction[0];
				case 7:
					memoryStore(getLogicMemPos(), 0);
				}
	}

	
	public static int createCounter() {
		int pc = (int) (Math.random() * 9998) + 1; //gera o PC
		//System.out.println(pc);
		return pc;
	}
	
	
	
	public   int getLogicMemPos()
	{
		int i = 0;
		do
		{
			if (logicMem[i] != 0)
			{
				continue;
			} else { break; } } while (i < logicMem.length);
		return i;
	}
	public   void memoryStore(int memPosition, int value)
	{
		logicMem[memPosition] = value;
	}
	
	public   void addToReg(int regNum) //operação pra adicionar ao reg
	{
		Register[regNum] = Instruction[0];
	}
	
	public   void delFromReg (int regNum)	//op pra remover o reg
	{
		Register[regNum] = 0;
	}
	public void runProgram()
	{
		Process.isRunning = true;
		for (int i = 0; i < ProgramCounter; i++)
		{
			realizeOperation();
		}
		
		Process.isFinished = true;
		Process.isRunning = false;
		
	}
	
	public programEmbed()
	{
		
		new Process();
		int status = 0;
		ProgramCounter = createCounter();
		do
		{
			createInstruction();  //cria instruções pra cada numero do pc
			status++;
		} while (status < ProgramCounter);
		runProgram();
	
	}
	public static void main (String []args)
	{
		new programEmbed();
		System.out.println(Process.name);
		System.out.print(" " + Process.cpuTimeNeeded + " ");
		for (int i = 0; i < Register.length; i++)
			{
				System.out.print(" " + Register[i] + " ");
			}
		}
		
	
	}