import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

//Represnts the board used for drawing
public class DrawingBoard extends JPanel {

	//reference to list of instructions
	private ArrayList<Instruction> instructions;
	private Point penPos;

	//drawing board
	public DrawingBoard(ArrayList<Instruction> instructions) {
		setBackground(Color.GRAY); //start with gray back ground
		this.instructions = instructions;
		penPos = new Point(0, 0);
	}

	//reset drawing board
	public void reset() {
		repaint();
		penPos.setLocation(0, 0);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		//for each instruction
		for (Instruction instruction : instructions) {
			if (instruction instanceof InvalidInstruction) //invalid instructions are not executed
				continue;

			//execute
			instruction.execute(g, penPos);
			if (instruction instanceof InstructionClear)
				super.paintComponent(g);
		}
	}

	//save image
	public void saveImage(File file) {
		BufferedImage image = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_ARGB);
		Graphics g = image.getGraphics();
		this.paint(g);
		try {
			ImageIO.write(image, "png", file);
		} catch (Exception ex) {

		}
	}
}
