package com.kvvssut.interviews.java.java8.misc;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class NashornDemo {

    public static void main(String[] args) throws IOException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("nashorn");

        String script = "var welcome = 'Hello';" + "welcome += ' World!';" + "welcome;";

        try {
            String result = (String) engine.eval(script);
            System.out.println("Evaluated result is : " + result);
        } catch (ScriptException e) {
            e.printStackTrace();
        }


        // change here


        Reader reader = null;
        try {
            File file = new File("C:\\Workspace_Srimanta\\Workspace_Eclipse\\java8examples\\src\\main\\java\\com\\zapcg\\tutorial\\java8\\misc\\readurl.js");
            reader = new FileReader(file);

            try {
                String result = (String) engine.eval(reader);
                System.out.println("\nEvaluated result for javascript from file is : \n" + result);
            } catch (ScriptException e) {
                e.printStackTrace();
            }

        } finally {
            if (reader != null) {
                reader.close();
            }
        }

    }

}