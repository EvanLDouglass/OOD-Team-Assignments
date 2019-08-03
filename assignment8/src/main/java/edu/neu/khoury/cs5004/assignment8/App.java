package edu.neu.khoury.cs5004.assignment8;

import edu.neu.khoury.cs5004.assignment8.CommandLineProcessor.CommandLineProcessor;
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

  public static void main(String[] args) {
    CommandLineProcessor commandLineProcessor = new CommandLineProcessor();
    commandLineProcessor.processArgument(args);
    // Init buffered readers for try/catch
    try (BufferedReader templateReader = new BufferedReader(new FileReader(commandLineProcessor.getTemplate()));
         BufferedReader csvReader = new BufferedReader(new FileReader(commandLineProcessor.getCsvfileName()))) {
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
