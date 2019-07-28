package edu.neu.khoury.cs5004.assignment8.templateprocessor;

import static org.junit.Assert.*;

import edu.neu.khoury.cs5004.assignment8.dataprocessor.Record;
import edu.neu.khoury.cs5004.assignment8.exceptions.PlaceHolderNotAFieldException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import org.junit.Before;
import org.junit.Test;

public class AbstractTextTemplateProcessorTest {

  private ConcreteTextTemplateProcessor processor;
  private String template;

  @Before
  public void setUp() throws Exception {
    template = "first: [[first_name]],\n"
        + "last: [[last_name]],\n"
        + "first: [[first_name]],\n"
        + "email: [[ email ]]\n"
        + "empty: [[ empty]]";
    processor = new ConcreteTextTemplateProcessor(new BufferedReader(new StringReader(template)));
  }

  @Test
  public void writeTemplate() {
  }

  @Test
  public void writeMany() {
  }

  @Test
  public void findAndReplaceLine() throws PlaceHolderNotAFieldException {
    String[] fields = new String[]{"first_name", "last_name", "email", "empty"};
    String[] values = new String[]{"Evan", "Douglass", "evandoug90@gmail.com", ""};
    Record record = new Record(fields, values);

    String expected = "first: Evan,\nlast: Douglass,\nfirst: Evan,\nemail: evandoug90@gmail.com\nempty: ";
    String actual = processor.findAndReplace(record);
    assertEquals(expected, actual);
  }

  private class ConcreteTextTemplateProcessor extends AbstractTextTemplateProcessor {

    public ConcreteTextTemplateProcessor(BufferedReader templateReader) throws IOException {
      super(templateReader);
    }

    @Override
    public Boolean hasValidArgs(String[] args) {
      return null;
    }

    @Override
    public void setFlags(String[] args) {}
  }
}