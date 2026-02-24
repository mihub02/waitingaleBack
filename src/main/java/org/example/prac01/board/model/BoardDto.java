package org.example.prac01.board.model;

import lombok.*;

public class BoardDto {
    @Getter
    public static class Reg {
        private String title;
        private String contents;

        public Board toEntity() {
            return Board.builder()
                    .title(this.title)
                    .contents(this.contents)
                    .build();
        }
    }

}
