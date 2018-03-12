import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

//Panel consisting of drawing board and instructions
public class DrawPanel extends JPanel{

	private static final int WIDTH = 900, HEIGHT = 600;
	
	private ArrayList<Instruction> instructions;
	private JTextArea taInstructions;
	private DrawingBoard drawPanel;

	//creates the panel
	public DrawPanel() {
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setLayout(new BorderLayout());
		
		instructions = new ArrayList<>();
		
		taInstructions = new JTextArea(10,50);
		taInstructions.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
		taInstructions.setEditable(false);
		
		drawPanel = new DrawingBoard(instructions);
		drawPanel.setMinimumSize(new Dimension(WIDTH, HEIGHT));
		drawPanel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		add(taInstructions, BorderLayout.WEST);
		add(drawPanel);
	}
	
	//reset
	public void reset(){
		instructions.clear();
		taInstructions.setText("");
		drawPanel.reset();
	}
	
	//load instructions in arraylist
	public void loadInstructions(File file){
		try (Scanner fileScanner = new Scanner(file);){

			while(fileScanner.hasNextLine()){
				String instruction = fileScanner.nextLine();
				Scanner lineScanner = new Scanner(instruction);
				String instructionCode = lineScanner.next();
				Instruction obj;
				try{
					//instructiosn already given in assignment
					if(instructionCode.equals("MOVE"))
						obj = new InstructionMove(instruction);
					else if(instructionCode.equals("LINE"))
						obj = new InstructionLine(instruction);
					else if(instructionCode.equals("CIRCLE"))
						obj = new InstructionCircle(instruction);
					else if(instructionCode.equals("SOLID_CIRCLE"))
						obj = new InstructionSolidCircle(instruction);
					else if(instructionCode.equals("CLEAR"))
						obj = new InstructionClear(instruction);
					else if(instructionCode.equals("COLOUR"))
						obj = new InstructionColour(instruction);
					else if(instructionCode.equals("TEXT"))
						obj = new InstructionText(instruction);
					
					//Instructions for Requirement 4
					else if(instructionCode.equals("FONT_SIZE"))
						obj = new InstructionFontSize(instruction);
					else if(instructionCode.equals("FONT_STYLE"))
						obj = new InstructionFontStyle(instruction);
					else if(instructionCode.equals("RECTANGLE"))
						obj = new InstructionRectangle(instruction);
					else if(instructionCode.equals("SQUARE"))
						obj = new InstructionSquare(instruction);
					else if(instructionCode.equals("STROKE_WIDTH"))
						obj = new InstructionStrokeWidth(instruction);
					
					//if not supported
					else 
						obj = new InvalidInstruction(instruction, "Instruction not supported");
				}catch(Exception e){ //if exception thrown
					obj = new InvalidInstruction(instruction, e.getMessage());
				}
				
				instructions.add(obj);
				lineScanner.close();
				
			}
			
			//show instructiosn in text field
			for (Instruction instruction : instructions) {
				taInstructions.append(instruction.toString()+"\n");
			}
			
			//draw panel
			drawPanel.repaint();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//save image to file
	public void saveImage(File file){
		drawPanel.saveImage(file);
	}
	
}
