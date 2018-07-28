package org.usfirst.frc.team5876.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;

public class AutoFromLeftSide extends AutoTemplate{
	
	 String gameData;
	 boolean hasRunAuto;
	
	public AutoFromLeftSide() {
		
		 gameData = DriverStation.getInstance().getGameSpecificMessage();
		 hasRunAuto = false;
		 
	}
	
    public void autonomousInitCode(ArtemisBot fawkes){
    	fawkes.prepareForAuto();
    }
    public void autonomousPeriodicCode(ArtemisBot fawkes){
    	System.out.println("Left to Switch");
		 System.out.println(gameData);
		 if (hasRunAuto == false) { //loop so tele-op will run once complete
		 fawkes.driveForward(210, 3); //forward yay
		 fawkes.turn(90, 2); //turn
		 if(gameData.charAt(0)=='L') { //if switch is on left, drives forward a little
			 fawkes.driveForward(65, 1.5);
			 }
		 else { //else (switch on right) drives forward a lot
			 fawkes.driveForward(150, 3);
		 }
		 fawkes.turn(90,2);
		 fawkes.driveForward(10,1);
		 Timer lifttimer = new Timer();
		 lifttimer.start();
		 while(lifttimer.get() < 1.0){fawkes.liftLift();}
		 fawkes.unliftLift();
		 fawkes.grabDaCube();
		 fawkes.liftLift();
		 fawkes.stopLift();
		 fawkes.releaseDaCube();
		 hasRunAuto = true;
		 }
		 else {
			 fawkes.driveForward(0,0);
		 }
    }
	
}