package cp213;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

//If you need to implement/use a listener in your program then it must be an instance of this class.
//You can add suitable Interfaces to the header/definition of this class using implements.

public class A05Listeners /*add your required Listener Interfaces here*/ {
	static final DecimalFormat f = new DecimalFormat("###.##");
	private BST mine = new BST();
	private change invending = new change(20, 10, 14,0,0,0,0);
	private change input = new change(0,0,0,0,0,0,0);
	private double cashgiven;
	A05Labels Message = new A05Labels("Please make a Selection");
	  final A05Buttons A = new A05Buttons("A");
	  final A05Buttons B = new A05Buttons("B");
	  final A05Buttons C = new A05Buttons("C");
	  final A05Buttons D = new A05Buttons("D");
	  final A05Buttons num1 = new A05Buttons("1");
	  final A05Buttons num2 = new A05Buttons("2");
	  final A05Buttons num3 = new A05Buttons("3");
	  final A05Buttons num4 = new A05Buttons("4");
	 
	  
	  
	  final A05Buttons nickels = new A05Buttons("Nickels");
	  final A05Buttons dimes = new A05Buttons("Dimes");
	  final A05Buttons quarters = new A05Buttons("Quarters");
	  final A05Buttons loonies = new A05Buttons("Loonies");
	  final A05Buttons twoonies = new A05Buttons("Twoonies");
	  final A05Buttons five = new A05Buttons("fives");
	  final A05Buttons tens = new A05Buttons("Tens");
	  
	  final A05Buttons Pay = new A05Buttons("Pay");
	  final A05Buttons Cancel = new A05Buttons("Cancel");
	  final A05Buttons Cash = new A05Buttons("Cash");
	  final A05Buttons Credit = new A05Buttons("Credit");
	  final A05Buttons done = new A05Buttons("Done");
	private String componentID;//your own unique way of identifying components that will be attached
	//to the A05Listener objects. This way you will be able to distinguish that which component has
	//invoked the action handler.
	
	
	
	private void clearID() {
		componentID = "";
		
	}
	
	private void addButton(final String button) {
		componentID += button;
	}
	
	private void pop() {
		mine.populatetree();
	}
	private class OrderButtonListener implements ActionListener {
    	/**
    	 * Determines whether values are incremented (+) or decremented (-).
    	 */
    	private String button = "";

    	public OrderButtonListener(final String button) {
    	    this.button = button;
    	}

    	
    	
