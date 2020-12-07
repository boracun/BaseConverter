import java.util.ArrayList;

public class BaseConverter
{
  /**
   * This class provides methods to convert decimal, binary, and hexadecimal numbers to each other.
   * @author Bora Çün
   * @version 13.11.2019
   */ 
  
  //Constructor
  
  /**
   * Do-nothing constructor
   */
  public BaseConverter()
  {
  }
  
  
  //Methods
  
  /**
   * Converts a decimal to binary
   * @param decimal Decimal number to be converted
   * @return Returns the binary number
   */
  public String decToBin ( String decimal )
  {
    String bin = "";                                        //Create an empty String to store new binary number
    int dec = Integer.parseInt( decimal );                  //Turn the decimal from String to int
    int binDigit;  //Int to hold the binary digit
    
    while ( dec != 0 )         //As long as the decimal is not 0       
    {
       binDigit = ( dec % 2 ) ; //Get the remainder of decimal from division by two
       bin = binDigit + bin;    //Add the digit to the start
       dec = dec / 2;                     //Divide the decimal by two and update it
    }
    
    return bin;
  }
  
  /**
   * Converts a binary to decimal
   * @param bin Binary number to be converted
   * @return Returns the decimal number
   */
  public String binToDec( String bin )
  {
    int dec = 0;  //New number to hold the decimal value
    int digit;
    int length = bin.length();
    
    for ( int i = 0; i < length; i++ )  
    {
      digit = Integer.parseInt( bin.substring( bin.length() - 1  ) );   //get the last digit of the binary string
      dec = dec + digit * (int) Math.pow( 2, i );  //Multiply the digit by the ith power of 2
      
      bin = bin.substring( 0, bin.length() - 1 );  //Delete the last digit of the binary string
    }
    
    return "" + dec;
  }
  
  /**
   * Converts a decimal to hexadecimal
   * @param decimal Decimal number to be converted
   * @return Returns the hexadecimal number
   */
  public String decToHex( String decimal )
  {
    int dec = Integer.parseInt( decimal );    //Turn the decimal string to int 
    String hex = "";  //New empty string to hold hex
    ArrayList<String> hexList = new ArrayList<String>();  //new ArrayList to hold the hex digits
    int remainder;  
    
    while ( dec != 0 )  //While decimal is not 0
    {
      remainder = dec % 16;    //remainder is decimal mod 16
      hexList.add( 0, hexLetters( remainder ) );  //Convert the remainder to corresponding character and add to the ArrayList
      dec = dec / 16;          //Divide the decimal by 16
    }
    
    for ( int i = 0; i < hexList.size(); i++ )
    {
      hex = hex + hexList.get( i );  //Add all the hex characters together
    }
    
    return hex;
  }
  
  /**
   * Converts a hexadecimal to decimal
   * @param hex Hexadecimal number to be converted
   * @return Returns the decimal number
   */
  public String hexToDec( String hex )
  {
    int dec = 0;  //New int to hold the decimal value
    String digit;
    int length = hex.length();
       
    for ( int i = 0; i < length; i++ )
    {
       int index = hex.length() - i - 1;  //Get the index of the last digit
       digit = hexNumbers( hex.charAt( index ) );  //Convert the digit from hex to decimal
       dec = dec + Integer.parseInt( digit ) * (int) Math.pow( 16, i );  //Multiply the digit by the ith power of 16 and add
    }
    
    return "" + dec;
  }
  
  /**
   * Converts a binary number to a hexadecimal number
   * @param binary The number to be converted
   * @return Returns the hexadecimal number
   */
  public String binToHex( String binary )
  {
    return this.decToHex( this.binToDec( binary ) );  
  }
  
  /**
   * Converts a hexadecimal to binary
   * @param hex Hexadecimal number to be converted
   * @return Returns the binary number
   */
  public String hexToBin( String hex )
  {
    return this.decToBin( this.hexToDec( hex ) );
  }
  
  /**
   * A static method to get the corresponding letters for hexadecimal production
   * @param num The number to be converted to a letter or to stay same
   * @return Returns the corresponding letter or number
   */
  public static String hexLetters( int num )
  {
    if ( num == 10 )
      return "A";
    else if ( num == 11 )
      return "B";
    else if ( num == 12 )
      return "C";
    else if ( num == 13 )
      return "D";
    else if ( num == 14 )
      return "E";
    else if ( num == 15 )
      return "F";
    else
      return "" + num;  //Return as String
  }
  
  /**
   * Static method to turn hex letters to decimal numbers
   * @param c The character to turn
   * @return Returns the corresponding decimal number
   */
  public static String hexNumbers( char c )
  {
    if ( c == 'A' || c == 'a' )
      return "10";
    else if ( c == 'B' || c == 'b' )
      return "11";
    else if ( c == 'C' || c == 'c' )
      return "12";
    else if ( c == 'D' || c == 'd' )
      return "13";
    else if ( c == 'E' || c == 'e' )
      return "14";
    else if ( c == 'F' || c == 'f' )
      return "15";
    else
      return "" + c;  //Return as String
  }
}