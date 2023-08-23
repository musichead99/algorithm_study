import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class algorithm_2174 {

    private static class Robot {
        public int x;
        public int y;
        public char direction; // 0, 1, 2, 3   E, S, W, N

        public Robot(int x, int y, char direction) {
            this.x = x;
            this.y = y;
            this.direction = direction;
        }
    }

    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, -1, 0, 1};

    private static int a;
    private static int b;
    private static ArrayList<Robot> robots = new ArrayList<>();

    private static String msg = "OK";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        robots.add(new Robot(-1, -1, 'X')); // 더미 로봇

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            char direction = st.nextToken().charAt(0);
            robots.add(new Robot(x, y, direction));
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int robotNum = Integer.parseInt(st.nextToken());
            char instruction = st.nextToken().charAt(0);
            int times = Integer.parseInt(st.nextToken());
            if(!runningInstruction(robotNum, instruction, times)) {
                break;
            }
        }

        System.out.println(msg);
    }

    private static boolean runningInstruction(int robotNum, char instruction, int times) {
        if(instruction == 'F') {
            return move(robotNum, instruction, times);
        } else {
            rotate(robotNum, instruction, times);
            return true;
        }
    }

    private static void rotate(int robotNum, char instruction, int times) {
        Robot robot = robots.get(robotNum);
        int index = getRotateIndex(robot.direction);

        if(instruction == 'L') {
            int rotateDirection = -1;
            for(int i = 0; i < times; i++) {
                if(index == 0) {
                    index = 4;
                }

                index = index + rotateDirection;
            }
        } else {
            int rotateDirection = 1;
            for(int i = 0; i < times; i++) {
                index = (index + rotateDirection) % 4;
            }
        }

        robot.direction = getDirectionChar(index);
    }

    private static boolean move(int robotNum, char instruction, int times) {
        Robot robot = robots.get(robotNum);
        int index = getRotateIndex(robot.direction);

        for(int i = 0; i < times; i++) {
            int nx = robot.x + dx[index];
            int ny = robot.y + dy[index];

            if(!boundaryCheck(nx, ny, robotNum)) {
                return false;
            }

            if(!collisionCheck(nx, ny, robotNum)) {
                return false;
            }

            robot.x = nx;
            robot.y = ny;
        }

        return true;
    }

    private static boolean boundaryCheck(int nx, int ny, int robotNum) {
        if(nx > a || nx < 1 || ny > b || ny < 1) {
            msg = "Robot " + robotNum + " crashes into the wall";
            return false;
        }

        return true;
    }

    private static boolean collisionCheck(int nx, int ny, int robotNum) {
        for(int i = 1; i < robots.size(); i++) {
            Robot robot = robots.get(i);

            if(robot.x == nx && robot.y == ny) {
                msg = "Robot " + robotNum + " crashes into robot " + i;
                return false;
            }
        }

        return true;
    }   

    private static int getRotateIndex(char direction) {
        switch(direction) {
            case 'E':
                return 0;
            case 'S':
                return 1;
            case 'W':
                return 2;
            case 'N':
                return 3;
            default:
                return -1;
        }
    }

    private static char getDirectionChar(int index) {
        switch(index) {
            case 0:
                return 'E';
            case 1:
                return 'S';
            case 2:
                return 'W';
            case 3:
                return 'N';
            default:
                return 'X';
        }
    }
}
