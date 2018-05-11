package Killerproto;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Graphics {
	
	private WareHouse map;
	private Game game;
	
	public Graphics(Game g) {
		game=g;
		map=g.getwh();
		
	}
	
	
	public void showMenu() {
		JFrame menu=new JFrame();
		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menu.setPreferredSize(new Dimension(300,300));
		menu.setVisible(true);
		JPanel p=new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		
		JLabel label=new JLabel();
		label.setText("KillerSokoban");				
		p.add(Box.createRigidArea(new Dimension(0, 10)));
		p.add(label,BorderLayout.NORTH);
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		label.setFont(new Font("Arial",Font.PLAIN,20));
		
		p.add(Box.createRigidArea(new Dimension(0, 40)));
		JButton newGame=new JButton("New Game");
		p.add(newGame,BorderLayout.SOUTH);		
		newGame.setAlignmentX(Component.CENTER_ALIGNMENT);
		newGame.addActionListener(new NewGameListener());
		
		JButton exit=new JButton("Exit");
		p.add(Box.createRigidArea(new Dimension(0, 30)));
		p.add(exit,BorderLayout.SOUTH);
		exit.setAlignmentX(Component.CENTER_ALIGNMENT);
		exit.addActionListener(new CloseListener());
		
		JButton help=new JButton("Help");
		p.add(Box.createRigidArea(new Dimension(0, 30)));
		p.add(help,BorderLayout.SOUTH);
		help.setAlignmentX(Component.CENTER_ALIGNMENT);		
		
		p.add(Box.createHorizontalGlue());		
		menu.add(p);
		menu.pack();
	}



	
	private class NewGameListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			game.NewGame();
		}
	}
	
	private class CloseListener implements ActionListener{	  
	    public void actionPerformed(ActionEvent e) {	        
	       // System.exit(0);
	    	JFrame jf= (JFrame) SwingUtilities.getRoot((Component)e.getSource());
			jf.setVisible(false);
	    	endFrame();
	    }
	}
	
	public void endFrame() {
		JFrame end=new JFrame();
		end.setLayout(new BorderLayout());
		end.setVisible(true);
		end.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		end.setPreferredSize(new Dimension(300,300));
		
		JPanel p=new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		
		p.add(Box.createRigidArea(new Dimension(0, 10)));
		JLabel over=new JLabel();
		over.setText("The game is over");
		over.setFont(new Font("Arial",Font.PLAIN,20));
		over.setAlignmentX(Component.CENTER_ALIGNMENT);
		p.add(over,BorderLayout.NORTH );
		
		
		JPanel scores=new JPanel();
		scores.setLayout(new GridLayout(2,2));
		
		JLabel p1=new JLabel();
		p1.setText("player1 score");
		scores.add(p1);
		
		
		JPanel p1p=new JPanel();
		JTextField p1tb=new JTextField();
		p1tb.setText("0");
		p1tb.setPreferredSize(new Dimension(100,30));
		p1tb.setEnabled(false);
		p1p.setLayout(new BorderLayout());		
		p1p.add(p1tb,BorderLayout.CENTER);
		scores.add(p1p,BorderLayout.CENTER);
		
		
		JLabel p2=new JLabel();
		p2.setText("player2 score");
		scores.add(p2);
		
		JTextField p2tb=new JTextField();
		p2tb.setText("0");
		p2tb.setPreferredSize(new Dimension(20,100));
		p2tb.setEnabled(false);
		scores.add(p2tb,BorderLayout.EAST);
		
		end.add(p,BorderLayout.NORTH);
		end.add(scores,BorderLayout.LINE_START);
	
		
		end.pack();
		
	}
	
	
	public void showMap() {
		JFrame mainFrame=new JFrame();
		mainFrame.setPreferredSize(new Dimension(map.getS()*50,map.getS()*50));
		JPanel pane=new JPanel();
		pane.setLayout(new GridLayout(map.getS(),map.getS()));
		for(int i=0;i<map.getS();i++) {
			for(int j=0;j<map.getS();j++) {
				pane.add(map.map[i][j]);
			}
		}
		mainFrame.add(pane);
		mainFrame.setVisible(true);
		mainFrame.pack();
		
	}
	
	WareHouse readMap() {
		return null;
	}

}
