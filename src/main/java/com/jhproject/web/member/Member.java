package com.jhproject.web.member;

import lombok.*;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Component
@Lazy
@Data
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberNo;
    @Column(length = 200, nullable = false)
    private String id;
    @Column(length = 200, nullable = false)
    private String passwd;
    @Column(length = 200, nullable = false)
    private String name;
    @Column(length = 500, nullable = false)
    private String email;

    @Builder
    public Member(String id, String passwd, String name, String email) {
        this.id = id;
        this.passwd = passwd;
        this.name = name;
        this.email = email;
    }
}
