package edu.neu.khoury.cs5004.assignment8.commandlineprocessor;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class CommandLineProcessorTest {
  private CommandLineProcessor commandLineProcessor;
  private String[] giventemplate;

  @Before
  public void setUp() throws Exception {
    giventemplate = new String[]{"--email",
        "--email-template",
        "template/emailtemplate.txt",
        "--output-dir", "testoutput",
        "--csv-file", "data/data_small.csv"};
    commandLineProcessor = new CommandLineProcessor();
    commandLineProcessor.processArgument(giventemplate);
  }

  @Test
  public void processArgument() {
    assertEquals("--email", commandLineProcessor.getOutputType());
    assertEquals("testoutput", commandLineProcessor.getOutputDir());
    assertEquals("data/data_small.csv", commandLineProcessor.getCsvfileName());
    assertEquals("template/emailtemplate.txt", commandLineProcessor.getTemplate());
    String[] emptytemplate = new String[]{};
    try {
      commandLineProcessor.processArgument(emptytemplate);
    }catch (InvalidArgumentException e) {
    }
  }

  @Test
  public void checkType() {
    List<String> giventemplate = new ArrayList<>();
    try {
      this.commandLineProcessor.checkType(giventemplate);
    } catch (InvalidArgumentException e) {
    }
    giventemplate.add("--email");
    this.commandLineProcessor.checkType(giventemplate);
    assertEquals("--email", this.commandLineProcessor.getOutputType());
    try {
      giventemplate.add("--letter");
      this.commandLineProcessor.checkType(giventemplate);
    } catch (InvalidArgumentException e) {
    }
    giventemplate.remove("--email");
    this.commandLineProcessor.checkType(giventemplate);
    assertEquals("--letter", this.commandLineProcessor.getOutputType());
  }

  @Test
  public void checkTemplate() {
    List<String> giventemplate = new ArrayList<>();
    try {
      this.commandLineProcessor.checkTemplate(giventemplate);
    } catch (InvalidArgumentException e) {
    }
  }

  @Test
  public void checkCsvfile() {
    String[] emptytemplate = new String[]{};
    try {
      commandLineProcessor.processArgument(emptytemplate);
    }catch (InvalidArgumentException e) {
    }
    try {
      this.commandLineProcessor.checkCsvfile();
    } catch (InvalidArgumentException e) {
    }
  }

  @Test
  public void checkOutputDir() {
    String[] emptytemplate = new String[]{};
    try {
      commandLineProcessor.processArgument(emptytemplate);
    }catch (InvalidArgumentException e) {
    }
    try {
      this.commandLineProcessor.checkOutputDir();
    } catch (InvalidArgumentException e) {
    }

  }

  @Test
  public void equals1() {
    assertTrue(commandLineProcessor.equals(commandLineProcessor));
    CommandLineProcessor emptyCmdProcessor = new CommandLineProcessor();
    assertFalse(commandLineProcessor.equals(emptyCmdProcessor));
    assertFalse(commandLineProcessor.equals(null));
    String[] template = new String[]{"--email",
        "--email-template",
        "template/emailtemplate.txt",
        "--output-dir", "testoutput",
        "--csv-file", "data/data_small.csv"};
    CommandLineProcessor cmdProcessor = new CommandLineProcessor();
    cmdProcessor.processArgument(template);
    assertTrue(commandLineProcessor.equals(cmdProcessor));
  }


  @Test
  public void hashCode1() {
    assertEquals(-445722118, commandLineProcessor.hashCode());
  }

  @Test
  public void toString1() {
    assertEquals("commandlineprocessor{outputType='--email',"
            + " outputDir='testoutput', csvfileName='data/data_small.csv',"
            + " template='template/emailtemplate.txt',"
            + " argpair={--email-template=template/emailtemplate.txt,"
            + " --csv-file=data/data_small.csv, --output-dir=testoutput}}",
        commandLineProcessor.toString());
  }

}