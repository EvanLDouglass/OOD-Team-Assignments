package edu.neu.khoury.cs5004.assignment8;

import org.junit.Before;
import org.junit.Test;

public class AppTest {

  private String[] emailArgs;
  private String[] letterArgs;
  private String[] badCsvFileArgs;  // IO error from non-existent csv
  private String[] badTemplateFileArgs;
  private String[] badFieldArgs; // template has fields not in the given csv

  @Before
  public void setUp() throws Exception {
    emailArgs = new String[]{"--email", "--email-template", "templates/emailtemplate.txt", "--output-dir", "testoutput", "--csv-file", "data/data_small.csv"};
    letterArgs = new String[]{"--output-dir", "testoutput", "--letter-template", "templates/lettertemplate.txt", "--letter", "--csv-file", "data/data_small.csv"};
    badCsvFileArgs = new String[]{"--csv-file", "data/does_not_exist.csv", "--letter-template", "templates/lettertemplate.txt", "--letter", "--output-dir", "testoutput"};
    badTemplateFileArgs = new String[]{"--letter-template", "templates/not_a_template.txt", "--csv-file", "data/data_small.csv", "--letter", "--output-dir", "testoutput"};
    badFieldArgs = new String[]{"--csv-file", "data/bad_field_test.csv", "--letter-template", "templates/lettertemplate.txt", "--letter", "--output-dir", "testoutput"};
  }

  @Test
  public void initApp() {
    // Only here to increase test coverage
    App app = new App();
    // No errors = success
  }

  @Test
  public void mainForEmail() {
    // should modify or create 3 email files
    App.main(emailArgs);
  }

  @Test
  public void mainForLetter() {
    // should modify or create 3 letter files
    App.main(letterArgs);
  }

  @Test
  public void mainBadFileIO() {
    // Should print an error pointing to file IO as cause and print the error message
    App.main(badCsvFileArgs);
  }

  @Test
  public void mainBadFileIO2() {
    // Should print an error pointing to file IO as cause and print the error message
    App.main(badTemplateFileArgs);
  }

  @Test
  public void mainBadCsvFields() {
    // Should print an error pointing to a template/csv field mismatch and print the error message
    App.main(badFieldArgs);
  }
}