package lab3;

public class IntValue extends Expression {
	 private int value;

	    public IntValue(int value) {
	        this.value = value;
	    }

	    @Override
	    public int evaluate() {
	        return value;
	    }

	    @Override
	    public String toString() {
	        return Integer.toString(value);
	    }
}