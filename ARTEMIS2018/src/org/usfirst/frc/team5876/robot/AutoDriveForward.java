//package org.usfirst.frc.team5876.robot;
//
//import edu.wpi.first.wpilibj.DriverStation;
//
//public class AutoDriveForward extends AutoTemplate{
//	
//	 String gameData;
//	 boolean hasRunAuto;
//	
//	public AutoDriveForward() {
//		
//		 gameData = DriverStation.getInstance().getGameSpecificMessage();
//		 hasRunAuto = false;
//		 
//	}
//	
//    public void autonomousInitCode(ArtemisBot fawkes){
//    	fawkes.prepareForAuto();
//    }
//    public void autonomousPeriodicCode(ArtemisBot fawkes){
//    	System.out.println("Baseline");
//		 System.out.println("X=" + fawkes.accel.getX() + ", Y=" + fawkes.accel.getY() + ", Z=" + fawkes.accel.getZ() + ", gyro=" + fawkes.gyro.getAngle());
//		 System.out.println(gameData);
//		 if (hasRunAuto == false) {
//		 fawkes.driveForward(132, 15);
//		 hasRunAuto = true;
//		 }
//		 else {
//			 fawkes.robotDriveBase.arcadeDrive(0,0);
//		 }
//    }
//	
//}