		public void actionPerformed(final ActionEvent evt) {
    		
    	    if(button.length() > 1) {
    	    	if(A05Listeners.this.componentID.length() < 2) {
    	    		A05Listeners.this.Message.getLabel().setText("Please Make a selection first");
    	    		//JOptionPane.showMessageDialog(null, "Enter a selection ");
    	    		
    	    	}else if(button.equals("Done")){
    	    		TreeNode spot = A05Listeners.this.mine.retrieve(A05Listeners.this.componentID);
    	    		double change = A05Listeners.this.cashgiven - spot.getPrice();
    	    		
    	    		if(change >= 0) {
    	    		
    	    		change x = A05Listeners.this.remining(change, A05Listeners.this.invending);
    	    		
    	    		
    	    		if(x == null) {
    	    			A05Listeners.this.Message.getLabel().setText("Sorry we do not have enough change");
    	    			//JOptionPane.showMessageDialog(null, "Sorry we do not have enough change");
    	    			JOptionPane.showMessageDialog(null, "Returning : $"+String.format("%.2f",A05Listeners.this.cashgiven)+ "\n"+ A05Listeners.this.input.toString());
    	    			A05Listeners.this.invending.subtract(A05Listeners.this.input);
    	    		}else if(change >0){
    	    			//JOptionPane.showMessageDialog(null, "HALA");
    	    			A05Listeners.this.Message.getLabel().setText("Enjoy your Purchase, Dont forget to take your change");
    	    			JOptionPane.showMessageDialog(null, "Your change is : $"+String.format("%.2f",change)+ "\n"+ x.toString());

    	    			A05Listeners.this.mine.remove(A05Listeners.this.componentID);
    	    			
    	    			A05Listeners.this.invending.subtract(x);
    	    			
    	    		}else {
    	    			A05Listeners.this.Message.getLabel().setText("Enjoy your Purchase");

    	    		}
    	    		
    	    		A05Listeners.this.input.subtract(A05Listeners.this.input);
    	    		A05Listeners.this.cashgiven = 0;
    	    		A05Listeners.this.clearID();
    	    		
    	    		A05Listeners.this.A.getButton().setVisible(true);
    	    		A05Listeners.this.B.getButton().setVisible(true);
    	    		A05Listeners.this.C.getButton().setVisible(true);
    	    		A05Listeners.this.D.getButton().setVisible(true);
    	    		A05Listeners.this.num1.getButton().setVisible(true);
    	    		A05Listeners.this.num2.getButton().setVisible(true);
    	    		A05Listeners.this.num3.getButton().setVisible(true);
    	    		A05Listeners.this.num4.getButton().setVisible(true);
    	    		A05Listeners.this.Pay.getButton().setVisible(true);
    	    		A05Listeners.this.Cancel.getButton().setVisible(true);
    	    		A05Listeners.this.Credit.getButton().setVisible(false);
    	    		A05Listeners.this.Cash.getButton().setVisible(false);
    	    		A05Listeners.this.twoonies.getButton().setVisible(false);
    	    		A05Listeners.this.nickels.getButton().setVisible(false);
    	    		A05Listeners.this.dimes.getButton().setVisible(false);
    	    		A05Listeners.this.quarters.getButton().setVisible(false);
    	    		A05Listeners.this.loonies.getButton().setVisible(false);
    	    		A05Listeners.this.five.getButton().setVisible(false);
    	    		A05Listeners.this.tens.getButton().setVisible(false);
    	    		A05Listeners.this.done.getButton().setVisible(false);
    	    		
    	    		
    	    		A05Listeners.this.Message.getLabel().setText("Please make a Selection");
    	    		}else {
    	    			A05Listeners.this.Message.getLabel().setText("You dont have enough.\r\n"+ "The price for "+ spot.getName() + " is $" +String.format("%.2f",spot.getPrice()) +"");
    	    		}
    	    	
    	    	}else if(button.equals("Cash")) {
    	    		A05Listeners.this.A.getButton().setVisible(false);
    	    		A05Listeners.this.B.getButton().setVisible(false);
    	    		A05Listeners.this.C.getButton().setVisible(false);
    	    		A05Listeners.this.D.getButton().setVisible(false);
    	    		A05Listeners.this.num1.getButton().setVisible(false);
    	    		A05Listeners.this.num2.getButton().setVisible(false);
    	    		A05Listeners.this.num3.getButton().setVisible(false);
    	    		A05Listeners.this.num4.getButton().setVisible(false);
    	    		A05Listeners.this.Credit.getButton().setVisible(false);
    	    		A05Listeners.this.Cash.getButton().setVisible(false);
    	    		A05Listeners.this.twoonies.getButton().setVisible(true);
    	    		A05Listeners.this.nickels.getButton().setVisible(true);
    	    		A05Listeners.this.dimes.getButton().setVisible(true);
    	    		A05Listeners.this.quarters.getButton().setVisible(true);
    	    		A05Listeners.this.loonies.getButton().setVisible(true);
    	    		A05Listeners.this.five.getButton().setVisible(true);
    	    		A05Listeners.this.tens.getButton().setVisible(true);
    	    		A05Listeners.this.done.getButton().setVisible(true);
    	    		
    	    		
    	    		
    	    	}else if(button.equals("Cancel")) {
    	    		A05Listeners.this.invending.subtract(A05Listeners.this.input);
    	    		A05Listeners.this.input.subtract(A05Listeners.this.input);
    	    		A05Listeners.this.cashgiven = 0;
    	    		A05Listeners.this.clearID();
    	    		A05Listeners.this.A.getButton().setVisible(true);
    	    		A05Listeners.this.B.getButton().setVisible(true);
    	    		A05Listeners.this.C.getButton().setVisible(true);
    	    		A05Listeners.this.D.getButton().setVisible(true);
    	    		A05Listeners.this.num1.getButton().setVisible(true);
    	    		A05Listeners.this.num2.getButton().setVisible(true);
    	    		A05Listeners.this.num3.getButton().setVisible(true);
    	    		A05Listeners.this.num4.getButton().setVisible(true);
    	    		A05Listeners.this.Pay.getButton().setVisible(true);
    	    		A05Listeners.this.Credit.getButton().setVisible(false);
    	    		A05Listeners.this.Cash.getButton().setVisible(false);
    	    		A05Listeners.this.twoonies.getButton().setVisible(false);
    	    		A05Listeners.this.nickels.getButton().setVisible(false);
    	    		A05Listeners.this.dimes.getButton().setVisible(false);
    	    		A05Listeners.this.quarters.getButton().setVisible(false);
    	    		A05Listeners.this.loonies.getButton().setVisible(false);
    	    		A05Listeners.this.five.getButton().setVisible(false);
    	    		A05Listeners.this.tens.getButton().setVisible(false);
    	    		A05Listeners.this.done.getButton().setVisible(false);
    	    		
    	    		A05Listeners.this.Pay.getButton().setEnabled(true);
     	    		A05Listeners.this.A.getButton().setEnabled(true);
     	    		A05Listeners.this.B.getButton().setEnabled(true);
     	    		A05Listeners.this.C.getButton().setEnabled(true);
     	    		A05Listeners.this.D.getButton().setEnabled(true);
     	    		A05Listeners.this.num1.getButton().setEnabled(true);
     	    		A05Listeners.this.num2.getButton().setEnabled(true);
     	    		A05Listeners.this.num3.getButton().setEnabled(true);
     	    		A05Listeners.this.num4.getButton().setEnabled(true);
     	    		A05Listeners.this.Credit.getButton().setEnabled(true);
     	    		A05Listeners.this.Cash.getButton().setEnabled(true);
     	    		A05Listeners.this.twoonies.getButton().setEnabled(true);
     	    		A05Listeners.this.nickels.getButton().setEnabled(true);
     	    		A05Listeners.this.dimes.getButton().setEnabled(true);
     	    		A05Listeners.this.quarters.getButton().setEnabled(true);
     	    		A05Listeners.this.loonies.getButton().setEnabled(true);
     	    		A05Listeners.this.five.getButton().setEnabled(true);
     	    		A05Listeners.this.tens.getButton().setEnabled(true);
     	    		A05Listeners.this.done.getButton().setEnabled(true);
    	    		A05Listeners.this.Message.getLabel().setText("Please make a Selection");
    	    		
    	    		
    	    	}else if(button.equals("Pay")) {
    	    		A05Listeners.this.Pay.getButton().setVisible(false);
    	    		A05Listeners.this.A.getButton().setVisible(false);
    	    		A05Listeners.this.B.getButton().setVisible(false);
    	    		A05Listeners.this.C.getButton().setVisible(false);
    	    		A05Listeners.this.D.getButton().setVisible(false);
    	    		A05Listeners.this.num1.getButton().setVisible(false);
    	    		A05Listeners.this.num2.getButton().setVisible(false);
    	    		A05Listeners.this.num3.getButton().setVisible(false);
    	    		A05Listeners.this.num4.getButton().setVisible(false);
    	    		A05Listeners.this.Credit.getButton().setVisible(true);
    	    		A05Listeners.this.Cash.getButton().setVisible(true);
    	    		A05Listeners.this.twoonies.getButton().setVisible(false);
    	    		A05Listeners.this.nickels.getButton().setVisible(false);
    	    		A05Listeners.this.dimes.getButton().setVisible(false);
    	    		A05Listeners.this.quarters.getButton().setVisible(false);
    	    		A05Listeners.this.loonies.getButton().setVisible(false);
    	    		A05Listeners.this.five.getButton().setVisible(false);
    	    		A05Listeners.this.tens.getButton().setVisible(false);
    	    		A05Listeners.this.done.getButton().setVisible(false);
    	    		
    	    		
    	    		
    	    	}else if(button.equals("Credit")) {
    	    		A05Listeners.this.Pay.getButton().setEnabled(false);
    	    		A05Listeners.this.A.getButton().setEnabled(false);
    	    		A05Listeners.this.B.getButton().setEnabled(false);
    	    		A05Listeners.this.C.getButton().setEnabled(false);
    	    		A05Listeners.this.D.getButton().setEnabled(false);
    	    		A05Listeners.this.num1.getButton().setEnabled(false);
    	    		A05Listeners.this.num2.getButton().setEnabled(false);
    	    		A05Listeners.this.num3.getButton().setEnabled(false);
    	    		A05Listeners.this.num4.getButton().setEnabled(false);
    	    		A05Listeners.this.Credit.getButton().setEnabled(false);
    	    		A05Listeners.this.Cash.getButton().setEnabled(false);
    	    		A05Listeners.this.twoonies.getButton().setEnabled(false);
    	    		A05Listeners.this.nickels.getButton().setEnabled(false);
    	    		A05Listeners.this.dimes.getButton().setEnabled(false);
    	    		A05Listeners.this.quarters.getButton().setEnabled(false);
    	    		A05Listeners.this.loonies.getButton().setEnabled(false);
    	    		A05Listeners.this.five.getButton().setEnabled(false);
    	    		A05Listeners.this.tens.getButton().setEnabled(false);
    	    		A05Listeners.this.done.getButton().setEnabled(false);
    	    		
    	    		A05Listeners.this.Message.getLabel().setText("Processing...");
    	            
    	            new Thread() {
    	            	public void run() {
    	            		Random rand = new Random();
		    	            int rand_int1 = rand.nextInt(10); 
		    	    		try {
								Thread.sleep(TimeUnit.SECONDS.toMillis(10));
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
		    	    		if(rand_int1 !=3) {
		    	    			//A05Listeners.this.Message.getLabel().setText("Approved");
		    	    			A05Listeners.this.Message.getLabel().setText( "Payment Accept. Please make a Selection");
		    	    			A05Listeners.this.mine.remove(A05Listeners.this.componentID);
		    	    		}else {
		    	    			//A05Listeners.this.Message.getLabel().setText(" Not approved, Please Make a selection");
		    	    			A05Listeners.this.Message.getLabel().setText("Payment Rejected. Please make a Selection");
		    	    		}
		    	    		A05Listeners.this.Pay.getButton().setEnabled(true);
		     	    		A05Listeners.this.A.getButton().setEnabled(true);
		     	    		A05Listeners.this.B.getButton().setEnabled(true);
		     	    		A05Listeners.this.C.getButton().setEnabled(true);
		     	    		A05Listeners.this.D.getButton().setEnabled(true);
		     	    		A05Listeners.this.num1.getButton().setEnabled(true);
		     	    		A05Listeners.this.num2.getButton().setEnabled(true);
		     	    		A05Listeners.this.num3.getButton().setEnabled(true);
		     	    		A05Listeners.this.num4.getButton().setEnabled(true);
		     	    		A05Listeners.this.Credit.getButton().setEnabled(true);
		     	    		A05Listeners.this.Cash.getButton().setEnabled(true);
		     	    		A05Listeners.this.twoonies.getButton().setEnabled(true);
		     	    		A05Listeners.this.nickels.getButton().setEnabled(true);
		     	    		A05Listeners.this.dimes.getButton().setEnabled(true);
		     	    		A05Listeners.this.quarters.getButton().setEnabled(true);
		     	    		A05Listeners.this.loonies.getButton().setEnabled(true);
		     	    		A05Listeners.this.five.getButton().setEnabled(true);
		     	    		A05Listeners.this.tens.getButton().setEnabled(true);
		     	    		A05Listeners.this.done.getButton().setEnabled(true);
		     	            
		     	    		A05Listeners.this.clearID();
		     	    		A05Listeners.this.A.getButton().setVisible(true);
		    	    		A05Listeners.this.B.getButton().setVisible(true);
		    	    		A05Listeners.this.C.getButton().setVisible(true);
		    	    		A05Listeners.this.D.getButton().setVisible(true);
		    	    		A05Listeners.this.num1.getButton().setVisible(true);
		    	    		A05Listeners.this.num2.getButton().setVisible(true);
		    	    		A05Listeners.this.num3.getButton().setVisible(true);
		    	    		A05Listeners.this.num4.getButton().setVisible(true);
		    	    		A05Listeners.this.Pay.getButton().setVisible(true);
		    	    		A05Listeners.this.Credit.getButton().setVisible(false);
		    	    		A05Listeners.this.Cash.getButton().setVisible(false);
		    	    		A05Listeners.this.twoonies.getButton().setVisible(false);
		    	    		A05Listeners.this.nickels.getButton().setVisible(false);
		    	    		A05Listeners.this.dimes.getButton().setVisible(false);
		    	    		A05Listeners.this.quarters.getButton().setVisible(false);
		    	    		A05Listeners.this.loonies.getButton().setVisible(false);
		    	    		A05Listeners.this.five.getButton().setVisible(false);
		    	    		A05Listeners.this.tens.getButton().setVisible(false);
		    	    		A05Listeners.this.done.getButton().setVisible(false);
		    	    		
    	            }
    	            }.start();
    	    		
    	           
    	    		
    	    		
    	    		
    	    	}else if(button.equals("nickels")) {
    	    		TreeNode spot = A05Listeners.this.mine.retrieve(A05Listeners.this.componentID);
    	    		A05Listeners.this.cashgiven += 0.05;
    	    		A05Listeners.this.cashgiven = Double.parseDouble(f.format(A05Listeners.this.cashgiven));
    	    		A05Listeners.this.invending.setnickles(A05Listeners.this.invending.getnickles()+1);
    	    		A05Listeners.this.input.setnickles(A05Listeners.this.input.getnickles()+1);
    	    		A05Listeners.this.Message.getLabel().setText("The price for "+ spot.getName() + " is $" +String.format("%.2f",spot.getPrice()) +"   $"+String.format("%.2f",A05Listeners.this.cashgiven));
    	    	}else if(button.equals("dimes")) {
    	    		TreeNode spot = A05Listeners.this.mine.retrieve(A05Listeners.this.componentID);
    	    		A05Listeners.this.cashgiven += 0.1;
    	    		A05Listeners.this.cashgiven = Double.parseDouble(f.format(A05Listeners.this.cashgiven));
    	    		A05Listeners.this.invending.setdimes(A05Listeners.this.invending.getdimes()+1);
    	    		A05Listeners.this.input.setdimes(A05Listeners.this.input.getdimes()+1);
    	    		A05Listeners.this.Message.getLabel().setText("The price for "+ spot.getName() + " is $" +String.format("%.2f",spot.getPrice()) +"   $"+String.format("%.2f",A05Listeners.this.cashgiven));
    	    	}else if(button.equals("quarters")) {
    	    		TreeNode spot = A05Listeners.this.mine.retrieve(A05Listeners.this.componentID);
    	    		A05Listeners.this.cashgiven += 0.25;
    	    		A05Listeners.this.cashgiven = Double.parseDouble(f.format(A05Listeners.this.cashgiven));
    	    		A05Listeners.this.invending.setquarters(A05Listeners.this.invending.getquarters()+1);
    	    		A05Listeners.this.input.setquarters(A05Listeners.this.input.getquarters()+1);
    	    		A05Listeners.this.Message.getLabel().setText("The price for "+ spot.getName() + " is $" +String.format("%.2f",spot.getPrice()) +"   $"+String.format("%.2f",A05Listeners.this.cashgiven));
    	    	}else if(button.equals("loonies")) {
    	    		TreeNode spot = A05Listeners.this.mine.retrieve(A05Listeners.this.componentID);
    	    		A05Listeners.this.cashgiven += 1;
    	    		A05Listeners.this.invending.setloonies(A05Listeners.this.invending.getloonies()+1);
    	    		A05Listeners.this.input.setloonies(A05Listeners.this.input.getloonies()+1);
    	    		A05Listeners.this.Message.getLabel().setText("The price for "+ spot.getName() + " is $" +String.format("%.2f",spot.getPrice()) +"    $"+String.format("%.2f",A05Listeners.this.cashgiven));
    	    	}else if(button.equals("twoonies")) {
    	    		TreeNode spot = A05Listeners.this.mine.retrieve(A05Listeners.this.componentID);
    	    		A05Listeners.this.cashgiven += 2;
    	    		A05Listeners.this.invending.settwoonies(A05Listeners.this.invending.gettwoonies()+1);
    	    		A05Listeners.this.input.settwoonies(A05Listeners.this.input.gettwoonies()+1);
    	    		A05Listeners.this.Message.getLabel().setText("The price for "+ spot.getName() + " is $" +String.format("%.2f",spot.getPrice()) +"    $"+String.format("%.2f",A05Listeners.this.cashgiven));
    	    	}else if(button.equals("fivers")) {
    	    		TreeNode spot = A05Listeners.this.mine.retrieve(A05Listeners.this.componentID);
    	    		A05Listeners.this.cashgiven += 5;
    	    		A05Listeners.this.invending.setfivers(A05Listeners.this.invending.getfivers()+1);
    	    		A05Listeners.this.input.setfivers(A05Listeners.this.input.getfivers()+1);
    	    		A05Listeners.this.Message.getLabel().setText("The price for "+ spot.getName() + " is $" +String.format("%.2f",spot.getPrice()) +"    $"+String.format("%.2f",A05Listeners.this.cashgiven));
    	    	}else if(button.equals("teners")) {
    	    		TreeNode spot = A05Listeners.this.mine.retrieve(A05Listeners.this.componentID);
    	    		A05Listeners.this.cashgiven += 10;
    	    		A05Listeners.this.invending.setteners(A05Listeners.this.invending.getteners()+1);
    	    		A05Listeners.this.input.setteners(A05Listeners.this.input.getteners()+1);
    	    		A05Listeners.this.Message.getLabel().setText("The price for "+ spot.getName() + " is $" +String.format("%.2f",spot.getPrice()) +"    $"+String.format("%.2f",A05Listeners.this.cashgiven));
    	    	}
    	    	
    	    	
    	    	
    	    	
    	    	
    	    	
    	    	
    	    }else if(button.length() == 1) {
    	    	A05Listeners.this.addButton(button); 
    	    	if(A05Listeners.this.componentID.length() == 2) {
	    	    	TreeNode spot = A05Listeners.this.mine.retrieve(A05Listeners.this.componentID);
	    	    	
	    	    	if(spot != null && spot.getCount() == 0) {
	    	    		A05Listeners.this.Message.getLabel().setText("We are out of your selection at this moment, Please make another Selection");
	    	    		//JOptionPane.showMessageDialog(null, "We are out of your selection at this moment, Please make another Selection");
	    	    		A05Listeners.this.clearID();
	    	    	}else if(spot == null) {
	    	    		A05Listeners.this.Message.getLabel().setText("Invalid Input, Please make a Selection");
	    	    		//JOptionPane.showMessageDialog(null, "Invalid Input");
	    	    		A05Listeners.this.clearID();
	    	    	}else {
	    	    		A05Listeners.this.Message.getLabel().setText("The price for "+ spot.getName() + " is $" +String.format("%.2f",spot.getPrice()) +"\n Select your Pay to continue");
	    	    		//JOptionPane.showMessageDialog(null, "The price is for "+ spot.getName() + " is $" +String.format(spot.getPrice()) +"\n Select your Payment method");
	    	    		A05Listeners.this.A.getButton().setVisible(false);
	    	    		A05Listeners.this.B.getButton().setVisible(false);
	    	    		A05Listeners.this.C.getButton().setVisible(false);
	    	    		A05Listeners.this.D.getButton().setVisible(false);
	    	    		A05Listeners.this.num1.getButton().setVisible(false);
	    	    		A05Listeners.this.num2.getButton().setVisible(false);
	    	    		A05Listeners.this.num3.getButton().setVisible(false);
	    	    		A05Listeners.this.num4.getButton().setVisible(false);
	    	    		
	    	    		
	    	    		
	    	    	}
	    	    	

    	    	}
    	    }
    	    
    	}	
        }
	
