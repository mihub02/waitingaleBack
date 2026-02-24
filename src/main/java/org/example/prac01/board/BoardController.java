package org.example.prac01.board;


import lombok.RequiredArgsConstructor;
import org.aspectj.apache.bcel.Repository;
import org.example.prac01.board.model.Board;
import org.example.prac01.board.model.BoardDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(
        origins = "http://localhost:5173/",
        allowCredentials = "true"
)

@RequestMapping("/board")
@RestController
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    // 게시글 등록
    @PostMapping("/reg")
    public ResponseEntity register(@RequestBody BoardDto.Reg dto) {
        boardService.register(dto);
        return ResponseEntity.ok("성공");
    }

    // 게시글 목록 조회
    @GetMapping("/list")
    public ResponseEntity list() {
        List<BoardDto.Res> dto = boardService.list();
        return ResponseEntity.ok(dto);
    }

    // 게시글 상세 조회
    @GetMapping("/read/{idx}")
    public ResponseEntity read(@PathVariable Long idx) {
        BoardDto.Res dto = boardService.read(idx);
        return ResponseEntity.ok(dto);
    }


    // 게시글 수정
    @PutMapping("/update/{idx}")
    public ResponseEntity update(@PathVariable Long idx,@RequestBody BoardDto.Reg dto) {
        boardService.update(idx, dto);
        return ResponseEntity.ok(dto);
    }

}