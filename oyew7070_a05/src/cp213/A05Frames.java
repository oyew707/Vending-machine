/**
 * 
 */
package cp213;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 * @author einsteinoyewole
 *
 */
public class A05Frames extends JPanel {
	static A05Listeners buttins = new A05Listeners("");
	private JFrame f = new JFrame();


	 public A05Frames() {
		OneView view = new OneView(buttins);
		f.setContentPane(view);
		f.setSize(1500, 1600);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(false);
		
		}
	 public void setVisible(boolean aFlag) {
		 f.setVisible(aFlag);
	 }

	
	 

	 
	
}





@SuppressWarnings("serial")
class Buttonview extends JPanel{
	
	public Buttonview(final A05Listeners HABIBY) {
		//A05Listeners n = new A05Listeners("");
		this.layout(HABIBY);
	}
public void layout(A05Listeners list) {
	this.setLayout(new GridLayout(6,4));
	this.add(list.num1.getButton());
	this.add(list.num2.getButton());
	this.add(list.num3.getButton());
	this.add(list.num4.getButton());

	this.add(list.A.getButton());
	this.add(list.B.getButton());
	this.add(list.C.getButton());
	this.add(list.D.getButton());
	
	this.add(list.Cash.getButton()).setVisible(false);
	this.add(list.Cancel.getButton()).setVisible(true);;
	this.add(list.Pay.getButton()).setVisible(true);;
	this.add(list.Credit.getButton()).setVisible(false);
	
	this.add(new A05Labels("").getLabel());
	this.add(new A05Labels("").getLabel());
	this.add(new A05Labels("").getLabel());
	this.add(new A05Labels("").getLabel());
	
	this.add(list.nickels.getButton()).setVisible(false);
	this.add(list.dimes.getButton()).setVisible(false);
	this.add(list.quarters.getButton()).setVisible(false);
	this.add(list.loonies.getButton()).setVisible(false);
	
	this.add(list.twoonies.getButton()).setVisible(false);
	this.add(list.five.getButton()).setVisible(false);
	this.add(list.tens.getButton()).setVisible(false);
	this.add(list.done.getButton()).setVisible(false);
	
	
	
	
}
}
class MessageView extends JPanel{
	A05Labels message;
	public MessageView(A05Listeners buttins) {
		this.message = buttins.Message;
		this.layoutView();
	}
	
	private void layoutView() {
		this.setLayout(new GridLayout(1,1));
		message.getLabel().setFont(new Font("Serif", Font.PLAIN, 40));
		this.add(message.getLabel());
		
	}
}




class Vendingview extends JPanel{
	
	public Vendingview(final A05Listeners HABIBY) {
		//A05Listeners n = new A05Listeners("");
		this.layout(HABIBY);
	}
public void layout(A05Listeners list) {
	
	
	this.setLayout(new GridLayout(8,4));
	this.add(new A05Labels("Lays Classic").getLabel());
	this.add(new A05Labels("Doritos Hot").getLabel());
	this.add(new A05Labels("Miss Vickies OG").getLabel());
	this.add(new A05Labels("Ruffles OG").getLabel());



	this.add(new A05Labels("A1").getLabel());
	this.add(new A05Labels("A2").getLabel());
	this.add(new A05Labels("A3").getLabel());
	this.add(new A05Labels("A4").getLabel());



	this.add(new A05Labels("Twix").getLabel());
	this.add(new A05Labels("Mars").getLabel());
	this.add(new A05Labels("Kitkat").getLabel());
	this.add(new A05Labels("Aero").getLabel());



	this.add(new A05Labels("B1").getLabel());
	this.add(new A05Labels("B2").getLabel());
	this.add(new A05Labels("B3").getLabel());
	this.add(new A05Labels("B4").getLabel());

	this.add(new A05Labels("Snickers").getLabel());
	this.add(new A05Labels("Oh Henry!").getLabel());
	this.add(new A05Labels("Excel ").getLabel());
	this.add(new A05Labels("Dentyne").getLabel());



	this.add(new A05Labels("C1").getLabel());
	this.add(new A05Labels("C2").getLabel());
	this.add(new A05Labels("C3").getLabel());
	this.add(new A05Labels("C4").getLabel());

	this.add(new A05Labels("Juicy Fruit").getLabel());
	this.add(new A05Labels("Bubble Gum").getLabel());
	this.add(new A05Labels( "Trident").getLabel());
	this.add(new A05Labels("Sour Patches").getLabel());

	this.add(new A05Labels("D1").getLabel());
	this.add(new A05Labels("D2").getLabel());
	this.add(new A05Labels("D3").getLabel());
	this.add(new A05Labels("D4").getLabel());




}
}

class OneView extends JPanel{
	public Buttonview kView = null;
	public MessageView vView = null;
	public Vendingview dView = null;
	public OneView(final A05Listeners model ) {
		this.kView = new Buttonview(model);
		this.vView = new MessageView(model);
		this.dView = new Vendingview(model);
		this.layoutView();
	}
	 private void layoutView() {
			this.setLayout(new BorderLayout(100,100));
			this.add(this.dView, BorderLayout.WEST);
			
			this.add(this.kView, BorderLayout.EAST);
			Border border = BorderFactory.createLineBorder(Color.BLACK, 3);
			 
	        // set the border of this component
	        this.dView.setBorder(border);
	        this.vView.setBorder(border);
			this.add(this.vView, BorderLayout.PAGE_START);
			
		    }
}

