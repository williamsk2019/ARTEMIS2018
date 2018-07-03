package org.usfirst.frc.team5876.robot;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import java.util.ArrayList;



public class RobotMain extends IterativeRobot {

  Controls driverStationControllers;
  ArtemisBot fawkes;
//  AutoManager autonomousPlans;
//  AutoTemplate selectedAutonomous;
  Timer robotTimer;

  //now we need the autonomous mode chooser....

  /*
   * Variables needed for Autonomous
   */
  String autoSelection;
  SendableChooser<String> chooser = new SendableChooser<String>();

  /**
   * set up the robot parameters, cameras, etc... once it is turned on.
   */
  @Override
  public void robotInit() {
    //the robot with all the motors and sensors available
    fawkes = new ArtemisBot();

    //the joystick controlls and mappings for instructions
    driverStationControllers = new Controls();

    //the collection of autonomous plans (classes)
//    autonomousPlans = new AutoManager();
//    autonomousPlans.registerPlan("AutoCentreToSwitch");
//    autonomousPlans.registerPlan("AutoDriveForward");
//    autonomousPlans.registerPlan("AutoLeftToSwitch");
//    autonomousPlans.registerPlan("AutoRightToSwitch");
//    autonomousPlans.registerPlan("AutoRightToSwitchTimer");
//    autonomousPlans.registerPlan("AutoLeftToSwitchTimer");
//
//
//    //get the list of registered auto classes and send them as options for the SmartDashboard selector
//   ArrayList<String> autonomousPlansList = autonomousPlans.getRegisteredPlansList();
//
//  for ( String planName : autonomousPlansList) {
//      chooser.addObject(planName, planName);
    }
//
//    SmartDashboard.putData("Auto choices", chooser);
//    
//    robotTimer = new Timer();
//    robotTimer.start();
    

  //} // end robotInit()



  /**
   * make sure all timers, gyros, encoders, and accelerometers are initialised
   * and reset to what they need to be
   */
  @Override
  public void autonomousInit() {
	fawkes.prepareForAuto();
	

//        System.out.println("Getting Auto selection from dashboard");
//
//    autoSelection = chooser.getSelected();
//
//        System.out.println("Auto selected was: " + autoSelection);
//        System.out.println("Loading Auto Plan...");
//
//    //selectedAutonomous = autonomousPlans.getAutoPlan(autoSelection);
//        
//       selectedAutonomous = new AutoDriveForward();
       // selectedAutonomous = new AutoLeftToSwitch();
        
//        if (autoSelection == "AutoCentreToSwitch"){
//        	selectedAutonomous = new AutoCentreToSwitch();
//        }
//        
//        else if (autoSelection == "AutoDriveForward") {
//        	selectedAutonomous = new AutoDriveForward();
//        }
//        
//        else if (autoSelection == "AutoLeftToSwitch") {
//        	selectedAutonomous = new AutoLeftToSwitch();
//        }
//        
//        else if (autoSelection == "AutoRightToSwitch") {
//        	selectedAutonomous = new AutoRightToSwitch();
//        }
//        
//        else if (autoSelection == "AutoLeftToSwitchTimer") {
//        	selectedAutonomous = new AutoLeftToSwitchTimer();
//        }
//       // selectedAutonomous = new AutoRightToSwitchTimer();
//        
//        System.out.println("Running Auto Init Code...");
//
//    selectedAutonomous.autonomousInitCode(robot);
//
//       System.out.println("Auto Init Code Completed!");

  } // end autonomousInit()


  /**
   * this function is called multiple times during autonomous. In this function,
   * get all inputs, check timers, and then adjust robout movements as needed
   * based on checks / timers / stage in process
   */
  @Override
  public void autonomousPeriodic() {
	  System.out.println("Glow Dance");

			fawkes.grabDaCube();
			fawkes.releaseDaCube();
			fawkes.driveForward(0,1.);
			fawkes.grabDaCube();
			fawkes.releaseDaCube();
			fawkes.driveForward(0,1);
			
			fawkes.liftLift();
			fawkes.driveForward(20, 2);
			fawkes.stopLift();
			fawkes.driveForward(0,1);
			fawkes.unliftLift();
			fawkes.driveForward(-20, 2);
			fawkes.stopLift();
			fawkes.driveForward(0,1);
			
			fawkes.turn(90, 5);
			
			fawkes.liftLift();
			fawkes.driveForward(20, 2);
			fawkes.stopLift();
			fawkes.driveForward(0,1);
			fawkes.unliftLift();
			fawkes.driveForward(-20, 2);
			fawkes.stopLift();
			fawkes.driveForward(0,1);
			
		  
//   System.out.println("Running Auto Periodic Code");
//   selectedAutonomous.autonomousPeriodicCode(robot);
//   

} // end autonomousPeriodic()


  /**
   * this function gets called multiple times during the tele-operated period.
   * In this function, get all inputs
   */
  @Override
  public void teleopPeriodic() {
	  double angle = fawkes.gyro.getAngle();
		//System.out.println("Timer, " + robotTimer.get() + ", Gyro angle, " + angle + ", measured");

    driverStationControllers.updateControls(fawkes);
  } // end teleopPeriodic()

  @Override
  public void testPeriodic() {
  } // end testPeriodic()

} // end RobotMain class definitions