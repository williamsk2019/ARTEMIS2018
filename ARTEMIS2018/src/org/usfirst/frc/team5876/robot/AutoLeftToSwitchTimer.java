package org.usfirst.frc.team5876.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;

public class AutoLeftToSwitchTimer extends AutoTemplate{
	
	 String gameData;
	 Timer driveTimer;
	 
	
	public AutoLeftToSwitchTimer() {
		
		 driveTimer = new Timer();
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
			 if (driveTimer.get() < 5 ){
				 fawkes.robotDriveBase.arcadeDrive(0.5, 0);
			 }
			 else if (driveTimer.get() > 5) {
				 fawkes.turn(90, 5);
				 fawkes.robotDriveBase.arcadeDrive(0.5, 0);
			 }
			 
			
			 //continue with return to grab more cubes 
		 }
		 
		 //otherwise drive forward over baseline
		 else {
			fawkes.robotDriveBase.arcadeDrive(0.5, 0);
		 }
    }
	
}
