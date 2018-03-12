import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class InstructionColour extends Instruction{
	//r,g,b components
	private int r,g,b;

	public InstructionColour(String instruction) {
		super(instruction);
		try(Scanner scanner = new Scanner(instruction);){
			scanner.next();
			//read r g b
			r = scanner.nextInt();
			g = scanner.nextInt();
			b = scanner.nextInt();
			
			if(scanner.hasNext())
				throw new RuntimeException("Invalid number of arguments");
			
			if(r < 0 || r > 255 || g < 0 || g > 255 || b < 0 || b > 255)
				throw new RuntimeException("Invalid RGB values.");
			
			scanner.close();
		}catch(InputMismatchException e){
			throw new RuntimeException("Invalid argument type.");
		}catch(NoSuchElementException e){
			throw new RuntimeException("Invalid number of arguments");
		}
		
	}

	@Override
	public void execute(Graphics g, Point penPos) {
		g.setColor(new Color(r, this.g, b));
		
	}

	
	
	
}
