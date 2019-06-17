package lesson_3.stack;

public class Brackets {

    private final String text;

    public Brackets(String text) {
        this.text = text;
    }

    public void checkBrackets(){
        Stack<Character> stack = new StackImpl<>(text.length());
        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            checkCurrentChar(stack, i, currentChar);
        }
        if (!stack.isEmpty()){
            System.out.println("Error: missing right delimiter");
        }
    }

    private void checkCurrentChar(Stack<Character> stack, int i, char currentChar) {
        switch (currentChar){
            case '{':
            case '[':
            case '(':
                stack.push(currentChar);
                break;
            case '}':
            case ']':
            case ')':
                if(stack.isEmpty()){
                    System.out.println("Error: " + currentChar + " at " + i);
                    break;
                }

                Character lastOpenedBracket = stack.pop();
                if(
                    lastOpenedBracket == '{' && currentChar != '}' ||
                    lastOpenedBracket == '[' && currentChar != ']' ||
                    lastOpenedBracket == '(' && currentChar != ')'
                ) {
                    System.out.println("Error: " + currentChar + " at " + i);
                }
                break;
                default:
                    break;
        }
    }
}
