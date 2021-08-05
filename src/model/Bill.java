package model;

import java.io.Serializable;
import java.time.LocalDate;

public class Bill implements Serializable {
    private String billCode;
    private Customer customer;
    private Staff staff;
    private RoomHotel roomHotel;
    private LocalDate dayStart;
    private LocalDate dayEnd;


    public Bill(String billCode, Customer customer, Staff staff, RoomHotel roomHotel, LocalDate dayStart, LocalDate dayEnd) {
        this.customer = customer;
        this.staff = staff;
        this.roomHotel = roomHotel;
        this.dayStart = dayStart;
        this.dayEnd = dayEnd;
        this.billCode = billCode;
    }
    public Bill(String billCode, Customer customer, Staff staff, RoomHotel roomHotel, LocalDate dayStart){
        this.billCode = billCode;
        this.customer = customer;
        this.staff = staff;
        this.roomHotel = roomHotel;
        this.dayStart = dayStart;
    }

    public String getBillCode() {
        return billCode;
    }

    public void setBillCode(String billCode) {
        this.billCode = billCode;
    }

    public Customer getCustomer() {
        return customer;
    }

    public  void setCustomer(Customer Customer) {
        this.customer = Customer;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public RoomHotel getRoomHotel() {
        return roomHotel;
    }

    public void setRoomHotel(RoomHotel roomHotel) {
        this.roomHotel = roomHotel;
    }

    public LocalDate getDayStart() {
        return dayStart;
    }

    public void setDayStart(LocalDate dayStart) {
        this.dayStart = dayStart;
    }

    public LocalDate getDayEnd() {
        return dayEnd;
    }

    public void setDayEnd(LocalDate dayEnd) {
        this.dayEnd = dayEnd;
    }
    public double getMoneyRoom(){
       return  (dayEnd.getDayOfMonth()-dayStart.getDayOfMonth())*roomHotel.getRoomPrice();
    }

    @Override
    public String toString() {
        return "model.Bill{" +
                "billCode='" + billCode + '\'' +
                ", customer=" + customer +
                ", staff=" + staff +
                ", roomHotel=" + roomHotel +
                ", dayStart=" + dayStart +
                ", dayEnd=" + dayEnd + "MoneyRoom" +
                '}';
    }
}
