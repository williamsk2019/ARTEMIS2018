package org.usfirst.frc.team5876.robot;

import edu.wpi.first.wpilibj.DriverStation;

public class AutoLeftToSwitch extends AutoTemplate{
	
	 String gameData;
	
	public AutoLeftToSwitch() {
		
		 gameData = DriverStation.getInstance().getGameSpecificMessage();
	}
	
    public void autonomousInitCode(ArtemisBot fawkes){
    	fawkes.prepareForAuto();
    }
    public void autonomousPeriodicCode(ArtemisBot fawkes){
    	 System.out.println("Position 1 (left)");
		 System.out.println("X=" + fawkes.accel.getX() + ", Y=" + fawkes.accel.getY() + ", Z=" + fawkes.accel.getZ() + ", gyro=" + fawkes.gyro.getAngle());
		 
		 //if alliance colour is on left of switch
		 if(gameData.charAt(0)=='L') {
			 boolean completed = fawkes.driveForward(168,5); //14 ft within 5 seconds
			 if (completed = true){
			 completed = completed & fawkes.turn(90,5); //turn right within 5 seconds
			 }
			 
			 if (completed = true) {
				completed = completed & fawkes.driveForward(80,5); //80 in within 5 seconds
			 }
			 
			 if (completed = true) {
				fawkes.releaseDaCube();
			 }
			 
			
			 //continue with return to grab more cubes 
		 }
		 
		 //otherwise drive forward over baseline
		 else {
			fawkes.driveForwardWithGyro(120, 15);
		 }
    }
	
}
