package org.example.layered.controller;

import org.example.layered.dto.MemoRequestDto;
import org.example.layered.dto.MemoResponseDto;
import org.example.layered.service.MemoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController //@Controller+@ResponseBody
@RequestMapping("/memos")
public class MemoController {

    private final MemoService memoService;

    public MemoController(MemoService memoService) {
        this.memoService = memoService;
    }

    @PostMapping
    public ResponseEntity<MemoResponseDto> createMemo(@RequestBody MemoRequestDto dto) {


        return new ResponseEntity<>(memoService.saveMemo(dto), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<MemoResponseDto>> findAllMemos(){
        List<MemoResponseDto> memos = memoService.findAllMemos();
        return ResponseEntity.ok(memos);
    }
    @GetMapping("/{id}")
    public ResponseEntity<MemoResponseDto> findMemoById(@PathVariable Long id){

        return new ResponseEntity<>(memoService.findMemoById(id),HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<MemoResponseDto> updateMemo(
            @PathVariable Long id,
            @RequestBody MemoRequestDto dto
    ){

        return new ResponseEntity<>(memoService.updateMemo(id,dto.getTitle(),dto.getContents()), HttpStatus.OK);
    }
    @PatchMapping("/{id}")
    public ResponseEntity<MemoResponseDto> updateTitle(
            @PathVariable Long id,
            @RequestBody MemoRequestDto dto
    ){

        return new ResponseEntity<>(memoService.updateTitle(id, dto.getTitle(),dto.getContents()),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMemo(@PathVariable Long id){
        memoService.deleteMemo(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}