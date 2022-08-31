import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] emails = new String[] {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        System.out.println(Arrays.toString(emails));
        System.out.println("Trong các email trên có " +numUniqueEmails(emails)+ " email là unique.");
    }

    public static int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String s : emails) {
            StringBuilder sb = new StringBuilder();
            char[] c = s.substring(0, s.indexOf("@")).toCharArray();
            for (char ch : c) {
                if (ch == '+') {
                    break;
                } else if (ch == '.') {
                    continue;
                } else {
                    sb.append(ch);
                }
            }
            sb.append(s.substring(s.indexOf("@")));
            set.add(sb.toString());
        }
        return set.size();
    }
}
