package view;

import controller.BillManager;
import controller.CustomerManager;
import controller.RoomManager;
import controller.StaffManager;
import model.Bill;
import model.Customer;
import model.RoomHotel;
import model.Staff;
import storage.fileBill;
import storage.fileCustomer;
import storage.fileRoomHotel;
import storage.fileStaff;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class BillClient {
    public static void main(String[] args) {
       List<Customer> customerList =null;
       try{
           customerList = fileCustomer.readFile();
       }catch (ClassNotFoundException e){
           e.printStackTrace();
       }catch (IOException e){
           e.printStackTrace();
       }
       List<Staff> staffList = null;
        try{
            staffList = fileStaff.readFile();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        List<RoomHotel> roomHotelList = null;
        try{
            roomHotelList = fileRoomHotel.readFile();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        List<Bill> billList = null;
        try{
            billList = fileBill.readFile();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        BillManager billManager = new BillManager(billList);
        Scanner sc = new Scanner(System.in);
        int number =1;
        while(number!=0){
            System.out.println("ẤN 1 để book phòng cho khách");
            System.out.println("ẤN 2 để  thanh toán cho khách");
            System.out.println("Ấn 3 để xem tổng thu nhập của tháng");
            System.out.println("ẤN 4 để xem tất cả phòng khách đang ở");

            System.out.println("Ấn 0 để thoát chương trình");
            int numbers = sc.nextInt();
            switch (numbers){
                case 1:
                    try {
                        sc.nextLine();
                        System.out.println("Nhập mã bill");
                        String billCode = sc.nextLine();
                        System.out.println("Nhập tên khách hàng");
                        String customerName = sc.nextLine();
                        CustomerManager customerManager = new CustomerManager(customerList);
                        Customer customer = customerManager.findCustomerbyName(customerName);
                        if(customer==null){
                            System.out.println("không tìm thấy");
                        }
                        System.out.println("Nhập mã nhân viên");
                        String staffCode = sc.nextLine();
                        StaffManager staffManager = new StaffManager(staffList);
                        Staff staff = staffManager.findStaffbyCode(staffCode);
                        if(staff== null){
                            System.out.println("không tìm thấy");
                        }
                        System.out.println("Nhập mã phòng");
                        String roomCode = sc.nextLine();
                        RoomManager roomManager = new RoomManager(roomHotelList);
                        RoomHotel roomHotel = roomManager.findRoombyCode(roomCode);
                        if(roomHotel == null){
                            System.out.println("Không tìm thấy");
                        }
                        roomHotel.setStatus("Đang ở");
                        roomManager.addRoom(roomHotel);
                        System.out.println("Nhập ngày bắt đầu ở");
                        LocalDate dayStart = LocalDate.of(sc.nextInt(),sc.nextInt(),sc.nextInt());
                        if(customer!=null&&staff!=null&&roomHotel!=null){
                            Bill  bill = new Bill(billCode,customer,staff,roomHotel,dayStart);
                            billManager.addBill(bill);
                        }
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    try {
                        sc.nextLine();
                        System.out.println("Nhập mã bill");
                        String billCode = sc.nextLine();
                        System.out.println("Nhập tên khách hàng");
                        String customerName = sc.nextLine();
                        CustomerManager customerManager = new CustomerManager(customerList);
                        Customer customer = customerManager.findCustomerbyName(customerName);
                        if(customer==null){
                            System.out.println("không tìm thấy");
                        }
                        System.out.println("Nhập mã nhân viên");
                        String staffCode = sc.nextLine();
                        StaffManager staffManager = new StaffManager(staffList);
                        Staff staff = staffManager.findStaffbyCode(staffCode);
                        if(staff== null){
                            System.out.println("không tìm thấy");
                        }
                        System.out.println("Nhập mã phòng");
                        String roomCode = sc.nextLine();
                        RoomManager roomManager = new RoomManager(roomHotelList);
                        RoomHotel roomHotel = roomManager.findRoombyCode(roomCode);
                        if(roomHotel == null){
                            System.out.println("Không tìm thấy");
                        }
                        roomHotel.setStatus("Đang sửa");
                        System.out.println("Nhập ngày bắt đầu ở");
                        LocalDate dayStart = LocalDate.of(sc.nextInt(),sc.nextInt(),sc.nextInt());
                        System.out.println("Nhập ngày kết thúc");
                        LocalDate endStart = LocalDate.of(sc.nextInt(),sc.nextInt(),sc.nextInt());
                        if(customer!=null&&staff!=null&&roomHotel!=null){
                            Bill  bill = new Bill(billCode,customer,staff,roomHotel,dayStart,endStart);
                            billManager.addBill(bill);
                        }
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                    break;

                case 3:
                    System.out.println("Nhập ngày bắt đầu của tháng");
                    LocalDate startMonth = LocalDate.of(sc.nextInt(),sc.nextInt(), sc.nextInt());
                    System.out.println("Nhập ngày kết thúc của tháng");
                    LocalDate endMonth = LocalDate.of(sc.nextInt(),sc.nextInt(),sc.nextInt());
                    billManager.totalMoneyInMonth(startMonth,endMonth);

                case 4:
                    billManager.showAllBook();

                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("No choice");
                    break;
            }
        }

    }
}
