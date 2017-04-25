package cz.lamorak.karel.core;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

/**
 * Created by ondrej on 25.4.2017.
 */
public class InputStreamTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void testNext() {
        final CharSequence testSequence = "Hello,\nworld!";
        InputStream stream = new InputStream(testSequence);
        for (int i = 0; i < testSequence.length(); i++) {
            assertEquals(stream.next(), testSequence.charAt(i));
        }
        exception.expect(StringIndexOutOfBoundsException.class);
        stream.next();
    }

    @Test
    public void testPeek() {
        final CharSequence testSequence = "x";
        InputStream stream = new InputStream(testSequence);
        assertEquals(stream.peek(), testSequence.charAt(0));
        stream.next();
        exception.expect(StringIndexOutOfBoundsException.class);
        stream.peek();
    }

    @Test
    public void testEof() {
        final CharSequence testSequence = "x";
        InputStream stream = new InputStream(testSequence);
        assertEquals(stream.eof(), false);
        stream.next();
        assertEquals(stream.eof(), true);
    }

    @Test
    public void testCroak() {
        InputStream stream = new InputStream("");
        exception.expect(Error.class);
        stream.croak("Unexpected character");
    }
}