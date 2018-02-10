package org.usfirst.frc.team5876.robot;

import edu.wpi.first.wpilibj.DriverStation;

public class AutoCentreToSwitch extends AutoTemplate{
	
	 String gameData;
	
	public AutoCentreToSwitch() {
		
		 gameData = DriverStation.getInstance().getGameSpecificMessage();
	}
	
    public void autonomousInitCode(ArtemisBot fawkes){
    	fawkes.prepareForAuto();
    }
    public void autonomousPeriodicCode(ArtemisBot fawkes){
    	 System.out.println("Position 2 (centre)");
		 System.out.println("X=" + fawkes.accel.getX() + ", Y=" + fawkes.accel.getY() + ", Z=" + fawkes.accel.getZ() + ", gyro=" + fawkes.gyro.getAngle());

	//if alliance colour is on right of switch
		 if(gameData.charAt(0)=='R') {
			 fawkes.driveForward(48);
			 fawkes.turn(45);
			 fawkes.driveForward(113);
			 fawkes.turn(-45);
			 fawkes.driveForward(12);
			 
		 }
		 
	//if alliance colour is on left of swtich
		 else {
			 fawkes.driveForward(42);
			 fawkes.turn(-45);
			 fawkes.driveForward(130); //?
			 fawkes.turn(45);
			 fawkes.driveForward(12);
		 }
    }
	
}
