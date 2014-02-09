import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;
import org.junit.Test;
import org.meri.antlr_step_by_step.parsers.S001HelloWordParser;

import static org.junit.Assert.assertEquals;

/**
 * Created by alex.collins on 24/12/2013.
 */
public class S001HelloWordCompilerTest {
    @Test
    public void testCorrectExpression() throws RecognitionException {
        //compile the expression
        S001HelloWordCompiler compiler = new S001HelloWordCompiler();
        CommonTree ast = compiler.compile("Hello wordoo");
        Tree rightChild = ast.getChild(1);
        Tree leftChild = ast.getChild(0);

        //check ast structure
        assertEquals(S001HelloWordParser.SALUTATION, leftChild.getType());
        assertEquals(S001HelloWordParser.ENDSYMBOL, rightChild.getType());
    }

}
