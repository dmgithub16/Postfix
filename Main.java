/**
 * This is simply a main class to demonstrate
 * the Converter and Evaluator classes
 * @author DMorgan13
 * */
public class Main {

	public static void main(String[] args) {

		String[] exp = {"2+3*4", "(2+3)*4", "4*5/2-5","2+3-4+5*6/3","2+3-(2+5*6)/4/2","(2+8)-((2+5)*6)/3/2","((5-3)*(8-3)+(2+1)*3)*((5-3)*(8-3)+(2+1)*3)","2+3*4", "(2+3)*4", "4*5/2-5","2+3-4+5*6/3","2+3-(2+5*6)/4/2","(2+8)-((2+5)*6)/3/2","((5-3)*(8-3)+(2+1)*3)*((5-3)*(8-3)+(2+1)*3)"};
		String[] conv = new String[14];
		String[] eval = new String[14];
		Converter co = new Converter();
		Evaluator ev = new Evaluator();
		
		System.out.println("Derek Morgan: Assignment 2");
		System.out.println("--------------------------");
		
		for(int a = 0; a < exp.length;a++)
		{
			String disp = co.convert(exp[a]);
			conv[a] = disp;
			disp = ev.evaluate(conv[a]);
			eval[a] = disp;
			
			System.out.println(exp[a] + " Converted to Postfix: " + conv[a] + " Evaluates to: " + eval[a]);
			System.out.println();
		}
	}
}
