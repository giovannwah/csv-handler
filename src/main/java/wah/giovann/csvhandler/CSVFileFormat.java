package wah.giovann.csvhandler;

import java.nio.charset.StandardCharsets;
/**
 * Created by giovadmin on 4/27/17.
 */
public class CSVFileFormat {
    public static final char[] LINE_FEED_LINE_END = new char[]{'\n'};
    public static final char[] CARRIAGE_RETURN_LINE_END = new char[]{'\r'};
    public static final char[] CARRIAGE_RETURN_LINE_FEED_LINE_END = new char[]{'\r','\n'};

    public static final char COMMA_DELIMITER = ',';
    public static final char TAB_DELIMITER = '\t';
    public static final char DECIMAL_DELIMITER = '.';
    public static final char SEMICOLON_DELIMITER = ';';
    public static final char COLON_DELIMITER = ':';
    public static final char SPACE_DELIMITER = ' ';
    public static final char PIPE_DELIMITER = '|';

    public static final String ISO_8859_1_CHARSET = StandardCharsets.ISO_8859_1.name();
    public static final String US_ASCII_CHARSET = StandardCharsets.US_ASCII.name();
    public static final String UTF_16_CHARSET = StandardCharsets.UTF_16.name();
    public static final String UTF_16BE_CHARSET = StandardCharsets.UTF_16BE.name();
    public static final String UTF_16LE_CHARSET = StandardCharsets.UTF_16LE.name();
    public static final String UTF_8_CHARSET = StandardCharsets.UTF_8.name();

    public static final CSVFileFormat DEFAULT_FORMAT = new CSVFileFormat(
            new CSVFileFormat.Builder()
    );
    private char delimiter;
    private boolean trimSpace;
    private boolean hasHeader;
    private String characterSetName;
    private char[] outputFileLineEnd;

    public boolean getTrimSpace() { return this.trimSpace; }

    protected void setTrimSpace(boolean b){
        this.trimSpace = b;
    }
    public boolean getHasHeader(){
        return this.hasHeader;
    }

    protected void setHasHeader(boolean b) {
        this.hasHeader = b;
    }
    public char getDelimiter() {
        return this.delimiter;
    }

    protected void setDelimiter(char c){
        this.delimiter = c;
    }
    public String getCharacterSetName() {
        return this.characterSetName;
    }

    protected void setCharacterSetName(String s) {
        this.characterSetName = s;
    }
    public char[] getOutputFileLineEnd() {
        return this.outputFileLineEnd;
    }

    protected void setOutputFileLineEnd(char[] le) {
        this.outputFileLineEnd = le;
    }


    private CSVFileFormat(Builder b){
        this.delimiter = b.delimiter;
        this.outputFileLineEnd = b.outputFileLineEnd;
        this.characterSetName = b.characterSetName;
        this.hasHeader = b.hasHeader;
        this.trimSpace = b.trimSpace;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Delimiter: ");
        switch(this.delimiter) {
            case COMMA_DELIMITER:
                sb.append("COMMA DELIMITER");
                break;
            case TAB_DELIMITER:
                sb.append("TAB DELIMITER");
                break;
            case DECIMAL_DELIMITER:
                sb.append("DECIMAL DELIMITER");
                break;
            case SEMICOLON_DELIMITER:
                sb.append("SEMICOLON DELIMITER");
                break;
            case COLON_DELIMITER:
                sb.append("COLON DELIMITER");
                break;
            case SPACE_DELIMITER:
                sb.append("SPACE DELIMITER");
                break;
            case PIPE_DELIMITER:
                sb.append("PIPE DELIMITER");
                break;
            default:
                sb.append("'"+this.delimiter+"'");
                break;
        }
        sb.append("\n");
        sb.append("Destination Line End: ");
        if (this.outputFileLineEnd.length == 2) sb.append("CARRIAGE RETURN + LINE FEED");
        else if (this.outputFileLineEnd[0] == '\n') sb.append("LINE FEED");
        else sb.append("CARRIAGE RETURN");
        sb.append("\n");
        sb.append("Charset Name: "+this.characterSetName+"\n");
        sb.append("Has Header: "+this.hasHeader+"\n");
        sb.append("Trim Space: "+this.trimSpace);
        return sb.toString();
    }
    public static class Builder {
        private char delimiter;
        private boolean trimSpace;
        private boolean hasHeader;
        private String characterSetName;
        private char[] outputFileLineEnd;

        public Builder(){
            this.delimiter = CSVFileFormat.COMMA_DELIMITER;
            this.outputFileLineEnd = CSVFileFormat.LINE_FEED_LINE_END;
            this.characterSetName = null;
            this.hasHeader = true;
            this.trimSpace = true;
        }
        public Builder delimiter(char c){
            this.delimiter = c;
            return this;
        }
        public Builder outputFileLineEnd(char[] c) {
            this.outputFileLineEnd = c;
            return this;
        }
        public Builder characterSetName(String s){
            this.characterSetName = s;
            return this;
        }
        public Builder hasHeader(boolean h){
            this.hasHeader = h;
            return this;
        }
        public Builder trimSpace(boolean b){
            this.trimSpace = b;
            return this;
        }
        public CSVFileFormat build() {
            return new CSVFileFormat(this);
        }
    }
}
