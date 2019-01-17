package org.gnuhpc.bigdata.designpattern.interpreter.jdkexample;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InterpreterJDKDemo{

	public static void main(String[] args) {
		String input = "Lions, and tigers, and bears! Oh, my!";

		Pattern p = Pattern.compile("(lion|cat|dog|wolf|bear|human|tiger|liger|Lion)");
		Matcher m = p.matcher(input);

		while (m.find()) {
			System.out.println("Found a " + m.group() + ".");
		}
	}
}
