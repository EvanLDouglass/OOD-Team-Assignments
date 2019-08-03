package edu.neu.khoury.cs5004.assignment8.templateprocessor;

import edu.neu.khoury.cs5004.assignment8.dataprocessor.Record;
import edu.neu.khoury.cs5004.assignment8.exceptions.PlaceHolderNotAFieldException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
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
  /**
   * The Type of template.
   */
  protected String typeOfTemplate;
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
   * Writes a processed template for each {@code Record} in the given list to the given output
   * directory. Files are produced with the naming convention [type-of-template]N.txt, where N is an
   * integer indicating which record's data has been inserted into the template. N = 1 is the first
   * {@code Record} and N is the last.
   *
   * @param records a list of records used for data in the templates
   * @param outputDir a directory in which to write the finished templates
   * @throws PlaceHolderNotAFieldException if any record does not contain fields matching any
   *     placeholder in the template
   * @throws IOException if there is a problem when writing
   */
  @Override
  public void writeMany(List<Record> records, String outputDir)
      throws PlaceHolderNotAFieldException, IOException {
    // Make a new directory if needed
    if (new File(outputDir).mkdirs()) {  // need if to avoid bug report warning
      System.out.println("created new directory " + outputDir);
    }
    // Make a new file for each record in the given directory
    for (int i = 0; i < records.size(); i++) {
      String path = outputDir + "/" + typeOfTemplate + (i + 1) + ".txt";  // ex: "output/email1.txt"
      File file = new File(path);
      if (file.createNewFile()) {  // actually creates the new file
        System.out.println("created new file " + file.toString());
      } else {
        System.out.println("modified file " + file.toString());
      }
      // Write to the new file
      // This causes a DM_DEFAULT_ENCODING warning in our maven bug report
      // However, the solution, found at:
      // https://stackoverflow.com/questions/35132693/set-encoding-as-utf-8-for-a-filewriter
      // causes a test to fail when building with Maven, though not when testing directly in
      // IntelliJ. I decided it is better to have a non-empty bug report than a failed build.
      BufferedWriter writer = new BufferedWriter(new FileWriter(file));
      writeTemplate(records.get(i), writer);
    }
  }

  /**
   * Writes a processed template to the output location specified in the given {@code
   * BufferedWriter}. Closes the writer after writing.
   *
   * @param data the data with which to replace the template placeholders
   * @param writer a String denoting a file to write to
   * @throws PlaceHolderNotAFieldException if the processor's template contains placeholder names
   *     that are not fields in the given Record
   * @throws IOException if there is a problem writing
   */
  @Override
  public void writeTemplate(Record data, BufferedWriter writer)
      throws PlaceHolderNotAFieldException, IOException {
    writer.write(findAndReplace(data));
    writer.close();
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
