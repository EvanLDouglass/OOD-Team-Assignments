package edu.neu.khoury.cs5004.assignment8;

import java.io.IOException;
import java.util.List;

/**
 * Describes required functionality for classes that process table based, textual data. Takes lines
 * of data and turns them into easily manipulated Java classes. Assumes an internal {@code
 * BufferedReader}.
 *
 * @author evandouglass
 */
public interface TableDataProcessor {

  /**
   * Takes a record from a table and converts it into a {@code Record} object.
   *
   * @return the given record as a Record object
   * @throws IOException if there is a problem reading from the csv
   */
  Record processNextRecord() throws IOException;

  /**
   * Processes all of the records in a data file. If some records have been processed already, will
   * process only those remaining.
   *
   * @return A list of every record in the file, or those remaining
   * @throws IOException if there is a problem reading from the csv
   */
  List<Record> processAll() throws IOException;
}
