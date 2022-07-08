public class User {
    private String phoneNumber;
    private String soTK;
    private String password;


    private long soDu;

    public User() {
    }

    public User(String phoneNumber, String soTK, String password, long soDu) {
        this.phoneNumber = phoneNumber;
        this.soTK = soTK;
        this.password = password;
        this.soDu = soDu;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSoTK() {
        return soTK;
    }

    public void setSoTK(String soTK) {
        this.soTK = soTK;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getSoDu() {
        return soDu;
    }

    public void setSoDu(long soDu) {
        this.soDu = soDu;
    }

    @Override
    public String toString() {
        return soTK + "-" + phoneNumber + " - " + password + " - " + soDu;
    }
}
