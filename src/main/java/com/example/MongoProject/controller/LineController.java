package com.example.MongoProject.controller;

import com.example.MongoProject.models.Line;
import com.example.MongoProject.service.LineService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/lines")
@AllArgsConstructor
public class LineController {

    private final LineService lineService;


    @GetMapping()
    @PreAuthorize("hasRole('GET_LINES')")
    public String getLines(Model model) {
        List<Line> lines = lineService.getLines();
        model.addAttribute("lines", lines);
        double averageSalary = lineService.getAverageSalary();
        double totalSalary = lineService.getSumSalaryReport();
        double maxSalary = lineService.getMaxSalaryReport();

        model.addAttribute("lines", lines);
        model.addAttribute("averageSalary", averageSalary);
        model.addAttribute("totalSalary", totalSalary);
        model.addAttribute("maxSalary", maxSalary);
        return "lines";
    }

    @PostMapping("/delete")
    @PreAuthorize("hasRole('DELETE_LINE')")
    public String deleteLine(@RequestParam("id") String id) {
        lineService.deleteLineById(id);
        return "redirect:/lines";
    }
    @PostMapping("/add")
    @PreAuthorize("hasRole('ADD_LINE')")
    public String addLine(@RequestParam("name") String name,
                          @RequestParam("salary") int salary) {
        Line line = new Line(name, salary);
        lineService.addLine(line);
        return "redirect:/lines";
    }

    @PostMapping("/update")
    @PreAuthorize("hasRole('UPDATE_LINE')")
    public String updateLine(@RequestParam("id") String id, @RequestParam("name") String name, @RequestParam("salary") int salary) {
        Line line = lineService.findById(id);

        if (line != null) {
            line.setName(name);
            line.setSalary(salary);
            lineService.save(line);
        }

        return "redirect:/lines";
    }

}
