package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous(name = "JoshuaRenAutonomous")
public class JoshuaRenAutonomous extends LinearOpMode
{
    private DcMotor frontRight;
    private DcMotor frontLeft;
    private DcMotor backRight;
    private DcMotor backLeft;

    @Override
    public void runOpMode() {
        waitForStart();


        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        backRight = hardwareMap.get(DcMotor.class, "backRight");
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");

        // name each wheel in the robot, mapped the wheels

        backLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);


        backLeft.setPower(0.6);
        backRight.setPower(0.6);
        frontLeft.setPower(0.6);
        frontRight.setPower(0.6);

        //scenario after it finds the game piece
        moveLeft(1060*2);
        //turning for scans
        //scenario depends on which side scanned
        scenario1(1060);



    }

    public void runWheels() {
        while (frontRight.getCurrentPosition() != frontRight.getTargetPosition()) {
            frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        }
    }
    public void reset() {
        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
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
    public void moveLeft(int distance) {
        reset();
        backLeft.setTargetPosition(distance);
        backRight.setTargetPosition(-distance);
        frontLeft.setTargetPosition(-distance);
        frontRight.setTargetPosition(distance);
        runWheels();
    }
    public void moveRight(int distance) {
        reset();
        backLeft.setTargetPosition(-distance);
        backRight.setTargetPosition(distance);
        frontLeft.setTargetPosition(distance);
        frontRight.setTargetPosition(-distance);
        runWheels();

    } //added turning
    public void turnRight(int distance) {
        reset();
        backLeft.setPower(0.6); backRight.setPower(-0.6); frontLeft.setPower(0.6); frontRight.setPower(-0.6);
        runWheels();
    }
    public void turnLeft(int distance) {
        reset();
        backLeft.setPower(-0.6); backRight.setPower(0.6); frontLeft.setPower(-0.6); frontRight.setPower(0.6);
        runWheels();
    }

    public void scenario1(int distance) {

        reset();
        moveLeft(distance*2);
        //what are we scanning
    }

}
