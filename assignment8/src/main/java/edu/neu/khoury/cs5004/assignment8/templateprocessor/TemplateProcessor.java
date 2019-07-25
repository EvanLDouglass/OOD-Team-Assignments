package edu.neu.khoury.cs5004.assignment8.templateprocessor;

import edu.neu.khoury.cs5004.assignment8.dataprocessor.Record;
import edu.neu.khoury.cs5004.assignment8.exceptions.PlaceHolderNotAFieldException;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;

/**
 * Describes the behavior of a template processor. Template processors should be able to take a
 * template and replace all the placeholder fields with data from a {@code Record} object,
 * containing information about a single record from a file of tabular data.
 *
 * @author evandouglass
 */
public interface TemplateProcessor {

  /**
   * Writes a processed template to the output location specified in the given {@code
   * BufferedWriter}.
   *
   * @param data the data with which to replace the template placeholders
   * @param writer a BufferedWriter pointing to a write location
   * @throws PlaceHolderNotAFieldException if the processor's template contains placeholder names
   * that are not fields in the given Record
   * @throws IOException if there is a problem writing
   */
  void writeTemplate(Record data, BufferedWriter writer)
      throws PlaceHolderNotAFieldException, IOException;

  /**
   * Writes a processed template for each {@code Record} in the given list to the given output
   * directory. Files are produced with the naming convention <type-of-template>N, where N is an
   * integer indicating which record's data has been inserted into the template. N = 1 is the first
   * {@code Record} and N is the last.
   *
   * @param records a list of records used for data in the templates
   * @param outputDir a directory in which to write the finished templates
   * @throws PlaceHolderNotAFieldException if any record does not contain fields matching any
   * placeholder in the template
   * @throws IOException if there is a problem when writing
   */
  void writeMany(List<Record> records, String outputDir)
      throws PlaceHolderNotAFieldException, IOException;

  /**
   * Determines whether the arguments given at the command line are valid for this processor.
   *
   * @param args the command line arguments
   * @return true if the arguments are valid, else false
   */
  Boolean hasValidArgs(String[] args);

  // As of now the next method is not needed, but would be helpful for future additions.
  /**
   * Sets any command line arguments passed to modify the behavior of this processor when running.
   *
   * @param args the command line arguments passed
   */
  void setFlags(String[] args);
}
