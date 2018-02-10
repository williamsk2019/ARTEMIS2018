package org.usfirst.frc.team5876.robot;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class ArtemisBot {
	// The drive base of the robots
	  DifferentialDrive robotDriveBase;

	  // The motor controllers (will be passed in to the drive base)
	  SpeedController motorDriveLeftFront;
	  SpeedController motorDriveLeftBack;
	  SpeedControllerGroup left_motors;
	  SpeedController motorDriveRightFront;
	  SpeedController motorDriveRightBack;
	  SpeedControllerGroup right_motors;

	  //accelerometer, gyro and encoder
	  ADXRS450_Gyro gyro;
	  BuiltInAccelerometer accel;
	  Encoder encoder;
	  
	  //pneumatics controls
	  DoubleSolenoid doubleSolenoidLifter; //eDouble;
	  Compressor compressor1;
	  
	  //additional motors
	  SpeedController leftLobsterWheels;
	  SpeedController rightLobsterWheels;
	  SpeedControllerGroup lobsterWheels;
	
	  //timer
	  Timer timer;
	  
	public ArtemisBot() {
		// set up individual drive motors
	    motorDriveLeftFront =     new VictorSP(0);
	    motorDriveLeftBack =      new VictorSP(1);
	
	    motorDriveRightFront =    new VictorSP(2);
	    motorDriveRightBack =     new VictorSP(3);
	
	    // set up drive motor groups and the drive base
	    left_motors =   new SpeedControllerGroup(motorDriveLeftFront, motorDriveLeftBack);
	    right_motors =  new SpeedControllerGroup(motorDriveRightFront, motorDriveRightBack);
	
	    robotDriveBase = new DifferentialDrive(left_motors, right_motors);
	    
	    //set up additional motors / motor groups
	    rightLobsterWheels = new VictorSP(4);
	    leftLobsterWheels = new VictorSP(5);
	    lobsterWheels = new SpeedControllerGroup(rightLobsterWheels, leftLobsterWheels);
	
	
	    // now set up other parts of the robot
	    compressor1 = new Compressor(0);
	    compressor1.setClosedLoopControl(true); // which one of these is needed?
	    compressor1.setClosedLoopControl(false); // which one of these is needed?
	    compressor1.start();
	
	    doubleSolenoidLifter = new DoubleSolenoid(2, 3);
	    doubleSolenoidLifter.set(DoubleSolenoid.Value.kOff);
	
	    accel = new BuiltInAccelerometer();
	
	    encoder = new Encoder(0, 1, false, Encoder.EncodingType.k4X);
	    
	    timer = new Timer();
	
	    gyro = new ADXRS450_Gyro();
	    gyro.calibrate();
	
	    CameraServer.getInstance().startAutomaticCapture();
	}
	
	void arcadeDrive(double xSpeed, double zRotation, boolean squareInput) {
		robotDriveBase.arcadeDrive(xSpeed, zRotation, squareInput);
	}
	
	void tankDrive(double leftSpeed, double rightSpeed) {
		robotDriveBase.tankDrive(leftSpeed, rightSpeed);
	}
	
	void driveForward(int distance) { //function to reach goal distance (inches)
		  encoder.reset();
		  encoder.setDistancePerPulse(18.85); //18.85 = distance of rotation 
		  
		  double travel = encoder.getDistance(); //amount travelled
		  
		  while(travel < distance) { //allows amount travelled to reach goal distance 
			  robotDriveBase.arcadeDrive( -0.5 , 0);  
			  travel = encoder.getDistance();
		  }
		  
	  } //end void driveForward()
	  
	  void driveForwardWithGyro(int distance) { //function to reach goal distance (inches)
		  encoder.reset();
		  encoder.setDistancePerPulse(18.85); //18.85 = distance of rotation 
		  
		  double travel = encoder.getDistance(); //amount travelled
		  
		  while(travel < distance) { //allows amount travelled to reach goal distance 
			  
			  double angle = gyro.getAngle();
				double Kp = 0.05;
				robotDriveBase.arcadeDrive(-0.5, angle * Kp);
				
				
				Timer.delay(0.01);
				travel = encoder.getDistance();
		  }
		  
	  } //end void driveForwardWithGyro()
	  
	  void turn(int angle) { //function to reach goal angle
		  gyro.reset();
		  
		  double turned = gyro.getAngle(); //amount turned
		  
		  while(turned < angle) { 
		  robotDriveBase.arcadeDrive(0, 0.4);
		  turned = gyro.getAngle();
		  }
		  									//two situations where amount turned reaches goal angle
		  while (turned > angle) {
			  robotDriveBase.arcadeDrive(0,-0.4);
			  turned = gyro.getAngle();
		  }
	  } //end void turn()
	
	void grabDaCube() {
		doubleSolenoidLifter.set(DoubleSolenoid.Value.kForward);
		System.out.println("grabbing");
	  } //end void grabDaCube()
	  
	void releaseDaCube() {
		doubleSolenoidLifter.set(DoubleSolenoid.Value.kReverse);
		System.out.println("releasing");
	  } //end void releaseDaCube()
	
	
	void liftLift() {
		//lifts stuff
	}
	
	void unliftLift() {
		//lifts stuff down
	}
	
	void stopLift() {
		
	}
	
}