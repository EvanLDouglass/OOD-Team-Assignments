package edu.neu.khoury.cs5004.assignment8.templateprocessor;

import edu.neu.khoury.cs5004.assignment8.dataprocessor.Record;
import edu.neu.khoury.cs5004.assignment8.exceptions.PlaceHolderNotAFieldException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Provides some common functionality for classes that process text based templates. Placeholders
 * for the templates should resemble "[[field_name]]".
 *
 * @author evandouglass
 */
public abstract class AbstractTextTemplateProcessor implements TemplateProcessor {

  private static final String PTRN = "\\[\\[(.*?)\\]\\]";

  private String template;
  private Pattern pattern;

  /**
   * Constructor for the processor. Takes a {@code BufferedReader} pointing to the template the
   * client wants to use.
   *
   * @param templateReader a BufferedReader used to read in the desired template
   * @throws IOException if there is a problem reading the template file
   */
  public AbstractTextTemplateProcessor(BufferedReader templateReader) throws IOException {
    this.template = readTemplate(templateReader);
    pattern = Pattern.compile(PTRN);
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
      // Read through template, saving each line in the builder
      builder.append(line);
      builder.append("\n");
      line = templateReader.readLine();
    }
    // Remove final newline character, as it was not in the original template
    builder.deleteCharAt(builder.lastIndexOf("\n"));
    return builder.toString();
  }

  /* ===== Methods ===== */

  /**
   * Writes a processed template to the output location specified in the given {@code
   * BufferedWriter}.
   *
   * @param data the data with which to replace the template placeholders
   * @param outFile a String denoting a file to write to
   * @throws PlaceHolderNotAFieldException if the processor's template contains placeholder names
   *     that are not fields in the given Record
   * @throws IOException if there is a problem writing
   */
  @Override
  public void writeTemplate(Record data, String outFile)
      throws PlaceHolderNotAFieldException, IOException {
    BufferedWriter writer = new BufferedWriter(new FileWriter(outFile));
    writer.write(findAndReplace(data));
  }

  /**
   * Given a single template, finds and replaces all placeholders in the template with their related
   * values from the given record. This method does the most significant work in this class.
   *
   * @param record the record to pull data from
   * @return the resulting string
   * @throws PlaceHolderNotAFieldException if one of the placeholders in the template is not a field
   *     in the record
   */
  private String findAndReplace(Record record)
      throws PlaceHolderNotAFieldException {
    String temp = template;
    Matcher matcher = pattern.matcher(temp);
    while (matcher.find()) {
      // Get replacement value, ignoring whitespace between brackets
      String replacement = record.getValue(matcher.group(1).trim());
      // End processing if the found placeholder is not a field in the record
      // Note that empty fields will be an empty string, only nonexistent fields will return null
      if (replacement == null) {
        throw new PlaceHolderNotAFieldException();
      }
      // Make new regex pattern to find the specific matched group
      String replacementRegex = "\\[\\[" + matcher.group(1) + "\\]\\]";
      // Replace all occurrences of the placeholder in this template with the replacement data
      temp = temp.replaceAll(replacementRegex, replacement);
    }
    return temp;
  }
}
