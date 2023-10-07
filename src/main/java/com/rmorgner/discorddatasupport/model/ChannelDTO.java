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
public class ChannelDTO {

  private String id;

  private String categoryId;

  @NotBlank
  @Size(min = 3, max = 255)
  private String name;

}
