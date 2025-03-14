// Demonstrate JComboBox. 
import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*; 
   
public class Gallery implements ActionListener{ 
  
  String timepieces[] = { "locate", "analog", "digital", "stopwatch" }; 
  int index = 0;
  JLabel jlab;
 
  public Gallery() { 
 
    // Set up the JFrame.
    JFrame jfrm = new JFrame("Gallery");
    jfrm.setLayout(new FlowLayout());
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jfrm.setSize(400, 250); 

 
    jlab = new JLabel(new ImageIcon(timepieces[index] + ".png")); 
    jfrm.add(jlab); 

    JButton next = new JButton("Next");
    next.setActionCommand("next");
    next.addActionListener(this);
    
    JButton previous = new JButton("Previous");
    previous.setActionCommand("previous");
    previous.addActionListener(this);
    
    jfrm.add(next);
    jfrm.add(previous);
 

    // Display the frame.
    jfrm.setVisible(true);
  }
  
  public void actionPerformed(ActionEvent ae) {
    if(ae.getActionCommand().equals("next")){
        index = index == 3 ? 0 : index + 1;
        jlab.setIcon(new ImageIcon(timepieces[index] + ".png"));
    }else{
        index = index == 0 ? 3 : index - 1;
        jlab.setIcon(new ImageIcon(timepieces[index] + ".png"));
    }
  }

  public static void main(String[] args) { 

    // Create the frame on the event dispatching thread.
    SwingUtilities.invokeLater( 
      new Runnable() { 
        public void run() { 
          new Gallery(); 
        } 
      } 
    ); 
  }
}

