import org.antlr.v4.runtime.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author alex.collins
 */
public class GameFactory {
    public Game createGame(InputStream in) throws IOException {
        FieldLexer l = new FieldLexer(new ANTLRInputStream(in));
        FieldParser p = new FieldParser(new CommonTokenStream(l));
        p.addErrorListener(new BaseErrorListener() {
            @Override
            public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
                throw new IllegalStateException("failed to parse at line " + line + " due to " + msg, e);
            }
        });

        final AtomicReference<String> name = new AtomicReference<>();
        final Map<String, Integer> points = new HashMap<>();
        final String[][] grid = new String[5][5];

        p.addParseListener(new FieldBaseListener() {
            int x;
            int y;

            @Override
            public void exitField(FieldParser.FieldContext ctx) {
                name.set(ctx.name.getText());
            }

            @Override
            public void exitLocation(FieldParser.LocationContext ctx) {
                x = Integer.parseInt(ctx.x.getText());
                y = Integer.parseInt(ctx.y.getText());
            }

            @Override
            public void exitBurial(FieldParser.BurialContext ctx) {
                grid[x][y] = ctx.treasure.getText();
            }

            @Override
            public void exitPoints(FieldParser.PointsContext ctx) {
                points.put(ctx.treasure.getText(), Integer.parseInt(ctx.value.getText()));
            }


        });
        p.field();

        return new Game(name.get(), points, grid);
    }
}
