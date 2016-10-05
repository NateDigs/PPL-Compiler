package lexicalAnalyzer;

public class LookUp {

	public LookUp()
	{
		
	}
	public String doAll(String lexemes, String tokens)
	{
		if(this.checkAddOp(lexemes)){tokens = "ADD_OP";}
		if(this.checkAssignment(lexemes)){tokens = "ASSIGNMENT_OP";}
		if(this.checkEnd(lexemes)){	tokens = ":END";}
		if(this.checkInput(lexemes)){tokens = "INPUT_COMMAND";}
		if(this.checkInt(lexemes)){tokens = "INT_LIT";}
		if(this.checkPrint(lexemes)){tokens = "PRINT_COMMAND";}
		if(this.checkSemiOp(lexemes)){tokens = "SEMI_COLON";}
		if(this.checkStart(lexemes)){tokens = "START:";}
		if(this.checkSubOp(lexemes)){tokens = "SUB_OP";}
		if(this.checkStringVariable(lexemes)){tokens ="STR_VARIABLE";}
		if(this.checkintVariable(lexemes)){	tokens = "INT_VARIABLE";}
		if(this.checkColon(lexemes)){tokens = "COLON";}
		if(this.checkString(lexemes)){tokens = "STRING_LIT";}
		return tokens;
	}
	
	
	public boolean checkString(String input)
	{
        
		if (input.charAt(0) == '"' && input.charAt(input.length()-1) == '"' )
			{
				//System.out.println(input + " is a string");
				return true;
			}
			else
			{
				return false;
			}
		}
	
	public boolean checkColon(String input)
	{
		if (input.equalsIgnoreCase(":"))
		{
			//System.out.println(input + " is a colon");
			return true;
		}
		else
		{
		return false;
		}
	}
	public boolean checkintVariable(String input)
	{
		if (input.equalsIgnoreCase("A") || input.equalsIgnoreCase("B") || input.equalsIgnoreCase("C"))
		{
			//System.out.println(input + " is an int variable");
			return true;
		}
		else
		{
		return false;
		}
	}
	public boolean checkStringVariable(String input)
	{
		if (input.equalsIgnoreCase("w") || input.equalsIgnoreCase("x") || input.equalsIgnoreCase("y") || input.equalsIgnoreCase("z"))
		{
			//System.out.println(input + " is a string variable");
			return true;
		}
		else
		{
		return false;
		}
	}
	
	public boolean checkInt(String input)
	{
	   try
	   {
	      Integer.parseInt(input);
	      //System.out.println(input + " is an integer");
	      return true;
	   }
	   catch(NumberFormatException stuff)
	   {
	       return false;
	   }
	}
	public boolean checkAddOp(String input)
	{
		
		if (input.equalsIgnoreCase("+"))
		{
			//System.out.println(input + " is an Add Operator");
			return true;
		}
		else 
		{
			return false;
		}
		
	}
	public boolean checkSubOp(String input)
	{
		
		if (input.equalsIgnoreCase("-"))
		{
			//System.out.println(input + " is a subtraction operator");
			return true;
			}
		else 
		{
			return false;
		}
		
	}
	public boolean checkSemiOp(String input)
	{
		
		if (input.equalsIgnoreCase(";"))
		{
			//System.out.println(input + " a semicolon operator");
			return true;
		}
		else 
		{
			return false;
		}
		
	}
	public boolean checkAssignment(String input)
	{
		
		if (input.equalsIgnoreCase("="))
		{
			//System.out.println(input + " is an equal sign");
			return true;
		}
		else 
		{
			return false;
		}
		
	}
	public boolean checkStart(String input)
	{
		
		if (input.equalsIgnoreCase("START:"))
		{
			//System.out.println(input + " is a START");
			return true;
		}
		else 
		{
			return false;
		}
		
	}
	public boolean checkEnd(String input)
	{
		
		if (input.equalsIgnoreCase(":END"))
		{
			//System.out.println(input + " is an END");
			return true;
		}
		else 
		{
			return false;
		}
		
	}
	public boolean checkInput(String input)
	{
		
		if (input.equalsIgnoreCase("INPUT"))
		{
			//System.out.println(input + " is an INPUT");
			return true;
		}
		else 
		{
			return false;
		}
		
	}
	
	public boolean checkPrint(String input)
	{
		
		if (input.equalsIgnoreCase("PRINT"))
		{
			//System.out.println(input + " is an PRINT");
			return true;
		}
		else 
		{
			return false;
		}
		
	}
		
}
