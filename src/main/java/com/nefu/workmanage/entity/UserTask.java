package com.nefu.workmanage.entity;


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
public class UserTask {

    public static final int UNDONE=1;
    public static final int DONE=2;
    public static final int OVERTIME=3;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String msg;
    @ManyToOne
    private User user;
    @ManyToOne
    private Task task;

    //任务状态默认未完成
    private int status=UNDONE;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",
            updatable = false,
            insertable = false)
    private LocalDateTime insertTime;
}
