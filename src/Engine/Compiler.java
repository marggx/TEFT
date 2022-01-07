package Engine;

import Model.Token;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;

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
        ArrayList<ArrayList<Object>> sets = new ArrayList<>();

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
                    String[] set = token.getContent().split("=");
                    sets.add(new ArrayList<>(Arrays.stream(set).toList()));
                    break;
                case "for":
                    JSONArray forobj = (JSONArray) json.get(token.getContent());
                    for (Object obj: forobj) {
                        newString.append(forobj);
                    }
                    break;
                case "if":
                    String[] ifCon = token.getContent().split("=");
                    Object ifobj = json.get(ifCon[0]);

                    if (ifobj.equals(ifCon[1])){
                        newString.append(token.getContent());
                    }
                    break;
            }

            lastPos = token.getEnd();
        }


        return newString.toString();
    }

}
