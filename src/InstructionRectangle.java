import java.awt.Graphics;
import java.awt.Point;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

//RECTANGLE width height
//e.g RECTANGLE 100 200
public class InstructionRectangle extends Instruction{

	private int width, height;
	
	public InstructionRectangle(String instruction) {
		super(instruction);
		try(Scanner scanner = new Scanner(instruction);){
			scanner.next();
			width = scanner.nextInt();
			height = scanner.nextInt();
			
			if(scanner.hasNext())
				throw new RuntimeException("Invalid number of arguments");
			
			if(width <= 0 || height <= 0)
				throw new RuntimeException("Invalid width or height.");
			
			scanner.close();
		}catch(InputMismatchException e){
			throw new RuntimeException("Invalid argument type.");
		}catch(NoSuchElementException e){
			throw new RuntimeException("Invalid number of arguments");
		}
	}

	@Override
	public void execute(Graphics g, Point penPos) {
		g.drawRect(penPos.x, penPos.y, width, height);
		
	}
}
