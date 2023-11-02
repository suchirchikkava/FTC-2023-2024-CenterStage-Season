package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous (name="AutonomousLandingSide")
public class AutonomousLandingSide extends LinearOpMode {
    private DcMotor backLeft;
    private DcMotor backRight;
    private DcMotor frontLeft;
    private DcMotor frontRight;

    @Override
    public void runOpMode() {
        waitForStart();
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        backRight = hardwareMap.get(DcMotor.class, "backRight");
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");

        backLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        backLeft.setDirection(DcMotor.Direction.REVERSE);
        frontLeft.setDirection(DcMotor.Direction.REVERSE);

        // ONE TILE is ~1060 CLICKS

        // Custom prop = solid color
        // Check 2 of 3 spikes and place pixel on spike mark (the easy 20 points)
        // NOTE: WITH CURRENT CLAW DESIGN, WE MAY NOT BE ABLE TO CARRY
        // AND DROP PIXELS FOR BOTH SPIKES AND BACKDROP

        // moveForward(); to spike zone
        // rotateAndLocateGamePiece();
        // moveForward(); to board (parking points)

    }

    public void moveForward(int distance) {
        reset();
        backLeft.setTargetPosition(distance);
        backRight.setTargetPosition(distance);
        frontLeft.setTargetPosition(distance);
        frontRight.setTargetPosition(distance);
        runWheels();
    }

    public void moveBackward(int distance) {
        reset();
        backLeft.setTargetPosition(-distance);
        backRight.setTargetPosition(-distance);
        frontLeft.setTargetPosition(-distance);
        frontRight.setTargetPosition(-distance);
        runWheels();
    }

    public void leftStrafe(int distance) {
        reset();
        backLeft.setTargetPosition(distance);
        backRight.setTargetPosition(-distance);
        frontLeft.setTargetPosition(-distance);
        frontRight.setTargetPosition(distance);
        runWheels();
    }

    public void rightStrafe(int distance) {
        reset();
        backLeft.setTargetPosition(-distance);
        backRight.setTargetPosition(distance);
        frontLeft.setTargetPosition(distance);
        frontRight.setTargetPosition(-distance);
        runWheels();
    }

    public void rotateAndLocateGamePiece() {
        reset();
        // while sensor feedback != condition for custom game piece
        // keep rotating
        // if game piece, record custom position
        runWheels();
    }

    public void runWheels() {
        while (frontRight.getCurrentPosition() != frontRight.getTargetPosition()) {
            backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        }
    }

    public void reset() {
        backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

}
