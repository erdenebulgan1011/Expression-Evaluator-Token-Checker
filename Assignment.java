package lab3;

public class Assignment {
	 private Variable target;
	    private Expression source;

	    public Assignment(Variable target, Expression source) {
	        this.target = target;
	        this.source = source;
	    }

	    public Variable getTarget() {
	        return target;
	    }

	    public Expression getSource() {
	        return source;
	    }

	    public int evaluate() {
	        return source.evaluate();
	    }

	    @Override

	    public String toString() {
	        return String.format("[target = %s, source = %s]", target.getId(), source.toString());
	    }

}