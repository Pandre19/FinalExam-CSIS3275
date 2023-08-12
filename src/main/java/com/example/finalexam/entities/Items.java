package com.example.finalexam.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Items {
    private String Icode;

    private String Catcode;
    private String Idesc;
    private float Price;
}
