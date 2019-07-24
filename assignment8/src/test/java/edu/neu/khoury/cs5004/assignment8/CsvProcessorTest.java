package edu.neu.khoury.cs5004.assignment8;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class CsvProcessorTest {

  private CsvProcessor csvProc;

  @Before
  public void setUp() throws Exception {
    String smallData =
          "\"first_name\",\"last_name\",\"company_name\",\"address\",\"city\",\"county\",\"state\",\"zip\",\"phone1\",\"phone2\",\"email\",\"web\"\n"
        + "\"James\",\"Butt\",\"Benton, John B Jr\",\"6649 N Blue Gum St\",\"New Orleans\",\"Orleans\",\"LA\",\"70116\",\"504-621-8927\",\"504-845-1427\",\"jbutt@gmail.com\",\"http://www.bentonjohnbjr.com\"\n"
        + "\"Josephine\",\"Darakjy\",\"Chanay, Jeffrey A Esq\",\"4 B Blue Ridge Blvd\",\"Brighton\",\"Livingston\",\"MI\",\"48116\",\"810-292-9388\",\"810-374-9840\",\"josephine_darakjy@darakjy.org\",\"http://www.chanayjeffreyaesq.com\"\n"
        + "\"Art\",\"Venere\",\"Chemel, James L Cpa\",\"8 W Cerritos Ave #54\",\"Bridgeport\",\"Gloucester\",\"NJ\",\"8014\",\"856-636-8749\",\"856-264-4130\",\"art@venere.org\",\"http://www.chemeljameslcpa.com\"";
    BufferedReader reader = new BufferedReader(new StringReader(smallData));
    csvProc = new CsvProcessor(reader);
  }

  @Test
  public void processNextRecord() throws IOException {
    String[] fields = new String[]{"first_name","last_name","company_name","address","city","county","state","zip","phone1","phone2","email","web"};
    String[] values = new String[]{"James","Butt","Benton, John B Jr","6649 N Blue Gum St","New Orleans","Orleans","LA","70116","504-621-8927","504-845-1427","jbutt@gmail.com","http://www.bentonjohnbjr.com"};
    Record record = new Record(fields, values);
    assertEquals(record, csvProc.processNextRecord());
  }

  @Test
  public void endOfFileTest() throws IOException {
    // Process all records
    csvProc.processNextRecord();
    csvProc.processNextRecord();
    csvProc.processNextRecord();
    // Try again
    assertNull(csvProc.processNextRecord());
  }

  @Test
  public void processAll() throws IOException {
    // Make a list
    String[] fields = new String[]{"first_name","last_name","company_name","address","city","county","state","zip","phone1","phone2","email","web"};
    String[] values1 = new String[]{"James","Butt","Benton, John B Jr","6649 N Blue Gum St","New Orleans","Orleans","LA","70116","504-621-8927","504-845-1427","jbutt@gmail.com","http://www.bentonjohnbjr.com"};
    String[] values2 = new String[]{"Josephine","Darakjy","Chanay, Jeffrey A Esq","4 B Blue Ridge Blvd","Brighton","Livingston","MI","48116","810-292-9388","810-374-9840","josephine_darakjy@darakjy.org","http://www.chanayjeffreyaesq.com"};
    String[] values3 = new String[]{"Art","Venere","Chemel, James L Cpa","8 W Cerritos Ave #54","Bridgeport","Gloucester","NJ","8014","856-636-8749","856-264-4130","art@venere.org","http://www.chemeljameslcpa.com"};
    Record record1 = new Record(fields, values1);
    Record record2 = new Record(fields, values2);
    Record record3 = new Record(fields, values3);
    List<Record> list = new ArrayList<>();
    list.add(record1);
    list.add(record2);
    list.add(record3);

    // Test
    assertEquals(list, csvProc.processAll());
  }

  @Test
  public void processAllEmptyList() throws IOException {
    List<Record> empty = new ArrayList<>();
    String data = "\"first_name\",\"last_name\",\"company_name\",\"address\",\"city\",\"county\",\"state\",\"zip\",\"phone1\",\"phone2\",\"email\",\"web\"";
    csvProc = new CsvProcessor(new BufferedReader(new StringReader(data)));
    assertEquals(empty, csvProc.processAll());
  }
}