	private void registerbuttonlisteners() {
		A.getButton().addActionListener(new OrderButtonListener("A"));
		B.getButton().addActionListener(new OrderButtonListener("B"));
		C.getButton().addActionListener(new OrderButtonListener("C"));
		D.getButton().addActionListener(new OrderButtonListener("D"));
		num1.getButton().addActionListener(new OrderButtonListener("1"));
		num2.getButton().addActionListener(new OrderButtonListener("2"));
		num3.getButton().addActionListener(new OrderButtonListener("3"));
		num4.getButton().addActionListener(new OrderButtonListener("4"));


		nickels.getButton().addActionListener(new OrderButtonListener("nickels"));
		dimes.getButton().addActionListener(new OrderButtonListener("dimes"));
		quarters.getButton().addActionListener(new OrderButtonListener("quarters"));
		loonies.getButton().addActionListener(new OrderButtonListener("loonies"));
		twoonies.getButton().addActionListener(new OrderButtonListener("twoonies"));
		five.getButton().addActionListener(new OrderButtonListener("fivers"));
		tens.getButton().addActionListener(new OrderButtonListener("teners"));
		
		Cancel.getButton().addActionListener(new OrderButtonListener("Cancel"));
		Pay.getButton().addActionListener(new OrderButtonListener("Pay"));
		Cash.getButton().addActionListener(new OrderButtonListener("Cash"));
		Credit.getButton().addActionListener(new OrderButtonListener("Credit"));
		done.getButton().addActionListener(new OrderButtonListener("Done"));
	}
	
