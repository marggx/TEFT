package Controller;

import java.util.regex.*;


public class TextController {

    final String regexName  = "[a-zA-Z_\\x7f-\\xff][a-zA-Z0-9_\\x7f-\\xff]*";
    final String regexNumber = "[0-9]+(?:\\.[0-9]+)?([Ee][\\+\\-][0-9]+)?";
    final String regexString = "\\\"([^#\\\"\\\\\\\\]*(?:\\\\\\\\.[^#\\\"\\\\\\\\]*)*)\\\"|\\'([^\\'\\\\\\\\]*(?:\\\\\\\\.[^\\'\\\\\\\\]*)*)\\'";
    public void main(String[] args) {

        final Pattern pattern = Pattern.compile(regex);
        final Matcher matcher = pattern.matcher("{{test}}{% set test = 123 %} {% if 1234 = abc %} {% endif %}");

        if (matcher.find()) {
            System.out.println("Full match: " + matcher.group(0));

            for (int i = 1; i <= matcher.groupCount(); i++) {
                System.out.println("Group " + i + ": " + matcher.group(i));
            }
        }
    }

}
