package com.rmorgner.discorddatasupport.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {

  private String id;

  @NotBlank
  @Size(min = 3, max = 255)
  private String name;

  @NotBlank
  @Size(min = 3, max = 255)
  private String displayName;

}
