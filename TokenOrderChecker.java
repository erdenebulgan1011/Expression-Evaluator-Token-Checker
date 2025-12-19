package lab3;
import java.util.*;

public class TokenOrderChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Orolt: ");
        String input = scanner.nextLine();

        List<Token> expected1 = Arrays.asList(
            new Token("INT", "int"),
            new Token("IDENTIFIER", "main"),
            new Token("LEFT_PARENT", "("),
            new Token("RIGHT_PARENT", ")"),
            new Token("LEFT_BRACE", "{")
        );

        List<Token> expected2 = Arrays.asList( //
            new Token("INT", "int"),
            new Token("IDENTIFIER", "main"),
            new Token("ZUUN_HAALT", "("),
            new Token("ZUUN_HAALT", "("),
            new Token("BARUUN_HAALT", ")"),
            new Token("BARUUN_HAALT", ")"),
            new Token("ZUUN_BURJGAR", "{")
        );

        List<Token> actual = tokenize(input);

        /*System.out.println("Tanii orolt: " + input);
        System.out.println("Tokens: " + (input.equals("int main(){}") ? expected1 : expected2));
        System.out.println("Uusgesen tokens: " + actual);*/
        System.out.println("Token " + (isTokenOrderCorrect(actual) ? "Zuv" : "Buruu"));
    }

    public static List<Token> tokenize(String input) {
        List<Token> tokens = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '(') {
                tokens.add(new Token("ZUUN_HAALT", "("));
            } else if (c == ')') {
                tokens.add(new Token("BARUUN_HAALT", ")"));
            } else if (c == '{') {
                tokens.add(new Token("ZUUN_BURJGAR", "{"));
            } else if (c == '}') {
                tokens.add(new Token("BARUUN_BURJGAR", "}"));
            }
        }
        String[] words = input.split("[^\\w']+");
        for (String word : words) {
            if (word.equals("int")) {
                tokens.add(new Token("INT", "int"));
            } else if (word.matches("[a-zA-Z][a-zA-Z0-9]*")) {
                tokens.add(new Token("IDENTIFIER", word));
            }
        }
        return tokens;
    }

    public static boolean isTokenOrderCorrect(List<Token> tokens) {
        Stack<Token> stack = new Stack<>();

        for (Token token : tokens) {
            if (token.getType().equals("ZUUN_HAALT") || token.getType().equals("ZUUN_HAALT")) {
                stack.push(token);
            } else if (token.getType().equals("BARUUN_HAALT")) {
                if (stack.isEmpty() || !stack.peek().getType().equals("ZUUN_HAALT")) {
                    return false;
                }
                stack.pop();
            } else if (token.getType().equals("BARUUN_HAALT")) {
                if (stack.isEmpty() || !stack.peek().getType().equals("ZUUN_HAALT")) {
                    return false;
                }
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}

class Token {
    private String type;
    private String value;

    public Token(String type, String value) {
        this.type = type;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "(" + type + ", " + value + ")";
    }
}
