import java.util.*;

public class Service {

    public ArrayList<User> getAllUsers(){
        ArrayList<User> list = new ArrayList<>();
        list.add(new User("0365820366","0123456789","Kevodanh2410!",5000000));
        list.add(new User("0913503905","012345678910","Kevodanh1205!",5000000));
        return list;
    }

    public ArrayList<LichSuGiaoDich> getAllUsersLSDD(){
        ArrayList<LichSuGiaoDich> listLSDD = new ArrayList<>();
        return listLSDD;
    }
}
