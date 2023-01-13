package org.sunny.domain;

public class User2 {
    private User user;

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "User2{" +
                "user=" + user +
                '}';
    }
}
