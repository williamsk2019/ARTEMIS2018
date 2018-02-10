package org.usfirst.frc.team5876.robot;

public class AutoLeftToSwitch extends AutoTemplate{
	public void AutoLeftToSwitch() {
		
	}
	
    public void autonomousInitCode(ArtemisBot fawkes){
    	
    }
    public void autonomousPeriodicCode(ArtemisBot fawkes){
    	 System.out.println("Position 1 (left)");
		 System.out.println("X=" + accel.getX() + ", Y=" + accel.getY() + ", Z=" + accel.getZ() + ", gyro=" + gyro.getAngle());
		 
		 //if alliance colour is on left of switch
		 if(gameData.charAt(0)=='L') {
			 driveForward(168); //14 ft
			 turn(90);
			 driveForward(80);
			 releaseDaCube();
			 //continue with return to grab more cubes 
		 }
		 
		 //otherwise drive forward over baseline
		 else {
			driveForwardWithGyro(120);
		 }
    }
	
}
