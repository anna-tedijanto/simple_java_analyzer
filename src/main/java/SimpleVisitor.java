import com.github.javaparser.ast.visitor.TreeVisitor;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.stmt.ReturnStmt;

public class SimpleVisitor extends TreeVisitor {
    public boolean hasHelloWorld = false;

    public void process(Node node){
        if (node instanceof ReturnStmt && node.toString().contains("Hello, World!")) {
            hasHelloWorld = true;
        }
    }

}
