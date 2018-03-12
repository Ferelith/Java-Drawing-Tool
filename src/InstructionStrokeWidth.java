import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

//STROKE_WIDTH width
//e.g STROKE_WIDTH 10
public class InstructionStrokeWidth extends Instruction{

	private int w;

	public InstructionStrokeWidth(String instruction) {
		super(instruction);
		try(Scanner scanner = new Scanner(instruction);){
			scanner.next();
			w = scanner.nextInt();
			
			
			if(scanner.hasNext())
				throw new RuntimeException("Invalid number of arguments");
			
			if(w < 1)
				throw new RuntimeException("Invalid stroke width.");
			
			scanner.close();
		}catch(InputMismatchException e){
			throw new RuntimeException("Invalid argument type.");
		}catch(NoSuchElementException e){
			throw new RuntimeException("Invalid number of arguments");
		}
	}
	
	@Override
	public void execute(Graphics g, Point penPos) {
		Graphics2D graphics2d = (Graphics2D) g;
		graphics2d.setStroke(new BasicStroke(w));
		
	}
	
	
}
