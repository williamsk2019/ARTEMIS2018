//package org.usfirst.frc.team5876.robot;
//
//import edu.wpi.first.wpilibj.DriverStation;
//
//public class AutoLeftToSwitch extends AutoTemplate{
//	
//	 String gameData;
//	
//	public AutoLeftToSwitch() {
//		
//		 gameData = DriverStation.getInstance().getGameSpecificMessage();
//	}
//	
//    public void autonomousInitCode(ArtemisBot fawkes){
//    	fawkes.prepareForAuto();
//    }
//    public void autonomousPeriodicCode(ArtemisBot fawkes){
//    	 System.out.println("Position 1 (left)");
//		 System.out.println("X=" + fawkes.accel.getX() + ", Y=" + fawkes.accel.getY() + ", Z=" + fawkes.accel.getZ() + ", gyro=" + fawkes.gyro.getAngle());
//		 System.out.println(gameData);
//		 
//		 //if alliance colour is on left of switch
//		 if(gameData.charAt(0)=='L') {
//			 boolean completed = fawkes.driveForward(236,5); //236 in within 5 seconds
//			 if (completed = true){
//			 completed = completed & fawkes.turn(90,5); //turn right within 5 seconds
//			 }
//			 
//			 if (completed = true) {
//				completed = completed & fawkes.driveForward(58,5); //58 in within 5 seconds
//			 }
//			 
//			 if (completed = true){
//				 completed = completed & fawkes.turn(90,5); //turn right within 5 seconds
//				 }
//			 
//			 if (completed = true) {
//					completed = completed & fawkes.driveForward(20,5); //20 in within 5 seconds
//				 }
//			 
//			 if (completed = true) {
//				fawkes.grabDaCube(); 
//				fawkes.liftLift();
//				completed = completed & fawkes.driveForward(20,2);
//				 }
//			 
//			 if (completed = true) {
//				fawkes.releaseDaCube();
//				fawkes.unliftLift();
//			 }
//			 
//			
//			 //continue with return to grab more cubes 
//		 }
//		 
//		 //otherwise drive forward over baseline
//		 else {
//			fawkes.driveForward(120, 15);
//		 }
//    }
//	
//}
