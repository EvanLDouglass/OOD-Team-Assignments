package edu.neu.khoury.cs5004.assignment8.templateprocessor;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Provides some common functionality for classes that process text based templates.
 *
 * @author evandouglass
 */
public abstract class AbstractTextTemplateProcessor implements TemplateProcessor {

  private String template;

  /**
   * Constructor for the processor. Takes a {@code BufferedReader} pointing to the template the
   * client wants to use.
   *
   * @param templateReader a BufferedReader used to read in the desired template
   * @throws IOException if there is a problem reading the template file
   */
  public AbstractTextTemplateProcessor(BufferedReader templateReader) throws IOException {
    this.template = readTemplate(templateReader);
  }

  /**
   * Reads a template file into a single string. This reduces the overhead of repeatedly opening and
   * closing a file to process multiple templates. Also reduces the risk of read errors since it
   * allows for only a single reading of the template file.
   *
   * @param templateReader a BufferedReader used to read in the desired template
   * @return a string containing the text in the template file
   * @throws IOException if there is a problem reading the file
   */
  private String readTemplate(BufferedReader templateReader) throws IOException {
    StringBuilder builder = new StringBuilder();
    String line = templateReader.readLine();
    while (line != null) {
      builder.append(line);
      builder.append("\n");
      line = templateReader.readLine();
    }
    return builder.toString();
  }
}
