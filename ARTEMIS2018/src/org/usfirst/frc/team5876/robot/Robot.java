package org.usfirst.frc.team5876.robot;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;



public class Robot extends IterativeRobot {

  /*
   * Variables for robot hardware here
   */

  // The drive base of the robot
  DifferentialDrive robotDriveBase;

  // The motor controllers (will be passed in to the drive base)
  SpeedController motorDriveLeftFront;
  SpeedController motorDriveLeftBack;
  SpeedControllerGroup left_motors;
  SpeedController motorDriveRightFront;
  SpeedController motorDriveRightBack;
  SpeedControllerGroup right_motors;

  //accelerometer and gyro
  ADXRS450_Gyro gyro;
  BuiltInAccelerometer accel;

  //pneumatics controls
  DoubleSolenoid doubleSolenoidLifter; //eDouble;
  Compressor compressor1;

  /*
   * Controllers and Joysticks
   */
  Joystick joystickLeft; // stick
  Joystick joystickRight; // gamepad
  Joystick gamepadController; // gamepadController

  /*
   * Variables needed for Autonomous
   */
  final Integer baseline =  new Integer(0);
  final Integer pos1 =      new Integer(1);
  final Integer pos2 =      new Integer(2);
  final Integer pos3 =      new Integer(3);
  Integer autoSelected;
  Timer timer;
  SendableChooser<Integer> chooser = new SendableChooser<Integer>();
  String gameData;




  /**
   * set up the robot parameters, cameras, etc... once it is turned on.
   */
  @Override
  public void robotInit() {

    // set up any game controllers
    joystickLeft =       new Joystick(0);
    joystickRight =      new Joystick(1);
    gamepadController =  new Joystick(2);

    // set up individual drive motors
    motorDriveLeftFront =     new VictorSP(0);
    motorDriveLeftBack =      new VictorSP(1);

    motorDriveRightFront =    new VictorSP(2);
    motorDriveRightBack =     new VictorSP(3);

    // set up drive motor groups and the drive base
    left_motors =   new SpeedControllerGroup(motorDriveLeftFront, motorDriveLeftBack);
    right_motors =  new SpeedControllerGroup(motorDriveRightFront, motorDriveRightBack);

    robotDriveBase = new DifferentialDrive(left_motors, right_motors);


    // now set up other parts of the robot
    compressor1 = new Compressor(0);
    compressor1.setClosedLoopControl(true); // which one of these is needed?
    compressor1.setClosedLoopControl(false); // which one of these is needed?
    compressor1.start();

    doubleSolenoidLifter = new DoubleSolenoid(2, 3);
    doubleSolenoidLifter.set(DoubleSolenoid.Value.kOff);

    accel = new BuiltInAccelerometer();

    timer = new Timer();

    gyro = new ADXRS450_Gyro();
    gyro.calibrate();

    CameraServer.getInstance().startAutomaticCapture();

    chooser.addDefault("Baseline", baseline);
    chooser.addObject("Position 1 (left)", pos1);
    chooser.addObject("Position 2 (centre)", pos2);
    chooser.addObject("Position 3 (right)", pos3);
    SmartDashboard.putData("Auto choices", chooser);
  } // end robotInit()



  /**
   * make sure all timers, gyros, encoders, and accelerometers are initialised
   * and reset to what they need to be
   */
  @Override
  public void autonomousInit() {
    timer.reset();
    timer.start();
    gyro.reset();
    autoSelected = chooser.getSelected();
    System.out.println("Auto selected: " + autoSelected);
  } // end autonomousInit()


