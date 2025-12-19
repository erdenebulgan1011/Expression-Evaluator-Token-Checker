package lab3;

public class main {
	public static void main(String[] args) {
	   
		Expression term1 = new Variable("x");
		Expression term2b = new Variable("y");
	    Variable z = new Variable("z");
	    Expression term2a = new IntValue(2);
	    Binary b2 = new Binary("*", term2a, term2b);
	    Expression term_main = new Binary("+", term1, b2);
	    Assignment assignment1 = new Assignment(z, term_main);
	   
	   
	    System.out.println(term_main.toString());
	}
}