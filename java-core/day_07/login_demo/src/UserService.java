public class UserService {

    public Users[] getAllUsers(){
        Users[] arr = new Users[3];
        arr[0] = new Users(1, "ngoc", "ngoc@gmail.com", "123456");
        arr[1] = new Users(2, "quang", "quang@gmail.com", "123456");
        arr[2] = new Users(3, "hung", "hung@gmail.com", "123456");
        return arr;
    }

    public boolean checkLogin(String email, String password, Users[] arr){
        boolean flag = false;
        for(Users u : arr){
            if(u.getEmail().equals(email) && u.getPassword().equals(password)){
                flag = true;
            }
        }
        return flag;
    }

    public Users checkLoginReturnUser(String email, String password, Users[] arr){
        Users users = null;
        for(Users u : arr){
            if(u.getEmail().equals(email) && u.getPassword().equals(password)){
                users = u;
            }
        }
        return users;
    }
}