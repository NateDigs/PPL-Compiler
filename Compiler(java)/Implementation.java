package lexicalAnalyzer;

import java.util.LinkedList;
import java.util.Scanner;

public class Implementation {

	LinkedList<TokenObject> statementList = new LinkedList<TokenObject>();
	//impObject impObject = new impObject();
	impObject[] storage = new impObject[100];
	
	
	int count=0;
	Implementation()
	{
		
	}
	
	
	Implementation(LinkedList<TokenObject> inputList)
	{
		int i=1;
		for(int p=0; p<100; p++)
		{
			storage[p] = new impObject("p", "p");
		}
		
		while(inputList.get(i).getToken()!=":END")
		{
			while(inputList.get(i).getToken() != "SEMI_COLON")
			{
				
				//System.out.println(i + " " +inputList.get(i).getLexeme());
				statementList.add(inputList.get(i));
				if(inputList.get(i+1).getToken()=="SEMI_COLON")
				{
					this.checkVar(statementList);
					this.checkSVar(statementList);
					this.checkPrint(statementList);
					//this.print();
					
				}
				i++;
			}
			statementList.clear();
			i++;
		}
	
		
	
	//check var
	
	//check svar
		
	//check print
		
	
	}
	public void checkVar(LinkedList<TokenObject> inputList)
	{
		int i=0;
		if(inputList.getFirst().getToken() == "INT_VARIABLE")
		{
			//System.out.println("INT_VARIABLE");
			String var, val;
			//var = inputList.get(0).getLexeme();
			//val = inputList.get(2).getLexeme();
			//impObject newObject = new impObject(var, val);
			//storage[0] = newObject;
			try
			{
			if(inputList.get(3) != null)
			{
				
				//var = var + var
				if(inputList.get(0).getToken() == "INT_VARIABLE" && inputList.get(2).getToken()=="INT_VARIABLE" && inputList.get(3).getToken() == "ADD_OP")
				{
					//check for
					boolean stuff = false;
					for(int j=0; j<count; j++)
					{
						if(inputList.get(0).getLexeme().equalsIgnoreCase(storage[j].getVar()))
						{
							//first exists
							stuff = true;
							for (int k=0; k<count; k++)
							{
								//second exists
								if(inputList.get(2).getLexeme().equalsIgnoreCase(storage[k].getVar()))
								{
									//third exists
									for(int l=0; l<count; l++)
										if(inputList.get(4).getLexeme().equalsIgnoreCase(storage[l].getVar()))
												{
												int a = Integer.parseInt(storage[k].getVal());
												int b = Integer.parseInt(storage[l].getVal());
												System.out.println(a+b);
												String c = Integer.toString(a+b);
												storage[j].setVal(c);
												}
								}
							}
						}
						
					}
					if(stuff == false)
					{
						for (int k=0; k<count; k++)
						{
							//second exists
							if(inputList.get(2).getLexeme().equalsIgnoreCase(storage[k].getVar()))
							{
								//third exists
								for(int l=0; l<count; l++)
									if(inputList.get(4).getLexeme().equalsIgnoreCase(storage[l].getVar()))
											{
											int a = Integer.parseInt(storage[k].getVal());
											int b = Integer.parseInt(storage[l].getVal());
											//System.out.println(a+b);
											String c = Integer.toString(a+b);
											storage[count].setVar(inputList.get(0).getLexeme());
											storage[count].setVal(c);
											count++;
											}
							}
						}
					}
					
				}
				if(inputList.get(0).getToken() == "INT_VARIABLE" && inputList.get(2).getToken()=="INT_VARIABLE" && inputList.get(3).getToken() == "SUB_OP")
				{
					for(int j=0; j<count; j++)
					{
						if(inputList.get(0).getLexeme().equalsIgnoreCase(storage[j].getVar()))
						{
							//first exists
							for (int k=0; k<count; k++)
							{
								//second exists
								if(inputList.get(2).getLexeme().equalsIgnoreCase(storage[k].getVar()))
								{
									//third exists
									for(int l=0; l<count; l++)
										if(inputList.get(4).getLexeme().equalsIgnoreCase(storage[l].getVar()))
												{
												int a = Integer.parseInt(storage[k].getVal());
												int b = Integer.parseInt(storage[l].getVal());
												System.out.println(a+b);
												String c = Integer.toString(a-b);
												storage[j].setVal(c);
												}
								}
							}
						}
					}
					
					
				}
				//var = var - var
			}
			}
			catch(IndexOutOfBoundsException a)
			{
				
					//var = var
					if(inputList.get(0).getToken() == "INT_VARIABLE" && inputList.get(2).getToken()=="INT_VARIABLE")
					{
						
						//check if var exists	
						//if var exists check if other var exists if it doesnt, throw an error
						//update with other vars value 
						//increment count
						//if first var doesnt exist, check if second var exists
						//if both exist, update value
						//increment count
						//throw error if one doesnt exist	
						boolean result = false;
						for(int j =0; j<count; j++)
						{
							if(inputList.get(0).getLexeme().equalsIgnoreCase(storage[j].getVar()))
								{
									for(int k=0; k<count; k++)
									{	
										if(inputList.get(2).getLexeme().equalsIgnoreCase(storage[k].getVar()))
										{
										result = true;
										storage[j].setVal(storage[k].getVal());
										break;
										}
									}	
								}
						}
						if(result == false)
						{
							storage[count].setVar(inputList.get(0).getLexeme());
							for(int k=0; k<count; k++)
							{
								if(inputList.get(2).getLexeme().equalsIgnoreCase(storage[k].getVar()))
								{
									storage[count].setVal(storage[k].getVal());
								}
							}
							count++;
						}
					}
					//var = input
					else if(inputList.get(0).getToken() == "INT_VARIABLE" && inputList.get(2).getToken()=="INPUT_COMMAND")
					{
						//check if var exists
						//if exists, prompt user
						//update value with user input
						//if doesnt exist
						//get users input
						//update current with user input val
						//increment count
						boolean result = false;
						Scanner input = new Scanner(System.in);
						int j=0;
						while(j<count)
						{
							if(inputList.get(0).getLexeme().equalsIgnoreCase(storage[j].getVar()))
							{
								result = true;
								break;
							}
							j++;
						}
						
						if(result == true)
						{
						//update
							System.out.println("Please enter an integer to assign to the variable '" + inputList.get(0).getLexeme()+ "'");
							storage[j].setVal(input.next());
						}
						else
						{
							//add new
							storage[count].setVar(inputList.get(0).getLexeme());
							System.out.println("Please enter an integer to assign to the variable '" + inputList.get(0).getLexeme()+ "'");
							storage[count].setVal(input.next());
							count++;
						}
					}
					//var =  int
					else if(inputList.get(0).getToken() == "INT_VARIABLE" && inputList.get(2).getToken()=="INT_LIT")
					{
						
						//check if var exists
						//if exists, update
						//if doesnt exist, create and increment count
						boolean result = false;
						for(int j =0; j<count; j++)
						{
							if(inputList.get(0).getLexeme().equalsIgnoreCase(storage[j].getVar()))
								{
									result = true;
									storage[j].setVal(inputList.get(2).getLexeme());
									break;
								}
						}
						if(result == false)
						{
							storage[count].setVar(inputList.get(0).getLexeme());
							storage[count].setVal(inputList.get(2).getLexeme());
							count++;
						}
					}
			}
		}
	}
	public void checkSVar(LinkedList<TokenObject> inputList)
	{
		int i=0;
		if(inputList.getFirst().getToken() == "STR_VARIABLE")
		{
			//System.out.println("INT_VARIABLE");
			String var, val;
			//var = inputList.get(0).getLexeme();
			//val = inputList.get(2).getLexeme();
			//impObject newObject = new impObject(var, val);
			//storage[0] = newObject;
			try
			{
			if(inputList.get(3) != null)
			{
				//System.out.println("IS not null            " + inputList.get(2).getToken());
				//svar = svar + svar
				if(inputList.get(0).getToken() == "STR_VARIABLE" && inputList.get(2).getToken()=="STR_VARIABLE" && inputList.get(3).getToken() == "ADD_OP" && inputList.get(4).getToken() == "STR_VARIABLE")
				{
					for(int j=0; j<count; j++)
					{
						if(inputList.get(0).getLexeme().equalsIgnoreCase(storage[j].getVar()))
						{
							//first exists
							for (int k=0; k<count; k++)
							{
								//second exists
								if(inputList.get(2).getLexeme().equalsIgnoreCase(storage[k].getVar()))
								{
									//third exists
									for(int l=0; l<count; l++)
										if(inputList.get(4).getLexeme().equalsIgnoreCase(storage[l].getVar()))
												{
												storage[j].setVal(storage[k].getVal() + storage[l].getVal());
												}
								}
							}
						}
					}
					
					
				}
				if(inputList.get(0).getToken() == "STR_VARIABLE" && inputList.get(2).getToken()=="STR_VARIABLE" && inputList.get(3).getToken() == "ADD_OP" && inputList.get(4).getToken() == "INT_VARIABLE")
				{
					for(int j=0; j<count; j++)
					{
						if(inputList.get(0).getLexeme().equalsIgnoreCase(storage[j].getVar()))
						{
							//first exists
							for (int k=0; k<count; k++)
							{
								//second exists
								if(inputList.get(2).getLexeme().equalsIgnoreCase(storage[k].getVar()))
								{
									//third exists
									for(int l=0; l<count; l++)
										if(inputList.get(4).getLexeme().equalsIgnoreCase(storage[l].getVar()))
												{
												storage[j].setVal(storage[k].getVal() + storage[l].getVal());
												}
								}
							}
						}
					}
					
					
					//System.out.println("svar + var operation");
				}
				//svar = svar + var
			}
			}
			catch(IndexOutOfBoundsException a)
			{
				//System.out.println("IS null      " + inputList.get(2).getToken());
					//svar = svar
					if(inputList.get(0).getToken() == "STR_VARIABLE" && inputList.get(2).getToken()=="STR_VARIABLE")
					{
						boolean result = false;
						for(int j =0; j<count; j++)
						{
							if(inputList.get(0).getLexeme().equalsIgnoreCase(storage[j].getVar()))
								{
									for(int k=0; k<count; k++)
									{	
										if(inputList.get(2).getLexeme().equalsIgnoreCase(storage[k].getVar()))
										{
										result = true;
										storage[j].setVal(storage[k].getVal());
										break;
										}
									}	
								}
						}
						if(result == false)
						{
							storage[count].setVar(inputList.get(0).getLexeme());
							for(int k=0; k<count; k++)
							{
								if(inputList.get(2).getLexeme().equalsIgnoreCase(storage[k].getVar()))
								{
									storage[count].setVal(storage[k].getVal());
								}
							}
							count++;
						}
					}
					//var = input
					else if(inputList.get(0).getToken() == "STR_VARIABLE" && inputList.get(2).getToken()=="INPUT_COMMAND")
					{
						boolean result = false;
						Scanner input = new Scanner(System.in);
						int j=0;
						while(j<count)
						{
							if(inputList.get(0).getLexeme().equalsIgnoreCase(storage[j].getVar()))
							{
								result = true;
								break;
							}
							j++;
						}
						
						if(result == true)
						{
						//update
							System.out.println("Please enter an string to assign to the variable '" + inputList.get(0).getLexeme()+ "'");
							storage[j].setVal(input.nextLine());
						}
						else
						{
							//add new
							storage[count].setVar(inputList.get(0).getLexeme());
							System.out.println("Please enter a string to assign to the variable '" + inputList.get(0).getLexeme()+ "'");
							storage[count].setVal(input.nextLine());
							count++;
						}
					
					}
					//var =  int
					else if(inputList.get(0).getToken() == "STR_VARIABLE" && inputList.get(2).getToken()=="STRING_LIT")
					{
						
						boolean result = false;
						for(int j =0; j<count; j++)
						{
							if(inputList.get(0).getLexeme().equalsIgnoreCase(storage[j].getVar()))
								{
									result = true;
									storage[j].setVal(inputList.get(2).getLexeme());
									break;
								}
						}
						if(result == false)
						{
							storage[count].setVar(inputList.get(0).getLexeme());
							storage[count].setVal(inputList.get(2).getLexeme());
							count++;
						}
						
					}
			}
		}
	}
	
	
	public void checkPrint(LinkedList<TokenObject> inputList)
	{
		int i=0;
		
		if(inputList.getFirst().getToken() == "PRINT_COMMAND")
		{
			
			//print string_lit
			try
			{
				
			if(inputList.get(1).getToken()=="STRING_LIT")
			{
				System.out.println(inputList.get(1).getLexeme());
			}
			//print expression
				//print var+var
			else if(inputList.get(1).getToken()=="INT_VARIABLE" && inputList.get(2).getToken()=="ADD_OP" && inputList.get(3).getToken()=="INT_VARIABLE")
			{
			//	System.out.println("var + var");
				
				
				
				
				for(int j=0; j<count; j++)
				{
					if(inputList.get(1).getLexeme().equalsIgnoreCase(storage[j].getVar()))
					{
						//first exists
						for (int k=0; k<count; k++)
						{
									if(inputList.get(3).getLexeme().equalsIgnoreCase(storage[k].getVar()))
											{
											int a = Integer.parseInt(storage[j].getVal());
											int b = Integer.parseInt(storage[k].getVal());
											System.out.println(a+b);
											//String c = Integer.toString(a+b);
											//storage[j].setVal(c);
											}
							}
						}
					}
				}
				
				
				
				
				
				
			
			//print var-var
			else if(inputList.get(1).getToken()=="INT_VARIABLE" && inputList.get(2).getToken()=="SUB_OP" && inputList.get(3).getToken()=="INT_VARIABLE")
			{
				System.out.println("var - var");
				
				for(int j=0; j<count; j++)
				{
					if(inputList.get(1).getLexeme().equalsIgnoreCase(storage[j].getVar()))
					{
						//first exists
						for (int k=0; k<count; k++)
						{
									if(inputList.get(3).getLexeme().equalsIgnoreCase(storage[k].getVar()))
											{
											int a = Integer.parseInt(storage[j].getVal());
											int b = Integer.parseInt(storage[k].getVal());
											System.out.println(a-b);
											//String c = Integer.toString(a+b);
											//storage[j].setVal(c);
											}
							}
						}
					}
				}
				
			
			//print svar+svar
			else if(inputList.get(1).getToken()=="STR_VARIABLE" && inputList.get(2).getToken()=="ADD_OP" && inputList.get(3).getToken()=="STR_VARIABLE")
			{
				System.out.println("str + str");
				
				for(int j=0; j<count; j++)
				{
					if(inputList.get(1).getLexeme().equalsIgnoreCase(storage[j].getVar()))
					{
						//first exists
						for (int k=0; k<count; k++)
						{
									if(inputList.get(3).getLexeme().equalsIgnoreCase(storage[k].getVar()))
											{
											System.out.println(storage[j].getVal() + storage[k].getVal());
											}
							}
						}
					}
				}
			
			//print svar+var
			else if(inputList.get(1).getToken()=="STR_VARIABLE" && inputList.get(2).getToken()=="ADD_OP" && inputList.get(3).getToken()=="INT_VARIABLE")
			{
				System.out.println("str + var");
				
				for(int j=0; j<count; j++)
				{
					
					if(inputList.get(1).getLexeme().equalsIgnoreCase(storage[j].getVar()))
					{
						//first exists
						for (int k=0; k<count; k++)
						{
									if(inputList.get(3).getLexeme().equalsIgnoreCase(storage[k].getVar()))
											{
											
											System.out.println(storage[j].getVal() + storage[k].getVal());
											}
							}
						}
					}
				}
				
				
				
			}
			catch(IndexOutOfBoundsException r)
			{
				//print var
				
				
				if(inputList.get(1).getToken()=="INT_VARIABLE")
				{
					for(int a = 0; a<count; a++)
					{
						if(inputList.get(1).getLexeme().equalsIgnoreCase(storage[a].getVar()))
						{
							System.out.println(storage[a].getVal());
							break;
						}
						else
						{
						//	System.out.println("Variable has not been initialized");
						}
						
					}
				}
				//print svar	
				else if(inputList.get(1).getToken()=="STR_VARIABLE")
					{
						for(int a = 0; a<count; a++)
						{
							if(inputList.get(1).getLexeme().equalsIgnoreCase(storage[a].getVar()))
							{
								System.out.println(storage[a].getVal());
								break;
							}
							else
							{
								//System.out.println("Variable has not been initialized");
							}
							
						}
				
				}
				if(count ==0)
				{
					System.out.println("Variable has not been initialized");
				}
			}
				
			
			//print string
				
			
				
			
			
			//System.out.println("Print Command");
		}
	}
	
	public void print()
	{
		System.out.println("var " + storage[0].getVar());
		System.out.println("val " + storage[0].getVal());
		System.out.println("var " + storage[1].getVar());
		System.out.println("val " + storage[1].getVal());
		
	}
	//input = input
	//print = print
	//assignments
		//string assignments
		//integer assignments
	//variable storage
	//integer
	//concatination
	
	
	
	
}
