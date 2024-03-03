package com.aplicativo.topijava.model;

import android.os.Parcel;
import android.os.Parcelable;


public class Data implements Parcelable {

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

    protected Data(Parcel in) {
        name = in.readString();
        description = in.readString();
        forks = in.readString();
        stargazers_count = in.readString();
        full_name = in.readString();
        login = in.readString();
    }

    public static final Creator<Data> CREATOR = new Creator<Data>() {
        @Override
        public Data createFromParcel(Parcel in) {
            return new Data(in);
        }

        @Override
        public Data[] newArray(int size) {
            return new Data[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(description);
        parcel.writeString(forks);
        parcel.writeString(stargazers_count);
        parcel.writeString(full_name);
        parcel.writeString(login);
    }
}
