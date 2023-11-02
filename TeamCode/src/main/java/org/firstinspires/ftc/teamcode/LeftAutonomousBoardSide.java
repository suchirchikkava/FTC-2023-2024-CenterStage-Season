package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;

public class LeftAutonomousBoardSide extends HoratioAiAutonomous
{
    private DcMotor backLeft;
    private DcMotor backRight;
    private DcMotor frontLeft;
    private DcMotor frontRight;
    public void runOpMode()
    {
        waitForStart();
        backLeft   = hardwareMap.get(DcMotor.class, "backLeft");
        backRight  = hardwareMap.get(DcMotor.class, "backRight");
        frontLeft  = hardwareMap.get(DcMotor.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");

        backLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        backLeft.setDirection(DcMotor.Direction.REVERSE);
        frontLeft.setDirection(DcMotor.Direction.REVERSE);

        backLeft.setPower(0.6);
        backRight.setPower(0.6);
        frontLeft.setPower(0.6);
        frontRight.setPower(0.6);

        doShit();
    }

    public void doShit() //Front wheels facing East relative to game board
    {
        moveForward();//move to mark for scanning
        //scan mark perpendicylar to board shit
        sleep(1000);
        turnLeft();
        //scan mark facing board, do cool shit
        sleep(1000);
        moveForward();//move to board, TETRIS TIME!!!!
        //I LOVE TETRIS!!!!!
        sleep(1000);
        moveForward();//park, if teamates want to park in front of board we use ohter code :3
        sleep(1000);
    }
}
