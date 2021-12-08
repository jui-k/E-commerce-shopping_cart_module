   import java.awt.*;
   import java.awt.event.*;
   import java.io.File;
   import java.io.*;
   import javax.swing.*;
   import java.util.*;
   import java.text.DecimalFormat;
   public class Payment extends JFrame implements ActionListener
   {	
   	//Declare array to put file into it.
      String[] items = new String[7];
      private double[] itemPrices = {14.95, 10.0, 39.55, 234.32, 213.23, 313.33, 23.34};
   	
   
   	// Declare components
      private JPanel greetingPanel;	   // To hold greeting components
      private JPanel itemPanel;		  // To hold the items components
      private JPanel shoppingCartPanel;   // To hold the shoppingCart components
      private JPanel billPanel;				// To hold the bill components
   
      private JLabel headerLabel;		 // To display header message
      private JList itemList;			// List of items
      private JLabel itemLabel;		  // Display itemlist label
   	
      private DefaultListModel listModel; // To add and remove items.
      private JList shoppingCartList;	 // List of Items in shopping cart
      private JLabel shoppingCartLabel;   // Display shopping cart label.
   	
      private JTextArea orderBill;			 // Display the bill.
   
      private JMenuBar menuBar;		 // The menu bar
      private JMenu fileMenu;		   // The file menu
      private JMenu editMenu;		   // The edit menu
      private JMenu helpMenu;		   // The help menu
      private JMenuItem exitItem;	   // Item to exit application
      private JMenuItem addTo;		  // Item to add selected items to shopping cart
      private JMenuItem remove;		 // Item to remove selected items from shopping cart
      private JMenuItem clearAll;	   // Item to clear all items from shopping cart
      private JMenuItem checkOut;	   // Item to check out
      private JMenuItem help;		   // Item to display help box.
	  JButton btnNewButton = new JButton("Logout");
	  
	 
	  
	  
   
   /**
    * Constructor
    */
   
      public Payment()
      {
      // Call the JFrame constructor to set title
         super("Online Grocery Store");
      
      // Specify an action for the close button.
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      // Create a BorderLayout manger for the content pane.
         setLayout(new BorderLayout());
      
      // Build the panels.
   
         buildBillPanel();
      
      // Add panels to the content pane.
         add(billPanel);
		 //addTo.addActionListener(new AddToListener());
      
 
      // Pack and display the window.
         pack();
         setVisible(true);
	
		
		setVisible(true);
		setSize(1500, 1500);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		
		btnNewButton.setBounds(500, 500, 110, 40);
		add(btnNewButton);
		
		btnNewButton.addActionListener(this);
		}
			  
      
   
   
      private void buildBillPanel()
      {
      // Create a panel
         billPanel = new JPanel();
      
      // Create a text area.
         orderBill = new JTextArea(30,40); 
		 orderBill.setEditable(false);
      
      // Add the label to the panel.
         billPanel.add(orderBill);
      }
	  
	  
   
      public void displayBill(JList itemList)
      {
		
      
         int[] listArray = itemList.getSelectedIndices();  
        
         double subTotal = 0;  
         double total = 0.0;	
         double taxes = 0.0;
      	  
         for (int index = 0; index < listArray.length; index++) 
         {
            subTotal = subTotal  
                + itemPrices[listArray[index]];
         }
      					
         taxes = subTotal * .06; 
         total = subTotal + taxes;
      	
         String header = "\tOnline items";
		 String bill = "\n\t\tSubTotal: " + subTotal
            				+ "\n\t\tTaxes: " + taxes
            				+ "\n\t\tTotal: " + total;
      						
         orderBill.setText(header + "\n\n" + bill);
         orderBill.setFont(new Font("Courier", Font.BOLD, 20));
		 
      }
	  
	  public void actionPerformed(ActionEvent e)
		{
			int a = JOptionPane.showConfirmDialog(btnNewButton, "Are you sure?");
                // JOptionPane.setRootFrame(null);
                if (a == JOptionPane.YES_OPTION) {
                    dispose();
                    Login obj = new Login();
                    
                }
                dispose();
                Registration obj = new Registration();


            }
		
		
  
      public static void main(String[] args)
      {
         new Payment();
      }
	  
   }
   