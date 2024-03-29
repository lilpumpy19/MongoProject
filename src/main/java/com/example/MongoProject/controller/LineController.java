package com.example.MongoProject.controller;

import com.example.MongoProject.models.Line;
import com.example.MongoProject.service.LineService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/lines")
@AllArgsConstructor
//@Api(tags = "Lines", description = "Operations about lines")
@Tag(name = "Line")
public class LineController {

    private final LineService lineService;


    @GetMapping("/")
    @Operation(description = "Get all lines")
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
    @Operation(description = "Delete line")
    public String deleteLine(@RequestParam("id") @Parameter(description = "Person id") String id) {
        lineService.deleteLineById(id);
        return "redirect:/lines";
    }
    @PostMapping("/add")
    @Operation(
            description = "Add line with name and salary"
    )
    public String addLine(@RequestParam("name") @Parameter(description = "Person name") String name,
                          @RequestParam("salary") @Parameter(description = "Person salary") int salary) {
        Line line = new Line(name, salary);
        lineService.addLine(line);
        return "redirect:/lines";
    }

    @PostMapping("/update")
    @Operation(
            description = "Update line with id and name and salary"
    )
    public String updateLine(
            @RequestParam("id") @Parameter(description = "Person id") String id,
            @RequestParam("name") @Parameter (description = "Person name") String name,
            @RequestParam("salary") @Parameter (description = "Person salary") int salary) {
        Line line = lineService.findById(id);

        if (line != null) {
            line.setName(name);
            line.setSalary(salary);
            lineService.save(line);
        }

        return "redirect:/lines";
    }

}
