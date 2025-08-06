package com.example.fisrtproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String title;
    @Column
    private String content;

    public Long getId() {
        return id;
    }

    public void patch(Article article) {
        if(article.title!=null)
            this.title = article.title;
        if(article.content!=null)
            this.content = article.content;
    }
}
