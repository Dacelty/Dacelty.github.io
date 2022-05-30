public class Main {
    public static void main(String[] args) {
        double diemToan = 5.5;
        double diemVan = 4.0;
        double diemLy = 3.25;
        double diemHoa = 6.0;
        double tbc = (diemToan + diemVan + diemLy + diemHoa)/4;
        System.out.println(tbc > 5 ? "Đạt" : "Trượt");
    }
}
