package com.study.app.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Comment;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Getter
@ToString(callSuper = true)
public class BoardComment extends AuditingFields {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer board_comment_no;

    @Setter
    @ManyToOne(optional = false)
    @JoinColumn(name="writer")
    private User user;

    @Setter
    @ManyToOne(optional = false)
    @JoinColumn(name = "board_no")
    private Board board;

    @Setter
    @Column(nullable = false)
    @Comment("댓글 내용")
    private String content;

    protected BoardComment() {}

    private BoardComment(User user, Board board, String content) {
        this.user = user;
        this.board = board;
        this.content = content;
    }

    public static BoardComment of(User user, Board board, String content) {
        return new BoardComment(user,board,content);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardComment that = (BoardComment) o;
        return board_comment_no.equals(that.board_comment_no);
    }

    @Override
    public int hashCode() {
        return Objects.hash(board_comment_no);
    }
}
