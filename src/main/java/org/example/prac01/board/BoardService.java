package org.example.prac01.board;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.aspectj.apache.bcel.Repository;
import org.example.prac01.board.model.Board;
import org.example.prac01.board.model.BoardDto;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;

    public void register(BoardDto.Reg dto) { boardRepository.save(dto.toEntity() );}
    public BoardDto.Res read(Long idx) {
        Board board = boardRepository.findById(idx).orElseThrow(
                () -> new RuntimeException()
        );
        return BoardDto.Res.from(board);
    }

    public List<BoardDto.Res> list() {
        List<Board> boardList = boardRepository.findAll();
        return boardList.stream().map(BoardDto.Res::from).toList();
    }

    @Transactional
    public void update(Long idx, BoardDto.Reg dto) {
        Board board = boardRepository.findById(idx).orElseThrow(
                () -> new RuntimeException("수정할 게시글이 없습니다.")
        );
        board.update(dto.getTitle(), dto.getContents());
    }

    // 5. 삭제
    public void delete(Long idx) {
        boardRepository.deleteById(idx);
    }
}
