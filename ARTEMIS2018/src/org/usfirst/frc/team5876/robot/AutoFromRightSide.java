package org.usfirst.frc.team5876.robot;

import edu.wpi.first.wpilibj.DriverStation;

public class AutoFromRightSide extends AutoTemplate{
	
	 String gameData;
	 boolean hasRunAuto;
	
	public AutoFromRightSide() {
		
		 gameData = DriverStation.getInstance().getGameSpecificMessage();
		 hasRunAuto = false;
		 
	}
	
    public void autonomousInitCode(ArtemisBot fawkes){
    	fawkes.prepareForAuto();
    }
    public void autonomousPeriodicCode(ArtemisBot fawkes){
    	System.out.println("Right to Switch");
		 System.out.println(gameData);
		 if (hasRunAuto == false) { //loop so tele-op will run once complete
		 fawkes.driveForward(200, 3); //forward yay
		 fawkes.turn(-90, 2); //turn
		 if(gameData.charAt(0)=='R') { //if switch is on right, drives forward a little
			 fawkes.driveForward(68, 1.5);
			 }
		 else { //else (switch on left) drives forward a lot
			 fawkes.driveForward(200, 3);
		 }
		 fawkes.turn(-90,2);
		 fawkes.grabDaCube();
		 fawkes.liftLift();
		 fawkes.stopLift();
		 fawkes.driveForward(5,0.5);
		 fawkes.releaseDaCube();
		 hasRunAuto = true;
		 }
		 else {
			 fawkes.driveForward(0,0);
		 }
    }
	
}