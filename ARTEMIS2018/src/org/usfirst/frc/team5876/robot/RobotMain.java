package org.usfirst.frc.team5876.robot;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import java.util.ArrayList;



public class RobotMain extends IterativeRobot {

  Controls driverStationControllers;
  ArtemisBot fawkes;
  AutoManager autonomousPlans;
  AutoTemplate selectedAutonomous;
  Timer robotTimer;

  //now we need the autonomous mode chooser....

  /*
   * Variables needed for Autonomous
   */
  String autoSelection;
  SendableChooser autonomousCodeChooser = new SendableChooser();

  /**
   * set up the robot parameters, cameras, etc... once it is turned on.
   */
  @Override
  public void robotInit() {
    //the robot with all the motors and sensors available
    fawkes = new ArtemisBot();

    //the joystick controlls and mappings for instructions
    driverStationControllers = new Controls();

    /**
     * Auto code section to add different autonomous plans (without code crashing if error)
     */
    //-------------------------
    //lets add a default option.
    //-------------------------
    try{
      autonomousCodeChooser.addDefault("forward",new AutoDriveForward());
    }
    catch(Exception e){
      System.out.println("unable to add --forward-- to auto chooser... perhaps there is a code error in that auto class?");
      e.printStackTrace();
    }

    //-------------------------
    //lets add an auto to go to the switch from the centre.
    //-------------------------
    try{
      autonomousCodeChooser.addDefault("centreToSwitch",new AutoCentreToSwitch());
    }
    catch(Exception e){
      System.out.println("unable to add --centreToSwitch-- to auto chooser... perhaps there is a code error in that auto class?");
      e.printStackTrace();
    }

    //-------------------------
    //lets add an auto to start from the left side.
    //-------------------------
    try{
      autonomousCodeChooser.addDefault("fromLeftSide",new AutopFromLeftSide());
    }
    catch(Exception e){
      System.out.println("unable to add --fromLeftSide-- to auto chooser... perhaps there is a code error in that auto class?");
      e.printStackTrace();
    }

    /*add more auto code choices here...*/

    SmartDashboard.putData("AutoChoices",autonomousCodeChooser);

    robotTimer = new Timer();
    robotTimer.start();
    // this will give time between init and auto init... gyro drift?


  } // end robotInit()



  /**
   * make sure all timers, gyros, encoders, and accelerometers are initialised
   * and reset to what they need to be
   */
  @Override
  public void autonomousInit() {
	  fawkes.prepareForAuto();

    System.out.println("Getting Auto selection from dashboard...");

    selectedAutonomous = (AutoTemplate) chooser.getSelected();

    if(selectedAutonomous!=null){
      System.out.println("Selected Autonomous is Loaded... and not empty");
    }
    else{
      System.out.println("ALERT: Selected Autonomous is empty????");
      System.out.println("ALERT: Selected Autonomous is empty????");
      System.out.println("ALERT: Selected Autonomous is empty????");
      System.out.println("ALERT: Selected Autonomous is empty????");
      System.out.println("ALERT: Selected Autonomous is empty????");
    }

    System.out.println("Running Auto Init Code...");

    selectedAutonomous.autonomousInitCode(fawkes); //TODO: this shouyld be fawkes!!!!!

    System.out.println("Auto Init Code Completed!");

  } // end autonomousInit()


  /**
   * this function is called multiple times during autonomous. In this function,
   * get all inputs, check timers, and then adjust robout movements as needed
   * based on checks / timers / stage in process
   */
  @Override
  public void autonomousPeriodic() {

    System.out.println("Running Auto Periodic Code");
    selectedAutonomous.autonomousPeriodicCode(fawkes);

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

    //driverStationControllers.updateControls(fawkes);
    //
  } // end testPeriodic()

} // end RobotMain class definitions
