package org.example.prac01.board;


import lombok.RequiredArgsConstructor;
import org.example.prac01.board.model.BoardDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/board")
@RestController
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @PostMapping("/reg")
    public ResponseEntity register(@RequestBody BoardDto.Reg dto) {
        boardService.register(dto);
        return ResponseEntity.ok("성공");
    }

}