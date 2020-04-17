/**
 * 
 */
package cp213;
import javax.swing.JButton;
import javax.swing.JLabel;
/**
 * @author einsteinoyewole
 *
 */
public class A05Labels extends JLabel{
	private JLabel lab;
	public A05Labels(final String s) {
		this.lab = new JLabel(s);
	}
	public JLabel getLabel() {
		return this.lab;
	}

}
