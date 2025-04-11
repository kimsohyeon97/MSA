package kr.co.sohyeon.controller;

import kr.co.sohyeon.service.MainService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@RestController
@RequestMapping("/redis")  // 공통 prefix
public class MainController {

    private final MainService mainService;

    // 1. String 값 저장 (POST)
    @PostMapping("/string")
    public void setValue(String key, String value) {
        mainService.setValue(key, value);
    }

    // 2. String 값 조회 (GET)
    @GetMapping("/string/{key}")
    public ResponseEntity<String> getValue(@PathVariable String key) {
        return ResponseEntity.ok(mainService.getValue(key));
    }


    // 3. 리스트 오른쪽 추가 (POST)
    @PostMapping("/list/right")
    public void addToListFromRight(@RequestParam String key, @RequestParam String value) {
        mainService.addToListFromRight(key, value);
    }


    // 4. 리스트 왼쪽 추가 (POST)
    @PostMapping("/list/left")
    public void addToListFromLeft(String key, String value) {
        mainService.addToListFromLeft(key, value);
    }

    // 5. 리스트 특정 인덱스 값 조회 (GET)
    @GetMapping("/list")
    public ResponseEntity<String> getFromList(String key, int index) {
        return ResponseEntity.ok(mainService.getFromList(key, index));
    }

    // 6. 리스트 범위 조회 (GET)
    @GetMapping("/list/range")
    public ResponseEntity<List<String>> getRangeFromList(String key, int start, int end) {
        return ResponseEntity.ok(mainService.getRangeFromList(key, start, end));
    }

    // 7. Set 값 추가 (POST)
    @PostMapping("/set")
    public void addToSet(String key,String[] values) {
        mainService.addToSet(key, values);
    }

    // 8. Set 전체 조회 (GET)
    @GetMapping("/set")
    public ResponseEntity<Set<String>> getFromSet(String key) {
        return ResponseEntity.ok(mainService.getFromSet(key));
    }

    // 9. Hash 값 추가 (POST)
    @PostMapping("/hash")
    public void addToHash(String key, String hashKey,String value) {
        mainService.addToHash(key, hashKey, value);
    }

    // 10. Hash 값 조회 (GET)
    @GetMapping("/hash")
    public ResponseEntity<String> getFromHash(String key, String hashKey) {
        return ResponseEntity.ok(mainService.getFromHash(key, hashKey));
    }
}
