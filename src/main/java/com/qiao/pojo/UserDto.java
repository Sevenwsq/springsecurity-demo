package com.qiao.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author Silent
 * @date 2020/3/13 23:39:20
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class UserDto{
    @Id
    private Integer id;
    private String username;
    private String password;
    private String fullName;
    private String mobile;
    private String permission;
}
