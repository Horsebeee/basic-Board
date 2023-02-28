package com.study.app.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@ToString(callSuper = true)
@DynamicInsert
public class Board extends AuditingFields {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer board_no;

    @ManyToOne(optional = false)
    @JoinColumn(name="writer")
    @Comment("작성자")
    private User user;

    @OneToMany(mappedBy = "board",cascade = CascadeType.ALL)
    @ToString.Exclude //순환 참조 issue 막기
    private final Set<BoardComment> boardComments = new LinkedHashSet<>();

    @Setter
    @Column(nullable = false)
    @Comment("게시글 제목")
    private String title;

    @Setter
    @Column(columnDefinition = "TEXT", nullable = false)
    @Comment("게시글 내용")
    private String content;

    @ColumnDefault("0")
    @Column(nullable = false)
    private Integer view_cnt;

    protected Board() {}

    private Board(User user,String title, String content, Integer view_cnt) {
        this.user = user;
        this.title = title;
        this.content = content;
        this.view_cnt = view_cnt;
    }

    private Board(User user,String title, String content, Integer view_cnt, Integer board_no) {
        this.user = user;
        this.title = title;
        this.content = content;
        this.view_cnt = view_cnt;
        this.board_no = board_no;
    }

    // 게시글 생성
    public static Board of(User user,String title, String content, Integer view_cnt) {
        return new Board(user, title, content, view_cnt);
    }

    // 게시글 수정
    public static Board of(User user,String title, String content, Integer view_cnt,Integer board_no) {
        return new Board(user, title, content, view_cnt,board_no);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Board board = (Board) o;
        return board_no.equals(board.board_no);
    }

    @Override
    public int hashCode() {
        return Objects.hash(board_no);
    }
}
