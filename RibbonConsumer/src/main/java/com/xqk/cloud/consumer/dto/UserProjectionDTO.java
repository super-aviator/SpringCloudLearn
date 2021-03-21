package com.xqk.cloud.consumer.dto;

import lombok.Getter;
import lombok.ToString;

/**
 * @author 熊乾坤
 * @date 2019/10/4 8:52
 */
@Getter
@ToString
public class UserProjectionDTO {
    /**
     * 使用Projection时，字段必须为final修饰
     */
    private final String name, email;

    /**
     * Instantiates a new User projection dto.
     *
     * @param name  the name
     * @param email the email
     */
    public UserProjectionDTO(String name, String email) {
        this.name = name;
        this.email = email;
    }
}