	/*
	 * Levelorder - B3,A4,C3,A2,B2,C1,D1,A1,A3,B1,B4,C2,C4,D3,D2,D4
	 * 
	 */
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public A05Listeners(String arg) {//DO NOT modify this line
		componentID = arg;//DO NOT modify this line
		this.cashgiven = 0;
		this.pop();
		this.registerbuttonlisteners();

		
		
		
		//you can perform additional actions here.
	}
	

//you can add/override additional methods here.
    
    
    //Converts change into coins depending on invending
    private change remining(double change, change invending) {
    	change remaining = new change(0, 0, 0,0,0,0,0);
    	
    	int add = invending.getteners() -(int)Math.floor(change/10);
    	if(add >= 0) {
    		add = (int)Math.floor(change/10);
    	}else {
    		add = invending.getteners();
    	}
		remaining.setteners(remaining.getteners() + add);
		
		change = change - 10*add;
		
		
		
		add = invending.getfivers() -(int)Math.floor(change/5);
    	if(add >= 0) {
    		add = (int)Math.floor(change/5);
    	}else {
    		add = invending.getfivers();
    	}
		remaining.setfivers(remaining.getfivers() + add);
		change = change - 5*add;
		
		add = invending.gettwoonies() -(int)Math.floor(change/2);
    	if(add >= 0) {
    		add = (int)Math.floor(change/2);
    	}else {
    		add = invending.gettwoonies();
    	}
		remaining.settwoonies(remaining.gettwoonies() + add);
		change = change - 2*add;
		
		add = invending.getloonies() -(int)Math.floor(change);
    	if(add >= 0) {
    		add = (int)Math.floor(change);
    	}else {
    		add = invending.getloonies();
    	}
		remaining.setloonies(remaining.getloonies() + add);
		change = change - add;
		
		
		
		add = invending.getquarters() -(int)Math.floor(change/0.25);
    	if(add >= 0) {
    		add = (int)Math.floor(change/0.25);
    		if(invending.getnickles()==0) {
    			add--;
    		}
    	}else {
    		add = invending.getquarters();
    		if(invending.getnickles()==0) {
    			add--;
    		}
    	}
		remaining.setquarters(remaining.getquarters() + add);
		change = change - 0.25*add;
		
		
    	add = invending.getdimes() -(int)Math.floor(change/0.1);
    	if(add >= 0) {
    		add = (int)Math.floor(change/0.10);
    	}else {
    		add = invending.getdimes();
    	}
		remaining.setdimes(remaining.getdimes() + add);
		change = change - 0.1*add;
		
		add = invending.getnickles() -(int)Math.floor(change/0.05);
    	if(add >= 0) {
    		add = (int)Math.floor(change/0.05);
    	}else {
    		add = invending.getnickles();
    	}
		remaining.setnickles(remaining.getnickles() + add);
		change = change - add;
		
		
		if(change != 0) {
			remaining = null;
		}
		
		return remaining;
    
    }
	   
    
    
    
    
