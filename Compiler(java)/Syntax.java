package lexicalAnalyzer;
import java.util.LinkedList;
import javafx.application.*;
import javafx.event.*;
import javafx.scene.*;


public class Syntax 
{
	Syntax()
	{
		
	}
	
	Syntax(LinkedList<TokenObject> inputList)
	{
		int i=0;
		if(this.checkProgram(inputList , i) == true)
		{
			System.out.println("Congrats, valid code!");
		}
		else
		{
			System.out.println("Invalid Code");
		}
		
	}
	
	
	public boolean checkProgram(LinkedList<TokenObject> inputList, int i)
	{
		boolean value = true;
		while(value==true)	
		{
			//if program does not start with START
			System.out.println("\t\t\t<program>");
			if(inputList.getFirst().getToken() != "START:")
			{
				System.out.println(" \t\t       /   ");
				System.out.println(" \t\t      /    ");
				System.out.println(" \t\t     /     ");
				System.out.println(" \t\t    /      ");
				
				System.out.println("\t    START is messed up");
				value = false;
				break;
			}
			if(inputList.getLast().getToken()!= ":END")
			{
				System.out.println(" \t\t       /    |    \\");
				System.out.println(" \t\t      /     |     \\");
				System.out.println(" \t\t     /      |      \\");
				System.out.println(" \t\t    /       |       \\");
				System.out.println("\t\tSTART: <smtmt_list>  :END is messed up");
				value = false;
				break;
			}
			//if statementlists are untrue
			if(this.checkStatementList(inputList, i)== false)
			{
				value = false;
			}

			//if program doesnt end with end
			break;
		}
		return value;
	}
	
	
	
	public boolean checkStatementList(LinkedList<TokenObject> inputList, int i)
	{
		boolean value= true;
		boolean statement = false;
		boolean statementList= false;
		int j = i;
		//search for semi colons
		
		while(inputList.get(i).getToken() != inputList.getLast().getToken())
		{
			if(inputList.get(i).getToken()== "SEMI_COLON")
			{
				statementList = true;
			}
			i++;
		}
		if(statementList==true)
		{
			System.out.println(" \t\t       /    |    \\");
			System.out.println(" \t\t      /     |     \\");
			System.out.println(" \t\t     /      |      \\");
			System.out.println(" \t\t    /       |       \\");
			System.out.println("\t\tSTART <smtmt_list>  END");
			
			
		}
	
		
		if(this.checkStatement(inputList) != true);
		else
		{
			
			statement=true;
		}
		
		
		if (statement == false)
		{
			System.out.println("Invalid statement");
			value=false;
		}
		
		if (statementList == false)
		{
			System.out.println("Invalid Statementlist");
			value=false;
		}
		return value;
	}
	
