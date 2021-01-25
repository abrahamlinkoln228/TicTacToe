package Main;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Wind implements ActionListener{
	JFrame f=new JFrame();
	JButton b1=new JButton("");
	JButton b2=new JButton("");
	JButton b3=new JButton("");
	JButton b4=new JButton("");
	JButton b5=new JButton("");
	JButton b6=new JButton("");
	JButton b7=new JButton("");
	JButton b8=new JButton("");
	JButton b9=new JButton("");
	
	JButton[] btns = {b1,b2,b3,b4,b5,b6,b7,b8,b9};
	
	public Wind(){
	
	f.add(b1);f.add(b2);f.add(b3);f.add(b4);f.add(b5);
	f.add(b6);f.add(b7);f.add(b8);f.add(b9);
	f.setLayout(new GridLayout(3,3,2,2));
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	f.setSize(300,300);
	f.setVisible(true);
	
	for(JButton b : btns){
	            b.addActionListener(this);
	    }
	}
	
	public static JButton[] newrow(JButton[] btns, int id){
		
		JButton[] newArr = new JButton[btns.length - 1];
	
        for(int j=0, k=0; j<btns.length; j++) {
            if(j == id)
                continue;
            newArr[k++] = btns[j];
        }
		
		
		return newArr;	
	}
	

	public void actionPerformed(ActionEvent e){
		if(btns.length != 0) {
			JButton b = (JButton) e.getSource();
			b.setText("X");
			int id = Arrays.asList(btns).indexOf(b);
	        btns = newrow(btns,id);
	        try {
		        int rnd = new Random().nextInt(btns.length);
	        
	        btns[rnd].setText("0");
	        btns = newrow(btns, rnd);
	        System.out.println(btns.length);
	        } catch(Exception ee) {
	        	System.out.println("Something is horribly wrong");
	        }
		} else {
	        	System.out.println("The game is over");
		}
}

}
