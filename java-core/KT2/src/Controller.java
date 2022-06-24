import java.io.*;
import java.util.*;

public class Controller {
    Service s = new Service();
    static ArrayList<User> listUsers;
    Scanner scanner;

    public Controller() {
        s = new Service();

        listUsers = s.getAllUsers();
        scanner = new Scanner(System.in);
    }

    public void main() {
        while (true) {
            Util.menuDNDK();
            int choose1 = Integer.parseInt(scanner.nextLine());
            switch (choose1) {
                case 1:
                    System.out.print("Nhập username : ");
                    String username = scanner.nextLine();
                    if (isValidUsernameLogin(username)) {
                        System.out.print("Nhập mật khẩu : ");
                        String password = scanner.nextLine();
                        if (isValidPWLogin(password)) {
                            System.out.println("Đăng nhập thành công");
                            System.out.println("Chào mừng " + username + ", bạn có thể thực hiện các công việc sau:");
                            Util.menuDNTK();
                            int choose2 = Integer.parseInt(scanner.nextLine());
                            switch (choose2) {
                                case 1:
                                    thayDoiUsername(username);
                                    break;
                                case 2:
                                    thayDoiEmail(username);
                                    break;
                                case 3:
                                    thayDoiPassword(password);
                                    break;
                                case 4:
                                    break;
                                case 0:
                                    System.exit(0);
                            }
                        } else {
                            Util.menuSMK();
                            int choose3 = Integer.parseInt(scanner.nextLine());
                        }
                    } else {
                        System.out.println("Kiểm tra lại username.");
                    }
                    break;
                case 2:
                    createNewUser();

            }

        }
    }

    public static boolean isValidUsernameLogin(String username) {
        boolean isValid = false;

        for (User u : listUsers) {
            if (Objects.equals(u.getUsername(), username)) {
                isValid = true;
            }
        }
        return isValid;
    }

    public static boolean isValidPWLogin(String password) {
        boolean isValid = false;

        for (User u : listUsers) {
            if (Objects.equals(u.getPassword(), password)) {
                isValid = true;
            }
        }
        return isValid;
    }

    public User findUserByUsername(String username) {
        for (User u : listUsers) {
            if (u.getUsername().contains(username)) {
                return u;
            }
        }
        return null;
    }

    public User findUserByPassword(String password) {
        for (User u : listUsers) {
            if (u.getPassword().contains(password)) {
                return u;
            }
        }
        return null;
    }


    public void thayDoiUsername(String username) {

        User u = findUserByUsername(username);
        System.out.println(u);
        System.out.println("Nhập username mới: ");
        String newUsername = scanner.nextLine();
        if (Validator.isValidUsernameReg(listUsers, newUsername)) {
            updateUsername(u, newUsername);
            System.out.println("Thay đổi username thành công.");
            System.out.println("Thông tin sau khi cập nhật: ");
            System.out.println(u);
        } else {
            System.out.println("Username đã tồn tại.");
        }

    }


    public void thayDoiPassword(String password) {
        User u = findUserByPassword(password);
        System.out.println(u);
        System.out.println("Nhập password mới: ");
        String newPassword = scanner.nextLine();
        if (Validator.isValidPasswordReg(newPassword)) {
            updatePassword(u, newPassword);
            System.out.println("Thay đổi password mới thành công.");
            System.out.println("Thông tin sau khi cập nhật: ");
            System.out.println(u);
        } else {
            System.out.println("Password không hợp lệ.");
        }
    }

    public void thayDoiEmail(String username) {
        User u = findUserByUsername(username);
        System.out.println(u);
        System.out.println("Nhập email mới: ");
        String newEmail = scanner.nextLine();
        if (Validator.isValidEmail(newEmail)) {
            updateEmail(u, newEmail);
            System.out.println("Thay đổi email thành công.");
            System.out.println("Thông tin sau khi cập nhật: ");
            System.out.println(u);
        } else {
            System.out.println("Email không hợp lệ.");
        }
    }

    public void updateUsername(User user, String newUsername) {
        user.setUsername(newUsername);
    }

    public void updatePassword(User user, String newPassword) {
        user.setPassword(newPassword);
    }

    public void updateEmail(User user, String newEmail) {
        user.setEmail(newEmail);
    }

    public void createNewUser() {
        boolean userRegValid = false;

        while (userRegValid == false) {
            System.out.println("Nhập username : ");
            String newUsername = scanner.nextLine();
            if (Validator.isValidUsernameReg(listUsers, newUsername)) {
                System.out.println("Nhập password : ");
                String newPassword = scanner.nextLine();
                if (Validator.isValidPasswordReg(newPassword)) {
                    System.out.println("Nhập email :");
                    String newEmail = scanner.nextLine();
                    if (Validator.isValidEmailReg(listUsers, newEmail)) {
                        User newUser = new User(newUsername, newPassword, newEmail);
                        listUsers.add(newUser);
                        userRegValid = true;
                        System.out.println("Đăng ký thành công.");
                        System.out.println("Danh sách tài khoản sau khi đăng ký :");
                        for (User u : listUsers){
                            System.out.println(u);
                        }
                    } else {
                        System.out.println("Email không hợp lệ.");
                    }
                } else {
                    System.out.println("Password không hợp lệ.");
                }
            } else {
                System.out.println("Username đã tồn tại.");
            }
        }
    }
}

