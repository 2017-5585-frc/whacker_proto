package org.usfirst.frc.team5585.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.SpeedController;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	public static int joystickPort = 0;
	public static SpeedController whackerMotor;
	public static DigitalInput beginSW;
	public static DigitalInput endSW;
	
	public static void init() {
        beginSW = new DigitalInput(1);
        LiveWindow.addSensor("whacker", "beginSW", beginSW);
        
        endSW = new DigitalInput(0);
        LiveWindow.addSensor("whacker", "endSW", endSW);
        
        whackerMotor = new Jaguar(0);
        LiveWindow.addActuator("whacker", "Speed Controller 1", (Jaguar) whackerMotor);
	}
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
}
