package controller;

import model.Bill;
import storage.fileBill;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BillManager {
    List<Bill> manager = new ArrayList<>();

    public BillManager(List<Bill> manager) {
        this.manager = manager;
    }

    public List<Bill> getManager() {
        return manager;
    }

    public void setManager(List<Bill> manager) {
        this.manager = manager;
    }
    public void addBill(Bill bill) throws IOException {
        manager.add(bill);
        fileBill.writefile(manager);
    }
    public Bill findBillbyCode(String code){
        Bill  bill = null;
        for(int i=0;i<manager.size();i++){
            if(manager.get(i).getBillCode().equals(code)){
                bill = manager.get(i);
            }
        }
        return bill;
    }
    public int getIndexByCode(String code){
        int index = -1;
        for (int i=0;i<manager.size();i++){
            if(manager.get(i).getBillCode().equals(code)) {
                 index = i;
            }
        }
        return index;
    }
    public void editBill(int index,Bill newBill)throws IOException{
        manager.set(index,newBill);
        fileBill.writefile(manager);
    }
    public void deleteBill(Bill bill) throws IOException{
        manager.remove(bill);
        fileBill.writefile(manager);
    }
    public void showAllBook(){
        for (Bill bill:
             manager) {
            System.out.println(bill);
        }
    }
    public double totalMoneyInMonth(LocalDate startMonth,LocalDate endMonth){
         double totalMoney = 0;
        for(int i=0;i<manager.size();i++){
           if((manager.get(i).getDayStart().isAfter(startMonth))&&(manager.get(i).getDayEnd().isBefore(endMonth))){
               totalMoney = manager.get(i).getMoneyRoom();
           }
        }
        return totalMoney;
    }
//    public void showStatusOfRoomInTime(LocalDate localDate1,LocalDate localDate2){
//        for (int i=0;i<manager.size();i++){
//              if(manager.get(i).getDayEnd().equals("")){
//                  System.out.println(manager.get(i).getRoomHotel().getStatus());
//              }else if(((localDate1.isAfter(manager.get(i).getDayStart()))&&
//        }
//    }
}