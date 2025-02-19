package org.ticket.booking.entities;

import java.util.List;

import static com.sun.xml.internal.ws.policy.sourcemodel.wspolicy.XmlToken.Name;

public class User {

    private String name;

    private String password;

    private String hashpassword;

    private List<Ticket> ticketsBooked;

    private String userId;

    public User(String name, String password, String hashpassword, List<Ticket> ticketsBooked, String userId) {

        this.name = name;
        this.password = password;
        this.hashpassword = hashpassword;
        this.ticketsBooked = ticketsBooked;
        this.userId = userId;

    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;

    }

    public String getHashpassword() {
        return hashpassword;

    }

    public List<Ticket> getTicketsBooked() {
        return ticketsBooked;

    }

    public void printTickets() {

        for (int i = 0; i < ticketsBooked.size(); i++) {
            System.out.println(ticketsBooked.get(i).getTicketInfo());
        }
    }

    public String getUserId() {
        return userId;

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHashpassword(String hashpassword) {
        this.hashpassword = hashpassword;

    }
    public void setTicketsBooked(List<Ticket> ticketsBooked){
        this.ticketsBooked = ticketsBooked;

    }
    public void setUserId(String userId){
        this.userId = userId;
    }
}






