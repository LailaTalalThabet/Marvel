package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class TargetExceptionView extends JFrame implements ActionListener {

	JButton Ok=new JButton("OK");
	JLabel l=new JLabel("You can't cast this ability on this target");
	
	public TargetExceptionView() {
		this.setBounds(600, 200, 200, 100);
		this.add(l,BorderLayout.NORTH);
		this.add(Ok,BorderLayout.SOUTH);
		Ok.addActionListener(this);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		validate();
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==Ok)
			this.dispose();
		
	}

}
