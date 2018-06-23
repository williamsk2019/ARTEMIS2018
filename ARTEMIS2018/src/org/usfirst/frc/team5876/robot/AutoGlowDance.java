package org.usfirst.frc.team5876.robot;

import edu.wpi.first.wpilibj.DriverStation;

public class AutoGlowDance extends AutoTemplate{

	 boolean hasRunDance;
	
	public AutoGlowDance() {
		
		 hasRunDance = false;	 
	}
	
    public void autonomousInitCode(ArtemisBot fawkes){
    	fawkes.prepareForAuto();
    }
    public void autonomousPeriodicCode(ArtemisBot fawkes){
    	System.out.println("Glow Dance");

		 if (hasRunDance == false) { 
			 
			fawkes.grabDaCube();
			fawkes.releaseDaCube();
			fawkes.driveForward(0,1.);
			fawkes.grabDaCube();
			fawkes.releaseDaCube();
			fawkes.driveForward(0,1);
			
			fawkes.liftLift();
			fawkes.driveForward(20, 3);
			fawkes.stopLift();
			fawkes.driveForward(0,1);
			fawkes.unliftLift();
			fawkes.driveForward(-20, 3);
			fawkes.stopLift();
			fawkes.driveForward(0,1);
			
			fawkes.turn(90, 5);
			
			fawkes.liftLift();
			fawkes.driveForward(20, 3);
			fawkes.stopLift();
			fawkes.driveForward(0,1);
			fawkes.unliftLift();
			fawkes.driveForward(-20, 3);
			fawkes.stopLift();
			fawkes.driveForward(0,1);
		 }
	
		 else {
			 fawkes.robotDriveBase.arcadeDrive(0,0);
		 }		 }}
   