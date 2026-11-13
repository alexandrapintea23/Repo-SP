
package com.example.designpatternslab.repository;

import com.example.designpatternslab.model.Section;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SectionRepository extends JpaRepository<Section, Long> {
}
