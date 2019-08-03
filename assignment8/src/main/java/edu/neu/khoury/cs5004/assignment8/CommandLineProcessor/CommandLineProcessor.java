package edu.neu.khoury.cs5004.assignment8.CommandLineProcessor;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;


/**
 * Command line processor should check whether a argument passed is validate.
 * There are 4 fields: outputType, outputDir, csvfileName and template.
 * I use map to store arg pairs like: <--csv-file MengtianAndEvan.csv>.
 * Besides, I got a bunch of checkers to check every part.
 */
public class CommandLineProcessor {
  private static final int ARGS_LENGTH = 7;
  private static final String EMAIL_TYPE = "--email";
  private static final String LETTER_TYPE = "--letter";
  private String outputType;
  private String outputDir;
  private String csvfileName;
  private String template;
  private Map<String, String> argpair;

  /**
   * Instantiates a new Command line processor.
   */
  public CommandLineProcessor() {
    this.outputType = null;
    this.outputDir = null;
    this.csvfileName = null;
    this.template = null;
    this.argpair = new HashMap<>();
  }

  /**
   * the main part of processor, first check the length of the argument.
   * then put all the invalid argument pairs into the map.
   *
   * @param args the args
   * @throws InvalidArgumentException the invalid argument exception
   */
  public void processArgument(String[] args) throws InvalidArgumentException {
    if (args.length != ARGS_LENGTH) {
      throw new InvalidArgumentException("Error:invalid argument length");
    } else {
      List<String> arglist = Arrays.asList(args);
      String type = checkType(arglist);
      for (int i = 0; i < args.length; i++) {
        if (arglist.get(i).startsWith("--") && !arglist.get(i).equals(type)
            && !arglist.get(i + 1).startsWith("--")) {
          this.argpair.put(arglist.get(i), arglist.get(i + 1));
        }
      }
      // any given template must be matched with the given type.
      List<String> templatelist = new ArrayList<>();
      List<String> keylist = new ArrayList<>(this.argpair.keySet());
      for (int i =  0; i< keylist.size(); i++){
        if (keylist.get(i).startsWith(type)) {
          templatelist.add(keylist.get(i));
        }
      }
      checkTemplate(templatelist);
      checkCsvfile();
      checkOutputDir();
    }
  }

  /**
   * check the given type is letter or email.
   *
   * @param arglist the arglist
   * @return the string
   * @throws InvalidArgumentException the invalid argument exception
   */
  public String checkType(List<String> arglist) throws InvalidArgumentException {
    if (arglist.contains(EMAIL_TYPE) && arglist.contains(LETTER_TYPE)) {
      throw new InvalidArgumentException("Error:can't input two output types");
    } else if (arglist.contains(EMAIL_TYPE)) {
      setOutputType(EMAIL_TYPE);
      return EMAIL_TYPE;
    } else if (arglist.contains(LETTER_TYPE)) {
      setOutputType(LETTER_TYPE);
      return LETTER_TYPE;
    } else {
      throw new InvalidArgumentException("Error:no valid type input");
    }
  }

  /**
   * Check the given template, if the given template is empty.
   * or the given template is not same with the given type, throw exception.
   * if all things go well, set template.
   *
   * @param giventemplate the giventemplate
   * @throws InvalidArgumentException the invalid argument exception
   */
  public void checkTemplate(List<String> giventemplate) throws InvalidArgumentException {
    if(giventemplate.isEmpty()) {
      errorExplanation();
      throw new InvalidArgumentException("Error:the template is not matched with the type");
    } else {
      setTemplate(this.argpair.get(giventemplate.get(0)));
    }
  }

  /**
   * Check csvfile and set csvfile.
   *
   * @throws InvalidArgumentException the invalid argument exception
   */
  public void checkCsvfile() throws InvalidArgumentException {
    if (!argpair.containsKey("--csv-file")){
      errorExplanation();
      throw new InvalidArgumentException("Error:csv file is required");
    } else {
      setCsvfileName(this.argpair.get("--csv-file"));
    }
  }

  /**
   * Check output dir and set putput dir.
   *
   * @throws InvalidArgumentException the invalid argument exception
   */
  public void checkOutputDir() throws InvalidArgumentException {
    if (!argpair.containsKey("--output-dir")){
      errorExplanation();
      throw new InvalidArgumentException("Error:output dictionary is required");
    } else {
      setOutputDir(this.argpair.get("--output-dir"));
    }
  }


  /**
   * Sets template.
   *
   * @param template the template
   */
  public void setTemplate(String template) {
    this.template = template;
  }

  /**
   * Sets output type.
   *
   * @param outputType the output type
   */
  public void setOutputType(String outputType) {
    this.outputType = outputType;
  }

  /**
   * Sets output dir.
   *
   * @param outputDir the output dir
   */
  public void setOutputDir(String outputDir) {
    this.outputDir = outputDir;
  }

  /**
   * Sets csvfile name.
   *
   * @param csvfileName the csvfile name
   */
  public void setCsvfileName(String csvfileName) {
    this.csvfileName = csvfileName;
  }

  /**
   * Gets template.
   *
   * @return the template
   */
  public String getTemplate() {
    return template;
  }


  /**
   * Gets output type.
   *
   * @return the output type
   */
  public String getOutputType() {
    return outputType;
  }

  /**
   * Gets output dir.
   *
   * @return the output dir
   */
  public String getOutputDir() {
    return outputDir;
  }

  /**
   * Gets csvfile name.
   *
   * @return the csvfile name
   */
  public String getCsvfileName() {
    return csvfileName;
  }

  /**
   * Error explanation.
   */
  public void errorExplanation() {
    System.out.println("Usage:");
    System.out.println("--email only generate email messages");
    System.out.println("--email-template <file> accept a filename that holds the email template.");
    System.out.println("Required if --email is used");
    System.out.println("--letter only generate letters");
    System.out.println("--letter-template <file> accept a filename that holds the email template.");
    System.out.println("Required if --letter is used");
    System.out.println("--output-dir <path> accept the name of a folder, all output is placed in this folder");
    System.out.println("--csv-file <path> accept the name of the csv file to process");
    System.out.println("Examples:");
    System.out.println("--email --email-template email-template.txt --output-dir"
        + "emails --csv-file customer.csv");
    System.out.println("--letter --letter-template letter-template.txt --outputdir"
        + "letters --csv-file customer.csv");
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CommandLineProcessor that = (CommandLineProcessor) o;
    return Objects.equals(outputType, that.outputType) &&
        Objects.equals(outputDir, that.outputDir) &&
        Objects.equals(csvfileName, that.csvfileName) &&
        Objects.equals(template, that.template) &&
        Objects.equals(argpair, that.argpair);
  }

  @Override
  public int hashCode() {
    return Objects.hash(outputType, outputDir, csvfileName, template, argpair);
  }

  @Override
  public String toString() {
    return "CommandLineProcessor{" +
        "outputType='" + outputType + '\'' +
        ", outputDir='" + outputDir + '\'' +
        ", csvfileName='" + csvfileName + '\'' +
        ", template='" + template + '\'' +
        ", argpair=" + argpair +
        '}';
  }
}