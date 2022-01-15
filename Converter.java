import java.util.Stack;

/**
* This is a class that converts an 
* arithmetic expression from infix to postfix notation
* @author DMorgan13
* Based on Pseudocode by Dr. Narayan Debnath
*/
public class Converter {
	
	private static Stack<Object> myStack; //Initialize empty Stack
	private static String postString; //Initialize empty postfix notation String
	private static char topsymbol;
	
	
	/**
	 * @param expression Arithmetic expression in infix notation
	 * @return Postfix String from infix expression
	 */
	public String convert(String expression)
	{
		topsymbol = 0;
		postString = "";
		myStack = new Stack<Object>();
		postString = "";
		
		// converting the String into an array, that will make reading the individual characters easier
		char[] exp = expression.toCharArray();

		
		for(int a = 0; a < exp.length; a++)
		{
			char symbol = exp[a];//Read a token and copy it into symbol
			if(isOperand(symbol))// If symbol is an operand then
			{
				postString += symbol;//Add symbol to the postfix String
			}	
			else//symbol is an operator so we have to check it
			{
				//If the stack isn't empty and Prcd is true then
				while(!myStack.isEmpty() && Prcd((char)myStack.peek(), symbol)) 
				{
					topsymbol = (char) myStack.pop();//pop the top item on the stack
					postString += topsymbol;//add it to postfix String
				}
				myStack.push(symbol);//add the operator to the top of the stack
			}
		}
		while(!myStack.isEmpty())//empty remaining items
		{
			topsymbol = (char) myStack.pop();
			if(topsymbol == '(' || topsymbol == ')')//Dump any parenthesis because postfix notation is unambiguous
			{	
				postString += "";
			}
			else
			postString += topsymbol;
		}
		
		return postString;
	}
	/**
	 * Simple function to see if a char is an operand or not
	 * @param c Char to be compared to a list of operands 1-9
	 * @return boolean true if char c is an operand
	 */
	private static boolean isOperand(char c)
	{
		char[] operands = {'0','1','2','3','4','5','6','7','8','9'};
		
		for(int a = 0; a < operands.length; a++)
		{
			if(c == operands[a])
			{
				return true;
			}
		}
		return false;
	}
	
	/**
	 *Operator precedence function returns true 
	 *if arg1 has a higher operator precedence
	 *than arg2. It is implied, but not necessary
	 *that arg1 is the item at the top of a stack
	 *of chars. The decision tree is based on the
	 *truth table below:
	 *
	 *	 ( ) ^ * / + - 
	 *	(F E F F F F F 	
	 *	)F E T T T T T
	 *	^F E F F F F F
	 *	*F E T T T F F
	 *	/F E T T T F F
	 *	+F E T T T T T
	 *	-F E T T T T T
	 *
	 * @param arg1 char to be tested for precedence
	 * @param arg2 char to be tested for precedence
	 * @return boolean
	 */
	private static boolean Prcd(char arg1, char arg2)
	{
		if(arg1 == '+' || arg1 =='-')
		{
			if(arg2 == '+' || arg2 == '-' || arg2== ')')
			{
				return true;
			}
			else
				return false;
		}
		else if(arg1 =='*' || arg1 =='/')
		{
			if(arg2 =='^' || arg2 =='(')
			{
				return false;
			}	
			else
				return true;
		}
		else if(arg1 =='^')
		{
			if(arg2 =='^' || arg2 =='(')
			{
				return false;
			}
			else
				return true;
		}
		else if(arg1 =='(')
		{
			return false;
		}	
		/*Final false return for error conditions
		* like a right parenthesis as arg2
		*/
		return false;
		
	}
}
