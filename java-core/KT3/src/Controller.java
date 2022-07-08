import java.time.LocalDate;
import java.util.*;

public class Controller {
    Service s = new Service();
    static ArrayList<User> listUsers;
    static ArrayList<LichSuGiaoDich> listLSDD;
    Scanner scanner;

    public Controller() {
        s = new Service();
        listUsers = s.getAllUsers();
        listLSDD = s.getAllUsersLSDD();
        scanner = new Scanner(System.in);
    }

    public void main(){
        while (true) {
            System.out.println("Nhập thông tin để đăng nhập.");
            System.out.println("Số điện thoại :");
            String pNumber = scanner.nextLine();
            if (isValidUsernameLogin(pNumber)){
                System.out.println("Mật khẩu :");
                String password = scanner.nextLine();
                if (isValidPWLogin(password)){
                    System.out.println("Đăng nhập thành công!");
                    System.out.println("Chào mừng " + pNumber +".");
                    inner: while (true){
                        Util.Menu();
                        int choose2 = Integer.parseInt(scanner.nextLine());
                        switch (choose2){
                            case 1:
                                truyXuatSoDu(pNumber);
                                break;
                            case 2:
                                chuyenTien(pNumber,password);
                                break;
                            case 3:
                                xemLSDD(pNumber);
                                break;
                            case 4:
                                System.out.println("Đăng xuất thành công.");
                                break inner;
                        }
                    }

                    }else {
                    System.out.println("Sai mật khẩu, vui lòng đăng nhập lại.");
                }
                } else {
                System.out.println("Sai số điện thoại, vui lòng đăng nhập lại.");
            }
        }
    }

    public static boolean isValidUsernameLogin(String pNumber) {
        boolean isValid = false;

        for (User u : listUsers) {
            if (Objects.equals(u.getPhoneNumber(), pNumber)) {
                isValid = true;
            }
        }
        return isValid;
    }

    public static boolean isValidsoTK(String pNumber) {
        boolean isValid = false;

        for (User u : listUsers) {
            if (Objects.equals(u.getSoTK(), pNumber)) {
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

    public User findUserByPhoneNumber(String pNumber) {
        for (User u : listUsers) {
            if (u.getPhoneNumber().equals(pNumber)) {
                return u;
            }
        }
        return null;
    }

    public User findUserBySoTK(String pNumber) {
        for (User u : listUsers) {
            if (u.getSoTK().equals(pNumber)) {
                return u;
            }
        }
        return null;
    }

    public LichSuGiaoDich findUserLSDDByPhoneNumber(String pNumber) {
        for (LichSuGiaoDich uLSDD : listLSDD) {
            if (uLSDD.getPhoneNumber().equals(pNumber)) {
                return uLSDD;
            }
        }
        return null;
    }



    public void truyXuatSoDu(String pNumber){
        User u = findUserByPhoneNumber(pNumber);
        long soDuTK = u.getSoDu();
        System.out.println("Số dư hiện tại của TK " +u.getSoTK()+ " là " +soDuTK);
    }

    public void chuyenTien(String pNumber, String password){
        User u = findUserByPhoneNumber(pNumber);
        long soDuTK = u.getSoDu();
        System.out.println("Số dư hiện tại của TK của bạn là " +soDuTK);
        System.out.println("Nhập số tài khoản cần chuyển đến:");
        String pNumber2 = scanner.nextLine();
        if (pNumber2.length()<8 || pNumber2.length()>16){
            System.out.println("Số tài khoản là các số gồm từ 8 đến 16 ký tự.");
        } else if (isValidsoTK(pNumber2)){
            System.out.println("Nhập lượng tiền cần chuyển:");
            long soTienDuocChuyen = Long.parseLong(scanner.nextLine());
            if (soTienDuocChuyen<50000){
                System.out.println("Lượng chuyển khoản phải lớn hơn 50000 Đồng.");
            } else if (soTienDuocChuyen>u.getSoDu()) {
                System.out.println("Lượng chuyển khoản bị quá số dư của tài khoản của bạn.");
            } else if (soTienDuocChuyen>(u.getSoDu()-50000)){
                System.out.println("Lượng chuyển khoản không hợp lệ do số dư sau chuyển khoản nhỏ hơn 50000 Đồng.");
                System.out.println("Tài khoản của bạn được chuyển nhiều nhất là " +(u.getSoDu()-50000));
            } else {
                System.out.println("Nhập lý do chuyển khoản");
                String lyDo = scanner.nextLine();
                User u2 = findUserBySoTK(pNumber2);

                System.out.println("Số dư của TK đích trước khi chuyển khoản là " +u2.getSoDu());
                u2.setSoDu(u2.getSoDu()+soTienDuocChuyen);

                System.out.println("Chuyển khoản thành công!");
                System.out.println("Số dư của TK đích sau khi chuyển khoản là " +u2.getSoDu());

                LocalDate ngayCT = LocalDate.now();
                LichSuGiaoDich lsdd = new LichSuGiaoDich(pNumber,password,u.getSoTK(),u.getSoDu(),lyDo,ngayCT,soTienDuocChuyen,u2.getSoTK());
                listLSDD.add(lsdd);

                u.setSoDu(u.getSoDu()-soTienDuocChuyen);
                System.out.println("Số dư hiện tại của TK của bạn sau khi chuyển khoản là " +u.getSoDu());
            }
        }else {
            System.out.println("Sai số tài khoản hoặc tài khoản không tồn tại.");
        }
    }

    public void xemLSDD(String pNumber){
        for (LichSuGiaoDich u : listLSDD){
            if (u.getPhoneNumber().equals(pNumber)){
                System.out.println(u);
            }
        }
    }
}
