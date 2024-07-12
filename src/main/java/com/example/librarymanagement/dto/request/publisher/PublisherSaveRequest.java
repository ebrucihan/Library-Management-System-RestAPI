package com.example.librarymanagement.dto.request.publisher;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublisherSaveRequest {
    private String publisherName;
    private String publisherEstablishmentYear;
    private String address;
}
