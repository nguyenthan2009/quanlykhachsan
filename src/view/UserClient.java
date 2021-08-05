package view;

import controller.UserManager;
import model.User;
import storage.fileUser;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class UserClient {
    public static void main(String[] args) {
        List<User> userList = null;
        try {
            userList = fileUser.readFile();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        UserManager userManager = new UserManager(userList);
        Pattern pattern = Pattern.compile("^[a-z0-9]{8,}$");
        Pattern pattern1 = Pattern.compile("^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\\\.[A-Za-z0-9]+)$");
        Scanner sc = new Scanner(System.in);
        System.out.println("Mời bạn đăng kí mật khẩu");
        System.out.println("Mời bạn nhập tài khoản ");
        String user = sc.nextLine();
        int number = 1;

//        if (pattern.matcher(user).matches()) {
//            System.out.println("Mời bạn nhập mật khẩu");
//            String password = sc.nextLine();
//            if (pattern.matcher(password).matches()) {
//                System.out.println("Mời bạn nhập email");
//                String email = sc.nextLine();
//                if (pattern1.matcher(email).matches()) {
//                    System.out.println("Mời bạn nhập họ tên");
//                    String name = sc.nextLine();
//                    if (pattern.matcher(name).matches()) {
//                        System.out.println("Đăng nhập thành công");
//                        User users = new User(user, password, email, name);
//                     //   userManager.addUser(users);
//                    }
//                }
//            }
//        }



    }

}
