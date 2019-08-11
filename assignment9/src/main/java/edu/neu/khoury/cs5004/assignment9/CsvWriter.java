package edu.neu.khoury.cs5004.assignment9;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Date;

/**
 * A utility to write information to a CSV file.
 */
public class CsvWriter {

  private BufferedWriter writer;

  /**
   * Constructor for {@code CsvWriter}. Creates the given file if it doesn't exist and writes an
   * initial header, overwriting any previous data in the file.
   *
   * @param outputFile a file name with the desired path
   * @throws IOException if there is a problem opening the file or writing the headers
   */
  public CsvWriter(String outputFile) throws IOException {
    File out = new File(outputFile);
    // Check for existence and output message
    if (out.createNewFile()) {
      System.out.println(outputFile + " created");
    } else {
      System.out.println("overwriting " + outputFile);
    }
    // Make writer and write header
    writer = new BufferedWriter(new FileWriter(out, false));
    writeHeader();
  }

  /**
   * Writes a single line of data, a single transaction, to the csv file.
   *
   * @param transactionNumber the transaction number
   * @param clientID the client's unique ID
   * @param message the message
   * @param signature the signature
   * @param verified a boolean (true if transaction accepted, else false)
   * @throws IOException if there is a problem writing to the file
   */
  public void writeLine(Long transactionNumber, Date timestamp, Long clientID, Integer message,
      BigInteger signature, Boolean verified) throws IOException {
    String line = String.format("%d,%s,%d,%d,%d,%s,%s",
        transactionNumber,
        timestamp,
        clientID,
        message,
        signature,
        chooseVerifiedString(verified),
        chooseStatusString(message, verified));
    writer.write(line);
    writer.newLine();
    writer.flush();
  }

  public void closeCsv() throws IOException {
    writer.close();
  }

  /**
   * Writes the header line to the csv file. Used only in the constructor.
   *
   * @throws IOException if there is a problem writing to the file
   */
  private void writeHeader() throws IOException {
    String header = "transaction_number,timestamp,client_id,message,"
        + "digital_signature,verified,status";
    writer.write(header);
    writer.newLine();
    writer.flush();
  }

  /**
   * Determines if "yes" or "no" should be written.
   *
   * @param verified a boolean (true if transaction accepted, else false)
   * @return "yes" if verified is true, else "no"
   */
  private String chooseVerifiedString(Boolean verified) {
    if (verified) {
      return "yes";
    }
    return "no";
  }

  /**
   * Determines what string should be written to the status field of the csv.
   *
   * @param message the message
   * @param verified a boolean (true if transaction accepted, else false)
   * @return a string with four options: deposit/withdrawal accepted/rejected
   */
  private String chooseStatusString(Integer message, Boolean verified) {
    if (verified) {
      return depositOrWithdrawal(message) + " accepted";
    }
    return depositOrWithdrawal(message) + " rejected";
  }

  /**
   * Determines if this message is a withdrawal or a deposit.
   *
   * @param message the message
   * @return a string: "deposit" or "withdrawal"
   */
  private String depositOrWithdrawal(Integer message) {
    int lastDigit = message % 10;
    int depositLimit = 5;
    if (lastDigit < depositLimit) {
      return "deposit";
    }
    return "withdrawal";
  }
}
