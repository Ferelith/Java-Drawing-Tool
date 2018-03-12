import java.awt.Point;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import java.awt.Graphics;

//Circle
public class InstructionCircle extends Instruction{

	//radius
	protected int r;

	public InstructionCircle(String instruction) {
		super(instruction);
		//open scanner
		try(Scanner scanner = new Scanner(instruction);){
			scanner.next();
			
			//read radius
			r = scanner.nextInt();
			
			//if more arguments left
			if(scanner.hasNext())
				throw new RuntimeException("Invalid number of arguments");
			
			if(r <= 0)
				throw new RuntimeException("Radius cannot be negative or 0.");
			
			scanner.close();
		}catch(InputMismatchException e){
			throw new RuntimeException("Invalid argument type.");
		}catch(NoSuchElementException e){
			throw new RuntimeException("Invalid number of arguments");
		}
	}

	@Override
	public void execute(Graphics g, Point penPos) {
		g.drawOval(penPos.x - r, penPos.y - r, r*2, r*2);
		
	}
	
	
	
}
