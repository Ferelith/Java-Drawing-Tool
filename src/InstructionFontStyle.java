import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
//Set font style: plain (p) bold(b) italic (i)
public class InstructionFontStyle extends Instruction{

	//font style
	private int style;

	public InstructionFontStyle(String instruction) {
		super(instruction);
		try(Scanner scanner = new Scanner(instruction);){
			scanner.next();
			String styleChar = scanner.next();
			
			if(styleChar.equals("p"))
				style = Font.PLAIN;
			else if(styleChar.equals("b"))
				style = Font.BOLD;
			else if(styleChar.equals("i"))
				style = Font.ITALIC;
			else
				throw new RuntimeException("Invalid font style.");
			
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
		g.setFont(g.getFont().deriveFont(style));
		
	}
	
	
}
