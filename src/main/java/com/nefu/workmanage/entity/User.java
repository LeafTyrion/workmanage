package com.nefu.workmanage.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class User {

    public static final int TEACHER=1;
    public static final int ADMIN=2;
    public static final int ROOT=3;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private  String name;
    private String title;
    private String introduce;
    private String telNum;

    private String account;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
//    没有声明默认为teacher
    private int authority=TEACHER;
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",
            updatable = false,
            insertable = false)
    private LocalDateTime insertTime;


}
