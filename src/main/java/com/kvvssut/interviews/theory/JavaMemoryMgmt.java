package com.kvvssut.interviews.theory;

public class JavaMemoryMgmt {

	// JRE
	/*
	 * Java is every where in browser, in mobile, in TV or in set-top boxes and
	 * if you are into Java programming language than you know that Java code
	 * which is bundled in JAR (Java archive) file require Java virtual machine
	 * JVM to execute it. Now JVM is an executable or program like any other
	 * program and you can install that into your machine. You have seen browser
	 * often suggesting download JRE to run a Java Applet downloaded from
	 * Internet. Various version of JRE are available in java.oracle.com and
	 * most of the user who just want to execute Java program inside browser or
	 * standalone downloads JRE. All browsers including Internet Explorer,
	 * Firefox and Chrome can work with JRE.
	 */

	// JVM
	/*
	 * When you download JRE and install on your machine you got all the code
	 * required to create JVM. Java Virtual Machine is get created when you run
	 * a java program using java command e.g. java HelloWorld. JVM is
	 * responsible for converting byte code into machine specific code and
	 * that's why you have different JVM for Windows, Linux or Solaris but one
	 * JAR can run on all this operating system.
	 * 
	 * Java Virtual machine is at heart of Java programming language and provide
	 * several feature to Java programmer including Memory Management and
	 * Garbage Collection, Security and other system level services. Java
	 * Virtual Machine can be customized e.g we can specify starting memory or
	 * maximum memory of heap size located inside JVM at the time of JVM
	 * creation. If we supplied invalid argument to java command it may refuse
	 * to create Java Virtual Machine by saying
	 * "failed to create Java virtual machine: invalid argument". In short Java
	 * Virtual Machine or JVM is the one who provides Platform independence to
	 * Java.
	 */

	// JDK
	/*
	 * JDK is also loosely referred as JRE but its lot more than JRE and it
	 * provides all the tools and executable require to compile debug and
	 * execute Java Program. Just like JRE, JDK is also platform specific and
	 * you need to use separate installer for installing JDK on Linux and
	 * Windows. Current Version of JDK is 1.7 which is also referred as Java7
	 * and it contains javac (java compiler) based on programming rules of Java7
	 * and Java which can execute java7 code with new features like String in
	 * Switch, fork-join framework or Automatic Resource Management.
	 * 
	 * When you install JDK, installation folder is often referred as JAVA_HOME.
	 * All binaries are located inside JAVA_HOME/bin which includes javac, java
	 * and other binaries and they must be in your system PATH in order to
	 * compile and execute Java programs.
	 */

	// JVM, JRE, JDK
	/*
	 * Java Virtual Machine (JVM) is an abstract computing machine.
	 * 
	 * Java Runtime Environment (JRE) is an implementation of the JVM.
	 * 
	 * Java Development Kit (JDK) contains JRE along with various development
	 * tools like Java libraries, Java source compilers, Java debuggers,
	 * bundling and deployment tools.
	 * 
	 * JVM becomes an instance of JRE at runtime of a java program. It is widely
	 * known as a runtime interpreter. The Java virtual machine (JVM) is the
	 * cornerstone on top of which the Java technology is built upon. It is the
	 * component of the Java technology responsible for its hardware and
	 * platform independence. JVM largely helps in the abstraction of inner
	 * implementation from the programmers who make use of libraries for their
	 * programmes from JDK.
	 */

	// JIT
	/*
	 * JIT is the part of the Java Virtual Machine (JVM) that is used to speed
	 * up the execution time. JIT compiles parts of the byte code that have
	 * similar functionality at the same time, and hence reduces the amount of
	 * time needed for compilation. Here the term compiler refers to a
	 * translator from the instruction set of a Java virtual machine (JVM) to
	 * the instruction set of a specific CPU.
	 * 
	 * JIT are advanced part of Java Virtual machine which optimize byte code to
	 * machine instruction conversion part by compiling similar byte codes at
	 * same time and thus reducing overall execution time. JIT is part of Java
	 * Virtual Machine and also performs several other optimizations such as
	 * in-lining function.
	 */

	// JVM Memory Types
	/*
	 * Heap Memory - Class instances and arrays are stored in heap memory. Heap
	 * memory is also called as shared memory. As this is the place where
	 * multiple threads will share the same data.
	 * 
	 * Non-Heap Memory - It comprises of Method Area and other memory required
	 * for internal processing. It stores runtime constants, static fields, code
	 * for methods and constructors.
	 * 
	 * Memory Pool - Memory pools are created by JVM memory managers during
	 * runtime. Memory pool may belong to either heap or non-heap memory.
	 * 
	 * Runtime Constant Pool - A run time constant pool is a per-class or
	 * per-interface run time representation of the constant_pool table in a
	 * class file. Each runtime constant pool is allocated from the Java virtual
	 * machines method area.
	 * 
	 * Java Stacks and Frames - Java stacks are created private to a thread.
	 * Every thread will have a program counter (PC) and a java stack. PC will
	 * use the java stack to store the intermediate values, dynamic linking,
	 * return values for methods and dispatch exceptions. This is used in the
	 * place of registers.
	 */

}
