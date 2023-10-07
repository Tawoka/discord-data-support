package com.rmorgner.discorddatasupport.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class User {

  @Id
  private String id;

  private String name;
  private String displayName;

}
