
public class Variable extends Expression {
	 private String id;
	    private int value;

	    public Variable(String id) {
	        this.id = id;
	        this.value = 0; 
	    }

	    public void setValue(int value) {
	        this.value = value;
	    }

	    public String getId() {
	        return id;
	    }

	    @Override
	    public int evaluate() {
	        return value;
	    }

	    @Override
	    public String toString() {
	        return id;
	    }
}
