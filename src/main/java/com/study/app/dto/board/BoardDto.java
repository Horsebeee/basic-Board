package com.study.app.dto.board;

import com.study.app.domain.Board;
import com.study.app.domain.User;
import com.study.app.dto.user.UserDto;

public record BoardDto(
        Integer board_no,
        String title,
        String content,
        UserDto writer,
        String created_date,
        String modified_date,
        Integer view_cnt
) {
    // entity -> dto 변경
    public static BoardDto from(Board entity){
        return new BoardDto(
                entity.getBoard_no(),
                entity.getTitle(),
                entity.getContent(),
                UserDto.from(entity.getUser()),
                entity.getCreatedDate(),
                entity.getModifiedDate(),
                entity.getView_cnt()
        );
    }

    // dto -> entity 변경
    public Board toCreateBoardEntity(User user) {
        return Board.of(
                user,
                title,
                content,
                view_cnt
        );
    }

    // dto -> entity 변경
    public Board toUpdateBoardEntity(User user) {
        return Board.of(
                user,
                title,
                content,
                view_cnt,
                board_no
        );
    }

}
