import java.util.*;

public class Main {
    public static void main(String[] args) {
        String ipAddress;
        Scanner scan = new Scanner(System.in);

        ipAddress = scan.nextLine();

        String regex = "((25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9]?[0-9])\\.){3}" +
                "(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9][0-9]?)";
        if(ipAddress.matches(regex)) System.out.println("YES");
        else System.out.println("NO");
    }
}