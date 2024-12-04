package com.kvvssut.interviews.java.versions.java14.textblocks;

/*
In addition to the capabilities from JDK 13 to make multiline strings easier to use, in their second preview,
text blocks now have two new escape sequences:
\: to indicate the end of the line, so that a new line character is not introduced
\s: to indicate a single space
 */
public class NewTextBlocksFeatures {

    public static void main(String[] args) {
        // Earlier
        String multiline = "A quick brown fox jumps over a lazy dog; the lazy dog howls loudly.";

        // With text blocks
        String textBlock = """
                A quick brown fox jumps over a lazy dog; \
                the lazy dog howls loudly.""";

        System.out.println(textBlock);
    }

}
