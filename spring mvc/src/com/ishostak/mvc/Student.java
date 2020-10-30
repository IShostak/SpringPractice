package com.ishostak.mvc;

import java.util.LinkedHashMap;

public class Student {

    private String firstName;
    private String lastName;
    private String country;
    private String favLang;

    private String[] opSys;

    private LinkedHashMap<String, String> countryOptions;

    public Student() {

        countryOptions = new LinkedHashMap<>();

        countryOptions.put("BR", "Brazil");
        countryOptions.put("FR", "France");
        countryOptions.put("DE", "Germany");
    }

    public String getFavLang() {
        return favLang;
    }

    public void setFavLang(String favLang) {
        this.favLang = favLang;
    }

    public void setCountryOptions(LinkedHashMap<String, String> countryOptions) {
        this.countryOptions = countryOptions;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LinkedHashMap<String, String> getCountryOptions() {
        return countryOptions;
    }

    public String[] getOpSys() {
        return opSys;
    }

    public void setOpSys(String[] opSys) {
        this.opSys = opSys;
    }
}
