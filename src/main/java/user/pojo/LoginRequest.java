package user.pojo;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class LoginRequest {

    private String account;

    private String password;
}
