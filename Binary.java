package lab3;

public class Binary extends Expression {
	  private String op;
	    private Expression term1;
	    private Expression term2;

	    public Binary(String op, Expression term1, Expression term2) {
	        this.op = op;
	        this.term1 = term1;
	        this.term2 = term2;
	    }

	    @Override
	    public int evaluate() {
	        int result = 0;

	        switch (op) {
	            case "+":
	                result = term1.evaluate() + term2.evaluate();
	                break;
	            case "-":
	                result = term1.evaluate() - term2.evaluate();
	                break;
	            case "*":
	                result = term1.evaluate() * term2.evaluate();
	                break;
	            case "/":
	                result = term1.evaluate() / term2.evaluate();
	                break;
	            default:
	                throw new IllegalArgumentException("Invalid operator: " + op);
	        }

	        return result;
	    }

	    @Override
	    public String toString() {
	        return "[" +"op= '"+ op +"', "+ "term1="+ term1.toString() + ", "+ "term2=" + term2.toString() + "]";
	    }
}