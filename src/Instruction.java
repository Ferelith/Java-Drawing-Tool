import java.awt.Graphics;
import java.awt.Point;

//Represnest an instruction
public abstract class Instruction {

	//the instruction text
	private String instruction;

	//sets the instriction
	public Instruction(String instruction) {
		this.instruction = instruction;
	}

	//execute instruction
	public abstract void execute(Graphics g, Point penPos);

	
	public String toString() {
		return instruction;
	}
}
