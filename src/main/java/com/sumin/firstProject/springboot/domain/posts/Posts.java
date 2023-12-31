package com.sumin.firstProject.springboot.domain.posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor  // public Posts() {} 와 같음, 기본 생성자
@Entity // Setter 메소드를 만들지 않아도 됨.
public class Posts extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment, MySQL 기준으로 bigInt
    private Long id;
    
    @Column(length = 500, nullable = false)
    private String title;
    
    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;
    
    private String author;
    
    @Builder    // 인자를 포함하는 생성자
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
