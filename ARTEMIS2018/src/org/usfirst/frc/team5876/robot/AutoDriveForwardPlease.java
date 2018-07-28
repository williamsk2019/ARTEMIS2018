package org.usfirst.frc.team5876.robot;

import edu.wpi.first.wpilibj.DriverStation;

public class AutoDriveForwardPlease extends AutoTemplate{
	
	 String gameData;
	 boolean hasRunAuto;
	
	public AutoDriveForwardPlease() {
		
		 gameData = DriverStation.getInstance().getGameSpecificMessage();
		 hasRunAuto = false;
		 
	}
	
    public void autonomousInitCode(ArtemisBot fawkes){
    	fawkes.prepareForAuto();
    	System.out.println("Plz let the robot go over the baseline. Plz");
    }
    public void autonomousPeriodicCode(ArtemisBot fawkes){
    	System.out.println("Baseline");
		 System.out.println("X=" + fawkes.accel.getX() + ", Y=" + fawkes.accel.getY() + ", Z=" + fawkes.accel.getZ() + ", gyro=" + fawkes.gyro.getAngle());
		 System.out.println(gameData);
		 if (hasRunAuto == false) {
		 fawkes.driveForward(152, 8);
		 hasRunAuto = true;
		 }
		 else {
			 fawkes.driveForward(0,0);
		 }
    }
	
}
