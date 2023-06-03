package com.example.MongoProject.controller;

import com.example.MongoProject.models.Line;
import com.example.MongoProject.service.LineService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
    public String getLines(Model model) {
        List<Line> lines = lineService.getLines();
        model.addAttribute("lines", lines);
        return "lines";
    }

    @PostMapping("/delete")
    public String deleteLine(@RequestParam("id") String id) {
        lineService.deleteLineById(id);
        return "redirect:/lines";
    }
    @PostMapping("/add")
    public String addLine(@RequestParam("name") String name,
                          @RequestParam("salary") int salary) {
        Line line = new Line(name, salary);
        lineService.addLine(line);
        return "redirect:/lines";
    }

    @PostMapping("/update")
    public String updateLine(@RequestParam("id") String id,
                             @RequestParam("name") String name,
                             @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
                             @RequestParam("salary") int salary) {
        // Поиск линии по идентификатору
        Line line = lineService.findById(id);

        if (line != null) {
            // Обновление значений линии
            line.setName(name);
            line.setDate(date);
            line.setSalary(salary);

            // Сохранение изменений
            lineService.save(line);
        }

        // Перенаправление на страницу со списком линий
        return "redirect:/lines";
    }

}
