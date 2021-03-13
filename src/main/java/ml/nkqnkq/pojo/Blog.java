package ml.nkqnkq.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ToString
public class Blog {
    private Long id;
    private Long user_id;
    private String title;
    private String description;
    private String content;
    private LocalDateTime created;
    private int status;
}