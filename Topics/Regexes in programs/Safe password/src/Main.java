import java.util.*;

public class Main {
    public static void main(String[] args) {
        String pass;
        Scanner scan = new Scanner(System.in);

        pass = scan.nextLine();

        String regex1 = ".*[A-Z]+.*";
        String regex2 = ".*[a-z]+.*";
        String regex3 = ".*[0-9]+.*";
        String regex4 = "\\w{12,}";
        if(pass.matches(regex1) && pass.matches(regex2) && pass.matches(regex3) && pass.matches(regex4)) {
            System.out.println("YES");
        }
        else System.out.println("NO");
    }
}