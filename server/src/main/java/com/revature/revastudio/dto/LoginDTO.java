package com.revature.revastudio.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

@Data
@NoArgsConstructor
public class LoginDTO {
    private String username;
    private String password;

}
