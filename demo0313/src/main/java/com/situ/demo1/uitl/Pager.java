package com.situ.demo1.uitl;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Pager {
    private Integer pageNo;
    private Integer pageSize;
}
