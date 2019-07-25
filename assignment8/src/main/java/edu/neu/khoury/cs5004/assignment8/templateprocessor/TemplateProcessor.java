package edu.neu.khoury.cs5004.assignment8.templateprocessor;

import edu.neu.khoury.cs5004.assignment8.dataprocessor.Record;
import edu.neu.khoury.cs5004.assignment8.exceptions.PlaceHolderNotAFieldException;
import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Describes the behavior of a template processor. Template processors should be able to take a
 * template and replace all the placeholder fields with data from a {@code Record} object,
 * containing information about a single record from a file of tabular data.
 *
 * @author evandouglass
 */
public interface TemplateProcessor {

  /**
   * Writes a processed template (real data inserted into the placeholders) to the output location
   * specified in the given {@code BufferedWriter}.
   *
   * @param data the data with which to replace the template placeholders
   * @param writer a BufferedWriter pointing to a write location
   * @throws PlaceHolderNotAFieldException if the processor's template contains placeholder names
   *     that are not fields in the given Record
   * @throws IOException if there is a problem writing
   */
  void writeTemplate(Record data, BufferedWriter writer)
      throws PlaceHolderNotAFieldException, IOException;


}
