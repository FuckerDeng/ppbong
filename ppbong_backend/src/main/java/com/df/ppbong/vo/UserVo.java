package com.df.ppbong.vo;


import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Data
public class UserVo {

    @NotNull
    @Length(min = 5,max = 16)
    private String username;

    @NotNull
    @Length(min = 6,max = 16)
    private String password;
    private String code;
}
