package org.example.prac01.board;


import lombok.RequiredArgsConstructor;
import org.example.prac01.board.model.Board;
import org.example.prac01.board.model.BoardDto;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;

    public void register(BoardDto.Reg dto) { boardRepository.save(dto.toEntity() );}
}
