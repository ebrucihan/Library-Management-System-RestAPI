package com.example.librarymanagement.dto.response.book;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookResponse {

    private int id;
    private String bookName;
    private String bookPublicationYear;
    private int bookStock;
    private int authorId;
    private int publisherId;
    private List<Integer> categoryIds;
}
