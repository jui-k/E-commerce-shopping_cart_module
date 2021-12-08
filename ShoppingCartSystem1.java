   import java.awt.*;
   import java.awt.event.*;
   import java.io.File;
   import java.io.*;
   import javax.swing.*;
   import java.util.*;
   import java.text.DecimalFormat;
   public class ShoppingCartSystem1 extends JFrame
   {	
   	//Declare array to put file into it.
      String[] items = new String[7];
      private double[] itemPrices = {14.95, 10.0, 39.55, 234.32, 213.23, 313.33, 23.34};
   
   	// Declare components
      private JPanel greetingPanel;	   // To hold greeting components
      private JPanel itemPanel;		  // To hold the items components
      private JPanel shoppingCartPanel;   // To hold the shoppingCart components
     // private JPanel billPanel;				// To hold the bill components
   
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
   
   /**
    * Constructor
    */
   
      public ShoppingCartSystem1()
      {
      // Call the JFrame constructor to set title
         super("Online Grocery Store");
      
      // Specify an action for the close button.
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      // Create a BorderLayout manger for the content pane.
         setLayout(new BorderLayout());
      
      // Build the panels.
         buildGreetingPanel();
         bulidItemsPanel();
         buildShoppingCartPanel();
         //buildBillPanel();
      
      // Add panels to the content pane.
         add(greetingPanel, BorderLayout.NORTH);
         add(itemPanel, BorderLayout.WEST);
         add(shoppingCartPanel, BorderLayout.EAST);
         //add(billPanel, BorderLayout.SOUTH);
      
      // Build the menu bar.
         buildMenuBar();
      
      // Pack and display the window.
         pack();
         setVisible(true);
      
      }
   
   /**
    * The buildGreetingPanel method adds a greeting
    * message to a panel.
    */
   
      private void buildGreetingPanel()
      {
      // Create a panel
         greetingPanel = new JPanel();
      
      // Create a greeting message.
         headerLabel = new JLabel("Welcome to Online Grocery Shopping!");
      
         headerLabel.setFont(new Font("Dialog",Font.BOLD,20)); 
      
      // Add the label to the panel.
         greetingPanel.add(headerLabel);
      }
   
   /**
    * The bulidItemsPanel method adds a list
    * to a panel.
    */
   
      private void bulidItemsPanel()
      {
         openFile();
      	
      	// Create a panel.
         itemPanel = new JPanel();
      	
      	// Add GridLayout manager to the content pane.
         itemPanel.setLayout(new GridLayout(2, 1));
      	
      	// Create a greeting message.
         itemLabel = new JLabel("     	Available Items:");
         itemLabel.setFont(new Font("Dialog",Font.BOLD,14));
      	
      	// Create a list
         itemList = new JList(items);
      
      	// Set the list to multiple interval selection mode.
         itemList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
      
      	// Set number of visible rows to 7.
         itemList.setVisibleRowCount(7);
      	
      	// Add lsit to a scroll pane
         JScrollPane itemListScroll = new JScrollPane(itemList);
      	
      	// Add label to the panel.
         itemPanel.add(itemLabel);
      	
      	// Add the list to the panel.
         itemPanel.add(itemListScroll);
      }
   
   /**
    * The buildShoppingCartPanel methods adds a list to 
    * a panel. This will hold the selected items.
    */
   
      private void buildShoppingCartPanel()
      {
      // Create a panel to hold another list.
         shoppingCartPanel = new JPanel();
      
      // Add GridLayout manager to the content pane.
         shoppingCartPanel.setLayout(new GridLayout(2, 1));
      
      // Create a greeting message.
         shoppingCartLabel = new JLabel("        		Your Cart");
         shoppingCartLabel.setFont(new Font("Dialog",Font.BOLD,14));
      
      // Create list model.
         listModel = new DefaultListModel();
      
      // Create the list.
         shoppingCartList = new JList(listModel);
      
         shoppingCartList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
      
      // Set the number of visible rows to 7.
         shoppingCartList.setVisibleRowCount(7);
      
      // Add list to a scroll pane.
         JScrollPane shoppingCartScroll = new JScrollPane(shoppingCartList);
      
      // Add label to the panel.
         shoppingCartPanel.add(shoppingCartLabel);
      
      // Add list to the panel
         shoppingCartPanel.add(shoppingCartScroll);
      }
   
   
   
   /**
    * The buildMenuBar method builds the menu bar.
    */
   
      private void buildMenuBar()
      {
      // Create the menu bar.
         menuBar = new JMenuBar();
      
      // Create the file and edit menus
         buildFileMenu();
         buildEditMenu();
         buildHelpMenu();
      
      // Add the file and edit menus to the menu bar.
         menuBar.add(fileMenu);
         menuBar.add(editMenu);
         menuBar.add(helpMenu);
      
      // Set the windows menu bar.
         setJMenuBar(menuBar);
      }
   
   /**
    * The buildFileMenu method builds the File MEnu
    * and returns a reference to its JMenu object.
    */
   
      private void buildFileMenu()
      {
      // Create an Exit menu item.
         exitItem = new JMenuItem("Exit");
         exitItem.setMnemonic(KeyEvent.VK_X);
         exitItem.addActionListener(new ExitListener());
      
      // Create a JMenu object for the file menu.
         fileMenu = new JMenu("File");
         fileMenu.setMnemonic(KeyEvent.VK_F);
      
      // Add the Exit item to the file menu.
         fileMenu.add(exitItem);
      }
   
   /**
    * The buildEditMenu method builds the Edit menu
    * and returns a reference to its JMenu object.
    */
   
      private void buildEditMenu()
      {
      // Create an addTo menu item.
         addTo = new JMenuItem("Add to Cart");
         addTo.setMnemonic(KeyEvent.VK_A);
         addTo.addActionListener(new AddToListener());
      
      // Create a remove menu Item.
         remove = new JMenuItem("Remove Item from Cart");
         remove.setMnemonic(KeyEvent.VK_R);
         remove.addActionListener(new RemoveListener());
      
      // Create a clearAll menu item.
         clearAll = new JMenuItem("Clear Shopping Cart");
         clearAll.setMnemonic(KeyEvent.VK_L);
         clearAll.addActionListener(new ClearAllListener());
      
      // Create a checkOut menu item.
         checkOut = new JMenuItem("Check Out");
         checkOut.setMnemonic(KeyEvent.VK_C);
         checkOut.addActionListener(new CheckOutListener());
      
      // Create menu object for Edit Menu.
         editMenu = new JMenu("Edit");
         editMenu.setMnemonic(KeyEvent.VK_E);
      
      // Add items to the Edit menu.
         editMenu.add(addTo);
         editMenu.add(remove);
         editMenu.add(clearAll);
         editMenu.add(checkOut);
      }
   
   /**
    * The buildHelpMenu method builds the Help menu
    * and returns a reference to its JMenu object.
    */
    
      private void buildHelpMenu()
      {
      // Create an Exit menu item.
         help = new JMenuItem("About");
         help.setMnemonic(KeyEvent.VK_B);
         help.addActionListener(new HelpListener());
      
      // Create a JMenu object for the file menu.
         helpMenu = new JMenu("Help");
         helpMenu.setMnemonic(KeyEvent.VK_H);
      
      // Add the Exit item to the file menu.
         helpMenu.add(help);	
      }
   
   /**
    * Private inner class that handles the event that
    * is generated when the user selects Exit from
    * the file menu.
    */
   
      private class ExitListener implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
            System.exit(0);
         }
      }
   
   /**
    * Private inner class that handles the event that
    * is generated when the user selects Add to Cart
    * from the edit menu.
    */
   
      private class AddToListener implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {  
            int[] listArray = itemList.getSelectedIndices();  
         
            for (int index = 0; index < listArray.length; index++)  
            {  
               listModel.addElement("\n" + items[listArray[index]] + "\n");  
            }  
         
            listModel.addElement("\n");  
         				
         }
      }
   
   /**
    * Private inner class that handles the event that
    * is generated when the user selects Remove from
    * the edit menu.
    */
   
      private class RemoveListener implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {	
         // Get the items selected for removal.
            int item = shoppingCartList.getSelectedIndex();
         
            if (item > -1)
            {
            // Remove items from shopping cart.
               listModel.removeElementAt(item);
            }
         
         }
      }
   
   /**
    * Private inner class that handles the event that
    * is generated when the user selects clear from 
    * the edit menu.
    */
   
      private class ClearAllListener implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
         	// Clear all items from shopping cart.
            listModel.clear();
         	
         	// Clear selections.
            itemList.clearSelection();
         	
            repaint();
         }
      }
   
   /**
    * Private inner class that handles the event that 
    * is generated when the user selects Checkout from
    * the edit menu.
    */
   
      private class CheckOutListener implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
            Payment pay = new Payment();
			//pay.buildBillPanel();
			pay.displayBill(itemList);
            pack();
         
         }
      }
   
   /**
    * Private inner class that handles the event that
    * is generated when the user selects About from
    * the help menu.
    */
   
      private class HelpListener implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
            String helpMessage = "This is a program to buy items from "
               					+ "\nthe list presented to you."
               					+ "\n"
               					+ "\nYou can add the items to your "
               					+ "\nshopping cart by clicking 'Add to Cart'"
               					+ "\nunder the edit menu."
               					+ "\n"
               					+ "\nWhen you're ready to check out, select all"
               					+ "\nitems that you want and click 'Check Out' and"
               					+ "\nyour reciept will appear at the bottom of"
               					+ "\nthe page.";
         							
            String note = "\n"
               		  + "\nNOTE: You can select multiple items at once by"
               		  + "\nholding down 'ctrl' on your keyboard and"
               		  + "\nclicking on each item title.";
         				  
         				  
            JOptionPane.showMessageDialog(null, helpMessage + note);
         							
         }
      }
   
      public void openFile()
      {
         int index = 0;
         try
         {
         
         // Open the file.
            File file = new File("ItemPrices.txt");
            Scanner inputFile = new Scanner(file);
         
         //Read the file contents into the array.
            while (inputFile.hasNext() && index < items.length)
            {
               items[index] = inputFile.nextLine();
               index++;
            }
         
         // Close the file.
            inputFile.close();
         }
            catch (FileNotFoundException e)
            {
            // The file was not found.
               System.out.println("The file doesn't exist.");
            
            }
      }
   	
   /**
    * The main method creates an instance of the 
    * ShoppingCartSystem1 class, which causes it to
    * display its window.
    */
   
      public static void main(String[] args)
      {
         new ShoppingCartSystem1();
      }
   }