package com.kvvssut.interviews.java.versions.java13.textblocks;

/*
Text Blocks were introduced as a preview feature in Java 13 and were made a permanent part of the Java language in Java 15.
It provides a more readable and natural way to define multi-line Strings without the need for concatenation or escape characters.
Text Blocks are particularly useful for writing SQL queries, JSON, XML, and any other kind of formatted text where readability is important.
 */
public class TextBlocks {

    public static void main(String[] args) {

        // Earlier, to embed JSON in our code
        String jsonString
                = "{\r\n" + "\"name\" : \"Baeldung\",\r\n" + "\"website\" : \"https://www.%s.com/\"\r\n" + "}";

        // With text blocks
        String jsonTextBlock = """
                {
                    "name" : "Baeldung",
                    "website" : "https://www.%s.com/"
                }
                """;

        System.out.println(jsonTextBlock);
    }

}
