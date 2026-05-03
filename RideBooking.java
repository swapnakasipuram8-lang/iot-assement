class Ride {
    int rideId;
    String pickup;
    String drop;
    int fare;

    Ride next;

    Ride(int id, String p, String d, int f) {
        rideId = id;
        pickup = p;
        drop = d;
        fare = f;
        next = null;
    }
}

public class RideBooking {

    Ride head = null;

    // Add new ride
    void addRide(int id, String pickup, String drop, int fare) {
        Ride newRide = new Ride(id, pickup, drop, fare);

        if (head == null) {
            head = newRide;
        } else {
            Ride temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newRide;
        }
    }

    // Delete last ride
    void deleteLastRide() {
        if (head == null) {
            System.out.println("No rides found");
            return;
        }

        if (head.next == null) {
            head = null;
            return;
        }

        Ride temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }

        temp.next = null;
    }

    // Display all rides
    void displayRides() {
        Ride temp = head;

        while (temp != null) {
            System.out.println(temp.rideId + " " + temp.pickup + " " + temp.drop + " " + temp.fare);
            temp = temp.next;
        }
    }

    // Search ride by pickup location
    void searchRide(String location) {
        Ride temp = head;

        while (temp != null) {
            if (temp.pickup.equals(location)) {
                System.out.println("Ride Found: " + temp.rideId);
                return;
            }
            temp = temp.next;
        }

        System.out.println("Ride not found");
    }

    public static void main(String[] args) {
        RideBooking r = new RideBooking();

        r.addRide(1, "Home", "College", 100);
        r.addRide(2, "College", "Mall", 80);
        r.addRide(3, "Mall", "Home", 120);

        System.out.println("All Rides:");
        r.displayRides();

        System.out.println("Search Ride:");
        r.searchRide("College");

        System.out.println("Delete Last Ride:");
        r.deleteLastRide();

        System.out.println("After Deletion:");
        r.displayRides();
    }
}