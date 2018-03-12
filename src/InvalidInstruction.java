import java.awt.Graphics;
import java.awt.Point;
//Invalid instruction
public class InvalidInstruction extends Instruction{

	private String errorText;
	
	public InvalidInstruction(String instruction, String errorText) {
		super(instruction);
		this.errorText = errorText;
	}

	//cannot be executed
	@Override
	public void execute(Graphics g, Point penPos) {
		throw new RuntimeException("Cannot be executed");
	}
	
	@Override
	public String toString() {
		return "INVALID ["+ errorText+ "]";
	}

	
	

	
	
}
