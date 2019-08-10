package edu.neu.khoury.cs5004.assignment9;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Date;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CsvWriterTest {

  private CsvWriter writer;
  private File file;
  private BufferedReader reader;

  @Before
  public void setUp() throws Exception {
    file = File.createTempFile("output", ".csv");
    String path = file.getPath();
    writer = new CsvWriter(path);
    reader = new BufferedReader(new FileReader(file));

  }

  @After
  public void tearDown() throws Exception {
    file.delete();
  }

  @Test
  public void checkHeader() throws IOException {
    String header = "transaction_number,timestamp,client_id,message,"
        + "digital_signature,verified,status";
    String line = reader.readLine();
    assertEquals(header, line);
  }

  @Test
  public void writeLineAcceptDeposit() throws IOException {
    Date now = new Date();
    writer.writeLine((long) 1, now, (long) 0, 14, new BigInteger("1234"),true);
    String expected = "1," + now.toString() + ",0,14,1234,yes,deposit accepted";

    reader.readLine();  // discard header
    assertEquals(expected, reader.readLine());
  }

  @Test
  public void writeLineRejectDeposit() throws IOException {
    Date now = new Date();
    writer.writeLine((long) 1, now, (long) 0, 10, new BigInteger("1234"),false);
    String expected = "1," + now.toString() + ",0,10,1234,no,deposit rejected";

    reader.readLine();  // discard header
    assertEquals(expected, reader.readLine());
  }

  @Test
  public void writeLineAcceptWithdrawal() throws IOException {
    Date now = new Date();
    writer.writeLine((long) 1, now, (long) 0, 15, new BigInteger("1234"),true);
    String expected = "1," + now.toString() + ",0,15,1234,yes,withdrawal accepted";

    reader.readLine();  // discard header
    assertEquals(expected, reader.readLine());
  }

  @Test
  public void writeLineRejectWithdrawal() throws IOException {
    Date now = new Date();
    writer.writeLine((long) 1, now, (long) 0, 19, new BigInteger("1234"),false);
    String expected = "1," + now.toString() + ",0,19,1234,no,withdrawal rejected";

    reader.readLine();  // discard header
    assertEquals(expected, reader.readLine());
  }
}