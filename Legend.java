package LegendBot; 
import robocode.*;
import java.awt.Color;

// API help : http://robocode.sourceforge.net/docs/robocode/robocode/Robot.html

/**
 * Legend - a robot by (Moshiur Rahman)
 */
public class Legend extends AdvancedRobot
{
		
		boolean movingForward;
	/**
	 * run: Legend's default behavior
	 */
	public void run() {
		// Initialization of the robot should be put here
			setBodyColor(Color.blue);
			setBulletColor(Color.red);
			setGunColor(Color.black);
			setScanColor(Color.blue);
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

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		// Replace the next line with any behavior you would like
		fire(3);
		setFire(Rules.MAX_BULLET_POWER);
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		// Replace the next line with any behavior you would like
		reverseDirection();
		
	}
	
	public void reverseDirection() {
		if (movingForward) {
			setBack(40000);
			movingForward = false;
		} else {
			setAhead(40000);
			movingForward = true;
		}
	}

	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
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
