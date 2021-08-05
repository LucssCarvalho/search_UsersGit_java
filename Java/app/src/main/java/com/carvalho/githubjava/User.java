package com.carvalho.githubjava;

import java.io.Serializable;

public class User implements Serializable {
    private String name, userName, organization, bio, avatarUrl;
    private int followers, following, repositories;


    public User(String name, String userName, String organization, String bio, int followers, int following, int repositories, String avatarUrl) {
        this.name = name;
        this.userName = userName;
        this.organization = organization;
        this.bio = bio;
        this.followers = followers;
        this.following = following;
        this.repositories = repositories;
        this.avatarUrl = avatarUrl;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public String getName() {
        return name;
    }

    public String getUserName() {
        return userName;
    }

    public String getOrganization() {
        return organization;
    }

    public String getBio() {
        return bio;
    }

    public int getFollowers() {
        return followers;
    }

    public int getFollowing() {
        return following;
    }

    public int getRepositories() {
        return repositories;
    }


}