    private class change{
    	public int nickles = 0;
    	public int dimes = 0;
    	public int quarters = 0;
    	public int loonies = 0;
    	public int twoonies = 0;
    	public int fivers = 0;
    	public int teners = 0;
    	public change(int nickles, int dimes, int quarters, int loonies, int twoonies, int fivers, int teners) {
    		this.nickles = nickles;
    		this.dimes = dimes;
    		this.quarters = quarters;
    		this.loonies = loonies;
    		this.twoonies = twoonies;
    		this.fivers = fivers;
    		this.teners = teners;
    	}
    	
    	private void setnickles(int newn) {
    		this.nickles = newn;
    	}
    	private void setdimes(int newn) {
    		this.dimes = newn;
    	}
    	private void setquarters(int newn) {
    		this.quarters = newn;
    	}
    	private  void setloonies(int newn) {
    		this.loonies = newn;
    	}
    	private  void settwoonies(int newn) {
    		this.twoonies = newn;
    	}
    	private  void setfivers(int newn) {
    		this.fivers = newn;
    	}
    	private void setteners(int newn) {
    		this.teners = newn;
    	}
    	private int getnickles() {
    		return this.nickles;
    	}
    	private int getdimes() {
    		return this.dimes;
    	}
    	private  int getquarters() {
    		return this.quarters ;
    	}
    	private  int getloonies() {
    		return this.loonies;
    	}
    	private int gettwoonies() {
    		return this.twoonies ;
    	}
    	private int getfivers() {
    		return this.fivers;
    	}
    	private int getteners() {
    		return this.teners ;
    	}
    	private void subtract(change that) {
    		this.nickles -= that.nickles;
    		this.dimes -= that.dimes;
    		this.quarters -= that.quarters;
    		this.loonies -= that.loonies;
    		this.twoonies -= that.twoonies;
    		this.fivers -= that.fivers;
    		this.teners -= that.teners;
    	}
    	public String toString() {
    		String out =  this.getteners()+ " ten dolloars; "+ this.getfivers() +
					" five dollars; "+ this.gettwoonies() + " twoonies; " + this.getloonies() + " loonies; "+ this.getquarters() + " quarters; " +
					this.getdimes() + " dimes; "+ this.getnickles()+ " nickels";
    		return out;
    	}
    	

    }
	
