import java.awt.Point;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import java.awt.Graphics;

//Draw line
public class InstructionLine extends Instruction{

	private int x,y;
	
	public InstructionLine(String instruction) {
		super(instruction);
		
		
		try(Scanner scanner = new Scanner(instruction);){
			scanner.next();
			x = scanner.nextInt();
			y = scanner.nextInt();
			
			if(scanner.hasNext())
				throw new RuntimeException("Invalid number of arguments");
			
			scanner.close();
		}catch(InputMismatchException e){
			throw new RuntimeException("Invalid argument type.");
		}catch(NoSuchElementException e){
			throw new RuntimeException("Invalid number of arguments");
		}
	}

	@Override
	public void execute(Graphics g, Point penPos) {
		g.drawLine(penPos.x, penPos.y, x, y);
		penPos.x = x;
		penPos.y = y;
		
	}
	
	

	
}
