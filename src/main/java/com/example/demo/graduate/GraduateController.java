package com.example.demo.graduate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/graduate")
public class GraduateController {
  private final GraduateService graduateService;

  @Autowired
  public GraduateController(GraduateService graduateService) {
    this.graduateService = graduateService;
  }

  @GetMapping
  public List<Graduate> getGraduates() {
    return graduateService.getGraduates();
  }

  @PostMapping
  public void registerNewGraduate(@RequestBody Graduate graduate) {
    graduateService.addNewGraduate(graduate);
  }

  @PutMapping(path = "{graduateId}")
  public void updateGraduate(@PathVariable("graduateId") Long graduateId, @RequestParam(required = false) String name,
      @RequestParam(required = false) String email) {
    graduateService.updateGraduate(graduateId, name, email);
  }

  @DeleteMapping(path = "{graduateId}")
  public void deleteGraduate(@PathVariable("graduateId") Long id) {
    graduateService.deleteGraduate(id);
  }
}