	public boolean checkStatement(LinkedList<TokenObject> inputList)
	{
		int i=0;
		boolean value = true;
		LinkedList<TokenObject> varCheckList = new LinkedList<TokenObject>();
		while(inputList.get(i).getToken() != inputList.getLast().getToken())
		{
			i++;
			varCheckList.add(inputList.get(i));
			if(inputList.get(i).getToken() == ":END") 
			{
				if(inputList.get(i-1).getToken() != "SEMI_COLON")
				{
					System.out.println("Missing semi colon");
					value=false;
					break;
				}
			}
			if(inputList.get(i).getToken()== "SEMI_COLON")
			{
		
				
				System.out.println("\t\t\t   |");
				System.out.println("\t\t\t   |");
				System.out.println("\t\t\t<stmt>");
				if(this.checkVar(varCheckList)== false  && this.checkSvar(varCheckList) == false && this.checkPrint(varCheckList) == false)
				{
					value = false;
				}
				varCheckList.clear();
				
			}
			
		}
		
		return value;
	}
	
	
	public boolean checkVar(LinkedList<TokenObject> inputList)
	{
		boolean value = false;
		int i=0;
		int j=1;
		LinkedList<TokenObject> exprstringList = new LinkedList<TokenObject>();
		while(inputList.get(j).getToken()!= "SEMI_COLON")
		{
			j++;
			exprstringList.add(inputList.get(j));
		}
		
		
		
		if((inputList.get(i).getToken() == "INT_VARIABLE") && (inputList.get(i+1).getToken()== "ASSIGNMENT_OP") && (inputList.get(i+2).getToken() == "INT_LIT") && (inputList.get(i+3).getToken() =="SEMI_COLON")) 
		{

			System.out.println(" \t\t       /  |  \\ \\");
			System.out.println(" \t\t      /   |   \\ \\");
			System.out.println(" \t\t     /    |   |  \\");
			System.out.println(" \t\t    /     |   |   |");
			System.out.println(" \t\t    |     |   |   |");
			System.out.println("\t\t  <var>  =    " +inputList.get(i+2).getLexeme() +"  ;");
			System.out.println("\t\t   |");
			System.out.println("\t\t   "   + inputList.get(i).getLexeme());
			value=true;
		}
		else if((inputList.get(i).getToken() == "INT_VARIABLE") && (inputList.get(i+1).getToken()== "ASSIGNMENT_OP") && (inputList.get(i+2).getToken() == "INPUT_COMMAND") && (inputList.get(i+3).getToken() =="SEMI_COLON")) 
		{
			System.out.println(" \t\t       /    |  \\ \\");
			System.out.println(" \t\t      /     |   \\ \\");
			System.out.println(" \t\t     /      |   |   \\");
			System.out.println(" \t\t    /       |   |    \\");
			System.out.println(" \t\t    |       |   |     \\");
			System.out.println("\t\t  <var>      = INPUT  ;");
			System.out.println("\t\t    | ");
			System.out.println("\t\t    | ");
			System.out.println("\t\t    " + inputList.get(i).getLexeme());
			
			value=true;
		}
		
		else if((inputList.get(i).getToken()=="INT_VARIABLE") && (inputList.get(i+1).getToken() == "ASSIGNMENT_OP"))
		{
			System.out.println(" \t\t       /    |  \\ ");
			System.out.println(" \t\t      /     |   \\ ");
			System.out.println(" \t\t     /      |   |   ");
			System.out.println(" \t\t    /       |   |   ");
			System.out.println(" \t\t    |       |   |   ");
			System.out.println("\t\t   <var>    = <expr>");
			System.out.println("\t\t    |           |  ");
			System.out.print("\t\t    " + inputList.get(i).getLexeme() + " ");
			if(this.checkExpression(exprstringList)==true)
			{
				value=true;
			}
			else
			{
				System.out.println("  Invalid expression");	
			}
			
		}
		return value;
	}
	public boolean checkSvar(LinkedList<TokenObject> inputList)
	{
		boolean value = false;
		int i=0;
		int j=1;
		LinkedList<TokenObject> exprstringList = new LinkedList<TokenObject>();
		while(inputList.get(j).getToken()!= "SEMI_COLON")
		{
			j++;
			exprstringList.add(inputList.get(j));
		}
		

		if((inputList.get(i).getToken() == "STR_VARIABLE") && (inputList.get(i+1).getToken()== "ASSIGNMENT_OP") && (inputList.get(i+2).getToken() == "INPUT_COMMAND") && (inputList.get(i+3).getToken() =="SEMI_COLON")) 
		{
			System.out.println(" \t\t       /    |  \\ ");
			System.out.println(" \t\t      /     |   \\ ");
			System.out.println(" \t\t     /      |   |   ");
			System.out.println(" \t\t    /       |   |   ");
			System.out.println(" \t\t    |       |   |   ");
			System.out.println("\t\t<svar> = INPUT ;");
			System.out.println(" \t\t    |   ");
			System.out.println("\t\t    " +inputList.get(i).getLexeme());
			value=true;
		}
		if((inputList.get(i).getToken() == "STR_VARIABLE") && (inputList.get(i+1).getToken()== "ASSIGNMENT_OP") && (inputList.get(i+2).getToken() == "STRING_LIT") && (inputList.get(i+3).getToken() =="SEMI_COLON")) 
		{
		
			System.out.println(" \t\t       /    |  \\ ");
			System.out.println(" \t\t      /     |   \\ ");
			System.out.println(" \t\t     /      |    |   ");
			System.out.println(" \t\t    /       |    |   ");
			System.out.println(" \t\t    |       |    |   ");
			System.out.println("\t\t<svar> = " +inputList.get(i+2).getLexeme()+ " ;");
			System.out.println(" \t\t    |   ");
			System.out.println("\t\t    " +inputList.get(i).getLexeme());
			value=true;
		}
		if((inputList.get(i).getToken() == "STR_VARIABLE") && (inputList.get(i+1).getToken()== "ASSIGNMENT_OP") && (inputList.get(i+2).getToken()=="STR_VARIABLE")) 
		{

			System.out.println(" \t\t       /    |  \\ ");
			System.out.println(" \t\t      /     |   \\ ");
			System.out.println(" \t\t     /      |    |   ");
			System.out.println(" \t\t    /       |    |   ");
			System.out.println(" \t\t    |       |    |   ");
			System.out.println("\t\t<svar>      = <string>");
			System.out.println("\t\t  " +inputList.get(i).getLexeme()+ "\t\t |");
			 if(this.checkString(exprstringList)== true)
				{
				 value=true;
				}
			 else
			 {
					if(inputList.getLast().getLexeme() != ";")
					{
							System.out.println("   Missing semi colon");
					}
				else{
					System.out.println("  Invalid String");	
				}
			 }
			
		}
		
		
		
		
		return value;
	}
	public boolean checkPrint(LinkedList<TokenObject> inputList)
	{
		boolean value = false;
		int i=0;
		int j=0;
		LinkedList<TokenObject> exprstringList = new LinkedList<TokenObject>();
		while(inputList.get(j).getToken()!= "SEMI_COLON")
		{
			j++;
			exprstringList.add(inputList.get(j));
		}
		
		
		
		if((inputList.get(i).getToken() == "PRINT_COMMAND") && (inputList.get(i+1).getToken()== "STRING_LIT") && (inputList.get(i+2).getToken() =="SEMI_COLON")) 
		{	
			
			System.out.println(" \t\t       /    |  \\ ");
			System.out.println(" \t\t      /     |   \\ ");
			System.out.println(" \t\t     /      |    |   ");
			System.out.println(" \t\t    /       |    |   ");
			System.out.println(" \t\t    |       |    |   ");
			System.out.println("\t\tPRINT " +"   " +inputList.get(i+1).getLexeme() + " ;");
			value=true;
		}
		else if((inputList.get(i).getToken()=="PRINT_COMMAND") && (inputList.get(i+1).getToken()=="INT_VARIABLE"))
		{
			System.out.println(" \t\t       /   \\    \\ ");
			System.out.println(" \t\t      /     \\    \\ ");
			System.out.println(" \t\t     /       \\    \\    ");
			System.out.println(" \t\t    /         \\    \\    ");
			System.out.println(" \t\t    |          \\    \\   ");
			System.out.println("\t\tPRINT " + "\t      <expr>" +" ;");
			System.out.print("\t\t");
			if(this.checkExpression(exprstringList)==true)
			{
			value=true;
			}
		}
		else if((inputList.get(i).getToken()=="PRINT_COMMAND") && (inputList.get(i+1).getToken()=="STR_VARIABLE"))
		{
			System.out.println(" \t\t       /   \\    \\ ");
			System.out.println(" \t\t      /     \\    \\ ");
			System.out.println(" \t\t     /       \\    \\    ");
			System.out.println(" \t\t    /         \\    \\    ");
			System.out.println(" \t\t   /           \\    \\   ");
			System.out.println("\t\tPRINT " + "\t    <String>" +" ;");
			if(this.checkString(exprstringList)==true)
			{
			value=true;;
			}
		}
		
		
		
		return value;
	}
	
