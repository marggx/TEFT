package Engine;

import Model.Token;

import java.util.ArrayList;

public class Compiler {

    ArrayList<Token> tokens;
    String mainString;

    public Compiler(ArrayList<Token> tokens, String string ) {
        this.tokens = tokens;
        this.mainString = string;
    }

    public String compile(String string) {
        StringBuilder newString = new StringBuilder();
        Integer lastPos = 0;

        for (Token token : tokens) {
            newString.append(string, lastPos, token.getStart());

            switch (token.getType()) {
                case "var":

                    break;
                case "set":
                    break;
                case "for":
                    break;
                case "if":
                    break;
            }

            lastPos = token.getEnd();
        }


        return newString.toString();
    }

}
