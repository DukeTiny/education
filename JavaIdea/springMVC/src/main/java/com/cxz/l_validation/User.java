package com.cxz.l_validation;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

    @Prime( min=100,max=200,groups = A.class)
    private Integer id;
    @Size( min=2, max=4, message = "{errors.name.size}",groups = A.class)
    @Size( min=3, max=10, message = "{errors.name.size}",groups = B.class)
    private String name;
    @NotNull(message = "This is wrong",groups = A.class)
    private Date birthday;
    private Double money;
    @Pattern(regexp = "1[35]\\d{9}", message = "{errors.cellphone.pattern}",groups = A.class)
    private String cellPhone;

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", money=" + money +
                '}';
    }
}
