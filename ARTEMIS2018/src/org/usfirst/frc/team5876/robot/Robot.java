package org.usfirst.frc.team5876.robot;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.CameraServer;



@SuppressWarnings("deprecation")
public class Robot extends IterativeRobot {
	final Integer baseline = new Integer(0);
	final Integer pos1 = new Integer(1);
	final Integer pos2 = new Integer(2);
	final Integer pos3 = new Integer(3);
	Integer autoSelected;

	RobotDrive robotDrive;
	Joystick stick;
	Joystick gamepad;
	Joystick controller;
	SendableChooser<Integer> chooser = new SendableChooser<Integer>();
	ADXRS450_Gyro gyro;
	Timer timer;
	BuiltInAccelerometer accel;
	DoubleSolenoid eDouble;
	

	 @Override
	 public void robotInit() {
		 chooser.addDefault("Baseline", baseline);
		 chooser.addObject("Position 1 (left)", pos1);
		 chooser.addObject("Position 2 (centre)", pos2);
		 chooser.addObject("Position 3 (right)", pos3);
		 SmartDashboard.putData("Auto choices", chooser);
		 
		 
		 stick = new Joystick(0);
		 gamepad = new Joystick(1);
		 controller = new Joystick(2);
		 SpeedController driveLeftFront = new VictorSP(0);
		 SpeedController driveLeftBack = new VictorSP(1);
		 SpeedController driveRightFront = new VictorSP(2);
		 SpeedController driveRightBack = new VictorSP(3);
		 accel = new BuiltInAccelerometer();
		 
		 Compressor c = new Compressor(0);
	
		 c.setClosedLoopControl(true);
		 c.setClosedLoopControl(false);
		 eDouble = new DoubleSolenoid(2, 3);

		 eDouble.set(DoubleSolenoid.Value.kOff);
		// eDouble.set(DoubleSolenoid.Value.kForward);
		 //eDouble.set(DoubleSolenoid.Value.kReverse);
		
		 timer = new Timer();
		 gyro = new ADXRS450_Gyro();
		 gyro.calibrate();
		 robotDrive = new RobotDrive(driveLeftFront, driveLeftBack, driveRightFront, driveRightBack);
		 CameraServer.getInstance().startAutomaticCapture();
	 }

	 @Override
	 public void autonomousInit() {
		 timer.reset();
		 timer.start();
		 gyro.reset();
		 autoSelected = chooser.getSelected();
		 System.out.println("Auto selected: " + autoSelected);
		 
	 }

	
	 @Override
	 public void autonomousPeriodic() {
		 	String gameData;
		 //while (isAutonomous() && isEnabled()){
			 double angle = gyro.getAngle();
			 double Kp = 0.03;
			 robotDrive.arcadeDrive(-1.0, -angle * Kp);
			 Timer.delay(0.01);
			 gameData = DriverStation.getInstance().getGameSpecificMessage();
		// }
		 switch (autoSelected) {
		 
		 case 1:
			 System.out.println("Position 1 (left)");
			 System.out.println("X=" + accel.getX() + ", Y=" + accel.getY() + ", Z=" + accel.getZ() + ", gyro=" + gyro.getAngle());
			 
			 if(gameData.charAt(0)=='L') {
				 
			 }
			 
			 else {
				 if (timer.get() < 1.5){
						angle = gyro.getAngle();
						Kp = 0.05;
						robotDrive.arcadeDrive(-0.35, angle * Kp);
						Timer.delay(0.01);
					}

					else if (timer.get() < 5.2) {
						
						angle = gyro.getAngle();
						Kp = 0.05;
						robotDrive.arcadeDrive(-0.5, angle * Kp);
						
						Timer.delay(0.01);
				 }
			 }
			 break;
			 
			 
		 case 2:
			 System.out.println("Position 2 (centre)");
			 System.out.println("X=" + accel.getX() + ", Y=" + accel.getY() + ", Z=" + accel.getZ() + ", gyro=" + gyro.getAngle());

			 if(gameData.charAt(0)=='R') {
				 
			 }
			 
			 else {
				 
			 }
			
			 break;
		
		 case 3:
			 System.out.println("Postion 3 (right)");
			 System.out.println("X=" + accel.getX() + ", Y=" + accel.getY() + ", Z=" + accel.getZ() + ", gyro=" + gyro.getAngle());
			 
			 if(gameData.charAt(0)=='R') {
				 
			 }
			 
			 else {
				 if (timer.get() < 1.5){
						angle = gyro.getAngle();
						Kp = 0.05;
						robotDrive.arcadeDrive(-0.35, angle * Kp);
						Timer.delay(0.01);
					}

					else if (timer.get() < 5.2) {
						
						angle = gyro.getAngle();
						Kp = 0.05;
						robotDrive.arcadeDrive(-0.5, angle * Kp);
						
						Timer.delay(0.01);
				 }
			 }
			 break;
			 
			 
		 case 0:
		 default:
			 System.out.println("Baseline");
			 System.out.println("X=" + accel.getX() + ", Y=" + accel.getY() + ", Z=" + accel.getZ() + ", gyro=" + gyro.getAngle());


				if (timer.get() < 1.5){
					angle = gyro.getAngle();
					Kp = 0.05;
					robotDrive.arcadeDrive(-0.35, angle * Kp);
					Timer.delay(0.01);
				}

				else if (timer.get() < 5.2) {
					
					angle = gyro.getAngle();
					Kp = 0.05;
					robotDrive.arcadeDrive(-0.5, angle * Kp);
					
					Timer.delay(0.01);
			 }
			 break;
		 }
	 }

	
	 @Override
	 public void teleopPeriodic() {
		 System.out.println("X=" + accel.getX() + ", Y=" + accel.getY() + ", Z=" + accel.getZ() + ", gyro=" + gyro.getAngle());
	
		 int pov = stick.getPOV();
		 int povTurn = gamepad.getPOV();
		 float slow = 0.5f;
		 float turn = 0, forward = 0;
		 
		 if (pov != -1 || povTurn != -1) {
			 switch (pov) {
			 case 0:
			 case 315:
			 case 45:
				 forward = -slow;
				 break;
			 case 180:
			 case 135:
			 case 225:
				 forward = slow;
				 break;
			 } 
			 switch (povTurn) {
			 case 90:
			 case 45:
			 case 135:	 
				 turn = -slow;
				 break;
			 case 270:
			 case 225:
			 case 315:
				 turn = slow;
				 break;
			 }
			 robotDrive.arcadeDrive(forward, turn);
		 }
		 

		 else {
			 robotDrive.arcadeDrive((stick.getRawAxis(1)), -(gamepad.getRawAxis(0)), true);
		 }
		
		if (gamepad.getRawButton(1)==true){
			//clamp claw
			eDouble.set(DoubleSolenoid.Value.kForward);
		}
		
		else if(controller.getRawButton(1)==true) {
			//release claw
		}
		
		else if(gamepad.getRawButton(3)==true) {
			//wheels in
	 	}
		
		else if(stick.getRawButton(4)==true) {
			//wheels out
		}
		
		else if(controller.getRawButton(2)== true) {
			//up
		}
		else if(controller.getRawButton(3)==true) {
			//down
		}
		
		  
	 }

	 @Override
	 public void testPeriodic() {
	 }

}