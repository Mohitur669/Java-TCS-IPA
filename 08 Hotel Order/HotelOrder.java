import java.util.Scanner;

public class HotelOrder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Hotel[] hotel = new Hotel[4];

        for (int i = 0; i < 4; i++) {
            int a = sc.nextInt();
            sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            int d = sc.nextInt();
            sc.nextLine();
            String e = sc.nextLine();
            double f = sc.nextDouble();

            hotel[i] = new Hotel(a, b, c, d, e, f);
        }

        sc.nextLine();
        String m = sc.nextLine();
        String w = sc.nextLine();

        int room = rooms(hotel, m);
        if (room > 0) {
            System.out.println(room);
        } else {
            System.out.println("No rooms booked in the given month");
        }

        Hotel ans = hotel(hotel, w);
        if (ans != null) {
            System.out.println(ans.getHotelId());
        } else {
            System.out.println("No such option available");
        }
    }

    public static int rooms(Hotel[] hotels, String m) {
        int count = 0;

        for (Hotel h : hotels) {
            if (h.getDateOfBooking().contains(m)) {
                count = count + h.getNoOfRoomsBooked();
            }
        }

        return count;
    }

    // TODO
    public static Hotel hotel(Hotel[] hotels, String wifiOption) {
        Hotel highest = null;
        Hotel secondHighest = null;

        for (Hotel hotel : hotels) {
            if (hotel.getWifiFacility().equalsIgnoreCase(wifiOption)) {
                if (highest == null || hotel.getTotalBill() > highest.getTotalBill()) {
                    secondHighest = highest;
                    highest = hotel;
                } else if (secondHighest == null || hotel.getTotalBill() > secondHighest.getTotalBill()) {
                    secondHighest = hotel;
                }
            }
        }

        return secondHighest;
    }
}

class Hotel {
    private int hotelId;
    private String hotelName;
    private String dateOfBooking;
    private int noOfRoomsBooked;
    private String wifiFacility;
    private double totalBill;

    public Hotel(int hotelId, String hotelName, String dateOfBooking, int noOfRoomsBooked, String wifiFacility, double totalBill) {
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.dateOfBooking = dateOfBooking;
        this.noOfRoomsBooked = noOfRoomsBooked;
        this.wifiFacility = wifiFacility;
        this.totalBill = totalBill;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public int getNoOfRoomsBooked() {
        return noOfRoomsBooked;
    }

    public void setNoOfRoomsBooked(int noOfRoomsBooked) {
        this.noOfRoomsBooked = noOfRoomsBooked;
    }

    public double getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(double totalBill) {
        this.totalBill = totalBill;
    }

    public String getDateOfBooking() {
        return dateOfBooking;
    }

    public void setDateOfBooking() {
        this.dateOfBooking = dateOfBooking;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName() {
        this.hotelName = hotelName;
    }

    public String getWifiFacility() {
        return wifiFacility;
    }

    public void setWifiFacility(String wifiFacility) {
        this.wifiFacility = wifiFacility;
    }
}