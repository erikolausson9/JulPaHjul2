package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookingRepository {

    @Autowired
    DataSource dataSource;

    private List<Booking> bookings;

    public BookingRepository () {
        bookings = new ArrayList<>();
    }

    public Booking rsBooking(ResultSet rs) throws SQLException{
        Booking booking = new Booking();
        booking.setBookingId(rs.getInt("BokningsId"));
        booking.setPeople(rs.getInt("AntalPersoner"));
        booking.setDay(rs.getString("BokningsDag"));
        booking.setTime(rs.getString("BokningsTid"));
        booking.setEmail(rs.getString("EmailAdress"));
        booking.setPhonenumber(rs.getString("Telefonnummer"));

        return booking;
    }

    public void addBooking(Booking bookingToAdd) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO Bokning(AntalPersoner, BokningsDag, " +
                     "BokningsTid, EmailAdress, Telefonnummer, Username) VALUES(?, ?, ?, ?, ?, ?)")) {
            ps.setInt(1, bookingToAdd.getPeople());
            ps.setString(2, bookingToAdd.getDay());
            ps.setString(3, bookingToAdd.getTime());
            ps.setString(4, bookingToAdd.getEmail());
            ps.setString(5, bookingToAdd.getPhonenumber());
            ps.setString(6, bookingToAdd.getUsername());
            ps.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<Booking> getBookings(){
        bookings.clear();
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM Bokning")){
            while(rs.next()){
                bookings.add(rsBooking(rs));
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }

        return bookings;
    }

    public List<Booking> getMyBooking(String username) {
        List<Booking> booking = new ArrayList<>();

        String SQLStatement = "SELECT * " +
                "FROM Bokning " +
                "INNER JOIN Medlem ON dbo.Bokning.MedlemsId = dbo.Medlem.MedlemsId " +
                "INNER JOIN Restaurang ON dbo.Bokning.RestaurangId = dbo.Restaurang.RestaurangId " +
                "WHERE Anvandarnamn = '" + username + "'";

        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQLStatement)){
            while(rs.next()){
                booking.add(rsGetMyBooking(rs));
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return booking;
    }

    public Booking rsGetMyBooking(ResultSet rs) throws SQLException{
        Booking booking = new Booking();

        booking.setPeople(rs.getInt("AntalPersoner"));
        booking.setDay(rs.getString("BokningsDag"));
        booking.setTime(rs.getString("BokningsTid"));
        booking.setRestaurant(rs.getString("RestaurangNamn"));
        booking.setRestaurantLank(rs.getString("Lank"));
        booking.setEmail(rs.getString("EmailAdress"));
        booking.setPhonenumber(rs.getString("Telefonnummer"));

        return booking;
    }
}
