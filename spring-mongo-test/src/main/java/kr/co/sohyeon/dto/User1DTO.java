package kr.co.sohyeon.dto;

import kr.co.sohyeon.document.User1Document;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class User1DTO {

    @Id
    private String _id;
    private String uid;
    private String name;
    private int age;
    private String addr;

    public User1Document toDocument(){
        return User1Document.builder()
                .uid(uid)
                .name(name)
                .age(age)
                .addr(addr)
                .build();
    }
}
