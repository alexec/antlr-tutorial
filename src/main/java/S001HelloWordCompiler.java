import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.CommonTree;
import org.meri.antlr_step_by_step.parsers.S001HelloWordLexer;
import org.meri.antlr_step_by_step.parsers.S001HelloWordParser;

/**
 * Created by alex.collins on 24/12/2013.
 */
public class S001HelloWordCompiler {
    public CommonTree compile(String expression) throws RecognitionException {
        //lexer splits input into tokens
        ANTLRStringStream input = new ANTLRStringStream(expression);
        TokenStream tokens = new CommonTokenStream(new S001HelloWordLexer(input));

        //parser generates abstract syntax tree
        S001HelloWordParser parser = new S001HelloWordParser(tokens);
        S001HelloWordParser.expression_return ret = parser.expression();

        //acquire parse result
        return (CommonTree) ret.getTree();
    }
}
