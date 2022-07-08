public class User {
    private String phoneNumber;
    private String password;

    private long soDu;

    public User() {
    }

    public User(String phoneNumber, String password, long soDu) {
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.soDu = soDu;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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
        return phoneNumber + " - " + password + " - " + soDu;
    }
}