	public boolean checkExpression(LinkedList<TokenObject> inputList)
	{
		boolean value = false;
		int i=0;
		int j=0;
		if((inputList.get(i).getToken() == "INT_VARIABLE") && (inputList.get(i+1).getToken()== "ADD_OP") && (inputList.get(i+2).getToken()== "INT_VARIABLE") && (inputList.get(i+3).getToken() =="SEMI_COLON")) 
		{	
			System.out.println("\t       /|\\");
			System.out.println("\t\t\t      / | \\");
			System.out.println("\t\t\t     /  |  \\");
			System.out.println("\t\t\t    /   |   \\");
			System.out.println("\t\t\t  <var> +  <var>");
			System.out.println("\t\t\t   |          |"); 
			System.out.println("\t\t\t   " + inputList.get(i).getLexeme() + "\t      " + inputList.get(i+2).getLexeme());
			value=true;
		}
		if((inputList.get(i).getToken() == "INT_VARIABLE") && (inputList.get(i+1).getToken()== "SUB_OP") && (inputList.get(i+2).getToken()== "INT_VARIABLE") && (inputList.get(i+3).getToken() =="SEMI_COLON")) 
		{	
			System.out.println("\t       /|\\");
			System.out.println("\t\t\t      / | \\");
			System.out.println("\t\t\t     /  |  \\");
			System.out.println("\t\t\t    /   |   \\");
			System.out.println("\t\t          <var>  - <var>");
			System.out.println("\t\t           |          |"); 
			System.out.println("\t\t           " + inputList.get(i).getLexeme() + "          " + inputList.get(i+2).getLexeme());
			value=true;
		}
		if((inputList.get(i).getToken() == "INT_VARIABLE") && (inputList.get(i+1).getToken()=="SEMI_COLON")) 
		{	
			
			System.out.println("\t\t|");
			System.out.println("\t\t\t     <var>");
			System.out.println("\t\t\t       |");
			System.out.println("\t\t\t       " +inputList.get(i).getLexeme());
			value=true;
		}
		
		
		
		return value;
	}
	public boolean checkString(LinkedList<TokenObject> inputList)
	{
		boolean value = false;
		int i=0;
		int j=0;
		if((inputList.get(i).getToken() == "STR_VARIABLE") && (inputList.get(i+1).getToken()== "ADD_OP") && (inputList.get(i+2).getToken()== "STR_VARIABLE") && (inputList.get(i+3).getToken() =="SEMI_COLON")) 
		{	
			System.out.println("\t\t\t        /|\\");
			System.out.println("\t\t\t       / | \\");
			System.out.println("\t\t\t      /  |  \\");
			System.out.println("\t\t\t     /   |   \\");
			System.out.println("\t\t\t <svar>  + <svar>");
			System.out.println("\t\t\t   |\t    |");
			System.out.println("\t\t\t   "+inputList.get(i).getLexeme() + " \t    " + inputList.get(i+2).getLexeme());
			value=true;
		}
		if((inputList.get(i).getToken() == "STR_VARIABLE") && (inputList.get(i+1).getToken()== "ADD_OP") && (inputList.get(i+2).getToken()== "INT_VARIABLE") && (inputList.get(i+3).getToken() =="SEMI_COLON")) 
		{	
			System.out.println("\t\t\t        /|\\");
			System.out.println("\t\t\t       / | \\");
			System.out.println("\t\t\t      /  |  \\");
			System.out.println("\t\t\t     /   |   \\");
			System.out.println("\t\t\t <svar>  + <var>");
			System.out.println("\t\t\t   |\t    |");
			System.out.println("\t\t\t   "+inputList.get(i).getLexeme() + "\t    " + inputList.get(i+2).getLexeme());
			value=true;
		}
		if((inputList.get(i).getToken() == "STR_VARIABLE") && (inputList.get(i+1).getToken()=="SEMI_COLON")) 
		{	
			System.out.println("\t\t\t      <svar>");
			System.out.println("\t\t\t\t|");
			System.out.println("\t\t\t\t" + inputList.get(i).getLexeme());
			value=true;
		}
		return value;
	}

	
	
	
}
	