package com.opot.count.entity;

import lombok.Data;

@Data
public class Count {
    private String username;
    private int today;
    private int yesterday;
    private int dayBeforeYesterday;
}