	private class TreeNode {

	    // The T data and count.
	    private String ID=  null;
	    private double price;
	    private String name;
	    private int count = 1;
	    // Link to the child TreeNodes.
	    private TreeNode left = null;
	    private TreeNode right = null;
	    private int height = 1;


	    
	    /**
	     * Creates a new TreeNode with data and null links to its child TreeNodes.
	     * Not copy safe as it accepts a reference to the data rather than a copy of
	     * the data.
	     *
	     * @param data
	     *            The data to store in the node.
	     */
	    public TreeNode(final String ID, final String name, final double price) {
		this.ID = ID;
		this.name = name;
		this.price = price;
	    }

	    /**
	     * Decrements the data count of this TreeNode by 1.
	     */
	    public void decrementCount() {
		this.count--;
	    }

	    /**
	     * Returns the data count of this TreeNode.
	     *
	     * @return count.
	     */
	    public int getCount() {
		return this.count;
	    }

	    /**
	     * Returns this TreeNode data. Not copy safe as it returns a reference to
	     * the data, not a copy of the data.
	     *
	     * @return The data portion of this TreeNode.
	     */
	    public String getName() {
		return this.name;
	    }
	    public double getPrice() {
			return this.price;
		    }
	    public String getID() {
			return this.ID;
		    }
	    /**
	     * Returns the height of this TreeNode.
	     *
	     * @return height.
	     */
	    

