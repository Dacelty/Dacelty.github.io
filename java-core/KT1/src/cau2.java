public class cau2 {
    public static void main(String[] args) {
        String yolo = "You only live once, but if you do it right, once is enough";
        int soTu=0, soKyTuO=0;

        String words[]=yolo.split(" ");

        for(String w: words){
            soTu=soTu+1;
        }
        System.out.println("Chuỗi có "+soTu+" từ");

        for (int i=0; i<yolo.length(); i++){
            if (yolo.charAt(i)=='o'){
                soKyTuO=soKyTuO+1;
            }
        }
        System.out.println("Chuỗi có "+soKyTuO+" ký tự o.");
    }
}
