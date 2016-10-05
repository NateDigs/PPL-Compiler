package lexicalAnalyzer;

public class TokenObject {

	private String lexeme, token;
	
	
	public TokenObject()
	{
		
	}
	public TokenObject(String lexeme, String token)
	{
		this.token = token;
		this.lexeme = lexeme;
	}
	
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	public String getLexeme() {
		return lexeme;
	}

	public void setLexeme(String lexeme) {
		this.lexeme = lexeme;
	}
	
	public String toString()
	   {
		      String description = "|  Lexeme = " + lexeme + " Tokens : " + token + "  |";
		      return description;
		   }


}
