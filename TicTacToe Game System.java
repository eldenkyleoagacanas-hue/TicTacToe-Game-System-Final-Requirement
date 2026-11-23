import java.util.*;
public class Main {
    static Scanner in = new Scanner(System.in);
    static Random r = new Random();
    static char[] b = new char[9];
    static int p=0, c=0, d=0;
    static int[][] w = {{0,1,2},{3,4,5},{6,7,8},
        {0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1. Play Game\n2. Scoreboard\n3. Exit");
            System.out.print("Choose: ");
            String x = in.nextLine();
            if (x.equals("1")) play();
            else if (x.equals("2"))
                System.out.println("PLAYER: "+p+"\nCOMPUTER: "+c+"\nDRAWS: "+d);
            else if (x.equals("3")) break;
            else System.out.println("Invalid choice!");
        }
        System.out.println("Thank you for playing!");
    }
    static void play() {
        do {
            Arrays.fill(b,' ');
            System.out.println("\nYOU = X | COMPUTER = O");
            while (true) {
                show();
                int m;
                do {
                    System.out.print("Your turn (1-9): ");
                    try { m = Integer.parseInt(in.nextLine())-1; }
                    catch (Exception e) { m = -1; }
                } while (m<0 || m>8 || b[m]!=' ');
                b[m]='X';
                if (check('X')) { p++; System.out.println("YOU WIN!"); break; }
                if (draw()) { d++; System.out.println("DRAW!"); break; }
                do { m=r.nextInt(9); } while (b[m]!=' ');
                b[m]='O';
                if (check('O')) { c++; System.out.println("COMPUTER WINS!"); break; }
                if (draw()) { d++; System.out.println("DRAW!"); break; }
            }
            show();
            System.out.println("1. Play Again\n2. Main Menu");
        } while (in.nextLine().equals("1"));
    }
    static void show() {
        for (int i=0;i<9;i+=3) {
            System.out.println(" "+cell(i)+" | "+cell(i+1)+" | "+cell(i+2));
            if (i<6) System.out.println("---+---+---");
        }
    }
    static String cell(int i) {
        return b[i]==' ' ? ""+(i+1) : ""+b[i];
    }
    static boolean check(char s) {
        for (int[] a:w)
            if (b[a[0]]==s && b[a[1]]==s && b[a[2]]==s) return true;
        return false;
    }
    static boolean draw() {
        for (char x:b) if (x==' ') return false;
        return true;
    }
}