	    /**
	     * Returns the left child of this TreeNode.
	     *
	     * @return left.
	     */
	    public TreeNode getLeft() {
		return this.left;
	    }

	    /**
	     * Returns the right child of this TreeNode.
	     *
	     * @return right.
	     */
	    public TreeNode getRight() {
		return this.right;
	    }

	    /**
	     * Increments the data count of this TreeNode by 1.
	     */
	    public void incrementCount() {
		this.count++;
	    }

	    /**
	     * Updates the left child reference of this TreeNode to another TreeNode.
	     *
	     * @param left
	     *            The new TreeNode to link to.
	     */
	    public void setLeft(final TreeNode left) {
		this.left = left;
	    }

	    /**
	     * Updates the right child reference of this TreeNode to another TreeNode.
	     *
	     * @param right
	     *            The new TreeNode to link to.
	     */
	    public void setRight(final TreeNode right) {
		this.right = right;
	    }

	    
	    public String toString() {
		return "ID -" + this.ID + "Name - " + this.name;
	    }

	    /**
	     * Updates the height of this TreeNode to 1 plus the maximum heights of its
	     * two child nodes. Empty child nodes have a height of 0.
	     */
	    public void updateHeight() {
		int leftHeight = 0;
		int rightHeight = 0;

		if (this.left != null) {
		    leftHeight = this.left.height;
		}
		if (this.right != null) {
		    rightHeight = this.right.height;
		}
		this.height = Math.max(leftHeight, rightHeight) + 1;
		return;
	    }
	    
	   

	}
	
