import java.time.LocalDate;
import java.util.*;

public class LichSuGiaoDich extends User{
    private String lyDo;
    private LocalDate ngayCT;
    private long soTienDuocChuyen;

    String tkDich;

    public LichSuGiaoDich() {
    }

    public LichSuGiaoDich(String lyDo, LocalDate ngayCT, long soTienDuocChuyen, String tkDich) {
        this.lyDo = lyDo;
        this.ngayCT = ngayCT;
        this.soTienDuocChuyen = soTienDuocChuyen;
        this.tkDich = tkDich;
    }

    public LichSuGiaoDich(String phoneNumber, String soTK, String password, long soDu, String lyDo, LocalDate ngayCT, long soTienDuocChuyen, String tkDich) {
        super(phoneNumber, soTK, password, soDu);
        this.lyDo = lyDo;
        this.ngayCT = ngayCT;
        this.soTienDuocChuyen = soTienDuocChuyen;
        this.tkDich = tkDich;
    }

    public String getLyDo() {
        return lyDo;
    }

    public void setLyDo(String lyDo) {
        this.lyDo = lyDo;
    }

    public LocalDate getNgayCT() {
        return ngayCT;
    }

    public void setNgayCT(LocalDate ngayCT) {
        this.ngayCT = ngayCT;
    }

    public long getSoTienDuocChuyen() {
        return soTienDuocChuyen;
    }

    public void setSoTienDuocChuyen(long soTienDuocChuyen) {
        this.soTienDuocChuyen = soTienDuocChuyen;
    }

    public String getTkDich() {
        return tkDich;
    }

    public void setTkDich(String tkDich) {
        this.tkDich = tkDich;
    }

    @Override
    public String toString() {
        return ngayCT + " - " + soTienDuocChuyen + " - " + tkDich + " - " +lyDo;
    }
}
