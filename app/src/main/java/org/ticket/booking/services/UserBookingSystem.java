package org.ticket.booking.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.ticket.booking.entities.User;
import org.ticket.booking.utils.UserServicesUtil; // Import correctly

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserBookingSystem {
    private final User user;
    private final List<User> userList;
    private final ObjectMapper objectMapper = new ObjectMapper();
    private static final String USERS_PATH = "../localDb/users.json"; // Ensure correct path

    public UserBookingSystem(User user1) throws IOException {
        this.user = user1;
        File users = new File(USERS_PATH);

        // Deserialize JSON into List<User>
        if (users.exists()) {
            userList = objectMapper.readValue(users, new TypeReference<List<User>>() {});
        } else {
            userList = new ArrayList<>(); // Initialize an empty list if the file doesn't exist
        }
    }

    public Boolean loginUser() {
        class UserServicesUtil()
        {}
        Optional<User> foundUser = userList.stream()
                .filter(user -> this.user.getName().equals(user.getName()) &&
                        UserServicesUtil.checkPassword(this.user.getPassword(), user.getPassword())) // Corrected method call
                .findFirst();

        return foundUser.isPresent();
    }

    public Boolean signUp(User user1) {
        try {
            userList.add(user1);
            saveUserListToFile();
            return Boolean.TRUE;
        } catch (IOException ex) {
            return Boolean.FALSE;
        }
    }

    private void saveUserListToFile() throws IOException {
        objectMapper.writeValue(new File(USERS_PATH), userList);
    }
}
