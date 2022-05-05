package com.fc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recommend  implements Serializable {
    private Integer rid;

    private Integer rtype;

    private Integer bid;
}