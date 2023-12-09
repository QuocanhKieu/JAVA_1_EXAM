package classList;

import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.time.LocalDate;

public class Class {
    private String className;
    private String phongHoc;
    private String maLop;
    private LocalDate startDate;

    private String tenChuongTrinh;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getPhongHoc() {
        return phongHoc;
    }

    public void setPhongHoc(String phongHoc) {
        this.phongHoc = phongHoc;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public String getTenChuongTrinh() {
        return tenChuongTrinh;
    }

    public void setTenChuongTrinh(String tenChuongTrinh) {
        this.tenChuongTrinh = tenChuongTrinh;
    }

    public Class(String className, String phongHoc, String maLop, LocalDate startDate, String tenChuongTrinh) {
        this.className = className;
        this.phongHoc = phongHoc;
        this.maLop = maLop;
        this.startDate = startDate;
        this.tenChuongTrinh = tenChuongTrinh;
    }

    public String toString(){
        return className+"\n"+phongHoc+"\n"+maLop+"\n"+startDate
                +"\n"+tenChuongTrinh;
    }
}
