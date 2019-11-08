/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.SpeedControllerGroup;


/**
 * This is a demo program showing the use of the RobotDrive class, specifically
 * it contains the code necessary to operate a robot with tank drive.
 */
public class Robot extends TimedRobot {
  private DifferentialDrive m_myRobot;
  private WPI_VictorSPX m_frontleft;
  private WPI_VictorSPX m_middleleft;
  private WPI_VictorSPX m_backleft;
  private WPI_VictorSPX m_frontright;
  private WPI_VictorSPX m_middleright;
  private WPI_VictorSPX m_backright;
  private SpeedControllerGroup m_left;
  private SpeedControllerGroup m_right;
  private XboxController m_leftStick;

  @Override
  public void robotInit() {
    m_left = new SpeedControllerGroup(new WPI_VictorSPX(1), new WPI_VictorSPX(2), new WPI_VictorSPX(3));
    m_right = new SpeedControllerGroup(new WPI_VictorSPX(4), new WPI_VictorSPX(5), new WPI_VictorSPX(6));
    m_myRobot = new DifferentialDrive(m_left, m_right);

    m_leftStick = new XboxController(0);
  }

  @Override
  public void teleopPeriodic() {
    m_myRobot.arcadeDrive(-m_leftStick.getY(Hand.kLeft), m_leftStick.getX(Hand.kRight));
  }
}