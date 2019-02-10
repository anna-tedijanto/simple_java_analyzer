import com.github.javaparser.ast.expr.*;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;
import static com.github.javaparser.JavaParser.*;
import java.io.File;
import com.github.javaparser.JavaParser;
import java.util.List;

class SimpleParser {

    CompilationUnit getContent(String flname) throws Exception{
        return JavaParser.parse(new File(flname));
    }

    boolean visit(Node content) {
        SimpleVisitor sv = new SimpleVisitor();
        sv.visitPreOrder(content);
        System.out.println(sv.hasHelloWorld);
        return true;
    }

    String getGreeting() {
        Expression e = parseExpression("1+1");
        System.out.println(e.toString());
        return "Hello, World!";
    }

}
