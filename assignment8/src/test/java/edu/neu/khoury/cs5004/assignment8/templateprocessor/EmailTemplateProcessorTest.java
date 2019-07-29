package edu.neu.khoury.cs5004.assignment8.templateprocessor;

import static org.junit.Assert.assertEquals;

import edu.neu.khoury.cs5004.assignment8.dataprocessor.Record;
import edu.neu.khoury.cs5004.assignment8.exceptions.PlaceHolderNotAFieldException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class EmailTemplateProcessorTest {

  private final String template = "From:insuranceCompany@ic.com\n"
      + "To:[[email]]\n"
      + "Subject: Insurance company – information about recent data breach\n"
      + "Dear [[ first_name ]] [[   last_name]],";  // Note the spaces on this line
  private EmailTemplateProcessor processor;

  @Before
  public void setUp() throws Exception {
    processor = new EmailTemplateProcessor(new BufferedReader(new StringReader(template)));
  }

  @Test
  public void writeTemplate() throws IOException, PlaceHolderNotAFieldException {
    String[] fields = new String[]{"first_name", "last_name", "email"};
    String[] values = new String[]{"Evan", "Douglass", "evandoug90@gmail.com"};
    Record record = new Record(fields, values);
    String expected = "From:insuranceCompany@ic.com\n"
        + "To:evandoug90@gmail.com\n"
        + "Subject: Insurance company – information about recent data breach\n"
        + "Dear Evan Douglass,";
    StringWriter strWriter = new StringWriter();
    processor.writeTemplate(record, new BufferedWriter(strWriter));
    String actual = strWriter.toString();
    assertEquals(expected, actual);
  }

  @Test(expected = PlaceHolderNotAFieldException.class)
  public void writeTemplate_UnknownPlaceholder() throws IOException, PlaceHolderNotAFieldException {
    String[] fields = new String[]{"last_name", "email"};
    String[] values = new String[]{"Douglass", "evandoug90@gmail.com"};
    Record record = new Record(fields, values);
    StringWriter strWriter = new StringWriter();
    processor.writeTemplate(record, new BufferedWriter(strWriter));
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
    String contents = readTemplate(new BufferedReader(new FileReader("./testoutput/email1.txt")));
    String expected = "From:insuranceCompany@ic.com\n"
        + "To:evandoug90@gmail.com\n"
        + "Subject: Insurance company – information about recent data breach\n"
        + "Dear Evan Douglass,";
    assertEquals(expected, contents);

    // Get contents and test second file
    contents = readTemplate(new BufferedReader(new FileReader("./testoutput/email2.txt")));
    expected = "From:insuranceCompany@ic.com\n"
        + "To:testing@1234.com\n"
        + "Subject: Insurance company – information about recent data breach\n"
        + "Dear Joe Blow,";
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