  /**
   * this function is called multiple times during autonomous. In this function,
   * get all inputs, check timers, and then adjust robot movements as needed
   * based on checks / timers / stage in process
   */
  @Override
  public void autonomousPeriodic() {
	  
	  //setup for "accurate" straight driving
	  		 double angle;
			 double Kp;
			 
	 //setup to allow recieval of game info 
			 String gameData;
			 gameData = DriverStation.getInstance().getGameSpecificMessage();
		
			 //start real code
		 switch (autoSelected) {
		 
		 //start case for position 1 (left)
		 case 1:
			 System.out.println("Position 1 (left)");
			 System.out.println("X=" + accel.getX() + ", Y=" + accel.getY() + ", Z=" + accel.getZ() + ", gyro=" + gyro.getAngle());
			 
			 //if alliance colour is on left of switch
			 if(gameData.charAt(0)=='L') {
				 
			 }
			 
			 //otherwise drive forward over baseline
			 else {
				 if (timer.get() < 5.2) {
						
						angle = gyro.getAngle();
						Kp = 0.05;
						robotDriveBase.arcadeDrive(-0.5, angle * Kp);
						
						Timer.delay(0.01);
				 }
			 }
			 break; //end case 1
			 
			 //start case for position 2 (centre)
		 case 2:
			 System.out.println("Position 2 (centre)");
			 System.out.println("X=" + accel.getX() + ", Y=" + accel.getY() + ", Z=" + accel.getZ() + ", gyro=" + gyro.getAngle());

		//if alliance colour is on right of switch
			 if(gameData.charAt(0)=='R') {
				 
			 }
			 
		//if alliance colour is on left of swtich
			 else {
				 
			 }
			
			 break; //end case 2
			 
			 
		//start case for position 3 (right)
		 case 3:
			 System.out.println("Postion 3 (right)");
			 System.out.println("X=" + accel.getX() + ", Y=" + accel.getY() + ", Z=" + accel.getZ() + ", gyro=" + gyro.getAngle());
			 
		//if alliance colour is on right side of switch
			 if(gameData.charAt(0)=='R') {
				 
			 }
		
		//otherwise drive forward over baseline
			 else {
				if (timer.get() < 5.2) {
				
					angle = gyro.getAngle();
					Kp = 0.05;
					robotDriveBase.arcadeDrive(-0.5, angle * Kp);
						
					Timer.delay(0.01);
				 }
			 }
			 break; //end case 3
			 
			 //start case top drive over baseline
		 case 0:
		 default:
			 System.out.println("Baseline");
			 System.out.println("X=" + accel.getX() + ", Y=" + accel.getY() + ", Z=" + accel.getZ() + ", gyro=" + gyro.getAngle());


			 	if (timer.get() < 5.2) {
					
					angle = gyro.getAngle();
					Kp = 0.05;
					robotDriveBase.arcadeDrive(-0.5, angle * Kp);
					
					Timer.delay(0.01);
			 }
			 break; // end case 0
		 }

  } // end autonomousPeriodic()


  /**
   * this function gets called multiple times during the tele-operated period.
   * In this function, get all inputs
   */
  @Override
  public void teleopPeriodic() {
    System.out.println("X=" + accel.getX() + ", Y=" + accel.getY() + ", Z=" + accel.getZ() + ", gyro=" + gyro.getAngle());

    //check left joystick slow speed control override
    int pov = joystickLeft.getPOV();
    //check right joystick slow speed control override
    int povTurn = joystickRight.getPOV();

    float slow = 0.5f;
    float turn = 0, forward = 0;


    // check the thumb controllers on the joysticks in case we need to override
    // the joystick drive commands. (This is for slow mode.)
    if (pov != -1 || povTurn != -1) {
      // the forward/back thumb controller to check if it is at one of
      // 0 degrees, 315 degrees, or 45 degrees for slow forward
      // XOR
      // 180 degrees, 135 degrees, or 225 degrees for slow backwards
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

      // the left / right thumb controller to check if it is pointing in one
      // of the left or right regions.
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
      robotDriveBase.arcadeDrive(forward, turn);
    } // end if -- for slow movement inputs ... otherwise feed in normal joystick drive...
    else
    {
      //drive the robot as normal
      robotDriveBase.arcadeDrive((joystickLeft.getRawAxis(1)), -(joystickRight.getRawAxis(0)), true);
    } // end if/else -- for slow or normal drive


    /* now to check what to do with the solenoid.
     * Do we want it to clamp or release the claw?
     */
    if (joystickRight.getRawButton(1)==true){
      // clamp claw
      doubleSolenoidLifter.set(DoubleSolenoid.Value.kForward);
    }
    else {
      // release claw
      doubleSolenoidLifter.set(DoubleSolenoid.Value.kReverse);
    }



    // other lifter / claw code to be created later below...

    // if(gamepadController.getRawButton(1)==true) {
    // 	//release claw
    // }
    //
    // else if(joystickRight.getRawButton(3)==true) {
    // 	//wheels in
    // }
    //
    // else if(joystickLeft.getRawButton(4)==true) {
    // 	//wheels out
    // }
    //
    // else if(gamepadController.getRawButton(2)== true) {
    // 	//up
    // }
    // else if(gamepadController.getRawButton(3)==true) {
    // 	//down
    // }


  } // end teleopPeriodic()

  @Override
  public void testPeriodic() {

  } // end testPeriodic()
  
  void driveForward() {
	  
  }
  
  

} // end Robot class definitions