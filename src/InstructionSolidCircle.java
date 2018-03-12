import java.awt.Graphics;
import java.awt.Point;

//solid circle
public class InstructionSolidCircle extends InstructionCircle{

	public InstructionSolidCircle(String instruction) {
		super(instruction);
	}
	
	@Override
	public void execute(Graphics g, Point penPos) {
		g.fillOval(penPos.x - r, penPos.y - r, r*2, r*2);
	}

}
