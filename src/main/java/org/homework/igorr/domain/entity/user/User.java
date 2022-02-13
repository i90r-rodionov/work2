package org.homework.igorr.domain.entity.user;

import lombok.Getter;
import lombok.Setter;
import org.homework.igorr.domain.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import static org.homework.igorr.domain.helper.DomainHelper.EMAIL_PATTERN;
import static org.homework.igorr.domain.helper.DomainHelper.PHONE_PATTERN;

@Entity
@Table(name = "T_USER")
@Getter
@Setter
public class User extends BaseEntity {

    @Column(name = "c_username")
    @Size(max = 256)
    private String username;

    @Column(name = "c_firstname")
    @Size(max = 128)
    private String firstName;

    @Column(name = "c_lastname")
    @Size(max = 128)
    private String lastName;

    @Column(name ="c_email")
    @Email
    @Size(max=256)
    private String email;

    @Column(name = "c_phone")
    @Pattern(regexp = PHONE_PATTERN)
    @Size(max = 30)
    private String phone;
}
