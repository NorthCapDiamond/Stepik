public class Main {
    /** This Method is going to find the way to the (toX, toY) location*/

    /* first version of this task:
        public static void moveRobot(Robot robot, int toX, int toY){
        if (robot.getY()<toY){
            while (robot.getDirection()!=Direction.UP) robot.turnLeft();
            while (robot.getY()<toY) robot.stepForward();
        }
        if (robot.getY()>toY){
            while (robot.getDirection()!=Direction.DOWN) robot.turnLeft();
            while (robot.getY()>toY) robot.stepForward();
        }
        if (robot.getX()<toX){
            while (robot.getDirection()!=Direction.RIGHT) robot.turnLeft();
            while (robot.getX()<toX) robot.stepForward();
        }
        if (robot.getX()>toX){
            while (robot.getDirection()!=Direction.LEFT) robot.turnLeft();
            while (robot.getX()>toX)robot.stepForward();
        }
        return;
    } */

    //task_2. you need to understand try-catch-finally; 
    public static void moveRobot( RobotConnectionManager robotConnectionManager,int x, int y) {
        RobotConnection connection = null;
        for (int i = 0; i < 3; i++) {
            try {
                connection = robotConnectionManager.getConnection();
                connection.moveRobotTo(x,y);
                return;

            }catch (RobotConnectionException exception){
                if(i==2)throw exception;
            }

            finally {
                if(connection!=(null)){
                    try{
                        connection.close();
                    }catch (Exception e){}
                }
            }
        }
    }






    /** Testing*/
    public static void main(String[] args) {
        Robot robot = new Robot();

        // here you can write some code for checking


    }
}
