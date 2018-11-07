package com.example.groustu.groustu;

// User class needs to communicate with SQL Database
// We don't have SQL Database yet

class User {
    private String username;
    private String userAvatar;
    private StudyGroup[] userGroups;
    private String userDescription;
    private boolean expert;
    private String expertCourses;

    // Constructor. To be completed
    public User() {

    }

    public String getUname() {
        return username;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public StudyGroup[] getUserGroups() {
        return userGroups;
    }

    public String getUserDescription() {
        return userDescription;
    }

    public boolean isExpert() {
        return expert;
    }

    public String getExpertCourses() {
        return expertCourses;
    }

    public void setUname(String username) {
        this.username = username;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    public void addUserGroup(StudyGroup sg) {
        // to be completed
    }

    public void deleteUserGroup(StudyGroup sg) {
        // to be completed
    }

    public void setUserDescription(String description) {
        this.userDescription = description;
    }

    public void setIsExpert(boolean expert) {
        this.expert = expert;
    }

    public void setExpertCourses(String expertCourses) {
        this.expertCourses = expertCourses;
    }

    // get all experts method to be implemented
}