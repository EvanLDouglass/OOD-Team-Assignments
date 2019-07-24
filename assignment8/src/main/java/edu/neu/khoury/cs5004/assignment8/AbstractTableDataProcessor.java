package edu.neu.khoury.cs5004.assignment8;

import java.io.BufferedReader;

/**
 * A template for building {@code TableDataProcessor}s.
 *
 * @author evandouglass
 */
public abstract class AbstractTableDataProcessor implements TableDataProcessor {

  protected BufferedReader reader;
  protected String[] fields;

  /* ===== Constructors ===== */

  /**
   * Creates an {@code AbstractTableDataProcessor} given a {@code BufferedReader}. The reader should
   * be unused and the file it points to should have a header row with field names.
   *
   * @param reader a BufferedReader pointing to the file that needs to be processed
   */
  public AbstractTableDataProcessor(BufferedReader reader) {
    this.reader = reader;
  }

  /* ===== Methods ===== */
}