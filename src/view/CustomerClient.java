package view;

import controller.CustomerManager;
import model.Customer;
import model.Staff;
import storage.fileCustomer;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class CustomerClient {
    public static void main(String[] args) {
        List<Customer> customerList =null;
        try{
            customerList = fileCustomer.readFile();
        }catch (IOException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        CustomerManager customerManager = new CustomerManager(customerList);
        Scanner sc = new Scanner(System.in);
        int number =1;
        while(number!=0){
            System.out.println("ẤN 1 để thêm 1 khách");
            System.out.println("ẤN 2 để xoá 1 khách");
            System.out.println("Ấn 3 để xem tất cả khách");
            System.out.println("Ấn 0 để thoát chương trình");
            int numbers = sc.nextInt();
            switch (numbers){
                case 1:
                    try {
                        sc.nextLine();
                        System.out.println("Nhập tên khách");
                        String name = sc.nextLine();
                        System.out.println("Nhập ngày sinh của khách");
                        LocalDate bornDay = LocalDate.of(sc.nextInt(),sc.nextInt(),sc.nextInt());
                        sc.nextLine();
                        System.out.println("Nhập giới tính của khách");
                        String gender = sc.nextLine();
                        System.out.println("Nhập chứng minh thư của khách");
                        String identityCard = sc.nextLine();
                        Customer customer = new Customer(name,bornDay,gender,identityCard);
                        customerManager.addCustomer(customer);
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    try {
                        sc.nextLine();
                        System.out.println("Nhập tên khách hàng bạn muốn xoá");
                        String name1 = sc.nextLine();
                        customerManager.deleteCustomer(customerManager.findCustomerbyName(name1));
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    customerManager.showAllCustomer();
                    break;
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
