package org.usfirst.frc.team5876.robot;

import edu.wpi.first.wpilibj.DriverStation;

public class AutoDriveBackward extends AutoTemplate{
	
	 String gameData;
	 boolean hasRunAuto;
	
	public AutoDriveBackward() {
		
		 gameData = DriverStation.getInstance().getGameSpecificMessage();
		 hasRunAuto = false;
		 
	}
	
    public void autonomousInitCode(ArtemisBot fawkes){
    	fawkes.prepareForAuto();
    }
    public void autonomousPeriodicCode(ArtemisBot fawkes){
    	
		 System.out.println(gameData);
		 System.out.println("Backward");
		 System.out.println("X=" + fawkes.accel.getX() + ", Y=" + fawkes.accel.getY() + ", Z=" + fawkes.accel.getZ() + ", gyro=" + fawkes.gyro.getAngle());
		 if (hasRunAuto == false) {
		 fawkes.driveBackward(132, 15);
		 hasRunAuto = true;
		 }
		 else {
			 fawkes.robotDriveBase.arcadeDrive(0,0);
		 }
    }
	
}
