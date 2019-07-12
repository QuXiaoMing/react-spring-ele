package com.shellming.eleservice.vo;

import com.shellming.eleservice.entity.User;
import lombok.Data;

@Data
public class UserVo extends User {
    @Override
    public String getPassword() {
        return null;
    }
}
