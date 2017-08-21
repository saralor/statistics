package statistics.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import statistics.dto.Statistics;
import statistics.service.StatisticsService;

import static org.springframework.http.HttpStatus.OK;

@Controller
public class StatisticsController {

    @Autowired
    private StatisticsService statisticsService;

    @RequestMapping("/statistics")
    @ResponseBody
    public ResponseEntity<Statistics> getTransactions() {
        return new ResponseEntity<>(statisticsService.getStatistics(), OK);
    }
}
