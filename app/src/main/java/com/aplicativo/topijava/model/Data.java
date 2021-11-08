package com.aplicativo.topijava.model;

public class Data{

    private String name;
    private String description;
    private Owner owner;
    private String forks;
    private String stargazers_count;
    private String full_name;
    private String login;

    public Data(String name, String description, Owner owner, String forks, String stargazers_count, String full_name, String login) {
        this.name = name;
        this.description = description;
        this.owner = owner;
        this.forks = forks;
        this.stargazers_count = stargazers_count;
        this.full_name = full_name;
        this.login = login;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getForsk() { return forks; }
    public void setForks(String fork) { this.forks = fork; }
    public String getStargazers_count() { return stargazers_count; }
    public void setStargazers_count(String stargazers_count) { this.stargazers_count = stargazers_count; }
    public String getFull_name() { return full_name; }
    public void setFull_name(String full_name) { this.full_name = full_name; }
    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }
    public Owner getOwner() {
        return owner;
    }
    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
