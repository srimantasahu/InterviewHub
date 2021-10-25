package com.kvvssut.interviews.designpattern.creational;

/*
 * Complex objects are made of parts produced by other objects that need
 * special care when being built. An application might need a mechanism for
 * building complex objects that is independent from the ones that make up
 * the object.
 * 
 * Builder pattern allows a client object to construct a complex object by
 * specifying only its type and content, being shielded from the details
 * related to the object's representation. This way the construction process
 * can be used to create different representations. The logic of this
 * process is isolated form the actual steps used in creating the complex
 * object, so the process can be used again to create a different object
 * form the same set of simple objects as the first one.
 * 
 * Intent
 * 
 * 1. Defines an instance for creating an object but letting subclasses
 * decide which class to instantiate
 * 
 * 2. Refers to the newly created object through a common interface
 */

//Abstract Builder
abstract class TextConverter {
	abstract void convertCharacter(char c);

	abstract void convertParagraph();
}

// Product
class ASCIIText {
	public void append(char c) { // Implement the code here
	}
}

// Concrete Builder
class ASCIIConverter extends TextConverter {
	ASCIIText asciiTextObj;// resulting product

	/*
	 * converts a character to target representation and appends to the
	 * resulting
	 */

	void convertCharacter(char c) {
		char asciiChar = new Character(c).charValue();
		// gets the ascii character
		asciiTextObj.append(asciiChar);
	}

	void convertParagraph() {
	}

	ASCIIText getResult() {
		return asciiTextObj;
	}
}

// This class abstracts the document object
class Document {
	static int value;
	char token;

	public char getNextToken() {
		// Get the next token
		return token;
	}
}

// Director
class RTFReader {
	private static final char EOF = '0'; // Delimiter for End of File
	final char CHAR = 'c';
	final char PARA = 'p';
	char t;
	TextConverter builder;

	RTFReader(TextConverter obj) {
		builder = obj;
	}

	void parseRTF(Document doc) {
		while ((t = doc.getNextToken()) != EOF) {
			switch (t) {
			case CHAR:
				builder.convertCharacter(t);
			case PARA:
				builder.convertParagraph();
			}
		}
	}
}

// Client
public class BuilderPattern {

	public static void main(String args[]) {
		BuilderPattern client = new BuilderPattern();
		Document doc = new Document();
		client.createASCIIText(doc);
		System.out.println("This is an example of Builder Pattern");
	}

	void createASCIIText(Document doc) {
		ASCIIConverter asciiBuilder = new ASCIIConverter();
		RTFReader rtfReader = new RTFReader(asciiBuilder);
		rtfReader.parseRTF(doc);
		ASCIIText asciiText = asciiBuilder.getResult();
	}

}

/*
 * The Builder design pattern is very similar, at some extent, to the Abstract
 * Factory pattern. That's why it is important to be able to make the difference
 * between the situations when one or the other is used. In the case of the
 * Abstract Factory, the client uses the factory's methods to create its own
 * objects. In the Builder's case, the Builder class is instructed on how to
 * create the object and then it is asked for it, but the way that the class is
 * put together is up to the Builder class, this detail making the difference
 * between the two patterns.
 */
