package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListOfPurchasesDto {
    private Long id;
    private Long productId;
    private Long numberOfProducts;
}
