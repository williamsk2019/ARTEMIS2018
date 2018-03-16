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
			 
			 boolean completed = fawkes.driveForward(91, 7); //4 ft within 5 seconds
			 if (completed = true){
				 fawkes.grabDaCube();
			 completed = completed & fawkes.turn(45,5); //turn right within 5 seconds
			 }
			 
			 if (completed = true) {
				completed = completed & fawkes.driveForward(150,5); //113 in within 5 seconds
			 }
			 
			 if (completed = true) {
				completed = completed & fawkes.turn(-45, 5);
				fawkes.liftLift();
			 }
			 
			 if (completed = true) {
				completed = completed & fawkes.driveForward(18, 5); //1 ft witin 5 seconds
			 }
			 
		 }
		 
	//if alliance colour is on left of swtich
		 else {
			 boolean completed = fawkes.driveForward(42,5); //42 in within 5 seconds
			 if (completed = true){
			 completed = completed & fawkes.turn(-45,5); //turn left within 5 seconds
			 }
			 
			 if (completed = true) {
				completed = completed & fawkes.driveForward(130,5); //130 in within 5 seconds
			 }
			 
			 if (completed = true) {
				completed = completed & fawkes.turn(45, 5); //turn right within 5 seconds
			 }
			 
			 if (completed = true) {
				completed = completed & fawkes.driveForward(12, 5); //1 ft witin 5 seconds
			 }
			 
		 }
    }
	
}
