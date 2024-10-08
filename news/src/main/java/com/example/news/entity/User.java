package com.example.news.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "u_id")),
        @AttributeOverride(name = "createdBy", column = @Column(name = "u_createBy")),
        @AttributeOverride(name = "createdDate", column = @Column(name = "u_createDate")),
        @AttributeOverride(name = "modifiedBy", column = @Column(name = "u_modifiedBy")),
        @AttributeOverride(name = "modifiedDate", column = @Column(name = "u_modifiedDate"))
})
@Table(name = "user")
public class User extends Base {

    @Column(name = "u_username")
    String userName;

    @Column(name = "u_password")
    String password;

    @Column(name = "u_fullname")
    String fullName;

    @Column(name = "u_email")
    String email;

    @Column(name = "u_googleId")
    String googleId;

    @Column(name = "u_avatar")
    String avatar;

    @Column(name = "u_dob")
    Date dob;

    @Column(name = "u_phoneNumber")
    String phoneNumber;

    @Column(name = "u_status")
    int status;

    @ManyToMany
    @JoinTable(
            name = "favorite",
            joinColumns = @JoinColumn(name = "u_id"),
            inverseJoinColumns = @JoinColumn(name = "n_id")
    )
    Set<News> favoriteNews;

    @OneToMany(mappedBy = "user")
    List<Comment> comments;

    @ManyToOne
    @JoinColumn(name = "r_id")
    @JsonManagedReference // Tránh vòng lặp
    Role role;

}
