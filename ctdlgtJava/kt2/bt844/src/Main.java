public class Main {
    public static void main(String[] args) {
        String s = ("ab#c");
        String t = ("ad#c");
        System.out.println(backspaceCompare(s,t));
    }

    public static boolean backspaceCompare(String s, String t) {
        StringBuilder sSB = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '#') {
                if (sSB.length() > 0)
                    sSB.deleteCharAt(sSB.length() - 1);
            }else sSB.append(s.charAt(i));
        }
        StringBuilder tSB = new StringBuilder();
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == '#') {
                if (tSB.length() > 0)
                    tSB.deleteCharAt(tSB.length() - 1);
            }else tSB.append(t.charAt(i));
        }
        return sSB.toString().equals(tSB.toString());
    }
}
