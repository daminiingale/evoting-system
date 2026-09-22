package com.damini.evoting.controller;

import com.damini.evoting.service.ResultService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/results")
public class ResultController {

    private final ResultService resultService;

    public ResultController(ResultService resultService) {
        this.resultService = resultService;
    }

    @GetMapping
    public List<Map<String, Object>> getElectionResults() {
        return resultService.getElectionResults();
    }
}