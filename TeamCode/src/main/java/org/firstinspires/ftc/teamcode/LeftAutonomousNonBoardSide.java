package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;

public class LeftAutonomousBoardSideOne extends HoratioAiAutonomous
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
        moveForward();//move to mark, scanning time yayy
        //scan perpendicular mark
        sleep(1000);
        turnLeft();
        //scan mark facing board, take data, pop the fuck off
        sleep(1000);
        moveLeft();//prep to go through tall gate
        sleep(1000);
        moveForward();//we going through the tall gate cause we built like wembanyama
        sleep(1000);
        moveRight();//get in front of the board for tetris
        sleep(1000);
        moveForward();//go up to the board,
                      // might rearrange the movement to get to board once we pass the gate
        //              to make it better for teamates idk
        sleep(1000);
        //alright, its board time, weeeeee
        //or we just skip board and go for parking, but then we need to coordinate with tesmates,
        //we figure that shit out later, parking is dependent on that

    }
}
