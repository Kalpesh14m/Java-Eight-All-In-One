package com.codedictator.javanashorn;

import java.io.File;
import java.io.FileReader;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class JavaNashornDemo {
	public static void main(String[] args) throws Exception {
		// Creating script engine
		ScriptEngine ee = new ScriptEngineManager().getEngineByName("Nashorn");
		// Reading Nashorn file
		ee.eval(new FileReader(new File("//Java Eight//src//com//codedictator//javanashorn//hello.js")));
	}
}
/*
 * Nashorn is a JavaScript engine. It is used to execute JavaScript code
 * dynamically at JVM (Java Virtual Machine). Java provides a command-line tool
 * jjs which is used to execute JavaScript code.
 * 
 * You can execute JavaScript code by using jjs command-line tool and by
 * embedding into Java source code.
 * 
 * Executing by Using Terminal
 * 
 * Following is the step by step process to execute JavaScript code at the JVM.
 * 
 * 1) Create a file hello.js.
 * 
 * 2) Write and save the following code into the file.
 * 
 * var hello = function(){ print("Hello Nashorn"); }; hello();
 * 
 * 3) Open terminal
 * 
 * 4) Write command jjs hello.js and press enter.
 * 
 * After executing command, you will see the below output.
 */