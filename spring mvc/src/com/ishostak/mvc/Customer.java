package com.ishostak.mvc;

import javax.validation.constraints.*;

public class Customer {

    @NotNull(message = "is required")
    @Size(min=1, message = "is required")
    private String firstName;

    @NotNull(message = "is required")
    @Min(value = 0, message = "must be greater or equal to zero")
    @Max(value = 10, message = "must be less or equal to 10")
    private Integer freePasses;

    @NotNull(message = "is required")
    @Size(min=1, message = "is required")
    private String lastName;

    @Pattern(regexp = "^[a-zA-Z0-9]{0,5}", message = "only 5 digits")
    private String postalCode;

    @CourseCode(value = "TOPS", message = "Must start with TOPS")
    private String courseCode;

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
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

    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(int freePasses) {
        this.freePasses = freePasses;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
