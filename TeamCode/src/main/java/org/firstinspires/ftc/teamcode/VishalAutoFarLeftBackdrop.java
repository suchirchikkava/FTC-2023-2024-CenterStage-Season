package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name="VishalAutoFarLeftBackdrop")
public class VishalAutoFarLeftBackdrop extends VishalAutonomous{
    private static DcMotor frontLeft;
    private static DcMotor backLeft;
    private static DcMotor frontRight;
    private static DcMotor backRight;

    public void runWheels() {
        while (frontRight.getCurrentPosition() != frontRight.getTargetPosition()) {
            frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        }
    }

    public void reset() {
        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    public void moveForward(int distance) {
        reset();
        frontLeft.setTargetPosition(distance);
        frontRight.setTargetPosition(distance);
        backLeft.setTargetPosition(distance);
        backRight.setTargetPosition(distance);
        runWheels();
    }

    public void moveBackward(int distance) {
        reset();
        frontLeft.setTargetPosition(-distance);
        frontRight.setTargetPosition(-distance);
        frontLeft.setTargetPosition(-distance);
        frontRight.setTargetPosition(-distance);
        runWheels();
    }

    public void strafeLeft(int distance) {
        reset();
        frontLeft.setPower(-distance);
        backLeft.setPower(distance);
        frontRight.setPower(distance);
        backRight.setPower(-distance);
        runWheels();
    }

    public void strafeRight(int distance) {
        reset();
        frontLeft.setPower(distance);
        backLeft.setPower(-distance);
        frontRight.setPower(-distance);
        backRight.setPower(distance);
        runWheels();
    }
}

    // Scan for placement of custom team element using machine learning to see which of the three
    // locations has the highest percentage of certainty

    // Place purple tag on tape
    moveBack() // Move back until in line with left part of truss
    turnleft() // Turn left 90 degrees
    moveForward() // Move forward until reach the board
    // Place pixel on board based on location of team element
    // Stay there (parking)
}
