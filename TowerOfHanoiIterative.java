import java.util.Scanner;
import java.util.Stack;

public class TowerOfHanoiIterative {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Number of disks: ");
        int numDisks = scanner.nextInt();
        solveTowerOfHanoiIterative(numDisks);
    }

    public static void solveTowerOfHanoiIterative(int numDisks) {
        int totalMoves = (int) Math.pow(2, numDisks) - 1;
        char source = 'A';
        char destination = 'C';
        char auxiliary = 'B';

        // Create stacks to represent rods
        Stack<Integer> sourceStack = new Stack<>();
        Stack<Integer> destinationStack = new Stack<>();
        Stack<Integer> auxiliaryStack = new Stack<>();

        // Initialize source rod
        for (int i = numDisks; i >= 1; i--) {
            sourceStack.push(i);
        }

        // Iterate through each move and print it
        for (int move = 1; move <= totalMoves; move++) {
            if (move % 3 == 1) {
                moveDiskBetweenRods(sourceStack, destinationStack, source, destination);
            } else if (move % 3 == 2) {
                moveDiskBetweenRods(sourceStack, auxiliaryStack, source, auxiliary);
            } else if (move % 3 == 0) {
                moveDiskBetweenRods(auxiliaryStack, destinationStack, auxiliary, destination);
            }
        }
    }

    public static void moveDiskBetweenRods(Stack<Integer> source, Stack<Integer> destination, char sourceRod, char destinationRod) {
        if (!source.isEmpty() && (destination.isEmpty() || source.peek() < destination.peek())) {
            int disk = source.pop();
            destination.push(disk);
            System.out.println("Move disk " + disk + " from rod " + sourceRod + " to rod " + destinationRod);
        } else if (!destination.isEmpty() && (source.isEmpty() || destination.peek() < source.peek())) {
            int disk = destination.pop();
            source.push(disk);
            System.out.println("Move disk " + disk + " from rod " + destinationRod + " to rod " + sourceRod);
        }
    }
}
