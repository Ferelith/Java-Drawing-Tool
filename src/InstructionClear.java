import java.awt.Graphics;
import java.awt.Point;
import java.util.Scanner;

//Clear instruction
public class InstructionClear extends Instruction{

	public InstructionClear(String instruction) {
		super(instruction);
		try(Scanner scanner = new Scanner(instruction);){
			scanner.next();
			if(scanner.hasNext())
				throw new RuntimeException("Invalid number of arguments");
		}
		
	}

	//reset pen position
	public void execute(Graphics g, Point penPos) {
		penPos.x = 0;
		penPos.y = 0;
	}

	
}
