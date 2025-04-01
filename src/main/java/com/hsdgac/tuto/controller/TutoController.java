package com.hsdgac.tuto.controller;

import com.hsdgac.tuto.dto.ItemDto;
import com.hsdgac.tuto.dto.ResponseDto;
import com.hsdgac.tuto.service.TutoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class TutoController {
    private final TutoService service;

    @Autowired
    public TutoController(TutoService service) {
        this.service = service;
    }

    @GetMapping("/dummy")
    public String dummy() {
        log.info("dummy log");
        return "{}";
    }

    @GetMapping("/dummy2")
    public String dummy2() {
        log.info("dummy2 log");

        return "dummy2";
    }

    @GetMapping("/member")
    public String getMember(@RequestParam("empNo") String empNo, @RequestParam("year") int year) {
        log.info("empNo: {}", empNo);
        log.info("year: {}", year);
        return "ok";
    }

    @GetMapping("/company/{id}")
    public String getCompany(@PathVariable("id") String id) {
        log.info("id: {}", id);
        return "ok";
    }

    @PostMapping("/item")
    public ResponseDto registerItem(@RequestBody ItemDto item) {
        log.info("item: {}", item);

        boolean succeeded = service.registerItem(item);

        ResponseDto resp = new ResponseDto();
        resp.setMessage(succeeded ? "ok" : "failed");
        return resp;
    }

    @GetMapping("/item")
    public ItemDto getItem(@RequestParam("id") String id) {
        return service.getItemById(id);
    }
}
