package com.example.demo.graduate;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class GraduateService {

  private final GraduateRepository graduateRepository;

  @Autowired
  public GraduateService(GraduateRepository graduateRepository) {
    this.graduateRepository = graduateRepository;
  }

  public List<Graduate> getGraduates() {
    return graduateRepository.findAll();
  }

  public void addNewGraduate(Graduate graduate) {
    Optional<Graduate> graduateByEmail = graduateRepository.findGraduateByEmail(graduate.getEmail());
    if (graduateByEmail.isPresent()) {
      throw new IllegalStateException("email taken");
    }
    graduateRepository.save(graduate);
  }

  public void deleteGraduate(Long id) {
    boolean exists = graduateRepository.existsById(id);
    if (!exists) {
      throw new IllegalStateException("graduate with id " + id + " does not exist");
    }
    else {
      graduateRepository.deleteById(id);
    }
  }

  @Transactional
  public void updateGraduate(Long id, String name, String email) {
    Graduate graduate = graduateRepository
        .findById(id)
        .orElseThrow(() -> new IllegalStateException(("graduate with id " + id + " does not exist")));

    if (name != null && name.length() > 0 && !Objects.equals(graduate.getName(), name)) {
      graduate.setName(name);
    }
    if (email != null && email.length() > 0 && !Objects.equals(graduate.getEmail(), email)) {
      graduate.setName(name);
    }

  }
}

