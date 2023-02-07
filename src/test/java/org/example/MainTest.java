package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class MainTest {
    // R10
  @Test
  public void testMain() {
    // Inputs to be sent to main
    String input = "I 3\nQ\n";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    ByteArrayOutputStream out = new ByteArrayOutputStream();
    System.setOut(new PrintStream(out));

    // Running main
    Main.main(new String[] {});

    // Comparing the expected outputs of CLI with the actual (with removal of \n and whitespace)
    assertEquals("Please Enter Command to initialize floor:\nPlease Enter Command:".replaceAll("\\s", ""),out.toString().replaceAll("\\s", ""));

  }
}
