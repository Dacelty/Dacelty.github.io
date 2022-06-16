import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserService service = new UserService();
        Users[] arrUsers = service.getAllUsers();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập email: ");
        String email = sc.nextLine();
        System.out.println("Nhập password: ");
        String password = sc.nextLine();
        boolean checkLogin = service.checkLogin(email, password, arrUsers);

        if(checkLogin){
            System.out.println("Đăng nhập thành công");
        }else {
            System.out.println("Đăng nhập thất bại");
        }


        Users usersLogin = service.checkLoginReturnUser(email, password, arrUsers);
        if(usersLogin != null){
            System.out.println("Đăng nhập thành công");
            System.out.println("Xin chào " + usersLogin.getUserName() );
        }else {
            System.out.println("Đăng nhập thất bại");
        }
    }
}