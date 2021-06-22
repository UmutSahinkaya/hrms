package com.example.hrms.entities.concretes;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "curriculum_vitaes")
public class CurriculumViate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @JsonIgnoreProperties({"password"})
    @ManyToOne(targetEntity = Candidate.class)
    @JoinColumn(name = "candidate_id", referencedColumnName = "id", nullable = false)
    private Candidate candidate;

    @Column(name = "github_link")
    private String githubLink;

    @Column(name = "linkedin_link")
    private String linkedLink;

    @Column(name = "photo")
    private String photo;

    @Column(name = "description")
    private String description;

    @JsonIgnore
    @Column(name = "created_date")
    private LocalDate createdDate;

    @JsonIgnore
    @Column(name = "latest_update_date")
    private LocalDate updateDate;


    @Column(name = "is_active")
    private boolean isActive = true;




    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @OneToMany(mappedBy = "curriculumVitae")
    private List<Language> languages;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @OneToMany(mappedBy = "curriculumVitae")
    private List<Talent> talents;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @OneToMany(mappedBy = "curriculumVitae")
    private List<EduHistory> eduHistory;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @OneToMany(mappedBy = "curriculumVitae")
    private List<JobExperience> jobExperiences;


}