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
			 fawkes.driveForward(168); //14 ft
			 fawkes.turn(90);
			 fawkes.driveForward(80);
			 fawkes.releaseDaCube();
			 //continue with return to grab more cubes 
		 }
		 
		 //otherwise drive forward over baseline
		 else {
			fawkes.driveForwardWithGyro(120);
		 }
    }
	
}
