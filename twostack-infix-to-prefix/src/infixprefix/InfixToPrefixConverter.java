package infixprefix;

import twostack.Twostack;
import twostack.TwostackArray;

import java.util.*;

/**
 * This class can be used to convert infix algebra notation to prefix algebra notation
 * @Author: Øyvind Johannessen
 * @Version: 1.0
 */
public class InfixToPrefixConverter {

    // Fields for this class
    Twostack<String> twostack;
    String[] operators = {"+", "-", "*", "/", "^"};
    private String infixNotation;
    private String prefixNotation;

    public static void main(String[] args) {
        InfixToPrefixConverter ipc = new InfixToPrefixConverter();
        ipc.convert("a+b*c");
        System.out.println("Input: " + ipc.getInfixNotation());
        System.out.println("Output: " + ipc.getPrefixNotation());

    }
    /**
     * Constructor for this class (Empty)
     */
    public InfixToPrefixConverter() {

    }

    /**
     * Pops two operands from left stack and one operator from the right stack and concatenates them
     * After pushes new String to left stack top
     */
    private void concatenate() {
        String operand1 = twostack.pop(false);
        String operand2 = twostack.pop(false);
        String operator = twostack.pop(true);
        String concat = operator + operand1 + operand2;
        twostack.push(false, concat);
    }

    /**
     * Initialises a new two stack array with the left stack containing the sequence of notation characters
     */
    public String convert(String infixNotation) {
        setInfixNotation(new StringBuilder(infixNotation).reverse().toString());
        validateInput();
        createStacks();
        reorder();
        finish();
        return getPrefixNotation();
    }

    /**
     * Completes the reordering and concatenates the last of parts of the stacks
     */
    private void finish() {
        while (rightStackNotEmpty()) {
            concatenate();
        }
        setInfixNotation(new StringBuilder(infixNotation).reverse().toString());
        setPrefixNotation(getLeftStackPeek());
    }

    /**
     * Reorders the infix notation
     */
    private void reorder() {
        for(int infixIndex = 0; infixIndex < getInfixNotationLength(); infixIndex++ ) {
            if( !isOperator(getCharacter(infixIndex)) ) {
                pushToLeftStack(infixIndex);
            } else {
                reorderRightStack(infixIndex);
            }
        }
    }

    /**
     * Returns the length of the infix notation (a+b*c length equals 5)
     * @return infix notation length
     */
    private int getInfixNotationLength() {
        return getInfixNotation().length();
    }

    /**
     * Reorders the right stack as long as right stack is not empty and infix character 'infixIndex' has priority less then or
     * equal to right stack top operator
     * @param infixIndex
     */
    private void reorderRightStack(int infixIndex) {
        while(rightStackNotEmpty() && operatorIsLessOrEqualTo(infixIndex)) {
            // Sett sammen streng
            concatenate();
        }
        pushToRightStack(infixIndex);
    }

    /**
     * Instantiates a TwoStack and sets the length to infix length * 2
     */
    private void createStacks() {
        twostack = new TwostackArray<>(getInfixNotationLength() * 2 );
    }

    /**
     * Print the current output state of the converter
     */
    private void printOutput() {
        System.out.println("Output: " + getLeftStackPeek());
    }

    /**
     * Return the top entry on the left stack
     * @return top entry
     */
    private String getLeftStackPeek() {
        return twostack.peek(false);
    }

    /**
     * Return the right stack top entry
     * @return
     */
    private String getRightStackPeek() {
        return twostack.peek(true);
    }

    /**
     * Checks if infix input is valid. Must not contain any space
     */
    private void validateInput() {
        if( getInfixNotation().contains(" ") ) {
            throw new IllegalArgumentException( "Wrong input: Do not use space in notation" );
        }
    }

    /**
     * Get infix character at index 'infixIndex' and cast to String
     * @param infixIndex
     * @return String character
     */
    private String getCharacter(int infixIndex) {
        return getInfixNotation().charAt(infixIndex) + "";
    }

    /**
     * Pushes infix index 'infixIndex' to left stack
     * @param infixIndex
     */
    private void pushToLeftStack(int infixIndex) {
        twostack.push(false, getCharacter(infixIndex));
    }

    /**
     * Pushes infix index 'infixIndex' to right stack
     * @param infixIndex
     */
    private void pushToRightStack(int infixIndex) {
        twostack.push(true, getCharacter(infixIndex));
    }

    /**
     * Checks if right stack is empty
     * @return True or False
     */
    private boolean rightStackNotEmpty() {
        return twostack.size(true) != 0;
    }

    /**
     * Checks if a operator at infix infixIndex 'i' has less or equal precedence to right stack top operator
     * @param infixIndex
     * @return True or False, depending on i parameter
     */
    private boolean operatorIsLessOrEqualTo(int infixIndex) {
        if(!isOperator(getCharacter(infixIndex))) {
            throw new IllegalArgumentException("Not an operator at this infixIndex");
        }
        return getPrecedenceValue(getCharacter(infixIndex)) <= getPrecedenceValue(getRightStackPeek());
    }

    /**
     * Checks if a String character is an operator or not
     * @param character
     * @return True or False depending on parameter input
     */
    private boolean isOperator(String character) {
        return Arrays.stream(operators).anyMatch(character::equals);
    }

    /**
     * Checks the precedence value of a operator
     * @param operator
     * @return A value from 0 and 2
     */
    private int getPrecedenceValue(String operator) {
        switch (operator) {
            case "+":
                return 1;
            case "-":
                return 1;
            case "*":
                return 2;
            case "/":
                return 2;
            case "^":
                return 3;
        }
        return 0;
    }

    /**
     * Get's the infix notation
     * @return
     */
    public String getInfixNotation() {
        return infixNotation;
    }

    /**
     * Set's the infix notation
     * @param infixNotation
     */
    private void setInfixNotation(String infixNotation) {
        this.infixNotation = infixNotation;
    }

    /**
     * Get's the prefix notation
     * @return
     */
    public String getPrefixNotation() {
        return prefixNotation;
    }

    /**
     * Set's the prefix notation
     * @param prefixNotation
     */
    private void setPrefixNotation(String prefixNotation) {
        this.prefixNotation = prefixNotation;
    }
}
