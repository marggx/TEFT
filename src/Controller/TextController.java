package Controller;

import Engine.Compiler;
import Engine.Lexer;
import Engine.Parser;
import Model.Token;
import View.Form;

import java.util.ArrayList;
import java.util.Comparator;


public class TextController {

    public TextController(Form form) {
        form.process(e -> {
            Lexer lexer = new Lexer(form.textField.getText());
            ArrayList<ArrayList<String>> variables = lexer.lex(lexer.regexVariable);
            ArrayList<ArrayList<String>> functions = lexer.lex(lexer.regexFunc);

            Parser parser = new Parser();
            ArrayList<Token> tokens = new ArrayList<>();

            for (ArrayList<String> hit : variables) {
                tokens.add(parser.createTokenForHit(hit, "var", new ArrayList<>()));
            }

            for (ArrayList<String> hit : functions) {
                tokens.add(parser.createTokenForHit(hit, "func", new ArrayList<>()));
            }

            tokens.sort(Comparator.comparing(Token::getStart));

            Compiler compiler = new Compiler(tokens, form.textField.getText(), form.json);

            String processedString = compiler.compile(form.textField.getText());

            form.textField.setText(processedString);
        });

    }

}
