package LegendBot;
import robocode.*;
import java.awt.Color;

// API help : http://robocode.sourceforge.net/docs/robocode/robocode/Robot.html

/**
 * Gangster - a robot by (your name here)
 */
public class Gangster extends AdvancedRobot
{

	private double x, y;
	
	public double getX(){
		return x;
	}
	
	public double getY(){
		return y;
	}
	

	public void run() {
		// Initialization of the robot should be put here
			setBodyColor(Color.red);
			setBulletColor(Color.red);
			setGunColor(Color.red);
			setScanColor(Color.red);
			setRadarColor(Color.lightGray);
			

		// initialization the movement speed
		
		double movement = Math.max(getBattleFieldWidth(),getBattleFieldHeight());
		
		turnLeft(getHeading() % 90);
		ahead(movement);
		turnGunRight(90);
		turnRight(90);

		// Robot main loop
		while(true) {
			// Replace the next 4 lines with any behavior you would like
			ahead(movement);
			turnRight(90);
		}
	}


	
	public void reset(){
		
		x = 0;
		y = 0;
	}
	
	public void update(ScannedRobotEvent e, Robot robot){
		
		double absBearingDeg= (robot.getHeading() + e.getBearing());
		if (absBearingDeg <0) absBearingDeg +=360;
		
		x = robot.getX() + Math.sin(Math.toRadians(absBearingDeg)) * e.getDistance();
		y = robot.getY() + Math.cos(Math.toRadians(absBearingDeg)) * e.getDistance();
		
	}
	
	public double getFutureX(long when){
		return x + Math.sin(Math.toRadians(getHeading())) * getVelocity() * when;
	}
	
	public double getFutureY(long when ){
		return y + Math.cos(Math.toRadians(getHeading())) * getVelocity() * when;
	}
	
	public void onScannedRobot(ScannedRobotEvent e) {
		// Replace the next line with any behavior you would like
		fire(1);
		
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		// Replace the next line with any behavior you would like
	
			setBack(40000);
			setAhead(40000);
			
		}
		
	
	public void onHitWall(HitWallEvent e) {
		// Replace the next line with any behavior you would like
			back(20);
		 	setTurnRight(90);
   			setAhead(100);
		
	}	
	
		public void onHitRobot(HitRobotEvent event) {
		       if (event.getBearing() > -90 && event.getBearing() <= 90) {
		           setBack(100);
		       } else {
		           setAhead(100);
		       }
		   }
}
