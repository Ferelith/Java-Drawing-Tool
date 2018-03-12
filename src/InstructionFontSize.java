import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

//Set Font size
//e.g FONT_SIZE 15
public class InstructionFontSize extends Instruction{

	private int size;

	public InstructionFontSize(String instruction) {
		super(instruction);
		try(Scanner scanner = new Scanner(instruction);){
			scanner.next();
			size = scanner.nextInt();
			
			
			if(scanner.hasNext())
				throw new RuntimeException("Invalid number of arguments");
			
			if(size < 1)
				throw new RuntimeException("Invalid font size.");
			
			scanner.close();
		}catch(InputMismatchException e){
			throw new RuntimeException("Invalid argument type.");
		}catch(NoSuchElementException e){
			throw new RuntimeException("Invalid number of arguments");
		}
	}
	
	@Override
	public void execute(Graphics g, Point penPos) {
		g.setFont(g.getFont().deriveFont((float)size));
		
	}
	
	
}
