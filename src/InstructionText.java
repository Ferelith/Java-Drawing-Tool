import java.awt.Graphics;
import java.awt.Point;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

//TEXT
public class InstructionText extends Instruction{

	
	private String text;

	public InstructionText(String instruction) {
		super(instruction);
		try(Scanner scanner = new Scanner(instruction);){
			scanner.next();
			text = scanner.nextLine().trim();
			

			if(!text.startsWith("\""))
				throw new RuntimeException("Text doesnt start with a quote");
			
			if(!text.endsWith("\""))
				throw new RuntimeException("Text doesnt end with a quote");
			
			scanner.close();
		}catch(InputMismatchException e){
			throw new RuntimeException("Invalid argument type.");
		}catch(NoSuchElementException e){
			throw new RuntimeException("Invalid number of arguments");
		}
		
	}

	@Override
	public void execute(Graphics g, Point penPos) {
		g.drawString(text, penPos.x, penPos.y + g.getFont().getSize());
		penPos.y += g.getFont().getSize();
	}
	
	
}
