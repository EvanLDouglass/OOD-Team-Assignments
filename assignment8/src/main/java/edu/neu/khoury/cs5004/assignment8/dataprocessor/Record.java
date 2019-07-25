package edu.neu.khoury.cs5004.assignment8.dataprocessor;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * Represents a single record from a table. Contains simple functionality to get data out of the
 * {@code Record}. {@code Record} values are kept as strings since much table data contains a mix of
 * data types. {@code Record}s are also immutable.
 *
 * @author evandouglass
 */
public class Record {

  private Map<String, String> record;

  /* ===== Constructors ===== */

  /**
   * Constructor allowing choice of map type.
   *
   * @param record a map containing field names to values for the record
   */
  public Record(Map<String, String> record) {
    this.record = record;
  }

  /**
   * This constructor makes a new HashMap to store the field to value pairs. The given arrays are
   * expected to be the same length, and values are expected to have the same index as the field
   * they belong to. Further, if duplicate fields exist, they will be overwritten by the last one
   * processed.
   *
   * @param fields an array of field names
   * @param values an array of values for each field name
   * @throws IllegalArgumentException if the given arrays are different lengths
   */
  public Record(String[] fields, String[] values) {
    if (!isSameLength(fields, values)) {
      throw new IllegalArgumentException("Given arrays must be the same length");
    }
    record = new HashMap<>();
    populateRecord(fields, values);
  }

  /**
   * Tests if two arrays have the same length.
   *
   * @param arr1 the first array
   * @param arr2 the second array
   * @return true if they are the same length, else false
   */
  private Boolean isSameLength(String[] arr1, String[] arr2) {
    return arr1.length == arr2.length;
  }

  /**
   * Populates the record map given two arrays. The arrays are assumed to be the same length.
   * Indexes are paired together (i.e. keys[0] -> values[0]).
   *
   * @param keys the keys for the map
   * @param values the values to pair with each key
   */
  private void populateRecord(String[] keys, String[] values) {
    for (int i = 0; i < keys.length; i++) {
      record.put(keys[i], values[i]);
    }
  }

  /* ===== Methods ===== */

  /**
   * Returns the value paired with the given field in this record.
   *
   * @param field the field from which to retrieve a value
   * @return the value paired with the given field, as a string
   */
  public String getValue(String field) {
    return record.get(field);
  }

  /**
   * Returns a set of the fields in this record.
   *
   * @return a set of the fields in this record.
   */
  public Set<String> getFields() {
    return record.keySet();
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Record record1 = (Record) obj;
    return record.equals(record1.record);
  }

  @Override
  public int hashCode() {
    return Objects.hash(record);
  }

  @Override
  public String toString() {
    return "Record" + record.toString();
  }
}
