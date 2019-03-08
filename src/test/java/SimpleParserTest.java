import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SimpleParserTest {

    @Test
    public void testThatGreeterReturnsTheCorrectGreeting() {
        assertEquals("Hello, World!", new SimpleParser().getGreeting());
    }

    @Test
    public void testSimpleVisitor() throws Exception{
        SimpleParser sp = new SimpleParser();
        assertEquals(true, sp.visit(sp.getContent("Greeter.java")));
    }

    @Test
    public void testSimpleVisitor2() throws Exception{
        SimpleParser sp = new SimpleParser();
        assertEquals(false, sp.visit(sp.getContent("Greeter2.java")));
    }
}
