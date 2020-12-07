import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This class is a subclass of JPanel class. It creates and fills a panel with JLabel and JTextField
 * components to form a 3 by 2 Grid Layout
 * @author Bora Çün
 * @version 12.11.2019
 */ 

public class ConverterPanel extends JPanel
{
  //Constants
  
  //Instance Variables
  private JTextField decimalField;
  private JLabel label;
  private JTextField hexField;
  private JTextField binaryField;
  private ActionListener listener;
  private String number;
  private BaseConverter converter;
  
  //Constructors
  
  /**
   * Constructs a Panel which has a three text fields and three labels
   */
  public ConverterPanel()
  {
    super(); //Construct a JPanel object  
    this.listener = new KeyboardListener();  //Constructs the KeyboardListener
    this.converter = new BaseConverter();  //Constructs a Base Converter
    this.createTextFields();    //Creates the text fields
    this.fillPanel();    //Fills the panel with three labels and three text fields
  }
  
  //Methods
  
  /**
   * Sets a Grid Layout for the panel and fills it with needed components
   */
  public void fillPanel()
  {
    this.setLayout( new GridLayout( 3, 2 ) );            //(3x2) GridLayout for the panel
    
    this.add( this.createLabel( "Decimal", 100, 100 ) );  //Creates and adds the Label for Decimal
    this.add( this.decimalField );                        //Adds the text field for the decimal
    this.add( this.createLabel( "Hex", 100, 100 ) );      //Creates and adds the Label for Hex
    this.add( this.hexField );                            //Adds the text field for hex
    this.add( this.createLabel( "Binary", 100, 100 ) );   //Creates and adds the Label for Binary
    this.add( this.binaryField );                         //Adds the text field for binary
  }
  
  /**
   * Creates and returns a Label with given properties
   * @param name Text of the label
   * @param x X dimension of the label
   * @param y Y dimension of the label
   * @return Returns the label
   */
  public JLabel createLabel( String name, int x, int y )
  {
    JLabel aLabel = new JLabel( name );                //Creates the label
    aLabel.setPreferredSize( new Dimension( x, y ) );  //Sets the size
    return aLabel; 
  }
  
  /**
   * Instantiates the text fields and adds KeyboardListener to them
   */
  public void createTextFields()
  {
    this.decimalField = new JTextField( 50 );    //Creates decimal field
    this.hexField = new JTextField( 50 );        //Creates hexField
    this.binaryField = new JTextField( 50 );     //Creates binary field
    
    decimalField.addActionListener ( listener );   //Add listeners
    hexField.addActionListener ( listener );
    binaryField.addActionListener ( listener );
  }
  
  /**
   * An inner class to handle the Keyboard events.
   */
  public class KeyboardListener implements ActionListener
  {
    /**
     * A method to handle the keyboard events
     * @param event The event that happens
     */
    public void actionPerformed( ActionEvent event )
    {
      //If the event happens at decimal Field
      //Get the number from the decimal field, convert it to hex and binary, set the other fields accordingly
      if ( event.getSource() == decimalField )
      {
        hexField.setText( converter.decToHex( decimalField.getText() ) ); 
        binaryField.setText( converter.decToBin( decimalField.getText() ) );
      }
      
      //If the event happens at hex Field
      //Get the number from the hex field, convert it to decimal and binary, set the other fields accordingly
      else if ( event.getSource() == hexField )
      {
        decimalField.setText( converter.hexToDec( hexField.getText() ) );
        binaryField.setText( converter.hexToBin( hexField.getText() ) );
      }
      
      //If the event happens at binary Field
      //Get the number from the binary field, convert it to hex and decimal, set the other fields accordingly
      else if ( event.getSource() == binaryField )
      {
        decimalField.setText( converter.binToDec( binaryField.getText() ) );
        hexField.setText( converter.binToHex( binaryField.getText() ) );
      }
        
    }
  }
}