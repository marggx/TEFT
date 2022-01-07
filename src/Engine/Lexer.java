package Engine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lexer {

    final public String regexVariable = "\\{\\{\\s*([^}]+)\\s*}}";
    final public String regexFunc = "\\{%\\s*([^%}]+)\\s*%}";
    String text;

    public Lexer(String text) {
        this.text = text;
    }


    public ArrayList<ArrayList<String>> lex(String regex) {
        ArrayList<ArrayList<String>> hits = new ArrayList<>();

        final Pattern pattern = Pattern.compile(regex, Pattern.COMMENTS);
        final Matcher matcher = pattern.matcher(this.text);

        while (matcher.find()) {
            ArrayList<String> hit = new ArrayList<>();

            for (int i = 1; i <= matcher.groupCount(); i++) {
                hit = new ArrayList<>(
                        Arrays.asList(
                                Integer.toString(matcher.start(i)),
                                Integer.toString(matcher.end(i)),
                                matcher.group(i).trim()
                        )
                );
            }

            if (!hit.isEmpty()) {
                hits.add(hit);
            }
        }
        return hits;
    }

}
