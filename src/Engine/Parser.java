package Engine;

import Model.Token;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    final String wordRegex = "\\b([\\w-]+)\\b";

    public Parser() {

    }

    public Token createTokenForHit(ArrayList<String> hit, String type, ArrayList<String> nextHit) {
        Token token = new Token(Integer.parseInt(hit.get(0)), Integer.parseInt(hit.get(1)));

        if (type.equals("var")) {
            token.setType(type);
            token.setContent(hit.get(2));

        } else if (type.equals("func")) {
            final Pattern pattern = Pattern.compile(wordRegex);
            final Matcher matcher = pattern.matcher(hit.get(2));

            if (matcher.find()) {
                for (int i = 1; i <= matcher.groupCount(); i++) {
                    switch (matcher.group(i)) {
                        case "set" -> token.setType("set");
                        case "for" -> {
                            token.setType("for");
                            if (nextHit.isEmpty() || !nextHit.get(2).equals("endfor")) {
                                throw new IllegalArgumentException("For Statement was not closed at Position " + matcher.start(i));
                            }
                            token.setEnd(Integer.parseInt(nextHit.get(1)));
                        }
                        case "if" -> {
                            token.setType("if");
                            if (nextHit.isEmpty() || !nextHit.get(2).equals("endif")) {
                                throw new IllegalArgumentException("If Statement was not closed at Position " + matcher.start(i));
                            }
                            token.setEnd(Integer.parseInt(nextHit.get(1)));
                        }
                        default -> throw new IllegalArgumentException("Invalid function: " + matcher.group(i) + " at Position " + matcher.start(i));
                    }
                    token.setContent(matcher.replaceFirst("").trim());
                }
            }
        }

        return token;
    }
}
