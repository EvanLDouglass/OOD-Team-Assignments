package edu.neu.khoury.cs5004.assignment8;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Takes lines of data from a csv file and turns them into easily manipulated {@code Record}
 * objects. Allows client's to process one record at a time, or all at once.
 *
 * @author evandouglass
 */
public class CsvProcessor extends AbstractTableDataProcessor {

  /* ===== Constructors ===== */

  /**
   * Creates a {@code CsvProcessor} given a {@code BufferedReader}. The reader should be unused and
   * the file it points to should have a header row with field names.
   *
   * @param reader a BufferedReader pointing to the file that needs to be processed
   * @throws IOException if there is a problem getting field names from the data file
   */
  public CsvProcessor(BufferedReader reader) throws IOException {
    super(reader);
    // Get the fields from the first line of the file
    this.fields = extractLine();
  }

  /* ===== Methods ===== */

  /**
   * Takes a record from a csv file and converts it into a {@code Record} object.
   *
   * @return a csv entry as a Record object
   * @throws IOException if there is a problem reading from the csv
   */
  @Override
  public Record processNextRecord() throws IOException {
    String[] vals = extractLine();
    // End of file check
    if (vals == null) {
      return null;
    }
    return new Record(fields, vals);
  }

  /**
   * Processes all of the records in a csv file. If some records have been processed already, will
   * process only those remaining.
   *
   * @return A list of every record in the file, or those remaining
   * @throws IOException if there is a problem reading from the csv
   */
  @Override
  public List<Record> processAll() throws IOException {
    List<Record> records = new ArrayList<>();
    // Keep adding records until there are none left
    Record record = processNextRecord();
    while (record != null) {
      records.add(record);
      record = processNextRecord();
    }
    return records;
  }

  /**
   * Gets the fields from a csv file and stores them, in-order, in an array.
   *
   * @return an array containing the names of each field, in the same order as the table
   * @throws IOException if there is a problem reading from the data file
   */
  private String[] extractLine() throws IOException {
    String line = reader.readLine();
    // Provides same behavior for readLine at the end of a file
    if (line == null) {
      return null;
    }
    // regex for a comma surrounded by quotes, potentially with whitespace between the quotes
    // and comma
    final String splitToken = "\"\\s*,\\s*\"";
    line = removeQuotes(line);
    return line.split(splitToken);
  }

  /**
   * Removes the leading quote of the first item in a csv line, and the trailing quote of the last
   * item in the line. Prepares the string for splitting into a String[].
   *
   * @param str the string from which to remove quotes
   * @return an equivalent string with leading and trailing quotes removed
   */
  private String removeQuotes(String str) {
    return removeLeadingQuote(removeTrailingQuote(str));
  }

  /**
   * Removes the leading quote of the first item in a line taken directly from a csv file.
   *
   * @param str the string from which to remove quotes
   * @return an equivalent string with leading and trailing quotes removed
   */
  private String removeLeadingQuote(String str) {
    String leadQuote = "^\"";
    return str.replaceFirst(leadQuote, "");
  }

  /**
   * Removes the trailing quote of the last item in a line taken directly from a csv file.
   *
   * @param str the string from which to remove quotes
   * @return an equivalent string with leading and trailing quotes removed
   */
  private String removeTrailingQuote(String str) {
    String endQuote = "\"$";
    return str.replaceFirst(endQuote, "");
  }
}
