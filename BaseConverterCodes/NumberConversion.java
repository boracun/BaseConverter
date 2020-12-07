import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This program converts decimal, binary and hexadecimal numbers to each other
 * @author Bora Çün
 * @version 12.11.2019
 */ 
public class NumberConversion
{
  public static void main( String[] args )
  {
    //Constants
    final int WIDTH = 400;
    final int HEIGHT = 300;
    final String TITLE = "Number Conversion";
    
    //Variables
    JPanel panel = new ConverterPanel();
    JFrame frame = createFrame( WIDTH, HEIGHT, TITLE );
    
    //Program
    frame.add( panel );
    
  }
  
  /**
   * Creates a frame
   * @param w Width of the frame
   * @param h Height of the frame
   * @param title Title of the frame
   * @return Returns the created frame
   */
  public static JFrame createFrame( int w, int h, String title )
  {
    JFrame frame = new JFrame();     //Creates the JFrame object
    frame.setSize( w, h );  //Sets the size
    frame.setTitle( title );  //Sets title
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );  //The frame will be killed when closed
    frame.setVisible( true ); //Sets visible
    
    return frame;
  }
}