
package org.usfirst.frc.team5585.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.DigitalInput;
import org.usfirst.frc.team5585.robot.RobotMap;
/**
 *
 */
public class Whacker extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private SpeedController whackerMotor = RobotMap.whackerMotor;
	public DigitalInput endSW = RobotMap.endSW,
			beginSW = RobotMap.beginSW;
	private boolean whacked = false;
	public boolean done = false;
	
	public void init() {
	}
	
	public void whack(double speed) {
		long start = 0;
		
		if (beginSW.get() == true && endSW.get() == true && whacked == false) {
			whackerMotor.set(0.5);
			return;
		}
		
		if (endSW.get() == false && whacked == false) {
			whackerMotor.stopMotor();
			start = System.currentTimeMillis();
			whacked = true;
			System.out.println(System.currentTimeMillis() - start);
			return;
		}
		
		if (System.currentTimeMillis() - start <= 5000) {
			System.out.println(System.currentTimeMillis() - start);
			return;
		}
		if (beginSW.get() == false) {
			whackerMotor.stopMotor();
			whacked = false;
			done = true;
			return;
		}
//		whackerMotor.set(-0.5);
		whackerMotor.stopMotor();
		System.out.println("looped");
	}
	
	public void reset() {
			whackerMotor.stopMotor();
			whacked = false;
			done = false;
	}
		

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

