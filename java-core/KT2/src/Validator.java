import java.util.ArrayList;

public class Validator {



    public static boolean isValidPasswordReg(String password)
    {
        boolean isValid = true;
        if (password.length() > 15 || password.length() < 7)
        {
            System.out.println("Mật khẩu phải từ 7-15 ký tự");
            isValid = false;
        }

        String upperCaseChars = "(.*[A-Z].*)";
        if (!password.matches(upperCaseChars ))
        {
            System.out.println("Mật khẩu phải có ít nhật 1 ký tự hoa");
            isValid = false;
        }

        if (!(password.contains("@") || password.contains("#")
                || password.contains("!") || password.contains("~")
                || password.contains("$") || password.contains("%")
                || password.contains("^") || password.contains("&")
                || password.contains("*") || password.contains("(")
                || password.contains(")") || password.contains("-")
                || password.contains("+") || password.contains("/")
                || password.contains(":") || password.contains(".")
                || password.contains(", ") || password.contains("<")
                || password.contains(">") || password.contains("?")
                || password.contains("|"))) {
            System.out.println("Mật khẩu phải có ít nhất 1 ký tự đặc biệt.");
            isValid = false;
        }
        return isValid;
    }

    public static boolean isValidEmail(String email){
        boolean isValid = true;
        String regex = "^[a-z][a-z0-9_\\.]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$";
        if (!email.matches(regex)){
            System.out.println("\"Email không hợp lệ");
            isValid = false;
        }
        return isValid;
    }

    public static boolean isValidUsernameReg(ArrayList<User> list, String username){
        boolean isValid = true;
        for (User u : list){
            if (u.getUsername().equals(username)){
                isValid = false;
            }
        }
        return isValid;
    }

    public static boolean isValidEmailReg(ArrayList<User> list, String email){
        boolean isValid = true;
        String regex = "^[a-z][a-z0-9_\\.]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$";
        for (User u : list){
            if (u.getEmail().equals(email) || !email.matches(regex)){
                isValid = false;
            }
        }
        return isValid;
    }


}
