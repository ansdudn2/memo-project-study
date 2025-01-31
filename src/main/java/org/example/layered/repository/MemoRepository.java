package org.example.layered.repository;

import org.example.layered.dto.MemoResponseDto;
import org.example.layered.entity.Memo;

import java.util.List;

public interface MemoRepository {

    List<MemoResponseDto> findAllMemos();

    Memo saveMemo(Memo memo);

    Memo findMemoById(Long id);

    void deleteMemo(Long id);
}
