import com.github.javaparser.ast.expr.*;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;
import static com.github.javaparser.JavaParser.*;
import java.io.File;
import com.github.javaparser.JavaParser;
import java.util.List;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;


class TwoferParser {

    public static CompilationUnit getContent(String flname) throws Exception{
        return JavaParser.parse(new File(flname));
    }

    private static class TwoferFinder extends VoidVisitorAdapter<Void> {
        boolean containsElse = false;

        @Override
        public void visit(ConditionalExpr ret, Void v) {
            if (ret.getElseExpr() != null) {
                containsElse = true;
            }
            System.out.println(ret);
        }
    }

    public static boolean parse(String flname) throws Exception {
        CompilationUnit cu = getContent(flname);
        // System.out.println(cu.toString());
        TwoferFinder tf = new TwoferFinder();
        cu.accept(tf, null);

        return tf.containsElse;
    }

}
