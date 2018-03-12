import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import java.awt.event.KeyEvent;



//Application frame
public class DrawingFrame extends JFrame{
	
	//the draw panel
	private DrawPanel pnlDraw;
	
	//menu items
	private JMenuItem miLoad, miSave, miExit, miAbout;
	
	
	public DrawingFrame() {
		//dadd draw panel
		pnlDraw = new DrawPanel();
		add(pnlDraw);
		
		//set menu bar
		setUpMenuBar();
		
		setTitle("Drawing Tool v1.0");
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	//sets menu bar
	private void setUpMenuBar(){
		JMenuBar menuBar = new JMenuBar();
		
		//file menu
		JMenu menuFile = new JMenu("File");
		menuFile.setMnemonic(KeyEvent.VK_F);
		
		//menu items
		miLoad = new JMenuItem("Load from text file", new ImageIcon("load.png"));
		miSave = new JMenuItem("Save As",  new ImageIcon("save.png"));
		miExit = new JMenuItem("Exit", new ImageIcon("exit.png"));
		
		//shorcuts
		miLoad.setMnemonic(KeyEvent.VK_O);
		miSave.setMnemonic(KeyEvent.VK_S);
		miExit.setMnemonic(KeyEvent.VK_X);
		
		menuFile.add(miLoad);
		menuFile.add(miSave);
		menuFile.addSeparator();
		menuFile.add(miExit);
		
		menuBar.add(menuFile);
		
		//help menu
		JMenu menuHelp = new JMenu("Help");
		menuHelp.setMnemonic(KeyEvent.VK_H);
		
		miAbout = new JMenuItem("About", new ImageIcon("about.png"));
		miAbout.setMnemonic(KeyEvent.VK_A);
		menuHelp.add(miAbout);
		
		menuBar.add(menuHelp);
		
		setJMenuBar(menuBar);
		
		//load
		miLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser(".");
				if(fileChooser.showOpenDialog(DrawingFrame.this) == JFileChooser.APPROVE_OPTION){
					pnlDraw.reset();
					pnlDraw.loadInstructions(fileChooser.getSelectedFile());
				}
			}
		});
		
		//save
		miSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(DrawingFrame.this, "To save the file as image, add an extension .png or .jpg ");
				JFileChooser fileChooser = new JFileChooser(".");
				if(fileChooser.showSaveDialog(DrawingFrame.this) == JFileChooser.APPROVE_OPTION){
					pnlDraw.saveImage(fileChooser.getSelectedFile());
				}
			}
		});
		
		//exit
		miExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		//about
		miAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(DrawingFrame.this, "Drawing Tool v1.0\nDeveloped by Artur Partyka. Student ID: 3469557.  ");
				JOptionPane.showMessageDialog(DrawingFrame.this, "How to Use: To open an instruction use 'File' and 'Load from text file' and open the text file. The instruction will write on the panel on the right. You can save the drawing by using 'File' and 'Save As'. Make sure to save it as .PNG or .JPEG for an image.   ");
			}
		});
	}
}
