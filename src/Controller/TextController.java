package Controller;

import View.Form;
import java.util.regex.*;


public class TextController {

    final String regexVariable = "\\{{\\s*([^}]+)\\s*}}";
    final String regexFunc = "\\{%\\s*([^%}]+)\\s*%}";


    public TextController(Form form) {
        form.selectFile(e -> {

            final Pattern pattern = Pattern.compile(regexFunc, Pattern.COMMENTS);
            final Matcher matcher = pattern.matcher("{{test}}{% set }test = 123 %} {% if 1234 = abc %} {% endif %}");

            while (matcher.find()) {
                System.out.println("Full match: " + matcher.group(0));

                for (int i = 1; i <= matcher.groupCount(); i++) {
                    System.out.println("Group " + i + ": " + matcher.group(i).trim());
                }
            }
        });

    }

}
