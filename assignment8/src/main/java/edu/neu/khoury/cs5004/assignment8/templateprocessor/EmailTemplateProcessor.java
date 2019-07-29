package edu.neu.khoury.cs5004.assignment8.templateprocessor;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Processes email templates from txt files.
 *
 * @author evandouglass
 */
public class EmailTemplateProcessor extends AbstractTextTemplateProcessor {

  /**
   * Constructor for the processor. Takes a {@code BufferedReader} pointing to the template the
   * client wants to use.
   *
   * @param templateReader a BufferedReader used to read in the desired template
   * @throws IOException if there is a problem reading the template file
   */
  public EmailTemplateProcessor(BufferedReader templateReader) throws IOException {
    super(templateReader);
    typeOfTemplate = "email";
  }
}
