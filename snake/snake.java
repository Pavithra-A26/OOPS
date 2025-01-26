import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class snake {
    private char[][] snakeboard = null;
    private Queue<Node> queue = new LinkedList<>();
    private Queue<Node> food = new LinkedList<>();

    snake(int row,int col){
        snakeboard = new char[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                snakeboard[i][j] = ' '; // Initialize board with blank spaces
            }
        }

        // Initialize the snake at the top-left corner
        queue.add(new Node(0, 0));
        snakeboard[0][0] = '.'; 

        food.add(new Node(4,0));
        food.add(new Node(2,2));
        food.add(new Node(3,4));
        food.add(new Node(5,2));
        food.add(new Node(4,5));

        displayFood(food.poll());
    }

    public void initiateSnake(){
        int row=0;
        int col=0;
        snakeboard[row][col]='.';

        while(true){
            printsnake();
            System.out.println("Enter a position : ");
            Scanner sc= new Scanner(System.in);
            char direction = sc.next().charAt(0);

            if(direction == 'U'){
                snakemove(--row, col);
            }
            else if(direction=='D'){
                snakemove(++row, col);
            }
            else if(direction=='L'){
                snakemove(row, --col);
            }
            else if(direction=='R'){
                snakemove(row, ++col);
            }
        }
    }

    public void snakemove(int row,int col){
        if(row>=0 && row<snakeboard.length && col>=0 && col<snakeboard[0].length){
            queue.add(new Node(row,col));

            if (snakeboard[row][col] == 'X') {
                if (food.isEmpty()) {
                    moveforwardAndPrint(row, col);
                    System.out.println("You Win!");
                    System.exit(0);
                }
                displayFood(food.poll());
            } else if (snakeboard[row][col] == '.') {
                System.out.println("Game Over! You hit yourself.");
                System.exit(0);
            } else {
                // Remove the tail (if no food eaten)
                Node tail = queue.poll();
                snakeboard[tail.getrow()][tail.getcolumn()] = ' ';
            }

            // Move the snake forward
            moveforwardAndPrint(row, col);
        } else {
            System.out.println("Invalid Move! Out of bounds.");
            System.exit(0);
        }
    }

    public void displayFood(Node node){
        int r=node.getrow();
        int c= node.getcolumn();
        snakeboard[r][c]='X';
    }

    public void moveforwardAndPrint(int row,int col){
        snakeboard[row][col] = '.';
        printsnake();
    }

    public void printsnake(){
        for(char[] chars:snakeboard){
            for(int j=0;j<snakeboard[0].length;j++){
                System.out.print(chars[j]+" ");
            }
            System.out.println();
        }
    }
}