	private class BST {

		
		// Attributes.
		protected TreeNode root = null;
		
		
		
		public void insert(final String ID, final String name, final double price) {

			 insert_aux(this.root, ID, name, price);

			return;
		}

		public ins insert_aux(TreeNode node, final String ID, final String name, final double price) {
			boolean inserted = false;
			ins ans = null;

			if (node == null) {
				// Base case: add a new node containing the value.
				node = new TreeNode(ID ,name , price);

				if (this.root == null) {
					this.root = node;
				}

				inserted = true;

			}

			else if (node.getID().compareTo(ID)> 0) {
				// General case: check the left subtree.

				// System.out.println(node + " "+ node.getLeft());
				ans = insert_aux(node.getLeft(), ID, name , price);
				inserted = ans.inserted;
				node.setLeft(ans.node);
			}

			else if (node.getID().compareTo(ID)< 0) {
				// General case: check the right subtree.

				ans = insert_aux(node.getRight(), ID, name, price);
				inserted = ans.inserted;
				node.setRight(ans.node);
			}

			else {

				// Base case: value is already in the BST.
				inserted = false;
				node.incrementCount();

			}
			if (inserted) {
				// Update the node height if any of its children have been changed.
				node.updateHeight();
			}
			ans = new ins(node, inserted);

			return ans;

		}
		public boolean remove(final String key) {
			TreeNode node = this.root;
			boolean removed;

			while (node.getID().compareTo(key) != 0) {
				
				if (node.getID().compareTo(key) > 0) {
					node = node.getLeft();
				} else  {
					node = node.getRight();
				} 

			}
			if(node.getCount() == 0) {
				removed = false;
			}else {
				node.decrementCount();
				removed = true;
			}
			
			// your code here
			return removed;
			
		}
		public TreeNode retrieve(final String key) {
			TreeNode node = this.root;

			while (node!= null && node.getID().compareTo(key) != 0) {
				
				if (node.getID().compareTo(key) > 0) {
					
					node = node.getLeft();
				} else  {
					
					node = node.getRight();
				} 

			}
			
			// your code here
			return node;
		}
		class ins {
			TreeNode node;
			boolean inserted;

			public ins(TreeNode node, boolean inserted) {
				this.node = node;
				this.inserted = inserted;
			}
		}
		public void populatetree() {
			
				this.insert("B3", "Kitkat", 2.00);

				this.insert("A4", "Ruffles OG" , 2.00);
			 
				this.insert("C3", "Excel", 2.00);
			 
				this.insert("A2", "Doritos", 2.50);
			 
				this.insert("B2", "Mars", 2.00);
			
				this.insert("C1", "Snickers", 2.00);

				this.insert("D1", "Juicy Fruit", 2.00);
			 
				this.insert("A1", "Lays ", 2.50);
			 
				this.insert("A3", "Miss Vickies", 3.00);
			 
				this.insert("B1", "Twix", 1.50);
			 
				this.insert("B4", "Aero", 1.50);
			 
				this.insert("C2", "Oh Henry!", 1.50);
			 
				this.insert("C4", "Dentyne", 2.00);
			 
				this.insert("D3", "Trident", 2.00);
			 
				this.insert("D2", "Bubble Gum", 2.500);
			 
				this.insert("D4", "Sour Patches", 3.00);
			
			
			
		}
	}
}
