
package org.usfirst.frc.team5585.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team5585.robot.Robot;

/**
 *
 */
public class RunWhacker extends Command {

    public RunWhacker() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.Whacker);
        
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.Whacker.init();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.Whacker.whack(0.5);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.Whacker.done;
    }

    // Called once after isFinished returns true
    protected void end() {
    	while (Robot.Whacker.beginSW.get() == false) {
    		Robot.Whacker.reset();
    	}
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
