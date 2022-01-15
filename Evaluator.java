import java.util.Stack;

/**
* This is a class that evaluates an 
* arithmetic expression in postfix notation
* demonstrating the Stack data structure
* @author DMorgan13
* Based on Pseudocode by Dr. Narayan Debnath
* */
public class Evaluator {
	
	private static Stack<Object> myStack; //Initialize empty Stack
	
	/**
	 * Will evaluate a postfix notation expression in String form and return the result as an int
	 * @param expression String expression in postfix notation
	 * @return integer Result
	 * 
	 */
	public String evaluate(String expression)
	{
		myStack = new Stack<Object>();
		int result = 0; //Initialize an integer to put the result in
		char[] exp = expression.toCharArray(); // breaking the String argument into an array for ease
		int operand1 = 0, operand2 = 0;//to integers to hold my operands for the binary arithmetic
		
		for(int a = 0; a < exp.length; a++)
		{
			char element = exp[a];
			if(isOperand(element))//If character is an operand PUSH onto the stack
			{
				myStack.push(element);
			}
			else
			{
				char operation = element; //If character is an operator, POP the previous operands and operate
					
					operand2 = Integer.parseInt(myStack.pop().toString());
					operand1 = Integer.parseInt(myStack.pop().toString());
					result = operation(operation, operand1, operand2);
					myStack.push(result);		
			}
		}
  		return ("" + result);
	}
	/**
	 * @param c Character
	 * @return Boolean true if c is an operand
	 *
	 */
	private boolean isOperand(char c)//Simple function to see if a char is an operand or not
	{
		char[] operands = {'0','1','2','3','4','5','6','7','8','9'};	
		for(int a = 0; a < operands.length; a++)//Loop though the list of operands and return true if there is a match
		{
			if(c == operands[a])
			{
				return true;
			}
		}
		return false;
	}
	 /**
	 * Takes two operators and performs the requested operation on them
	  * @param operation A character operator + - * /
	  * @param operand1 An integer
	  * @param operand2 An integer
	  * @return Integer result of operand1 operator operand2
	  * 
	  */
	private static int operation(char operation, int operand1, int operand2) 
	 {
	        int result = 0;

	        switch (operation) 
	        {
	            case '+' :
	                result = operand1 + operand2;
	                break;
	            case '-' :
	                result = operand1 - operand2;
	                break;
	            case '*' :
	                result = operand1 * operand2;
	                break;
	            case '/' :
	                result = operand1 / operand2;
	        }
			return result;
	 }

}
