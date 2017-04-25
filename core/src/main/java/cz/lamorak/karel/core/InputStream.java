package cz.lamorak.karel.core;

/**
 * Created by ondrej on 25.4.2017.
 */

public class InputStream {

    private int pos;
    private int line;
    private int col;

    private final CharSequence input;

    public InputStream(CharSequence input) {
        this.input = input;
    }

    public char next() throws StringIndexOutOfBoundsException {
        char ch = input.charAt(pos++);
        if (ch == '\n') {
            line++;
            col = 0;
        } else {
            col++;
        }
        return ch;
    }

    public char peek() throws StringIndexOutOfBoundsException{
        return input.charAt(pos);
    }

    public boolean eof() {
        return pos == input.length();
    }

    public void croak(final String msg) {
        throw new Error(msg + "at (" + line + ":" + col + ")");
    }
}
