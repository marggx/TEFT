package Engine;

import Model.Token;
import com.formdev.flatlaf.json.Json;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public class Compiler {

    ArrayList<Token> tokens;
    String mainString;
    JSONObject json;

    public Compiler(ArrayList<Token> tokens, String string, JSONObject json) {
        this.tokens = tokens;
        this.mainString = string;
        this.json = json;
    }

    public String compile(String string) {
        StringBuilder newString = new StringBuilder();
        Integer lastPos = 0;
        ArrayList<Object> sets;

        for (Token token : tokens) {
            newString.append(string, lastPos, token.getStart());

            switch (token.getType()) {
                case "var":
                    Object object = json.get(token.getContent());
                    if (object != null) {
                        newString.append(object);
                    }
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
