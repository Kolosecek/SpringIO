package sk.stuba.fei.asos.asos_project.student;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Document(collection = "students")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    private String id;

    @NotBlank(message="Please provide a name.")
    private String name;
    @NotBlank(message="Please provide a surname.")
    private String surname;

    @NotBlank(message="Please provide a subject.")
    private String subject;


    @NotNull(message="Please provide your age.")
    private Integer age;



}
