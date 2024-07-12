package com.example.librarymanagement.dto.request.author;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorSaveRequest {

    private String authorName;
    private String authorBirthDate;
    private String authorCountry;
}
