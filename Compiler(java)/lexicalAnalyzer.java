package lexicalAnalyzer;
import java.io.IOException;

import javax.swing.JTable;
import javax.swing.event.*;
import javax.swing.table.TableModel;

import com.sun.prism.paint.Color;

import java.util.LinkedList;
import java.util.Scanner;
import java.io.*;

public class lexicalAnalyzer {
	public static  void main(String [ ] args) throws IOException
	{
	
		String[] lexemes, tokens;
		String lexeme, token;
		lexemes = new String[100];
		tokens = new String[100];
		int i=0;
		int j=0;
		
		Scanner fileScan = new Scanner(new File("input.txt"));
		LookUp lexicalObject = new LookUp();
		LinkedList<TokenObject> lexicalList = new LinkedList<TokenObject>();
		ListGetters getStuff = new ListGetters();
		
		
		/*
			//reads file, stores data in lexemes array
		   while (fileScan.hasNext())  
		   {       
			   
			   lexemes[i] =  fileScan.next();
			   
			   if(lexemes[i].charAt(0)== '"')
			   {
				   while(lexemes[i].charAt(lexemes[i].length()-1) != '"')
				   {
					   lexemes[i] = lexemes[i] + " " + fileScan.next();
				   }
			   }
			   i++;
		   }*/
		
		   while (fileScan.hasNext()) 
		   {
			  lexeme = fileScan.next();
			  if(lexeme.charAt(0)=='"')
			  {
				  while(lexeme.charAt(lexeme.length()-1) !='"')
				  {
					  lexeme = lexeme + " " + fileScan.next();
				  }
			  }
			  
			  token = "stuff";
			  token = lexicalObject.doAll(lexeme, token);
			  
			  
			  lexicalList.add(new TokenObject(lexeme,token));
			  
			  
			  
		   }
		   i=0;
		  
		   try
		   {
		   while(lexicalList.get(i) !=null)
		   {
			//  System.out.println((i)+ " " + lexicalList.get(i));
			   i++;
		   }
		   }
		   catch(IndexOutOfBoundsException e)
		   {
			   
		   }
		  
		
		  
		  
	   /*	i=0; //use lexemes to lookup their tokens and store in tokens array  		
		   	while (lexemes[i] != null)
		   	{
		   		tokens[i] = lexicalObject.doAll(lexemes[i], tokens[i]); 
				i++;
		   	}
		 */  	 

		   	
		   	
		   	/*
		   	 //print out a nice table of the lexemes and tokens  
		   	System.out.println("________________________________________________________________________");   
		    while (lexemes[j] != null)
		   	{
		    	System.out.format("%10s%20s%20s%20s","|  Lexeme = " , lexemes[j], "Tokens : " , tokens[j]+ "  |");
		    	System.out.println();
		   		j++;
		   	}
		   */

		  
		  new Syntax(lexicalList);
		  new Implementation(lexicalList);
		  
		  
		    
		  
		  
		  
	fileScan.close();
	}
}












