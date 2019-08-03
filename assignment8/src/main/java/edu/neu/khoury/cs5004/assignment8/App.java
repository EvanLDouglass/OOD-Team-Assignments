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
 * Hello world!
 */
public class App {

  public static void main(String[] args) throws IOException, PlaceHolderNotAFieldException {
    CommandLineProcessor commandLineProcessor = new CommandLineProcessor();
    commandLineProcessor.processArgument(args);
    BufferedReader templateReader = new BufferedReader(new FileReader(commandLineProcessor.getTemplate()));
    BufferedReader csvReader = new BufferedReader(new FileReader(commandLineProcessor.getCsvfileName()));
    CsvProcessor csvProcessor = new CsvProcessor(csvReader);

    if (commandLineProcessor.getTemplate() == "--email") {
      EmailTemplateProcessor emailTemplateProcessor = new EmailTemplateProcessor(templateReader);
      emailTemplateProcessor.writeMany(csvProcessor.processAll(), commandLineProcessor.getOutputDir());
    } else {
      LetterTemplateProcessor letterTemplateProcessor = new LetterTemplateProcessor(templateReader);
      letterTemplateProcessor.writeMany(csvProcessor.processAll(), commandLineProcessor.getOutputDir());
    }
  }
}
