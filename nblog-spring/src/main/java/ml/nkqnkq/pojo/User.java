package ml.nkqnkq.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ToString
public class User {
    private Long id;
    @NotBlank(message = "昵称不能为空")
    private String username;
    private String avatar;
    @NotBlank(message = "邮箱不能为空")
    @Email(message = "邮箱格式不正确")
    private String email;
    private String password;
    private Integer status;
    private LocalDateTime created;
    private LocalDateTime last_login;
}
