/** Robot class*/
public class Robot{
    int x = 0;
    int y = 0;
    Direction direction =  Direction.UP;
    public Robot(){

    }
    public Robot(int x, int y, Direction dir){
        this.x = x;
        this.y = y;
        this.direction = dir;
    }

    public Direction getDirection() {
        return direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public void turnLeft() {
        switch (this.getDirection()) {
            case UP:
                this.direction = Direction.LEFT;
                break;
            case DOWN:
                this.direction = Direction.RIGHT;
                break;
            case LEFT:
                this.direction = Direction.DOWN;
                break;
            case RIGHT:
                this.direction = Direction.UP;
                break;
        }
    }

    public void turnRight() {
        switch (this.getDirection()) {
            case UP:
                this.direction = Direction.RIGHT;
                break;
            case DOWN:
                this.direction = Direction.LEFT;
                break;
            case LEFT:
                this.direction = Direction.UP;
                break;
            case RIGHT:
                this.direction = Direction.DOWN;
                break;
        }
    }

    public void stepForward() {
        switch (this.getDirection()) {
            case UP:
                this.y += 1;
                break;
            case DOWN:
                this.y -= 1;
                break;
            case LEFT:
                this.x -= 1;
                break;
            case RIGHT:
                this.x += 1;
                break;
        }
    }
}