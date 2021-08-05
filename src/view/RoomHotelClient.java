package view;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import controller.RoomManager;
import model.RoomHotel;
import model.Staff;
import storage.fileRoomHotel;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class RoomHotelClient {
    public static void main(String[] args) {
        List<RoomHotel> roomHotelList = null;
        try{
            roomHotelList = fileRoomHotel.readFile();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        RoomManager roomManager = new RoomManager(roomHotelList);
        Scanner sc = new Scanner(System.in);
        int number =1;
        while(number!=0){
            System.out.println("ẤN 1 để thêm một phòng");
            System.out.println("ẤN 2 để sửa thông tin 1 phòng");
            System.out.println("Ấn 3 để xoá 1 phòng");
            System.out.println("Ấn 4 để xem trạng thái của các phòng");
            System.out.println("Ấn 5 để hiện thông tin tất cả các phòng");
            System.out.println("Ấn 0 để thoát chương trình");
            int numbers = sc.nextInt();
            switch (numbers){
                case 1:
                    try {
                        sc.nextLine();
                        System.out.println("Nhập mã phòng");
                        String roomCode = sc.nextLine();
                        System.out.println("Nhập tên phòng");
                        String nameRoom = sc.nextLine();
                        System.out.println("Nhập số toilet của phòng");
                        int toilet = sc.nextInt();
                        System.out.println("Nhập số lượng phòng ngủ của phòng");
                        int bedRoom = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Nhập trạng thái của phòng");
                        String status = sc.nextLine();
                        System.out.println("Nhập giá phòng");
                        double priceRoom = sc.nextDouble();
                        RoomHotel roomHotel = new RoomHotel(roomCode,nameRoom,toilet,bedRoom,status,priceRoom);
                        roomManager.addRoom(roomHotel);
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    try {
                        sc.nextLine();
                        System.out.println("Nhập mã phòng bạn muốn sửa");
                        String code = sc.nextLine();
                        System.out.println("Nhập mã  mới cho phòng");
                        String roomCode = sc.nextLine();
                        System.out.println("Nhập tên mới phòng");
                        String nameRoom = sc.nextLine();
                        System.out.println("Nhập số toilet mới của phòng");
                        int toilet = sc.nextInt();
                        System.out.println("Nhập số lượng phòng ngủ mới của phòng");
                        int bedRoom = sc.nextInt();
                        System.out.println("Nhập trạng thái mới của phòng");
                        String status = sc.nextLine();
                        System.out.println("Nhập giá mới của phòng");
                        double priceRoom = sc.nextDouble();
                        RoomHotel newRoomHotel = new RoomHotel(roomCode,nameRoom,toilet,bedRoom,status,priceRoom);
                        roomManager.editRoom(roomManager.getIndexbyCode(code),newRoomHotel);
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    try{
                    System.out.println("Nhập mã phòng bạn muốn xoá");
                    String roomCode = sc.nextLine();
                    roomManager.deleteRoom(roomManager.findRoombyCode(roomCode));
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    sc.nextLine();
                    System.out.println("Nhập trạng trái của phòng");
                    String status = sc.nextLine();
                    roomManager.showfocusStatus(status);
                    break;
                case 5:
                    roomManager.showAllRoom();
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("No choice");
                    break;
            }
        }
       }
}
