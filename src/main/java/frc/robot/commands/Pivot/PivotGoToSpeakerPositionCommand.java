// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Pivot;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.PivotSubsystem;

public class PivotGoToSpeakerPositionCommand extends Command {

  private PivotSubsystem m_pivotSubsystem;
  double target_angle = 11; // ! Change this to the desired angle

  /** Creates a new PivotGoToSpeakerPositionCommand. */
  public PivotGoToSpeakerPositionCommand(PivotSubsystem pivot) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.m_pivotSubsystem = pivot;
    addRequirements(m_pivotSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_pivotSubsystem.moveMotorToAngle(50);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_pivotSubsystem.moveMotorToAngle(target_angle);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_pivotSubsystem.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (m_pivotSubsystem.atSetpoint()) {
      return true;
    } else {
      return false;
    }
  }
}
