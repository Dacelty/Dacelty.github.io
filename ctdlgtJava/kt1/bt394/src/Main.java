public class Main {
    public static void main(String[] args) {
        String s1 = "3[a]2[bc]";
        String s2 = "3[a2[c]]";
        System.out.println(decodeString(s1));
        System.out.println(decodeString(s2));
    }

    public static String decodeString(String s) {
        int firstR = s.indexOf(']');
        if (firstR == -1) {
            return s;
        }
        int lastL = s.substring(0, firstR).lastIndexOf('[');
        String repeat = s.substring(lastL+1, firstR);

        int p = lastL;
        StringBuilder sb = new StringBuilder();
        while (--p >= 0 && Character.isDigit(s.charAt(p)));
        int loop = Integer.parseInt(s.substring(p+1, lastL));
        while (loop-- >0) sb.append(repeat);

        sb.insert(0, s.substring(0, p+1));
        sb.append(s.substring(firstR+1));

        return decodeString(sb.toString());
    }
}
