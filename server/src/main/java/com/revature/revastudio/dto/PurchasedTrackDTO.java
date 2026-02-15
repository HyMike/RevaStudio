package com.revature.revastudio.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchasedTrackDTO {
    private String track;
    private String artist;
    private String albums;
}
