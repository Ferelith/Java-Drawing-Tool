import java.awt.Graphics;
import java.awt.Point;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
//SQUARE side
//e.g SQUARE 15
public class InstructionSquare extends Instruction{

	private int side;
	
	public InstructionSquare(String instruction) {
		super(instruction);
		try(Scanner scanner = new Scanner(instruction);){
			scanner.next();
			side = scanner.nextInt();
			
			
			if(scanner.hasNext())
				throw new RuntimeException("Invalid number of arguments");
			
			if(side < 0)
				throw new RuntimeException("Invalid side length.");
			
			scanner.close();
		}catch(InputMismatchException e){
			throw new RuntimeException("Invalid argument type.");
		}catch(NoSuchElementException e){
			throw new RuntimeException("Invalid number of arguments");
		}
	}

	@Override
	public void execute(Graphics g, Point penPos) {
		g.drawRect(penPos.x, penPos.y, side, side);
		
	}
}
