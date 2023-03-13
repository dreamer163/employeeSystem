package com.situ.model;

import java.time.LocalDate;

/**
 * 用于封装查询条件的bean
 */
public class EmployeeSearchBean extends Employee {
    private LocalDate birthdayFrom;
    private LocalDate birthdayTo;

    public LocalDate getBirthdayFrom() {
        return birthdayFrom;
    }

    public void setBirthdayFrom(LocalDate birthdayFrom) {
        this.birthdayFrom = birthdayFrom;
    }

    public LocalDate getBirthdayTo() {
        return birthdayTo;
    }

    public void setBirthdayTo(LocalDate birthdayTo) {
        this.birthdayTo = birthdayTo;
    }
}
