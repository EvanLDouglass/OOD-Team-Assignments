package edu.neu.khoury.cs5004.assignment8.templateprocessor;

import static org.junit.Assert.assertEquals;

import edu.neu.khoury.cs5004.assignment8.dataprocessor.Record;
import edu.neu.khoury.cs5004.assignment8.exceptions.PlaceHolderNotAFieldException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class LetterTemplateProcessorTest {

  private final String template = "([[email]])\n"
      + "\n"
      + "Dear [[first_name]] [[last_name]],\n"
      + "As you may have heard or read, last month we learned that criminals forced their way into our systems,";
  private LetterTemplateProcessor processor;

  @Before
  public void setUp() throws Exception {
    processor = new LetterTemplateProcessor(new BufferedReader(new StringReader(template)));
  }

  @Test
  public void writeMany() throws IOException, PlaceHolderNotAFieldException {
    // Make record list
    String[] fields = new String[]{"first_name", "last_name", "email"};
    String[] values1 = new String[]{"Evan", "Douglass", "evandoug90@gmail.com"};
    String[] values2 = new String[]{"Joe", "Blow", "testing@1234.com"};
    Record record1 = new Record(fields, values1);
    Record record2 = new Record(fields, values2);
    List<Record> list = new ArrayList<>();
    list.add(record1);
    list.add(record2);

    // Run function
    processor.writeMany(list, "./testoutput");

    // Get contents and test first file
    String contents = readTemplate(new BufferedReader(new FileReader("./testoutput/letter1.txt")));
    String expected = "(evandoug90@gmail.com)\n"
        + "\n"
        + "Dear Evan Douglass,\n"
        + "As you may have heard or read, last month we learned that criminals forced their way into our systems,";
    assertEquals(expected, contents);

    // Get contents and test second file
    contents = readTemplate(new BufferedReader(new FileReader("./testoutput/letter2.txt")));
    expected = "(testing@1234.com)\n"
        + "\n"
        + "Dear Joe Blow,\n"
        + "As you may have heard or read, last month we learned that criminals forced their way into our systems,";
    assertEquals(expected, contents);
  }

  // Error with maven due to previous use of Files.readAllLines, so had to copy paste the following
  // method in order to get a string representation of file contents
  private String readTemplate(BufferedReader templateReader) throws IOException {
    StringBuilder builder = new StringBuilder();
    String line = templateReader.readLine();
    while (line != null) {
      // Read through template, saving each line in the builder
      builder.append(line);
      builder.append("\n");
      line = templateReader.readLine();
    }
    // Remove final newline character, as it was not in the original template
    builder.deleteCharAt(builder.lastIndexOf("\n"));
    return builder.toString();
  }
}