package edu.neu.khoury.cs5004.assignment8;

import edu.neu.khoury.cs5004.assignment8.commandlineprocessor.CommandLineProcessor;
import edu.neu.khoury.cs5004.assignment8.dataprocessor.CsvProcessor;
import edu.neu.khoury.cs5004.assignment8.exceptions.PlaceHolderNotAFieldException;
import edu.neu.khoury.cs5004.assignment8.templateprocessor.EmailTemplateProcessor;
import edu.neu.khoury.cs5004.assignment8.templateprocessor.LetterTemplateProcessor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Provides command line functionality for our template processing program.
 */
public class App {

  /**
   * the main method.
   *
   * @param args args
   */
  public static void main(String[] args) {
    CommandLineProcessor commandLineProcessor = new CommandLineProcessor();
    commandLineProcessor.processArgument(args);
    // Readers cause a DM_DEFAULT_ENCODING warning in our maven bug report
    // There are solutions, found at:
    // https://stackoverflow.com/questions/35132693/set-encoding-as-utf-8-for-a-filewriter
    // however, using the suggested stream readers causes issues with Maven, so the bug has not
    // been fixed.
    try (BufferedReader templateReader = new BufferedReader(
        new FileReader(commandLineProcessor.getTemplate()));
         BufferedReader csvReader = new BufferedReader(
             new FileReader(commandLineProcessor.getCsvfileName()))) {
      // Start try block
      CsvProcessor csvProcessor = new CsvProcessor(csvReader);
      if (commandLineProcessor.getOutputType().equals("--email")) {
        EmailTemplateProcessor emailTemplateProcessor = new EmailTemplateProcessor(templateReader);
        emailTemplateProcessor
            .writeMany(csvProcessor.processAll(), commandLineProcessor.getOutputDir());
      } else {
        LetterTemplateProcessor letterTemplateProcessor = new LetterTemplateProcessor(
            templateReader);
        letterTemplateProcessor
            .writeMany(csvProcessor.processAll(), commandLineProcessor.getOutputDir());
      }
      // End try block
    } catch (IOException e) {
      System.out.println("Error on file IO:");
      System.out.println(e.getMessage());
    } catch (PlaceHolderNotAFieldException e) {
      System.out.println("One of the template fields does not match the data given:");
      System.out.println(e.getMessage());
    }
  }
}
